package nl.mprog.layouts;

/**
 * BoterKaasEieren super-class
 *
 * Provides the bare-bones needed for a game of TicTacToe, but does not handle user interaction or
 * visualisation of the board.
 *
 * Tic-Tac-Toe is a classic game where two players fill a grid of 3*3 one tile at a time.
 * The game is won if one player manages to get 3 consecutive vertical, horizontal, or diagonal
 * tiles filled. Always go for one of the corners.
 *
 * @author Joost Bremmer
 * @version 1.0
 *
 */
public class BoterKaasEieren {

    public static final int DEFAULT_BOARDSIZE = 3;
    private boolean turnX  = true;
    public int turn = 1;
    public int boardSize;
    private char board[][];
    public int wins[]= {0,0};


    /**
     * Default Constructor, uses boardsize of DEFAULT_BOARDSIZE and initializes every tile to 0;
     * All tiles on the board will be initiated as having the char NUL.
     * That is the ASCII code, not the digit 0.
     * @see #board
     * @see #boardSize
     * @see #DEFAULT_BOARDSIZE
     */
    public BoterKaasEieren() {
        board = new char[DEFAULT_BOARDSIZE][DEFAULT_BOARDSIZE];
        for(int i=0;i<DEFAULT_BOARDSIZE;i++) {
            for(int j=0;j<DEFAULT_BOARDSIZE;j++){
                board[i][j] = 0;
            }
        }
        this.boardSize = DEFAULT_BOARDSIZE;
    }

    /**
     * Constructor which allows a custom size for the board.
     * All tiles of the board will be initiated to the ASCII character NUL.
     * @see #board
     * @see #boardSize
     * @param boardSize custom dimension for the board.
     */
    public BoterKaasEieren(int boardSize) {
        board = new char[boardSize][boardSize];
        for(int i=0;i<boardSize;i++) {
            for(int j=0;j<boardSize;j++){
                board[i][j] = 0;
            }
        }

        this.boardSize = boardSize;

    }

    /**
     * Returns the current player, will either be 'X' or 'O'
     */
    public char getPlayer() {return turnX ? 'X' : 'O';}

    /**
     * Returns the current turn number starting at 1;
     *         should never be more than boardSize*boardSize
     * @see #boardSize
     */
    public int getTurn(){return turn;}

    /**
     * Changes whose turn it is
     */
    public void switchTurn() {
        turnX = !turnX;
        turn++;
    }

    /**
     * Sets the value of a certain tile
     * @param row    int the row number (x) of the desired tile, starting at 0
     * @param column int of the column number (y) of the disered tile, starting at 0
     * @return       char of the player who marked the tile, will be either 'X' or 'O'
     * @see #board
     */
    public char setTile(int row, int column) {
        board[row][column] = getPlayer();
        return  board[row][column];
    }

    /**
     * Get the value of a tile
     * @param row    int of the row number (x) of the tile you're requesting, starting at 0
     * @param column int the column number (y) of the tile you're requesting, starting at 0
     * @return       char of the value of tile x-y, can be either 'X', 'O', or NUL
     */
    public char getTile(int row, int column){return board[row][column];}

    /**
     * Check if the player placing a certain tile has won the game.
     * @param row    int of the row number of the specified tile, starting at 0. ending at
     *               {@link #boardSize boardsize}-1
     * @param column int of the column number of the specified tile, starting at 0, ending at
     *               {@link #boardSize boardsize}-1
     * @return       boolean on whether the current player has won.
     * @see          #getPlayer()
     * @see          #checkTile(char, int, int)
     * @see          #addWin(char)
     * @see          #wins
     */
    public boolean hasWon(int row, int column){

        /**
         * hasWon.count[] is an array containing counters.
         * count[0] = row counter
         * count[1] = column counter
         * count[2] = diagonal counter
         * count[3] = diagonal backwards counter
         */
        int count[] = {0,0,0,0};
        char player = getPlayer();
        boolean won = false;

        for(int i=0;i<board.length;i++) {
            //Check for row win
            if(checkTile(player, row, i)) {count[0]++;}
            //Check for column win
            if(checkTile(player, i, column)){count[1]++;}
            //Check for diagonal win
            if(checkTile(player, i,i)){count[2]++;}
            //Check for diagnoal backwards win
            if(checkTile(player, i, ((board.length-1)-i))){count[3]++;}

        }
        //count owned tiles, if they're a full row, column or diagonal, they must equal boardSize
        for(int i=0;i<count.length;i++) {
            if (count[i] == board.length) {
                won = true;
                addWin(player);
            }

         }


        return won;
    }

    /**
     * Check if a certain tile is owned by a player
     * @param player char of the player you're checking against. Must be either 'X' or 'O'
     * @param row    int of the row number of the specified tile. Starts at 0, ends at boardSize-1
     * @param column int of the column number of the specified tile. Starts at 0,
     *               ends at boardSize-1
     * @return       boolean of whether the value of the specified tile and the player match.
     */
    public boolean checkTile(char player, int row, int column){
        return (player == getTile(row, column));
    }

    /**
     * Resets the board by setting every tile back to NUL, and the turn timer back to 1.
     */
    public void resetBoard() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++) {board[i][j] = 0;}
        }
        turn = 1;
    }

    /**
     * Increased the win count of a specified player by 1.
     * @param player char of the player who has won the previous round. Must be either 'X' or 'O'
     */
    public void addWin(char player){
        switch (player) {
            case 'X': wins[0]++;
                      break;

            case 'O': wins[1]++;
                      break;

            default: break;
        }
    }

    /**
     * Returns a String of the boardsize, amount of rounds, and amount of wins per player.
     */
    @Override
    public String toString() {
        return "Playing with a board of " + boardSize + "*" + boardSize+ ".\n" +
                "We've played " + (wins[0] + wins[1]) + "Rounds. \n" +
                "X won " + wins[0] + "\t|\t" + "O won" + wins[1];

    }

}

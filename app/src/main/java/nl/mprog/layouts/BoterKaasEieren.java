package nl.mprog.layouts;


/**
 * BoterKaasEieren class
 *
 *
 */
public class BoterKaasEieren {

    public static final int DEFAULT_BOARDSIZE = 3;
    private boolean turnX  = true;
    public char board[][];

    /**
     * Default Constructor, uses boardsize of DEFAULT_BOARDSIZE and initializes every tile to 0;
     */
    public BoterKaasEieren() {
        board = new char[DEFAULT_BOARDSIZE][DEFAULT_BOARDSIZE];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                board[i][j] = 0;
            }
        }
    }

    public BoterKaasEieren(int boardSize) {
        board = new char[boardSize][boardSize];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                board[i][j] = 0;
            }
        }

    }

    public boolean isTurnX() {
        return turnX;
    }

    public void switchTurn() {
        turnX = !turnX;
    }

    public char setTile(int row, int column) {
        board[row][column] = isTurnX() ? 'X' : 'O';
        return  isTurnX() ? 'x' : 'o';
    }

    public char[][] getBoard(){return board;}

    public char getTile(int row, int column){return board[row][column];}

}

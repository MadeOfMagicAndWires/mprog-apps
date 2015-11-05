package nl.mprog.layouts;

/**
 * BoterKaasEieren class
 *
 *
 */
public class BoterKaasEieren {
    private boolean turnX  = true;
    private char board[][] = new char[3][3];

    public BoterKaasEieren() {}

    public boolean isTurnX() {
        return turnX;
    }

    public void switchTurn() {
        turnX = !turnX;
    }

    public void setField(int row, int column) {
        if(isTurnX()) {board[row][column] = 'X';}
        else {board[row][column] = 'O';}
    }

    public char[][] getBoard(){return board;}

}

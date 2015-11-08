package nl.mprog.layouts;


import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;


public class BoterKaasEierenAndroid extends BoterKaasEieren {

    /** Was Trying to be FANCY, crashes app somehow. Can't find the resource
    //@Override
    public char setTile(int row, int column) {

        String x = Resources.getSystem().getString(R.string.boter);
        String o = Resources.getSystem().getString(R.string.kaas);

        char turn = isTurnX() ? x.charAt(0) : o.charAt(0);
        board[row][column] = turn;
        return turn;
    }

    **/

    public void drawBoard(Context context, android.support.v7.widget.GridLayout boardGrid,
                          int boardSize)
    {

        for (int i=0;i< boardSize;i++) {

            for (int j = 0; j < boardSize; j++) {
                Button gridField = (Button) LayoutInflater.from(context)
                        .inflate(R.layout.grid_field, null);
                gridField.setTag(i + "-" + j);

                if (getTile(i,j) == 0) {
                    gridField.setText(R.string.space);
                }

                boardGrid.addView(gridField);
            }
        }

        for(int i=0; i<boardGrid.getChildCount(); i++) {
            View boardTile = boardGrid.getChildAt(i);
            Log.v("child at " + i + ":", String.valueOf(boardTile.getTag()));
            android.support.v7.widget.GridLayout.MarginLayoutParams params =
                    (android.support.v7.widget.GridLayout.MarginLayoutParams)
                            boardTile.getLayoutParams();
            params.setMargins(4,4,4,4);
        }
    }


    /**
     * plays a turn by marking a tile on the board with either 'X' or 'O'
     * @param tile Button, contains the tile's position on the board as a tag
     *             with the format of row-column, starting from 0
     *             For example: 2-0 would be the bottom-left tile on a 3 by 3 board.
     */
    public char playTurn(Button tile) {
        int row = Character.getNumericValue(String.valueOf(tile.getTag()).charAt(0));
        int column = Character.getNumericValue(String.valueOf(tile.getTag()).charAt(2));

        char turn = setTile(row, column);

        Log.v("Set tile " + row + '-' + column + "to: ", String.valueOf(turn));
        Log.v("double check:", String.valueOf(getTile(row,column)));

        return turn;

    }
}

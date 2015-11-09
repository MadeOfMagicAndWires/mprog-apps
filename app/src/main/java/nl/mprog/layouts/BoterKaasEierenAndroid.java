package nl.mprog.layouts;


import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;



/**
 * sub-class of {@link BoterKaasEieren}
 * Handles the visualisation and user-interaction for Android.
 *
 * @author Joost Bremmer
 * @version 1.0
 */
public class BoterKaasEierenAndroid extends BoterKaasEieren {

    /* Was Trying to be FANCY, crashes app somehow. Can't find the resource
    //@Override
    public char setTile(int row, int column) {

        String x = Resources.getSystem().getString(R.string.boter);
        String o = Resources.getSystem().getString(R.string.kaas);

        char turn = getPlayer();
        board[row][column] = turn;
        return turn;
    } */


    /**
     * Draws a representation of the {@link #board board} to the screen using a GridLayout and a Button
     * view. Also sets a tag to each (Button) tile containing it's position on the board.
     *
     * @param context   The current {@link Context context} of your
     *                              {@link android.app.Activity activity}.
     * @param boardGrid a {@link GridLayout grid} in which to draw the board.
     * @see Context
     * @see android.support.v7.widget.GridLayout
     * @see Button
     */
    public void drawBoard(Context context, android.support.v7.widget.GridLayout boardGrid)
    {

        boardGrid.removeAllViews();
        boardGrid.setColumnCount(boardSize);
        boardGrid.setRowCount(boardSize);

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
            android.support.v7.widget.GridLayout.MarginLayoutParams params =
                    (android.support.v7.widget.GridLayout.MarginLayoutParams)
                            boardTile.getLayoutParams();
            params.setMargins(4,4,4,4);
        }
    }


    /**
     * Read a views position from it's tag.
     *
     * @param tile View; Must have a tag containing the tile's position of the board
     *                   in the format of 'row'-'column'. For example, '0-2' is the top center.
     * @return     int[]; position as an array, contains the row as the first number,
     *                                                   column as the second number.
     */
    public int[] readTile(View tile) {

        return (new int[]{Character.getNumericValue(String.valueOf(tile.getTag()).charAt(0)),
                          Character.getNumericValue(String.valueOf(tile.getTag()).charAt(2))});
    }


    /**
     * plays a turn by marking a tile on the board with either 'X' or 'O'
     * @param tile Button, contains the tile's position on the board as a tag
     *             with the format of row-column, starting from 0
     *             For example: 2-0 would be the bottom-left tile on a 3 by 3 board.
     */
    public char playTurn(Button tile) {
        int position[] =readTile(tile);

        char turn = setTile(position[0], position[1]);

        Log.v("Set tile " + position[0] + '-' + position[1] + " to", String.valueOf(turn));
        //Log.v("double check", String.valueOf(getTile(position[0],position[1])));

        return turn;

    }

    /**
     * Shows a message on who has won the current round, and what the scores are.
     * @param view View from which to get the parent from, to which the message is drawn.
     * @see android.support.design.widget.Snackbar
     */
    public void printScore(View view) {
        Snackbar.make(view, String.valueOf(getPlayer()) + " Wins!\n" +
                "X has " + wins[0] + " wins" + "\t|\t" + "O has " + wins[1] + " wins",
                Snackbar.LENGTH_SHORT).show();
    }
}

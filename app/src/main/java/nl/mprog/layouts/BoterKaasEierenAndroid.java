package nl.mprog.layouts;


import android.content.Context;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class BoterKaasEierenAndroid extends BoterKaasEieren {


    public void drawBoard(Context context, android.support.v7.widget.GridLayout boardGrid, int boardSize) {

        for (int i=0;i< boardSize;i++) {
            Log.v("row", String.valueOf(i));

            for (int j = 0; j < boardSize; j++) {
                View gridField = LayoutInflater.from(context).inflate(R.layout.grid_field, null);
                gridField.setTag(i + "-" + j);
                if (i == 2) {
                    int paddingRight = gridField.getPaddingRight();
                    gridField.setPadding(0, 0, paddingRight, 0);
                }

                if (j == 2) {
                    int paddingBottom = gridField.getPaddingBottom();
                    gridField.setPadding(0, 0, 0, paddingBottom);
                }

                boardGrid.addView(gridField);
            }
        }
    }

}

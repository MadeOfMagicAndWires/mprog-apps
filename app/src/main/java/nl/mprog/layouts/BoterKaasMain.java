package nl.mprog.layouts;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


/**
 * Main Activty for a Tic-Tac-Toe Game
 * @see BoterKaasEierenAndroid
 * @see BoterKaasEieren
 * @see android.app.Activity
 *
 * @author Joost Bremmer
 * @version 1.0
 *
 */

public class BoterKaasMain extends AppCompatActivity {

    android.support.v7.widget.GridLayout boterkaas;
    BoterKaasEierenAndroid game = new BoterKaasEierenAndroid();

    /**
     * draws MainActivity on creation, and also initiates the board.
     * @param savedInstanceState Everything saved from previous instance, if any.
     * @see AppCompatActivity
     * @see Bundle
     * @see BoterKaasEierenAndroid#drawBoard(Context, GridLayout)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        boterkaas = (android.support.v7.widget.GridLayout) findViewById(R.id.boterkaas);
        Log.v("test", String.valueOf(boterkaas));


        game.drawBoard(this, boterkaas);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * OnClick Event for the tiles of the board
     *
     * <p>
     * Handles setting clicked tile to the correct value ('X' or 'O', depending on whose turn it is)
     * Then it checks if anyone has won, if so it shows an appropriate message and resets the board
     * or goes to the next turn.
     * </p>
     * @param view clicked view, added automatically.
     *
     * @see BoterKaasEierenAndroid#playTurn(Button)
     * @see BoterKaasEierenAndroid#readTile(View)
     * @see BoterKaasEierenAndroid#printScore(View)
     * @see BoterKaasEierenAndroid#resetBoard()
     * @see BoterKaasEierenAndroid#drawBoard(Context, GridLayout)
     * @see BoterKaasEieren#switchTurn()
     */
    public void playTurn(View view) {
        Log.v("turn", String.valueOf(game.getTurn()));

        boterkaas = (android.support.v7.widget.GridLayout) findViewById(R.id.boterkaas);
        Button tile = (Button) boterkaas.findViewWithTag(view.getTag());

        char result = game.playTurn(tile);
        tile.setText(String.valueOf(result));
        tile.setEnabled(false);

        int position[] = game.readTile(view);

        if(game.hasWon(position[0],position[1])) {
            game.printScore(view);
            game.resetBoard();
            game.drawBoard(view.getContext(),boterkaas);

        }

        else if (game.getTurn() == (game.boardSize*game.boardSize)) {
            Snackbar.make(view, "A tie! Everybody loses!", Snackbar.LENGTH_SHORT).show();
            game.resetBoard();
            game.drawBoard(view.getContext(), boterkaas);
        } else {game.switchTurn();}

    }
}
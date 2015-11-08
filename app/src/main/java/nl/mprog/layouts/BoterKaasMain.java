package nl.mprog.layouts;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BoterKaasMain extends AppCompatActivity {

    android.support.v7.widget.GridLayout boterkaas;
    BoterKaasEierenAndroid game = new BoterKaasEierenAndroid();

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


        game.drawBoard(this, boterkaas, BoterKaasEieren.DEFAULT_BOARDSIZE);


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

    public void playTurn(View view) {
        Log.v("buttan", String.valueOf(view.getTag()));

        boterkaas = (android.support.v7.widget.GridLayout) findViewById(R.id.boterkaas);
        Button tile = (Button) boterkaas.findViewWithTag(view.getTag());

        char result = game.playTurn(tile);
        tile.setText(String.valueOf(result));
        Log.v("triple check:", String.valueOf(tile.getText()));

        game.switchTurn();

    }
}
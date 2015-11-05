package nl.mprog.layouts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BoterKaasMain extends AppCompatActivity {

    android.support.v7.widget.GridLayout boterkaas;

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

        for (int i=0;i<3;i++) {

            Log.v("row", String.valueOf(i));

            for (int j=0;j<3;j++) {
                View gridField = LayoutInflater.from(this).inflate(R.layout.grid_field, null);
                gridField.setTag(i+"-"+j);
                if (i==2) {
                    int paddingRight  = gridField.getPaddingRight();
                    gridField.setPadding(0,0,paddingRight,0);
                }

                if (j==2) {
                    int paddingBottom = gridField.getPaddingBottom();
                    gridField.setPadding(0, 0, 0, paddingBottom);
                }

                boterkaas.addView(gridField);
            }




        }

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
}
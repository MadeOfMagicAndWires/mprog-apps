package com.toostinc.primegame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button answerYes;
    private Button answerNo;
    private TextView primeNumber;
    private TextView score;
    private TextView turn;


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

        answerYes = (Button) findViewById(R.id.answerYes);
        answerNo  = (Button) findViewById(R.id.answerNo);
        primeNumber = (TextView) findViewById(R.id.primeNumber);
        score = (TextView) findViewById(R.id.score);
        turn = (TextView) findViewById(R.id.turn);

        final PrimeGameAndroid me = new PrimeGameAndroid();
        me.nextTurn(primeNumber, score, turn);

        View.OnClickListener checkAnswerEvent = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean answer = false;

                if( view == answerYes)
                    answer = true;

                Log.v("answer", String.valueOf(answer));
                boolean correct = me.checkAnswer(answer);
                Snackbar.make(view, "Your answer was " + String.valueOf(correct), Snackbar.LENGTH_SHORT).show();
                me.nextTurn(primeNumber, score, turn);
            }
        };

        answerYes.setOnClickListener(checkAnswerEvent);
        answerNo.setOnClickListener(checkAnswerEvent);

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


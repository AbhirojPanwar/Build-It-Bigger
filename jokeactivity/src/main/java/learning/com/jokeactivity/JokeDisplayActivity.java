package learning.com.jokeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import Data.DataStore;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String joke=getIntent().getExtras().getString(DataStore.KEY);
        setContentView(R.layout.activity_joke_display);
        TextView textView=(TextView) findViewById(R.id.joketext);
        textView.setText(joke);

    }
}

package brendenbernal.anagram;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class viewResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

        String name = getIntent().getStringExtra("name");
        String score = getIntent().getStringExtra("score");

        TextView yourScore = (TextView) findViewById(R.id.yourScore);
        TextView yourName = (TextView) findViewById(R.id.yourName);

        yourName.setText(name + ",");
        yourScore.setText(score + " points.");

        SharedPreferences sharedPref = getSharedPreferences("HIGH_SCORES", Context.MODE_PRIVATE);
        Set<String> scores = sharedPref.getStringSet("scores", new HashSet<String>());
        SharedPreferences.Editor editor = sharedPref.edit();

        int thisScore = Integer.parseInt(score);
        score = String.format("%03d", thisScore);
        scores.add(score + " --- " + name);

        editor.putStringSet("scores", scores);
        editor.commit();

        onClick();
    }

    public void onClick() {
        Button buttonResultsExit = (Button) findViewById(R.id.buttonResultsExit);
        Button buttonResultsHighScores = (Button) findViewById(R.id.buttonResultsHighScores);

        buttonResultsExit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        buttonResultsHighScores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(getApplicationContext(), highScores.class));
            }
        });
    }
}

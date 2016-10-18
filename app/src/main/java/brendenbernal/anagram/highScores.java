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
import java.util.Arrays;


public class highScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        loadScores();

        onClick();
    }

    public void onClick() {
        Button buttonBackHighScores = (Button) findViewById(R.id.buttonBackHighScores);

        buttonBackHighScores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    public void loadScores() {
        SharedPreferences sharedPref = getSharedPreferences("HIGH_SCORES", Context.MODE_PRIVATE);
        Set<String> scores = sharedPref.getStringSet("scores", new HashSet<String>());
        String[] scoresArray = scores.toArray(new String[0]);
        Arrays.sort(scoresArray);

        TextView score1 = (TextView) findViewById(R.id.score1);
        TextView score2 = (TextView) findViewById(R.id.score2);
        TextView score3 = (TextView) findViewById(R.id.score3);
        TextView score4 = (TextView) findViewById(R.id.score4);
        TextView score5 = (TextView) findViewById(R.id.score5);

        TextView[] toIterate = {score1, score2, score3, score4, score5};
        int i = scoresArray.length;
        int j = 1;
        for (TextView score : toIterate) {
            try {
                score.setText((j++) + ". " + scoresArray[--i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                break;
            }
        }
    }
}

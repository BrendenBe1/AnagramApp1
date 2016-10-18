package brendenbernal.anagram;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
//        TreeSet<String> scores = new TreeSet<>();
//        SharedPreferences.Editor editor = sharedPref.edit();
//        editor.putStringSet("scores", scores);
//        editor.commit();

        onClick();
    }

    public void onClick()
        {
        Button buttonAbout = (Button) findViewById(R.id.buttonAbout);
        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        Button buttonHighScores = (Button) findViewById(R.id.buttonHighScore);
        final EditText enterName = (EditText) findViewById(R.id.enterName);

        buttonAbout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(getApplicationContext(), aboutPage.class));
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                Intent playIntent = new Intent(getApplicationContext(), selectDifficulty.class);
                playIntent.putExtra("name", enterName.getText().toString());
                startActivity(playIntent);
            }
        });

        buttonHighScores.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(getApplicationContext(), highScores.class));
            }
        });
    }
}

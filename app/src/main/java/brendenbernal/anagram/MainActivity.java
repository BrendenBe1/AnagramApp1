package brendenbernal.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClick();
    }

    public void onClick()
        {
        Button buttonAbout = (Button) findViewById(R.id.buttonAbout);
        Button buttonPlay = (Button) findViewById(R.id.buttonPlay);
        Button buttonHighScores = (Button) findViewById(R.id.buttonHighScore);

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
                startActivity(new Intent(getApplicationContext(), selectDifficulty.class));
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

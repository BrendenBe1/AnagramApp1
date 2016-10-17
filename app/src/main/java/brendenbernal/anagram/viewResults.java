package brendenbernal.anagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class viewResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_results);

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

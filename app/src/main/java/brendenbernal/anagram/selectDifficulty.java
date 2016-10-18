package brendenbernal.anagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.DynamicLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class selectDifficulty extends AppCompatActivity {

    private Spinner spinner;
    private static final String[]paths = {"Easy", "Intermediate", "Advanced"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_difficulty);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        onClick();

    }

    public void onClick()
    {
        final Spinner dropdown = (Spinner)findViewById(R.id.spinnerDifficulty);
        String[] items = new String[]{"Easy", "Intermediate", "Hard"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        final Intent intent = new Intent(getApplicationContext(), playGame.class);


//        int spinnerPos = dropdown.getSelectedItemPosition();
//        Log.d("spinner position", String.valueOf(spinnerPos));
//
//        String spinnerValue = dropdown.getSelectedItem().toString();
//        Log.d("spinner value",spinnerValue);


        Button buttonBackSelect = (Button) findViewById(R.id.buttonBackSelect);
        Button buttonPlaySelect = (Button) findViewById(R.id.buttonPlaySelect);

        buttonBackSelect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                Object item = parent.getItemAtPosition(pos);
//                int spinnerPos = dropdown.getSelectedItemPosition();
//                Log.d("spinner position", String.valueOf(spinnerPos));
                // get value of dropdown menu
                String spinnerValue = dropdown.getSelectedItem().toString();
                intent.putExtra("data", spinnerValue);
                //Log.d("spinner value",spinnerValue);

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        buttonPlaySelect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                intent.putExtra("name", getIntent().getStringExtra("name"));
                startActivity(intent);
            }
        });
    }

}

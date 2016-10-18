package brendenbernal.anagram;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static brendenbernal.anagram.R.id.yourName;
import static brendenbernal.anagram.R.id.yourScore;
import static brendenbernal.anagram.R.id.time;


public class playGame extends AppCompatActivity {

    int timeToPlay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Intent difficultyActivity = getIntent();
        String difficultyDecision = difficultyActivity.getStringExtra("data");
        Log.d("spinner play game", difficultyDecision);


        String[] letterArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        Random ran = new Random();
        int randomInt;
        //Log.d("random int", String.valueOf(randomInt));

        String[] buttonValue = {"a", "b", "c", "d", "e", "f", "g", "h"};

        int i = 0;
        while( i < 8)
        {
            randomInt = ran.nextInt(25);
            Log.d("random int", String.valueOf(randomInt));
            String newButtonValue = letterArray[randomInt];
            Log.d("new character", newButtonValue);
            buttonValue[i] = newButtonValue;
            i++;
        }

        Log.d("button value", String.valueOf(buttonValue));

        String[] wordList = createArray();
        onClick(wordList, buttonValue, difficultyDecision);
    }


    public String[] createArray()
    {
        String[] wordArray = new String[0];
        try
        {
            InputStream is = getAssets().open("dictionary.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            String text = new String(buffer);
            wordArray = text.split("\\s+");
            is.close();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        return wordArray;

    }


    public void onClick(String[] wordArray, String[] buttonValue, String difficulty)
    {

        final String[] dictionaryArray = wordArray;
        final String[] buttonNames = buttonValue;


        final EditText editTextGameInput = (EditText) findViewById(R.id.editTextGameInput);
        final TextView textViewScore = (TextView) findViewById(R.id.textViewScore);
        Button buttonBackSelect = (Button) findViewById(R.id.buttonExit);
        Button buttonGameEnter = (Button) findViewById(R.id.buttonGameEnter);
        Button buttonGameBackspace = (Button) findViewById(R.id.buttonGameBackspace);


        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.button7);
        final Button button8 = (Button) findViewById(R.id.button8);

        final ProgressBar progressBar;
        CountDownTimer timer;

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setProgress(timeToPlay);

        button1.setText(buttonNames[0]);
        button2.setText(buttonNames[1]);
        button3.setText(buttonNames[2]);
        button4.setText(buttonNames[3]);
        button5.setText(buttonNames[4]);
        button6.setText(buttonNames[5]);
        button7.setText(buttonNames[6]);
        button8.setText(buttonNames[7]);

        int maxTime = 0;
        // set progress bar max based on spinner
        if(difficulty.equals("Easy"))
        {
            progressBar.setMax(30);
            maxTime = 30000;
        }
        else if(difficulty.equals("Intermediate"))
        {
            progressBar.setMax(20);
            maxTime = 20000;
        }
        else
        {
            progressBar.setMax(10);
            maxTime = 10000;
        }



        timer = new CountDownTimer(maxTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ timeToPlay + millisUntilFinished);
                timeToPlay++;
                progressBar.setProgress(timeToPlay);
            }

            @Override
            public void onFinish() {
                timeToPlay++;
                progressBar.setProgress(timeToPlay);

                Intent intent = new Intent(getApplicationContext(), viewResults.class);
                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("score", textViewScore.getText().toString());
                startActivity(intent);

            }
        };
        timer.start();

        buttonBackSelect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[0]);
                button1.setAlpha(.5f);
                button1.setClickable(false);
            }
        });

        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[1]);
                button2.setAlpha(.5f);
                button2.setClickable(false);
            }
        });

        button3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[2]);
                button3.setAlpha(.5f);
                button3.setClickable(false);
            }
        });

        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[3]);
                button4.setAlpha(.5f);
                button4.setClickable(false);
            }
        });

        button5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[4]);
                button5.setAlpha(.5f);
                button5.setClickable(false);
            }
        });

        button6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[5]);
                button6.setAlpha(.5f);
                button6.setClickable(false);
            }
        });

        button7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[6]);
                button7.setAlpha(.5f);
                button7.setClickable(false);
            }
        });

        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                editTextGameInput.append(buttonNames[7]);
                button8.setAlpha(.5f);
                button8.setClickable(false);
            }
        });

        buttonGameBackspace.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                // reset input box to empty
                editTextGameInput.setText("");

                // reset buttons to original unpushed state
                button1.setAlpha(1f);
                button1.setClickable(true);
                button2.setAlpha(1f);
                button2.setClickable(true);
                button3.setAlpha(1f);
                button3.setClickable(true);
                button4.setAlpha(1f);
                button4.setClickable(true);
                button5.setAlpha(1f);
                button5.setClickable(true);
                button6.setAlpha(1f);
                button6.setClickable(true);
                button7.setAlpha(1f);
                button7.setClickable(true);
                button8.setAlpha(1f);
                button8.setClickable(true);
            }
        });

        buttonGameEnter.setOnClickListener(new View.OnClickListener()
        {
            // create array list to keep track of used words
            ArrayList<String> usedWords = new ArrayList<>();

            @Override
            public void onClick (View v)
            {

                // get word
                String inputWord = editTextGameInput.getText().toString();

                // check against dictionary to see if its a real word
                if(Arrays.asList(dictionaryArray).contains(inputWord))
                {
                    // check if already used the word
                    if(usedWords.contains(String.valueOf(editTextGameInput.getText())))
                    {
                        int j = 20;
                    }
                    else
                    {
                        // get length for points
                        int scoreCalculation = editTextGameInput.length();
                        Log.d("length", String.valueOf(scoreCalculation));

                        // get current score
                        String currentScore = textViewScore.getText().toString();
                        Log.d("String current score", currentScore);

                        // convert to int
                        int Score = Integer.parseInt(currentScore);
                        Log.d("int current score", String.valueOf(Score));

                        // add length to old score to get new score
                        int newScore = scoreCalculation + Score;
                        Log.d("int new score", String.valueOf(newScore));

                        // set new score
                        textViewScore.setText(String.valueOf(newScore));

                        // append word to array list
                        usedWords.add(String.valueOf(editTextGameInput.getText()));
                        Log.d("used word array", String.valueOf(usedWords));
                    }

                }
                else {
                    int i = 15;
                }

                // reset input box to empty
                editTextGameInput.setText("");

                // reset buttons to original unpushed state
                button1.setAlpha(1f);
                button1.setClickable(true);
                button2.setAlpha(1f);
                button2.setClickable(true);
                button3.setAlpha(1f);
                button3.setClickable(true);
                button4.setAlpha(1f);
                button4.setClickable(true);
                button5.setAlpha(1f);
                button5.setClickable(true);
                button6.setAlpha(1f);
                button6.setClickable(true);
                button7.setAlpha(1f);
                button7.setClickable(true);
                button8.setAlpha(1f);
                button8.setClickable(true);


            }
        });
    }

}

package com.example.justynagolawska.quizappiteration2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Question1Activity extends AppCompatActivity {

    SharedPreferences mypref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        final EditText answerQ1 = (EditText) findViewById(R.id.answer_robots);

        mypref = PreferenceManager.getDefaultSharedPreferences(this);

//        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
//        preferences.getString("Name", "Justyna");

        ActionBar actionbar = getSupportActionBar();

        //Applies the custom action bar style
        getSupportActionBar().setDisplayOptions(actionbar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        // Find the View that shows the next TextView
        TextView nextQuestion = (TextView) findViewById(R.id.next);

        // Set a click listener on that View. When The "next" is clicked the Question2Activity is launched
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {
                //Getting the answer to question 1
                String answer = answerQ1.getText().toString();

                //Calculate Question 1 score
                int resultQ1 = calculateResultQ1(answer);

                Intent question2Intent = new Intent(Question1Activity.this, Question2Activity.class);
                question2Intent.putExtra("q1result", resultQ1);
                Log.v("Question1Activity.this", "q1result");
                startActivity(question2Intent);
            }
        });

        // Find the View that shows the next TextView
        TextView previousQuestion = (TextView) findViewById(R.id.previous);

        // Set a click listener on that View
        previousQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {
                Intent question1Intent = new Intent(Question1Activity.this, MainActivity.class);
                startActivity(question1Intent);
            }
        });

    }

    /**
     * Check the answer to the question 1
     *
     * @param userAnswer is the user's answer to the question 1
     * @return the score the user got for question 1
     */
    private int calculateResultQ1(String userAnswer) {
        int result = 0;
        String answer = "Robina";
        if (userAnswer.equals(answer)) {
            result = 1;
        }
        return result;
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        EditText answerQ1 = (EditText) findViewById(R.id.answer_robots);
        String answer = answerQ1.getText().toString();

        mypref.edit().putString("MYLABEL", answer).apply(); //value to store

    }

    @Override
    protected void onResume() {
        super.onResume();

        mypref.getString("MYLABEL", "defaultStringIfNothingFound");

    }

}

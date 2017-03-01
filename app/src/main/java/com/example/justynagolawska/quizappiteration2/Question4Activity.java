package com.example.justynagolawska.quizappiteration2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        ActionBar actionbar = getSupportActionBar();

        // Applies the custom action bar style
        getSupportActionBar().setDisplayOptions(actionbar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        // Changes the action bar title
        TextView title = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.action_bar_title);
        title.setText(R.string.q4_name);

        // Find the View that shows the next TextView
        Button submitAnswers = (Button) findViewById(R.id.submit_answers);

        //Getting the intent with score for question 1
        Intent question2Intent = getIntent();
        final int resultQ1 = question2Intent.getIntExtra("q1result", 0);

        //Getting the intent with score for question 2
        Intent question3Intent = getIntent();
        final int resultQ2 = question3Intent.getIntExtra("q2result", 0);

        //Getting the intent with score for question 3
        Intent question4Intent = getIntent();
        final int resultQ3 = question4Intent.getIntExtra("q3result", 0);

        // Set a click listener on that View
        submitAnswers.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {

                //Getting the answer to question 4 radio button 1
                RadioButton radioButton1Q4 = (RadioButton) findViewById(R.id.radiobutton1Q4);
                boolean isRadioButton1Q4 = radioButton1Q4.isChecked();

                //Calculate Question 4 score
                int resultQ4 = calculateResultQ4(isRadioButton1Q4);

                //Calculate the quiz score
                int result = resultQ1 + resultQ2 + resultQ3 + resultQ4;

                //Display the quiz result in the Toast message
                Toast.makeText(Question4Activity.this, "Congrats! Your score is " + result + ". Thank you for taking the quiz!", Toast.LENGTH_LONG).show();
            }
        });

        // Find the View that shows the next TextView
        TextView previousQuestion = (TextView) findViewById(R.id.previous);

        // Set a click listener on that View
        previousQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {
                Intent question3Intent = new Intent(Question4Activity.this, Question3Activity.class);
                startActivity(question3Intent);
            }
        });
    }

    /**
     * Check which radio button was selected in the question 4
     *
     * @param radioButton1 is whether or not the user checked the radio button 1
     * @return the score the user got for question 4
     */
    private int calculateResultQ4(boolean radioButton1) {
        int result = 0;
        if (radioButton1) {
            result = 1;
        }
        return result;
    }

}

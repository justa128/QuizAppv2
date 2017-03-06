package com.example.justynagolawska.quizappiteration2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class Question3Activity extends AppCompatActivity {

    SharedPreferences mypref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        final CheckBox checkBox1Q3 = (CheckBox) findViewById(R.id.checkbox1Q3);
        final CheckBox checkBox2Q3 = (CheckBox) findViewById(R.id.checkbox2Q3);
        final CheckBox checkBox3Q3 = (CheckBox) findViewById(R.id.checkbox3Q3);

        mypref = PreferenceManager.getDefaultSharedPreferences(this);

        ActionBar actionbar = getSupportActionBar();

        // Applies the custom action bar style
        getSupportActionBar().setDisplayOptions(actionbar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        // Changes the action bar title
        TextView title = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.action_bar_title);
        title.setText(R.string.q3_name);

        //Getting the intent with score for question 1
        Intent question2Intent = getIntent();
        final int resultQ1 = question2Intent.getIntExtra("q1result", 0);

        //Getting the intent with score for question 2
        Intent question3Intent = getIntent();
        final int resultQ2 = question3Intent.getIntExtra("q2result", 0);

        // Find the View that shows the next TextView
        TextView nextQuestion = (TextView) findViewById(R.id.next);

        // Set a click listener on that View
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {
                //Getting the answer to question 3 checkbox 1
                boolean isCheckBox1Q3 = checkBox1Q3.isChecked();

                //Getting the answer to question 3 checkbox 2
                boolean isCheckBox2Q3 = checkBox2Q3.isChecked();

                //Getting the answer to question 3 checkbox 3
                boolean isCheckBox3Q3 = checkBox3Q3.isChecked();

                //Calculate Question 3 score
                int resultQ3 = calculateResultQ3(isCheckBox1Q3, isCheckBox2Q3, isCheckBox3Q3);

                Intent question4Intent = new Intent(Question3Activity.this, Question4Activity.class);
                question4Intent.putExtra ("q1result", resultQ1);
                question4Intent.putExtra ("q2result", resultQ2);
                question4Intent.putExtra ("q3result", resultQ3);
                startActivity(question4Intent);
            }
        });

        // Find the View that shows the next TextView
        TextView previousQuestion = (TextView) findViewById(R.id.previous);

        // Set a click listener on that View
        previousQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {
                Intent question2Intent = new Intent(Question3Activity.this, Question2Activity.class);
                startActivity(question2Intent);
            }
        });
    }

    /**
     * Check which checkbox was selected in the question 3
     *
     * @param checkBox1 is whether or not the user checked the checkbox1
     * @param checkBox2 is whether or not the user checked the checkbox2
     * @param checkBox3 is whether or not the user checked the checkbox3
     * @return the score the user got for question 3
     */
    private int calculateResultQ3(boolean checkBox1, boolean checkBox2, boolean checkBox3) {
        int result = 0;
        if (checkBox1 && checkBox2) {
            result = 1;
        }

        if (checkBox3) {
            result = 0;
        }
        return result;
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Getting the answer to question 3 checkbox 1
        CheckBox checkBox1Q3 = (CheckBox) findViewById(R.id.checkbox1Q3);
        boolean isCheckBox1Q3 = checkBox1Q3.isChecked();

        //Getting the answer to question 3 checkbox 2
        CheckBox checkBox2Q3 = (CheckBox) findViewById(R.id.checkbox2Q3);
        boolean isCheckBox2Q3 = checkBox2Q3.isChecked();

        //Getting the answer to question 3 checkbox 3
        CheckBox checkBox3Q3 = (CheckBox) findViewById(R.id.checkbox3Q3);
        boolean isCheckBox3Q3 = checkBox3Q3.isChecked();

        if(isCheckBox1Q3 == true){
            mypref.edit().putBoolean("Iscb1q3Checked", true).apply();
        }
        else if(isCheckBox1Q3 == false){
            mypref.edit().putBoolean("Iscb1q3Checked", false).apply();
        }

        if(isCheckBox2Q3 == true){
            mypref.edit().putBoolean("Iscb2q3Checked", true).apply();
        }
        else if(isCheckBox2Q3 == false){
            mypref.edit().putBoolean("Iscb2q3Checked", false).apply();
        }

        if(isCheckBox3Q3 == true){
            mypref.edit().putBoolean("Iscb3q3Checked", true).apply();
        }
        else if(isCheckBox3Q3 == false){
            mypref.edit().putBoolean("Iscb3q3Checked", false).apply();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        CheckBox checkBox1Q3 = (CheckBox) findViewById(R.id.checkbox1Q3);
        CheckBox checkBox2Q3 = (CheckBox) findViewById(R.id.checkbox2Q3);
        CheckBox checkBox3Q3 = (CheckBox) findViewById(R.id.checkbox3Q3);

        if(mypref.contains("Iscb1q3Checked")){
            if(mypref.getBoolean("Iscb1q3Checked",false)){
                checkBox1Q3.setChecked(true);
            }
        }

        if(mypref.contains("Iscb2q3Checked")){
            if(mypref.getBoolean("Iscb2q3Checked",false)){
                checkBox2Q3.setChecked(true);
            }
        }

        if(mypref.contains("Iscb3q3Checked")){
            if(mypref.getBoolean("Iscb3q3Checked",false)){
                checkBox3Q3.setChecked(true);
            }
        }
    }
}

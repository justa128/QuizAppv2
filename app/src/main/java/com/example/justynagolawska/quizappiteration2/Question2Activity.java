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

public class Question2Activity extends AppCompatActivity {

    SharedPreferences mypref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        // disable ScrollView in portrait mode
//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            ScrollView scrollView = (ScrollView)findViewById(R.id.scrollview1);
//            scrollView.setEnabled(false);
//        }

        final CheckBox checkBox1Q2 = (CheckBox) findViewById(R.id.checkbox1Q2);
        final CheckBox checkBox2Q2 = (CheckBox) findViewById(R.id.checkbox2Q2);
        final CheckBox checkBox3Q2 = (CheckBox) findViewById(R.id.checkbox3Q2);

        mypref = PreferenceManager.getDefaultSharedPreferences(this);

        ActionBar actionbar = getSupportActionBar();

        // Applies the custom action bar style
        getSupportActionBar().setDisplayOptions(actionbar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        // Changes the action bar title
        TextView title = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.action_bar_title);
        title.setText(R.string.q2_name);

        //Getting the intent with score for question 1
        Intent question2Intent = getIntent();


        final int resultQ1 = question2Intent.getIntExtra("q1result", 0);

        // Find the View that shows the next TextView
        TextView nextQuestion = (TextView) findViewById(R.id.next);

        // Set a click listener on that View
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {

                //Getting the answer to question 2 checkbox 1
                boolean isCheckBox1Q2 = checkBox1Q2.isChecked();

                //Getting the answer to question 2 checkbox 2
                boolean isCheckBox2Q2 = checkBox2Q2.isChecked();

                //Getting the answer to question 2 checkbox 3
                boolean isCheckBox3Q2 = checkBox3Q2.isChecked();

                //Calculate Question 2 score
                int resultQ2 = calculateResultQ2(isCheckBox1Q2, isCheckBox2Q2, isCheckBox3Q2);

                Intent question3Intent = new Intent(Question2Activity.this, Question3Activity.class);
                question3Intent.putExtra ("q1result", resultQ1);
                question3Intent.putExtra ("q2result", resultQ2);
                startActivity(question3Intent);
            }
        });

        // Find the View that shows the next TextView
        TextView previousQuestion = (TextView) findViewById(R.id.previous);

        // Set a click listener on that View
        previousQuestion.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when next View is clicked on.
            @Override
            public void onClick(View view) {
                Intent question1Intent = new Intent(Question2Activity.this, Question1Activity.class);
                startActivity(question1Intent);
            }
        });
    }

    /**
     * Check which checkbox was selected in the question 2
     *
     * @param checkBox1 is whether or not the user checked the checkbox1
     * @param checkBox2 is whether or not the user checked the checkbox2
     * @param checkBox3 is whether or not the user checked the checkbox3
     * @return the score the user got for question 2
     */
    private int calculateResultQ2(boolean checkBox1, boolean checkBox2, boolean checkBox3) {
        int result = 0;
        if (checkBox1 && checkBox2 && checkBox3) {
            result = 1;
        }
        return result;
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Getting the answer to question 2 checkbox 1
        CheckBox checkBox1Q2 = (CheckBox) findViewById(R.id.checkbox1Q2);
        boolean isCheckBox1Q2 = checkBox1Q2.isChecked();

        //Getting the answer to question 2 checkbox 2
        CheckBox checkBox2Q2 = (CheckBox) findViewById(R.id.checkbox2Q2);
        boolean isCheckBox2Q2 = checkBox2Q2.isChecked();

        //Getting the answer to question 2 checkbox 3
        CheckBox checkBox3Q2 = (CheckBox) findViewById(R.id.checkbox3Q2);
        boolean isCheckBox3Q2 = checkBox3Q2.isChecked();

        if(isCheckBox1Q2 == true){
            mypref.edit().putBoolean("Iscb1Checked", true).apply();
        }
        else if(isCheckBox1Q2 == false){
            mypref.edit().putBoolean("Iscb1Checked", false).apply();
        }

        if(isCheckBox2Q2 == true){
            mypref.edit().putBoolean("Iscb2Checked", true).apply();
        }
        else if(isCheckBox2Q2 == false){
            mypref.edit().putBoolean("Iscb2Checked", false).apply();
        }

        if(isCheckBox3Q2 == true){
            mypref.edit().putBoolean("Iscb3Checked", true).apply();
        }
        else if(isCheckBox3Q2 == false){
            mypref.edit().putBoolean("Iscb3Checked", false).apply();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        //Getting the answer to question 2 checkbox 1
        CheckBox checkBox1Q2 = (CheckBox) findViewById(R.id.checkbox1Q2);

        //Getting the answer to question 2 checkbox 2
        CheckBox checkBox2Q2 = (CheckBox) findViewById(R.id.checkbox2Q2);

        //Getting the answer to question 2 checkbox 3
        CheckBox checkBox3Q2 = (CheckBox) findViewById(R.id.checkbox3Q2);

        if(mypref.contains("Iscb1Checked")){
            if(mypref.getBoolean("Iscb1Checked",false)){
                checkBox1Q2.setChecked(true);
            }
        }

        if(mypref.contains("Iscb2Checked")){
            if(mypref.getBoolean("Iscb2Checked",false)){
                checkBox2Q2.setChecked(true);
            }
        }

        if(mypref.contains("Iscb3Checked")){
            if(mypref.getBoolean("Iscb3Checked",false)){
                checkBox3Q2.setChecked(true);
            }
        }
    }

}

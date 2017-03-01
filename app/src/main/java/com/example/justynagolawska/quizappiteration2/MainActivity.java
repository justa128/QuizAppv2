package com.example.justynagolawska.quizappiteration2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the start quiz button
        TextView startQuiz = (TextView) findViewById(R.id.start_quiz);

        // Set a click listener on that View
        startQuiz.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when start quiz View is clicked on.
            @Override
            public void onClick(View view) {
                Intent question1Intent = new Intent(MainActivity.this, Question1Activity.class);
                startActivity(question1Intent);
            }
        });
    }
}

package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String answer5 = "Антарктида";
    private ArrayList<Boolean> goals = new ArrayList<>();
    int score = 0;
    int errors = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.ques1_var1).setFocusable(true);
    }

    public void calculateScore(View view) {
        CheckBox quest1CheckBox2 = findViewById(R.id.ques1_var2);
        CheckBox quest1CheckBox4 = findViewById(R.id.ques1_var4);
        CheckBox quest2CheckBox2 = findViewById(R.id.ques2_var2);
        CheckBox quest2CheckBox3 = findViewById(R.id.ques2_var3);
        RadioButton quest3button2 = findViewById(R.id.ques3_var2);
        RadioButton quest4button3 = findViewById(R.id.ques4_var3);
        EditText input = findViewById(R.id.input);
        String userInput = input.getText().toString();

        goals.add(quest1CheckBox2.isChecked() && quest1CheckBox4.isChecked());
        goals.add(quest2CheckBox2.isChecked() && quest2CheckBox3.isChecked());
        goals.add(quest3button2.isChecked());
        goals.add(quest4button3.isChecked());
        goals.add(userInput.equalsIgnoreCase(answer5));

        for (Boolean goal : goals) {
            if (goal) score++;
            else errors++;
        }
        displayScore(score, errors);
    }

    private void displayScore(int score, int errors) {
        TextView view = findViewById(R.id.score);
        TextView errorView = findViewById(R.id.errors);
        errorView.setText("Допущено ошибок: " + errors);
        view.setText("Правильных ответов: " + score);
    }
}

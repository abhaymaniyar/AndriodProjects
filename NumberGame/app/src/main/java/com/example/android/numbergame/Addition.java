package com.example.android.numbergame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.android.numbergame.R.id.firstNumber;
import static com.example.android.numbergame.R.id.secondNumber;

public class Addition extends AppCompatActivity {

    int noOfTurns= 0;
    int rights = 0, wrongs = 0;
    public static final int LOW = 50;          // range to generate random numbers
    public static final int MID = 100;         //
    public static final int HIGH = 200;        //
    public static int range;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        Bundle extras = getIntent().getExtras();
        String level = extras.getString("level");
        switch (level){
            case "Beginner":
                range = LOW;
                displayRandomNumbers(LOW);
                break;
            case "Good":
                range = MID;
                displayRandomNumbers(MID);
                break;
            case "Expert":
                range = HIGH;
                displayRandomNumbers(HIGH);
                break;
        }
    }

    /*
        @param - range of random numbers
        generates and sets random numbers and displays a toast when
        number of turns is equal to 10
     */
    public void displayRandomNumbers(int range){
        Random rndm = new Random();
        int firstNumber = 1 + rndm.nextInt(range);
        int secondNumber = 1 + rndm.nextInt(range);
        if(noOfTurns < 10) {
            TextView tOne = (TextView) findViewById(R.id.firstNumber);
            tOne.setText(String.valueOf(firstNumber));
            TextView tTwo = (TextView) findViewById(R.id.secondNumber);
            tTwo.setText(String.valueOf(secondNumber));
            noOfTurns++;
        }else {
            Toast t = Toast.makeText(this, "Game Ended", Toast.LENGTH_LONG);
            t.show();
        }
    }

    /*
        invoked when button is clicked
        this method contains main addition logic and counts number of turns
     */
    public void checkAddition(View view) throws InterruptedException {
        TextView tOne = (TextView) findViewById(firstNumber);
        int firstNumber = Integer.parseInt(tOne.getText().toString());
        TextView tTwo = (TextView) findViewById(secondNumber);
        TextView rightScoreView = (TextView) findViewById(R.id.right_score);
        TextView wrongScoreView = (TextView) findViewById(R.id.wrong_score);
        int secondNumber = Integer.parseInt(tTwo.getText().toString());
        EditText ansText = (EditText) findViewById(R.id.ansText);
        if(ansText.getText().toString().equals("")){
            Toast t = Toast.makeText(this, "Please enter any response.", Toast.LENGTH_SHORT);
            t.show();
        }else {
            Button btn = (Button) findViewById(R.id.test_button);
            if ((firstNumber + secondNumber) == Integer.valueOf(ansText.getText().toString())) {
                btn.setBackgroundColor(Color.GREEN);
                rights++;
                rightScoreView.setText(String.valueOf(rights));
            } else {
                btn.setBackgroundColor(Color.RED);
                wrongs++;
                wrongScoreView.setText(String.valueOf(wrongs));
            }
            ansText.setText("");
            displayRandomNumbers(range);
        }
    }
}

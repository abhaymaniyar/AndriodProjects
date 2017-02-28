package com.example.android.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int yourTotalScore = 0;
    private int compTotalScore = 0;
    private int yourTurnScore = 0;
    private int compTurnScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // rolls a dice,
    Random number = new Random();
    public int rollDice(View view){
        int diceFace = number.nextInt(6) + 1;
        Log.d("diceFace : ", String.valueOf(diceFace));
        String drawableName = "dice"+diceFace;
        Log.d("drawableName : ", drawableName);
        int resID = getResources().getIdentifier(drawableName, "drawable",  getPackageName());
        Log.d("resID : ", String.valueOf(resID));
        ImageView image = (ImageView) findViewById(R.id.dice_face);
        image.setImageResource(resID);
        TextView yourTurnScoreView = (TextView) findViewById(R.id.your_turn_score);
        TextView yourTotalScoreView = (TextView) findViewById(R.id.your_score);
        TextView compTotalScoreView = (TextView) findViewById(R.id.comp_score);
        if(diceFace != 1){
            yourTurnScore = yourTurnScore + diceFace;
            yourTurnScoreView.setText("Your Turn score : "+yourTurnScore);
        }else {
            yourTurnScore = 0;
            yourTurnScoreView.setText("Your Turn score : "+yourTurnScore);
            computerTurn();
        }
        return yourTurnScore;
    }

    // resets the value of all the score variables (handler for reset button)
    public void resetValues(View view){
        TextView yourTurnScoreView = (TextView) findViewById(R.id.your_turn_score);
        TextView yourTotalScoreView = (TextView) findViewById(R.id.your_score);
        TextView compTotalScoreView = (TextView) findViewById(R.id.comp_score);
        TextView compTurnScoreView = (TextView) findViewById(R.id.comp_turn_score);
        yourTotalScore = 0;
        compTotalScore = 0;
//        compTurnScore = 0;
//        yourTurnScore = 0;
        yourTotalScoreView.setText(yourTotalScore);
        compTotalScoreView.setText(compTotalScore);
        yourTurnScoreView.setText("");
        compTotalScoreView.setText("");
    }

    public void holdValues(View view){
        TextView yourTurnScoreView = (TextView) findViewById(R.id.your_turn_score);
        TextView yourTotalScoreView = (TextView) findViewById(R.id.your_score);
        int turnScore = Integer.parseInt(yourTurnScoreView.getText().toString());
        yourTotalScore += turnScore;
        yourTotalScoreView.setText(yourTotalScore);
        yourTurnScoreView.setText("");
        computerTurn();
    }

    public void computerTurn(){
        Button holdButton = (Button) findViewById(R.id.hold_button);
        holdButton.setEnabled(false);
        Button rollButton = (Button) findViewById(R.id.roll_button);
        rollButton.setEnabled(false);
//        while(true){
//            compTurnScore = compTurnScore + rollDice();
//            if(compTurnScore >= 20){
//                holdValues(new View());    // hold if the value of compTurnScore is greater or equal to 20
//            }
        }
    }

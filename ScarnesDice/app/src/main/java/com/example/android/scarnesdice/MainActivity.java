package com.example.android.scarnesdice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    boolean userTurn = false;
    public void changeTurn(View view){
        if(userTurn){
            // roll the dice as roll button is clicked
        }else{
            // roll the dice for computer's turn
        }
    }

    public void rollDice(View view) {
        TextView compScoreText = (TextView) findViewById(R.id.comp_score_text);
        TextView yourScoreText = (TextView) findViewById(R.id.your_score_text);
        TextView yourTurnScoreView = (TextView) findViewById(R.id.your_turn_score);
        TextView yourTotalScoreView = (TextView) findViewById(R.id.your_score);
        TextView compTotalScoreView = (TextView) findViewById(R.id.comp_score);
        int diceFace = number.nextInt(6) + 1;
        String drawableName = "dice" + diceFace;
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        ImageView image = (ImageView) findViewById(R.id.dice_face);
        image.setImageResource(resID);
        compScoreText.setText("Computer turn score : ");
        yourScoreText.setText("Your turn score : ");
        if (diceFace != 1) {
            yourTurnScore = yourTurnScore + diceFace;
            yourTurnScoreView.setText(String.valueOf(yourTurnScore));
            Log.d("User turn ", "> ");
        } else {
            yourTurnScore = 0;
            yourTurnScoreView.setText(String.valueOf(yourTurnScore));
            Log.d("Now its comp turn ", " > ");
            computerTurn();
        }
//        return yourTurnScore;
    }

    // resets the value of all the score variables (handler for reset button)
    public void resetValues(View view) {
        TextView yourTurnScoreView = (TextView) findViewById(R.id.your_turn_score);
        TextView yourTotalScoreView = (TextView) findViewById(R.id.your_score);
        TextView compTotalScoreView = (TextView) findViewById(R.id.comp_score);
        TextView compTurnScoreView = (TextView) findViewById(R.id.comp_turn_score);
        TextView compScoreText = (TextView) findViewById(R.id.comp_score_text);
        TextView yourScoreText = (TextView) findViewById(R.id.your_score_text);
        yourTotalScore = 0;
        compTotalScore = 0;
        compTurnScore = 0;
        yourTurnScore = 0;
        yourTotalScoreView.setText(String.valueOf(yourTotalScore));
        compTotalScoreView.setText(String.valueOf(compTotalScore));
        yourTurnScoreView.setText("");
        compTurnScoreView.setText("");
        compScoreText.setText("");
        yourScoreText.setText("");
        Button holdButton = (Button) findViewById(R.id.hold_button);
        holdButton.setEnabled(true);
        Button rollButton = (Button) findViewById(R.id.roll_button);
        rollButton.setEnabled(true);
    }

    public void holdValues(View view) {
        TextView yourTurnScoreView = (TextView) findViewById(R.id.your_turn_score);
        TextView yourTotalScoreView = (TextView) findViewById(R.id.your_score);
        TextView yourScoreText = (TextView) findViewById(R.id.your_score_text);
        TextView compScoreText = (TextView) findViewById(R.id.comp_score_text);
//        Log.d("Yourturnscoreview ", yourTurnScoreView.getText().toString());
        yourTurnScore = Integer.parseInt(yourTurnScoreView.getText().toString());
        yourTotalScore += yourTurnScore;
        yourTurnScore = 0;
        yourTotalScoreView.setText(String.valueOf(yourTotalScore));
        yourTurnScoreView.setText(String.valueOf(yourTurnScore));
        yourScoreText.setText("Your turn score : ");
//        compScoreText.setText("Comp turn score : ");
        Log.d("Now its comp turn ", " > ");
        computerTurn();
    }

    public void computerTurn() {
        TextView compScoreText = (TextView) findViewById(R.id.comp_score_text);
        TextView yourScoreText = (TextView) findViewById(R.id.your_score_text);
        TextView yourTurnScoreView = (TextView) findViewById(R.id.your_turn_score);
        TextView yourTotalScoreView = (TextView) findViewById(R.id.your_score);
        TextView compTotalScoreView = (TextView) findViewById(R.id.comp_score);
        TextView compTurnScoreView = (TextView) findViewById(R.id.comp_turn_score);
        Button holdButton = (Button) findViewById(R.id.hold_button);
        holdButton.setEnabled(false);
        Button rollButton = (Button) findViewById(R.id.roll_button);
        rollButton.setEnabled(false);
        while (true) {
            if (compTurnScore < 20) {
                int diceFace = number.nextInt(6) + 1;
                String drawableName = "dice" + diceFace;
                int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                ImageView image = (ImageView) findViewById(R.id.dice_face);
                image.setImageResource(resID);
                Log.d("while if dice face > ", String.valueOf(diceFace));
                if (diceFace != 1) {
                    compTurnScore = compTurnScore + diceFace;
                    Log.d("while if if > ", String.valueOf(compTurnScore));
                    compTurnScoreView.setText(String.valueOf(compTurnScore));
                } else {
                    compTurnScore = 0;
                    Log.d("while if else > ", String.valueOf(compTurnScore));
                    compTurnScoreView.setText(String.valueOf(compTurnScore));
                    break;
                }
            }else{
                compTurnScore = Integer.parseInt(compTurnScoreView.getText().toString());
                compTotalScore += compTurnScore;
                Log.d("while else> ", String.valueOf(compTotalScore));
                compTurnScore = 0;
                compTotalScoreView.setText(String.valueOf(compTotalScore));
                compTurnScoreView.setText(String.valueOf(compTurnScore));
                compScoreText.setText("Comp turn score : ");
                break;
            }
        }
        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_SHORT;
        if(compTotalScore > yourTotalScore){
            text = "Computer Won!!";
        }else if(yourTotalScore > compTotalScore){
            text = "User Won!!";
        }else{
            text = "Its a draw!!";
        }
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    // to show a delayed computer turn
//        private Handler mHandler = new Handler();

//        private Runnable mUpdateTimeTask = new Runnable() {
//            public void run() {
//                final long start = mStartTime;
//                long millis = SystemClock.uptimeMillis() - start;
//                int seconds = (int) (millis / 1000);
//                int minutes = seconds / 60;
//                seconds     = seconds % 60;
//
//                if (seconds < 10) {
//                    mTimeLabel.setText("" + minutes + ":0" + seconds);
//                } else {
//                    mTimeLabel.setText("" + minutes + ":" + seconds);
//                }
//
//                mHandler.postAtTime(this,
//                        start + (((minutes * 60) + seconds + 1) * 1000));
//            }
//        };
//        View.OnClickListener mStartListener = new View.OnClickListener() {
//            public void onClick(View v) {
//                if (mStartTime == 0L) {
//                    mStartTime = System.currentTimeMillis();
//                    mHandler.removeCallbacks(mUpdateTimeTask);
//                    mHandler.postDelayed(mUpdateTimeTask, 100);
//                }
//            }
//        };
    }
}

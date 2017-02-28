package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Integer scoreTeamA = 0, scoreTeamB = 0;
    public void incrementThreeTeamA(View view){
        scoreTeamA += 3;
        displayScoreTeamA(scoreTeamA);
    }

    public void incrementThreeTeamB(View view){
        scoreTeamB += 3;
        displayScoreTeamB(scoreTeamB);
    }

    public void incrementTwoTeamA(View view){
        scoreTeamA += 2;
        displayScoreTeamA(scoreTeamA);
    }

    public void incrementTwoTeamB(View view){
        scoreTeamB += 2;
        displayScoreTeamB(scoreTeamB);
    }

    public void incrementOneTeamA(View view){
        scoreTeamA += 1;
        displayScoreTeamA(scoreTeamA);
    }

    public void incrementOneTeamB(View view){
        scoreTeamB += 1;
        displayScoreTeamB(scoreTeamB);
    }

    private void displayScoreTeamA(Integer scoreTeamA){
        TextView scoreTeamATextView = (TextView) findViewById(R.id.score_teamA_textView);
        scoreTeamATextView.setText(scoreTeamA.toString());
    }

    private void displayScoreTeamB(Integer scoreTeamB){
        TextView scoreTeamBTextView = (TextView) findViewById(R.id.score_teamB_textView);
        scoreTeamBTextView.setText(scoreTeamB.toString());
    }

    public void resetScores(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreTeamA(scoreTeamA);
        displayScoreTeamB(scoreTeamB);
    }

    public void displayResult(View view){
        if (scoreTeamA > scoreTeamB){
            Result("Team A won the Match");
        }
        else if(scoreTeamB > scoreTeamA){
            Result("Team B won the Match");
        }else{
            Result("Match Draw!");
        }
    }

    private void Result(String winner){
        TextView resultTextView = (TextView) findViewById(R.id.score_teamA_textView);
        resultTextView.setText(winner);
    }
}

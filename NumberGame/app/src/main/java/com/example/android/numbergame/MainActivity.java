package com.example.android.numbergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectLevelAddition(View view){
        Intent t = new Intent(this, levels.class);
        t.putExtra("className", "Addition");
        startActivity(t);
    }

    public void selectLevelSubtraction(View view){
        Intent t = new Intent(this, levels.class);
        t.putExtra("className", "Subtraction");
        startActivity(t);
    }

    public void selectLevelMultiplication(View view){
        Intent t = new Intent(this, levels.class);
        t.putExtra("className", "Multiplication");
        startActivity(t);
    }

    public void selectLevelDivision(View view){
        Intent t = new Intent(this, levels.class);
        t.putExtra("className", "Division");
        startActivity(t);
    }
}

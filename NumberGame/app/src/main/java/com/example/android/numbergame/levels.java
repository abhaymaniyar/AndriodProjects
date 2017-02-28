package com.example.android.numbergame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class levels extends AppCompatActivity {

    String className = "";
    Intent t = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        Bundle bundle = getIntent().getExtras();
        className = bundle.getString("className");
        switch (className){
            case "Addition":
                t = new Intent(this, Addition.class);{
                View levelView = findViewById(R.id.activity_levels);
                levelView.setBackgroundColor(getResources().getColor(R.color.addition));
                break;}
            case "Subtraction":
                t = new Intent(this, Subtraction.class);{
                View levelView = findViewById(R.id.activity_levels);
                levelView.setBackgroundColor(getResources().getColor(R.color.subtraction));
                break;}
            case "Multiplication":
                t = new Intent(this, Multiplication.class);{
                View levelView = findViewById(R.id.activity_levels);
                levelView.setBackgroundColor(getResources().getColor(R.color.multiplication));
                break;}
            case "Division":
                t = new Intent(this, Division.class);{
                View levelView = findViewById(R.id.activity_levels);
                levelView.setBackgroundColor(getResources().getColor(R.color.division));
                break;}
        }
    }

    public void beginnerSelected(View view) throws ClassNotFoundException {
//        Button btn = (Button) findViewById(R.id.expert_btn);
//        btn.setText(Class.forName(className).toString());
//        Log.d(">>>>", Class.forName(className).toString());
        t.putExtra("level", "Beginner");
        startActivity(t);
    }

    public void goodSelected(View view) throws ClassNotFoundException {
        t.putExtra("level", "Good");
        startActivity(t);
    }

    public void expertSelected(View view) throws ClassNotFoundException {
        t.putExtra("level", "Expert");
        startActivity(t);
    }
}

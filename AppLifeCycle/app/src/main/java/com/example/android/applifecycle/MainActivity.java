package com.example.android.applifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Inside >>>>>> ", "ONCREATE()");
        setContentView(R.layout.activity_main);
    }

    protected void onStart(){
        super.onStart();
        Log.d("Inside >>>>>> ", "ONSTART()");
        setContentView(R.layout.activity_main);
    }

    protected void onResume(){
        super.onResume();
        Log.d("Inside >>>>>> ", "ONResume()");
        setContentView(R.layout.activity_main);
    }

    protected void onStop(){
        super.onStop();
        Log.d("Inside >>>>>> ", "ONStop()");
        setContentView(R.layout.activity_main);
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.d("Inside >>>>>> ", "ONDestroy()");
        setContentView(R.layout.activity_main);
    }

    protected void onRestart(){
        super.onRestart();
        Log.d("Inside >>>>>> ", "ONReSTART()");
        setContentView(R.layout.activity_main);
    }

    protected void onPause(){
        super.onPause();
        Log.d("Inside >>>>>> ", "ONpause()");
        setContentView(R.layout.activity_main);
    }
}

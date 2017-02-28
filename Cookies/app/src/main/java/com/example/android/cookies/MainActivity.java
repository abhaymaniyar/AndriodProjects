package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        TextView text = (TextView) findViewById(R.id.status_text_view);
        ImageView img = (ImageView) findViewById(R.id.android_cookie_image_view);
        Button btn = (Button) findViewById(R.id.button_text);
        // TODO: Find a reference to the TextView in the layout. Change the text.
        if(text.getText().toString().equals("I'm so hungry")){
            text.setText("I'm so Full.");
            btn.setText("Place Cookie");
            img.setImageResource(R.drawable.after_cookie);
        }else {
            text.setText("I'm so hungry");
            btn.setText("Eat Cookie");
            img.setImageResource(R.drawable.before_cookie);
        }

    }
}
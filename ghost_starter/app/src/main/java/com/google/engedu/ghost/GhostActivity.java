package com.google.engedu.ghost;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import static com.google.engedu.ghost.R.id.ghostText;


public class GhostActivity extends AppCompatActivity {
    private static final String COMPUTER_TURN = "Computer's turn";
    private static final String USER_TURN = "Your turn";
    private GhostDictionary dictionary;
    private boolean userTurn = false;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghost);
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("words.txt");
            dictionary = new SimpleDictionary(inputStream);
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
            toast.show();
        }
        onStart(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)   {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ghost, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handler for the "Reset" button.
     * Randomly determines whether the game starts with a user turn or a computer turn.
     * @param view
     * @return true
     */
    public boolean onStart(View view) {
        userTurn = random.nextBoolean();
        TextView text = (TextView) findViewById(ghostText);
        text.setText("");
//        Log.d("Txt a sT >>>>>>> ", "j " +text.getText().toString());
        TextView label = (TextView) findViewById(R.id.gameStatus);
        if (userTurn) {
            label.setText(USER_TURN);
        } else {
            label.setText(COMPUTER_TURN);
            Log.d("Turn >>>>>>> ", label.getText().toString());
            computerTurn();
        }
        return true;
    }

    private void computerTurn() {
        TextView label = (TextView) findViewById(R.id.gameStatus);
        // Do computer turn stuff then make it the user's turn again
        TextView text = (TextView) findViewById(ghostText);
        Log.d("computerTurn >>>>>>> ", text.getText().toString());
        String word = text.getText().toString();
        Log.d("Value of Word : ", word);
        Log.d("Found : ", String.valueOf(dictionary.isWord(word)));
        if(word.length() >= 4 && dictionary.isWord(word)){
            label.setText("Computer Won!");
            userTurn = true;
            return;
        }
        try {
            String wordStartingWith = dictionary.getAnyWordStartingWith(word);
            if(wordStartingWith == null){
                challenge(null);
                label.setText("Computer Won!");
            }else{
                text.setText(word+wordStartingWith.substring(word.length(),word.length()+1));
            }
            userTurn = true;
            label.setText(USER_TURN);
        }catch (Exception e){

        }

    }

    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if((char)event.getUnicodeChar() >= 'a' && (char)event.getUnicodeChar() <= 'z'){
//            Log.d(">>>", ""+(char)event.getUnicodeChar());
            TextView text = (TextView) findViewById(ghostText);
//            String str = (String) text.getText().toString();
//            text.setText(str + ((char) event.getUnicodeChar()));
            text.append(""+(char)event.getUnicodeChar());
            computerTurn();
            return true;
        }
        else{
            return super.onKeyUp(keyCode, event);
        }
    }

    public void challenge(View view){
        TextView text = (TextView) findViewById(ghostText);
        String word = text.getText().toString();
        String s = dictionary.getAnyWordStartingWith(word);
        TextView label = (TextView) findViewById(R.id.gameStatus);
        Log.d("Tag >>>>>>> s ",s);
        Log.d("Tag >>>>>>>", word);
        if(word.length() >= 4){
            if(dictionary.isWord(word)){
                label.setText("User Wins!");
            }else {
                label.setText("Computer Wins!");
                text.setText(s);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}

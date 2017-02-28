package com.google.engedu.ghost;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SimpleDictionary implements GhostDictionary {
    private ArrayList<String> words;
    private Random random = new Random();
    // this will create an arraylist called words and add words to it only if
    // the word length is >= 4
    public SimpleDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        words = new ArrayList<>();
        String line = null;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
              words.add(line.trim());
        }
    }

    // it shows whether a word is present in the words array list or not
    @Override
    public boolean isWord(String word) {
        return words.contains(word);
    }

    @Override
    public String getAnyWordStartingWith(String prefix) {
        String wordWithPrefix = null;
        Log.d("Prefix ", prefix);
        if(prefix == ""){
            int i = random.nextInt(60000);
            return (words.get(i+1));
        }else{
            int begin = 0;
            int end = words.size()-1;
            int mid = 0;
            while(begin <= end){
                mid = (begin + end) / 2;
//                int c = prefix.compareTo(words.get(mid));
                Log.d("prfefiasj ", words.get(mid).toString());
                int c = words.get(mid).startsWith(prefix) ? 0 : prefix.compareTo(words.get(mid));
                if( c > 0){
                    begin = mid + 1;
                    Log.d("Mid + 1 >>>>>>>>" , words.get(begin));
                }else if(c == 0){
                    wordWithPrefix = words.get(mid);
                    break;
                }else{
                    end = mid - 1;
//                    Log.d("end >>>>>>>>" , words.get(end));
                }
            }
            wordWithPrefix = words.get(mid+1);
        }
        return wordWithPrefix;
    }

    @Override
    public String getGoodWordStartingWith(String prefix) {
        String selected = null;
        int pos = -1;
        pos = Collections.binarySearch(words, prefix);
        if(pos == -1){
            return null;
        }
        return selected = words.get(pos);
    }
}

package com.example.android.miwok;

/**
 * Created by abhay on 25/11/16.
 */

public class Word {

    private String miwokWord = "";
    private String defaultWord = "";
    private final int NO_IMAGE_PROVIDED = -1;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String englishWord, String miwokWord){
        this.miwokWord = miwokWord;
        this.defaultWord = englishWord;
    }

    public Word(String englishWord, String miwokWord, int mImageResourceId){
        this.miwokWord = miwokWord;
        this.defaultWord = englishWord;
        this.mImageResourceId = mImageResourceId;
    }

    public String getMiwokWord(){
        return miwokWord;
    }

    public String getEnglishWord(){
        return defaultWord;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

//    Returns true if we have a image else returns false
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}

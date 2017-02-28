package com.google.engedu.anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 4;
    private Random random = new Random();
    ArrayList<String> wordList = new ArrayList<String>();
    HashSet<String> wordSet = new HashSet<>();
    HashMap<String,ArrayList<String>> lettersToWord = new HashMap<>();

    // this constructor add all the words in the txt file to a HashMap(sortedWord, corresponding word)
    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordList.add(word);
            wordSet.add(word);
            String sortedWord = sortLetters(word);
            if (lettersToWord.containsKey(sortedWord)){
                lettersToWord.get(sortedWord).add(word);
            }else {
                lettersToWord.put(sortedWord, new ArrayList<String>());
                lettersToWord.get(sortedWord).add(word);
            }
        }
    }


    // tells us whether a word is a valid game word or not
    public boolean isGoodWord(String word, String base) {
        boolean valid = false;
        if(wordSet.contains(word) && !(word.toLowerCase().contains(base.toLowerCase()))){
            valid = true;
            return  valid;
        }
        return valid;
    }

    // this method is taking a word and searching the text file for
    // all possible anagrams in it by sorting the word and
    // comparing the length with the targetWord
    // @param targetWord = the word whose anagrams we are searching in the text file
    public ArrayList<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        result = lettersToWord.get(sortLetters(targetWord));
//        Log.d("List : ", result.toString());
        return result;
    }

    // method to sort the letters of a given word
    // @param str = string to sort
    public String sortLetters(String str){
        char[] chars = str.toCharArray();   // put the characters into an array
        Arrays.sort(chars);                 // sort the array
        str = new String(chars);
        return str;
    }

    // returns all the anagram words with one letter extra then the parameter passed
    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> anagramList;
        for(char alphabet = 'a' ; alphabet <= 'z'; alphabet++){
            String newWord = word + alphabet;
            String sortedWord = sortLetters(newWord);
            if(lettersToWord.containsKey(sortedWord)){
                anagramList = new ArrayList();
                anagramList = lettersToWord.get(sortedWord);
                for(int i = 0;i< anagramList.size();i++)
                    result.add(String.valueOf(anagramList.get(i)));
                }
        }
        return result;
    }

    // picks a starter word from text file
    public String pickGoodStarterWord() {

        int RandomNum;
        String randomWord = null;
        ArrayList listOfWords;
        boolean keepGoing = true;
        while(keepGoing) {
            RandomNum = random.nextInt(62000) + 1;
            randomWord = (String) wordList.get(RandomNum);
            listOfWords = new ArrayList();
            listOfWords = (ArrayList)lettersToWord.get(sortLetters(randomWord));
            if(listOfWords.size() >= MIN_NUM_ANAGRAMS && randomWord.length() > MAX_WORD_LENGTH){
                keepGoing = false;
            }
        }
        return randomWord;
    }
}

package com.example.android.learnjapanese.logic;

import java.util.HashMap;

/**
 * Created by rockderick on 10/08/16.
 */
public class Quiz {

    protected HashMap<String, String> questions;
    protected int numberOfCorrectAnswers;
    protected int getNumberOfInCorrectAnswers;


    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void setNumberOfCorrectAnswers(int numberOfCorrectAnswers) {
        this.numberOfCorrectAnswers = numberOfCorrectAnswers;
    }

    public int getGetNumberOfInCorrectAnswers() {
        return getNumberOfInCorrectAnswers;
    }

    public void setGetNumberOfInCorrectAnswers(int getNumberOfInCorrectAnswers) {
        this.getNumberOfInCorrectAnswers = getNumberOfInCorrectAnswers;
    }
}

package com.example.android.learnjapanese.logic;

/**
 * Created by rockderick on 13/06/16.
 */
public class Hiragana extends Kana {

    public Hiragana(String reading, String romaji,String nmemonic,String imageName)
    {
        super(reading,romaji,nmemonic,imageName);
    }

    public Hiragana(String reading, String romaji,String nmemonic,String imageName,int sound)
    {
        super(reading,romaji,nmemonic,imageName,sound);
    }

    public Hiragana(String reading, String romaji,String nmemonic,int image,int sound){
        super(reading,romaji,nmemonic,image,sound);
    }


}

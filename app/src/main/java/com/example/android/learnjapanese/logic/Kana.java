package com.example.android.learnjapanese.logic;

import com.example.android.learnjapanese.R;

/**
 * Created by rockderick on 13/06/16.
 */
public class Kana {


    private String reading;
    private String romaji;
    private String nmemonic;
    private String imageName;
    private int image;

    public int getSound() {
        return sound;
    }

    private int sound;

    public Kana(String reading, String romaji,String nmemonic,String imageName){
        this.reading = reading;
        this.romaji = romaji;
        this.nmemonic = nmemonic;
        this.imageName = imageName;
        this.sound = R.raw.a;
    }

    public Kana(String reading, String romaji,String nmemonic,String imageName,int sound){
        this.reading = reading;
        this.romaji = romaji;
        this.nmemonic = nmemonic;
        this.imageName = imageName;
        this.sound = sound;
    }

    public Kana(String reading, String romaji,String nmemonic,int image,int sound){
        this.reading = reading;
        this.romaji = romaji;
        this.nmemonic = nmemonic;
        this.image = image;
        this.sound = sound;
    }


    public String getReading() {
        return reading;
    }

    public String getRomaji() {
        return romaji;
    }


    public String getNmemonic() {
        return nmemonic;
    }

    public String getImageName() {
        return imageName;
    }

    public int getImage() {
        return image;
    }
}

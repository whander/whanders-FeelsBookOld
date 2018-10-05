package com.example.whanders_feelsbook;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//The shell and most base functions were taken from lonelyTwitter lab (specifically the Tweet class) but were heavily edited by me.

public class Post extends Object {
    private String text;
    protected String date;
    protected Mood mood;

    public Post(String text, String date, Mood mood){
        this.text = text;
        this.date = date;
        this.mood = mood;

    }

    public Post(Mood mood){
        this.mood = mood;

    }

    public Post(){
        //this.setMood(mood);
        Date theDate = new Date(System.currentTimeMillis());
        SimpleDateFormat iso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        this.date = iso.format(theDate);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws PostTooLongException {
        if (text.length() <= 100) {
            this.text = text;
        } else {
            throw new PostTooLongException();
        }
    }

    public String getDate() {
        return this.date;
    }


    public void setDate(String time){
        this.date = time;
    }

    @Override
    public String toString() {
        if (this.text != null) {
            return mood.getType() + " | " + this.date + " | " + text;
        }else{
            return mood.getType() + " | " + this.date;
        }
    }

    public void setMood(Mood mood){
        this.mood = mood;

    }

    public String getType(){
        return mood.getType();
    }



}

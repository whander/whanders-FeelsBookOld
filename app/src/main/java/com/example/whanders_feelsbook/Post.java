package com.example.whanders_feelsbook;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//The shell and most base functions were taken from lonelyTwitter lab (specifically the Tweet class) but were heavily edited by me.

public class Post extends Object {
    //text is the optional text for a post
    private String text;
    protected String date;
    protected Mood mood;

    //constructor for adding all variables
    public Post(String text, String date, Mood mood){
        this.text = text;
        this.date = date;
        this.mood = mood;

    }

    //initializes a post without the text
    public Post(Mood mood){
        this.mood = mood;

    }

    public Post(){
        //code taken from https://mincong-h.github.io/2017/02/16/convert-date-to-string-in-java/
        Date theDate = new Date(System.currentTimeMillis());
        SimpleDateFormat iso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        this.date = iso.format(theDate);
    }

    public String getText() {
        return text;
    }
    
    //adds the optional text to the post class. Throws an exception if the text is too long.
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

    //rewrote the toString function when relating to this class. Has one for including the optional text and one for not. 
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

    //returns if the mood for the post in anger, fear, etc. 
    public String getType(){
        return mood.getType();
    }



}

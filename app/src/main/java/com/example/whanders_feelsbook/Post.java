package com.example.whanders_feelsbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joshua2 on 9/16/15.
 */

//implements Postable, MyObservable

public class Post extends Object {
    private String text;
    protected Date date;
    protected Mood mood;

    public Post(String text, Date date, Mood mood){
        this.text = text;
        this.date = date;
        this.mood = mood;

    }

    public Post(Mood mood){
        this.mood = mood;

    }

    public Post(){
        //this.setMood(mood);
        this.date = new Date(System.currentTimeMillis());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) throws PostTooLongException {
        if (text.length() <= 140) {
            this.text = text;
        } else {
            throw new PostTooLongException();
        }
        //notifyAllObservers();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        //notifyAllObservers();
    }

    @Override
    public String toString() {
        if (this.text != null) {
            return mood.getType() + " | " + date.toString() + " | " + text;
        }else{
            return mood.getType() + " | " + date.toString();
        }
    }

    public void setMood(Mood mood){
        this.mood = mood;

    }

    public String getType(){
        return mood.getType();
    }

    //private volatile ArrayList<MyObserver> observers = new ArrayList<MyObserver>();

  /*  public void addObserver(MyObserver observer) {
        observers.add(observer);
    }

    private void notifyAllObservers() {
        for (MyObserver observer : observers) {
            observer.myNotify(this);
        }
    }*/


}
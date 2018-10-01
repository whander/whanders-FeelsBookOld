package com.example.whanders_feelsbook;

import java.util.Date;

public class Mood {
    //mood is the primary class. All actual moods (ie, anger, sadness, etc.) are subclasses of mood.

    private Date date;
    private String type;

    //intializes mood with a date
    public Mood(Date date){
        this.date = date;
    }

    //default initialzation
    public Mood(){

    }

    //returns date
    public Date getDate(){
        return this.date;

    }

    //returns type
    public String getType(){
        return this.type;
    }

    //manually sets the type. Used in subclasses
    public void setType(String type){
        this.type = type;

    }
}


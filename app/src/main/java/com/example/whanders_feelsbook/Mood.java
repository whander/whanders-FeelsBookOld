package com.example.whanders_feelsbook;

import java.util.Date;

public class Mood {
    private Date date;
    private String type;

    public Mood(Date date){
        this.date = date;
    }

    public Mood(){
       // this.date = new Date(System.currentTimeMillis());

    }


    public Date getDate(){
        return this.date;

    }

    public String getType(){
        return this.type;
    }

    public void setType(String type){
        this.type = type;

    }
}


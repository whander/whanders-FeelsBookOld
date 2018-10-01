package com.example.whanders_feelsbook;

import android.util.Log;

public class Sadness extends Mood {
    private String name = "Sadness";

    public Sadness(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}


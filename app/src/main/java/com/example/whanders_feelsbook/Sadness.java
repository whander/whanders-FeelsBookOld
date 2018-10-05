package com.example.whanders_feelsbook;

import android.util.Log;

//Purpose is to be a subclass of mood that sets type to sadness.
//No known issues

public class Sadness extends Mood {
    private String name = "Sadness";

    public Sadness(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}


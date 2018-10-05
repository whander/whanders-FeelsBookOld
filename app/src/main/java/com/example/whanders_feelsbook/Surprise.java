package com.example.whanders_feelsbook;

import android.util.Log;

//Purpose is to be a subclass of mood that sets type to surprise.
//No known issues

public class Surprise extends Mood {
    private String name = "Surprise";

    public Surprise(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}

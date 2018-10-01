package com.example.whanders_feelsbook;

import android.util.Log;

public class Surprise extends Mood {
    private String name = "Surprise";

    public Surprise(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}

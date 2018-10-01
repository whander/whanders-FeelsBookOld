package com.example.whanders_feelsbook;

import android.util.Log;

public class Anger extends Mood {
    //only difference in the mood subclasses is that they initialize the type

    private String name = "Anger";

    public Anger(){
            Log.d("whanders","Setting type to anger");
            this.setType(this.name);
    }

}
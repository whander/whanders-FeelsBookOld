package com.example.whanders_feelsbook;

import android.util.Log;

public class Anger extends Mood {
    private String name = "Anger";

    public Anger(){
            Log.d("whanders","Setting type to anger");
            this.setType(this.name);
    }

}
package com.example.whanders_feelsbook;

import android.util.Log;

public class Joy extends Mood {
    private String name = "Joy";

    public Joy(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}


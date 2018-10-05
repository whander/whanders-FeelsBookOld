package com.example.whanders_feelsbook;

import android.util.Log;

//Purpose is to be a subclass of mood that sets type to joy.
//No known issues

public class Joy extends Mood {
    private String name = "Joy";

    public Joy(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}


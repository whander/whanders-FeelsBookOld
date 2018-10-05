package com.example.whanders_feelsbook;

import android.util.Log;

//Purpose is to be a subclass of mood that sets type to love.
//No known issues

public class Love extends Mood {
    private String name = "Love";

    public Love(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }

}

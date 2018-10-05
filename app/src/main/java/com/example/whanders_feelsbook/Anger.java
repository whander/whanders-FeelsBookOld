package com.example.whanders_feelsbook;

import android.util.Log;

//Purpose is to be a subclass of mood that sets type to anger.
//No known issues

public class Anger extends Mood {
    //only difference in the mood subclasses is that they initialize the type

    private String name = "Anger";

    public Anger(){
            Log.d("whanders","Setting type to anger");
            this.setType(this.name);
    }

}

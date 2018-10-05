package com.example.whanders_feelsbook;

import android.util.Log;

//Purpose is to be a subclass of mood that sets type to fear.
//No known issues

public class Fear extends Mood {
    private String name = "Fear";

    public Fear(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}

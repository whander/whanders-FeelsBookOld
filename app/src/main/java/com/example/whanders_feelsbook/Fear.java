package com.example.whanders_feelsbook;

import android.util.Log;

public class Fear extends Mood {
    private String name = "Fear";

    public Fear(){
        Log.d("whanders","Setting type to anger");
        this.setType(this.name);
    }
}
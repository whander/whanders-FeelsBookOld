package com.example.whanders_feelsbook;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        //Button Delete = (Button)findViewById(R.id.delete);
        //Button Edit = (Button)findViewById(R.id.edit);

        TextView displayPost = (TextView)findViewById(R.id.currentPost);



       /* Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    */

    }

    @Override
    protected void onStart(){
        super.onStart();
    }
}

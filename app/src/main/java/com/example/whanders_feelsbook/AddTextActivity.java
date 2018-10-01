package com.example.whanders_feelsbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;

//https://stackoverflow.com/questions/2091465/how-do-i-pass-data-between-activities-in-android-application

public class AddTextActivity extends Activity  {
    //private static final String FILENAME = "file.sav";

    public EditText getBodyText() {
        return bodyText;
    }

    private ArrayList<Post> posts = StartActivity.posts;

    private EditText bodyText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("whanders", "successfully switched activities to addText");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_text);

        bodyText = (EditText) findViewById(R.id.body); //view
        Button saveButton = (Button)findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = bodyText.getText().toString();
                int num = posts.size();
                num = num - 1;
                Log.d("whanders", Integer.toString(num));
                if (text.length() > 0){
                    posts.get(num).setText(text);
                }

                saveInFile();
                finish();

                //Intent switchToMain = new Intent(AddTextActivity.this, StartActivity.class);
                //startActivity(switchToMain);

            }
        });



    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }

    private void saveInFile() {
        Log.d("whanders", "got to save");
        try {
            FileOutputStream fos = openFileOutput(StartActivity.FILENAME,
                    0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(posts, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

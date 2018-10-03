package com.example.whanders_feelsbook;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

public class EditActivity extends Activity {
    private ArrayList<Post> posts = StartActivity.posts;
    private ArrayAdapter<Post> adapter;
    private ListView displayPost;
    private int position;
    private ArrayList<Post> neededPost = new ArrayList<Post>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        Bundle extras = getIntent().getExtras();
        position = extras.getInt("position");

        displayPost = (ListView) findViewById(R.id.currentPost); //view


        final EditText bodyText = (EditText)findViewById(R.id.body2);

        Button updateText = (Button)findViewById(R.id.updateText);
        Button done = (Button)findViewById(R.id.done);
        Button angerButton = (Button)findViewById(R.id.angerButton2);
        Button fearButton = (Button)findViewById(R.id.fearButton2);
        final Button joyButton = (Button)findViewById(R.id.joyButton2);
        Button loveButton = (Button)findViewById(R.id.loveButton2);
        Button sadnessButton = (Button)findViewById(R.id.sadnessButton2);
        Button surpriseButton = (Button)findViewById(R.id.surpriseButton2);
        Button updateTime = (Button)findViewById(R.id.updateTime);


        //TextView displayPost = (TextView)findViewById(R.id.currentPost);

        Log.d("in onCreate", Integer.toString(position));

        final Post currentPost = posts.get(position);

        //displayPost.setText(currentPost.toString());

        updateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = bodyText.getText().toString();
                currentPost.setText(newText);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInFile();
                finish();
            }
        });

        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anger anger = new Anger();
                currentPost.setMood(anger);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fear fear = new Fear();
                currentPost.setMood(fear);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Joy joy = new Joy();
                currentPost.setMood(joy);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Love love = new Love();
                currentPost.setMood(love);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        sadnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sadness sadness = new Sadness();
                currentPost.setMood(sadness);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Surprise surprise = new Surprise();
                currentPost.setMood(surprise);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });

        updateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = bodyText.getText().toString();
                currentPost.setDate(date);
                saveInFile();
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    protected void onStart(){
        super.onStart();
        //this will retrieve the position of the correct post
        Log.d("in Onstart", Integer.toString(position));
        neededPost.add(posts.get(position));
        adapter = new ArrayAdapter<Post>(this, R.layout.list_item, neededPost);
        displayPost.setAdapter(adapter);
    }

    private void saveInFile() {
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

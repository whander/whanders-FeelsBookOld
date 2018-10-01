package com.example.whanders_feelsbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class HistoryActivity extends Activity {
    //intializes all the variables used in the HistoryActivity, primarily anything related the the older posts
    public ListView getOldPostsList() {
        return oldPostsList;
    }
    private ListView oldPostsList;
    public ArrayList<Post> getPosts() {
        return posts;
    }
    private ArrayList<Post> posts = StartActivity.posts;
    private ArrayAdapter<Post> adapter;

    //private HistoryActivity activity2 = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);

        //loads all the old posts into a listview.
        oldPostsList = (ListView) findViewById(R.id.oldPostsList); //view

        final Button Delete = (Button)findViewById(R.id.delete);
        final Button Edit = (Button)findViewById(R.id.edit);

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //returns user to main menu
        Button backButton = (Button)findViewById(R.id.backButtonId);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchMain = new Intent(HistoryActivity.this, StartActivity.class);
                startActivity(switchMain);
            }
        });

        //allows someone to choose a post and then select whether you want to edit or delete it
        oldPostsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			    Edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(HistoryActivity.this, EditActivity.class);
                        startActivity(intent);
                    }
                });

			}
		});
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Post>(this, R.layout.list_item, posts);
        oldPostsList.setAdapter(adapter);
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(StartActivity.FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-09-22
            Type listType = new TypeToken<ArrayList<Post>>(){}.getType();
            posts = gson.fromJson(in, listType);
            Log.d("whanders", "done");
        } catch (FileNotFoundException e) {
            posts = new ArrayList<Post>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
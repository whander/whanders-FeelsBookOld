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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;

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
			public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

			    Edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent switchToEdit = new Intent(HistoryActivity.this, EditActivity.class);
                        switchToEdit.putExtra("position", position);
                        startActivity(switchToEdit);
                    }
                });

			    Delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        posts.remove(position);
                        saveInFile();
                        adapter.notifyDataSetChanged();
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
        sort();
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
        } catch (FileNotFoundException e) {
            posts = new ArrayList<Post>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    private void sort(){
        for (int x = 0; x < posts.size(); x++){
            for (int y = 0; y < posts.size(); y++){
                if (posts.get(x).getDate().before(posts.get(y).getDate())){
                    Post temp = posts.get(x);
                    posts.set(x, posts.get(y));
                    posts.set(y, temp);
                }
            }
        }

    }

}
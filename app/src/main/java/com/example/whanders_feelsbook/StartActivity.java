package com.example.whanders_feelsbook;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//Code borrowed from https://github.com/joshua2ua/lonelyTwitter/tree/f15tuesday and edited. Code for LonelyTwitteActivity, onCreate, onStart, SaveInFile, LoadFromFile, ImportantPost, Post, NormalPost, PostTooLongException.

public class StartActivity extends Activity {

    protected static final String FILENAME = "file.sav";
    private StartActivity activity = this;
    protected static Post temp;

    //public Button getSaveButton() {
    //	return saveButton;
    //}

    //private Button saveButton;

    /*public EditText getBodyText() {
        return bodyText;
    }

    private EditText bodyText;

    */

   /* public ListView getOldPostsList() {
        return oldPostsList;
    }

    private ListView oldPostsList;


    public ArrayList<Post> getPosts() {
        return posts;
    }

*/
    protected static ArrayList<Post> posts = new ArrayList<Post>();
//    protected ArrayAdapter<Post> adapter;




    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); // view
        setContentView(R.layout.activity_start); // view

        Button historyButton = (Button)findViewById(R.id.historyButton);
        Button AngerButton = (Button)findViewById(R.id.angerButton);
        Button fearButton = (Button)findViewById(R.id.fearButton);
        Button joyButton = (Button)findViewById(R.id.joyButton);
        Button loveButton = (Button)findViewById(R.id.loveButton);
        Button sadnessButton = (Button)findViewById(R.id.sadnessButton);
        Button surpriseButton = (Button)findViewById(R.id.surpriseButton);
        Button countButton = (Button)findViewById(R.id.countButton);

       // bodyText = (EditText) findViewById(R.id.body);
     //   oldPostList = (ListView) findViewById(R.id.oldPostList);


        historyButton.setOnClickListener(new View.OnClickListener() {
            //Log.d("whanders", "got to the listener");
            public void onClick(View v) {
                Intent switchToHistory = new Intent(StartActivity.this, HistoryActivity.class);
                //Log.d("whanders", "added intent fine");
                startActivity(switchToHistory);

            }
        });

        AngerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Anger anger = new Anger();
                setResult(RESULT_OK);
                //String text = bodyText.getText().toString(); //controller
                posts.add(new Post(anger)); // controller
               // adapter.notifyDataSetChanged(); // view
                //saveInFile(); // model
                Intent switchToAddText = new Intent(StartActivity.this, AddTextActivity.class);
                startActivity(switchToAddText);
            }
        });

        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Love love = new Love();
                setResult(RESULT_OK);
                //String text = bodyText.getText().toString(); //controller
                posts.add(new Post(love)); // controller
                // adapter.notifyDataSetChanged(); // view
                //saveInFile(); // model
                Intent switchToAddText = new Intent(StartActivity.this, AddTextActivity.class);
                startActivity(switchToAddText);
            }
        });

        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fear fear = new Fear();
                setResult(RESULT_OK);
                //String text = bodyText.getText().toString(); //controller
                posts.add(new Post(fear)); // controller
                // adapter.notifyDataSetChanged(); // view
                //saveInFile(); // model
                Intent switchToAddText = new Intent(StartActivity.this, AddTextActivity.class);
                startActivity(switchToAddText);
            }
        });

        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Joy joy = new Joy();
                setResult(RESULT_OK);
                //String text = bodyText.getText().toString(); //controller
                posts.add(new Post(joy)); // controller
                // adapter.notifyDataSetChanged(); // view
                //saveInFile(); // model
                Intent switchToAddText = new Intent(StartActivity.this, AddTextActivity.class);
                startActivity(switchToAddText);
            }
        });

        sadnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sadness sadness = new Sadness();
                setResult(RESULT_OK);
                //String text = bodyText.getText().toString(); //controller
                posts.add(new Post(sadness)); // controller
                // adapter.notifyDataSetChanged(); // view
                //saveInFile(); // model
                Intent switchToAddText = new Intent(StartActivity.this, AddTextActivity.class);
                startActivity(switchToAddText);
            }
        });

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Surprise surprise = new Surprise();
                setResult(RESULT_OK);
                //String text = bodyText.getText().toString(); //controller
                posts.add(new Post(surprise)); // controller
                // adapter.notifyDataSetChanged(); // view
                //saveInFile(); // model
                Intent switchToAddText = new Intent(StartActivity.this, AddTextActivity.class);
                startActivity(switchToAddText);
            }
        });

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("whander", "got to countButton");
                Intent switchtToCount = new Intent(StartActivity.this, EmotionCountActivity.class);
                startActivity(switchtToCount);
            }
        });

        //bodyText = (EditText) findViewById(R.id.body); //view
        //	saveButton = (Button) findViewById(R.id.save);
        //oldPostsList = (ListView) findViewById(R.id.oldPostsList); //view

		/*saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString(); //controller
				posts.add(new NormalPost(text)); // controller
				adapter.notifyDataSetChanged(); // view
				saveInFile(); // model
			}
		});*/

		/*oldPostsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(activity, EditPostActivity.class);
				startActivity(intent);
			}
		});*/
    }

   @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        loadFromFile();
        //adapter = new ArrayAdapter<Post>(this, R.layout.list_item, posts);
        //oldPostsList.setAdapter(adapter);
    }


   private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(StartActivity.FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html 2015-09-22
            Type listType = new TypeToken<ArrayList<Post>>() {}.getType();
            posts = gson.fromJson(in, listType);
        } catch (FileNotFoundException e) {
            posts = new ArrayList<Post>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
/*
    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
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
    }*/
}//end activity

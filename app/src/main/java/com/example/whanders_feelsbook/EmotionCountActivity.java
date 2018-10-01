package com.example.whanders_feelsbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EmotionCountActivity extends Activity {
    //intializes all variables used in EmotionCountActivity
    private int angercount = 0;
    private int fearcount=0;
    private int joycount=0;
    private int lovecount=0;
    private int sadnesscount=0;
    private int surprisecount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count); // view

        //intializes all the textviews of the layout
        TextView angerCount = (TextView)findViewById(R.id.angerCount);
        TextView fearCount = (TextView)findViewById(R.id.fearCount);
        TextView joyCount = (TextView)findViewById(R.id.joyCount);
        TextView loveCount = (TextView)findViewById(R.id.loveCount);
        TextView sadnessCount = (TextView)findViewById(R.id.sadnessCount);
        TextView surpriseCount = (TextView)findViewById(R.id.surpriseCount);

        //num is used in the for loop to tell when to stop
        int num = StartActivity.posts.size();

        //this for loop checks all the previous posts to count the number of times each emotion occurs
        for (int i = 0; i < num; i++){
            if (StartActivity.posts.get(i).getType().equalsIgnoreCase("Anger")){
                angercount++;
            }else if (StartActivity.posts.get(i).getType().equalsIgnoreCase("Fear")){
                fearcount++;
            }else if (StartActivity.posts.get(i).getType().equalsIgnoreCase("Joy")){
                joycount++;
            }else if (StartActivity.posts.get(i).getType().equalsIgnoreCase("Love")){
                lovecount++;
            }else if (StartActivity.posts.get(i).getType().equalsIgnoreCase("Sadness")){
                sadnesscount++;
            }else if (StartActivity.posts.get(i).getType().equalsIgnoreCase("Surprise")) {
                surprisecount++;
            }
        }//end for loop

        //this displays the values that were counted
        angerCount.setText("Anger: " + Integer.toString(angercount));
        fearCount.setText("Fear: " + Integer.toString(fearcount));
        joyCount.setText("Joy: " + Integer.toString(joycount));
        loveCount.setText("Love: " + Integer.toString(lovecount));
        sadnessCount.setText("Sadness: " + Integer.toString(sadnesscount));
        surpriseCount.setText("Surprise: " + Integer.toString(surprisecount));

        Button backButton = (Button)findViewById(R.id.backButtonId2);

        //this button takes the user back to the main menu
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchMain = new Intent(EmotionCountActivity.this, StartActivity.class);
                startActivity(switchMain);
            }
        });


    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
    }


}

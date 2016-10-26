package com.example.youngki.memory_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.HashMap;

public class showTestOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_test_options);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf");
        Button button = (Button)findViewById(R.id.buttonLetterToNumber);
        button.setTypeface(type);
        button = (Button)findViewById(R.id.buttonMatching);
        button.setTypeface(type);
        button = (Button)findViewById(R.id.buttonMatching2);
        button.setTypeface(type);

        // here is the stored hashmap
        //if gson error add to gradlefile like here:
        //http://stackoverflow.com/questions/18555135/the-best-way-to-integrate-third-party-library-in-android-studio

        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        if (wrapperStr == null){
            //TODO: here a map was not created
        }

    }


    public void onLetterToNumberButtonClicked(View v){
        Intent testOpener = new Intent(this,showTest.class);
        startActivity(testOpener);
    }

    public void onMatchingButtonClicked(View v) {
        Intent testOpener = new Intent(this, matchingTest.class);
        startActivity(testOpener);
    }

    public void on2Clicked(View v) {
        Intent test2Opener = new Intent(this, matchingTest2.class);
        startActivity(test2Opener);
    }

    @Override
    public void onBackPressed(){
        Intent mainWindowOpener = new Intent(this,MainActivity.class);
        startActivity(mainWindowOpener);
    }
}

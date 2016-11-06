package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.gson.Gson;
import android.content.SharedPreferences;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

public class repetitionTraining extends AppCompatActivity {

    private MapWrapper memMapWrap;
    int count = 0;
    String[] keys;
    Integer[] values;
    String letter;
    int number;
    int text = 0;
    Boolean done = Boolean.FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repetition_training);
        nextPair();
        setLetters();
        setNumbers();
    }

    public void nextPair(){
        if (done == Boolean.FALSE){
            this.letter = this.keys[count];
            this.number = this.values[count];
            count = count + 1;
            if (count > keys.length){
                done = Boolean.TRUE;
            }
        }
        else{
            Intent windowOpener = new Intent(this,showTrainOptions.class);
            startActivity(windowOpener);
        }
    }

    public void setLetters(){
        String a = letter + " " + letter + " " + letter + " " + letter + " " + letter;
        String b = letter + " " + letter;
        TextView tv = (TextView) findViewById(R.id.textView0);
        tv.setText(a);
        tv = (TextView) findViewById(R.id.textView2);
        tv.setText(b);
        tv = (TextView) findViewById(R.id.textView4);
        tv.setText(b);
        tv = (TextView) findViewById(R.id.textView6);
        tv.setText(letter);
        tv = (TextView) findViewById(R.id.textView8);
        tv.setText(letter);
        tv = (TextView) findViewById(R.id.textView10);
        tv.setText(letter);
        tv = (TextView) findViewById(R.id.textView12);
        tv.setText(letter);
        tv = (TextView) findViewById(R.id.textView14);
        tv.setText(letter);
    }

    public void setNumbers(){
        String n = Integer.toString(number);
        String a = n + " " + n + " " + n + " " + n + " " + n;
        String b = n + " " + n;
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(a);
        tv = (TextView) findViewById(R.id.textView3);
        tv.setText(b);
        tv = (TextView) findViewById(R.id.textView5);
        tv.setText(b);
        tv = (TextView) findViewById(R.id.textView7);
        tv.setText(n);
        tv = (TextView) findViewById(R.id.textView9);
        tv.setText(n);
        tv = (TextView) findViewById(R.id.textView11);
        tv.setText(n);
        tv = (TextView) findViewById(R.id.textView13);
        tv.setText(n);
        tv = (TextView) findViewById(R.id.textView15);
        tv.setText(n);
    }

    public void makeBold(){
        TextView tv;
        switch (text) {
            case 0:
                tv = (TextView) findViewById(R.id.textView0);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 1:
                tv = (TextView) findViewById(R.id.textView1);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 2:
                tv = (TextView) findViewById(R.id.textView2);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 3:
                tv = (TextView) findViewById(R.id.textView3);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 4:
                tv = (TextView) findViewById(R.id.textView4);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 5:
                tv = (TextView) findViewById(R.id.textView5);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 6:
                tv = (TextView) findViewById(R.id.textView6);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 7:
                tv = (TextView) findViewById(R.id.textView7);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 8:
                tv = (TextView) findViewById(R.id.textView8);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 9:
                tv = (TextView) findViewById(R.id.textView9);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 10:
                tv = (TextView) findViewById(R.id.textView10);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 11:
                tv = (TextView) findViewById(R.id.textView11);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 12:
                tv = (TextView) findViewById(R.id.textView12);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 13:
                tv = (TextView) findViewById(R.id.textView13);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 14:
                tv = (TextView) findViewById(R.id.textView14);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case 15:
                tv = (TextView) findViewById(R.id.textView15);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                break;
        }
        if (text == 15){
            text = 0;
            nextPair();
        }
        else{
            text++;
        }
    }

    public void onClick(View v){
        makeBold();

    }
}

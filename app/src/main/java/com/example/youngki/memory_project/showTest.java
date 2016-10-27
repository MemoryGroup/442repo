package com.example.youngki.memory_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import java.util.HashMap;


public class showTest extends AppCompatActivity {

    private MapWrapper memMapWrap;

    String[] keys;
    Integer[] values;
    String showThis;
    int count = 0;
    HashMap<String, Integer> correct = new HashMap<>();
    //String [] correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //have to access sharedpreferences in onCreate
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);
        this.showThis = this.keys[0];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //    setMemoryMap(memoryMap);
        TextView tv = (TextView) findViewById(R.id.textView3);
        //    this.showThis = this.keys[3];
        tv.setText(this.showThis);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setMax(keys.length);

    }


	 @Override
    protected void onCreate(Bundle savedInstanceState) {
        //have to access sharedpreferences in onCreate
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);
        this.showThis = this.keys[0];

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //    setMemoryMap(memoryMap);
        TextView tv = (TextView) findViewById(R.id.textView3);
        //    this.showThis = this.keys[3];
        tv.setText(this.showThis);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setMax(keys.length);

    }

    public void showResultsNow(){
        Intent resultsWindowOpener = new Intent(this,showResults.class);
        //resultsWindowOpener.putExtra("correct", correct);
        startActivity(resultsWindowOpener);
    }

    public void getNextLetter(){
        this.count = this.count + 1;
        if (count < keys.length){
            this.showThis = this.keys[this.count];
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setText(showThis);
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
            pb.incrementProgressBy(1);
        }
        else{
            showResultsNow();
        }
    }

    public void onOneClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 1){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onTwoClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 2){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onThreeClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 3){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onFourClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 4){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onFiveClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 5){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onSixClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 6){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onSevenClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 7){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onEightClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 8){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onNineClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 9){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }

    public void onZeroClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 0){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
        }
        else{
            tv.setText(R.string._incorrect);
        }
        getNextLetter();
    }


}

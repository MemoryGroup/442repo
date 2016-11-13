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
    HashMap<String, Integer> streakMap = new HashMap<>();
    HashMap<String, Integer> timesCorrectMap = new HashMap<>();
    HashMap<String, Integer> totalAttemptsMap = new HashMap<>();


    //String [] correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //have to access shared preferences in onCreate
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper MemWrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = MemWrapper.getKeys();
        this.values = MemWrapper.getValues(keys);
        this.showThis = this.keys[0]; //show the first key


        String streakStr = prefs.getString("streakMap", null);
        MapWrapper streakWrapper = gson.fromJson(streakStr, MapWrapper.class);
        this.streakMap = streakWrapper.getMap();

        String correctStr = prefs.getString("timesCorrectMap", null);
        MapWrapper correctWrapper = gson.fromJson(correctStr, MapWrapper.class);
        this.timesCorrectMap = correctWrapper.getMap();

        String attemptsStr = prefs.getString("totalAttemptsMap", null);
        MapWrapper attemptsWrapper = gson.fromJson(attemptsStr, MapWrapper.class);
        this.totalAttemptsMap = attemptsWrapper.getMap();



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //    setMemoryMap(memoryMap);
        TextView tv = (TextView) findViewById(R.id.textView3);
        //    this.showThis = this.keys[3];
        tv.setText(this.showThis);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setMax(keys.length);

    }


    public void onPause(){
        //save the data onpause
        super.onPause();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();

        MapWrapper streakWrap = new MapWrapper();
        streakWrap.setMap(streakMap);
        String serializedStreak = gson.toJson(streakWrap);
        editor.putString("streakMap", serializedStreak);

        MapWrapper correctWrap = new MapWrapper();
        correctWrap.setMap(timesCorrectMap);
        String serializedCorrect = gson.toJson(correctWrap);
        editor.putString("timesCorrectMap", serializedCorrect);

        MapWrapper attemptsWrap = new MapWrapper();
        attemptsWrap.setMap(totalAttemptsMap);
        String serializedAttempts = gson.toJson(attemptsWrap);
        editor.putString("totalAttemptsMap", serializedAttempts);

        editor.apply(); //persist the values
    }

    public void showResultsNow(){
        //currently correct is not used
        //Implemented an alternate result display
        // Intent resultsWindowOpener = new Intent(this,showResults.class);

        //resultsWindowOpener.putExtra("correct", correct);

        Intent resultsWindowOpener = new Intent(this,showResultsOpt2.class);
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
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
            pb.incrementProgressBy(1);

            showResultsNow();
        }
    }

    public void onOneClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 1){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);

        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);

        getNextLetter();
    }

    public void onTwoClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 2){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onThreeClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 3){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onFourClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 4){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onFiveClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 5){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onSixClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 6){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onSevenClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 7){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onEightClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 8){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onNineClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 9){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }

    public void onZeroClicked(View view){
        TextView tv = (TextView) findViewById(R.id.textView10);
        if (values[count] == 0){
            correct.put(keys[count], values[count]);
            tv.setText(R.string._correct);
            streakMap.put(keys[count], streakMap.get(keys[count])+1);
            timesCorrectMap.put(keys[count], timesCorrectMap.get(keys[count])+1);
        }
        else{
            tv.setText(R.string._incorrect);
            streakMap.put(keys[count], 0);
        }

        totalAttemptsMap.put(keys[count], totalAttemptsMap.get(keys[count])+1);
        getNextLetter();
    }


}

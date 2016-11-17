package com.youngki.memory_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class showResultsOpt2 extends AppCompatActivity {

    String[] keys;
    Integer[] values;
    HashMap<String, Integer> streakMap = new HashMap<>();
    HashMap<String, Integer> timesCorrectMap = new HashMap<>();
    HashMap<String, Integer> totalAttemptsMap = new HashMap<>();
    ArrayList<showResultsOpt2Column > scoreList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper MemWrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = MemWrapper.getKeys();
        Arrays.sort(this.keys); //sorted alphabetically
        this.values = MemWrapper.getValues(keys);

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
        setContentView(R.layout.view_score);
        this.findViewById(android.R.id.content).setBackgroundColor(Color.parseColor("#d3d3d3"));

        int numRows = values.length;
        if(numRows == 0){
        }else{

            showResultsOpt2Column  temp1 = new showResultsOpt2Column
                    ("Letter", "Number", "Correct", "Overall");
            scoreList.add(0,temp1);

            for(int i = 0; i < keys.length; i++){
                Integer acc = (int)((timesCorrectMap.get(keys[i]) * 1.0 /
                        totalAttemptsMap.get(keys[i]))*100);
                String curCorrect = "";
                String curAcc = acc.toString() + "%";
                if (streakMap.get(keys[i]) == 0){
                    curCorrect = "\u2716";
                }else{
                    curCorrect = "\u2713";
                }

                showResultsOpt2Column  temp = new showResultsOpt2Column
                        (keys[i],values[i].toString(), curCorrect, curAcc);
                scoreList.add(i+1,temp);
            }
            showResultsOpt2Format scoreboard = new showResultsOpt2Format
                                                (this,R.layout.progress_layout, scoreList);
            listView = (ListView) findViewById(R.id.scoreView);
            listView.setAdapter(scoreboard);
        }
    }

    public void onBackPressed(){
        Intent testsWindowOpener = new Intent(this,showTestOptions.class);
        startActivity(testsWindowOpener);
    }
}

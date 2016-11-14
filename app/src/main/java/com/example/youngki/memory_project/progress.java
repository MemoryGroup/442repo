package com.example.youngki.memory_project;

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


public class progress extends AppCompatActivity {

    String[] keys;
    Integer[] values;
    HashMap<String, Integer> streakMap = new HashMap<>();
    HashMap<String, Integer> timesCorrectMap = new HashMap<>();
    HashMap<String, Integer> totalAttemptsMap = new HashMap<>();
    ArrayList<progress_column> scoreList = new ArrayList<>();
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
            // TODO Error check here
        }else{

            progress_column temp1 = new progress_column
                    ("Letter", "Number", "Accuracy", "Streak");
            scoreList.add(0,temp1);

            for(int i = 0; i < keys.length; i++){
                Integer acc = (int)((timesCorrectMap.get(keys[i]) * 1.0 /
                                totalAttemptsMap.get(keys[i]))*100);
                String curStreak = streakMap.get(keys[i]).toString();
                String curAcc = acc.toString() + "%";
                if (totalAttemptsMap.get(keys[i]) == 0){
                    curStreak = "-";
                    curAcc = "-";
                }

                progress_column temp = new progress_column
                        (keys[i],values[i].toString(), curAcc, curStreak);
                scoreList.add(i+1,temp);
            }
            progress_format scoreboard = new progress_format(this,R.layout.progress_layout, scoreList);
            listView = (ListView) findViewById(R.id.scoreView);
            listView.setAdapter(scoreboard);
        }
    }
}

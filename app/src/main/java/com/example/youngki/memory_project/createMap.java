package com.example.youngki.memory_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import android.graphics.Typeface;

import android.content.SharedPreferences;
import com.google.gson.Gson;

public class createMap extends AppCompatActivity {

  private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  HashMap<String, Integer> memMap = new HashMap<>();
  int mapLetters =  2;
  int mapDigits = 2;
  Boolean hasGenerated = false;

  Level level = Level.EASY;

  // given amount of letters
  // and digits, make a new Memory Map stored in memMap
  public void makeNewMap(int letters, int digits) {
    String letterMap = ALPHABETS;
    ArrayList<Integer> usedDigits = new ArrayList<Integer>(digits);
    for (int i = 0; i < 10; i++) {
      usedDigits.add(i);
    }
    Collections.shuffle(usedDigits);
    usedDigits.subList(digits, usedDigits.size()).clear();
    // now add the randomized digits
    memMap.clear();
    for (int i = 0; i < letters; i++) {
      //randomize digits here, if we have used all of the digits then shuffle them again
      if (i % digits == 0) {
        Collections.shuffle(usedDigits);
      }
      memMap.put(letterMap.substring(i, i + 1), usedDigits.get(i % digits));
    }
  }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_map);

    }

  public void onAddLettersClicked(View v) {
    level.incrementLetter();
    //return the max of
  }

  public void onSubLettersClicked(View v) {
    level.decrementLetter();
  }

  public void onAddNumbersClicked(View v) {
    level.incrementDigit();
  }

  public void onSubNumbersClicked(View v) {
    level.decrementDigit();
  }

  public void onGenerateClicked(View v) {
    //now get the maps with default: 7 letters and 3 numbers for easy
    makeNewMap(level.letters(), level.digits());
    String letterMap = ALPHABETS;
    String displayLetters = "";
	String displayNumbers = "";
    int mapLetters = level.letters();
    for (int i = 0; i < mapLetters; i++) {
      String curLetter = letterMap.substring(i, i + 1);
      int curNumber = memMap.get(curLetter);
      displayLetters += curLetter + ":" + curNumber + "  ";
      if (i != 0 && i % 4 == 0 && mapLetters != 4) {
        displayLetters += "\n";
      }
    }
    TextView mapView = (TextView) findViewById(R.id.letterText);
    mapView.setText(displayLetters);
    mapView.setTextSize(20);
    mapView.setHeight(500);
    mapView.setWidth(500);
    //setContentView(mapView);
	hasGenerated = true;
  }

  public void onNewEasyClicked(View v) {
    TextView titleView = (TextView) findViewById(R.id.longText);
    titleView.setText(getResources().getString(R.string.mapInfoEasy));
    titleView.setTextSize(12);
    Button easy = (Button) findViewById(R.id.easy);
    easy.setTypeface(null, Typeface.BOLD);
    Button medium = (Button) findViewById(R.id.medium);
    medium.setTypeface(null, Typeface.NORMAL);
    Button hard = (Button) findViewById(R.id.hard);
    hard.setTypeface(null, Typeface.NORMAL);
    level = Level.EASY;
  }

  public void onNewMediumClicked(View v) {
    TextView titleView = (TextView) findViewById(R.id.longText);
    titleView.setText(getResources().getString(R.string.mapInfoMedium));
    titleView.setTextSize(12);
    Button easy = (Button) findViewById(R.id.easy);
    easy.setTypeface(null, Typeface.NORMAL);
    Button medium = (Button) findViewById(R.id.medium);
    medium.setTypeface(null, Typeface.BOLD);
    Button hard = (Button) findViewById(R.id.hard);
    hard.setTypeface(null, Typeface.NORMAL);
    level = Level.MEDIUM;
  }

  public void onNewHardClicked(View v) {
    TextView titleView = (TextView) findViewById(R.id.longText);
    titleView.setText(getResources().getString(R.string.mapInfoHard));
    titleView.setTextSize(12);
    Button easy = (Button) findViewById(R.id.easy);
    easy.setTypeface(null, Typeface.NORMAL);
    Button medium = (Button) findViewById(R.id.medium);
    medium.setTypeface(null, Typeface.NORMAL);
    Button hard = (Button) findViewById(R.id.hard);
    hard.setTypeface(null, Typeface.BOLD);
    level = Level.HARD;
  }
  
public void onNewTrainClicked(View v){
	
    if(hasGenerated == false){
        return;
    }

    Gson gson = new Gson();
    MapWrapper wrapper = new MapWrapper();
    wrapper.setMap(memMap);
    String serializedMap = gson.toJson(wrapper);
    SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
    editor.putString("memMap", serializedMap);
	editor.commit();
    }
}
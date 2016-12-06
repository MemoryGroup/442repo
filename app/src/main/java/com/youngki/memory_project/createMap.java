package com.youngki.memory_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class createMap extends AppCompatActivity {

    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, Integer> memMap = new HashMap<>();
    int mapLetters = 2;
    int mapDigits = 2;
    Boolean hasGenerated = false;
    GridLayout dynamicGridLayout;
    Level level = Level.EASY;
    private int[] colors = new int[10];

   /**
   * Convert Dp to Pixel
   */
    public static int dpToPx(float dp, Resources resources) {
        float px =
            TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }

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
        dynamicGridLayout = (GridLayout) findViewById(R.id.dynamicGridLayout);
        colors[0] = ContextCompat.getColor(this, R.color.red);
        colors[1] = ContextCompat.getColor(this, R.color.orange);
        colors[2] = ContextCompat.getColor(this, R.color.yellow);
        colors[3] = ContextCompat.getColor(this, R.color.green);
        colors[4] = ContextCompat.getColor(this, R.color.blue);
        colors[5] = ContextCompat.getColor(this, R.color.purple);
        colors[6] = ContextCompat.getColor(this, R.color.pink);
        colors[7] = ContextCompat.getColor(this, R.color.teal);
        colors[8] = ContextCompat.getColor(this, R.color.tan);
        colors[9] = ContextCompat.getColor(this, R.color.gray);
    }

    public void onAddLettersClicked(View v) {
        level.incrementLetter();
        onGenerateClicked(null);
        //return the max of
    }

    public void onSubLettersClicked(View v) {
        level.decrementLetter();
        onGenerateClicked(null);
    }

    public void onAddNumbersClicked(View v) {
        level.incrementDigit();
        onGenerateClicked(null);
    }

    public void onSubNumbersClicked(View v) {
        level.decrementDigit();
        onGenerateClicked(null);
    }

    public void onGenerateClicked(View v) {
        //now get the maps with default: 7 letters and 3 numbers for easy
        makeNewMap(level.letters(), level.digits());
        String letterMap = ALPHABETS;
        int mapLetters = level.letters();
        dynamicGridLayout.removeAllViews();
        for (int i = 0; i < mapLetters; i++) {
            String curLetter = letterMap.substring(i, i + 1);
            int curNumber = memMap.get(curLetter);
            Button button = new Button(this);
            ViewGroup.MarginLayoutParams marginLayoutParams =
              new ViewGroup.MarginLayoutParams(dpToPx(48, getResources()), dpToPx(48, getResources()));
            marginLayoutParams.rightMargin = dpToPx(5, getResources());
            marginLayoutParams.bottomMargin = dpToPx(5, getResources());
            button.setLayoutParams(new GridLayout.LayoutParams(marginLayoutParams));
            button.setBackgroundColor(colors[curNumber]);
            dynamicGridLayout.addView(button);
            button.setGravity(Gravity.CENTER);
            button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            button.setText(curLetter + ":" + curNumber);
        }
        //TextView mapView = (TextView) findViewById(R.id.letterText);
        //mapView.setText(displayLetters);
        //mapView.setTextSize(20);
        //mapView.setHeight(500);
        //mapView.setWidth(500);
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
        onGenerateClicked(null);
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
        onGenerateClicked(null);
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
        onGenerateClicked(null);
    }

    public void onNewTrainClicked(View v) {
        if (hasGenerated == false) {
            return;
        }
        HashMap<String, Integer> progress_map = new HashMap<>();
        for (String key : memMap.keySet()) {
            progress_map.put(key, 0);
        }
        Gson gson = new Gson();
        MapWrapper mem = new MapWrapper();
        mem.setMap(memMap);
        String serializedMap = gson.toJson(mem);
        SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
        editor.putString("memMap", serializedMap);
        MapWrapper progress = new MapWrapper();
        progress.setMap(progress_map);
        String serializedProgress = gson.toJson(progress);
        editor.putString("streakMap", serializedProgress);
        editor.putString("timesCorrectMap", serializedProgress);
        editor.putString("totalAttemptsMap", serializedProgress);
        editor.apply(); //persist the values
        startActivity(new Intent(this, showTrainOptions.class));
    }

    //public void onCustomClick(View v){
    //    Intent generateMapWindowOpener = new Intent(this, custom_map.class);
    //    startActivity(generateMapWindowOpener);
    //}
}
package com.youngki.memory_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;

public class matchingTest2 extends AppCompatActivity {

    String[] keys;
    Integer[] values;
    String key = "";
    int length;
    int currentColor = Color.rgb(255,255,255);
    int aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW,
        aX, aY, aZ;
    int answer;
    int currentNum = 0;
    HashMap<String, Integer> memMap = new HashMap<>();
    HashMap<String, Integer> streakMap = new HashMap<>();
    HashMap<String, Integer> timesCorrectMap = new HashMap<>();
    HashMap<String, Integer> totalAttemptsMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);
        length = keys.length;
        this.memMap = wrapper.getMap();

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
        setContentView(R.layout.activity_matching_test2);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf");
        Button b = (Button) findViewById(R.id.button6);
        b.setTypeface(type);
        hideLetters();
        findKs();
    }

    /* Find the letters used in the map and set the answer keys. */
    public void findKs(){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int j = 0; j < alphabet.length(); j++){
            String l = alphabet.substring(j, j + 1);
            if (memMap.containsKey(l)){
                key = key.concat(l);
            }
        }
        for(int i = 0; i < length; i++){
            String l = key.substring(i, i + 1);
            setButtons(i, l);
        }
    }

    /* Set the correct answer for a specific button. */
    public void setButtons(int pos, String i) {
        Button b;
        switch (pos) {
            case 0:
                b = (Button) findViewById(R.id.buttonA);
                b.setText(i);
                break;
            case 1:
                b = (Button) findViewById(R.id.buttonB);
                b.setText(i);
                break;
            case 2:
                b = (Button) findViewById(R.id.buttonC);
                b.setText(i);
                break;
            case 3:
                b = (Button) findViewById(R.id.buttonD);
                b.setText(i);
                break;
            case 4:
                b = (Button) findViewById(R.id.buttonE);
                b.setText(i);
                break;
            case 5:
                b = (Button) findViewById(R.id.buttonF);
                b.setText(i);
                break;
            case 6:
                b = (Button) findViewById(R.id.buttonG);
                b.setText(i);
                break;
            case 7:
                b = (Button) findViewById(R.id.buttonH);
                b.setText(i);
                break;
            case 8:
                b = (Button) findViewById(R.id.buttonI);
                b.setText(i);
                break;
            case 9:
                b = (Button) findViewById(R.id.buttonJ);
                b.setText(i);
                break;
            case 10:
                b = (Button) findViewById(R.id.buttonK);
                b.setText(i);
                break;
            case 11:
                b = (Button) findViewById(R.id.buttonL);
                b.setText(i);
                break;
            case 12:
                b = (Button) findViewById(R.id.buttonM);
                b.setText(i);
                break;
            case 13:
                b = (Button) findViewById(R.id.buttonN);
                b.setText(i);
                break;
            case 14:
                b = (Button) findViewById(R.id.buttonO);
                b.setText(i);
                break;
            case 15:
                b = (Button) findViewById(R.id.buttonP);
                b.setText(i);
                break;
            case 16:
                b = (Button) findViewById(R.id.buttonQ);
                b.setText(i);
                break;
            case 17:
                b = (Button) findViewById(R.id.buttonR);
                b.setText(i);
                break;
            case 18:
                b = (Button) findViewById(R.id.buttonS);
                b.setText(i);
                break;
            case 19:
                b = (Button) findViewById(R.id.buttonT);
                b.setText(i);
                break;
            case 20:
                b = (Button) findViewById(R.id.buttonU);
                b.setText(i);
                break;
            case 21:
                b = (Button) findViewById(R.id.buttonV);
                b.setText(i);
                break;
            case 22:
                b = (Button) findViewById(R.id.buttonW);
                b.setText(i);
                break;
            case 23:
                b = (Button) findViewById(R.id.buttonX);
                b.setText(i);
                break;
            case 24:
                b = (Button) findViewById(R.id.buttonY);
                b.setText(i);
                break;
            case 25:
                b = (Button) findViewById(R.id.buttonZ);
                b.setText(i);
                break;
        }
    }

    /* Set button's alpha to 0 so it isn't visible. */
    public void hide(int i){
        Button button = (Button) findViewById(i);
        button.setAlpha(0);
    }

    /* Hide the letter buttons not needed. */
    public void hideLetters(){
        int i = 26 - length;
        switch (i){
            case 26:
                hide(R.id.buttonA);
            case 25:
                hide(R.id.buttonB);
            case 24:
                hide(R.id.buttonC);
            case 23:
                hide(R.id.buttonD);
            case 22:
                hide(R.id.buttonE);
            case 21:
                hide(R.id.buttonF);
            case 20:
                hide(R.id.buttonG);
            case 19:
                hide(R.id.buttonH);
            case 18:
                hide(R.id.buttonI);
            case 17:
                hide(R.id.buttonJ);
            case 16:
                hide(R.id.buttonK);
            case 15:
                hide(R.id.buttonL);
            case 14:
                hide(R.id.buttonM);
            case 13:
                hide(R.id.buttonN);
            case 12:
                hide(R.id.buttonO);
            case 11:
                hide(R.id.buttonP);
            case 10:
                hide(R.id.buttonQ);
            case 9:
                hide(R.id.buttonR);
            case 8:
                hide(R.id.buttonS);
            case 7:
                hide(R.id.buttonT);
            case 6:
                hide(R.id.buttonU);
            case 5:
                hide(R.id.buttonV);
            case 4:
                hide(R.id.buttonW);
            case 3:
                hide(R.id.buttonX);
            case 2:
                hide(R.id.buttonY);
            case 1:
                hide(R.id.buttonZ);
                break;
        }
    }

    /* Check and save the answers. */
    public void saveAnswers () {
        for (int i = 0; i < key.length(); i++) {
            String s = key.substring(i, i + 1);
            int correct = memMap.get(s);
            getAnswers(i+1);
            if (answer == correct) {
                streakMap.put(s, streakMap.get(s) + 1);
                timesCorrectMap.put(s, timesCorrectMap.get(s) + 1);
            }
            else {
                streakMap.put(s, 0);
            }
            totalAttemptsMap.put(s, totalAttemptsMap.get(s)+1);
        }
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

    /* Retrieve the answer for a specific button/position. */
    public void getAnswers(int i){
        switch (i) {
            case 26:
                answer = aZ;
                break;
            case 25:
                answer = aY;
                break;
            case 24:
                answer = aX;
                break;
            case 23:
                answer = aW;
                break;
            case 22:
                answer = aV;
                break;
            case 21:
                answer = aU;
                break;
            case 20:
                answer = aT;
                break;
            case 19:
                answer = aS;
                break;
            case 18:
                answer = aR;
                break;
            case 17:
                answer = aQ;
                break;
            case 16:
                answer = aP;
                break;
            case 15:
                answer = aO;
                break;
            case 14:
                answer = aN;
                break;
            case 13:
                answer = aM;
                break;
            case 12:
                answer = aL;
                break;
            case 11:
                answer = aK;
                break;
            case 10:
                answer = aJ;
                break;
            case 9:
                answer = aI;
                break;
            case 8:
                answer = aH;
                break;
            case 7:
                answer = aG;
                break;
            case 6:
                answer = aF;
                break;
            case 5:
                answer = aE;
                break;
            case 4:
                answer = aD;
                break;
            case 3:
                answer = aC;
                break;
            case 2:
                answer = aB;
                break;
            case 1:
                answer = aA;
                break;
        }
    }

    /* Get the number clicked on and set the color/number for answers. */
    public void onNumberClick(View v){
        int id = v.getId();
        if (id == R.id.button00){
            currentColor = Color.rgb(220,94,90);
            currentNum = 0;
        }
        else if (id == R.id.button01){
            currentColor = Color.rgb(238,178,104);
            currentNum = 1;
        }
        if (id == R.id.button02){
            currentColor = Color.rgb(247,232,118);
            currentNum = 2;
        }
        else if (id == R.id.button03){
            currentColor = Color.rgb(111,197,128);
            currentNum = 3;
        }
        if (id == R.id.button04){
            currentColor = Color.rgb(142,197,235);
            currentNum = 4;
        }
        else if (id == R.id.button05){
            currentColor = Color.rgb(175,134,204);
            currentNum = 5;
        }
        else if (id == R.id.button06){
            currentColor = Color.rgb(248,162,209);
            currentNum = 6;
        }
        else if (id == R.id.button07){
            currentColor = Color.rgb(144,181,178);
            currentNum = 7;
        }
        else if (id == R.id.button08){
            currentColor = Color.rgb(209,184,151);
            currentNum = 8;
        }
        else if (id == R.id.button09){
            currentColor = Color.rgb(202,201,201);
            currentNum = 9;
        }
    }

    /* Get the answers given and send to results screen. */
    public void onSubmitClick(View view){
        saveAnswers();
        Intent resultsWindowOpener = new Intent(this,showResultsOpt2.class);
        startActivity(resultsWindowOpener);
    }

    /* Get letter button clicked and set corresponding answer to the current number. */
    public void onClick(View v){
        int id = v.getId();
        Button b = (Button) findViewById(id);
        b.setBackgroundColor(currentColor);
        setAnswer(id);
    }

    /* Set the answer for a specific button/position. */
    public void setAnswer(int id){
        switch (id){
            case R.id.buttonA:
                aA = currentNum;
                break;
            case R.id.buttonB:
                aB = currentNum;
                break;
            case R.id.buttonC:
                aC = currentNum;
                break;
            case R.id.buttonD:
                aD = currentNum;
                break;
            case R.id.buttonE:
                aE = currentNum;
                break;
            case R.id.buttonF:
                aF = currentNum;
                break;
            case R.id.buttonG:
                aG = currentNum;
                break;
            case R.id.buttonH:
                aH = currentNum;
                break;
            case R.id.buttonI:
                aI = currentNum;
                break;
            case R.id.buttonJ:
                aJ = currentNum;
                break;
            case R.id.buttonK:
                aK = currentNum;
                break;
            case R.id.buttonL:
                aL = currentNum;
                break;
            case R.id.buttonM:
                aM = currentNum;
                break;
            case R.id.buttonN:
                aN = currentNum;
                break;
            case R.id.buttonO:
                aO = currentNum;
                break;
            case R.id.buttonP:
                aP = currentNum;
                break;
            case R.id.buttonQ:
                aQ = currentNum;
                break;
            case R.id.buttonR:
                aR = currentNum;
                break;
            case R.id.buttonS:
                aS = currentNum;
                break;
            case R.id.buttonT:
                aT = currentNum;
                break;
            case R.id.buttonU:
                aU = currentNum;
                break;
            case R.id.buttonV:
                aV = currentNum;
                break;
            case R.id.buttonW:
                aW = currentNum;
                break;
            case R.id.buttonX:
                aX = currentNum;
                break;
            case R.id.buttonY:
                aY = currentNum;
                break;
            case R.id.buttonZ:
                aZ = currentNum;
                break;
        }
    }
}

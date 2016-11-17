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
    int length;
    int i = 0;
    int currentColor = Color.rgb(255,255,255);
    int aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW,
        aX, aY, aZ;
    int kA, kB, kC, kD, kE, kF, kG, kH, kI, kJ, kK, kL, kM, kN, kO, kP, kQ, kR, kS, kT, kU, kV, kW,
            kX, kY, kZ;
    int currentNum = 0;
    HashMap<String, Integer> correct = new HashMap<>();
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
        hideNumbers();
        findKs();
    }

    public void findKs(){
        for(i = 0; i < length; i++){
            String s = keys[i];
            setKs(s, i);
        }
    }

    public void setKs(String s, int i){
        switch (s){
            case "A":
                kA = i;
                break;
            case "B":
                kB = i;
                break;
            case "C":
                kC = i;
                break;
            case "D":
                kD = i;
                break;
            case "E":
                kE = i;
                break;
            case "F":
                kF = i;
                break;
            case "G":
                kG = i;
                break;
            case "H":
                kH = i;
                break;
            case "I":
                kI = i;
                break;
            case "J":
                kJ = i;
                break;
            case "K":
                kK = i;
                break;
            case "L":
                kL = i;
                break;
            case "M":
                kM = i;
                break;
            case "N":
                kN = i;
                break;
            case "O":
                kO = i;
                break;
            case "P":
                kP = i;
                break;
            case "Q":
                kQ = i;
                break;
            case "R":
                kR = i;
                break;
            case "S":
                kS = i;
                break;
            case "T":
                kT = i;
                break;
            case "U":
                kU = i;
                break;
            case "V":
                kV = i;
                break;
            case "W":
                kW = i;
                break;
            case "X":
                kX = i;
                break;
            case "Y":
                kY = i;
                break;
            case "Z":
                kZ = i;
                break;
        }
    }

    public void hide(int i){
        Button button = (Button) findViewById(i);
        button.setAlpha(0);
    }

    public void hideNumbers(){
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

    public void saveAnswer(int a, int k){
        if (a == values[k]){
            streakMap.put(keys[k], streakMap.get(keys[k])+1);
            timesCorrectMap.put(keys[k], timesCorrectMap.get(keys[k])+1);
        }
        else{
            streakMap.put(keys[k], 0);
        }
        totalAttemptsMap.put(keys[k], totalAttemptsMap.get(keys[k])+1);
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

    public void getAnswers(){
        int i = length;
        switch (i){
            case 26:
                saveAnswer(aZ, kZ);
            case 25:
                saveAnswer(aY, kY);
            case 24:
                saveAnswer(aX, kX);
            case 23:
                saveAnswer(aW, kW);
            case 22:
                saveAnswer(aV, kV);
            case 21:
                saveAnswer(aU, kU);
            case 20:
                saveAnswer(aT, kT);
            case 19:
                saveAnswer(aS, kS);
            case 18:
                saveAnswer(aR, kR);
            case 17:
                saveAnswer(aQ, kQ);
            case 16:
                saveAnswer(aP, kP);
            case 15:
                saveAnswer(aO, kO);
            case 14:
                saveAnswer(aN, kN);
            case 13:
                saveAnswer(aM, kM);
            case 12:
                saveAnswer(aL, kL);
            case 11:
                saveAnswer(aK, kK);
            case 10:
                saveAnswer(aJ, kJ);
            case 9:
                saveAnswer(aI, kI);
            case 8:
                saveAnswer(aH, kH);
            case 7:
                saveAnswer(aG, kG);
            case 6:
                saveAnswer(aF, kF);
            case 5:
                saveAnswer(aE, kE);
            case 4:
                saveAnswer(aD, kD);
            case 3:
                saveAnswer(aC, kC);
            case 2:
                saveAnswer(aB, kB);
            case 1:
                saveAnswer(aA, kA);
                break;
        }
    }

    public void showResults(){
        getAnswers();
        Intent resultsWindowOpener = new Intent(this,showResultsOpt2.class);
        startActivity(resultsWindowOpener);
    }

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

    public void onSubmitClick(View view){
        showResults();
    }

    public void onClick(View v){
        int id = v.getId();
        Button b = (Button) findViewById(id);
        b.setBackgroundColor(currentColor);
        setAnswer(id);
    }

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

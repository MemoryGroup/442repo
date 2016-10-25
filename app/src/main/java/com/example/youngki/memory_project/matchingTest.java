package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.MotionEvent;
import android.graphics.Color;
import android.widget.Button;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class matchingTest extends AppCompatActivity {

    String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int length = keys.length;
    Boolean submit = Boolean.FALSE;
    int currentColor = Color.rgb(202,201,201);
    Integer[] numbers = {R.id.buttonA1, R.id.buttonB1, R.id.buttonC1, R.id.buttonD1};
    Integer[] letters = {R.id.buttonA0, R.id.buttonB0, R.id.buttonC0, R.id.buttonD0};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_test);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf");
        Button button = (Button)findViewById(R.id.buttonSubmit);
        button.setTypeface(type);
    }

    public void onSubmitClicked(View v){
        Button b = (Button) findViewById(R.id.buttonSubmit);
        if (submit == Boolean.FALSE){
            b.setText("next");
            submit = Boolean.TRUE;
        }
        else{
            b.setText("submit");
            submit = Boolean.FALSE;
            setNumbers();
            setLetters();
        }
    }

    public void showResults(){
        Intent resultsWindowOpener = new Intent(this,showResults.class);
        startActivity(resultsWindowOpener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        return super.onTouchEvent(e);
    }

    public void setNumbers(){
        
    }

    public void setLetters(){

    }

    public void onNumberClick(int id){
        if (id == R.id.buttonA1){
            currentColor = Color.rgb(142,197,235);
        }
        else if (id == R.id.buttonB1){
            currentColor = Color.rgb(111,197,128);
        }
        else if (id == R.id.buttonC1){
            currentColor = Color.rgb(220,94,90);
        }
        else if (id == R.id.buttonD1){
            currentColor = Color.rgb(175,134,204);
        }
    }

    public void onLetterClick(Button button){
        button.setBackgroundColor(currentColor);
    }

    public void onClick(View v){
        int id = v.getId();
        Button b = (Button) findViewById(id);
        for (int i =0; i < 4; i++){
            if (numbers[i] == id){
                onNumberClick(id);
            }
            else if (letters[i] == id){
                onLetterClick(b);
            }
        }
    }



}

package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class matchingTest2 extends AppCompatActivity {

    String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    int length = keys.length;
    int i = 0;
    int currentColor = Color.rgb(255,255,255);
    Integer[] numbers = {R.id.button00, R.id.button01, R.id.button02, R.id.button03, R.id.button04,
            R.id.button05, R.id.button06, R.id.button07, R.id.button08, R.id.button09};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_test2);

    }

    public void showResults(){
        Intent resultsWindowOpener = new Intent(this,showResults.class);
        startActivity(resultsWindowOpener);
    }

    public void onNumberClick(View v){
        int id = v.getId();
        if (id == R.id.button00){
            currentColor = Color.rgb(220,94,90);
        }
        else if (id == R.id.button01){
            currentColor = Color.rgb(238,178,104);
        }
        if (id == R.id.button02){
            currentColor = Color.rgb(247,232,118);
        }
        else if (id == R.id.button03){
            currentColor = Color.rgb(111,197,128);
        }
        if (id == R.id.button04){
            currentColor = Color.rgb(142,197,235);
        }
        else if (id == R.id.button05){
            currentColor = Color.rgb(175,134,204);
        }
        else if (id == R.id.button06){
            currentColor = Color.rgb(248,162,209);
        }
        else if (id == R.id.button07){
            currentColor = Color.rgb(144,181,178);
        }
        else if (id == R.id.button08){
            currentColor = Color.rgb(209,184,151);
        }
        else if (id == R.id.button09){
            currentColor = Color.rgb(202,201,201);
        }
    }

    public void onClick(View v){
        int id = v.getId();
        Button b = (Button) findViewById(id);
        b.setBackgroundColor(currentColor);
    }
}

package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;

import java.util.HashMap;

public class matchingTest extends AppCompatActivity {

    String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    Integer[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    Boolean A0 = Boolean.FALSE;
    Boolean B0 = Boolean.FALSE;
    Boolean C0 = Boolean.FALSE;
    Boolean D0 = Boolean.FALSE;
    Boolean done = Boolean.FALSE;
    Button a1, b1, c1, d1;
    int length = keys.length;
    Boolean submit = Boolean.FALSE;
    HashMap<String, Integer> result = new HashMap<>();
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
        button = (Button)findViewById(R.id.buttonNext);
        button.setTypeface(type);
    }

    public void onSubmitClicked(View v){
        if(A0 & B0 & C0 & D0){
            Button submit = (Button) findViewById(R.id.buttonSubmit);
            submit.setAlpha(0);
            Button next = (Button) findViewById(R.id.buttonNext);
            next.setAlpha(1);
            showResult();
        }
    }

    public void onNextClicked(View view){
        Button next = (Button) findViewById(R.id.buttonNext);
        next.setAlpha(0);
        if (done){
            Intent resultsWindowOpener = new Intent(this,showResults.class);
            startActivity(resultsWindowOpener);
        }
        else{
            Button submit = (Button) findViewById(R.id.buttonSubmit);
            A0 = Boolean.FALSE;
            B0 = Boolean.FALSE;
            C0 = Boolean.FALSE;
            D0 = Boolean.FALSE;
            submit.setAlpha(1);
            clearA0Lines();
            clearB0Lines();
            clearC0Lines();
            clearD0Lines();
            clearColors();
        }
    }

    public void clearA0Lines(){
        View v = findViewById(R.id.lineA1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1A0);
        v.setAlpha(0);
    }

    public void clearB0Lines(){
        View v = findViewById(R.id.lineA1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1B0);
        v.setAlpha(0);
    }

    public void clearC0Lines(){
        View v  = findViewById(R.id.lineA1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1C0);
        v.setAlpha(0);
    }

    public void clearD0Lines(){
        View v= findViewById(R.id.lineA1D0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1D0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1D0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1D0);
        v.setAlpha(0);
    }

    public void clearA1Lines(){
        View v = findViewById(R.id.lineA1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineA1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineA1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineA1D0);
        v.setAlpha(0);
    }

    public void clearB1Lines(){
        View v = findViewById(R.id.lineB1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1D0);
        v.setAlpha(0);
    }

    public void clearC1Lines(){
        View v  = findViewById(R.id.lineC1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1D0);
        v.setAlpha(0);
    }

    public void clearD1Lines(){
        View v= findViewById(R.id.lineD1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1D0);
        v.setAlpha(0);
    }

    public void clearColors(){
        currentColor = Color.rgb(202,201,201);
        Button b = (Button) findViewById(R.id.buttonA0);
        b.setBackgroundColor(currentColor);
        b = (Button) findViewById(R.id.buttonB0);
        b.setBackgroundColor(currentColor);
        b = (Button) findViewById(R.id.buttonC0);
        b.setBackgroundColor(currentColor);
        b = (Button) findViewById(R.id.buttonD0);
        b.setBackgroundColor(currentColor);
    }

    public void showResult(){


    }

    public void setNumbers(){
        
    }

    public void setLetters(){

    }

    public void clearButtonRefs(Button b){
        if (a1 == b){
            a1 = null;
        }
        else if (b1 == b){
            b1 = null;
        }
        else if (c1 == b){
            c1 = null;
        }
        else if (d1 == b){
            d1 = null;
        }
    }

    public void onNumberClick(View v){
        int id = v.getId();
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

    public void onA0Click(View view){
        clearA0Lines();
        A0 = Boolean.TRUE;
        Button b = (Button) findViewById(R.id.buttonA0);
        clearButtonRefs(b);
        if (currentColor == Color.rgb(142,197,235)){
            View v = findViewById(R.id.lineA1A0);
            if(a1 != null){
                a1.setBackgroundColor(Color.rgb(202,201,201));
            }
            clearA1Lines();
            v.setAlpha(1);
            a1 = b;
        }
        else if (currentColor == Color.rgb(111,197,128)){
            View v = findViewById(R.id.lineB1A0);
            if(b1 != null){
                b1.setBackgroundColor(Color.rgb(202,201,201));
            }
            clearB1Lines();
            v.setAlpha(1);
            b1 = b;
        }
        else if (currentColor == Color.rgb(220,94,90)){
            View v = findViewById(R.id.lineC1A0);
            clearC1Lines();
            v.setAlpha(1);
            if(c1 != null){
                c1.setBackgroundColor(Color.rgb(202,201,201));
            }
            c1 = b;
        }
        else if (currentColor == Color.rgb(175,134,204)){
            View v = findViewById(R.id.lineD1A0);
            clearD1Lines();
            v.setAlpha(1);
            if(d1 != null){
                d1.setBackgroundColor(Color.rgb(202,201,201));
            }
            d1 = b;
        }
        b.setBackgroundColor(currentColor);
    }

    public void onB0Click(View view){
        clearB0Lines();
        B0 = Boolean.TRUE;
        Button b = (Button) findViewById(R.id.buttonB0);
        clearButtonRefs(b);
        if (currentColor == Color.rgb(142,197,235)){
            View v = findViewById(R.id.lineA1B0);
            clearA1Lines();
            v.setAlpha(1);
            if(a1 != null){
                a1.setBackgroundColor(Color.rgb(202,201,201));
            }
            a1 = b;
        }
        else if (currentColor == Color.rgb(111,197,128)){
            View v = findViewById(R.id.lineB1B0);
            clearB1Lines();
            v.setAlpha(1);
            if(b1 != null){
                b1.setBackgroundColor(Color.rgb(202,201,201));
            }
            b1 = b;
        }
        else if (currentColor == Color.rgb(220,94,90)){
            View v = findViewById(R.id.lineC1B0);
            clearC1Lines();
            v.setAlpha(1);
            if(c1 != null){
                c1.setBackgroundColor(Color.rgb(202,201,201));
            }
            c1 = b;
        }
        else if (currentColor == Color.rgb(175,134,204)){
            View v = findViewById(R.id.lineD1B0);
            clearD1Lines();
            v.setAlpha(1);
            if(d1 != null){
                d1.setBackgroundColor(Color.rgb(202,201,201));
            }
            d1 = b;
        }
        b.setBackgroundColor(currentColor);
    }

    public void onC0Click(View view){
        clearC0Lines();
        C0 = Boolean.TRUE;
        Button b = (Button) findViewById(R.id.buttonC0);
        clearButtonRefs(b);
        if (currentColor == Color.rgb(142,197,235)){
            View v = findViewById(R.id.lineA1C0);
            clearA1Lines();
            v.setAlpha(1);
            if(a1 != null){
                a1.setBackgroundColor(Color.rgb(202,201,201));
            }
            a1 = b;
        }
        else if (currentColor == Color.rgb(111,197,128)){
            View v = findViewById(R.id.lineB1C0);
            clearB1Lines();
            v.setAlpha(1);
            if(b1 != null){
                b1.setBackgroundColor(Color.rgb(202,201,201));
            }
            b1 = b;
        }
        else if (currentColor == Color.rgb(220,94,90)){
            View v = findViewById(R.id.lineC1C0);
            clearC1Lines();
            v.setAlpha(1);
            if(c1 != null){
                c1.setBackgroundColor(Color.rgb(202,201,201));
            }
            c1 = b;
        }
        else if (currentColor == Color.rgb(175,134,204)){
            View v = findViewById(R.id.lineD1C0);
            clearD1Lines();
            v.setAlpha(1);
            if(d1 != null){
                d1.setBackgroundColor(Color.rgb(202,201,201));
            }
            d1 = b;
        }
        b.setBackgroundColor(currentColor);
    }

    public void onD0Click(View view){
        clearD0Lines();
        D0 = Boolean.TRUE;
        Button b = (Button) findViewById(R.id.buttonD0);
        clearButtonRefs(b);
        if (currentColor == Color.rgb(142,197,235)){
            View v = findViewById(R.id.lineA1D0);
            clearA1Lines();
            v.setAlpha(1);
            if(a1 != null){
                a1.setBackgroundColor(Color.rgb(202,201,201));
            }
            a1 = b;
        }
        else if (currentColor == Color.rgb(111,197,128)){
            View v = findViewById(R.id.lineB1D0);
            clearB1Lines();
            v.setAlpha(1);
            if(b1 != null){
                b1.setBackgroundColor(Color.rgb(202,201,201));
            }
            b1 = b;
        }
        else if (currentColor == Color.rgb(220,94,90)){
            View v = findViewById(R.id.lineC1D0);
            clearC1Lines();
            v.setAlpha(1);
            if(c1 != null){
                c1.setBackgroundColor(Color.rgb(202,201,201));
            }
            c1 = b;
        }
        else if (currentColor == Color.rgb(175,134,204)){
            View v = findViewById(R.id.lineD1D0);
            clearD1Lines();
            v.setAlpha(1);
            if(d1 != null){
                d1.setBackgroundColor(Color.rgb(202,201,201));
            }
            d1 = b;
        }
        b.setBackgroundColor(currentColor);
    }
}

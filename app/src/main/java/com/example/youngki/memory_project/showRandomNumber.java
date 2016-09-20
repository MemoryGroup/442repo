package com.example.youngki.memory_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

//at first, EMPTY CLASS!!
public class showRandomNumber extends AppCompatActivity {
    int[] arr = new int[30];
    int i=0, seed=0;
    Random ran = new Random(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_random_number);
        print();
    }
    public void print(){
        TextView viewRandomNumber = new TextView(this);
        //TextView textView = (TextView)findViewById(R.id.textView);
        for(i=0;i<30;i++){
            arr[i] = ran.nextInt(10)+1;
        }

        viewRandomNumber.setText(Arrays.toString(arr));
        viewRandomNumber.setTextSize(20);
        viewRandomNumber.setHeight(500);
        viewRandomNumber.setWidth(500);
        setContentView(viewRandomNumber);

    }
    public void onNewRandomNumberClicked(View v){
        Button newRandomNumberButton = (Button) v;
        ran.setSeed(++seed);

        print();

    }
}

package com.example.youngki.memory_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class showTestOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_test_options);
    }

    public void onLetterToNumberButtonClicked(View v){
        Intent testOpener = new Intent(this,showTest.class);
        startActivity(testOpener);
    }

    public void onMatchingButtonClicked(View v) {
        Intent testOpener = new Intent(this, matchingTest.class);
        startActivity(testOpener);
    }
}

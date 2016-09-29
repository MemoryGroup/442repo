package com.example.youngki.memory_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onStartButtonClicked(View v){
        Button startButton = (Button) v;
        Intent startWindowOpener = new Intent(this,createMap.class);
        startActivity(startWindowOpener);
    }
    public void onHelpButtonClicked(View v){
        Button helpButton = (Button) v;
        Intent helpWindowOpener = new Intent(this,showHelp.class);
        startActivity(helpWindowOpener);
    }

    public void onTestButtonClicked(View v){
        Intent testWindowOpener = new Intent(this,showTest.class);
        startActivity(testWindowOpener);
    }

}

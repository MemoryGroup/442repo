package com.example.youngki.memory_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_help);
        showHelp();
    }

    public void showHelp(){

        TextView viewHelp = new TextView(this);
        viewHelp.setText("HOW TO PLAY GAME");
        viewHelp.setTextSize(20);
        viewHelp.setHeight(500);
        viewHelp.setWidth(500);
        setContentView(viewHelp);
    }

}

package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class showTrainOptions extends AppCompatActivity {

    private Button buttonTmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_train_options);
        Typeface type = Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf");
        Button button = (Button) findViewById(R.id.generateMap);
        button.setTypeface(type);
        button = (Button) findViewById(R.id.buttonTmp);
        button.setTypeface(type);
        button = (Button) findViewById(R.id.numberButton);
        button.setTypeface(type);
        button = (Button)findViewById(R.id.button7);
        button.setTypeface(type);
        findViewById(R.id.numberButton).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startActivity(new Intent(showTrainOptions.this,NumberButtons.class));
            }
        });

        onClickButtonListener();
    }

    public void onClickButtonListener(){

        buttonTmp = (Button)findViewById(R.id.buttonTmp);
        buttonTmp.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.youngki.memory_project.handWritingTrain");
                        startActivity(intent);
                    }
                }
        );
    }

    public void onStartButtonClicked(View v){
        Intent windowOpener = new Intent(this,createMap.class);
        startActivity(windowOpener);
    }

    public void onTestClicked(View v){
        Intent windowOpener = new Intent(this,showTestOptions.class);
        startActivity(windowOpener);
    }
}

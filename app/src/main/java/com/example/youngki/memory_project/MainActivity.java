package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView2);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf");
        textView.setTypeface(type);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        textView.setAnimation(anim);

    }
    public void onStartButtonClicked(View v){
        Button startButton = (Button) v;
        Intent startWindowOpener = new Intent(this,showRandomNumber.class);
        startActivity(startWindowOpener);
    }
    public void onHelpButtonClicked(View v){
        Button helpButton = (Button) v;
        Intent helpWindowOpener = new Intent(this,showHelp.class);
        startActivity(helpWindowOpener);


    }
}

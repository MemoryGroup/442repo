package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    private Button button;
    private AlphaAnimation buttonClicked = new AlphaAnimation(1F, 0.8F);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.textView2);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf");
        textView.setTypeface(type);

        Animation anim = AnimationUtils.loadAnimation(this,R.anim.fade_in);
        textView.setAnimation(anim);

        //Setting fonts of buttons
        button = (Button)findViewById(R.id.button);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));

        button = (Button)findViewById(R.id.button2);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));

        button = (Button)findViewById(R.id.button3);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));

        button = (Button)findViewById(R.id.button4);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));



    }
    public void onStartButtonClicked(View v){
        v.startAnimation(buttonClicked);
        Intent startWindowOpener = new Intent(this,createMap.class);
        startActivity(startWindowOpener);
    }
    public void onHelpButtonClicked(View v){
        v.startAnimation(buttonClicked);
        Intent helpWindowOpener = new Intent(this,showHelp.class);
        startActivity(helpWindowOpener);
    }

    public void onTestButtonClicked(View v){
        v.startAnimation(buttonClicked);
        Intent testWindowOpener = new Intent(this,showTest.class);
        startActivity(testWindowOpener);
    }

}

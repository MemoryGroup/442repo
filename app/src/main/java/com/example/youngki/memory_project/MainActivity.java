package com.example.youngki.memory_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    //added to check before test phase
    private Boolean hasMap = false;

    //TODO need to implement this via a shared preference boolean
    private Boolean userHasTrainedToday;

    private Button button;
    private Button buttonTmp;
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



            // a map was detected
            hasMap = true;

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

        if(hasMap == false){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setMessage("Train today before testing.");
            builder1.setCancelable(false);
            builder1.setNeutralButton(
                    "Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();

                        }
                    });
            AlertDialog alert11 = builder1.create();
            alert11.show();
            return;
        }

        v.startAnimation(buttonClicked);
        Intent testWindowOpener = new Intent(this,showTestOptions.class);
        startActivity(testWindowOpener);
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


}

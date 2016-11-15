package com.example.youngki.memory_project;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class showHelp extends AppCompatActivity {

    private TextView howToPlay;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_help);

        howToPlay = (TextView)findViewById(R.id.textView10);
        howToPlay.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf"));

        button = (Button)findViewById(R.id.button);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));
        button = (Button)findViewById(R.id.button1);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));
        button = (Button)findViewById(R.id.button2);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));
        button = (Button)findViewById(R.id.button3);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));
        button = (Button)findViewById(R.id.button4);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));
        button = (Button)findViewById(R.id.button5);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));

    }

    public void onGenerateMapClick(View v){
        Intent windowOpener = new Intent(this,createMap.class);
        startActivity(windowOpener);
    }

    public void onGenerateHelpClick(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(showHelp.this);
        builder1.setMessage("Select easy, medium, or hard, then click generate and the map will show " +
                "on the screen. Click the + or - buttons to increase or decrease the amount of letters" +
                " or numbers shown. Click train to save the map you've created.");
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
    }

    public void onHandwritingHelpClick(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(showHelp.this);
        builder1.setMessage("In the open space, write the number shown at the bottom, and hear the " +
                "number read back to you.");
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
    }

    public void onRepetitionHelpClick(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(showHelp.this);
        builder1.setMessage("Press the button corresponding to the letters and numbers shown on the " +
                "screen, and hear it played back to you. At the bottom of the screen, choose from " +
                "the different voices we have available.");
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
    }

    public void onMatchingHelpClick(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(showHelp.this);
        builder1.setMessage("First, click on a number to select it, the click on the letter that " +
                "is paired with the number. When you have matched all letters and numbers, click " +
                "submit to check your answers. Click next to continue to test on the remaining " +
                "items. When there are no items left, you will be taken to the results screen.");
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
    }

    public void onLetterToNumberHelpClick(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(showHelp.this);
        builder1.setMessage("Click on the number that is paired with the letter shown. On the next " +
                "screen, the upper right hand corner will let you know if you answered right or " +
                "wrong. When there are no items left, you will be taken to the results screen.");
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
    }
}

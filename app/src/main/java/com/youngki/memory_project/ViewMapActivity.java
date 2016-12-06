package com.youngki.memory_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import com.google.gson.Gson;
import java.util.HashMap;

public class ViewMapActivity extends AppCompatActivity {

  private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  HashMap<String, Integer> memMap;
  Boolean hasGenerated = false;
  GridLayout dynamicGridLayout;
  //Level level = Level.EASY;
  private int[] colors = new int[10];

  /**
   * Convert Dp to Pixel
   */
  public static int dpToPx(float dp, Resources resources) {
    float px =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    return (int) px;
  }



  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_map);
    dynamicGridLayout = (GridLayout) findViewById(R.id.dynamicGridLayout);
    colors[0] = ContextCompat.getColor(this, R.color.red);
    colors[1] = ContextCompat.getColor(this, R.color.orange);
    colors[2] = ContextCompat.getColor(this, R.color.yellow);
    colors[3] = ContextCompat.getColor(this, R.color.green);
    colors[4] = ContextCompat.getColor(this, R.color.blue);
    colors[5] = ContextCompat.getColor(this, R.color.purple);
    colors[6] = ContextCompat.getColor(this, R.color.pink);
    colors[7] = ContextCompat.getColor(this, R.color.teal);
    colors[8] = ContextCompat.getColor(this, R.color.tan);
    colors[9] = ContextCompat.getColor(this, R.color.gray);
    SharedPreferences myPref = getSharedPreferences("MyPref", MODE_PRIVATE);
    String map =myPref.getString("memMap", "");
    memMap =  new Gson().fromJson(map,MapWrapper.class).getMap();


    onGenerateClicked(null);
  }

  public void onGenerateClicked(View v) {
    //now get the maps with default: 7 letters and 3 numbers for easy
    String letterMap = ALPHABETS;
    for (int i = 0; i < memMap.size(); i++) {
      String curLetter = letterMap.substring(i, i + 1);
      int curNumber = memMap.get(curLetter);
      Button button = new Button(this);
      ViewGroup.MarginLayoutParams marginLayoutParams =
          new ViewGroup.MarginLayoutParams(dpToPx(48, getResources()), dpToPx(48, getResources()));
      marginLayoutParams.rightMargin = dpToPx(5, getResources());
      marginLayoutParams.bottomMargin = dpToPx(5, getResources());
      button.setLayoutParams(new GridLayout.LayoutParams(marginLayoutParams));
      button.setBackgroundColor(colors[curNumber]);
      dynamicGridLayout.addView(button);
      button.setGravity(Gravity.CENTER);
      button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
      button.setText(curLetter + ":" + curNumber);
    }
    hasGenerated = true;
  }

  @Override
  public void onBackPressed(){
    Intent windowOpener = new Intent(this, showHelp.class);
    startActivity(windowOpener);
  }
}
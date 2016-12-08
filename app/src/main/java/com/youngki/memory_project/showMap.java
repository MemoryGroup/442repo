package com.youngki.memory_project;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class showMap extends AppCompatActivity {

    String [] keys;
    Integer [] values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_map);
        showMap();
    }

    public void showMap(){
        int k = keys.length;
        TextView tv;
        int i = k - 1;
        switch (k){
            case 26:
                tv = (TextView) findViewById(R.id.textView26);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 25:
                tv = (TextView) findViewById(R.id.textView25);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 24:
                tv = (TextView) findViewById(R.id.textView24);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 23:
                tv = (TextView) findViewById(R.id.textView23);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 22:
                tv = (TextView) findViewById(R.id.textView22);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 21:
                tv = (TextView) findViewById(R.id.textView21);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 20:
                tv = (TextView) findViewById(R.id.textView20);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 19:
                tv = (TextView) findViewById(R.id.textView19);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 18:
                tv = (TextView) findViewById(R.id.textView18);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 17:
                tv = (TextView) findViewById(R.id.textView17);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 16:
                tv = (TextView) findViewById(R.id.textView16);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 15:
                tv = (TextView) findViewById(R.id.textView15);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 14:
                tv = (TextView) findViewById(R.id.textView14);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 13:
                tv = (TextView) findViewById(R.id.textView13);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 12:
                tv = (TextView) findViewById(R.id.textView12);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 11:
                tv = (TextView) findViewById(R.id.textView11);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 10:
                tv = (TextView) findViewById(R.id.textView10);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 9:
                tv = (TextView) findViewById(R.id.textView9);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 8:
                tv = (TextView) findViewById(R.id.textView8);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 7:
                tv = (TextView) findViewById(R.id.textView7);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 6:
                tv = (TextView) findViewById(R.id.textView6);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 5:
                tv = (TextView) findViewById(R.id.textView5);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 4:
                tv = (TextView) findViewById(R.id.textView4);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 3:
                tv = (TextView) findViewById(R.id.textView3);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 2:
                tv = (TextView) findViewById(R.id.textView2);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                i = i - 1;
            case 1:
                tv = (TextView) findViewById(R.id.textView1);
                tv.setText(keys[i] + ":  " + Integer.toString(values[i]));
                break;
        }
    }
}

package com.youngki.memory_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.gson.Gson;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;


public class custom_map extends AppCompatActivity {

    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, Integer> memMap = new HashMap<>();
    HashMap<String, Boolean> alphabet = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_map);

    }

    public void onSubmitClick(View v){
        EditText let = (EditText) findViewById(R.id.editText2);
        String letters = let.getText().toString();
        EditText num = (EditText) findViewById(R.id.editText);
        String numbers = num.getText().toString();
        if (letters.length() == numbers.length()){
            clearMap();
            if (checkLetters(letters)){
                saveMap(letters, numbers);
                Intent windowOpener = new Intent(this,ViewMapActivity.class);
                startActivity(windowOpener);
            }
            else{
                TextView tv = (TextView)findViewById(R.id.textView27);
                tv.setAlpha(1);
            }
        }
        else{
            TextView tv = (TextView)findViewById(R.id.textView27);
            tv.setAlpha(1);
        }
    }

    public Boolean checkLetters(String s){
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            String str = Character.toString(c);
            if (alpha.contains(str)){
                if (!alphabet.get(str)){
                    alphabet.put(str, Boolean.TRUE);
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    public void saveMap(String letters, String numbers){
        for (int i = 0; i < letters.length(); i++){
            String let = Character.toString(letters.charAt(i));
            int num = Integer.parseInt(Character.toString(numbers.charAt(i)));
            memMap.put(let,num);
        }
        HashMap<String, Integer> progress_map = new HashMap<>();
        for (String key : memMap.keySet()) {
            progress_map.put(key, 0);
        }
        Gson gson = new Gson();
        MapWrapper mem = new MapWrapper();
        mem.setMap(memMap);
        String serializedMap = gson.toJson(mem);
        SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
        editor.putString("memMap", serializedMap);
        MapWrapper progress = new MapWrapper();
        progress.setMap(progress_map);
        String serializedProgress = gson.toJson(progress);
        editor.putString("streakMap", serializedProgress);
        editor.putString("timesCorrectMap", serializedProgress);
        editor.putString("totalAttemptsMap", serializedProgress);
        editor.apply(); //persist the values
    }

    public void clearMap(){
        for (int i = 0; i < 26; i++){
            char c = alpha.charAt(i);
            alphabet.put(Character.toString(c), Boolean.FALSE);
        }
    }
}

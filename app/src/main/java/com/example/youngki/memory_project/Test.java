package com.example.youngki.memory_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Set;

public class Test extends AppCompatActivity {

    HashMap<String, Integer> memoryMap = new HashMap<String, Integer>(26);
    String[] keys;

    public void setMemoryMap(HashMap<String, Integer> memoryMap) {
        memoryMap.put("A", 1);
        memoryMap.put("B", 0);
        memoryMap.put("C", 5);
        memoryMap.put("D", 7);
        this.memoryMap = memoryMap;
        memoryMap.keySet().toArray(this.keys);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        //setMemoryMap(memoryMap);
        //TextView tv = (TextView) findViewById(R.id.textView3);
        //tv.setText(this.keys[0]);
    }

}

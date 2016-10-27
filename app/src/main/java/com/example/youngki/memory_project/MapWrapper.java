package com.example.youngki.memory_project;

import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapWrapper{
    private HashMap<String, Integer> memMap;

    public HashMap<String, Integer> getMap(){
        return memMap;
    }

    public void setMap(HashMap<String, Integer> newMap){
        this.memMap = newMap;

    }

    public String[] getKeys(){
        //here we get a random amount of keys from the entire list to train on
        Set<String> keys = memMap.keySet();
        String[] keyArray = keys.toArray(new String[keys.size()]);
        return keyArray;
    }

    public Integer[] getValues(String[] keylist){
        //here we get the respective values
        Integer[] valueArray = new Integer[keylist.length];
        int index = 0;
        for(int i = 0; i < keylist.length; i++){
            valueArray[i] = memMap.get(keylist[i]);
        }
        return valueArray;
    }



}
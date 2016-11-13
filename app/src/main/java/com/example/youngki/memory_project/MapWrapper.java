package com.example.youngki.memory_project;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
        //here we get all keys in random order
        Set<String> keys = memMap.keySet();
        List<String> keyList = new ArrayList(keys);
        //we get a random ordering every time
        Collections.shuffle(keyList);
        String[] keyArray = keyList.toArray(new String[keys.size()]);

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

    public String[] getKeysVariable(HashMap<String, Integer> streakMap){
        //here we get a certain amound of each key depending on the user's streak
        // if the user has a streak more than 3 we do not test on the key
        // if the user has a streak of 0 we put the key in three times
        // if the user has a streak of 1 we put the key in twice
        // if the user has a streak of 2-3 we put the key in once

        Set<String> keys = memMap.keySet();
        List<String> keyList = new ArrayList(keys);
        List<String> variablekeyList = new ArrayList<>();

        for(String curKey:keyList){
            if(streakMap.get(curKey) == 0){
                variablekeyList.add(curKey);
                variablekeyList.add(curKey);
                variablekeyList.add(curKey);
            }else if(streakMap.get(curKey) == 1){
                variablekeyList.add(curKey);
                variablekeyList.add(curKey);
            }
            else if(streakMap.get(curKey)==2 || streakMap.get(curKey)==3) {
                variablekeyList.add(curKey);
            }else{
                //Here streak is greater than 3
                //TODO may want to add in the key after a certain number of days
                //amount of days may depend onlength of the streak
            }
        }

        //we get a random ordering every time
        Collections.shuffle(variablekeyList);
        String[] keyArray = variablekeyList.toArray(new String[variablekeyList.size()]);

        return keyArray;
    }




}

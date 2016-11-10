package com.example.youngki.memory_project;

import android.app.Activity;
import android.content.SharedPreferences;
import android.gesture.Gesture;
        import android.gesture.GestureLibraries;
        import android.gesture.GestureLibrary;
        import android.gesture.GestureOverlayView;
        import android.gesture.Prediction;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Map.Entry;
        import java.util.Random;


        import android.gesture.GestureOverlayView.OnGesturePerformedListener;

import com.google.gson.Gson;

public class handWritingTrain extends Activity {

    GestureLibrary gestureLibrary = null;
    GestureOverlayView gestureOverlayView;
    TextView gestureResult;
    TextView textView2;
    TextView textView4;
    int cnt=0;
    HashMap<String, Integer> memMap = new HashMap<>();
    Map<Integer, String> myNewHashMap = new HashMap<>();
    String[] keys;
    Integer[] values;
    ArrayList<Integer> keyList = new ArrayList<>();
    ArrayList<String> valueList = new ArrayList<>();
    int[] audio = new int[] {
            R.raw.zero, R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five, R.raw.six, R.raw.seven,
            R.raw.eight, R.raw.nine
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);
        //

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_writing_train);
        generateHashMap(memMap, keys,values);

        keyList.addAll(myNewHashMap.keySet());
        valueList.addAll(myNewHashMap.values());

        textView2 = (TextView)findViewById(R.id.textView2);

        textView2.setText("The first one of map : "+myNewHashMap.get(keyList.get(0))+", write "+keyList.get(0));
        textView4 = (TextView)findViewById(R.id.textView4);



        gestureResult = (TextView)findViewById(R.id.gestureresult);
        gestureOverlayView = (GestureOverlayView)findViewById(R.id.gestures);

        gestureLibrary = GestureLibraries.fromRawResource(this, R.raw.gestures);
        gestureLibrary.load();

        gestureOverlayView.addOnGesturePerformedListener(gesturePerformedListener);



    }

    private void generateHashMap(HashMap<String, Integer> memMap, String[] keys, Integer[] values) {
        int i;
        for(i=0;i<keys.length;i++){
            memMap.put(keys[i],values[i]);
        }

        //making into <Integer,String>
        for(Map.Entry<String, Integer> entry : memMap.entrySet()){
            myNewHashMap.put(entry.getValue(), entry.getKey());
        }
    }

    GestureOverlayView.OnGesturePerformedListener gesturePerformedListener = new GestureOverlayView.OnGesturePerformedListener(){

        @Override
        public void onGesturePerformed(GestureOverlayView view, Gesture gesture) {
            ArrayList<Prediction> prediction = gestureLibrary.recognize(gesture);
            String targetString = new String();
            String nextTargetString = new String();
            String getString= new String();

            int getInt;


            if(prediction.size() > 0){
                if(cnt==memMap.size()) cnt = 0;

                targetString = myNewHashMap.get(keyList.get(cnt));
                if(cnt==keyList.size()-1)cnt=-1;
                nextTargetString = myNewHashMap.get(keyList.get(cnt+1));

                gestureResult.setText(prediction.get(0).name);

                getString = gestureResult.getText().toString();
                gestureResult.setAlpha(0.0f);//1.0f to make it visible
                getInt = makeIntValue(getString);


                MediaPlayer.create(handWritingTrain.this,audio[memMap.get(targetString)]).start();

                textView2.setText(keyList.toString());
                textView2.setText("NEXT : "+nextTargetString+" is "+memMap.get(nextTargetString)+". Write "+memMap.get(nextTargetString));
                cnt++;

            }


        }};

    private int makeIntValue(String getString) {

        switch (getString) {
            case "zero"    : return 0;
            case "one"   : return 1;
            case "two"  : return 2;
            case "three"    : return 3;
            case "four"   : return 4;
            case "five"  : return 5;
            case "six"    : return 6;
            case "seven"   : return 7;
            case "eight"  : return 8;
            case "nine" : return 9;
            default    : return -1;

        }

    }

}
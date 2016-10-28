package com.example.youngki.memory_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;
import java.util.ArrayList;


public class progress extends AppCompatActivity {

    String[] keys =           {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
    Integer[] values =        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    Integer[] streak =        {2, 0, 1, 4, 1, 0, 2, 2, 0, 0, 0};
    Integer[] times_correct = {2, 0, 1, 4, 1, 1, 2, 4, 0, 0, 0};
    Integer[] total_attempts ={3, 1, 2, 4, 3, 5, 2, 5, 2, 0, 1};
    ArrayList<progress_column> scoreList = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_score);

        int numRows = values.length;
        if(numRows == 0){
            // TODO Error check here
        }else{

            progress_column temp1 = new progress_column
                    ("Letter", "Number", "Accuracy", "Streak");
            scoreList.add(0,temp1);

            for(int i = 0; i < keys.length; i++){
                Integer acc = (int)((times_correct[i] * 1.0 / total_attempts[i])*100);
                String curStreak = streak[i].toString();
                String curAcc = acc.toString() + "%";
                if (total_attempts[i] == 0){
                    curStreak = "-";
                    curAcc = "-";
                }

                progress_column temp = new progress_column
                        (keys[i],values[i].toString(), curAcc, curStreak);
                scoreList.add(i+1,temp);
            }
            progress_format scoreboard =  new progress_format(this,R.layout.progress_layout, scoreList);
            listView = (ListView) findViewById(R.id.scoreView);
            listView.setAdapter(scoreboard);
        }
    }
}

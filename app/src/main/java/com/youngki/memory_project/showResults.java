package com.youngki.memory_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
        //String[] correct = getIntent().getExtras().getStringArray("correct");
        //for (int i = 0; i < 6; i++){
        //    TextView tv = (TextView) findViewById(R.id.textView1);
        //    tv.setText(0);
        //}
    }

    @Override
    public void onBackPressed(){
        Intent testsWindowOpener = new Intent(this,showTestOptions.class);
        startActivity(testsWindowOpener);
    }

}

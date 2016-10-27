package com.example.youngki.memory_project;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class showHelp extends AppCompatActivity {
    private TextView howToPlay;
    private Button button;
    private Button mButton;
    private LinearLayout mLayout;
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_help);

        howToPlay = (TextView)findViewById(R.id.textView10);
        howToPlay.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf"));

        button = (Button)findViewById(R.id.button6);
        button.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/orange juice 2.0.ttf"));
//////
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        //mEditText = (EditText) findViewById(R.id.editText);

        mButton = (Button) findViewById(R.id.button6);
        mButton.setOnClickListener(onClick());
//        TextView textView = new TextView(this);
//        textView.setText("MMM");


    }


    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mLayout.addView(createNewTextView("Making"));

                //mLayout.addView(createNewTextView(mEditText.getText().toString()));
            }
        };
    }

    private TextView createNewTextView(String text) {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView howTestTextView = new TextView(this);
        howTestTextView.setLayoutParams(lparams);
        howTestTextView.setText("New text : " + text);
        return howTestTextView;
    }


}

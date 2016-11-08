package com.example.youngki.memory_project;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.google.gson.Gson;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

public class repetitionTraining extends AppCompatActivity {

    private MapWrapper memMapWrap;
    int count = 0;
    String[] keys;
    Integer[] values;
    String letter;
    int number;
    int text = 0;
    int audioSelection = 1;
    Boolean done = Boolean.FALSE;
    int audioThree[] = new int[]{
        R.raw.a3, R.raw.b3, R.raw.c3, R.raw.d3, R.raw.e3, R.raw.f3, R.raw.g3, R.raw.h3, R.raw.i3,
        R.raw.j3, R.raw.k3, R.raw.l3, R.raw.m3, R.raw.n3, R.raw.o3, R.raw.p3, R.raw.q3, R.raw.r3,
        R.raw.s3, R.raw.t3, R.raw.u3, R.raw.v3, R.raw.w3, R.raw.x3, R.raw.y3, R.raw.z3, R.raw.zero3,
        R.raw.one3, R.raw.two3,R.raw.three3, R.raw.four3, R.raw.five3, R.raw.six3, R.raw.seven3,
        R.raw.eight3, R.raw.nine3
    };
    int audioTwo[] = new int[]{
        R.raw.a2, R.raw.b2, R.raw.c2, R.raw.d2, R.raw.e2, R.raw.f2, R.raw.g2, R.raw.h2, R.raw.i2,
        R.raw.j2, R.raw.k2, R.raw.l2, R.raw.m2, R.raw.n2, R.raw.o2, R.raw.p2, R.raw.q2, R.raw.r2,
        R.raw.s2, R.raw.t2, R.raw.u2, R.raw.v2, R.raw.w2, R.raw.x2, R.raw.y2, R.raw.z2, R.raw.zero2,
        R.raw.one2, R.raw.two2,R.raw.three2, R.raw.four2, R.raw.five2, R.raw.six2, R.raw.seven2,
        R.raw.eight2, R.raw.nine2
    };
    int audioOne[] = new int[]{
        R.raw.a1, R.raw.b1, R.raw.c1, R.raw.d1, R.raw.e1, R.raw.f1, R.raw.g1, R.raw.h1, R.raw.i1,
        R.raw.j1, R.raw.k1, R.raw.l1, R.raw.m1, R.raw.n1, R.raw.o1, R.raw.p1, R.raw.q1, R.raw.r1,
        R.raw.s1, R.raw.t1, R.raw.u1, R.raw.v1, R.raw.w1, R.raw.x1, R.raw.y1, R.raw.z1, R.raw.zero1,
        R.raw.one1, R.raw.two1,R.raw.three1, R.raw.four1, R.raw.five1, R.raw.six1, R.raw.seven1,
        R.raw.eight1, R.raw.nine1
    };
    int audioZero[] = new int[]{
        R.raw.a0, R.raw.b0, R.raw.c0, R.raw.d0, R.raw.e0, R.raw.f0, R.raw.g0, R.raw.h0, R.raw.i0,
        R.raw.j0, R.raw.k0, R.raw.l0, R.raw.m0, R.raw.n0, R.raw.o0, R.raw.p0, R.raw.q0, R.raw.r0,
        R.raw.s0, R.raw.t0, R.raw.u0, R.raw.v0, R.raw.w0, R.raw.x0, R.raw.y0, R.raw.z0, R.raw.zero0,
        R.raw.one0, R.raw.two0,R.raw.three0, R.raw.four0, R.raw.five0, R.raw.six0, R.raw.seven0,
        R.raw.eight0, R.raw.nine0
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repetition_training);
        nextPair();
        Button b = (Button) findViewById(R.id.audio1);
        b.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void nextPair(){
        if (done == Boolean.FALSE){
            this.letter = this.keys[count];
            this.number = this.values[count];
            count = count + 1;
            setLetters();
            setNumbers();
            if (count == keys.length){
                done = Boolean.TRUE;
            }
        }
        else{
            finished();
        }
    }

    public void finished(){
        Intent windowOpener = new Intent(this,showTrainOptions.class);
        startActivity(windowOpener);
    }

    public void setLetters(){
        TextView tv = (TextView) findViewById(R.id.textView0);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView01);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView02);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView03);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView04);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView2);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView21);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView4);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView41);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView6);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView8);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView10);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView12);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView14);
        tv.setText(letter);
        tv.setTypeface(Typeface.DEFAULT);
        Button button = (Button) findViewById(R.id.button0);
        button.setText(letter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer.create(repetitionTraining.this, getAudio(letter)).start();
                makeBold(R.id.button0);
            }
        });

    }

    public void setNumbers(){
        String n = Integer.toString(number);
        TextView tv = (TextView) findViewById(R.id.textView05);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView06);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView07);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView08);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView09);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView3);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView31);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView5);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView51);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView7);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView9);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView11);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView13);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        tv = (TextView) findViewById(R.id.textView15);
        tv.setText(n);
        tv.setTypeface(Typeface.DEFAULT);
        Button button = (Button) findViewById(R.id.button1);
        button.setText(n);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer.create(repetitionTraining.this, getAudio(Integer.toString(number))).start();
                makeBold(R.id.button1);
            }
        });
    }

    public void makeBold(int id){
        TextView tv;
        Boolean correct = Boolean.FALSE;
        if (id == R.id.button0){
            if (text == 0 | text == 1 | text == 2| text == 3 | text == 4 | text == 10 | text == 11 |
                    text == 14 | text == 15 | text == 18 | text == 20 | text == 22 | text == 24 |
                    text == 26){
                correct = Boolean.TRUE;
            }
        }
        else if (id == R.id.button1){
            if (text == 5 | text == 6 | text == 7 | text == 8 | text == 9 | text == 12 | text == 13 |
                    text == 16 | text == 17 | text == 19 | text == 21 | text == 23 | text == 25 |
                    text == 27){
                correct = Boolean.TRUE;
            }
        }
        if(correct) {
            switch (text) {
                case 0:
                    tv = (TextView) findViewById(R.id.textView0);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 1:
                    tv = (TextView) findViewById(R.id.textView01);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 2:
                    tv = (TextView) findViewById(R.id.textView02);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 3:
                    tv = (TextView) findViewById(R.id.textView03);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 4:
                    tv = (TextView) findViewById(R.id.textView04);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 5:
                    tv = (TextView) findViewById(R.id.textView05);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 6:
                    tv = (TextView) findViewById(R.id.textView06);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 7:
                    tv = (TextView) findViewById(R.id.textView07);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 8:
                    tv = (TextView) findViewById(R.id.textView08);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 9:
                    tv = (TextView) findViewById(R.id.textView09);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 10:
                    tv = (TextView) findViewById(R.id.textView2);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 11:
                    tv = (TextView) findViewById(R.id.textView21);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 12:
                    tv = (TextView) findViewById(R.id.textView3);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 13:
                    tv = (TextView) findViewById(R.id.textView31);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 14:
                    tv = (TextView) findViewById(R.id.textView4);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 15:
                    tv = (TextView) findViewById(R.id.textView41);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 16:
                    tv = (TextView) findViewById(R.id.textView5);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 17:
                    tv = (TextView) findViewById(R.id.textView51);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 18:
                    tv = (TextView) findViewById(R.id.textView6);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 19:
                    tv = (TextView) findViewById(R.id.textView7);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 20:
                    tv = (TextView) findViewById(R.id.textView8);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 21:
                    tv = (TextView) findViewById(R.id.textView9);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 22:
                    tv = (TextView) findViewById(R.id.textView10);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 23:
                    tv = (TextView) findViewById(R.id.textView11);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 24:
                    tv = (TextView) findViewById(R.id.textView12);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 25:
                    tv = (TextView) findViewById(R.id.textView13);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 26:
                    tv = (TextView) findViewById(R.id.textView14);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case 27:
                    tv = (TextView) findViewById(R.id.textView15);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
            }
            if (text == 27) {
                if (done == Boolean.TRUE) {
                    finished();
                } else {
                    text = 0;
                    nextPair();
                }
            } else {
                text++;
            }
        }
    }

    public void onAudioSelectClick(View v){
        int id = v.getId();
        Button b;
        b = (Button) findViewById(R.id.audio0);
        b.setTypeface(Typeface.DEFAULT);
        b = (Button) findViewById(R.id.audio1);
        b.setTypeface(Typeface.DEFAULT);
        b = (Button) findViewById(R.id.audio2);
        b.setTypeface(Typeface.DEFAULT);
        b = (Button) findViewById(R.id.audio3);
        b.setTypeface(Typeface.DEFAULT);
        switch (id){
            case R.id.audio0:
                audioSelection = 0;
                b = (Button) findViewById(R.id.audio0);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case R.id.audio1:
                audioSelection = 1;
                b = (Button) findViewById(R.id.audio1);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case R.id.audio2:
                audioSelection = 2;
                b = (Button) findViewById(R.id.audio2);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                break;
            case R.id.audio3:
                audioSelection = 3;
                b = (Button) findViewById(R.id.audio3);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                break;
        }
    }

    public int getAudio(String s){
        int audio = 0;
        int audio1[];
        if (audioSelection == 1){
            audio1 = audioOne;
        }
        else if (audioSelection == 2){
            audio1 = audioTwo;
        }
        else if (audioSelection == 0){
            audio1 = audioZero;
        }
        else if (audioSelection == 3){
            audio1 = audioThree;
        }
        else{
            audio1 = audioOne;
        }
        switch (s){
            case "A":
                audio = audio1[0];
                break;
            case "B":
                audio = audio1[1];
                break;
            case "C":
                audio = audio1[2];
                break;
            case "D":
                audio = audio1[3];
                break;
            case "E":
                audio = audio1[4];
                break;
            case "F":
                audio = audio1[5];
                break;
            case "G":
                audio = audio1[6];
                break;
            case "H":
                audio = audio1[7];
                break;
            case "I":
                audio = audio1[8];
                break;
            case "J":
                audio = audio1[9];
                break;
            case "K":
                audio = audio1[10];
                break;
            case "L":
                audio = audio1[11];
                break;
            case "M":
                audio = audio1[12];
                break;
            case "N":
                audio = audio1[13];
                break;
            case "O":
                audio = audio1[14];
                break;
            case "P":
                audio = audio1[15];
                break;
            case "Q":
                audio = audio1[16];
                break;
            case "R":
                audio = audio1[17];
                break;
            case "S":
                audio = audio1[18];
                break;
            case "T":
                audio = audio1[19];
                break;
            case "U":
                audio = audio1[20];
                break;
            case "V":
                audio = audio1[21];
                break;
            case "W":
                audio = audio1[22];
                break;
            case "X":
                audio = audio1[23];
                break;
            case "Y":
                audio = audio1[24];
                break;
            case "Z":
                audio = audio1[25];
                break;
            case "0":
                audio = audio1[26];
                break;
            case "1":
                audio = audio1[27];
                break;
            case "2":
                audio = audio1[28];
                break;
            case "3":
                audio = audio1[29];
                break;
            case "4":
                audio = audio1[30];
                break;
            case "5":
                audio = audio1[31];
                break;
            case "6":
                audio = audio1[32];
                break;
            case "7":
                audio = audio1[33];
                break;
            case "8":
                audio = audio1[34];
                break;
            case "9":
                audio = audio1[35];
                break;
        }
        return audio;
    }
}

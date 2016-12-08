package com.youngki.memory_project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
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
    MediaPlayer mp = new MediaPlayer();

    int audioNine[] = new int[]{
        R.raw.a24, R.raw.b24, R.raw.c24, R.raw.d24, R.raw.e24, R.raw.f24, R.raw.g24, R.raw.h24,
        R.raw.i24, R.raw.j24, R.raw.k24, R.raw.l24, R.raw.m24, R.raw.n24, R.raw.o24, R.raw.p24,
        R.raw.q24, R.raw.r24, R.raw.s24, R.raw.t24, R.raw.u24, R.raw.v24, R.raw.w24, R.raw.x24,
        R.raw.y24, R.raw.z24, R.raw.zero24, R.raw.one24, R.raw.two24,R.raw.three24, R.raw.four24,
        R.raw.five24, R.raw.six24, R.raw.seven24, R.raw.eight24, R.raw.nine24
    };
    int audioEight[] = new int[]{
        R.raw.a21, R.raw.b21, R.raw.c21, R.raw.d21, R.raw.e21, R.raw.f21, R.raw.g21, R.raw.h21,
        R.raw.i21, R.raw.j21, R.raw.k21, R.raw.l21, R.raw.m21, R.raw.n21, R.raw.o21, R.raw.p21,
        R.raw.q21, R.raw.r21, R.raw.s21, R.raw.t21, R.raw.u21, R.raw.v21, R.raw.w21, R.raw.x21,
        R.raw.y21, R.raw.z21, R.raw.zero21, R.raw.one21, R.raw.two21,R.raw.three21, R.raw.four21,
        R.raw.five21, R.raw.six21, R.raw.seven21, R.raw.eight21, R.raw.nine21
    };
    int audioSeven[] = new int[]{
        R.raw.a20, R.raw.b20, R.raw.c20, R.raw.d20, R.raw.e20, R.raw.f20, R.raw.g20, R.raw.h20,
        R.raw.i20, R.raw.j20, R.raw.k20, R.raw.l20, R.raw.m20, R.raw.n20, R.raw.o20, R.raw.p20,
        R.raw.q20, R.raw.r20, R.raw.s20, R.raw.t20, R.raw.u20, R.raw.v20, R.raw.w20, R.raw.x20,
        R.raw.y20, R.raw.z20, R.raw.zero20, R.raw.one20, R.raw.two20,R.raw.three20, R.raw.four20,
        R.raw.five20, R.raw.six20, R.raw.seven20, R.raw.eight20, R.raw.nine20
    };
    int audioSix[] = new int[]{
        R.raw.a6, R.raw.b6, R.raw.c6, R.raw.d6, R.raw.e6, R.raw.f6, R.raw.g6, R.raw.h6, R.raw.i6,
        R.raw.j6, R.raw.k6, R.raw.l6, R.raw.m6, R.raw.n6, R.raw.o6, R.raw.p6, R.raw.q6, R.raw.r6,
        R.raw.s6, R.raw.t6, R.raw.u6, R.raw.v6, R.raw.w6, R.raw.x6, R.raw.y6, R.raw.z6,
        R.raw.zero6, R.raw.one6, R.raw.two6,R.raw.three6, R.raw.four6, R.raw.five6, R.raw.six6,
        R.raw.seven6, R.raw.eight6, R.raw.nine6
    };
    int audioFive[] = new int[]{
        R.raw.a19, R.raw.b19, R.raw.c19, R.raw.d19, R.raw.e19, R.raw.f19, R.raw.g19, R.raw.h19,
        R.raw.i19, R.raw.j19, R.raw.k19, R.raw.l19, R.raw.m19, R.raw.n19, R.raw.o19, R.raw.p19,
        R.raw.q19, R.raw.r19, R.raw.s19, R.raw.t19, R.raw.u19, R.raw.v19, R.raw.w19, R.raw.x19,
        R.raw.y19, R.raw.z19, R.raw.zero19, R.raw.one19, R.raw.two19,R.raw.three19, R.raw.four19,
        R.raw.five19, R.raw.six19, R.raw.seven19, R.raw.eight19, R.raw.nine19
    };
    int audioFour[] = new int[]{
        R.raw.a0, R.raw.b0, R.raw.c0, R.raw.d0, R.raw.e0, R.raw.f0, R.raw.g0, R.raw.h0, R.raw.i0,
        R.raw.j0, R.raw.k0, R.raw.l0, R.raw.m0, R.raw.n0, R.raw.o0, R.raw.p0, R.raw.q0, R.raw.r0,
        R.raw.s0, R.raw.t0, R.raw.u0, R.raw.v0, R.raw.w0, R.raw.x0, R.raw.y0, R.raw.z0,
        R.raw.zero0, R.raw.one0, R.raw.two0,R.raw.three0, R.raw.four0, R.raw.five0, R.raw.six0,
        R.raw.seven0, R.raw.eight0, R.raw.nine0
    };

    //Use these first three
    int audioThree[] = new int[]{
        R.raw.a3, R.raw.b3, R.raw.c3, R.raw.d3, R.raw.e3, R.raw.f3, R.raw.g3, R.raw.h3, R.raw.i3,
        R.raw.j3, R.raw.k3, R.raw.l3, R.raw.m3, R.raw.n3, R.raw.o3, R.raw.p3, R.raw.q3, R.raw.r3,
        R.raw.s3, R.raw.t3, R.raw.u3, R.raw.v3, R.raw.w3, R.raw.x3, R.raw.y3, R.raw.z3, R.raw.zero3,
        R.raw.one3, R.raw.two3,R.raw.three3, R.raw.four3, R.raw.five3, R.raw.six3, R.raw.seven3,
        R.raw.eight3, R.raw.nine3
    };
    int audioTwo[] = new int[]{
        R.raw.a17, R.raw.b17, R.raw.c17, R.raw.d17, R.raw.e17, R.raw.f17, R.raw.g17, R.raw.h17,
        R.raw.i17, R.raw.j17, R.raw.k17, R.raw.l17, R.raw.m17, R.raw.n17, R.raw.o17, R.raw.p17,
        R.raw.q17, R.raw.r17, R.raw.s17, R.raw.t17, R.raw.u17, R.raw.v17, R.raw.w17, R.raw.x17,
        R.raw.y17, R.raw.z17, R.raw.zero17, R.raw.one17, R.raw.two17,R.raw.three17, R.raw.four17,
        R.raw.five17, R.raw.six17, R.raw.seven17, R.raw.eight17, R.raw.nine17
    };
    int audioOne[] = new int[]{
        R.raw.a1, R.raw.b1, R.raw.c1, R.raw.d1, R.raw.e1, R.raw.f1, R.raw.g1, R.raw.h1, R.raw.i1,
        R.raw.j1, R.raw.k1, R.raw.l1, R.raw.m1, R.raw.n1, R.raw.o1, R.raw.p1, R.raw.q1, R.raw.r1,
        R.raw.s1, R.raw.t1, R.raw.u1, R.raw.v1, R.raw.w1, R.raw.x1, R.raw.y1, R.raw.z1, R.raw.zero1,
        R.raw.one1, R.raw.two1,R.raw.three1, R.raw.four1, R.raw.five1, R.raw.six1, R.raw.seven1,
        R.raw.eight1, R.raw.nine1
    };
    int audioZero[] = new int[]{
        R.raw.a14, R.raw.b14, R.raw.c14, R.raw.d14, R.raw.e14, R.raw.f14, R.raw.g14, R.raw.h14,
        R.raw.i14, R.raw.j14, R.raw.k14, R.raw.l14, R.raw.m14, R.raw.n14, R.raw.o14, R.raw.p14,
        R.raw.q14, R.raw.r14, R.raw.s14, R.raw.t14, R.raw.u14, R.raw.v14, R.raw.w14, R.raw.x14,
        R.raw.y14, R.raw.z14, R.raw.zero14, R.raw.one14, R.raw.two14,R.raw.three14, R.raw.four14,
        R.raw.five14, R.raw.six14, R.raw.seven14, R.raw.eight14, R.raw.nine14
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
        b.setTextColor(Color.RED);
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
                if (mp != null){
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(repetitionTraining.this, getAudio(letter.toUpperCase()));
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mp.start();
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
                if (mp != null){
                    mp.stop();
                    mp.release();
                    mp = null;
                }
                mp = MediaPlayer.create(repetitionTraining.this, getAudio(Integer.toString(number)));
                mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mp.start();
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

    public void clearAudioSelection(){
        Button b;
        b = (Button) findViewById(R.id.audio0);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio1);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio2);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio3);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio4);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio5);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio6);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio7);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio8);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio9);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
    }

    public void onAudioSelectClick(View v){
        int id = v.getId();
        Button b;
        clearAudioSelection();
        switch (id){
            case R.id.audio0:
                audioSelection = 0;
                b = (Button) findViewById(R.id.audio0);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio1:
                audioSelection = 1;
                b = (Button) findViewById(R.id.audio1);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio2:
                audioSelection = 2;
                b = (Button) findViewById(R.id.audio2);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio3:
                audioSelection = 3;
                b = (Button) findViewById(R.id.audio3);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio4:
                audioSelection = 4;
                b = (Button) findViewById(R.id.audio4);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio5:
                audioSelection = 5;
                b = (Button) findViewById(R.id.audio5);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio6:
                audioSelection = 6;
                b = (Button) findViewById(R.id.audio6);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio7:
                audioSelection = 7;
                b = (Button) findViewById(R.id.audio7);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio8:
                audioSelection = 8;
                b = (Button) findViewById(R.id.audio8);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio9:
                audioSelection = 9;
                b = (Button) findViewById(R.id.audio9);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
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
        else if (audioSelection == 4){
            audio1 = audioFour;
        }
        else if (audioSelection == 5){
            audio1 = audioFive;
        }
        else if (audioSelection == 6){
            audio1 = audioSix;
        }
        else if (audioSelection == 7){
            audio1 = audioSeven;
        }
        else if (audioSelection == 8){
            audio1 = audioEight;
        }
        else if (audioSelection == 9){
            audio1 = audioNine;
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

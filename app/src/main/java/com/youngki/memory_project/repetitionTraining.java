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

    int audioEleven[] = new int[]{
            R.raw.a11, R.raw.b11, R.raw.c11, R.raw.d11, R.raw.e11, R.raw.f11, R.raw.g11, R.raw.h11,
            R.raw.i11, R.raw.j11, R.raw.k11, R.raw.l11, R.raw.m11, R.raw.n11, R.raw.o11, R.raw.p11,
            R.raw.q11, R.raw.r11, R.raw.s11, R.raw.t11, R.raw.u11, R.raw.v11, R.raw.w11, R.raw.x11,
            R.raw.y11, R.raw.z11, R.raw.zero11, R.raw.one11, R.raw.two11,R.raw.three11, R.raw.four11,
            R.raw.five11, R.raw.six11, R.raw.seven3, R.raw.eight11, R.raw.nine11
    };
    int audioTen[] = new int[]{
            R.raw.a10, R.raw.b10, R.raw.c10, R.raw.d10, R.raw.e10, R.raw.f10, R.raw.g10, R.raw.h10,
            R.raw.i10, R.raw.j10, R.raw.k10, R.raw.l10, R.raw.m10, R.raw.n10, R.raw.o10, R.raw.p10,
            R.raw.q10, R.raw.r10, R.raw.s10, R.raw.t10, R.raw.u10, R.raw.v10, R.raw.w10, R.raw.x10,
            R.raw.y10, R.raw.z10, R.raw.zero10, R.raw.one10, R.raw.two10,R.raw.three10, R.raw.four10,
            R.raw.five10, R.raw.six10, R.raw.seven10, R.raw.eight10, R.raw.nine10
    };
    int audioNine[] = new int[]{
            R.raw.a9, R.raw.b9, R.raw.c9, R.raw.d9, R.raw.e9, R.raw.f9, R.raw.g9, R.raw.h9, R.raw.i9,
            R.raw.j9, R.raw.k9, R.raw.l9, R.raw.m9, R.raw.n9, R.raw.o9, R.raw.p9, R.raw.q9, R.raw.r9,
            R.raw.s9, R.raw.t9, R.raw.u9, R.raw.v9, R.raw.w9, R.raw.x9, R.raw.y9, R.raw.z9,
            R.raw.zero9, R.raw.one9, R.raw.two9,R.raw.three9, R.raw.four9, R.raw.five9, R.raw.six9,
            R.raw.seven9, R.raw.eight9, R.raw.nine9
    };
    int audioEight[] = new int[]{
            R.raw.a8, R.raw.b8, R.raw.c8, R.raw.d8, R.raw.e8, R.raw.f8, R.raw.g8, R.raw.h8, R.raw.i8,
            R.raw.j8, R.raw.k8, R.raw.l8, R.raw.m8, R.raw.n8, R.raw.o8, R.raw.p8, R.raw.q8, R.raw.r8,
            R.raw.s8, R.raw.t8, R.raw.u8, R.raw.v8, R.raw.w8, R.raw.x8, R.raw.y8, R.raw.z8,
            R.raw.zero8, R.raw.one8, R.raw.two8,R.raw.three8, R.raw.four8, R.raw.five8, R.raw.six8,
            R.raw.seven8, R.raw.eight8, R.raw.nine8
    };
    int audioSeven[] = new int[]{
            R.raw.a12, R.raw.b12, R.raw.c12, R.raw.d12, R.raw.e12, R.raw.f12, R.raw.g12, R.raw.h12,
            R.raw.i12, R.raw.j12, R.raw.k12, R.raw.l12, R.raw.m12, R.raw.n12, R.raw.o12, R.raw.p12,
            R.raw.q12, R.raw.r12, R.raw.s12, R.raw.t12, R.raw.u12, R.raw.v12, R.raw.w12, R.raw.x12,
            R.raw.y12, R.raw.z12, R.raw.zero12, R.raw.one12, R.raw.two12,R.raw.three12, R.raw.four12,
            R.raw.five12, R.raw.six12, R.raw.seven12, R.raw.eight12, R.raw.nine12
    };
    int audioSix[] = new int[]{
            R.raw.a6, R.raw.b6, R.raw.c6, R.raw.d6, R.raw.e6, R.raw.f6, R.raw.g6, R.raw.h6, R.raw.i6,
            R.raw.j6, R.raw.k6, R.raw.l6, R.raw.m6, R.raw.n6, R.raw.o6, R.raw.p6, R.raw.q6, R.raw.r6,
            R.raw.s6, R.raw.t6, R.raw.u6, R.raw.v6, R.raw.w6, R.raw.x6, R.raw.y6, R.raw.z6,
            R.raw.zero6, R.raw.one6, R.raw.two6,R.raw.three6, R.raw.four6, R.raw.five6, R.raw.six6,
            R.raw.seven6, R.raw.eight6, R.raw.nine6
    };
    int audioFive[] = new int[]{
            R.raw.a5, R.raw.b5, R.raw.c5, R.raw.d5, R.raw.e5, R.raw.f5, R.raw.g5, R.raw.h5, R.raw.i5,
            R.raw.j5, R.raw.k5, R.raw.l5, R.raw.m5, R.raw.n5, R.raw.o5, R.raw.p5, R.raw.q5, R.raw.r5,
            R.raw.s5, R.raw.t5, R.raw.u5, R.raw.v5, R.raw.w5, R.raw.x5, R.raw.y5, R.raw.z5,
            R.raw.zero5, R.raw.one5, R.raw.two5,R.raw.three5, R.raw.four5, R.raw.five5, R.raw.six5,
            R.raw.seven5, R.raw.eight5, R.raw.nine5
    };
    int audioFour[] = new int[]{
            R.raw.a4, R.raw.b4, R.raw.c4, R.raw.d4, R.raw.e4, R.raw.f4, R.raw.g4, R.raw.h4, R.raw.i4,
            R.raw.j4, R.raw.k4, R.raw.l4, R.raw.m4, R.raw.n4, R.raw.o4, R.raw.p4, R.raw.q4, R.raw.r4,
            R.raw.s4, R.raw.t4, R.raw.u4, R.raw.v4, R.raw.w4, R.raw.x4, R.raw.y4, R.raw.z4,
            R.raw.zero4, R.raw.one4, R.raw.two4,R.raw.three4, R.raw.four4, R.raw.five4, R.raw.six4,
            R.raw.seven4, R.raw.eight4, R.raw.nine4
    };
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
        b = (Button) findViewById(R.id.audio10);
        b.setTypeface(Typeface.DEFAULT);
        b.setTextColor(Color.BLACK);
        b = (Button) findViewById(R.id.audio11);
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
            case R.id.audio10:
                audioSelection = 10;
                b = (Button) findViewById(R.id.audio10);
                b.setTypeface(Typeface.DEFAULT_BOLD);
                b.setTextColor(Color.RED);
                break;
            case R.id.audio11:
                audioSelection = 11;
                b = (Button) findViewById(R.id.audio11);
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
        else if (audioSelection == 10){
            audio1 = audioTen;
        }
        else if (audioSelection == 11){
            audio1 = audioEleven;
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

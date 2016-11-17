package com.youngki.memory_project;

import android.graphics.Color;
import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.Button;

public class DrawView extends View {

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    View hL, hN;

    public DrawView(Context context, Button hL, Button hN){
        super(context);
        paint.setColor(Color.BLACK);
        this.hL = findViewById(hL.getId());
        this.hN = findViewById(hN.getId());
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawLine(hL.getX(), hL.getY(), hN.getX(), hN.getY(), paint);
    }

}

package com.example.youngki.memory_project;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class NumberButtons extends AppCompatActivity implements View.OnClickListener {
  /**
   * Whether or not the system UI should be auto-hidden after
   * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
   */
  private static final boolean AUTO_HIDE = true;

  /**
   * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
   * user interaction before hiding the system UI.
   */
  private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

  /**
   * Some older devices needs a small delay between UI widget updates
   * and a change of the status and navigation bar.
   */
  private static final int UI_ANIMATION_DELAY = 300;
  private final Handler mHideHandler = new Handler();
  private final Runnable mShowPart2Runnable = new Runnable() {
    @Override public void run() {
      // Delayed display of UI elements
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null) {
        actionBar.show();
      }
    }
  };
  /**
   * Touch listener to use for in-layout UI controls to delay hiding the
   * system UI. This is to prevent the jarring behavior of controls going away
   * while interacting with activity UI.
   */
  private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
    @Override public boolean onTouch(View view, MotionEvent motionEvent) {
      if (AUTO_HIDE) {
        delayedHide(AUTO_HIDE_DELAY_MILLIS);
      }
      return false;
    }
  };
  int[] audio = new int[] {
      R.raw.zero, R.raw.one, R.raw.two, R.raw.three, R.raw.four, R.raw.five, R.raw.six, R.raw.seven,
      R.raw.eight, R.raw.nine
  };
  private View mContentView;
  private final Runnable mHidePart2Runnable = new Runnable() {
    @SuppressLint("InlinedApi") @Override public void run() {
      // Delayed removal of status and navigation bar
      // Note that some of these constants are new as of API 16 (Jelly Bean)
      // and API 19 (KitKat). It is safe to use them, as they are inlined
      // at compile-time and do nothing on earlier devices.
      mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
          | View.SYSTEM_UI_FLAG_FULLSCREEN
          | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
          | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
          | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
          | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
  };
  private boolean mVisible;
  private final Runnable mHideRunnable = new Runnable() {
    @Override public void run() {
      hide();
    }
  };

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_number_buttons);
    mVisible = true;
    mContentView = findViewById(R.id.fullscreen_content);
    // Set up the user interaction to manually show or hide the system UI.
    //mContentView.setOnClickListener(new View.OnClickListener() {
    //  @Override public void onClick(View view) {
    //    toggle();
    //  }
    //});
    // Upon interacting with UI controls, delay any scheduled hide()
    // operations to prevent the jarring behavior of controls going away
    // while interacting with the UI.
    findViewById(R.id.button_0).setOnClickListener(this);
    findViewById(R.id.button_1).setOnClickListener(this);
    findViewById(R.id.button_2).setOnClickListener(this);
    findViewById(R.id.button_3).setOnClickListener(this);
    findViewById(R.id.button_4).setOnClickListener(this);
    findViewById(R.id.button_5).setOnClickListener(this);
    findViewById(R.id.button_6).setOnClickListener(this);
    findViewById(R.id.button_7).setOnClickListener(this);
    findViewById(R.id.button_8).setOnClickListener(this);
    findViewById(R.id.button_9).setOnClickListener(this);
  }

  @Override protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    // Trigger the initial hide() shortly after the activity has been
    // created, to briefly hint to the user that UI controls
    // are available.
    delayedHide(100);
  }

  private void toggle() {
    if (mVisible) {
      hide();
    } else {
      show();
    }
  }

  private void hide() {
    // Hide UI first
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.hide();
    }
    mVisible = false;
    // Schedule a runnable to remove the status and navigation bar after a delay
    mHideHandler.removeCallbacks(mShowPart2Runnable);
    mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
  }

  @SuppressLint("InlinedApi") private void show() {
    // Show the system bar
    mContentView.setSystemUiVisibility(
        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    mVisible = true;
    // Schedule a runnable to display UI elements after a delay
    mHideHandler.removeCallbacks(mHidePart2Runnable);
    mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
  }

  /**
   * Schedules a call to hide() in [delay] milliseconds, canceling any
   * previously scheduled calls.
   */
  private void delayedHide(int delayMillis) {
    mHideHandler.removeCallbacks(mHideRunnable);
    mHideHandler.postDelayed(mHideRunnable, delayMillis);
  }

  @Override public void onClick(View v) {
    if (v.getId() == R.id.button_0) {
      MediaPlayer.create(NumberButtons.this, audio[0]).start();
    } else if (v.getId() == R.id.button_1) {
      MediaPlayer.create(NumberButtons.this, audio[1]).start();
    } else if (v.getId() == R.id.button_2) {
      MediaPlayer.create(NumberButtons.this, audio[2]).start();
    } else if (v.getId() == R.id.button_3) {
      MediaPlayer.create(NumberButtons.this, audio[3]).start();
    } else if (v.getId() == R.id.button_4) {
      MediaPlayer.create(NumberButtons.this, audio[4]).start();
    } else if (v.getId() == R.id.button_5) {
      MediaPlayer.create(NumberButtons.this, audio[5]).start();
    } else if (v.getId() == R.id.button_6) {
      MediaPlayer.create(NumberButtons.this, audio[6]).start();
    } else if (v.getId() == R.id.button_7) {
      MediaPlayer.create(NumberButtons.this, audio[7]).start();
    } else if (v.getId() == R.id.button_8) {
      MediaPlayer.create(NumberButtons.this, audio[8]).start();
    } else if (v.getId() == R.id.button_9) {
      MediaPlayer.create(NumberButtons.this, audio[9]).start();
    }
  }
}

package com.example.root.dmx;


import android.app.Activity;
import android.os.Bundle;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Geoff on 2017/12/31.
 */

public class wxn extends Activity {
    ImageView ivfly, ivleft, ivright;
    int screenWidth, screenHeight;
    float flyX, alpha;

    ViewGroup.LayoutParams params;

    Handler handler1 = new Handler();
    Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            setFlyX_Right();
            handler1.postDelayed(this, 20);
        }
    };

    private void setFlyX_Right() {
        if (ivfly.getX() < (screenWidth - params.width)) {
            flyX = ivfly.getX() + 15;
            ivfly.setX(flyX);
        } else {
            handler1.removeCallbacks(runnable1);
        }
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            setFlyX();
            handler.postDelayed(this, 20);
        }
    };

    private void setFlyX() {
        if (ivfly.getX() > 0) {
            flyX = ivfly.getX() - 15;
            ivfly.setX(flyX);
        } else {
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.wxn);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;
        screenWidth = dm.widthPixels;

        alpha = 98;
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (alpha > 0) {
                    ivleft.setAlpha(alpha / 100);
                    ivright.setAlpha(alpha / 100);
                    alpha = alpha - 2;
                } else {
                    alpha = 0;
                    ivleft.setAlpha(alpha);
                    ivright.setAlpha(alpha);
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask, 60, 40);

        ivfly = (ImageView) findViewById(R.id.fly);
        params = ivfly.getLayoutParams();

        flyX = screenWidth / 2 - (params.width / 2);
        ivfly.setX(flyX);
        ivleft = (ImageView) findViewById(R.id.ivleft);
        ivright = (ImageView) findViewById(R.id.ivright);

        ivleft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler1.removeCallbacks(runnable1);
                        handler.postDelayed(runnable, 0);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler.removeCallbacks(runnable);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        ivright.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        handler.removeCallbacks(runnable);
                        handler1.postDelayed(runnable1, 0);
                        break;
                    case MotionEvent.ACTION_UP:
                        handler1.removeCallbacks(runnable1);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }
}

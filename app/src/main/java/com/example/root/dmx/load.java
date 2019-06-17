package com.example.root.dmx;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by root on 12/23/17.
 */

public class load extends Activity {

    //private ImageView iv1;
    TextView tvloading;
    float alpha = 100;
    boolean aBoolean = true;
    int count = 0;

    final Timer timer = new Timer();
    final Timer timer1 = new Timer();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.load);

        tvloading = (TextView) findViewById(R.id.tvloading);
/*
        iv1 = (ImageView) findViewById(R.id.ivlogo);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(load.this, entry.class);
                startActivity(intent);
            }
        });*/

    }

    @Override
    protected void onResume() {
        super.onResume();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (aBoolean) {
                    if (alpha <= 20) {
                        aBoolean = false;
                    } else {
                        alpha = alpha - 2;
                        tvloading.setAlpha(alpha / 100);
                    }
                } else {
                    if (alpha >= 100) {
                        aBoolean = true;
                    } else {
                        alpha = alpha + 2;
                        tvloading.setAlpha(alpha / 100);
                    }
                }
            }
        };
        timer.schedule(timerTask, 500, 40);

        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                if (count >= 7) {
                    Intent intent = new Intent(load.this, cover.class);
                    startActivity(intent);
                } else {
                    count++;
                }
            }
        };
        timer1.schedule(timerTask1, 500, 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
        timer1.cancel();
        load.this.finish();
    }
}


package com.example.root.dmx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by root on 12/24/17.
 */

public class entry extends Activity {

/*
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(entry.this, "dddd", Toast.LENGTH_SHORT).show();
        }
    };*/

    private ImageView ivsp;
    private ImageView ivsettings, ivvolume, ivshare;
    private TextView tvsp;
    private TextView tvsettings;
    private boolean t = false;
    boolean isfirstpress = false;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            reset();
            handler.postDelayed(this, 2000);
        }
    };

    private void reset() {
        isfirstpress = false;
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.entry);

        /*
        Timer tm = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };
        tm.schedule(task, 1000);*/

        ivsp = (ImageView) findViewById(R.id.ivbuttonback);
        ivsettings = (ImageView) findViewById(R.id.ivbuttonback2);
        tvsp = (TextView) findViewById(R.id.tvsp);
        tvsettings = (TextView) findViewById(R.id.tvsettings);
        ivshare = (ImageView) findViewById(R.id.ivshare);
        ivvolume = (ImageView) findViewById(R.id.ivvolume);

        ivsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entry.this, gamechoose.class);
                startActivity(intent);
            }
        });
        tvsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entry.this, gamechoose.class);
                startActivity(intent);
            }
        });
        tvsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entry.this, about.class);
                startActivity(intent);
            }
        });
        ivsettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entry.this, about.class);
                startActivity(intent);
            }
        });
        ivvolume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(entry.this, R.string.jokingvolume, Toast.LENGTH_SHORT).show();
            }
        });
        ivshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(entry.this, R.string.share, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (!isfirstpress) {
                    isfirstpress = true;
                    Toast.makeText(entry.this, R.string.presstoexit, Toast.LENGTH_SHORT).show();
                    handler.postDelayed(runnable, 2000);
                    return true;
                } else {
                    System.exit(0);
                }
                break;
            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    /*
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (t) {
            finish();
        } else {
            Toast.makeText(entry.this, "zai an yi ci tui chu", Toast.LENGTH_LONG);
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    t = true;
                }
            };
            timer.schedule(task, 3000);
        }
    }*/
}

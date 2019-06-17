package com.example.root.dmx;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by Geoff on 2017/12/31.
 */

public class cover extends Activity {
    GifImageView gifmain;
    TextView tvpresstocontinue;
    ImageView ivpress;
    float tvPresstoContinueAlpha = 100;
    boolean isAlpha = false, backpressed = false;
    MediaPlayer mediaPlayer;

    Timer timer = new Timer();

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            backFirstPress();
            handler.postDelayed(this, 2000);
        }
    };

    private void backFirstPress() {
        backpressed = false;
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.cover);

        gifmain = (GifImageView) findViewById(R.id.gifmain);
        tvpresstocontinue = (TextView) findViewById(R.id.presstocontinue);
        ivpress = (ImageView) findViewById(R.id.ivpress);

        tvpresstocontinue.setAlpha(0);

        mediaPlayer = MediaPlayer.create(cover.this, R.raw.apptheme);
        mediaPlayer.start();

        ivpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cover.this, entry.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
        mediaPlayer.stop();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (isAlpha) {
                    if (tvPresstoContinueAlpha <= 20) {
                        isAlpha = false;

                    } else {
                        tvPresstoContinueAlpha = tvPresstoContinueAlpha - 2;
                        tvpresstocontinue.setAlpha(tvPresstoContinueAlpha / 100);
                    }
                } else {
                    if (tvPresstoContinueAlpha >= 100) {
                        isAlpha = true;
                    } else {
                        tvPresstoContinueAlpha = tvPresstoContinueAlpha + 2;
                        tvpresstocontinue.setAlpha(tvPresstoContinueAlpha / 100);
                    }
                }
            }
        };
        timer.schedule(timerTask, 2000, 45);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if (!backpressed) {
                    backpressed = true;
                    Toast.makeText(cover.this, R.string.presstoexit, Toast.LENGTH_SHORT).show();
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
}

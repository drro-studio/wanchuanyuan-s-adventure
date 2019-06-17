package com.example.root.dmx;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by root on 12/28/17.
 */

public class wanfeifei extends Activity {

    MediaPlayer mediaPlayer = null;
    ImageView ivwf;
    int a = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.wanfeifei);

        Toast.makeText(wanfeifei.this, R.string.dress, Toast.LENGTH_SHORT).show();

        mediaPlayer = MediaPlayer.create(this, R.raw.main);
        mediaPlayer.start();
        ivwf = (ImageView) findViewById(R.id.ivwff);

        ivwf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*switch (a) {
                    case 0: {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(wanfeifei.this, R.raw.fail);
                        mediaPlayer.start();
                        a++;
                    }
                    case 1: {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(wanfeifei.this, R.raw.success);
                        mediaPlayer.start();
                        a++;
                    }
                    case 2: {
                        mediaPlayer.stop();
                        mediaPlayer = MediaPlayer.create(wanfeifei.this, R.raw.main);
                        mediaPlayer.start();
                        a = 0;
                    }
                }*/
                switch (a) {
                    case 0:
                        ivwf.setBackground(getResources().getDrawable(R.drawable.bird2));
                        Toast.makeText(wanfeifei.this, R.string.meizizi, Toast.LENGTH_SHORT).show();
                        a++;
                        break;
                    case 1:
                        ivwf.setBackground(getResources().getDrawable(R.drawable.bird3));
                        Toast.makeText(wanfeifei.this, R.string.meizizi, Toast.LENGTH_SHORT).show();
                        a++;
                        break;
                    case 2:
                        ivwf.setBackground(getResources().getDrawable(R.drawable.bird4));
                        Toast.makeText(wanfeifei.this, R.string.meizizi, Toast.LENGTH_SHORT).show();
                        a++;
                        break;
                    case 3:
                        ivwf.setBackground(getResources().getDrawable(R.drawable.bird));
                        Toast.makeText(wanfeifei.this, R.string.meizizi, Toast.LENGTH_SHORT).show();
                        a = 0;
                        break;
                    default:
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
        wanfeifei.this.finish();
    }
}

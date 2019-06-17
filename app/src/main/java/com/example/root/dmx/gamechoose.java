package com.example.root.dmx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 12/26/17.
 */

public class gamechoose extends Activity {

    private TextView tvgame1;
    private ImageView iv1;
    private TextView tvmore;
    private ImageView ivmore;
    TextView tvwanxiaoniao, tvqiexianfangcheng;
    ImageView ivwanxiaoniao, ivqiexianfangcheng;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.gamechoose);

        tvgame1 = (TextView) findViewById(R.id.tvwanfeifei);
        tvmore = (TextView) findViewById(R.id.tvmore);
        iv1 = (ImageView) findViewById(R.id.ivwanfeifei);
        ivmore = (ImageView) findViewById(R.id.ivmore);
        tvwanxiaoniao = (TextView) findViewById(R.id.tvwanxiaoniao);
        ivwanxiaoniao = (ImageView) findViewById(R.id.ivwanxiaoniao);
        tvqiexianfangcheng = (TextView) findViewById(R.id.tvqiexianfangcheng);
        ivqiexianfangcheng = (ImageView) findViewById(R.id.ivqiexianfangcheng);


        tvqiexianfangcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(gamechoose.this, R.string.geer, Toast.LENGTH_SHORT).show();
            }
        });
        ivqiexianfangcheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(gamechoose.this, R.string.geer, Toast.LENGTH_SHORT).show();
            }
        });
        tvmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(gamechoose.this, R.string.more, Toast.LENGTH_SHORT).show();
            }
        });
        ivmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(gamechoose.this, R.string.more, Toast.LENGTH_SHORT).show();
            }
        });
        tvgame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gamechoose.this, wanfeifei.class);
                startActivity(intent);
            }
        });
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(gamechoose.this, wanfeifei.class);
                startActivity(intent);
            }
        });
        tvwanxiaoniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gamechoose.this, wxn.class);
                startActivity(intent);
            }
        });
        ivwanxiaoniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gamechoose.this, wxn.class);
                startActivity(intent);
            }
        });
        /*tvwanxiaoniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gamechoose.this, wanxiaoniao.class);
                startActivity(intent);
            }
        });
        ivwanxiaoniao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(gamechoose.this, wanxiaoniao.class);
                startActivity(intent);
            }
        });*/
    }

}

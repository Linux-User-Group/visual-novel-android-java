package com.example.cantmakeyouloveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button btnMulai, btnKeluar;
    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();

        audio = MediaPlayer.create(this, R.raw.sound2);
        audio.setVolume(1,1);
        audio.start();

        btnMulai = (Button)findViewById(R.id.btnMulai);
        btnKeluar = (Button)findViewById(R.id.btnKeluar);

        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Loading.class));
                audio.setVolume(0,0);
                audio.stop();
            }
        });

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), PopUp.class));
                audio.setVolume(0,0);
                audio.stop();
            }
        });
    }
}
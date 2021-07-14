package com.example.cantmakeyouloveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Credit extends AppCompatActivity {

    TextView txtCredit;
    Animation animation;
    MediaPlayer audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_credit);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.credit);
        txtCredit = (TextView)findViewById(R.id.txtCredit);

        audio = MediaPlayer.create(this, R.raw.sound2);
        audio.setVolume(1,1);
        audio.start();

        txtCredit.setText(
                "THE END \n"
                +"BEST ON TRUE STORY \n"
                +"\n \n KARAKTER \n"
                +"\n Karakter 1 - Lail \n"
                +"Karakter 2 - Apweel \n"
                +"Karakter 3 - Odel \n"
                +"Karakter 4 - Jufer \n"
                +"Karakter 5 - Laoegi \n"
                +"\n \n Lagu \n "
                +"\n i can't make you love me - dave thomas junior \n"
                +"Yukitoki (Piano OST Ver.) - Oregairu Kan Episode 11 OST / Oregairu Zoku OST [Synthesia] \n"
        );

        txtCredit.startAnimation(animation);
        txtCredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Home.class));
                audio.setVolume(0,0);
                audio.stop();
                finish();
            }
        });



    }
}
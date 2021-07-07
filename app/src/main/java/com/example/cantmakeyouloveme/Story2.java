package com.example.cantmakeyouloveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Story2 extends AppCompatActivity {

    ImageView femaleChar;
    Animation slideDown;
    TextView txtStory;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_story2);

        Intent intent = getIntent();

        text = "Besok harinya siang hari hujan ";

        txtStory = (TextView)findViewById(R.id.txtStory);
        femaleChar = (ImageView)findViewById(R.id.femaleChar);

        slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        femaleChar.setAnimation(slideDown);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                txtStory.setText(text);
            }
        }, 500);
    }
}
package com.example.cantmakeyouloveme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Story1 extends AppCompatActivity {

    ImageView maleChar1;
    Animation slideDown;
    TextView txtStory;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_story1);

        Intent intent = getIntent();

        text = "Malam hari dikamar “join discord” ngobrol tugas lalu april mengajak untuk keluar ke rumah adel";

        txtStory = (TextView)findViewById(R.id.txtStory);
        maleChar1 = (ImageView)findViewById(R.id.maleChar1);

        slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);

        maleChar1.setAnimation(slideDown);

        txtStory.setText(text);

    }
}
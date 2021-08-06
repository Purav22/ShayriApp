    package com.example.allshayri2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    Animation topAnimation, bottomAnimation;
    View first, second, third, four, five ,six, second2, third2, four2, five2 ,six2;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        topAnimation = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnimation = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        four = findViewById(R.id.four_line);
        five = findViewById(R.id.five_line);
        six = findViewById(R.id.six_line);
        second2 = findViewById(R.id.second2_line);
        third2 = findViewById(R.id.third2_line);
        four2 = findViewById(R.id.four2_line);
        five2 = findViewById(R.id.five2_line);
        six2 = findViewById(R.id.six2_line);

        text = findViewById(R.id.textView);

        first.setAnimation(topAnimation);
        second.setAnimation(topAnimation);
        third.setAnimation(topAnimation);
        five.setAnimation(topAnimation);
        four.setAnimation(topAnimation);
        six.setAnimation(topAnimation);
        second2.setAnimation(topAnimation);
        third2.setAnimation(topAnimation);
        four2.setAnimation(topAnimation);
        five2.setAnimation(topAnimation);
        six2.setAnimation(topAnimation);

        text.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
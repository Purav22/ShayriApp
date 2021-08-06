package com.example.allshayri2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;

import static android.content.ContentValues.TAG;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    String[] title;
    Animation ani;
    AdView mAdView;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        ani = AnimationUtils.loadAnimation(this, R.anim.animation1);
        listView = findViewById(R.id.listview);
        Integer[] image = {R.drawable.goodmorning, R.drawable.goodnight, R.drawable.love,
                R.drawable.friend, R.drawable.attitude, R.drawable.emoji, R.drawable.funny,
                R.drawable.birthday, R.drawable.romantic, R.drawable.life, R.drawable.god,
                R.drawable.sad, R.drawable.happy, R.drawable.dard, R.drawable.intezar,
                R.drawable.bewfa, R.drawable.navratri, R.drawable.newyear, R.drawable.chrismas,
                R.drawable.goodmorning, R.drawable.goodnight, R.drawable.goodnight, R.drawable.goodnight,
                R.drawable.goodnight, R.drawable.goodnight, R.drawable.goodnight, R.drawable.goodnight,
                R.drawable.goodnight, R.drawable.goodnight, R.drawable.goodnight, R.drawable.goodnight};
//        listView.setAnimation(ani);
        title = getResources().getStringArray(R.array.title);
        MainAdapter adapter = new MainAdapter(SecondActivity.this, title, image);



        listView.setAdapter(adapter);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

//        loadIn();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent secondIntent = new Intent(SecondActivity.this, ThirdActivity.class);
                secondIntent.putExtra("title", title[i]);
                startActivity(secondIntent);

            }
        });

    }

}

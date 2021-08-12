package com.kpdigital.Allshayri2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;

public class SecondActivity extends AppCompatActivity {

    ListView listView;
    String[] title;
    Animation ani;
    AdView mAdView;
//    private InterstitialAd mInterstitialAd;


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
                R.drawable.goodmorning, R.drawable.republic, R.drawable.goodnight, R.drawable.rakshabandhan,
                R.drawable.diwali, R.drawable.maa, R.drawable.baap, R.drawable.family,
                R.drawable.sharabi, R.drawable.cute, R.drawable.goodnight, R.drawable.goodnight};
//        listView.setAnimation(ani);
        title = getResources().getStringArray(R.array.title);
        MainAdapter adapter = new MainAdapter(SecondActivity.this, title, image);



        listView.setAdapter(adapter);
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

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

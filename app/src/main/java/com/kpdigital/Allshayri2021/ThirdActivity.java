package com.kpdigital.Allshayri2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;

public class ThirdActivity extends AppCompatActivity {

    String title;
    String[] str;
    ListView second_list;
    AdView mAdView;
//    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        second_list = findViewById(R.id.second_list);

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
        title = getIntent().getStringExtra("title");

        if (title.equals("Good morning shayri")) {
            str = getResources().getStringArray(R.array.goodmorning);
        }
        if (title.equals("Good night shayri")) {
            str = getResources().getStringArray(R.array.goodnight);
        }

        if (title.equals("Love shayri")) {
            str = getResources().getStringArray(R.array.loveshayri);
        }
        if (title.equals("Friend shayri")) {
            str = getResources().getStringArray(R.array.friend);
        }
        if (title.equals("Attitude shayri")) {
            str = getResources().getStringArray(R.array.attitude);
        }
        if (title.equals("Emoji shayri")) {
            str = getResources().getStringArray(R.array.emoji);
        }

        if (title.equals("Funny shayri")) {
            str = getResources().getStringArray(R.array.funny);
        }
        if (title.equals("Birthday shayri")) {
            str = getResources().getStringArray(R.array.birthday);
        }
        if (title.equals("Romantic shayri")) {
            str = getResources().getStringArray(R.array.romantic);
        }
        if (title.equals("Life shayri")) {
            str = getResources().getStringArray(R.array.life);
        }
        if (title.equals("God shayri")) {
            str = getResources().getStringArray(R.array.god);
        }
        if (title.equals("Sad shayri")) {
            str = getResources().getStringArray(R.array.sad);
        }

        if (title.equals("Happy shayri")) {
            str = getResources().getStringArray(R.array.happy);
        }
        if (title.equals("Dard shayri")) {
            str = getResources().getStringArray(R.array.dard);
        }

        if (title.equals("Intezar shayri")) {
            str = getResources().getStringArray(R.array.intezar);
        }
        if (title.equals("Bewafa shayri")) {
            str = getResources().getStringArray(R.array.bewafa);
        }
        if (title.equals("Navratri shayri")) {
            str = getResources().getStringArray(R.array.navratri);
        }
        if (title.equals("New year shayri")) {
            str = getResources().getStringArray(R.array.newyear);
        }
        if (title.equals("Chrismas shayri")) {
            str = getResources().getStringArray(R.array.chismas);
        }
        if (title.equals("Utrayan shayri")) {
            str = getResources().getStringArray(R.array.utrayan);
        }
        if (title.equals("Republicday shayri")) {
            str = getResources().getStringArray(R.array.republic);
        }
        if (title.equals("Valentine shayri")) {
            str = getResources().getStringArray(R.array.valentine);
        }

        if (title.equals("Rakshabandhan shayri")) {
            str = getResources().getStringArray(R.array.rakshabandhan);
        }
        if (title.equals("Diwali shayri")) {
            str = getResources().getStringArray(R.array.diwali);
        }
        if (title.equals("Maa shayri")) {
            str = getResources().getStringArray(R.array.maa);
        }
        if (title.equals("Baap shayri")) {
            str = getResources().getStringArray(R.array.baap);
        }
        if (title.equals("Family shayri")) {
            str = getResources().getStringArray(R.array.family);
        }
        if (title.equals("Sharabi shayri")) {
            str = getResources().getStringArray(R.array.sharabi);
        }
        if (title.equals("Cutness shayri")) {
            str = getResources().getStringArray(R.array.cutness);
        }
        if (title.equals("2 line shayri")) {
            str = getResources().getStringArray(R.array.line);
        }

        if (title.equals("All in one")) {
            str = getResources().getStringArray(R.array.allinone);
        }

        SecondAdapter add = new SecondAdapter(ThirdActivity.this, str);
        second_list.setAdapter(add);
        second_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent last = new Intent(ThirdActivity.this, ShayriLastActivity.class);
                last.putExtra("shayri", str);
                last.putExtra("position", i);
                startActivity(last);

            }
        });

    }


}

package com.kpdigital.Allshayri2021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import top.defaults.colorpicker.ColorPickerPopup;


public class ShayriLastActivity extends AppCompatActivity {

    int pos;
    String[] shayri;
    TextView textView;
    Button next, previous, share, copy, edit;
    AlertDialog.Builder builder;
    Animation animation;
    AdView mAdView;
    AdRequest adRequest;
    int countMove = 0;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayri_last);
        animation = AnimationUtils.loadAnimation(this, R.anim.animation2);
        textView = findViewById(R.id.shayri_last_view);
        builder = new AlertDialog.Builder(this);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        share = findViewById(R.id.share);
        copy = findViewById(R.id.copy);
        edit = findViewById(R.id.edit);

        pos = getIntent().getIntExtra("position", 0);
        shayri = getIntent().getStringArrayExtra("shayri");

        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
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
        textView.setText("" + shayri[pos]);
        textView.setAnimation(animation);




        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos--;
                countMove++;
                try {
                    textView.setAnimation(animation);
                    textView.setText("" + shayri[pos]);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(countMove % 5 == 0) {
                    showMeAd();
                }

            }


        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos++;

                countMove++;
                try {
                    textView.setAnimation(animation);
                    textView.setText("" + shayri[pos]);

                } catch (Exception e) {
                }
                if(countMove % 5 == 0) {
                    showMeAd();
                }
            }
        });
        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = textView.getText().toString();
                ClipboardManager clipbord = (ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("test", ss);
                clipbord.setPrimaryClip(clip);
                showtoast();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new ColorPickerPopup.Builder(ShayriLastActivity.this)
                       .initialColor(android.R.color.white)
                       .enableBrightness(true)
                       .okTitle("Choose Colour")
                       .cancelTitle("Cancel")
                       .showIndicator(true)
                       .showValue(true)
                       .build()
                       .show(v, new ColorPickerPopup.ColorPickerObserver() {
                           @Override
                           public void onColorPicked(int color) {
                               textView.setTextColor(color);
                           }

                           @Override
                           public void onColor(int color, boolean fromUser) {
//                               textView.setTextColor(color);
                           }
                       });


//                Intent intent = new Intent(getApplicationContext(), editImageAndFont.class);
//                intent.putExtra("shayri", shayri[pos]);
//                startActivity(intent);



            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ss = textView.getText().toString();
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\n" + ss + "\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n" + "download this ";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {

                }

            }
        });


    }

    private void showMeAd() {
        InterstitialAd.load(this,getString(R.string.InterstitialAds), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when fullscreen content is dismissed.
                                Log.d("TAG", "The ad was dismissed.");
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when fullscreen content failed to show.
                                Log.d("TAG", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when fullscreen content is shown.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                mInterstitialAd = null;
                                Log.d("TAG", "The ad was shown.");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
        if (mInterstitialAd != null) {
            mInterstitialAd.show(ShayriLastActivity.this);
        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
        }
        countMove = 0;
    }

    void showtoast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}

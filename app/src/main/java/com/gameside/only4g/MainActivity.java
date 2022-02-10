package com.gameside.only4g;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.gameside.only4g.MyObjects.AdmobAds;
import com.gameside.only4g.MyObjects.RadioInfoSettings;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioInfoSettings radioInfoSettings = new RadioInfoSettings();

        AdView adView = findViewById(R.id.adView);
        Button button = findViewById(R.id.go_but);


        howToText();
        troubleText();
        privacyAndTerm();

        //admob ads
        AdmobAds admobAds = new AdmobAds();
        admobAds.bannerAd(MainActivity.this, adView);

        //interstitial ads
        admobAds.interstitialAd(MainActivity.this,"ca-app-pub-1757707746288682/6597182450");

        button.setOnClickListener(view -> {
            radioInfoSettings.openSettings(MainActivity.this);

            //load interstitial ad
            admobAds.loadInterstialAd(MainActivity.this);

        });
    }
    @SuppressLint("SetTextI18n")
    public void howToText(){

        TextView textView = findViewById(R.id.hototext);
        textView.setText(
                "1. Make sure your sim card is in first slot.\n" +
                "2. Open settings from below button.\n" +
                        "3. Scroll down to  set preference network type.\n" +
                        "4. Select LTE only option."
        );
    }
    @SuppressLint("SetTextI18n")
    public void troubleText(){
        TextView textView = findViewById(R.id.troubletext);
        textView.setText("Q. Cant received calls\n" +
                "-> In some device model after forcing 4g mode it will block your incoming and outgoing call, so after use of 4g network you need to set again default mode.\n" +
                "\n" +
                "Q. Doesn't getting any network\n" +
                "-> After set LTE only if you doesn't getting any network, That's means there is no 4g network available.\n" +
                "\n" +
                "Q. Can't open settings\n" +
                "-> It's weird to here this, we will fix this later.\n" +
                "\n" +
                "Q. After set LTE only mode it gets back to the 2g/3g\n" +
                "-> There is some reason behind this problem\n" +
                " 1. If you don't have 4g network at that place, make sure your device already on 4g network.\n" +
                " 2. Here is an example :  if your network is on 2g or 3g. And you use this app to get 4g. Sometime settings revert to default option. So for that make sure your network is on 4g.\n" +
                " 3. Trying multiple times solve this problem");
    }
    public void privacyAndTerm(){
        //terms and conditions https://gamesidein.blogspot.com/p/terms-condition-only-4g.html
        //privacy and policy  https://gamesidein.blogspot.com/p/privacy-policy-only-4g.html

        TextView privacybut = findViewById(R.id.privacybut);
        TextView termbut = findViewById(R.id.termbut);
        privacybut.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://gamesidein.blogspot.com/p/privacy-policy-only-4g.html"));
            startActivity(intent);
        });
        termbut.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://gamesidein.blogspot.com/p/terms-condition-only-4g.html"));
            startActivity(intent);
        });
    }

}
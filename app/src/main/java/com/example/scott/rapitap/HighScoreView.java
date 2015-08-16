package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.AdRequest;



public class HighScoreView extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.highscoreview);

/*        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/

        // import font
        final TextView hiScoreTitleTextView = (TextView) findViewById(R.id.hiScoreTitleTextView);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        hiScoreTitleTextView.setTypeface(myfont);


        // Bring in high scores
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        int currentLevelOneHighScore = scorePref.getInt("levelOneScore", 0);
        int currentLevelTwoHighScore = scorePref.getInt("levelTwoScore", 0);
        int currentLevelThreeHighScore = scorePref.getInt("levelThreeScore", 0);
        int currentLevelFourHighScore = scorePref.getInt("levelFourScore", 0);
        int currentLevelFiveHighScore = scorePref.getInt("levelFiveScore", 0);

        // Set Hi-Score int to String value
        final TextView levelOneHiScoreTextView = (TextView) findViewById(R.id.levelOneHiScoreTextView);
        levelOneHiScoreTextView.setTypeface(myfont);
        levelOneHiScoreTextView.setText(String.valueOf(currentLevelOneHighScore));

        final TextView levelTwoHiScoreTextView = (TextView) findViewById(R.id.levelTwoHiScoreTextView);
        levelTwoHiScoreTextView.setTypeface(myfont);
        levelTwoHiScoreTextView.setText(String.valueOf(currentLevelTwoHighScore));

        final TextView levelThreeHiScoreTextView = (TextView) findViewById(R.id.levelThreeHiScoreTextView);
        levelThreeHiScoreTextView.setTypeface(myfont);
        levelThreeHiScoreTextView.setText(String.valueOf(currentLevelThreeHighScore));

        final TextView levelFourHiScoreTextView = (TextView) findViewById(R.id.levelFourHiScoreTextView);
        levelFourHiScoreTextView.setTypeface(myfont);
        levelFourHiScoreTextView.setText(String.valueOf(currentLevelFourHighScore));

        final TextView levelFiveHiScoreTextView = (TextView) findViewById(R.id.levelFiveHiScoreTextView);
        levelFiveHiScoreTextView.setTypeface(myfont);
        levelFiveHiScoreTextView.setText(String.valueOf(currentLevelFiveHighScore));




        final TextView mainMenuBtnView = (TextView) findViewById(R.id.mainMenuBtnView);
        mainMenuBtnView.setTypeface(myfont);
        mainMenuBtnView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(HighScoreView.this, SplashActivity.class);
                //finish();
                startActivity(mainMenuIntent);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}

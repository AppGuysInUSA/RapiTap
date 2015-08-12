package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.AdRequest;



public class LevelOneActivity extends Activity implements OnClickListener {

    // Start counter variable and firstClick trigger
    int tapCount = 0;
    int firstClick = 0;
    boolean roundStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.level_one);

/*        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/

        // import font
        final TextView tapCountTextView = (TextView) findViewById(R.id.tapCountTextView);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        tapCountTextView.setTypeface(myfont);

        final TextView roundOverView = (TextView) findViewById(R.id.roundOverView);
        roundOverView.setTypeface(myfont);

        final TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
        nextLevelView.setTypeface(myfont);
        nextLevelView.setAlpha(0);

        final TextView timerView = (TextView) findViewById(R.id.timerView);
        timerView.setTypeface(myfont);

        final TextView hiScoreTitleTextView = (TextView) findViewById(R.id.hiScoreTitleTextView);
        hiScoreTitleTextView.setTypeface(myfont);

        final TextView hiScoreTextView = (TextView) findViewById(R.id.hiScoreTextView);
        hiScoreTextView.setTypeface(myfont);

        final TextView levelOneRulesView = (TextView) findViewById(R.id.levelOneRulesView);
        levelOneRulesView.setTypeface(myfont);


        // Start of buttons
        final TextView resetView = (TextView) findViewById(R.id.resetView);
        resetView.setTypeface(myfont);
        resetView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        final TextView mainMenuBtnView = (TextView) findViewById(R.id.mainMenuBtnView);
        mainMenuBtnView.setTypeface(myfont);
        mainMenuBtnView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(LevelOneActivity.this, SplashActivity.class);
                finish();
                startActivity(mainMenuIntent);
            }
        });

        final ImageButton tapBtn = (ImageButton) findViewById(R.id.tapBtn);
        tapBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                firstClick++;
                tapCount++;
                //long timePassed = 0;
                tapCountTextView.setText(String.valueOf(tapCount));

                if (firstClick == 1) {
                    new CountDownTimer(5000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            timerView.setText("Seconds Remaining: " + millisUntilFinished / 1000);
                            tapBtn.setBackgroundResource(R.drawable.btn_states);
                            roundStarted = true;

                            if (millisUntilFinished > 2000 && tapCount > 20){
                                roundOverView.setText("Spectacular!");
                            }
                        }

                        public void onFinish() {
                            timerView.setText("Times Up!");
                            tapBtn.setBackgroundResource(R.drawable.redbutton);

                            if (timerView.getText() == ("Times Up!") && tapCount <= 24) {
                                roundOverView.setText("Yikes!");
                                resetView.setText("Try Again");
                                roundStarted = false;
                            }

                            if (timerView.getText() == ("Times Up!") && tapCount > 24) {
                                roundOverView.setText("Good Job!");
                                nextLevelView.setAlpha(1);
                                roundStarted = false;
                                //  hiScoreTextView.setText(Integer.toString(tapCount));

                                //TextView tv = (TextView) findViewById(R.id.hiScoreTextView);
                                //tv.setText(String.valueOf(tapCount));
                            }

                            if (!roundStarted) {
                                tapBtn.setOnClickListener(null);
                                //timePassed++;
                            }
                        }
                    }.start();
                }
/*
                if (timerView.getText() == ("Times Up!") && tapCount > 24) {
                    roundOverView.setText("Good Job!");
                    nextLevelView.setAlpha(1);
                    //  hiScoreTextView.setText(Integer.toString(tapCount));

                    //TextView tv = (TextView) findViewById(R.id.hiScoreTextView);
                    //tv.setText(String.valueOf(tapCount));
                }
*/
                nextLevelView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent levelTwoIntent = new Intent(LevelOneActivity.this, LevelTwoActivity.class);
                        finish();
                        startActivity(levelTwoIntent);
                    }
                });
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}

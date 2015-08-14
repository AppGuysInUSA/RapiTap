package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class LevelFiveActivity extends Activity implements OnClickListener {

    // Start counter variable and firstClick trigger
    int tapCount = 0;
    int newLevelFiveScore = 0;
    int firstClick = 0;
    boolean roundStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.level_five);

/*        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/

        // import font
        final TextView tapCountTextView = (TextView) findViewById(R.id.tapCountTextView);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        tapCountTextView.setTypeface(myfont);

        // Check String Values for Resume Game
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        int levelFiveScore = scorePref.getInt("levelFiveScore", 0);
        String levelUnlocked = scorePref.getString("levelUnlocked", "locked");
        if(levelUnlocked.equals("five") || levelFiveScore > 14){

            TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
            nextLevelView.setTypeface(myfont);
            nextLevelView.setAlpha(1);
            nextLevelView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //Intent levelTwoIntent = new Intent(LevelFiveActivity.this, LevelFiveActivity.class);
                    //finish();
                    //startActivity(levelTwoIntent);
                }
            });
        } else {

            TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
            nextLevelView.setTypeface(myfont);
            nextLevelView.setAlpha(0);

        }

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

        final TextView levelRulesView = (TextView) findViewById(R.id.levelRulesView);
        levelRulesView.setTypeface(myfont);

        displayScore();


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
                Intent mainMenuIntent = new Intent(LevelFiveActivity.this, SplashActivity.class);
                finish();
                startActivity(mainMenuIntent);
            }
        });

        final ImageButton tapBtn = (ImageButton) findViewById(R.id.tapBtn);
        tapBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                firstClick++;
                tapCount++;
                tapCountTextView.setText(String.valueOf(tapCount));

                if (firstClick == 1) {
                    new CountDownTimer(1000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            timerView.setText("Seconds Remaining: " + millisUntilFinished / 1000 + " ms" +
                                    millisUntilFinished / 1000);
                            tapBtn.setBackgroundResource(R.drawable.btn_states);
                            roundStarted = true;

                            if (millisUntilFinished  > 0.500 && tapCount > 7){
                                roundOverView.setText("Sizzlin!");
                                tapBtn.setBackgroundResource(R.drawable.btn_bonus_states);
                            }

                            if (millisUntilFinished  > 0.250 && tapCount > 3){
                                roundOverView.setText("Lightnin!");
                                tapBtn.setBackgroundResource(R.drawable.btn_bonus_states);
                            }
                        }

                        public void onFinish() {
                            timerView.setText("Times Up!");
                            tapBtn.setBackgroundResource(R.drawable.redbutton);
                            newLevelFiveScore = tapCount;

                            if (timerView.getText() == ("Times Up!") && tapCount < 13) {
                                roundOverView.setText("Nope!");
                                resetView.setText("Try Again");
                                roundStarted = false;
                            }

                            if (timerView.getText() == ("UNBELIEVABLE!") && tapCount > 12) {
                                roundOverView.setText("You did that!");
                                nextLevelView.setAlpha(1);
                                roundStarted = false;
                            }

                            if (!roundStarted) {
                                tapBtn.setOnClickListener(null);
                            }

                            saveScore();
                            displayScore();
                        }
                    }.start();
                }
            }
        });
    }

    private void saveScore() {
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        int currentLevelFiveHighScore = scorePref.getInt("levelFiveScore", 0);

        if(newLevelFiveScore > currentLevelFiveHighScore ){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putInt("levelFiveScore", newLevelFiveScore);
            scoreEditor.apply();
        }

        if (scorePref.getInt("levelFiveScore", 0) > 0){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putString("levelUnlocked", "five");
            scoreEditor.apply();
        }

        if (scorePref.getInt("levelFiveScore", 0) > 12){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putString("levelUnlocked", "five");
            scoreEditor.apply();
        }
    }

    private void displayScore() {

        TextView hiScoreTextView = (TextView) findViewById(R.id.hiScoreTextView);
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);

        int hiScore = scorePref.getInt("levelFiveScore", 0);
        hiScoreTextView.setText(String.valueOf(hiScore));
    }

    @Override
    public void onClick(View v) {

    }
}
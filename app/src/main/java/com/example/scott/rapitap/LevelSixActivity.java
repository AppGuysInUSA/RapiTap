package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;


public class LevelSixActivity extends Activity implements OnClickListener {

    // Start counter variable and firstClick trigger
    int tapCount = 0;
    int newLevelSixScore = 0;
    int firstClick = 0;
    boolean roundStarted;
    TextView playerName6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.level_six);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // import font
        final TextView tapCountTextView = (TextView) findViewById(R.id.tapCountTextView);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        tapCountTextView.setTypeface(myfont);

        // Check String Values for Resume Game
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);

        String userName = scorePref.getString("userName6", "");

        playerName6 = (TextView) findViewById(R.id.playerName6);
        playerName6.setTypeface(myfont);
        playerName6.setText(String.valueOf(userName));

        int levelSixScore = scorePref.getInt("levelSixScore", 0);
        String levelUnlocked = scorePref.getString("levelUnlocked", "locked");
        if(levelUnlocked.equals("finale") || levelSixScore > 104){

            TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
            nextLevelView.setTypeface(myfont);
            nextLevelView.setAlpha(1);
            nextLevelView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent finaleIntent = new Intent(LevelSixActivity.this, FinaleActivity.class);
                    finish();
                    startActivity(finaleIntent);
                }
            });
        } else {

            TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
            nextLevelView.setTypeface(myfont);
            nextLevelView.setAlpha(0);

        }

        final TextView roundOverView = (TextView) findViewById(R.id.roundOverView);
        roundOverView.setTypeface(myfont);

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
                Intent mainMenuIntent = new Intent(LevelSixActivity.this, SplashActivity.class);
                finish();
                startActivity(mainMenuIntent);
            }
        });

        final ImageButton btnLeft = (ImageButton) findViewById(R.id.tapBtnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final ImageButton btnRight = (ImageButton) findViewById(R.id.tapBtnRight);
                btnRight.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){

                        btnLeft.setClickable(true);
                        firstClick++;
                        tapCount++;
                        tapCountTextView.setText(String.valueOf(tapCount));
                        btnRight.setClickable(false);
                    }
                });

                btnRight.setClickable(true);
                firstClick++;
                tapCount++;
                tapCountTextView.setText(String.valueOf(tapCount));
                btnLeft.setClickable(false);

                if (firstClick == 1) {
                    new CountDownTimer(10000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            timerView.setText("SECONDS REMAINING: " + millisUntilFinished / 1000);
                            btnLeft.setBackgroundResource(R.drawable.btn_states);
                            btnRight.setBackgroundResource(R.drawable.btn_states);
                            roundStarted = true;

                            if (millisUntilFinished > 7000 && tapCount > 25) {
                                roundOverView.setText("Sizzlin!");
                                btnLeft.setBackgroundResource(R.drawable.btn_bonus_states);
                                btnRight.setBackgroundResource(R.drawable.btn_bonus_states);
                            }

                            if (millisUntilFinished > 5000 && tapCount > 50) {
                                roundOverView.setText("Lightnin!");
                                btnLeft.setBackgroundResource(R.drawable.btn_bonus_states);
                                btnRight.setBackgroundResource(R.drawable.btn_bonus_states);
                            }

                            if (millisUntilFinished > 2000 && tapCount > 75) {
                                roundOverView.setText("Lightnin!");
                                btnLeft.setBackgroundResource(R.drawable.btn_bonus_states);
                                btnRight.setBackgroundResource(R.drawable.btn_bonus_states);
                            }
                        }

                        public void onFinish() {
                            timerView.setText("TIMES UP!");
                            btnLeft.setBackgroundResource(R.drawable.redbutton);
                            btnRight.setBackgroundResource(R.drawable.redbutton);
                            newLevelSixScore = tapCount;

                            if (timerView.getText() == ("TIMES UP!") && tapCount < 105) {
                                //resetView.setText("REPLAY");
                                roundOverView.setText("Sorry!");
                                roundStarted = false;
                            }

                            if (timerView.getText() == ("TIMES UP!") && tapCount > 104) {
                                roundOverView.setText("WOOO HOOO!!!");
                                //TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
                                //nextLevelView.setAlpha(1);
                                //nextLevelView.setText("Congrats!");
                                roundStarted = false;
                            }

                            if (!roundStarted) {
                                btnLeft.setOnClickListener(null);
                                btnRight.setOnClickListener(null);
                            }

                            saveScore();
                            displayScore();
                        }
                    }.start();
                }

                TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
                nextLevelView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent finaleIntent = new Intent(LevelSixActivity.this, FinaleActivity.class);
                        finish();
                        startActivity(finaleIntent);
                    }
                });
            }
        });
    }

    private void saveScore() {
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        int currentLevelSixHighScore = scorePref.getInt("levelSixScore", 0);
        String userName6 = scorePref.getString("userName6", "");

        if(newLevelSixScore > currentLevelSixHighScore ){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putInt("levelSixScore", newLevelSixScore);
            scoreEditor.putString("userName6", scorePref.getString("newUserName", ""));
            scoreEditor.apply();

            new ScoreAsyncTask().execute((Void) null);
        }

        if (scorePref.getInt("levelSixScore", 0) > 0){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putString("levelUnlocked", "six");
            scoreEditor.apply();
        }

        if (scorePref.getInt("levelSixScore", 0) > 104){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putString("levelUnlocked", "finale");
            scoreEditor.apply();
        }
    }

    private void displayScore() {

        TextView hiScoreTextView = (TextView) findViewById(R.id.hiScoreTextView);
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);

        int hiScore = scorePref.getInt("levelSixScore", 0);
        hiScoreTextView.setText(String.valueOf(hiScore));
        playerName6.setText(String.valueOf(scorePref.getString("userName6", "")));
    }

    class ScoreAsyncTask extends AsyncTask<Void, Void, Boolean> {

        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        String playerName = String.valueOf(scorePref.getString("userName6", ""));
        int playerLevel = 6;
        int playerScore = scorePref.getInt("levelSixScore", 0);


        private void postData(int playerLevel, String playerName, int playerScore) {

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://www.appguysinusa.com/insert.php");

            try {
                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
                nameValuePairs.add(new BasicNameValuePair("playerLevel", String.valueOf(playerLevel)));
                nameValuePairs.add(new BasicNameValuePair("playerName", playerName));
                nameValuePairs.add(new BasicNameValuePair("playerScore", String.valueOf(playerScore)));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
            }
            catch(Exception e)
            {
                Log.e("log_tag", "Error:  " + e.toString());
            }
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            postData(playerLevel, playerName, playerScore);
            return null;
        }
    }

    @Override
    public void onClick(View v) {

    }
}
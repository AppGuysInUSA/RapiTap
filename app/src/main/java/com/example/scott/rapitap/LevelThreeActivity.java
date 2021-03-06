package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


public class LevelThreeActivity extends Activity implements OnClickListener {

    // Start counter variable and firstClick trigger
    int tapCount = 0;
    int newLevelThreeScore = 0;
    int firstClick = 0;
    boolean roundStarted;
    TextView playerName3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.level_three);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        // import font
        final TextView tapCountTextView = (TextView) findViewById(R.id.tapCountTextView);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        tapCountTextView.setTypeface(myfont);

        // Check String Values for Resume Game
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);

        String userName = scorePref.getString("userName3", "");

        playerName3 = (TextView) findViewById(R.id.playerName3);
        playerName3.setTypeface(myfont);
        playerName3.setText(String.valueOf(userName));

        int levelThreeScore = scorePref.getInt("levelThreeScore", 0);
        String levelUnlocked = scorePref.getString("levelUnlocked", "locked");
        if(levelUnlocked.equals("four") || levelThreeScore > 31){

            TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
            nextLevelView.setTypeface(myfont);
            nextLevelView.setAlpha(1);
            nextLevelView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent levelTwoIntent = new Intent(LevelThreeActivity.this, LevelFourActivity.class);
                    finish();
                    startActivity(levelTwoIntent);
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
                Intent mainMenuIntent = new Intent(LevelThreeActivity.this, SplashActivity.class);
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
                    new CountDownTimer(3000, 1000) {

                        public void onTick(long millisUntilFinished) {
                            timerView.setText("Seconds Remaining: " + millisUntilFinished / 1000);
                            tapBtn.setBackgroundResource(R.drawable.btn_states_level_three);
                            roundStarted = true;

                            if (millisUntilFinished  > 2000 && tapCount > 12){
                                roundOverView.setText("Redhot!");
                                tapBtn.setBackgroundResource(R.drawable.btn_bonus_states);
                            }

                            if (millisUntilFinished  > 1000 && tapCount > 26){
                                roundOverView.setText("Redhot!");
                                tapBtn.setBackgroundResource(R.drawable.btn_bonus_states);
                            }
                        }

                        public void onFinish() {
                            timerView.setText("Times Up!");
                            tapBtn.setBackgroundResource(R.drawable.redbutton);
                            newLevelThreeScore = tapCount;

                            if (timerView.getText() == ("Times Up!") && tapCount < 32) {
                                roundOverView.setText("Nope!");
                                resetView.setText("Try Again");
                                roundStarted = false;
                            }

                            if (timerView.getText() == ("Times Up!") && tapCount > 31) {
                                roundOverView.setText("Fantastic!");
                                TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
                                nextLevelView.setAlpha(1);
                                resetView.setText("Replay");
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

                TextView nextLevelView = (TextView) findViewById(R.id.nextLevelView);
                nextLevelView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent levelFourIntent = new Intent(LevelThreeActivity.this, LevelFourActivity.class);
                        finish();
                        startActivity(levelFourIntent);
                    }
                });
            }
        });
    }

    private void saveScore() {
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        int currentLevelThreeHighScore = scorePref.getInt("levelThreeScore", 0);
        String userName3 = scorePref.getString("userName3", "");

        if(newLevelThreeScore > currentLevelThreeHighScore ){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putInt("levelThreeScore", newLevelThreeScore);
            scoreEditor.putString("userName3", scorePref.getString("newUserName", ""));
            scoreEditor.apply();

            new ScoreAsyncTask().execute((Void) null);
        }

        if (scorePref.getInt("levelThreeScore", 0) > 0){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putString("levelUnlocked", "three");
            scoreEditor.apply();
        }

        if (scorePref.getInt("levelThreeScore", 0) > 31){
            SharedPreferences.Editor scoreEditor = scorePref.edit();
            scoreEditor.putString("levelUnlocked", "four");
            scoreEditor.apply();
        }
    }

    private void displayScore() {

        TextView hiScoreTextView = (TextView) findViewById(R.id.hiScoreTextView);
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);

        int hiScore = scorePref.getInt("levelThreeScore", 0);
        hiScoreTextView.setText(String.valueOf(hiScore));
        playerName3.setText(String.valueOf(scorePref.getString("userName3", "")));
    }

    class ScoreAsyncTask extends AsyncTask<Void, Void, Boolean> {

        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        String playerName = String.valueOf(scorePref.getString("userName3", ""));
        int playerLevel = 3;
        int playerScore = scorePref.getInt("levelThreeScore", 0);


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
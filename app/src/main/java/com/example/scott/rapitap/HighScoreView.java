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
        final TextView hiScoreTitleTextView2 = (TextView) findViewById(R.id.hiScoreTitleTextView2);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        hiScoreTitleTextView.setTypeface(myfont);
        hiScoreTitleTextView2.setTypeface(myfont);



        // Bring in high scores
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        int currentLevelOneHighScore = scorePref.getInt("levelOneScore", 0);
        int currentLevelTwoHighScore = scorePref.getInt("levelTwoScore", 0);
        int currentLevelThreeHighScore = scorePref.getInt("levelThreeScore", 0);
        int currentLevelFourHighScore = scorePref.getInt("levelFourScore", 0);
        int currentLevelFiveHighScore = scorePref.getInt("levelFiveScore", 0);
        String userName = (scorePref.getString("userName1", ""));

        // Set Hi-Score int to String value
        final TextView levelOneHiScoreTextView = (TextView) findViewById(R.id.levelOneHiScoreTextView);
        String levelOneHighestScore = (String.valueOf(currentLevelOneHighScore));
        levelOneHiScoreTextView.setTypeface(myfont);
        levelOneHiScoreTextView.setText(levelOneHighestScore);

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

        final TextView level1 = (TextView) findViewById(R.id.level1);
        level1.setTypeface(myfont);

        final TextView level2 = (TextView) findViewById(R.id.level2);
        level2.setTypeface(myfont);

        final TextView level3 = (TextView) findViewById(R.id.level3);
        level3.setTypeface(myfont);

        final TextView level4 = (TextView) findViewById(R.id.level4);
        level4.setTypeface(myfont);

        final TextView level5 = (TextView) findViewById(R.id.level5);
        level5.setTypeface(myfont);

        final TextView playerName1 = (TextView) findViewById(R.id.playerName1);
        playerName1.setTypeface(myfont);
        playerName1.setText(userName);

        final TextView playerName2 = (TextView) findViewById(R.id.playerName2);
        playerName2.setTypeface(myfont);

        final TextView playerName3 = (TextView) findViewById(R.id.playerName3);
        playerName3.setTypeface(myfont);

        final TextView playerName4 = (TextView) findViewById(R.id.playerName4);
        playerName4.setTypeface(myfont);

        final TextView playerName5 = (TextView) findViewById(R.id.playerName5);
        playerName5.setTypeface(myfont);

        final TextView globalPlayerName1 = (TextView) findViewById(R.id.globalPlayerName1);
        globalPlayerName1.setTypeface(myfont);

        final TextView globalPlayerName2 = (TextView) findViewById(R.id.globalPlayerName2);
        globalPlayerName2.setTypeface(myfont);

        final TextView globalPlayerName3 = (TextView) findViewById(R.id.globalPlayerName3);
        globalPlayerName3.setTypeface(myfont);

        final TextView globalPlayerName4 = (TextView) findViewById(R.id.globalPlayerName4);
        globalPlayerName4.setTypeface(myfont);

        final TextView globalPlayerName5 = (TextView) findViewById(R.id.globalPlayerName5);
        globalPlayerName5.setTypeface(myfont);


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

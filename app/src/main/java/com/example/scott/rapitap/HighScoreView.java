package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;

import java.security.PrivilegedAction;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.AdRequest;



public class HighScoreView extends Activity implements OnClickListener{

    int newLevelOneScore = 0;
    int newLevelTwoScore = 0;
    int newLevelThreeScore = 0;
    int newLevelFourScore = 0;
    int newLevelFiveScore = 0;

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

        final TextView hiScoreTextView1 = (TextView) findViewById(R.id.hiScoreTextView1);
        hiScoreTextView1.setTypeface(myfont);

        final TextView hiScoreTextView2 = (TextView) findViewById(R.id.hiScoreTextView2);
        hiScoreTextView2.setTypeface(myfont);

        final TextView hiScoreTextView3 = (TextView) findViewById(R.id.hiScoreTextView3);
        hiScoreTextView3.setTypeface(myfont);

        final TextView hiScoreTextView4 = (TextView) findViewById(R.id.hiScoreTextView4);
        hiScoreTextView4.setTypeface(myfont);

        final TextView hiScoreTextView5 = (TextView) findViewById(R.id.hiScoreTextView5);
        hiScoreTextView5.setTypeface(myfont);

        final TextView playerName1 = (TextView) findViewById(R.id.playerName1);
        playerName1.setTypeface(myfont);

        final TextView playerName2 = (TextView) findViewById(R.id.playerName2);
        playerName2.setTypeface(myfont);

        final TextView playerName3 = (TextView) findViewById(R.id.playerName3);
        playerName3.setTypeface(myfont);

        final TextView playerName4 = (TextView) findViewById(R.id.playerName4);
        playerName4.setTypeface(myfont);

        final TextView playerName5 = (TextView) findViewById(R.id.playerName5);
        playerName5.setTypeface(myfont);


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

    public void onClick(View v) {

    }
}

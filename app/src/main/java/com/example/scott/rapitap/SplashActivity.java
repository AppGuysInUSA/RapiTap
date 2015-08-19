package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SplashActivity extends Activity {

    //MyDBHandler gameDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        // Import font
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");

        // Check String Values for Resume Game
        SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
        String levelUnlocked = scorePref.getString("levelUnlocked", "locked");
        final int levelOneScore = scorePref.getInt("levelOneScore", 0);
        int levelTwoScore = scorePref.getInt("levelTwoScore", 0);

        if(levelUnlocked.equals("locked")){

            final TextView resumeGameTextView = (TextView) findViewById(R.id.resumeGameTextView);
            resumeGameTextView.setTypeface(myfont);
            resumeGameTextView.setTextColor(Color.GRAY);
            resumeGameTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                }
            });
        }

        if(levelUnlocked.equals("one")){

            lvloneBackBtn();

            final TextView resumeGameTextView = (TextView) findViewById(R.id.resumeGameTextView);
            resumeGameTextView.setTypeface(myfont);
            resumeGameTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent levelOneIntent = new Intent(SplashActivity.this, LevelOneActivity.class);
                    startActivity(levelOneIntent);
                }
            });
        }

        if(levelUnlocked.equals("two")){

            lvloneBackBtn();
            lvltwoBackBtn();

            final TextView resumeGameTextView = (TextView) findViewById(R.id.resumeGameTextView);
            resumeGameTextView.setTypeface(myfont);
            resumeGameTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent levelTwoIntent = new Intent(SplashActivity.this, LevelTwoActivity.class);
                    startActivity(levelTwoIntent);
                }
            });
        }

        if(levelUnlocked.equals("three")){

            lvloneBackBtn();
            lvltwoBackBtn();
            lvlthreeBackBtn();

            final TextView resumeGameTextView = (TextView) findViewById(R.id.resumeGameTextView);
            resumeGameTextView.setTypeface(myfont);
            resumeGameTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent levelThreeIntent = new Intent(SplashActivity.this, LevelThreeActivity.class);
                    startActivity(levelThreeIntent);
                }
            });
        }

        if(levelUnlocked.equals("four")){

            lvloneBackBtn();
            lvltwoBackBtn();
            lvlthreeBackBtn();
            lvlfourBackBtn();

            final TextView resumeGameTextView = (TextView) findViewById(R.id.resumeGameTextView);
            resumeGameTextView.setTypeface(myfont);
            resumeGameTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent levelFourIntent = new Intent(SplashActivity.this, LevelFourActivity.class);
                    startActivity(levelFourIntent);
                }
            });
        }

        if(levelUnlocked.equals("five")){

            lvloneBackBtn();
            lvltwoBackBtn();
            lvlthreeBackBtn();
            lvlfourBackBtn();
            lvlfiveBackBtn();

            final TextView resumeGameTextView = (TextView) findViewById(R.id.resumeGameTextView);
            resumeGameTextView.setTypeface(myfont);
            resumeGameTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Intent levelFiveIntent = new Intent(SplashActivity.this, LevelFiveActivity.class);
                    startActivity(levelFiveIntent);
                }
            });
        }

        // Start Buttons
        final TextView newGameTextView = (TextView) findViewById(R.id.newGameTextView);
        newGameTextView.setTypeface(myfont);
        newGameTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent nameInputIntent = new Intent(SplashActivity.this, NameInputActivity.class);
                //SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
                //scorePref.edit().clear().commit();
                startActivity(nameInputIntent);
/*
                Intent levelOneIntent = new Intent(SplashActivity.this, LevelOneActivity.class);
                SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
                scorePref.edit().clear().commit();
                startActivity(levelOneIntent);
                */
            }
        });

        final TextView highScoreTextView = (TextView) findViewById(R.id.highScoreTextView);
        highScoreTextView.setTypeface(myfont);
        highScoreTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent highScoreView = new Intent(SplashActivity.this, HighScoreView.class);
                startActivity(highScoreView);
                //Intent levelOneIntent = new Intent(SplashActivity.this, LevelOneActivity.class);
                //startActivity(levelOneIntent);
            }
        });
    }

    public void lvloneBackBtn () {

        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        TextView levelOneBackBtn = (TextView) findViewById(R.id.levelOneBackView);
        levelOneBackBtn.setTypeface(myfont);
        levelOneBackBtn.setText("Level 1");
        levelOneBackBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent levelOneIntent = new Intent(SplashActivity.this, LevelOneActivity.class);
                startActivity(levelOneIntent);
            }
        });
    }

    public void lvltwoBackBtn () {

        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        TextView levelTwoBackBtn = (TextView) findViewById(R.id.levelTwoBackView);
        levelTwoBackBtn.setTypeface(myfont);
        levelTwoBackBtn.setText("Level 2");
        levelTwoBackBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent levelTwoIntent = new Intent(SplashActivity.this, LevelTwoActivity.class);
                startActivity(levelTwoIntent);
            }
        });
    }

    public void lvlthreeBackBtn () {

        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        TextView lvlthreeBackBtn = (TextView) findViewById(R.id.levelThreeBackView);
        lvlthreeBackBtn.setTypeface(myfont);
        lvlthreeBackBtn.setText("Level 3");
        lvlthreeBackBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent levelThreeIntent = new Intent(SplashActivity.this, LevelThreeActivity.class);
                startActivity(levelThreeIntent);
            }
        });
    }

    public void lvlfourBackBtn () {

        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        TextView lvlfourBackBtn = (TextView) findViewById(R.id.levelFourBackView);
        lvlfourBackBtn.setTypeface(myfont);
        lvlfourBackBtn.setText("Level 4");
        lvlfourBackBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent levelFourIntent = new Intent(SplashActivity.this, LevelFourActivity.class);
                startActivity(levelFourIntent);
            }
        });
    }

    public void lvlfiveBackBtn () {

        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");
        TextView lvlfiveBackBtn = (TextView) findViewById(R.id.levelFiveBackView);
        lvlfiveBackBtn.setTypeface(myfont);
        lvlfiveBackBtn.setText("Level 5");
        lvlfiveBackBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent levelFiveIntent = new Intent(SplashActivity.this, LevelFiveActivity.class);
                startActivity(levelFiveIntent);
            }
        });
    }
}

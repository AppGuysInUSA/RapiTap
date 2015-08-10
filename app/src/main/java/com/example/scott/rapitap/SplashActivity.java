package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
                setContentView(R.layout.activity_splash);

        // Import font
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/Sprayerz.otf");

        // Start Buttons
        final TextView newGameTextView = (TextView) findViewById(R.id.newGameTextView);
        newGameTextView.setTypeface(myfont);
        newGameTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent levelOneIntent = new Intent(SplashActivity.this, LevelOneActivity.class);
                startActivity(levelOneIntent);
            }
        });

        final TextView resumeGameTextView = (TextView) findViewById(R.id.resumeGameTextView);
        resumeGameTextView.setTypeface(myfont);
        resumeGameTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent levelOneIntent = new Intent(SplashActivity.this, LevelOneActivity.class);
                //startActivity(levelOneIntent);
            }
        });

        final TextView highScoreTextView = (TextView) findViewById(R.id.highScoreTextView);
        highScoreTextView.setTypeface(myfont);
        highScoreTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Intent levelOneIntent = new Intent(SplashActivity.this, LevelOneActivity.class);
                //startActivity(levelOneIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

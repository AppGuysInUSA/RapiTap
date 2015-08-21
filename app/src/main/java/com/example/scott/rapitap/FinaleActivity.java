package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;


public class FinaleActivity extends Activity {

    //MyDBHandler gameDbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.finale_activity);

        // import font
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/ppetrial.otf");

        final TextView mainMenuBtnView = (TextView) findViewById(R.id.mainMenuBtnView);
        mainMenuBtnView.setTypeface(myfont);
        mainMenuBtnView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mainMenuIntent = new Intent(FinaleActivity.this, SplashActivity.class);
                finish();
                startActivity(mainMenuIntent);
            }
        });

    }
}

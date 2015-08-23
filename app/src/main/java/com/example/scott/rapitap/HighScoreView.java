package com.example.scott.rapitap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class HighScoreView extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.highscoreview);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // initialize high scores
        new GetAllScoresTask().execute(new ApiConnector());
        new GetAllScoresTask2().execute(new ApiConnector());
        new GetAllScoresTask3().execute(new ApiConnector());
        new GetAllScoresTask4().execute(new ApiConnector());
        new GetAllScoresTask5().execute(new ApiConnector());

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

        // Bring in hi score user name from each level
        String userName1 = (scorePref.getString("userName1", ""));
        String userName2 = (scorePref.getString("userName2", ""));
        String userName3 = (scorePref.getString("userName3", ""));
        String userName4 = (scorePref.getString("userName4", ""));
        String userName5 = (scorePref.getString("userName5", ""));

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

        ///////////// Levels ///////////////

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

        ///////////// Local Player Names ///////////////

        final TextView playerName1 = (TextView) findViewById(R.id.playerName1);
        playerName1.setTypeface(myfont);
        playerName1.setText(userName1);

        final TextView playerName2 = (TextView) findViewById(R.id.playerName2);
        playerName2.setTypeface(myfont);
        playerName2.setText(userName2);

        final TextView playerName3 = (TextView) findViewById(R.id.playerName3);
        playerName3.setTypeface(myfont);
        playerName3.setText(userName3);

        final TextView playerName4 = (TextView) findViewById(R.id.playerName4);
        playerName4.setTypeface(myfont);
        playerName4.setText(userName4);

        final TextView playerName5 = (TextView) findViewById(R.id.playerName5);
        playerName5.setTypeface(myfont);
        playerName5.setText(userName5);

        ///////////// Global Player Names ///////////////

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

        ////////////// Global High Scores ///////////////

        final TextView levelOneGlobalHiScoreTextView = (TextView) findViewById(R.id.levelOneGlobalHiScoreTextView);
        levelOneGlobalHiScoreTextView.setTypeface(myfont);

        final TextView levelTwoGlobalHiScoreTextView = (TextView) findViewById(R.id.levelTwoGlobalHiScoreTextView);
        levelTwoGlobalHiScoreTextView.setTypeface(myfont);

        final TextView levelThreeGlobalHiScoreTextView = (TextView) findViewById(R.id.levelThreeGlobalHiScoreTextView);
        levelThreeGlobalHiScoreTextView.setTypeface(myfont);

        final TextView levelFourGlobalHiScoreTextView = (TextView) findViewById(R.id.levelFourGlobalHiScoreTextView);
        levelFourGlobalHiScoreTextView.setTypeface(myfont);

        final TextView levelFiveGlobalHiScoreTextView = (TextView) findViewById(R.id.levelFiveGlobalHiScoreTextView);
        levelFiveGlobalHiScoreTextView.setTypeface(myfont);


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

    // Level One
    public void setTextToGlobalScoreView(JSONArray jsonArray)
    {
        String gpn1  = "";
        int gpn1score = 0;
        for(int i=0; i<jsonArray.length();i++){

            JSONObject json = null;
            try {
                json = jsonArray.getJSONObject(i);
                gpn1 = json.getString("NAME");
                gpn1score = json.getInt("SCORE");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        TextView globalPlayerName1 = (TextView) findViewById(R.id.globalPlayerName1);
        globalPlayerName1.setText(gpn1);

        TextView levelOneGlobalHiScoreTextView = (TextView) findViewById(R.id.levelOneGlobalHiScoreTextView);
        levelOneGlobalHiScoreTextView.setText(String.valueOf(gpn1score));

    }

    // Level Two
    public void setTextToGlobalScoreViewTwo(JSONArray jsonArray2)
    {
        String gpn2  = "";
        int gpn2score = 0;
        for(int i=0; i<jsonArray2.length();i++){

            JSONObject json = null;
            try {
                json = jsonArray2.getJSONObject(i);
                gpn2 = json.getString("NAME");
                gpn2score = json.getInt("SCORE");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        TextView globalPlayerName2 = (TextView) findViewById(R.id.globalPlayerName2);
        globalPlayerName2.setText(gpn2);

        TextView levelTwoGlobalHiScoreTextView = (TextView) findViewById(R.id.levelTwoGlobalHiScoreTextView);
        levelTwoGlobalHiScoreTextView.setText(String.valueOf(gpn2score));

    }

    // Level Three
    public void setTextToGlobalScoreViewThree(JSONArray jsonArray3)
    {
        String gpn3  = "";
        int gpn3score = 0;
        for(int i=0; i<jsonArray3.length();i++){

            JSONObject json = null;
            try {
                json = jsonArray3.getJSONObject(i);
                gpn3 = json.getString("NAME");
                gpn3score = json.getInt("SCORE");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        TextView globalPlayerName3 = (TextView) findViewById(R.id.globalPlayerName3);
        globalPlayerName3.setText(gpn3);

        TextView levelThreeGlobalHiScoreTextView = (TextView) findViewById(R.id.levelThreeGlobalHiScoreTextView);
        levelThreeGlobalHiScoreTextView.setText(String.valueOf(gpn3score));

    }

    // Level four
    public void setTextToGlobalScoreViewFour(JSONArray jsonArray4)
    {
        String gpn4  = "";
        int gpn4score = 0;
        for(int i=0; i<jsonArray4.length();i++){

            JSONObject json = null;
            try {
                json = jsonArray4.getJSONObject(i);
                gpn4 = json.getString("NAME");
                gpn4score = json.getInt("SCORE");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        TextView globalPlayerName4 = (TextView) findViewById(R.id.globalPlayerName4);
        globalPlayerName4.setText(gpn4);

        TextView levelFourGlobalHiScoreTextView = (TextView) findViewById(R.id.levelFourGlobalHiScoreTextView);
        levelFourGlobalHiScoreTextView.setText(String.valueOf(gpn4score));

    }

    // Level Five
    public void setTextToGlobalScoreViewFive(JSONArray jsonArray5)
    {
        String gpn5  = "";
        int gpn5score = 0;
        for(int i=0; i<jsonArray5.length();i++){

            JSONObject json = null;
            try {
                json = jsonArray5.getJSONObject(i);
                gpn5 = json.getString("NAME");
                gpn5score = json.getInt("SCORE");

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        TextView globalPlayerName5 = (TextView) findViewById(R.id.globalPlayerName5);
        globalPlayerName5.setText(gpn5);

        TextView levelFiveGlobalHiScoreTextView = (TextView) findViewById(R.id.levelFiveGlobalHiScoreTextView);
        levelFiveGlobalHiScoreTextView.setText(String.valueOf(gpn5score));

    }

    private class GetAllScoresTask extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread

            return params[0].GetAllScores();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray) {

            setTextToGlobalScoreView(jsonArray);

        }

    }

    private class GetAllScoresTask2 extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread

            return params[0].GetAllScoresLevelTwo();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray2) {

            setTextToGlobalScoreViewTwo(jsonArray2);

        }

    }

    private class GetAllScoresTask3 extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread

            return params[0].GetAllScoresLevelThree();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray3) {

            setTextToGlobalScoreViewThree(jsonArray3);

        }

    }

    private class GetAllScoresTask4 extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread

            return params[0].GetAllScoresLevelFour();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray4) {

            setTextToGlobalScoreViewFour(jsonArray4);

        }

    }

    private class GetAllScoresTask5 extends AsyncTask<ApiConnector,Long,JSONArray>
    {
        @Override
        protected JSONArray doInBackground(ApiConnector... params) {

            // it is executed on Background thread

            return params[0].GetAllScoresLevelFive();
        }

        @Override
        protected void onPostExecute(JSONArray jsonArray5) {

            setTextToGlobalScoreViewFive(jsonArray5);

        }

    }

    @Override
    public void onClick(View v) {

    }
}

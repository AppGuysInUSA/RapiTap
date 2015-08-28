package com.example.scott.rapitap;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;


public class ApiConnector {

    // Level One High Score
    public JSONArray GetAllScores(){
        // URL for getting all the scores

        String scoreurl = "http://www.appguysinusa.com/getAllScores.php";

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try
        {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            HttpGet httpGet = new HttpGet(scoreurl);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();



        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert HttpEntity into JSON Array
        JSONArray jsonArray = null;

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray;

    }

    // Level Two High Score
    public JSONArray GetAllScoresLevelTwo(){
        // URL for getting all the scores

        String scoreurl = "http://www.appguysinusa.com/getAllScoresLevelTwo.php";

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try
        {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            HttpGet httpGet = new HttpGet(scoreurl);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();



        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert HttpEntity into JSON Array
        JSONArray jsonArray2 = null;

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray2 = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray2;

    }

    // Level Three High Score
    public JSONArray GetAllScoresLevelThree(){
        // URL for getting all the scores

        String scoreurl = "http://www.appguysinusa.com/getAllScoresLevelThree.php";

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try
        {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            HttpGet httpGet = new HttpGet(scoreurl);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();



        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert HttpEntity into JSON Array
        JSONArray jsonArray3 = null;

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray3 = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray3;

    }

    // Level Four High Score
    public JSONArray GetAllScoresLevelFour(){
        // URL for getting all the scores

        String scoreurl = "http://www.appguysinusa.com/getAllScoresLevelFour.php";

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try
        {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            HttpGet httpGet = new HttpGet(scoreurl);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();



        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert HttpEntity into JSON Array
        JSONArray jsonArray4 = null;

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray4 = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray4;

    }

    // Level Five High Score
    public JSONArray GetAllScoresLevelFive(){
        // URL for getting all the scores

        String scoreurl = "http://www.appguysinusa.com/getAllScoresLevelFive.php";

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try
        {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            HttpGet httpGet = new HttpGet(scoreurl);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();



        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert HttpEntity into JSON Array
        JSONArray jsonArray5 = null;

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray5 = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray5;

    }

    // Level Five High Score
    public JSONArray GetAllScoresLevelSix(){
        // URL for getting all the scores

        String scoreurl = "http://www.appguysinusa.com/getAllScoresLevelSix.php";

        // Get HttpResponse Object from url.
        // Get HttpEntity from Http Response Object

        HttpEntity httpEntity = null;

        try
        {

            DefaultHttpClient httpClient = new DefaultHttpClient();  // Default HttpClient
            HttpGet httpGet = new HttpGet(scoreurl);

            HttpResponse httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();



        } catch (ClientProtocolException e) {

            // Signals error in http protocol
            e.printStackTrace();

            //Log Errors Here

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert HttpEntity into JSON Array
        JSONArray jsonArray6 = null;

        if (httpEntity != null) {
            try {
                String entityResponse = EntityUtils.toString(httpEntity);

                Log.e("Entity Response  : ", entityResponse);

                jsonArray6 = new JSONArray(entityResponse);

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return jsonArray6;

    }
}

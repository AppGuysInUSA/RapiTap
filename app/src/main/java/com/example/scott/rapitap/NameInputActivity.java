package com.example.scott.rapitap;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameInputActivity extends Activity {

    EditText playerNameInput;
    TextView enterBtnTextView;
    String playerName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_input);

        // Set up calls
        playerNameInput = (EditText) findViewById(R.id.playerNameInput);
        enterBtnTextView = (TextView) findViewById(R.id.enterBtnTextView);
        enterBtnTextView.setHintTextColor(Color.BLACK);
        enterBtnTextView.setHint("Type Initials up to 3 characters");

        // Set up button
        enterBtnTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final String name = playerNameInput.getText().toString();

                if (isValidName(name)) {

                    playerName = playerNameInput.getText().toString();

                    SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
                    SharedPreferences.Editor scoreEditor = scorePref.edit();
                    String newUserName = scorePref.getString("newUserName", "");
                    scoreEditor.putString("newUserName", String.valueOf(playerName));
                    scoreEditor.apply();

                    Intent levelOneIntent = new Intent(NameInputActivity.this, LevelOneActivity.class);
                    finish();
                    startActivity(levelOneIntent);
                }

                if (!isValidName(name)) {
                    Toast.makeText(getApplicationContext(),
                            "Initials should be 3 characters in length", Toast.LENGTH_LONG)
                            .show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }

    private boolean isValidName(String name) {
        String NAME = "^[a-z0-9_-]{3,3}$";

        Pattern pattern = Pattern.compile(NAME, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}

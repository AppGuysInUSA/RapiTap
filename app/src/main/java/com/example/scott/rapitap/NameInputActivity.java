package com.example.scott.rapitap;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NameInputActivity extends Activity{

    TextView currentPlayerNameView;
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

        // Set up button
        enterBtnTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                playerName = playerNameInput.getText().toString();

                SharedPreferences scorePref = getSharedPreferences("userScore", Context.MODE_PRIVATE);
                SharedPreferences.Editor scoreEditor = scorePref.edit();
                String userName = scorePref.getString("userName1", "");
                scoreEditor.putString("userName1", String.valueOf(playerName));
                scoreEditor.apply();

                Intent levelOneIntent = new Intent(NameInputActivity.this, LevelOneActivity.class);
                finish();
                startActivity(levelOneIntent);
            }
        });
    }
}

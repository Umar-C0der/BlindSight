package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        new Handler().postDelayed(new Runnable() { //used for delay of for splash screen
            @Override
            public void run() {

                SharedPreferences preferences = getSharedPreferences("UserData", MODE_PRIVATE);
                Boolean check = preferences.getBoolean("flag",false);

                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
                if (check){ // for true (user register)


                }
                else {  // for false (using app for first time or logged out

                }



            }
        }, 1000);

    }
    public void onBackPressed() { //restric to exit form splash screen

    }

}
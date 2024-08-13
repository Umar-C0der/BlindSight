package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity {

    CardView cardView1, cardView2, cardView3;

    private SharedPreferences sharedPreferences;
    private static final String PREF_NAME = "login_pref";
    private static final String IS_LOGGED_IN = "isLoggedIn";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        cardView1 = findViewById(R.id.navigation);
        cardView2 = findViewById(R.id.detectobject);
        cardView3 = findViewById(R.id.findobect);

        sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, NavigationActivity.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, ObjectDetectionActivity.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, ObjectListActivity.class);
                startActivity(intent);
            }
        });


    }





    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        Intent intent;

        if (id == R.id.Testimonial) {
            intent = new Intent(home.this, feedbackActivity.class);
            startActivity(intent);

        } else if (id == R.id.FQA) {
            intent = new Intent(home.this, FQAActivity.class);
            startActivity(intent);

        }
        else if(id==R.id.logout){

            FirebaseAuth.getInstance().signOut();

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(IS_LOGGED_IN, false);
            editor.apply();
            intent = new Intent(home.this, MainActivity.class);
            startActivity(intent);
            finish();

        }
        else {
            intent = new Intent(home.this, contactus.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
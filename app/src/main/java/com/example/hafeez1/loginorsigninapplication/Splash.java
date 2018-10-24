package com.example.hafeez1.loginorsigninapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {


    @Override
    protected void onStart() {
        super.onStart();


        SharedPreferences preferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        String name = preferences.getString("Name", null);
        String password = preferences.getString("Password", null);
        String email = preferences.getString("Email", null);


        if (name != null && password != null && email!=null ){
            Intent quizIntent = new Intent(Splash.this, Catagory.class);
            startActivity(quizIntent);
            finish();

        } else {

            Intent quizIntent = new Intent(Splash.this, MainActivity.class);
            startActivity(quizIntent);
            finish();
        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}

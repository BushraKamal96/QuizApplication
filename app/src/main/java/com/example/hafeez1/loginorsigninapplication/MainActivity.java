package com.example.hafeez1.loginorsigninapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1, b2, guestbtn;

    SharedPreferences.Editor preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);


        preferences = getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE).edit();





        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this, Login.class);
                startActivity(login);

            }

        });
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(MainActivity.this, Signin.class);
                startActivity(signin);
            }
        });


        guestbtn = (Button) findViewById(R.id.guestbutton);
        guestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                preferences.putString("is_guest", "true");
                preferences.apply();

                Intent guest = new Intent(MainActivity.this, Catagory.class);
                startActivity(guest);
            }
        });


    }


}

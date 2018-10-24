package com.example.hafeez1.loginorsigninapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText userEmail, userPassword;
    Button log;
    String inputEmail, inputPassword;
    private SharedPreferences.Editor preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE).edit();

        userEmail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);

        log = (Button)findViewById(R.id.button3);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEmail = userEmail.getText().toString();
                inputPassword = userPassword.getText().toString();
                preferences.putString("Name", inputEmail);
                preferences.putString("Password", inputPassword);
                preferences.apply();
                Log.e("InsideListener", "Check");

                if(inputEmail.equals("Bushra") && inputPassword.equals("12345")){

                    preferences.putString("is_guest","false");
                    preferences.apply();

                    Intent home = new Intent(Login.this, Catagory.class);
                    startActivity(home);
                    finish();
                }

            }
        });



    }


}

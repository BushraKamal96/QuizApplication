package com.example.hafeez1.loginorsigninapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    TextView userResult, userPoints;
    Button doneBtn;
    EditText userName;
    String name;
    RelativeLayout guestLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_results);

        guestLayout = (RelativeLayout) findViewById(R.id.for_guest);
        userResult = (TextView) findViewById(R.id.finalpoints);
        userResult.setText(getIntent().getExtras().getString("my marks") + " " + "points");
        userName = (EditText) findViewById(R.id.yourname);
        doneBtn = (Button) findViewById(R.id.donebutton);

        SharedPreferences preferences = getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE);
        String isGuest, name;
        isGuest = preferences.getString("is_guest", null);
        if (isGuest.equals("true")) {
            guestLayout.setVisibility(View.VISIBLE);
        } else {
            userResult.setVisibility(View.VISIBLE);
        }
name= preferences.getString("Name",null);
        if (name != null) {
            userResult.setText(name+" "+ getIntent().getStringExtra("Your score"));

        }
        // userPoints = (TextView) findViewById(R.id.finalpoints);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guestLayout.setVisibility(View.GONE);

                userResult.setVisibility(View.VISIBLE);

                userResult.setText(userName.getText()+"  "+ getIntent().getStringExtra("Your score"));

               // userResult.setText(getIntent().getExtras().getString("my marks") + " USER NAME TO PUT FROM PREFERENCES" + "points");

//                name = userName.getText().toString();
//                userResult.setText(name + " " + getIntent().getExtras().getString("my marks") + " " + "points");

            }
        });


    }
}

package com.example.hafeez1.loginorsigninapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class userProfile extends AppCompatActivity {
    TextView nameText, emailText;
    CircleImageView circleImage;
    String name, email, image;
    public static final int CHANGE_PIC = 1;
    public static String sharedPreferences = "SharedPreferences";

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        preferences = getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE);


        circleImage = (CircleImageView) findViewById(R.id.circleimgview);
        circleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentedd = new Intent(Intent.ACTION_PICK);
                intentedd.setType("image/*");
                startActivityForResult(Intent.createChooser(intentedd, "Change Pic"), CHANGE_PIC);
            }
        });
        nameText = (TextView) findViewById(R.id.nametext);
        emailText = (TextView) findViewById(R.id.emiltext);

        name = preferences.getString("Name", null);
        if (name != null) {
            nameText.setText("Name : " + name);
        }
        email = preferences.getString("Email", null);
        if (email != null) {
            emailText.setText("Email: " + email);

        }

        image = preferences.getString("Image", null);
        Toast.makeText(this, "" + image, Toast.LENGTH_SHORT).show();
        if (image != null) {
            Uri changing = Uri.parse(image);
            circleImage.setImageURI(changing);
        } else {
            circleImage.setImageResource(R.drawable.displaypic);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHANGE_PIC && resultCode == Activity.RESULT_OK && data != null) {

            Uri changing = data.getData();
            circleImage.setImageURI(changing);


        }
    }


}

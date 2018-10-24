package com.example.hafeez1.loginorsigninapplication;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

public class Signin extends AppCompatActivity {

    CircleImageView circularImage;
    EditText userName, userEmail, userPassword;
    Button sign, pickButton, captureButton;
    String inputName, inputEmail, inputPassword;
    public static final int PICK_IMAGE = 1;
    public static final int CAPTURE_IMAGE = 2;
    private SharedPreferences.Editor preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        preferences = getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE).edit();

        initUI();

        pickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pick = new Intent(Intent.ACTION_PICK);
                pick.setType("image/*");
                startActivityForResult(Intent.createChooser(pick, "Pick image"), PICK_IMAGE);

            }

        });
        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent captured = new Intent(ACTION_IMAGE_CAPTURE);
                startActivityForResult(captured, CAPTURE_IMAGE);

            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {

                inputName = userName.getText().toString();
                inputEmail = userEmail.getText().toString();
                inputPassword = userPassword.getText().toString();


                preferences.putString("Name", inputName);
                preferences.putString("Email", inputEmail);
                preferences.putString("Password", inputPassword);


                preferences.apply();


                if (inputName.isEmpty() || inputEmail.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(Signin.this, "You cannot signin", Toast.LENGTH_SHORT).show();
                }

                else {

                    preferences.putString("is_guest", "false");
                    preferences.apply();
                    Intent home = new Intent(Signin.this, Catagory.class);
                    startActivity(home);
                    finish();


                }
            }

        });


    }

    private void initUI() {
        circularImage = (CircleImageView) findViewById(R.id.circleimage);


        userName = (EditText) findViewById(R.id.myname);

        userEmail = (EditText) findViewById(R.id.myemail);

        userPassword = (EditText) findViewById(R.id.mypass);

        pickButton = (Button) findViewById(R.id.pickbutton);

        captureButton = (Button) findViewById(R.id.capturebutton);

        sign = (Button) findViewById(R.id.button4);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {


            Uri pickimg = data.getData();
            circularImage.setImageURI(pickimg);
            preferences.putString("Image", pickimg.toString());

            //preferences.commit();
        }
        if (requestCode == CAPTURE_IMAGE && resultCode == Activity.RESULT_OK && data != null) {


            Bitmap capimg = (Bitmap) data.getExtras().get("data");
            circularImage.setImageBitmap(capimg);



        }


    }


}
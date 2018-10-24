package com.example.hafeez1.loginorsigninapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Quiz extends AppCompatActivity {

    TextView userMarks, userQuestion, texted;
    Button userTrue, userFalse, userNext;
    int index = 0;
    int marks = 0;
    String quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        userMarks = (TextView) findViewById(R.id.quizmarks);
        userQuestion = (TextView) findViewById(R.id.myquestion);
        userTrue = (Button) findViewById(R.id.truebutton);
        userFalse = (Button) findViewById(R.id.falsebutton);
        userNext = (Button) findViewById(R.id.nextbutton);


        quiz = getIntent().getExtras().getString("name");
        final HashMap<String, Boolean> Questions = new HashMap<>();
        final String[] sawal = new String[10];

        if (quiz.equals("Maths")) {


            sawal[0] = "((22)3) = 25.";
            sawal[1] = "A googol is bigger than a billion.";
            sawal[2] = "29 + 38 = 57";
            sawal[3] = "The slope of a vertical line is undefined";
            sawal[4] = "121 ÷ 11 = 11";
            sawal[5] = "All sides of a scalene triangle have the same length";
            sawal[6] = "-2 is an integer";
            sawal[7] = "A convex shape curves outwards";
            sawal[8] = "53 - 18 = 25";
            sawal[9] = "Pi can be correctly written as a fraction";

            userQuestion.setText(sawal[0]);
            userMarks.setText(String.valueOf(marks));


            Questions.put("((22)3) = 25.", false);
            Questions.put("A googol is bigger than a billion.", true);
            Questions.put("29 + 38 = 57", false);
            Questions.put("The slope of a vertical line is undefined", true);
            Questions.put("121 ÷ 11 = 11", true);
            Questions.put("All sides of a scalene triangle have the same length", false);
            Questions.put("-2 is an integer", true);
            Questions.put("A convex shape curves outwards", true);
            Questions.put("53 - 18 = 25", false);
            Questions.put("Pi can be correctly written as a fraction", false);


        }


        if (quiz.equals("Science")) {

            sawal[0] = "Electrons are larger than molecules.";
            sawal[1] = "Red is higher frequency light than Blue";
            sawal[2] = "Atoms are most stable when their outer shells are full.";
            sawal[3] = "The human skeleton is made up of less than 100 bones.";
            sawal[4] = "Oxygen is the most common element on Earth";
            sawal[5] = "Molecules can have atoms from more than one chemical element";
            sawal[6] = "Kelvin is a measure of temperature";
            sawal[7] = "Venus is the closest planet to the Sun";
            sawal[8] = "Water is an example of a chemical element";
            sawal[9] = "Sharks are mammals";

            userQuestion.setText(sawal[0]);
            userMarks.setText(String.valueOf(marks));

            Questions.put("Electrons are larger than molecules.", false);
            Questions.put("Red is higher frequency light than Blue", true);
            Questions.put("Atoms are most stable when their outer shells are full.", true);
            Questions.put("The human skeleton is made up of less than 100 bones.", false);
            Questions.put("Oxygen is the most common element on Earth", false);
            Questions.put("Molecules can have atoms from more than one chemical element", true);
            Questions.put("Kelvin is a measure of temperature", true);
            Questions.put("Venus is the closest planet to the Sun", false);
            Questions.put("Water is an example of a chemical element", false);
            Questions.put("Sharks are mammals", false);

        }

        if (quiz.equals("General Knowledge")) {

            sawal[0] = "Human body glow in the dark but its too faint to see";
            sawal[1] = "The fax machine was patented in 1843";
            sawal[2] = "The oldest living organism on earth is cockroach";
            sawal[3] = "The Atlantic Ocean is the biggest ocean on Earth.";
            sawal[4] = "Herbivores eat meat.";
            sawal[5] = "In January Earth is closest to the Sun";
            sawal[6] = "Electrons are larger than molecules";
            sawal[7] = "Lighters were invented before matches";
            sawal[8] = "There are more possible moves in chess than there are atoms in the known universe";
            sawal[9] = "Spiders have six legs";


            userQuestion.setText(sawal[0]);
            userMarks.setText(String.valueOf(marks));

            Questions.put("Human body glow in the dark but its too faint to see", true);
            Questions.put("The fax machine was patented in 1843", true);
            Questions.put("The oldest living organism on earth is cockroach", true);
            Questions.put("The Atlantic Ocean is the biggest ocean on Earth.", false);
            Questions.put("Herbivores eat meat.", false);
            Questions.put("In January Earth is closest to the Sun", true);
            Questions.put("Electrons are larger than molecules", false);
            Questions.put("Lighters were invented before matches", true);
            Questions.put("There are more possible moves in chess than there are atoms in the known universe", true);
            Questions.put("Spiders have six legs", false);

        }

        if (quiz.equals("Pakistan Studies")) {

            sawal[0] = "Sialkot is famous for its sports goods";
            sawal[1] = "Peshawar is the capital of the Balochistan province";
            sawal[2] = "Khuzdar is said to have consistently the highest temperature in Pakistan";
            sawal[3] = "Pakistan borders Afghanistan";
            sawal[4] = "Punjabi was declared the national language of Pakistan in the constitution of 1956";
            sawal[5] = "K-2 peak is the 1st Highest peak of the World";
            sawal[6] = "Sir Syed Ahmed Khan Reviewed the famous book “The Indian Musalmans” in 1872";
            sawal[7] = "Allama Muhammad Iqbal delivered his famous Allahabad Address in 1930";
            sawal[8] = "Mohammad Ali Jinnah is the first Governor General of Pakistan";
            sawal[9] = "1991 was the year when Pakistan win the Cricket World Cup";


            userQuestion.setText(sawal[0]);
            userMarks.setText(String.valueOf(marks));

            Questions.put("Sialkot is famous for its sports goods", true);
            Questions.put("Peshawar is the capital of the Balochistan province", false);
            Questions.put("Khuzdar is said to have consistently the highest temperature in Pakistan", false);
            Questions.put("Pakistan borders Afghanistan", true);
            Questions.put("Punjabi was declared the national language of Pakistan in the constitution of 1956", false);
            Questions.put("K-2 peak is the 1st Highest peak of the World", false);
            Questions.put("Sir Syed Ahmed Khan Reviewed the famous book “The Indian Musalmans” in 1872", true);
            Questions.put("Allama Muhammad Iqbal delivered his famous Allahabad Address in 1930", true);
            Questions.put("Mohammad Ali Jinnah is the first Governor General of Pakistan", true);
            Questions.put("1991 was the year when Pakistan win the Cricket World Cup", false);

        }

        if (quiz.equals("Computer")) {

            sawal[0] = "Wireless data communications are 5th generation innovation in computing";
            sawal[1] = "Computer Science is the study of how to write computer programs";
            sawal[2] = "The CPU is responsible for executing instructions for the computer";
            sawal[3] = "Main memory is a place where the programs and data are store temporarily during processing";
            sawal[4] = "Variable names can begin with a number";
            sawal[5] = "Decimal numbers are only stored by floats or double data types";
            sawal[6] = "A method name should usually be a noun or noun phrase.";
            sawal[7] = "ROM stands for read only memory";
            sawal[8] = "Freeware is software that is available for use at no monetary cost";
            sawal[9] = "The hexadecimal number system contains digits from 1 - 15.";


            userQuestion.setText(sawal[0]);
            userMarks.setText(String.valueOf(marks));

            Questions.put("Wireless data communications are 5th generation innovation in computing", true);
            Questions.put("Computer Science is the study of how to write computer programs", false);
            Questions.put("The CPU is responsible for executing instructions for the computer", true);
            Questions.put("Main memory is a place where the programs and data are store temporarily during processing", true);
            Questions.put("Variable names can begin with a number", false);
            Questions.put("Decimal numbers are only stored by floats or double data types", true);
            Questions.put("A method name should usually be a noun or noun phrase.", false);
            Questions.put("ROM stands for read only memory", true);
            Questions.put("Freeware is software that is available for use at no monetary cost", true);
            Questions.put("The hexadecimal number system contains digits from 1 - 15.", false);


        }


        userTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isTrue = Questions.get(userQuestion.getText().toString());

                if (isTrue) {
                    index = index + 1;
                    if (index < 10) {
                        userQuestion.setText(sawal[index]);
                    } else {

                        userTrue.setVisibility(View.INVISIBLE);
                        userFalse.setVisibility(View.INVISIBLE);
                        userQuestion.setVisibility(View.INVISIBLE);
                        userNext.setVisibility(View.VISIBLE);

                    }

                    marks = marks + 2;
                    userMarks.setText("marks : " + marks);
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Quiz.this, "Incorrect", Toast.LENGTH_SHORT).show();
                    index = index + 1;

                    if (index < 10) {
                        userQuestion.setText(sawal[index]);
                    } else {

                        userTrue.setVisibility(View.INVISIBLE);
                        userFalse.setVisibility(View.INVISIBLE);
                        userQuestion.setVisibility(View.INVISIBLE);
                        userNext.setVisibility(View.VISIBLE);


                    }

                }
            }
        });


        userFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isFalse = Questions.get(userQuestion.getText().toString());

                if (!isFalse) {

                    index = index + 1;
                    if (index < 10) {
                        userQuestion.setText(sawal[index]);
                    } else {

                        userTrue.setVisibility(View.INVISIBLE);
                        userFalse.setVisibility(View.INVISIBLE);
                        userQuestion.setVisibility(View.INVISIBLE);
                        userNext.setVisibility(View.VISIBLE);


                    }

                    marks = marks + 2;
                    userMarks.setText("marks :" + marks);
                    Toast.makeText(Quiz.this, "Correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Quiz.this, "Incorrect", Toast.LENGTH_SHORT).show();

                    index = index + 1;
                    if (index < 10) {
                        userQuestion.setText(sawal[index]);
                    } else {
                        userTrue.setVisibility(View.INVISIBLE);
                        userFalse.setVisibility(View.INVISIBLE);
                        userQuestion.setVisibility(View.INVISIBLE);
                        userNext.setVisibility(View.VISIBLE);


                    }

                }
            }
        });
        if (index < 10) {
            userNext.setVisibility(View.INVISIBLE);

        } else {

            userNext.setVisibility(View.VISIBLE);
        }


        userNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent nextpage = new Intent(Quiz.this, Results.class);
                nextpage.putExtra("Your score", userMarks.getText().toString());
                startActivity(nextpage);


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


SharedPreferences preferences = getSharedPreferences("SharedPreferences", MODE_PRIVATE);
        String name = preferences.getString("Name", null);
        String password = preferences.getString("Password", null );

        if (name != null && password != null) {

            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.options, menu);
        } return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {

            SharedPreferences.Editor editorPrefs = getSharedPreferences(Common.sharedPreferences, MODE_PRIVATE).edit();
            editorPrefs.clear();
            editorPrefs.apply();


            Intent intent = new Intent(Quiz.this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.userProfile) {
            Intent intented = new Intent(Quiz.this, userProfile.class);
            startActivity(intented);

        }
        return true;

    }

}





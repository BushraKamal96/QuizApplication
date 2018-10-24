package com.example.hafeez1.loginorsigninapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.hafeez1.loginorsigninapplication.Model.Quizcatagory;
import com.example.hafeez1.loginorsigninapplication.adapter.CatagoryAdapter;

import java.util.ArrayList;

public class Catagory extends AppCompatActivity {

    private ArrayList<Quizcatagory> arrayList = new ArrayList<>();
    private RecyclerView recycleview;
    private CatagoryAdapter catAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        preparingCatagoryDate();
        recycleview = (RecyclerView) findViewById(R.id.recyclerview);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        catAdapter = new CatagoryAdapter(arrayList, this);
        recycleview.setAdapter(catAdapter);
    }

    private void preparingCatagoryDate() {

        Quizcatagory catagory = new Quizcatagory("Maths");
        arrayList.add(catagory);
        catagory = new Quizcatagory("Science");
        arrayList.add(catagory);
        catagory = new Quizcatagory("General Knowledge");
        arrayList.add(catagory);
        catagory = new Quizcatagory("Pakistan Studies");
        arrayList.add(catagory);
        catagory = new Quizcatagory("Computer");
        arrayList.add(catagory);


    }

}


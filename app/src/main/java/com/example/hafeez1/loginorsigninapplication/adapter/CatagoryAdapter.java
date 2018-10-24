package com.example.hafeez1.loginorsigninapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hafeez1.loginorsigninapplication.Model.Quizcatagory;
import com.example.hafeez1.loginorsigninapplication.Quiz;
import com.example.hafeez1.loginorsigninapplication.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by acer on 7/1/2018.
 */

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.MyViewHolder> {
    ArrayList<Quizcatagory> arrayList = new ArrayList<>();
    Context context;

    public CatagoryAdapter(ArrayList<Quizcatagory> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Quizcatagory catagory = arrayList.get(position);
        holder.button.setText(catagory.getButton());
        //Picasso.with(context).load(catagory.g)
        //Toast.makeText(context, catagory.getButton(), Toast.LENGTH_SHORT).show();

        
       holder.button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
               Toast.makeText(context, ""+holder.button.getText(), Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(context, Quiz.class);

               intent.putExtra("name", holder.button.getText());
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Button button;
        View holderView;

        public MyViewHolder(View view) {
            super(view);
            holderView = view;
            button = (Button) holderView.findViewById(R.id.button);


        }
    }

}




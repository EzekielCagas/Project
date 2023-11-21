package com.example.dressire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AboutUs extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Descriptions> descriptionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        recyclerView=findViewById(R.id.recycleView);

        initData();
        setRecyclerView();
    }

    private void initData() {

        descriptionsList = new ArrayList<>();

    }

    private void setRecyclerView() {
        Adapter adapter = new Adapter(descriptionsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}
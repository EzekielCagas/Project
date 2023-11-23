package com.example.dressire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class About extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Contents> contentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        recyclerView = findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();

    }

    private void initRecyclerView() {

        ContentsAdapter contentsAdapter = new ContentsAdapter(contentsList);
        recyclerView.setAdapter(contentsAdapter);
        recyclerView.setHasFixedSize(true);

    }

    private void initData() {

        contentsList = new ArrayList<>();

        contentsList.add(new Contents("One Step Solution", "Dressire is a one step solution to your browsing problem. We provide you a digitalized\n" +
                "version when browsing your desired Gowns, Suits, and Dresses\n" +
                "in rental shops giving you a newer experience."));
        contentsList.add(new Contents("Why Rental?", "With Dressire we are giving you a fresh way to\n" +
                "browse and search for the perfect gown you want to wear to the party. Digitalizing\n" +
                "and making it easy for you to browse and reserve your desired dress."));
        contentsList.add(new Contents("Quick Turnaround Time", "Dressire is making your desired dress hunt much easier\n" +
                "Just swipe / search / and reserve your desired dress is yours to borrow\n" +
                "Providing you a quick turnaround looking for your desired dress to rent out!"));
        contentsList.add(new Contents("Product Quality Control", "With Dressire partnering with multiple shops we gurantee\n" +
                "you that you'll receive a great quality of clothing for your event needs"));
        contentsList.add(new Contents("Our Team", "We in Dressire, Team Porary Co. is obliged and and happy to develop this app\n" +
                "for your rental needs. We want to create an easier way for you to search your desired dress making you\n" +
                "fresh, relevant, and unique on your party."));

    }
}
package edu.miracostacollege.recyclerviewwithcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> itemList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemList.add(new ExampleItem(R.drawable.ic_android, "Android Gal", "Select for Android info"));
        itemList.add(new ExampleItem(R.drawable.ic_audiotrack, "Music Gal", "Select for Music info"));
        itemList.add(new ExampleItem(R.drawable.ic_beach_access, "Beach Gal", "Select for Beach info"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(itemList);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}

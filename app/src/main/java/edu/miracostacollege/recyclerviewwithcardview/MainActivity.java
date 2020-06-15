package edu.miracostacollege.recyclerviewwithcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ExampleItem> itemList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button insertButton;
    private Button removeButton;
    private EditText insertEditText;
    private EditText removeEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        buildeRecyclerView();

        insertButton = findViewById(R.id.buttonInsert);
        removeButton = findViewById(R.id.buttonRemove);
        insertEditText = findViewById(R.id.edit_insert);
        removeEditText = findViewById(R.id.edit_remove);


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(insertEditText.getText().toString());
               insertItem(position);
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(removeEditText.getText().toString());
                removeItem(position);
            }
        });



    }

    public void insertItem(int position){
        itemList.add(position, new ExampleItem(R.drawable.ic_android, "New Item at Position" + position,
                "This is line 2"));
        mAdapter.notifyDataSetChanged();

    }

    public void removeItem(int position){
        itemList.remove(position);
        mAdapter.notifyDataSetChanged();

    }
    private void buildeRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(itemList);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void createExampleList(){
        itemList = new ArrayList<>();
        itemList.add(new ExampleItem(R.drawable.ic_android, "Android Gal",
                "Select for Android info"));
        itemList.add(new ExampleItem(R.drawable.ic_audiotrack, "Music Gal",
                "Select for Music info"));
        itemList.add(new ExampleItem(R.drawable.ic_beach_access, "Beach Gal",
                "Select for Beach info"));


    }
}

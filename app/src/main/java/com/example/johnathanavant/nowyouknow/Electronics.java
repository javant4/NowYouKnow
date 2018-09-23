package com.example.johnathanavant.nowyouknow;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.johnathanavant.nowyouknow.Model.ElectronicsData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Electronics extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Electronics Profiles");

        mRecyclerView = findViewById(R.id.electronics_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Electronics");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<ElectronicsData, ElectronicsViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<ElectronicsData, ElectronicsViewHolder>(
                        ElectronicsData.class,
                        R.layout.electronics_row,
                        ElectronicsViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ElectronicsViewHolder viewHolder, ElectronicsData model, int position) {

                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getdescription(), model.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
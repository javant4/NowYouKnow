package com.example.johnathanavant.nowyouknow;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.johnathanavant.nowyouknow.Model.VehiclesData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Vehicles extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Vehicles Profiles");

        mRecyclerView = findViewById(R.id.vehicles_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Vehicles");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<VehiclesData, VehiclesViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<VehiclesData, VehiclesViewHolder>(
                        VehiclesData.class,
                        R.layout.vehicles_row,
                        VehiclesViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(VehiclesViewHolder viewHolder, VehiclesData model, int position) {

                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getdescription(), model.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}


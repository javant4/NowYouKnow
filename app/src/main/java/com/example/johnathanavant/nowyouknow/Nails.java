package com.example.johnathanavant.nowyouknow;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.johnathanavant.nowyouknow.Model.NailsData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nails extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nails);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Nails Profiles");

        mRecyclerView = findViewById(R.id.nails_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Nails");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<NailsData, NailsViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<NailsData, NailsViewHolder>(
                        NailsData.class,
                        R.layout.nails_row,
                        NailsViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(NailsViewHolder viewHolder, NailsData model, int position) {

                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getdescription(), model.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
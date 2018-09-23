
package com.example.johnathanavant.nowyouknow;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.johnathanavant.nowyouknow.Model.GrillsData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Grills extends AppCompatActivity {
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grills);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Grills Profiles");

        mRecyclerView = findViewById(R.id.grills_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Grills");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<GrillsData, GrillsViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<GrillsData, GrillsViewHolder>(
                        GrillsData.class,
                        R.layout.grills_row,
                        GrillsViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(GrillsViewHolder viewHolder, GrillsData model, int position) {

                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getdescription(), model.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}

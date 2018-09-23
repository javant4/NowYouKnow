package com.example.johnathanavant.nowyouknow;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.johnathanavant.nowyouknow.Model.HairData;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Hair extends AppCompatActivity {

//    private RecyclerView mProfileList;
//    private DatabaseReference mDatabase;

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hair Profiles");

        mRecyclerView = findViewById(R.id.hair_recyclerview);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Hair");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<HairData, HairViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<HairData, HairViewHolder>(
                        HairData.class,
                        R.layout.hair_row,
                        HairViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(HairViewHolder viewHolder, HairData model, int position) {

                        viewHolder.setDetails(getApplicationContext(), model.getTitle(), model.getdescription(), model.getImage());
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Hair");
//        mDatabase.keepSynced(true);
//
//        mProfileList = (RecyclerView) findViewById(R.id.hair_recyclerview);
//        mProfileList.setHasFixedSize(true);
//        mProfileList.setLayoutManager(new LinearLayoutManager(this));
//    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseRecyclerAdapter<HairData,HairDataViewHolder>firebaseRecyclerAdapter= new FirebaseRecyclerAdapter<HairData,HairDataViewHolder>
//                (HairData.class,R.layout.hair_row,HairDataViewHolder.class,mDatabase) {
//            @Override
//            protected void populateViewHolder(HairDataViewHolder viewHolder, HairData model, int position) {
//                viewHolder.setTitle(model.getTitle());
//                viewHolder.setDesc(model.getDesc());
//                viewHolder.setImage(getApplicationContext(),model.getImage());
//            }
//        };
//
//        mProfileList.setAdapter(firebaseRecyclerAdapter);
//    }
//
//    public static class HairDataViewHolder extends RecyclerView.ViewHolder {
//        View mView;
//        public HairDataViewHolder(View itemView){
//            super(itemView);
//            mView=itemView;
//        }
//        public void setTitle(String title){
//            TextView profile_title = (TextView) mView.findViewById(R.id.profile_title);
//            profile_title.setText(title);
//        }
//        public void setDesc(String desc){
//            TextView profile_desc = (TextView) mView.findViewById(R.id.profile_desc);
//            profile_desc.setText(desc);
//        }
//        public void setImage(Context ctx,String image){
//            ImageView profile_Image = (ImageView) mView.findViewById(R.id.profile_image);
//            Picasso.with(ctx).load(image).into(profile_Image);
//        }
//    }
//}

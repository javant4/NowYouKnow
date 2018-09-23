package com.example.johnathanavant.nowyouknow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class VehiclesViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public VehiclesViewHolder(View itemView) {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String title, String description, String image){

        TextView mProfileTitle = mView.findViewById(R.id.profile_title);
        TextView mProfileDescription = mView.findViewById(R.id.profile_description);
        ImageView mProfileImage = mView.findViewById(R.id.profile_image);

        mProfileTitle.setText(title);
        mProfileDescription.setText(description);
        Picasso.get().load(image).into(mProfileImage);

    }
}

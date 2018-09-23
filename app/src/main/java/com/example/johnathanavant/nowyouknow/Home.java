package com.example.johnathanavant.nowyouknow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity implements View.OnClickListener{
    private CardView hairCard,nailsCard,electronicsCard,vehiclesCard,grillsCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        //defining cards
        hairCard = (CardView) findViewById(R.id.hair_card);
        nailsCard = (CardView) findViewById(R.id.nails_card);
        electronicsCard = (CardView) findViewById(R.id.electronics_card);
        vehiclesCard = (CardView) findViewById(R.id.vehicles_card);
        grillsCard = (CardView) findViewById(R.id.grill_card);
        //add click listener to cards
        hairCard.setOnClickListener(this);
        nailsCard.setOnClickListener(this);
        electronicsCard.setOnClickListener(this);
        vehiclesCard.setOnClickListener(this);
        grillsCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.hair_card : i = new Intent(this, Hair.class); startActivity(i); break;
            case R.id.nails_card : i = new Intent(this, Nails.class); startActivity(i); break;
            case R.id.electronics_card : i = new Intent(this, Electronics.class); startActivity(i); break;
            case R.id.vehicles_card : i = new Intent(this, Vehicles.class); startActivity(i); break;
            case R.id.grill_card : i = new Intent(this, Grills.class); startActivity(i); break;
            default:break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_profile){
            Toast.makeText(this, "Profile Clicked", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.menu_signout){
            Toast.makeText(this, "Sign Out Clicked", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

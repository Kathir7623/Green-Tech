package com.example.greenagri;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FarmerDashboardActivity extends AppCompatActivity {
    ImageButton offer,ordinary;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_dashboard);
        offer =  findViewById(R.id.offerproduct);
        ordinary =  findViewById(R.id.ordinarproduct);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(FarmerDashboardActivity.this,OfferActivity.class);
                startActivity(in);
            }
        });
        ordinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(FarmerDashboardActivity.this,FarmerProductActivity.class);
                startActivity(in);
            }
        });


    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Switching on the item id of the menu item
        switch (item.getItemId()) {
            case R.id.nav_account:
                  startActivity(new Intent(getApplicationContext(),LoginScreen.class));
                return true;
            case R.id.nav_settings:
                startActivity(new Intent(getApplicationContext(),SettingActivity.class));
                return true;
            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(),FarmerLoginActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
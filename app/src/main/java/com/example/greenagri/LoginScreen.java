package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class LoginScreen extends AppCompatActivity {
    LinearLayout farmer,user;
    Button govt,set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        farmer =  findViewById(R.id.farmerloginbut);
        user =  findViewById(R.id.uselogrinbut);

        govt = findViewById(R.id.govtlinks);
        set = findViewById(R.id.settings);


        farmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginScreen.this,FarmerLoginActivity.class);
                startActivity(in);
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginScreen.this,LoginActivity.class);
                startActivity(in);
            }
        });

        govt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginScreen.this,GovtActivity.class);
                startActivity(in);
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SettingActivity.class));
            }
        });
    }
}
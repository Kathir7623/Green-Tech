package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Farmer_view extends AppCompatActivity {
    ImageButton offer,or;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_view);
        offer=findViewById(R.id.offerproduct);
        or=findViewById(R.id.ordinarproduct);

        offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(getApplicationContext(),FarmerofferActivity.class);
                startActivity(i1);
            }
        });

        or.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(getApplicationContext(),Dashboard_view.class);
                startActivity(i2);
            }
        });


    }
}
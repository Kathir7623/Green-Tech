package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GovtActivity extends AppCompatActivity {
    TextView one,two,three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_govt);
         one = findViewById(R.id.onelink);
         two = findViewById(R.id.twolink);
         three = findViewById(R.id.thirdlink);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://agricoop.nic.in/programmes-schemes-listing"));
                startActivity(openURL);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://agriculture.gov.in/"));
                startActivity(openURL);
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openURL = new Intent(android.content.Intent.ACTION_VIEW);
                openURL.setData(Uri.parse("http://agricoop.gov.in/divisiontype/rainfed-farming-system/programmes-schemes-new-initiatives"));
                startActivity(openURL);
            }
        });



    }
}
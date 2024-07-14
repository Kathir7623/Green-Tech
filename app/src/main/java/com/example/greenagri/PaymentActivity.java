package com.example.greenagri;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PaymentActivity extends AppCompatActivity {
    EditText card,date,cvv,name;
    Button pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        card = findViewById(R.id.card_number_txt);
        date = findViewById(R.id.expriy_date_txt);
        cvv = findViewById(R.id.cvv_txt);
        name = findViewById(R.id.holder_name_txt);
        pay = findViewById(R.id.pay_btn);



        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Card =card.getText().toString();
                String Date = date.getText().toString();
                String Cvv = cvv.getText().toString();
                String Name =name.getText().toString();

                if (Card.isEmpty() && Card.length()<12){
                    card.setError("Please enter valid number");
                }else if (Date.isEmpty()){
                    date.setError("please enter vaild date");
                } else if (Cvv.isEmpty()) {
                    cvv.setError("Please enter vaild cvv");

                } else if (Name.isEmpty()) {
                    name.setError("Please enter vaild Name");

                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                    builder.setTitle(getString(R.string.app_name));
                    builder.setMessage("Payment Successful");
                    builder.setIcon(R.drawable.success);
                    // add a button
                    builder.setPositiveButton("OK", (dialog, which) -> {
                       finish();
                    });
                    // create and show the alert dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }

            }
        });

    }
}
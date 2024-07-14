package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoorActivity extends AppCompatActivity {
    Button bt;
    EditText pdt, qty;
    String getnum, cname, cmail, cusnum, productname;

    String product, quantity;
    String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_door);

        Intent in = getIntent();
        Bundle b = in.getExtras();

        getnum = b.getString("number");
        cname = b.getString("name");
        cmail = b.getString("mail");
        cusnum = b.getString("cusnum");
        productname = b.getString("product");

        bt = (Button) findViewById(R.id.extrabuybtss);
        pdt = (EditText) findViewById(R.id.productnameedt);
        qty = (EditText) findViewById(R.id.quantityedtss);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                product = pdt.getText().toString();
                quantity = qty.getText().toString();

                msg = cname + "Need to Ask Extra Products  Product Name : " + product + " and Quantity is : " + quantity + "Notification from " ;

                String msgs = cname + " user. "+ " User Contact Details : " + " Name : " + cname  + " Email id : " + cmail  + " Contact Number : " + cusnum;

                try {
                    SmsManager sm2 = SmsManager.getDefault();
                    sm2.sendTextMessage(getnum, null, msg, null, null);
                    sm2.sendTextMessage(getnum, null, msgs, null, null);

                    Toast.makeText(getApplicationContext(), "Send Notification to Farmer", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
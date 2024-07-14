package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AlertActivity extends AppCompatActivity {
    Button bt,pay;
    TextView one, two, three, four;
    EditText pdt, qty;
    String product = "";
    String quantity = "";
    Button doordelevery;
    EditText name, address, number;

    String username = "";
    String addr = "";
    String cnum = "";
    String getnum, getcname, getcmail, getcnum, productname;

    Button forextra, doorbuy, extrabut;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        bt = (Button) findViewById(R.id.alertbt);
        forextra = (Button) findViewById(R.id.forextra);
        one = (TextView) findViewById(R.id.fnumshow);
        two = (TextView) findViewById(R.id.cnameshow);
        three = (TextView) findViewById(R.id.cmailshow);
        four = (TextView) findViewById(R.id.cnumshow);
        pay = findViewById(R.id.pay);
        doordelevery = (Button) findViewById(R.id.doordeleverybt);


        pdt = (EditText) findViewById(R.id.extraproduct);
        qty = (EditText) findViewById(R.id.extraquantity);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        getnum = b.getString("fnum");
        getcname = b.getString("cname");
        getcmail = b.getString("cmail");
        getcnum = b.getString("cnum");
        productname = b.getString("product");
        one.setText(getnum);
        two.setText(getcname);
        three.setText(getcmail);
        four.setText(getcnum);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),PaymentActivity.class));

            }
        });

        forextra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(AlertActivity.this, ExtraActivity.class);
                in.putExtra("number", getnum);
                in.putExtra("name", getcname);
                in.putExtra("mail", getcmail);
                in.putExtra("cusnum", getcnum);
                in.putExtra("product", productname);

                startActivity(in);
            }
        });


        doordelevery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in = new Intent(AlertActivity.this, DoorActivity.class);
                in.putExtra("number", getnum);
                in.putExtra("name", getcname);
                in.putExtra("mail", getcmail);
                in.putExtra("cusnum", getcnum);
                in.putExtra("product", productname);
                startActivity(in);
            }
        });


        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg = "Notification from " + getcname + "\n" + " User Contact Details : " + "\n" + " Name : " + getcname + "\n" + " Email id : " + getcmail + "\n" + " Contact Number : " + getcnum;
                try {

                    SmsManager sm = SmsManager.getDefault();
                    sm.sendTextMessage(getnum, null, msg, null, null);
                    Toast.makeText(getApplicationContext(), "Send Notification to Farmer", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
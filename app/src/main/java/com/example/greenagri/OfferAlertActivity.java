package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OfferAlertActivity extends AppCompatActivity {
    Button bt,pay;
    TextView one, two, three, four;
    EditText pdt, qty;
    String product = "";
    String quantity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_alert);

        bt = (Button) findViewById(R.id.oalertbt);

        one = (TextView) findViewById(R.id.ofnumshow);
        two = (TextView) findViewById(R.id.ocnameshow);
        three = (TextView) findViewById(R.id.ocmailshow);
        four = (TextView) findViewById(R.id.ocnumshow);
        pay = findViewById(R.id.pay);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        final String getnum = b.getString("fnum");
        final String getcname = b.getString("cname");
        final String getcmail = b.getString("cmail");
        final String getcnum = b.getString("cnum");

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

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String msg = "Notification from " + getcname + " user. " + "\n" + " User Contact Details : " + "\n" + " Name : " + getcname + "\n" + " Email id : " + getcmail + "\n" + " Contact Number : " + getcnum;

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
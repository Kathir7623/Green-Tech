package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExtraActivity extends AppCompatActivity {

    EditText name,address,number;
    Button send;
    String username,addr,cnum;
    String getnum,cname,cmail,cusnum,productname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);

        Intent in = getIntent();
        Bundle b = in.getExtras();

        getnum = b.getString("number");
        cname = b.getString("name");
        cmail = b.getString("mail");
        cusnum = b.getString("cusnum");
        productname = b.getString("product");


        name = (EditText) findViewById(R.id.extrauname);
        address = (EditText)findViewById(R.id.extraaddress);
        number = (EditText) findViewById(R.id.extracnum);
        send = (Button) findViewById(R.id.extrabuy);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = name.getText().toString();
                addr = address.getText().toString();
                cnum = number.getText().toString();


                if ((username.equals("")) && (addr.equals("")) && (cnum.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Please fill the Address Details", Toast.LENGTH_SHORT).show();
                } else {
                    String extras = "The Product Name is : "+productname+"\n"+cname + "Need to Ask Door Delivery " + "\n" +"Address Details is : "+addr+"\n"+"For Contact "+cnum;


                    try {
                        SmsManager sm1 = SmsManager.getDefault();
                        sm1.sendTextMessage(getnum, null, extras, null, null);
                        Toast.makeText(getApplicationContext(), "Send Notification to Farmer", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
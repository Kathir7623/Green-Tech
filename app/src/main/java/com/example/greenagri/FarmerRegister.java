package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FarmerRegister extends AppCompatActivity {
    EditText name,mail,num,pass,adhar,addr;
    Button reg;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_register);
        name = (EditText) findViewById(R.id.fnameedt);
        mail = (EditText) findViewById(R.id.femailedt);
        num = (EditText) findViewById(R.id.fmobileedt);
        pass = (EditText) findViewById(R.id.fpassedt);
        adhar = (EditText) findViewById(R.id.fadharedt);
        addr = (EditText) findViewById(R.id.faddressedt);
        reg = (Button) findViewById(R.id.fregbt);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);

        loginDataBaseAdapter = loginDataBaseAdapter.open();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fname = name.getText().toString();
                String mailid = mail.getText().toString();
                String number = num.getText().toString();
                String password = pass.getText().toString();
                String adharno = adhar.getText().toString();
                String address =addr.getText().toString();

                if((fname.equals("")) || (mailid.equals("")) || (number.equals("")) || (password.equals("")) || (adharno.equals("")) || (address.equals(""))){

                    Toast.makeText(getApplicationContext(),"Field Empty",Toast.LENGTH_LONG).show();

                }else {

                    loginDataBaseAdapter.insertFarmerEntry(fname,mailid,password,number,adharno,address);
                    Toast.makeText(getApplicationContext(),"FARMER Registration Sucessfully",Toast.LENGTH_LONG).show();
                    Intent in = new Intent(FarmerRegister.this,FarmerLoginActivity.class);
                    startActivity(in);
                }
            }
        });


    }
}
package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText uname, email, pass, mnum, adhar, dob, addr;
    Button reg;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        uname = (EditText) findViewById(R.id.unameedt);
        email = (EditText) findViewById(R.id.emailedt);
        pass = (EditText) findViewById(R.id.passedt);
        mnum = (EditText) findViewById(R.id.mobileedt);
        adhar = (EditText) findViewById(R.id.adharedt);
        dob = (EditText) findViewById(R.id.dobedt);
        addr = (EditText) findViewById(R.id.addressedt);

        reg = (Button) findViewById(R.id.regbt);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = uname.getText().toString();
                String mail = email.getText().toString();
                String pas = pass.getText().toString();
                String num = mnum.getText().toString();
                String adhr = adhar.getText().toString();
                String date = dob.getText().toString();
                String adr = addr.getText().toString();


                if ((name.equals("")) || (mail.equals("")) || (pas.equals("")) || (num.equals("")) || (adhr.equals("")) || (date.equals("")) || (adr.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Field Vagent", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Registered Sucessfully", Toast.LENGTH_LONG).show();
                    loginDataBaseAdapter.insertEntry(name, mail, pas, num, adhr, date, adr);
                    Intent in = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(in);
                }


            }
        });


    }
}
package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FarmerLoginActivity extends AppCompatActivity {
    EditText mail, pass;
    Button login;
    TextView signup;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_login);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        mail = (EditText) findViewById(R.id.Femaillogin);
        pass = (EditText) findViewById(R.id.Fpasslogin);
        login = (Button) findViewById(R.id.Floginbt);
        signup = (TextView) findViewById(R.id.Fsignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(FarmerLoginActivity.this, FarmerRegister.class);
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mail.getText().toString();
                String pas = pass.getText().toString();

                String temp = loginDataBaseAdapter.getSinlgeEntryF(email);

                if (temp.equals(pas)) {

                    Intent in = new Intent(FarmerLoginActivity.this,Farmer_selction.class);
                    startActivity(in);
                    Toast.makeText(getApplicationContext(), "Login Sucessfully !!!", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed !!!", Toast.LENGTH_LONG).show();
                    mail.setText("");
                    pass.setText("");
                }
            }
        });

    }
}
package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mail, pass;
    Button login;
    TextView signup;
    LoginDataBaseAdapter loginDataBaseAdapter;
    public final static String KEY_EXTRA_CONTACT_ID = "KEY_EXTRA_CONTACT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();

        mail = (EditText) findViewById(R.id.emaillogin);
        pass = (EditText) findViewById(R.id.passlogin);
        login = (Button) findViewById(R.id.loginbt);
        signup = (TextView) findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(in);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mail.getText().toString();
                String pas = pass.getText().toString();
                String temp = loginDataBaseAdapter.getSinlgeEntry(email);
                if (temp.equals(pas)) {

                    Intent in = new Intent(LoginActivity.this,UserDashboardActivity.class);
                    in.putExtra(KEY_EXTRA_CONTACT_ID,email);
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
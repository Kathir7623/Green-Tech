package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OfferActivity extends AppCompatActivity {
    EditText pname, fname, pcost, pweight, fnum;
    Button submit;

    SQLiteDatabase mDatabase, meddb;
    public static final String DATABASE_NAME = "myofferdatabase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer);
        pname = (EditText) findViewById(R.id.oproductname);
        fname = (EditText) findViewById(R.id.ofarmername);
        pcost = (EditText) findViewById(R.id.oproductcost);
        pweight = (EditText) findViewById(R.id.oproductweight);
        fnum = (EditText) findViewById(R.id.ofarnernumber);
        submit = (Button) findViewById(R.id.osubmitproduct);


        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatemethod();

                String proname = pname.getText().toString();
                String faname = fname.getText().toString();
                String procost = pcost.getText().toString();
                String proweight = pweight.getText().toString();
                String fanum = fnum.getText().toString();

                if ((proname.equals("")) || (faname.equals("")) || (procost.equals("")) || (proweight.equals("")) || (fanum.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Field Empty", Toast.LENGTH_LONG).show();
                } else {
                    String insertSQL = "INSERT INTO OfferProduct \n" +
                            "(oproductname,ofarmername,oproductcost,oproductweight,ofarmernumber)\n" +
                            "VALUES \n" +
                            "(?,?,?,?,?);";
                    //using the same method execsql for inserting values
                    //this time it has two parameters
                    //first is the sql string and second is the parameters that is to be binded with the query
                    mDatabase.execSQL(insertSQL, new String[]{proname, faname, procost, proweight, fanum});
                    Toast.makeText(OfferActivity.this, "Product Added Successfully", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(OfferActivity.this, Farmer_selction.class);
                    startActivity(in);
                }
            }
        });


    }

    private void updatemethod() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS OfferProduct (\n" +
                        "     oproductname varchar(200) NOT NULL," +
                        "    ofarmername varchar(200) NOT NULL\n," +
                        "    oproductcost varchar(200) NOT NULL\n," +
                        "    oproductweight varchar(200) NOT NULL\n," +
                        "    ofarmernumber varchar(200) NOT NULL\n" +
                        ");"
        );
    }
}
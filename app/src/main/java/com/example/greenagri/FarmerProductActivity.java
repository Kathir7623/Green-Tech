package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FarmerProductActivity extends AppCompatActivity {
    EditText pname, fname, pcost, pweight, fnum;
    Button submit;

    SQLiteDatabase mDatabase, meddb;
    public static final String DATABASE_NAMEUP = "mypackageupdatedatabase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_product);
        pname = (EditText) findViewById(R.id.productname);
        fname = (EditText) findViewById(R.id.farmername);
        pcost = (EditText) findViewById(R.id.productcost);
        pweight = (EditText) findViewById(R.id.productweight);
        fnum = (EditText) findViewById(R.id.farnernumber);
        submit = (Button) findViewById(R.id.submitproduct);

        mDatabase = openOrCreateDatabase(DATABASE_NAMEUP, MODE_PRIVATE, null);


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
                    String insertSQL = "INSERT INTO ProductSubmit \n" +
                            "(productname,farmername,productcost,productweight,farmernumber)\n" +
                            "VALUES \n" +
                            "(?,?,?,?,?);";
                    //using the same method execsql for inserting values
                    //this time it has two parameters
                    //first is the sql string and second is the parameters that is to be binded with the query
                    mDatabase.execSQL(insertSQL, new String[]{proname, faname, procost, proweight, fanum});
                    Toast.makeText(FarmerProductActivity.this, "Product Added Successfully", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(FarmerProductActivity.this, Farmer_selction.class);
                    startActivity(in);
                }
            }
        });


    }

    private void updatemethod() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS ProductSubmit (\n" +
                        "     productname varchar(200) NOT NULL," +
                        "    farmername varchar(200) NOT NULL\n," +
                        "    productcost varchar(200) NOT NULL\n," +
                        "    productweight varchar(200) NOT NULL\n," +
                        "    farmernumber varchar(200) NOT NULL\n" +
                        ");"
        );
    }
    }

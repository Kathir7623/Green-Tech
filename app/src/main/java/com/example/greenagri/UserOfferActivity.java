package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserOfferActivity extends AppCompatActivity {
    List<OfferProduct> employeeList;
    SQLiteDatabase mDatabase;
    ListView listViewEmployees;
    OfferProductAdapter adapter;
    LoginDataBaseAdapter loginDataBaseAdapter;
    TextView name, mail, num;
    String names,mails,nums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_offer);

        loginDataBaseAdapter = new LoginDataBaseAdapter(this);
        loginDataBaseAdapter = loginDataBaseAdapter.open();
        name = (TextView) findViewById(R.id.onameview);
        mail = (TextView) findViewById(R.id.oemailview);
        num = (TextView) findViewById(R.id.omobview);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        names=b.getString("name");
        mails=b.getString("mail");
        nums=b.getString("num");

        name.setText(names);
        mail.setText(mails);
        num.setText(nums);
        listViewEmployees = (ListView) findViewById(R.id.olist);
        employeeList = new ArrayList<>();
        //opening the database
        mDatabase = openOrCreateDatabase(OfferActivity.DATABASE_NAME, MODE_PRIVATE, null);
        //this method will display the employees in the list
        showEmployeesFromDatabase();
    }

    private void showEmployeesFromDatabase() {

        Cursor cursorEmployees = mDatabase.rawQuery("SELECT * FROM OfferProduct", null);
        //if the cursor has some data
        if (cursorEmployees.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                employeeList.add(new OfferProduct(
                        cursorEmployees.getString(0),
                        cursorEmployees.getString(1),
                        cursorEmployees.getString(2),
                        cursorEmployees.getString(3),
                        cursorEmployees.getString(4)
                ));
            } while (cursorEmployees.moveToNext());
        }
        cursorEmployees.close();
        //creting the adapter object
        adapter = new OfferProductAdapter(this, R.layout.offer_farmer_list, employeeList, mDatabase);
        //adding the adapter to listview
        listViewEmployees.setAdapter(adapter);
    }
    }

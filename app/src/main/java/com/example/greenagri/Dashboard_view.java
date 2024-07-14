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

public class Dashboard_view extends AppCompatActivity {
    List<Product_View> employeeList;
    SQLiteDatabase mDatabase;
    ListView listViewEmployees;
    ProductAdapter_View adapter;
    LoginDataBaseAdapter loginDataBaseAdapte;
    TextView name, mail, num;

    String names,mails,nums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_view);
        loginDataBaseAdapte = new LoginDataBaseAdapter(this);
        loginDataBaseAdapte = loginDataBaseAdapte.open();

        name = (TextView) findViewById(R.id.nameview);
        mail = (TextView) findViewById(R.id.emailview);
        num = (TextView) findViewById(R.id.mobview);


        listViewEmployees = (ListView) findViewById(R.id.list);
        employeeList = new ArrayList<>();
        //opening the database
        mDatabase = openOrCreateDatabase(FarmerProductActivity.DATABASE_NAMEUP, MODE_PRIVATE, null);
        //this method will display the employees in the list
        showEmployeesFromDatabase();


    }

    private void showEmployeesFromDatabase() {

        Cursor cursorEmployees = mDatabase.rawQuery("SELECT * FROM ProductSubmit", null);
        //if the cursor has some data
        if (cursorEmployees.moveToFirst()) {
            //looping through all the records
            do {
                //pushing each record in the employee list
                employeeList.add(new Product_View(
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
        adapter = new ProductAdapter_View(this, R.layout.farmer_view_list, employeeList, mDatabase);
        //adding the adapter to listview
        listViewEmployees.setAdapter(adapter);
    }
}
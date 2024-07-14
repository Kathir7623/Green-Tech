package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class updatedelete extends AppCompatActivity {
    private EditText courseNameEdt, courseTracksEdt, courseDurationEdt, courseDescriptionEdt,fumber;
    private Button updateCourseBtn, deleteCourseBtn;
    String courseName, courseDesc, courseDuration, courseTracks,fumnber;
    SQLiteDatabase mDatabase, meddb;
    public static final String DATABASE_NAME = "myofferdatabase";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedelete);

        mDatabase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);

        courseNameEdt = findViewById(R.id.name);
        courseTracksEdt = findViewById(R.id.fname);
        courseDurationEdt = findViewById(R.id.cost);
        courseDescriptionEdt = findViewById(R.id.weight);
        fumber=findViewById(R.id.fumber);
        updateCourseBtn = findViewById(R.id.up);
        deleteCourseBtn = findViewById(R.id.de);

        Intent i1=getIntent();

           courseName=i1.getStringExtra("one");
           courseDesc=i1.getStringExtra("two");
           courseDuration=i1.getStringExtra("three");
           courseTracks=i1.getStringExtra("four");
           fumnber=i1.getStringExtra("five") ;


           courseNameEdt.setText(courseName);
           courseTracksEdt.setText(courseDesc);
           courseDescriptionEdt.setText(courseDuration);
           courseDurationEdt.setText(courseTracks);
           fumber.setText(fumnber);


           updateCourseBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                        String updatesql="UPDATE OfferProduct \n" +"SET \n"+"oproductname= (?) , ofarmername= (?) ,oproductcost= (?) ,oproductweight= (?),ofarmernumber= (?) \n"
                                +"WHERE \n"+ "oproductname =(?)";


                        mDatabase.execSQL(updatesql, new String[]{courseNameEdt.getText().toString(),courseTracksEdt.getText().toString(),
                        courseDescriptionEdt.getText().toString(),courseDurationEdt.getText().toString(),fumber.getText().toString(),courseName});

                   Toast.makeText(updatedelete.this, "update successfully", Toast.LENGTH_SHORT).show();

                   Intent i1=new Intent(getApplicationContext(),Farmer_selction.class);
                   startActivity(i1);


               }
           });

           deleteCourseBtn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String deletesql="DELETE FROM OfferProduct \n" +"WHERE \n"+ "oproductname =(?)";

                   mDatabase.execSQL(deletesql, new String[]{courseName});

                   Toast.makeText(updatedelete.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                   Intent i2=new Intent(getApplicationContext(),Farmer_selction.class);
                   startActivity(i2);
               }
           });







    }
}
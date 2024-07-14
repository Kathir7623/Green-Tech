package com.example.greenagri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ProductAdapter_View extends ArrayAdapter<Product_View> {
    Context mCtx;
    int listLayoutRes;
    List<Product_View> employeeListt;
    SQLiteDatabase mDatabase;
    TextView dateshow, textViewone, textViewtwo, textViewthree, textViewfour;
    Button bt;
    String one,two,three,four,five;

    public ProductAdapter_View(@NonNull Context context, int resource, List<Product_View> employeeList, SQLiteDatabase mDatabase) {
        super(context,resource,employeeList);
        this.mCtx = context;
        this.listLayoutRes = resource;
        this.employeeListt = employeeList;
        this.mDatabase = mDatabase;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final Product_View employee = employeeListt.get(position);

        textViewone = view.findViewById(R.id.pnameview);
        textViewtwo = view.findViewById(R.id.fnameview);
        textViewthree = view.findViewById(R.id.pcostview);
        textViewfour = view.findViewById(R.id.pweightview);
        dateshow = view.findViewById(R.id.fnumview);
        bt = view.findViewById(R.id.update);

        textViewone.setText(employee.getOnone());
        textViewtwo.setText(employee.getOntwo());
        textViewthree.setText(employee.getOnthree());
        textViewfour.setText(employee.getOnfour());
        dateshow.setText(employee.getOnfive());

        final TextView txtView1 = (TextView) ((Activity) mCtx).findViewById(R.id.nameview);
        final TextView txtView2 = (TextView) ((Activity) mCtx).findViewById(R.id.emailview);
        final TextView txtView3 = (TextView) ((Activity) mCtx).findViewById(R.id.mobview);

        one= employee.getOnone();
        two=employee.getOntwo();
        three=employee.getOnthree();
        four=employee.getOnfour();
        five=employee.getOnfive();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(mCtx,productupdate.class);
                i1.putExtra("one",one);
                i1.putExtra("two",two);
                i1.putExtra("three",three);
                i1.putExtra("four",four);
                i1.putExtra("five",five);
                mCtx.startActivity(i1);
            }
        });




        return view;
    }
}

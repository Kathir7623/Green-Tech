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

public class OfferProductAdapter_View   extends ArrayAdapter<OfferProduct_View> {

    Context mCtx;
    int listLayoutRes;
    List<OfferProduct_View> employeeListt;
    SQLiteDatabase mDatabase;
    TextView dateshow, textViewone, textViewtwo, textViewthree, textViewfour;
    Button bt,bt1;
    String one,two,three,four,five;

    public OfferProductAdapter_View(@NonNull Context context, int resource, List<OfferProduct_View> employeeList, SQLiteDatabase mDatabase) {
        super(context,resource,employeeList);
        this.mCtx = context;
        this.listLayoutRes = resource;
        this.employeeListt = employeeList;
        this.mDatabase = mDatabase;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final OfferProduct_View employee = employeeListt.get(position);

        textViewone = view.findViewById(R.id.opnameview);
        textViewtwo = view.findViewById(R.id.ofnameview);
        textViewthree = view.findViewById(R.id.opcostview);
        textViewfour = view.findViewById(R.id.opweightview);
        dateshow = view.findViewById(R.id.ofnumview);
        bt = view.findViewById(R.id.update);


        textViewone.setText(employee.getOnone());
        textViewtwo.setText(employee.getOntwo());
        textViewthree.setText(employee.getOnthree());
        textViewfour.setText(employee.getOnfour());
        dateshow.setText(employee.getOnfive());

        one= employee.getOnone();
        two=employee.getOntwo();
        three=employee.getOnthree();
        four=employee.getOnfour();
        five=employee.getOnfive();


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(mCtx,updatedelete.class);
                i1.putExtra("one",one);
                i1.putExtra("two",two);
                i1.putExtra("three",three);
                i1.putExtra("four",four);
                i1.putExtra("five",five);
                mCtx.startActivity(i1);
            }
        });


      /*  final TextView txtView1 = (TextView) ((Activity)mCtx).findViewById(R.id.onameview);
        final TextView txtView2 = (TextView) ((Activity)mCtx).findViewById(R.id.oemailview);
        final TextView txtView3 = (TextView) ((Activity)mCtx).findViewById(R.id.omobview); */








        return view;

    }




}

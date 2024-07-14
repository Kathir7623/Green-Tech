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

public class ProductAdapter extends ArrayAdapter<Product> {
    Context mCtx;
    int listLayoutRes;
    List<Product> employeeListt;
    SQLiteDatabase mDatabase;
    TextView dateshow, textViewone, textViewtwo, textViewthree, textViewfour, one;
    Button bt;


    public ProductAdapter(@NonNull Context context, int resource, List<Product> employeeList, SQLiteDatabase mDatabase) {
        super(context, resource, employeeList);
        this.mCtx = context;
        this.listLayoutRes = resource;
        this.employeeListt = employeeList;
        this.mDatabase = mDatabase;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(listLayoutRes, null);

        final Product employee = employeeListt.get(position);

        textViewone = view.findViewById(R.id.pnameview);
        textViewtwo = view.findViewById(R.id.fnameview);
        textViewthree = view.findViewById(R.id.pcostview);
        textViewfour = view.findViewById(R.id.pweightview);
        dateshow = view.findViewById(R.id.fnumview);
        bt = view.findViewById(R.id.buybt);

        textViewone.setText(employee.getOnone());
        textViewtwo.setText(employee.getOntwo());
        textViewthree.setText(employee.getOnthree());
        textViewfour.setText(employee.getOnfour());
        dateshow.setText(employee.getOnfive());

        final TextView txtView1 = (TextView) ((Activity) mCtx).findViewById(R.id.nameview);
        final TextView txtView2 = (TextView) ((Activity) mCtx).findViewById(R.id.emailview);
        final TextView txtView3 = (TextView) ((Activity) mCtx).findViewById(R.id.mobview);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt1 = txtView1.getText().toString();
                String txt2 = txtView2.getText().toString();
                String txt3 = txtView3.getText().toString();
                String name = textViewone.getText().toString();

                String number = dateshow.getText().toString();

                Intent in = new Intent(mCtx, AlertActivity.class);
                in.putExtra("fnum", number);
                in.putExtra("cname", txt1);
                in.putExtra("cmail", txt2);
                in.putExtra("cnum", txt3);
                in.putExtra("product", name);
                mCtx.startActivity(in);
            }
        });


        return view;
    }
}

package com.example.greenagri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Locale;

public class SettingActivity extends AppCompatActivity {
    Spinner spinner;

    private static final String SELECTED_LANGUAGE = "Locale.Helper.Selected.Language";

    String [] item ={"Select Lanuage","English","Tamil","Malayalam"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SettingActivity.this, android.R.layout.simple_spinner_item,item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String lanu = parent.getItemAtPosition(position).toString();
                if (lanu.equals("English")){
                    setLocal(SettingActivity.this,"en");
                    finish();
                    startActivity(new Intent(getApplicationContext(),LoginScreen.class));

                } else if (lanu.equals("Tamil")) {
                    setLocal(SettingActivity.this,"ta");
                    finish();
                    startActivity(new Intent(getApplicationContext(),LoginScreen.class));

                } else if (lanu.equals("Malayalam")) {
                    setLocal(SettingActivity.this,"ma");
                    finish();
                    startActivity(new Intent(getApplicationContext(),LoginScreen.class));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void setLocal(Activity activity, String langCode){
        Locale locale =new Locale(langCode);
        locale.setDefault(locale);
        Resources resources =activity.getResources();
        Configuration config=resources.getConfiguration();
        config.setLocale(locale);
        resources.updateConfiguration(config,resources.getDisplayMetrics());


    }
}
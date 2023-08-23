package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    private AppCompatSpinner mSpinner;
    private ArrayAdapter<String> mSpAdapter;
    private String[] mcities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mSpinner = findViewById(R.id.sp_city);
        mcities = getResources().getStringArray(R.array.cities);
        mSpAdapter =  new ArrayAdapter<>(this, R.layout.sp_item_layout, mcities);
        mSpinner.setAdapter(mSpAdapter);
    }
}
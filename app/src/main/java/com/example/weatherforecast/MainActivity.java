package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private AppCompatSpinner mSpinner;
    private ArrayAdapter<String> mSpAdapter;
    private String[] mcities;
    private TextView tvWeather, tvTem, tvTemLowHigh, tvWin, tvAir;
    private ImageView ivWeather;
    private RecyclerView rvFutureWeather;

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
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tvWeather = findViewById(R.id.tv_weather);
        tvTem = findViewById(R.id.tv_tem);
        tvTemLowHigh = findViewById(R.id.tv_tem_low_high);
        tvWin = findViewById(R.id.tv_win);
        tvAir = findViewById(R.id.tv_air);
        ivWeather = findViewById(R.id.iv_weather);
        rvFutureWeather = findViewById(R.id.rlv_future_weather);
    }
}
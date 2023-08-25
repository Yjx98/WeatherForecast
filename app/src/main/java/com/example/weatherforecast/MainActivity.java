package com.example.weatherforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherforecast.util.NetUtil;

public class MainActivity extends AppCompatActivity {
    private AppCompatSpinner mSpinner;
    private ArrayAdapter<String> mSpAdapter;
    private String[] mCities;
    private TextView tvWeather, tvTem, tvTemLowHigh, tvWin, tvAir;
    private ImageView ivWeather;
    private RecyclerView rvFutureWeather;

    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String weather = (String) msg.obj;
                Log.d("fan", "---主线程接收到了天气数据数据---" + weather);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        mSpinner = findViewById(R.id.sp_city);
        mCities = getResources().getStringArray(R.array.cities);
        mSpAdapter =  new ArrayAdapter<>(this, R.layout.sp_item_layout, mCities);
        mSpinner.setAdapter(mSpAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectCity = mCities[i];
                getWeatherOfCity(selectCity);
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

    private void getWeatherOfCity(String selectCity) {
        // 开启子线程请求网络
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 请求网络（需要一个网络请求的工具类）
                String weatherCity = NetUtil.getWeatherOfCity(selectCity);

                Message message = Message.obtain();
                message.what = 0;
                message.obj = weatherCity;
                mHandler.sendMessage(message);
            }
        }).start();
    }



}
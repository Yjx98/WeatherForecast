package com.example.weatherforecast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.weatherforecast.Bean.DayWeatherBean;
import com.example.weatherforecast.Bean.WeatherBean;
import com.example.weatherforecast.adapter.FutureWeatherAdapter;
import com.example.weatherforecast.util.NetUtil;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AppCompatSpinner mSpinner;
    private ArrayAdapter<String> mSpAdapter;
    private String[] mCities;
    private TextView tvWeather, tvTem, tvTemLowHigh, tvWin, tvAir;
    private ImageView ivWeather;
    private RecyclerView rlvFutureWeather;

    private FutureWeatherAdapter mWeatherAdapter;
    private DayWeatherBean todayWeather;

    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String weather = (String) msg.obj;
                Log.d("fan", "---主线程接收到了天气数据数据---" + weather);

                // GSON 解析
                Gson gson = new Gson();
                WeatherBean weatherBean = gson.fromJson(weather, WeatherBean.class);  // 将JSON字符串解析成对应的Java对象
                Log.d("fan", "---解析后的weatherBean对应的Java对象---" + weatherBean.toString());

                // 将解析到的数据进行界面呈现
                updateUiOfWeather(weatherBean);

                // 更新完天气进行消息提示
                // 需要外部类Context来显示Toast
                Toast.makeText(MainActivity.this, "更新天气~", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private void updateUiOfWeather(WeatherBean weatherBean) {
        if (weatherBean == null) return;

        List<DayWeatherBean> dayWeathers = weatherBean.getDayWeatherBeans();

        todayWeather = dayWeathers.get(0);
        if (todayWeather == null) return;

        tvTem.setText(todayWeather.getTem());
        tvWeather.setText(todayWeather.getWea() + " " + todayWeather.getDate() + todayWeather.getWeek());
        tvTemLowHigh.setText(todayWeather.getTem2()  + " ~ " + todayWeather.getTem1());
        tvWin.setText(todayWeather.getWin()[0] + " " + todayWeather.getWinSpeed());
        tvAir.setText("空气等级: " + todayWeather.getAir() + " " + todayWeather.getAirLevel() + "\n\n" + todayWeather.getAirTips());
        ivWeather.setImageResource(getImageResource(todayWeather.getWeaImg()));  // 图片更新，针对拿到的不同图片的字符串映射成不同的图片

        dayWeathers.remove(0);  // 去掉当天天气

        // 未来天气的展示，通过RecyclerView
        mWeatherAdapter = new FutureWeatherAdapter(this, dayWeathers);
        rlvFutureWeather.setAdapter(mWeatherAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rlvFutureWeather.setLayoutManager(layoutManager);
    }

    private int getImageResource(String weaStr) {
        int result = 0;
        switch(weaStr) {
            case "qing" :
                result = R.drawable.biz_plugin_weather_qing;
            break;

            case "yin" :
                result = R.drawable.biz_plugin_weather_yin;
                break;

            case "yu" :
                result = R.drawable.biz_plugin_weather_dayu;
                break;

            case "yun" :
                result = R.drawable.biz_plugin_weather_duoyun;
                break;

            case "bingbao" :
                result = R.drawable.biz_plugin_weather_leizhenyubingbao;
                break;

            case "shachen" :
                result = R.drawable.biz_plugin_weather_shachenbao;
                break;

            case "lei" :
                result = R.drawable.biz_plugin_weather_leizhenyu;
                break;

            case  "xue" :
                result = R.drawable.biz_plugin_weather_daxue;
                break;

            default:
                result = R.drawable.biz_plugin_weather_qing;
                break;
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }


    private void initView() {
        // Spinner 控件列表
        mSpinner = findViewById(R.id.sp_city);
        // 要向列表上显示的数据
        mCities = getResources().getStringArray(R.array.cities);
        // 生成Adapter
        mSpAdapter =  new ArrayAdapter<>(this, R.layout.sp_item_layout, mCities);
        // 设置Adapter。设置完成后，就会在对应的列表控件显示对应的数据
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
        rlvFutureWeather = findViewById(R.id.rlv_future_weather);

        tvAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TipsActivity.class);
                Log.d("data", "----todayWeather为：---" + todayWeather);
                // 将数据传递给tipsActivity
                intent.putExtra("tips", todayWeather);
                startActivity(intent);
            }
        });
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
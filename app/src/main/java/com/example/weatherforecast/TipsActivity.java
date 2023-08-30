package com.example.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.weatherforecast.Bean.DayWeatherBean;
import com.example.weatherforecast.adapter.TipsAdapter;

//public class TipsActivity extends AppCompatActivity {
//    // RecyclerView可以高效地重用(Recycle)列表项视图,避免重复创建ItemView带来的性能问题
//    // 通过Adapter可以将数据与列表视图进行绑定
//    private RecyclerView rlvTips;
//    private TipsAdapter mTipsAdapter;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tips);  // 为当前Activity设置显示的布局界面
//
//        rlvTips = findViewById(R.id.rlv_tips);
//
//        // 数据从上一个界面传过来的 todayWeather对象的引用
//        Intent intent = getIntent();
//        DayWeatherBean weatherBean = (DayWeatherBean) intent.getSerializableExtra("tip");
//        Log.d("data", "----从主界面接受过来的数据---" + weatherBean.getTipsBean());
//        if (weatherBean == null) return;
//
//        mTipsAdapter = new TipsAdapter(this, weatherBean.getTipsBean());
//
//        rlvTips.setAdapter(mTipsAdapter);// 如果不指定显示方式，默认就是垂直展示
//        rlvTips.setLayoutManager(new LinearLayoutManager(this));
//    }
//}


public class TipsActivity extends AppCompatActivity {

    private RecyclerView rlvTips;
    private TipsAdapter mTipsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        rlvTips = findViewById(R.id.rlv_tips);

        Intent intent = getIntent();
        DayWeatherBean weatherBean = (DayWeatherBean) intent.getSerializableExtra("tips");
        if (weatherBean == null) return;  // 如果数据为空就不会进行下面的渲染

        mTipsAdapter = new TipsAdapter(this, weatherBean.getTipsBean());

        rlvTips.setAdapter(mTipsAdapter);
        rlvTips.setLayoutManager(new LinearLayoutManager(this));

    }
}
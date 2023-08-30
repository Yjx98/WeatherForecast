package com.example.weatherforecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherforecast.Bean.DayWeatherBean;
import com.example.weatherforecast.R;

import java.util.List;

// RecyclerView 是用于展示大量数据列表的高级控件，而 RecyclerView.Adapter 则负责管理数据集合和对应列表项的显示。
public class FutureWeatherAdapter extends RecyclerView.Adapter<FutureWeatherAdapter.WeatherViewHolder> {

    private Context mContext;
    private List<DayWeatherBean> mWeatherBeans;

    public FutureWeatherAdapter(Context mContext, List<DayWeatherBean> mWeatherBeans) {
        this.mContext = mContext;
        this.mWeatherBeans = mWeatherBeans;
    }

    @NonNull
    @Override
    // 创建控件
    // 创建ViewHolder
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  // 通过View来创建ViewHolder
        // 创建view
        View view = LayoutInflater.from(mContext).inflate(R.layout.weather_item_layout, parent, false);
        // 通过view创建ViewHolder
        WeatherViewHolder weatherViewHolder = new WeatherViewHolder(view);
        return weatherViewHolder;
    }

    @Override
    // 将创建出来的控件来进行赋值
    // 将数据与ViewHolder进行绑定
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        DayWeatherBean weatherBean = mWeatherBeans.get(position);  // 拿到当前位置的JavaBean对象
        holder.tvWeather.setText(weatherBean.getWea());
        holder.tvDate.setText(weatherBean.getDate() + " " + weatherBean.getWeek());
        holder.tvTem.setText(weatherBean.getTem());
        holder.tvAir.setText("空气："+weatherBean.getAir() + weatherBean.getAirLevel());
        holder.tvWin.setText(weatherBean.getWin()[0] + " " + weatherBean.getWinSpeed());
        holder.tvTemLowHigh.setText(weatherBean.getTem2() + " " + "~" + " " + weatherBean.getTem1());
        holder.ivWeather.setImageResource(getImageResource(weatherBean.getWeaImg()));
    }

    @Override
    public int getItemCount() {
        if (mWeatherBeans == null) return 0;
        return mWeatherBeans.size();
    }

    // ViewHolder 是一个列表
    // ViewHolder 是一个包含了列表项视图中各个子视图组件的容器类。它通常定义为适配器的内部类。
    class WeatherViewHolder extends RecyclerView.ViewHolder {
        TextView tvWeather, tvTem, tvTemLowHigh, tvWin, tvAir, tvDate;
        ImageView ivWeather;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWeather = itemView.findViewById(R.id.tv_weather);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvTem = itemView.findViewById(R.id.tv_tem);
            tvTemLowHigh = itemView.findViewById(R.id.tv_tem_low_high);
            tvWin = itemView.findViewById(R.id.tv_win);
            tvAir = itemView.findViewById(R.id.tv_air);
            ivWeather = itemView.findViewById(R.id.iv_weather);
        }
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
}

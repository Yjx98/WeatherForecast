package com.example.weatherforecast.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetUtil {
    public static final String URL_WEATHER_WITH_FUTURE = "https://www.yiketianqi.com/free/week?unescape=1&appid=79152114&appsecret=423yCAvP";

    // 通过建立 HTTP 连接、发送 GET 请求，并从服务器读取响应数据
    // 将网络流数据转换为字符串数据
    public static String doGet(String urlStr) {
        String result = "";
        HttpURLConnection connection = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        // 连接网络
        try {
            // 建立连接
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);

            // 从连接中读取数据(数据是一个InputStream即输入流，这个输入流是一个二进制数据，需要将二进制数据转换成为我们人能看懂的字符串，即对数据流进行加工)
            // 相当于接管子
            InputStream inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            // 将数据流数据放到缓冲区，即先放到一个池子里，处理一部分，读取一部分
            bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();  // 字符串拼接
            String line = "";
            while ((line = bufferedReader.readLine()) != null) { // 每次读取一行
                stringBuilder.append(line);
            }
            result = stringBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            // != 的逻辑：connection 连接成功建立，connection 对象将被赋值为非空对象，否则为 null；
            // 通过检查 connection != null 条件，可以确保在关闭资源时只对有效的连接对象进行操作，避免对空对象进行操作而引发空指针异常
            if (connection != null) connection.disconnect();
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }

    // 获取对应城市的天气
    public static String getWeatherOfCity(String city) {
        String weatherResult = "";

        String weatherUrl = URL_WEATHER_WITH_FUTURE + "&city=" + city;
        Log.d("fan", "---weatherUrl---" + weatherUrl);
        weatherResult = doGet(weatherUrl);
        Log.d("fan", "---weatherResult---" + weatherResult);
        return weatherResult;
    }


}

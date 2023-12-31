## 天气预报App项目
#### （一）涵盖知识点
* android 异步任务
  * 同步执行任务概念
  * 异步执行任务概念
  * 线程概念
* 多线程、
  * 分类
    * 主线程
    * 子线程
  * Handler 机制进行多线程间通信
    * 组成
      * Handler 类
      * Message 消息：传递的实体对象
      * Looper
      * MessageQueue：消息队列
    * 消息传递流程
    * 消息传递时机
    * 主线程与子线程消息传递代码执行流程与范围
* 网络请求
  * GET
  * 数据处理
    * 将网络流数据转换为字符串
      * InputStreamReader
      * InputStreamReader
      * BufferedReader
      * StringBuilder
* JSON 数据解析
  * 注解
  * JavaBean 类
  * 序列化与反序列化
* Java 基础知识
  * 类
    * 匿名类
    * 匿名内部类
    * 匿名对象
    * 工具类
  * 继承
  * 多态
* Android 基础知识
  * Context
  * Activity 界面间跳转进行参数传递
    * Intent
    * 数据传递方式
      * 分散传递 
      * 打包传递（Bundle）
      * 传递对象
      * 数据回传
  * 控件
    * RecyclerView、Adapter
      * ViewHolder
      * ViewHolder
      * onBindViewHolder
    * Spinner
  * 布局
    * 基本概念
    * 容器
      * LinearLayout：以水平或垂直排列控件元素；
      * RelativeLayout：相对于其他视图的位置；
    * 常用属性
      * match_parent
      * match_parent
#### （二）功能
* 主界面：上半部分显示当天的天气，下半部分显示未来6天的天气情况；
* 跳转界面:生活小提示界面；
#### （三）实现步骤
* 主界面布局及初始化；
* 子线程中开启网络请求；
* 网络请求返回的JSON数据解析；
* 界面呈现；

#### （四）实现结果

##### 主界面

<img src="https://github.com/Yjx98/WeatherForecast/blob/master/%E4%B8%BB%E7%95%8C%E9%9D%A2.jpg" alt="主界面" style="zoom: 25%;" />

##### 生活小提示界面

<img src="https://github.com/Yjx98/WeatherForecast/blob/master/%E7%94%9F%E6%B4%BB%E6%8F%90%E7%A4%BA%E7%95%8C%E9%9D%A2.jpg" alt="生活提示界面" style="zoom:25%;" />

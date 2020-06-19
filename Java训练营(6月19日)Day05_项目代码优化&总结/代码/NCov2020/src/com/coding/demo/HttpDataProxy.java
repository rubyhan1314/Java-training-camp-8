package com.coding.demo;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.codingke.ncov.util.HttpDataHandle;

/**
 * 实现缓存
 * 
 * @author ruby
 *
 */
public class HttpDataProxy {

	
	//3.窗体对象
	private MainFrame mainFrame;
	//构造方法
	public HttpDataProxy(MainFrame mainFrame){
		this.mainFrame = mainFrame;
	}
	
	//2.加载数据，判断是否要请求网络
	public void loadData(String urlString){
		//jdk1.8的新增的时间类
		LocalDateTime cachetime= null;
		//如果是第一次访问，只能访问网络
		//如果不是第一次访问，判断事件间隔
		if(mainFrame.currData!=null){
			//不是第一次
			//定义一个事件转换格式
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			//将String类型的事件，转为LocalDateTime，可以做事件差
			cachetime = LocalDateTime.parse(mainFrame.currData.getCachetime(), formatter);
			//获取当前的时间
			LocalDateTime nowtime = LocalDateTime.now();
			//获取两个时间之间的差值
			Duration duration = Duration.between(cachetime, nowtime);//秒
			System.out.println("最近两次请求的时间间隔是(秒)："+duration.getSeconds());
			if(duration.getSeconds() >= 300){//5分钟
				//再次请求网络
				System.out.println("time out get data from http...");
				getData(urlString);
			}else{
				System.out.println("使用缓存数据。。。");
			}
			
			
		}else{
			//是第一次请求，需要访问网络
			System.out.println("第一次获取数据，需要访问网络。。。");
			getData(urlString);
		}
	}
	
	
	// 1.这个是真实的网络请求，我们在它前面加一层控制。
	//获取疫情的数据，并解析为Data对象
	public void getData(String jsonUrl) {
		System.out.println("jsonUrl-->"+jsonUrl);
		HttpDataHandle httpDataHandle = new HttpDataHandle();
		try {
			// 获取网络上的疫情数据：json
			String json = httpDataHandle.request(jsonUrl);
			// 解析json数据
			mainFrame.currData= httpDataHandle.parseJson(json);
//			System.out.println(mainFrame.currData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

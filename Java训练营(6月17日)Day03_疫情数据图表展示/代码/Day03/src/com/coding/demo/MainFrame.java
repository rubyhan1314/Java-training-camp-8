package com.coding.demo;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.codingke.ncov.chart.BarChart;
import com.codingke.ncov.chart.PieChart;
import com.codingke.ncov.chart.TimeSeriesChart;
import com.codingke.ncov.model.Data;
import com.codingke.ncov.util.HttpDataHandle;
import com.codingke.ncov.view.TotalDataPanel;
import com.codingke.ncov.view.WorldDataPanel;
/**
 * 继承JFrame这个类，窗体
 * 思路：
 * step1：设计好界面显示的布局
 * 
 * step2：获取网络数据（已封装）
 * 
 * step3：解析--->Data对象（已经封装）
 * 
 * step4：填充到界面上
 * 
 * 
 * 
 * @author ruby
 *
 */
public class MainFrame extends JFrame {
	
	//2.定义功能区的部分：1个文字，5个按钮
	JLabel jLabel_menu_tip = new JLabel("功能区->");
	JButton jButton1 = new JButton("全国疫情数据汇总");
	JButton jButton2 = new JButton("全国省份疫情数据比例");
	JButton jButton3 = new JButton("全国疫情累计趋势图");
	JButton jButton4 = new JButton("其他国家疫情数据汇总");
	JButton jButton5 = new JButton("其他国家疫情数据统计分析");
	
	//定义面板
	JPanel menuPanel = new JPanel();//功能区的面板
	JPanel mainPanel = new JPanel();//中心区面板
	
	//1.构造方法：显示窗体
	public MainFrame(){
//		System.out.println("构造方法。。。。");
		//设置title
		this.setTitle("抗击肺炎，北京加油！新冠疫情数据实时统计");
		//因为要展示的数据比较多，所以窗体的大小全屏就可以
		//设置全屏，获取窗体的工具箱，获取屏幕的尺寸
		int width = this.getToolkit().getScreenSize().width;
		int height = this.getToolkit().getScreenSize().height;
		this.setSize(width, height);
		
		//3.设置功能区
//		menuPanel.setLayout(new FlowLayout());//设置功能区的布局，流布局
		menuPanel.setLayout(new GridLayout(1, 6,50,0));//设置为网格布局：1行6列，水平间距50，垂直0
		menuPanel.add(jLabel_menu_tip);
		menuPanel.add(jButton1);
		menuPanel.add(jButton2);
		menuPanel.add(jButton3);
		menuPanel.add(jButton4);
		menuPanel.add(jButton5);
		
		//将功能区面板，添加到窗体上
		this.add(menuPanel,BorderLayout.NORTH);//将功能区放在窗体的上部
		
		//设置中心区面板
		mainPanel.setLayout(new BorderLayout());//设置中心区的布局，边界布局
		/*
		 * 颜色：RGB，红绿蓝三原色。
		 * 表示方式：
		 * 	A：# 16进制的数值：
		 * 		#ffffff，白色
		 * 		#000000，黑色
		 * 		#ff0000，红色
		 * 		#00ff00，绿色
		 * 	B：单词，red，green，blue，pink，gray。。。。
		 * 	C：rgb颜色值：0-255
		 * 
		 * 	
		 */
		mainPanel.setBackground(new Color(250, 250, 250));
		this.add(mainPanel,BorderLayout.CENTER);//将中心区添加到窗体的中间部分
		//4.加载图片
		initImage(image1);
		
		//5.按钮的点击事件
		//A：点击第一个按钮，全国疫情汇总
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jLabel_menu_tip.setText("数据加载中，请稍后。。。");
				
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						//获取网络数据
						Data data = getData();
						TotalDataPanel totalDataPanel = new TotalDataPanel(data);
						mainPanel.removeAll();//删除mainPanel面板上的所有的组件
						mainPanel.add(totalDataPanel,BorderLayout.NORTH);//汇总面板放在上面，北
						initImage(image2);
						mainPanel.repaint();//重新绘制
						mainPanel.validate();//重新初始化
						jLabel_menu_tip.setText("功能区->");
					}
				}).start();
				
				
				
				
			}
		});
	
		//B：点击第二个按钮，柱状图
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jLabel_menu_tip.setText("数据加载中，请稍后。。。");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						Data data = getData();
						//柱状图
						BarChart barChart = new BarChart(data);
						JPanel jPanel = barChart.getChartPanel();
						mainPanel.removeAll();
						mainPanel.add(jPanel);
						mainPanel.repaint();//重新绘制
						mainPanel.validate();//重新初始化
						jLabel_menu_tip.setText("功能区->");
					}
				}).start();
				
				
			}
		});
		
		//C：点击第三个按钮
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jLabel_menu_tip.setText("数据加载中，请稍后。。。");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Data data =getData();
						TimeSeriesChart timeSeriesChart = new TimeSeriesChart(data);
						JPanel jPanel = timeSeriesChart.getChartPanel();
						mainPanel.removeAll();
						mainPanel.add(jPanel);
						mainPanel.repaint();//重新绘制
						mainPanel.validate();//重新初始化
						jLabel_menu_tip.setText("功能区->");
					}
				}).start();
				
				
			}
		});
		
		//D，点击第四个按钮流
		jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jLabel_menu_tip.setText("数据加载中，请稍后。。。");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						Data data = getData();
						WorldDataPanel worldDataPanel = new WorldDataPanel(data);
						mainPanel.removeAll();
						mainPanel.add(worldDataPanel,BorderLayout.NORTH);
						initImage(image3);
						mainPanel.repaint();//重新绘制
						mainPanel.validate();//重新初始化
						jLabel_menu_tip.setText("功能区->");
					}
				}).start();
				
				
			}
		});
		
		//E：点击第五个按钮
		jButton5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jLabel_menu_tip.setText("数据加载中，请稍后。。。");
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						Data data = getData();
						//饼图
						PieChart pieChart = new PieChart(data);
						JPanel jPanel = pieChart.getChartPanel();
						mainPanel.removeAll();
						mainPanel.add(jPanel);
						mainPanel.repaint();//重新绘制
						mainPanel.validate();//重新初始化
						jLabel_menu_tip.setText("功能区->");
					}
				}).start();
				
				
			}
		});
		
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//当窗体关闭的时候，程序结束退出
		this.setVisible(true);//设置可见
	}
	
	
	
	//加载图片的方法
	public void initImage(String imageUrl){
		//1.根据当前线程，获取要加载的资源，一张图片
		URL url = Thread.currentThread().getContextClassLoader().getResource(imageUrl);
		//2.根据url创建ImageIcon对象
		ImageIcon icon = new ImageIcon(url);
		//3.创建JLabel标签，显示图片
		JLabel jLabel = new JLabel(icon);
		//4.将JLabel标签对象，放在中心区域的面板上
		mainPanel.add(jLabel,BorderLayout.CENTER);
	}
	
	
	//图片的路径
	String image1 = "com/coding/res/timg2.jpg";//愿世界和平
	String image2 = "com/coding/res/yq.jpg";//武汉加油
	String image3 = "com/coding/res/true.jpeg";//全球抗疫
			
	
	//疫情的网络接口：网址
	String jsonUrl = "https://interface.sina.cn/news/wap/fymap2020_data.d.json"; 
	
	//获取疫情的数据，并解析为Data对象
	public Data getData(){
		HttpDataHandle httpDataHandle = new HttpDataHandle();
		try {
			//获取网络上的疫情数据：json
			String json = httpDataHandle.request(jsonUrl);
			//解析json数据
			Data data = httpDataHandle.parseJson(json);
			return data;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		//创建对象，会自动调用构造方法
		MainFrame mf = new MainFrame();
	}

}

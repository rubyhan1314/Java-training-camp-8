package com.coding.demo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/*
 * 继承 JFrame类
 */
public class DownloadFrame extends JFrame {//继承JFrame这个类，那么DownloadFrame就有了父类的功能

	//2.定义组件，需要放在窗体上才能显示
	JButton jButtonDownload= new JButton("下载");//创建一个按钮
	JButton jButtonYQ = new JButton("获取疫情数据");//创建一个按钮
//	JLabel jLabel = new JLabel("这里是要显示图片的。。",JLabel.CENTER);//文本组件(可以用来显示图片)
	JLabel jLabel  =new JLabel("",JLabel.CENTER);
	
	//3.添加一个面板，为了更好的布局，美观，好看
	JPanel p1 = new JPanel();
	
	//1.构造方法，用于创建对象，当创建对象的时候，自动调用
	public DownloadFrame(){
//		System.out.println("我是一个构造方法啊。。。。");
		this.setSize(850, 700);//设置窗体大小
		
		//设置p1的布局
		p1.setLayout(new FlowLayout());//设置面板的布局为流布局。
		p1.add(jButtonDownload);//添加按钮
		p1.add(jButtonYQ);
		
		
		
		//4.为按钮添加点击事件：下载图片
		jButtonDownload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//添加按钮的点击事件的操作。。。
				System.out.println("我点啊，点点点。。。。。");
				//此处实现获取网络的图片，并且显示到frame上
				
				try {
					//step1：根据一个图片网址创建URL对象
					URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1583842740225&di=df2ffbeaaf3ccd144db55a03cd97910e&imgtype=0&src=http%3A%2F%2Fwx1.sinaimg.cn%2Flarge%2F00678rgoly1ffz5pz8zrej30m80goq76.jpg");
					
					//step2：通过URL打开网络连接
					URLConnection connection = url.openConnection();
					
					//step3：做一些网络设置
					connection.setConnectTimeout(10000);//连接超时，10s，如果网络不好，连不上，超过10s，程序就停了，不会一直等着
					connection.setRequestProperty("Content-Type", "image/jpg");//要访问网络数据的类型，固定写法
					
					//step4：读取数据
					InputStream inputStream = connection.getInputStream();//从连接中获取输入流，用于读取网络上的数据
					FileOutputStream fos = new FileOutputStream("j30m80goq76.jpg");
					
					//创建一个字节数组，用于读取数据
					byte[] bs = new byte[1024];
					int len = -1;//每次读取的数据量，如果读没了，-1.
					while((len = inputStream.read(bs))!=-1){//向byte数组中读数据
						fos.write(bs, 0, len);//写到文件上
					}
					//关闭流
					inputStream.close();
					fos.close();
					
					//将图片显示到label组件上
					ImageIcon icon = new ImageIcon("j30m80goq76.jpg");
					jLabel.setIcon(icon);
					
					
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		
		
		//5.给按钮添加点击事件：获取疫情数据
		jButtonYQ.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//点击疫情按钮，获取疫情的数据
				System.out.println("点击疫情按钮，获取疫情的数据..");
				try {
					URL url = new URL("https://interface.sina.cn/news/wap/fymap2020_data.d.json?_=1580892522427");
					
					URLConnection connection = url.openConnection();
					connection.setReadTimeout(10000);
					connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
					InputStream inputStream = connection.getInputStream();
					
					StringBuffer sb = new StringBuffer();//操作字符串的类
					byte [] bs = new byte[1024];
					int len = -1;
					while((len = inputStream.read(bs))!=-1){
						sb.append(new String(bs,0,len));
					}
					System.out.println("读取到的疫情数据：");
					System.out.println(sb.toString());
					
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		//将按钮等组件，显示到窗体上
//		this.add(jButtonDownload,BorderLayout.NORTH);//上北
		this.add(p1,BorderLayout.NORTH);
		this.add(jLabel,BorderLayout.CENTER);//中间
		
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗体关闭的事件
		this.setVisible(true);//显示窗体
	}
	
	
	public static void main(String[] args) {
		//在主函数中，创建对象
		DownloadFrame df = new DownloadFrame();//创建对象，调用构造方法
	}

}

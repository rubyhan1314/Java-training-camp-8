package com.coding.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.stream.JsonReader;

/**
 * 获取网络数据并处理
 * 
 * step1：获取网络的数据：json格式
 * 
 * step2：解析json-->Java的对象
 * 
 * @author ruby
 *
 */
public class HttpDataHandle {

	/**
	 * 根据指定的网址，获取json字符串
	 * 
	 * @param urlString
	 * @return
	 * @throws IOException
	 */
	public String request(String urlString) throws IOException {
		// 1.根据网址，创建URL对象
		URL url = new URL(urlString);
		// 2.打开网络连接，获取连接对象
		URLConnection connection = url.openConnection();
		// 3.设置
		connection.setConnectTimeout(10000);
		connection.setRequestProperty("Content-Type", "	application/json; charset=utf-8");
		// 4.通过IO流进行获取
		BufferedInputStream in = new BufferedInputStream(connection.getInputStream());// 提升效率
		byte[] bs = new byte[1024];
		int len = -1;
		StringBuffer sb = new StringBuffer();
		while ((len = in.read(bs)) != -1) {
			sb.append(new String(bs, 0, len));
		}
		in.close();// 关闭流
		String json = sb.toString();
		return json;
	}

	/**
	 * 解析json，得到Data对象
	 * @param json
	 * @return
	 * @throws IOException 
	 */
	public Data parseJson(String json) throws IOException{
		//1.io包下有StringReader，字符串的字符流
		StringReader sr = new StringReader(json);
		//2.gson包下，jsonReader，类似于一个读取器
		JsonReader jsonReader = new JsonReader(sr);
		//3.开始解析
		Data data = null;
		jsonReader.beginObject();	
		while(jsonReader.hasNext()){
			//开始解析
			String name = jsonReader.nextName();
			switch (name) {
			case "data_title":
				//跳过
				jsonReader.skipValue();
				break;

			case "data":
				//疫情数据
				data = praseData(jsonReader);
				break;
			default:
				break;
			}
		}
		
		
		jsonReader.endObject();
		return data;
	}
	
	//解析data
	private Data praseData(JsonReader jsonReader) throws IOException {
		jsonReader.beginObject();
		Data data = new Data();
		while(jsonReader.hasNext()){
			String name = jsonReader.nextName();
			switch (name) {
			case "times":
				data.setTimes(jsonReader.nextString());
				break;
			case "mtime":
				data.setMtime(jsonReader.nextString());
				break;
			case "cachetime":
				data.setCachetime(jsonReader.nextString());
				break;
			case "gntotal":
				data.setGntotal(jsonReader.nextString());
				break;
			case "deathtotal":
				data.setDeathtotal(jsonReader.nextString());
				break;
			case "sustotal":
				data.setSustotal(jsonReader.nextString());
				break;
			case "curetotal":
				data.setCuretotal(jsonReader.nextString());
				break;
			case "econNum":
				data.setEconNum(jsonReader.nextString());
				break;
			case "heconNum":
				data.setHeconNum(jsonReader.nextString());
				break;
			case "add_daily":
				AddDaily addDaily = parseAddDaily(jsonReader);
				data.setAdd_daily(addDaily);
				break;
			case "list":
				List<Province> list = parseProviceList(jsonReader);
				data.setProvinceList(list);
				break;
			default:
				jsonReader.skipValue();
				break;
			}
		}
		
		
		
		jsonReader.endObject();
		return data;
	}

	//解析省份集合
	private List<Province> parseProviceList(JsonReader jsonReader) throws IOException {
		List<Province> list = new ArrayList<Province>();
		//此处是数组
		jsonReader.beginArray();
		
		while(jsonReader.hasNext()){
			Province province = parseProvince(jsonReader);
			list.add(province);
		}
		
		
		jsonReader.endArray();
		return list;
	}
//解析省份
	private Province parseProvince(JsonReader jsonReader) throws IOException {
		Province province = new Province();
		jsonReader.beginObject();
		while(jsonReader.hasNext()){
			String name = jsonReader.nextName();
			switch (name) {
			case "name":
				province.setName(jsonReader.nextString());
				break;
			case "ename":	
				province.setEname(jsonReader.nextString());
				break;
			case "value":
				province.setValue(jsonReader.nextString());
				break;
			case "conadd":
				province.setConadd(jsonReader.nextString());
				break;
			case "econNum":
				province.setEconNum(jsonReader.nextString());
				break;
			case "susNum":
				province.setSusNum(jsonReader.nextString());
				break;
			case "deathNum":
				province.setDeathNum(jsonReader.nextString());
				break;
			case "cureNum":
				province.setCureNum(jsonReader.nextString());
				break;
			default:
				jsonReader.skipValue();
				break;
			}
		}
		
		jsonReader.endObject();
		return province;
	}

	//解析AddDaily
	private AddDaily parseAddDaily(JsonReader jsonReader) throws IOException {
		AddDaily addDaily = new AddDaily();
		jsonReader.beginObject();
		while(jsonReader.hasNext()){
			String name = jsonReader.nextName();
			switch (name) {
			case "addcon_new":
				addDaily.setAddcon_new(jsonReader.nextString());
				break;
			case "adddeath_new":
				addDaily.setAdddeath_new(jsonReader.nextString());
				break;
			case "addcure_new":
				addDaily.setAddcure_new(jsonReader.nextString());
				break;
			case "wjw_addsus_new":
				addDaily.setWjw_addsus_new(jsonReader.nextString());
				break;
			case "addecon_new":
				addDaily.setAddecon_new(jsonReader.nextString());
				break;
			case "addhecon_new":
				addDaily.setAddhecon_new(jsonReader.nextString());
				break;
				
				
				
			default:
				jsonReader.skipValue();
				break;
			}
		}
		
		
		
		jsonReader.endObject();
		return addDaily;
	}

	public static void main(String[] args) {
		String urlString = "https://interface.sina.cn/news/wap/fymap2020_data.d.json";
		HttpDataHandle httpDataHandle = new HttpDataHandle();
		try {
			String json = httpDataHandle.request(urlString);
			System.out.println(json);
			
			Data data  = httpDataHandle.parseJson(json);
//			System.out.println(data);
//			System.out.println(data.getAdd_daily());
			for(Province province:data.getProvinceList()){
				System.out.println(province);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

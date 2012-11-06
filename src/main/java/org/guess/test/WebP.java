package org.guess.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class WebP {
	
	public String conUrl = "http://www.quanjing.com";
	
	public void downImage(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements hrefs = doc.select("img[src]");
			for(Element element:hrefs){
				String href = element.attr("abs:src");
				System.out.println("网址:"+ href);
				saveImage(href);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存图片
	 * @param url
	 */
	public void saveImage(String url){
		if(url.indexOf("http:") == -1){
			url = conUrl+url;
		}
		try {
			HttpURLConnection huc = (HttpURLConnection) new URL(
					url).openConnection();
			huc.setRequestMethod("GET");
			InputStream is = huc.getInputStream();
			File file = new File("E:\\ptools\\image\\"+getImageName(url));
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int count;
			while ((count = is.read(buffer)) != -1) {
				fos.write(buffer, 0, count);
			}
			is.close();
			fos.close();
			System.out.println("保存成功！！！！！！！！！！！！！！！！！！！");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取图片地址
	 * @param url
	 * @return
	 */
	public String getImageName(String url){
		System.out.println(url);
		String firstUrl = url.substring(url.lastIndexOf("/")+1);
		if(firstUrl.indexOf("?") != -1){
			String SecondUrl = firstUrl.substring(0,firstUrl.indexOf("?"));
			return SecondUrl;
		}else{
			return firstUrl;
		}
	}
	
	/**
	 * 遍历网址获取地址
	 */
	@Test
	public void downImageByUrl(){
		try {
			Document doc = Jsoup.connect(conUrl).get();
			Elements hrefs = doc.select("a[href]");
			for(Element element:hrefs){
				String href = element.attr("href");
				if(href.indexOf("javascript") == -1 && href.indexOf("http") != -1){
					System.out.println(href);
					downImage(href);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

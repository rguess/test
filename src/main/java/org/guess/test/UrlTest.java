package org.guess.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class UrlTest {

	@Test
	public void test01() {
		try {
			HttpURLConnection huc = (HttpURLConnection) new URL(
					"http://www.qq.com").openConnection();
			huc.setRequestMethod("GET");
			InputStream is = huc.getInputStream();
			StringBuffer temp = new StringBuffer();
			String str;
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, huc
							.equals("text-html; charset=gb2312") ? "gb2312"
							: "UTF-8"));
			
			while ((str = reader.readLine()) != null) {
				temp.append(str + "\n");
			}
			System.out.println(temp.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

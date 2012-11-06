package org.guess.test;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Test;

public class WebClient1 {

	@Test
	public void test01(){
		WebClient client = WebClient.create("http://www.baidu.com");
		String res = client.accept(MediaType.TEXT_HTML).get(String.class);
		System.out.println(res);
	}
}

package com.tmz.okhttp3;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkTest {

	static OkHttpClient httpClient = new OkHttpClient();
	static String url = "http://api.jisuapi.com/lsplateluck/query";
	static String key = "ed34fc4147bebb47";
	
	public static void main(String[] args) {
		
		String carNo = "T8168";
		RequestBody body = new FormBody.Builder()
		.add("lsplate", "皖E"+carNo)
		.add("appkey", key)
		.build();
		
		Request request = new Request.Builder()
	    .url(url)
	    .post(body)
	    .build();
		
		Call call = httpClient.newCall(request);
		try {
		    Response response = call.execute();
		    System.out.println(response.body().string());
		} catch (IOException e) {
		    e.printStackTrace();
		    System.err.println(e);
		}
	}
	
}

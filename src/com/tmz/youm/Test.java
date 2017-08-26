package com.tmz.youm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;
import com.aliyuncs.push.model.v20160801.PushResponse;
import com.aliyuncs.utils.ParameterHelper;

public class Test {

	// The user agent
	protected final static String USER_AGENT = "Mozilla/5.0";

	// This object is used for sending the post request to Umeng
	protected static CloseableHttpClient httpCilent = HttpClients.createDefault();
	
	// The host
	protected static final String host = "http://msg.umeng.com";
	
	// The upload path
	protected static final String uploadPath = "/upload";
	
	// The post path
	protected static final String postPath = "/api/send";
	
	protected static final String AppKey  = "58fc53562ae85b54ee001331";
	protected static final String AppMasterSecret = "fhq5opflj4sxvdcap5zsblghcwxpuixt";
	
	public static void main(String[] args) throws Exception {
		String contents = "hha";
		JSONObject uploadJson = new JSONObject();
		uploadJson.put("appkey", AppKey);
		String timestamp = Integer.toString((int)(System.currentTimeMillis() / 1000));
		uploadJson.put("timestamp", timestamp);
		uploadJson.put("content", contents);
		// Construct the request
		String url = host + postPath;
		String postBody = uploadJson.toString();
		System.err.println(postBody);
		String sign = SecurityUtil.MD5Small("POST" + url + postBody + AppMasterSecret);
		url = url + "?sign=" + sign;
		httpSend(url, postBody);
        System.err.println(sign);
        return ;
	


	}
	
	public static void httpSend(String url,String postBody){
		
		HttpPost post = new HttpPost(url);
        post.setHeader("User-Agent", USER_AGENT);
        StringEntity se = new StringEntity(postBody, "UTF-8");
        post.setEntity(se);
		CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
//		HttpGet httpGet = new HttpGet(url);
		HttpPost httpPost = new HttpPost(url+"&postBody="+postBody);
		
		try {
			CloseableHttpResponse httpResponse = httpCilent.execute(httpPost);
			String srtResult = EntityUtils.toString(httpResponse.getEntity());
			System.err.println(srtResult);
			int status = httpResponse.getStatusLine().getStatusCode();
			
			if (status == 200) {
	            System.out.println("Notification sent successfully.");
	        } else {
	            System.out.println("Failed to send the notification!");
	        }
		} catch (IOException e) {
		    e.printStackTrace();
		}finally {
		    try {
		        httpCilent.close();//释放资源
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	}
}

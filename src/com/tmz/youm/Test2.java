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

public class Test2 {

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
	
	
	protected static final String AppKey2  = "58fc533bb27b0a12bf001b7d";
	protected static final String AppMasterSecret2 = "nchpglrqf7az3tnd7ppm9zkzw2c6p5wq";
	private static PushClient client = new PushClient();
	
	public static void main(String[] args) throws Exception {
		sendAndroidUnicast();
	}
	
	public static void sendIOSUnicast() throws Exception {
		IOSUnicast unicast = new IOSUnicast(AppKey,AppMasterSecret);
		// TODO Set your device token
		unicast.setDeviceToken("d2061eea164849edf5d1e1ee7373ba59cd425021e13229299273181c162ece40");
//		unicast.setAlert("好友申请");
		unicast.setAlert("创群通知");
		unicast.setBadge( 0);
		unicast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		// Set customized fields
		unicast.setTestMode();
//		unicast.setCustomizedField("notifycationType", "applyAddFriend");
//		unicast.setCustomizedField("addFriendType", "0");
		unicast.setCustomizedField("notifycationType", "createTribeSuccess");
		unicast.setCustomizedField("tribeId", "2273293696");
		client.send(unicast);
	}
	
	
	public static void sendAndroidUnicast() throws Exception {
		AndroidUnicast unicast = new AndroidUnicast(AppKey2,AppMasterSecret2);
		// TODO Set your device token
		unicast.setDeviceToken("AhU2BpmuNSK3287Lj5wqGiT-eP5tgCyH5zY94lDqoP4S");
		unicast.setTicker( "Android unicast ticker");
		unicast.setTitle(  "赶紧结束");
		unicast.setText(   "kamang");
		unicast.goCustomAfterOpen("");
		unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		unicast.setProductionMode();
		// Set customized fields
		unicast.setExtraField("test", "helloworld");
		client.send(unicast);
	}
}

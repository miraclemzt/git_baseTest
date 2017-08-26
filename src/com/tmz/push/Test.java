package com.tmz.push;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.push.model.v20160801.PushRequest;
import com.aliyuncs.push.model.v20160801.PushResponse;
import com.aliyuncs.utils.ParameterHelper;

public class Test {

	public static void main(String[] args) throws Exception {
		String AccessKeyId = "LTAIAbHnG1NXHVih";
		String  AppSecret = "3EyFrRdxzAi97Azg2dRHSZfQgdN96n";
		String appKey = "24591414";
		String TimeSt = PublicSignature.getISO8601Time();
		String SignatureNonce = PublicSignature.getUniqueNonce();
		String Target = "DEVICE";
		String TargetValue = "d2061eea164849edf5d1e1ee7373ba59cd425021e13229299273181c162ece40";
		String ApnsEnv = "DEV";
		String Body = "haha";
		String url = "http://cloudpush.aliyuncs.com/?Format=JSON"
				+ "&AccessKeyId="+AccessKeyId+"&Action=PushNoticeToiOS"
				+ "&SignatureMethod=HMAC-SHA1&RegionId=cn-hangzhou"
				+ "&SignatureNonce="+SignatureNonce
				+ "&SignatureVersion=1.0&Version=2016-08-01"
				+ "&Timestamp="+TimeSt+"&AppKey="+appKey
				+ "&Target="+Target+"&TargetValue="+TargetValue
				+"&ApnsEnv="+ApnsEnv+"&Body="+Body;
				
//		String TimeSt = PublicSignature.getISO8601Time();
////		TimeSt = URLEncoder.encode(TimeSt,"utf-8");
//		String url = "http://cloudpush.aliyuncs.com/?Format=JSON"
//		+ "&AccessKeyId="+AppKey
//		+ "&SignatureMethod=HMAC-SHA1&RegionId=cn-hangzhou"
//		+ "&SignatureVersion=1.0&Version=2015-08-27"
//		+ "&Timestamp="+TimeSt;
//		
////		HttpRequest.sendGet(url, "");
		System.err.println(PublicSignature.splitQueryString(url));
		Map<String,String> map = PublicSignature.splitQueryString(url);
		String a = PublicSignature.generate("GET", map, AppSecret);
//		
		url = url +"&Signature="+a;
//		System.err.println(HttpRequest.sendGet(url, ""));
		
	
CloseableHttpClient httpCilent = HttpClients.createDefault();//Creates CloseableHttpClient instance with default configuration.
HttpGet httpGet = new HttpGet(url);
//HttpPost httpPost = new HttpPost(url);

try {
	CloseableHttpResponse httpResponse = httpCilent.execute(httpGet);
	String srtResult = EntityUtils.toString(httpResponse.getEntity());
	System.err.println(srtResult);
} catch (IOException e) {
    e.printStackTrace();
}finally {
    try {
        httpCilent.close();//释放资源
    } catch (IOException e) {
        e.printStackTrace();
    }
}
//		System.err.println(UrlUtil.generateQueryString(map, false));
		
		
//		Map<String,String> dmap = new HashMap<String, String>();
//		dmap.put("",);
//		dmap.put("",);
//		dmap.put("",);
//		dmap.put("",);
//		dmap.put("",);
//		dmap.put("",);
//		dmap.put("",);
		//		System.err.println(a);
//		
//		System.err.println(Signature.newBuilder().method(The.HTTP.GET.method()).url(url).secret(The.API.secret()).build());
		
//		final String ACTION = url;
//		final String API_URL = The.API.build(ACTION);
//		System.err.println(Signature.newBuilder()
//		                .method(The.HTTP.GET.method())
//		                .url(API_URL)
//		                .secret(The.API.secret())
//		                .build()Signature=Q4jj5vC%2BNRtz294V%2BoIW7gfaJ6U%3D
//		                .compose());
//		String appKey = "23807704";
//        String accessKeyId = "LTAIAbHnG1NXHVih";
//        String accessKeySecret = "3EyFrRdxzAi97Azg2dRHSZfQgdN96n";
//        String deviceIds ="11029527";
//		 IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
//	        DefaultAcsClient client = new DefaultAcsClient(profile);
//	        PushRequest pushRequest = new PushRequest();
//	        
//	        // 推送目标
//	        pushRequest.setAppKey(Long.valueOf(appKey));
//	        pushRequest.setTarget("ACCOUNT"); //推送目标: DEVICE:按设备推送 ALIAS : 按别名推送 ACCOUNT:按帐号推送  TAG:按标签推送; ALL: 广播推送
//	        pushRequest.setTargetValue(deviceIds); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
////	        pushRequest.setTarget("ALL"); //推送目标: DEVICE:推送给设备; ACCOUNT:推送给指定帐号,TAG:推送给自定义标签; ALL: 推送给全部
////	        pushRequest.setTargetValue("ALL"); //根据Target来设定，如Target=DEVICE, 则对应的值为 设备id1,设备id2. 多个值使用逗号分隔.(帐号与设备有一次最多100个的限制)
//	        pushRequest.setPushType("NOTICE"); // 消息类型 MESSAGE NOTICE
//	        pushRequest.setDeviceType("iOS"); // 设备类型 ANDROID iOS ALL.
//	        // 推送配置
//	        pushRequest.setTitle("好好好"); // 消息的标题
//	        pushRequest.setBody("大家好"); // 消息的内容
//	        // 推送配置: iOS
//	        pushRequest.setIOSBadge(5); // iOS应用图标右上角角标
//	        pushRequest.setIOSMusic("default"); // iOS通知声音
//	        pushRequest.setIOSSubtitle("iOS10 subtitle");//iOS10通知副标题的内容
//	        pushRequest.setIOSNotificationCategory("iOS10 Notification Category");//指定iOS10通知Category
//	        pushRequest.setIOSMutableContent(true);//是否允许扩展iOS通知内容
//	        pushRequest.setIOSApnsEnv("DEV");//iOS的通知是通过APNs中心来发送的，需要填写对应的环境信息。"DEV" : 表示开发环境 "PRODUCT" : 表示生产环境
//	        pushRequest.setIOSRemind(true); // 消息推送时设备不在线（既与移动推送的服务端的长连接通道不通），则这条推送会做为通知，通过苹果的APNs通道送达一次。注意：离线消息转通知仅适用于生产环境
//	        pushRequest.setIOSRemindBody("iOSRemindBody");//iOS消息转通知时使用的iOS通知内容，仅当iOSApnsEnv=PRODUCT && iOSRemind为true时有效
//	        pushRequest.setIOSExtParameters("{\"_ENV_\":\"DEV\",\"k2\":\"v2\"}"); //通知的扩展属性(注意 : 该参数要以json map的格式传入,否则会解析出错)
//	        // 推送配置: Android
////	        pushRequest.setAndroidNotifyType("NONE");//通知的提醒方式 "VIBRATE" : 震动 "SOUND" : 声音 "BOTH" : 声音和震动 NONE : 静音
////	        pushRequest.setAndroidNotificationBarType(1);//通知栏自定义样式0-100
////	        pushRequest.setAndroidNotificationBarPriority(1);//通知栏自定义样式0-100
////	        pushRequest.setAndroidOpenType("URL"); //点击通知后动作 "APPLICATION" : 打开应用 "ACTIVITY" : 打开AndroidActivity "URL" : 打开URL "NONE" : 无跳转
////	        pushRequest.setAndroidOpenUrl("http://www.aliyun.com"); //Android收到推送后打开对应的url,仅当AndroidOpenType="URL"有效
////	        pushRequest.setAndroidActivity("com.alibaba.push2.demo.XiaoMiPushActivity"); // 设定通知打开的activity，仅当AndroidOpenType="Activity"有效
////	        pushRequest.setAndroidMusic("default"); // Android通知音乐
////	        pushRequest.setAndroidPopupActivity("com.ali.demo.PopupActivity");//设置该参数后启动辅助弹窗功能, 此处指定通知点击后跳转的Activity（辅助弹窗的前提条件：1. 集成第三方辅助通道；2. StoreOffline参数设为true）
////	        pushRequest.setAndroidPopupTitle("Popup Title");
////	        pushRequest.setAndroidPopupBody("Popup Body");
////	        pushRequest.setAndroidExtParameters("{\"k1\":\"android\",\"k2\":\"v2\"}"); //设定通知的扩展属性。(注意 : 该参数要以 json map 的格式传入,否则会解析出错)
//	        // 推送控制
//	        Date pushDate = new Date(System.currentTimeMillis()) ; // 30秒之间的时间点, 也可以设置成你指定固定时间
//	        String pushTime = ParameterHelper.getISO8601Time(pushDate);
//	        pushRequest.setPushTime(pushTime); // 延后推送。可选，如果不设置表示立即推送
//	        String expireTime = ParameterHelper.getISO8601Time(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)); // 12小时后消息失效, 不会再发送
//	        pushRequest.setExpireTime(expireTime);
//	        pushRequest.setStoreOffline(false); // 离线消息是否保存,若保存, 在推送时候，用户即使不在线，下一次上线则会收到
//	        PushResponse pushResponse = client.getAcsResponse(pushRequest);
//	        System.out.printf("RequestId: %s, MessageID: %s\n",
//	        pushResponse.getRequestId(), pushResponse.getMessageId());
//		
//		String url = "https://cloudpush.aliyuncs.com/";
//		String Format = "https://cloudpush.aliyuncs.com/";
//		String RegionId = "https://cloudpush.aliyuncs.com/";
//		String url = "https://cloudpush.aliyuncs.com/";
//		String url = "https://cloudpush.aliyuncs.com/";
//		String url = "https://cloudpush.aliyuncs.com/";
//		String url = "https://cloudpush.aliyuncs.com/";
//		String url = "https://cloudpush.aliyuncs.com/";
	}
}

package com.cbry.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;

public class UniversalTemplate {
	
	
    private static  Integer level=0;
    //当前层级
    private static Integer currentLevel=0;
    //上一层级
    private static  Integer upperLevel=0;

	public static void parseJsonString(String json) {
		 HashMap<String, Object> jsonMap = JSON.parseObject(json, new TypeReference<HashMap<String, Object>>() {});
	        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
	            parseJsonMap(entry);
	        }	
	}
	
	  public static void parseJsonMap(Map.Entry<String, Object> entry){

	        //如果是单个map继续遍历
	        if(entry.getValue() instanceof Map){
	        	HashMap<String, Object> jsonMap = JSON.parseObject(entry.getValue().toString(), new TypeReference<HashMap<String, Object>>() {
	            });
	            for (Map.Entry<String, Object> entry2 : jsonMap.entrySet()) {
	                parseJsonMap(entry2);
	            }
	        }

	        //如果是list就提取出来
	        if(entry.getValue() instanceof List && ((List) entry.getValue()).size()>0){
	        	System.err.println("list parse");
	            level++;
	            currentLevel=level;
	            List list = (List)entry.getValue();
	            for (int i = 0; i < list.size(); i++) {
	                parseJsonString(list.get(i).toString());
	            }
	            if(upperLevel<currentLevel){
	                level=level-1;
	            }
	        }

	        //如果是String就获取它的值
	        if(entry.getValue() instanceof String){
	            System.out.println("开始解析第"+level+"层数据key："+entry.getKey() + ",   value:" + entry.getValue());
	            if(upperLevel==currentLevel){
	                upperLevel=level;
	            }
	        }
	        //如果是空JSONArray,就返回它的值
	        if(entry.getValue() instanceof JSONArray && ((JSONArray) entry.getValue()).size()==0){
	            System.out.println("开始解析第"+level+"层数据key："+entry.getKey() + ",   value: []");
	            if(upperLevel==currentLevel){
	                upperLevel=level;
	            }
	        }
	    }
	
	public static void main(String[] args) {
		String str = "{\"goodsInfo\": [{\"activityInfo\": {\"actProtPer\": \"24\",\"activityType\": \"4\",\"eventId\": \"89230148\",\"eventName\": \"2015年06月12日全国小米4预存话费送手机136元档(24个月)[全渠道]\"},\"certInfo\": {\"certAddr\": \"中华人民共和国联通\",\"certName\": \"王松\",\"certNo\": \"110223197902******\",\"certType\": \"02\"},\"cityCode\": \"340\",\"firstMonBillMode\": \"套餐包外资费\",\"goodsId\": \"341712197840\",\"goodsName\": \"小米4 小米4白色\",\"goodsType\": \"普通业务\",\"mainFlag\": \"1\",\"numType\": \"4G\",\"phoneNum\": \"13047513547\",\"productId\": \"99999828\",\"productName\": \"4G全国136元套餐\",\"productType\": \"2C\",\"resourcesInfo\": {\"resourcesBrand\": \"小米\",\"resourcesCode\": \"null\",\"resourcesColor\": \"白色\",\"resourcesModel\": \"小米4\"},\"tmplType\": \"200000\",\"userTag\": \"1\"}],\"busChannel\": \"BC06\",\"orderFrom\": \"MOBILE\",\"orderId\": \"4018083022878865\",\"orderNo\": \"1257733595\",\"orderState\": \"B0\",\"orderTime\": \"20180830162631\",\"payInfo\": {\"couponMoney\": \"0\",\"incomeMoney\": \"1744000\",\"payState\": \"0\",\"payType\": \"02\",\"topayMoney\": \"1744000\",\"udpInfo\": []},\"postInfo\": {\"mobilePhone\": \"135****7875\",\"postAddr\": \"111111111111\",\"postCityCode\": \"320600\",\"postDistrictCode\": \"320602\",\"postProvinceCode\": \"320000\",\"receiverName\": \"测试\"},\"referrerInfo\": {\"referrerCode\": \"null\",\"referrerDepartId\": \"null\"},\"riskFlag\": \"null\",\"tendencyInfo\": {\"channelThree\": \"null\",\"channelTwo\": \"null\",\"latitude\": \"null\",\"longitude\": \"null\",\"channel\": \"null\"},\"termRefInfo\": [],\"tid\": \"null\"}";
		System.err.println(str);
		Map<String, String> map = new HashMap<>();	//匿名函数无法作用传参
		Map<String, String> map2 = new HashMap<>();
		map.put("key_1", "list_elemen_1");
		map2.put("key_2", "list_elemen_2");
		
		List<Map<String, String>> list = new ArrayList<>();
		list.add(map);
		list.add(map2);
		
		String jsonString = JSON.toJSONString(list);
		
		Map map3 = new HashMap<>();
		map3.put("data", list);
		jsonString = JSON.toJSONString(map3);
		System.out.println(jsonString);
		 HashMap<String, Object> jsonMap = JSON.parseObject(jsonString, new TypeReference<HashMap<String, Object>>() {});
	        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
	            System.out.println("key：" + entry.getKey() + "  " + entry.getValue().getClass() +  "： " + entry.getValue());
	        }	
		
		parseJsonString(jsonString);
	}
	
}

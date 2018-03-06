package testzifuchuan.Stringlength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import net.minidev.json.JSONValue;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
/**
 * JSON数据的转换
 * @author dys
 *
 */
public class testJson {
	public static void main(String args[]){
		//将数组转换为JSON：
//		String[] arr = {"asd","dfgd","asd","234"};
//		JSONArray jsonarray = JSONArray.fromObject(arr);
		//System.out.println("将数组转换为JSON..："+jsonarray);
		
		//把Map转换成json， 要使用jsonObject对象：
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 1001);
		map.put("userName", "张三");
		map.put("userSex", "男");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("userId", 1002);
		map2.put("userName", "张三2");
		map2.put("userSex", "男2");
		List<Map> list1 = new ArrayList<Map>();
		list1.add(map);
		list1.add(map2);
		//System.out.println(list1);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("total", 123);
		map3.put("rows", list1);
		JSONObject josns = new JSONObject();
		josns.put("errorCode", 0);
		josns.put("data", map3);
		System.out.println(josns.toString());
		JSONObject resultJson = (JSONObject) JSONValue.parse(josns.toString());
		//0 为成功返  回；非 0 为非成功返回
		int errorCode=(Integer)resultJson.get("errorCode");
		if (errorCode==0) {
			JSONObject Json=(JSONObject)resultJson.get("data");
			JSONArray jArray = (JSONArray) Json.get("row");
			for (Object object : jArray) {// 遍历返回数据 
				JSONObject jo = (JSONObject) JSONValue.parse(object.toString());
				//事件类型码 
				String eventType=(String) jo.get("eventType");
				//事件类型描述 
				String eventName=(String) jo.get("eventName");
				//门禁点 doorsyscode  
				String doorSyscode=(String) jo.get("doorSyscode");
				// 66305 设备防拆报警    66306 装置离线     198400 开门超时 
				if (eventType.equals("66305") ||eventType.equals("66306")||eventType.equals("198400")) {
					//报警
					//sendMessageByOutParamForAlarm(doorSyscode , "1", true,eventName);
				}else {
					//正常
					//sendMessageByOutParamForAlarm(doorSyscode , "0", true,null);
				}
				}
		}
		//JSONArray jsonarrays = JSONArray.fromObject(map3);
		//System.out.println("把Map转换成json..："+jsonarrays);
//		for (int i=0;i<jsonarrays.size();i++) {// 遍历返回数据
//			//JSONObject jo = (JSONObject) JSONValue.parse(object.toString());
//			JSONObject jo = JSONObject.fromObject(jsonarrays.get(i)); 
//			String Busnumber = jo.get("userId").toString();
//			System.out.println("json..："+Busnumber);
//			}
		//把List转换成JSON数据：

//		List<String> list = new ArrayList<String>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add("ccc");
//		JSONArray jsonArray = JSONArray.fromObject(list);
		//System.out.println("List转换成JSON数据..："+jsonArray);
		
		
	}
}


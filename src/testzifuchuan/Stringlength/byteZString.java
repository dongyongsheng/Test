package testzifuchuan.Stringlength;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minidev.json.JSONValue;
import net.sf.json.JSONObject;

import org.apache.commons.collections.map.HashedMap;

/**
 * byte数据转为string数据
 * @author dys
 *
 */


public class byteZString {

	public static void main(String[] args){
		String content = "Hello World.你好世界.";
		byte[] bs = content.getBytes();
		System.out.println(bs);
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = ByteBuffer.wrap(bs);
		CharBuffer cBuf = charset.decode(buf);
		String jsonString;
		try {
			jsonString = new String(cBuf.toString().getBytes("UTF-8"),"UTF-8");
			System.out.println(jsonString);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> jArray=new HashMap<String, Object>();
		jArray.put("DoorId", 11);
		jArray.put("Status", 0);
		jArray.put("Remark", "门正常闭合");
         //第一种：普遍使用，二次取值
		 System.out.println("通过Map.keySet遍历key和value：");
			for (Entry<String, Object> data:jArray.entrySet()) {
				String key =data.getKey();
				int DoorId=(int) jArray.get("DoorId");
				if (DoorId==11) {
					System.out.println("dddddd");
				}
				//System.out.println("key....:"+key+"    value....:"+jArray.get(key));
			}
		
	}
}

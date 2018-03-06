package testzifuchuan.Stringlength;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import util.ByteUtil;
import   util.DAPCUtil;
import testzifuchuan.Stringlength.CRC16;

import com.dahai.utils.DateUtil;


import util.MD5;


/**
 * ��ȡ��ƴ�Ӷ�̬SQl���
 * @author dys
 *
 */
public class testsb {
	private static boolean isFirst = false;
	
	public boolean isFirst() {
		return isFirst;
	}

	public void setFirst(boolean isFirst) {
		this.isFirst = isFirst;
	}

	final static byte[] CHECK_BYTE = { (byte) 0x68, (byte) 0x09, (byte) 0x09, (byte) 0x68, (byte) 0x01, (byte) 0x00, (byte) 0x02, (byte) 0x00, (byte) 0x00, (byte) 0x10, (byte) 0xFA, (byte) 0x01, (byte) 0x87, (byte) 0xe1, (byte) 0x16};
	//byte �� int ���໥ת��
		public static byte intToByte(int x) {
			return (byte) x;
		}
		
		public static int byteToInt(byte b) {
			//Java ���ǰ� byte �����з��������ǿ���ͨ������� 0xFF ���ж�������õ������޷�ֵ
			return b & 0xFF;
		}
		
		
	public static void main(String args[]){
		 SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date=new Date();
		String str=sdfs.format(date);
		
		System.out.println(str);
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        String strs=sdfs.format(zero);
        System.out.println(strs);
		
//        byte[] yy = { (byte) 0x82};
//        byte g3 = (byte) (yy[0] & 0x1);
//        System.out.println("上行.....:"+g3);
//        byte g1 = (byte) ((yy[0] & 0x2) >> 1);
//        System.out.println("下行.......:"+g1);
//        byte g2 = (byte) ((yy[0] & 0x4) >> 2);
//        System.out.println("停止.......:"+g2);
//        byte g4 = (byte) ((yy[0] & 0x8) >> 3);
//        System.out.println("锁梯.......:"+g4);
//        byte b6 = (byte) ((yy[0] & 0x64) >> 6);
//        System.out.println("故障.......:"+b6);
        //
        
        
        String receData="6000;0121;192.168.221.169;1;0;1;22;2;;2014-06-19 10:34:14;Office V1000;1#V100;前门;通行拒绝-未知的卡或密码;;2270247126;;;";
        String[] splitData=receData.split(";");
        System.out.println("splitData.....:"+splitData.length);
        String receData1="Sence_1";
        if (receData1.indexOf("Sence")!=-1) {
			System.out.println(999999);
		}
        
        byte[] yy = { (byte) 0x79};
        byte g3 = (byte) (yy[0] & 0x1);
        System.out.println("上行.....:"+g3);
        
        byte g1 = (byte) ((yy[0] & 0x2) >> 1);
        System.out.println("下行.......:"+g1);
        
        byte g2 = (byte) ((yy[0] & 0x4) >> 2);
        System.out.println("停止.......:"+g2);
        
        byte g4 = (byte) ((yy[0] & 0x8) >> 3);
        System.out.println("锁梯.......:"+g4);
        
        byte b6 = (byte) ((yy[0] & 0x64) >> 6);
        System.out.println("故障.......:"+b6);
        
     // 运行状态
        byte g5 = (byte) ((yy[0]& 0xff)>>6);
        System.out.println("故障.......:"+g5);
        
        String op="1_8";
        String  ll=op.substring(op.indexOf("_"),op.length());
        System.out.println(ll);
        
        
        List<String> list=new ArrayList<String>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator=list.iterator();
        while  (iterator.hasNext()) {
			String temp=iterator.next();
			if ("1".equals(temp)) {
				System.out.println("进入删除");
				iterator.remove();
			}		
		}
        System.out.println(list);
        
        
        String subString="1_3";
//        System.out.println(Integer.parseInt(subString));
        String[] outparamArray = subString.split("_");
        System.out.println("outparamArray.....:"+subString.substring(subString.indexOf("_")));
        
//		if (!isFirst) {
//			System.out.println(11111);
//			isFirst=true;
//		}
//		
//		
		if (!isFirst) {
			System.out.println(22222);
			isFirst=true;
		}else{
			System.out.println(444444);
			isFirst=false;
		}
//		
//		if (!isFirst) {
//			System.out.println(333333);
//			isFirst=true;
//		}else{
//			System.out.println(444444);
//			isFirst=false;
//		}
		
//		String zifu="00 00 29 8b 01 01 10 c7}}{16 68 0a 0a 68 01 00 00";
//		if (zifu.indexOf("}{")!=-1) {
//			System.out.println(zifu.substring(0,zifu.toString().indexOf("}{")+1));
//			System.out.println(zifu.substring(zifu.toString().indexOf("}{")+1));
//		}
		
		byte[] Buff = new byte[6];
//		int crc16 = CRC16.calcCrc16(Buff);
		String paramValue="1";
		byte[] writeBuf = { (byte) 0xFB, (byte) 0x06, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,(byte) 0x00, (byte) 0x00};
		writeBuf[0]=(byte) Integer.parseInt("22");
		writeBuf[2]=(byte) 0x00;
		if (paramValue.equalsIgnoreCase("1")) {
			writeBuf[3]=(byte) 0x02;
			writeBuf[5]=(byte) 0x01;
		}else {
			writeBuf[3]=(byte) 0x01;
			writeBuf[5]=(byte) 0x00;
		}
		for (int j = 0; j < 6; j++) {
			Buff[j] = writeBuf[j];
		}
		int crc16 = CRC16.calcCrc16(Buff);
		writeBuf[6]=(byte) ((crc16 & 0x00FF));
		writeBuf[7]=(byte) ((crc16 & 0xFF00) >> 8);
		System.out.println( DAPCUtil.toHex(writeBuf));
		//System.out.println(zifu.indexOf("68")+"-----"+zifu.indexOf("16"));
//		List<String> list=new ArrayList<String>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add("ccc");
//		StringBuilder sb = new StringBuilder("select COUNT(*) from ");
//		for (int i = 0; i < list.size(); i++) {
//			 if (list.get(i).equals("bbb")) {
//				 sb.append("em."+list.get(i)+",");
//			}else {
//				sb.append("vr."+list.get(i)+",");
//			}
//			
//		}
//		sb.setLength(sb.length()-1);
//		sb.append(" from JanETMonitor vr ");
//		System.out.println("ƴ�Ӻ��SQL���.....:"+sb);
//		String beginTime="2017-08-15"; 
//		String endTime="2017-08-16";
//		int i=getMJRecordCount(beginTime,endTime,list);
//		
//		String lf_sql;
//		lf_sql = "select  DISTINCT   tcb.RecordId, tcb.CarCode, tcb.InTm,tcb.OutTm,tcb.ChargeMoney,tcb.ChargeDt,tcb.ChargeType,";
//		lf_sql+= "tcu.Channleid,";
//		lf_sql+= "pbo.OperatorName "; 
//		lf_sql+="from Tc_Business tcb ";
//		lf_sql += "left join Tc_UserCrdtm tcu on tcb.CarCode=tcu.CarCode ";
//		lf_sql += "left join Tc_Channle tcc on tcu.DeviceSysId=tcc.DeviceSysId ";
//		lf_sql += "left join pb_Operator pbo on tcb.OperatorId=pbo.OperatorId  ";
//		//lf_sql += " where sessionstarttime>= '" + beginInDate + "' and sessionendtime <= '" + endInDate + "'";
//		System.out.println( lf_sql);
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//		Long times=new Long(System.currentTimeMillis()); 
//		long time=System.currentTimeMillis();
//		System.out.println(time);
		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("doorSyscodes", "d10f43b465d040e2b208192bb977885e");
//		map.put("pageNo", 1);
//		map.put("pageSize", 1);
// 	
//		 String httpUrl = "http://192.168.4.101:90/webapi/service/";//ip��˿�
//		 String method1 = "acs/getPlatAcsHistoryEventList";//����
//		 String appkey="9aee8c9e";//�û�ID
//		 String secret="73c16f0aa3bf4638a5202557b092e4e5";//��Կ
//			Long time=new Long(System.currentTimeMillis()); 
//			String data="doorSyscodes="+"d10f43b465d040e2b208192bb977885e"+"&pageNo="+1+"&pageSize="+1+"&"+"appkey="+appkey+"&"+"time="+time;
//			//token = MD5(���� URI + ������ + secret)��
//			String token=MD5.md5(httpUrl+method1+"?"+data+secret);
//			//ƴ�ӵķ���url��ַ
//			String url=httpUrl+method1+"?"+data+"&"+"token="+token;
//			System.out.println(time);
//			System.out.println(System.currentTimeMillis());
//			
//			
//			HttpClientUtil.doGet(httpUrl, method1, map, appkey, secret);
//			System.out.println(Integer.parseInt("ce", 16));
//			CHECK_BYTE[13] = getValue(CHECK_BYTE);
//			//CHECK_BYTE[13] = (byte) (CHECK_BYTE[10]&(byte) 0xFF);
//			System.out.println(byteToInt(CHECK_BYTE[13]));
//			
			//�õ�Calendar��ʵ��
//			Calendar calendar = Calendar.getInstance();
//			
//			
//			/**
//			 * ��ȡ �� ���� ����
//			 */
//			System.out.println(calendar.get(Calendar.YEAR));
//			//Ĭ�ϴ�0-11
//			System.out.println(calendar.get(Calendar.MONTH));
//			System.out.println(calendar.get(Calendar.DATE));
//			
//			
//			/**
//			 * ��ȡʱ����
//			 */
//			//24Сʱ��
//			System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
//			//12Сʱ��
//			//System.out.println(calendar.get(Calendar.HOUR));
//			System.out.println(calendar.get(Calendar.MINUTE));
//			System.out.println(calendar.get(Calendar.SECOND));
//			
//			/**
//			 * ��һ��ĵڼ���,����µĵڼ��죬���ܵĵڼ���
//			 */
//			System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
//			System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
//			System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
//			
//			/**
//			 * �õ�ʱ�䣬Fri Aug 19 14:33:03 CST 2016
//			 * �õ����ܵ�һ��
//			 * �õ�ʱ��ĺ�����
//			 */
//			System.out.println(calendar.getTime());
//			System.out.println(calendar.getFirstDayOfWeek());
//			System.out.println(calendar.getTimeInMillis())
//			
//		String buf="31 50 61";
//		System.out.println(ByteUtil.stringToHex(buf));
//		System.out.println(DAPCUtil.toHex(buf.getBytes()));
//		
//		byte[] buf1={(byte)0x31,(byte)0x50,(byte)0x61};
//		System.out.println(DAPCUtil.toHex(buf1));

//		   Map<String,String> map = new HashMap<String,String>();
//	        map.put("apple", "���ʵ�ƻ��"); // ���б����������
//	        map.put("computer", "���������ļ����"); // ���б����������
//	        map.put("book", "�ѻ���ɽ��ͼ��"); // ���б����������
//	        String key = "book";
//	        boolean contains = map.containsKey(key);
//	        boolean is=map.containsValue("�ѻ���ɽ��ͼ��");
//	        if (is) {
//	            System.out.println("��Map�����а�������" + key);
//	        } else {
//	            System.out.println("��Map�����в���������" + key);
//	        }
//
//	        Calendar cal = Calendar. getInstance ();
//			cal.add(Calendar. HOUR , -2) ; // ��ǰʱ��+ѹ��Сʱ��
//			String	endTime =  new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format(cal.getTime());
//			System.out.println(endTime);
//		byte[] writeBuff = { (byte) 0xFB, (byte) 0x06, (byte) 0xFC, (byte) 0xAA, (byte) 0xAA, (byte) 0xAA, (byte) 0x73,
//				(byte) 0x3F };	
//		String outparam = "12_1";
//		String changqin[]=outparam.split("_");
// 		//byte  buf1=(byte)0x00;
////		byte  buf2=(byte)0x80;
//		int data=Integer.parseInt(changqin[0]);
//		//buf1=(byte) 0x00;
//		writeBuff[0]=(byte) data;
////		buf2=(byte) (buf1&0xff);
// 		//System.out.println(byteToInt(buf1));
// 		System.out.println(DAPCUtil.toHex(writeBuff));
//		System.out.println(byteToInt(buf2));
//			
//		Date date = new Date();
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(date);
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
//		String endInDate = format.format(cal.getTime());
//		cal.add(Calendar.MINUTE, -10);// ǰ10����
//		String beginInDate = format.format(cal.getTime());
//		System.out.println(endInDate+"      "+beginInDate);
//		
//	  String	outParam = String.format("%01d", Integer.parseInt("87",16));
//	  System.out.println(outParam);
// 		try {
// 			List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
// 			String SubGroupID1="2_017";
//			String[] datas=SubGroupID1.split("_");
//			String PARAM_ALARM = "2_";
//			//List<Map<String,Object>> list=jdbcTemplatehunan.queryForList(sql);
//			if(null!=list && !list.isEmpty()){
//				String outParam="";
//				for (Map<String, Object> maps : list) {
//					outParam=PARAM_ALARM+""+maps.get("SubGroupID1");
//					//logger.info("����outparamΪ��.....:"+outParam);
////					if(outParamMap.get(outParam)!=null){
////						sendMessageByOutParam(outParam, "1",false);
////					}
//				}
//			}else {
//				System.out.println(PARAM_ALARM+datas[1]+"  �������¹�0  ");
//				//sendMessageByOutParam(PARAM_ALARM+datas[1], "0",false);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
 		
// 		byte[] Buff = { (byte) 0xFB, (byte) 0x06, (byte) 0x0E, (byte) 0x00, (byte) 0x00, (byte) 0xAA};
// 		byte[] Buffs = { (byte) 0xFB, (byte) 0x06, (byte) 0x03, (byte) 0xAA, (byte) 0xA0, (byte) 0x00, (byte) 0xA0, (byte) 0x00};
//// 		int crc16 =147;
//// 		System.out.println(crc16);
//// 		Buffs[6]=(byte) ((crc16 & 0x00FF));
//// 		Buffs[7]=(byte) ((crc16 & 0xFF00) >> 8);
//// 		System.out.println("Buff:"+DAPCUtil.toHex(Buffs));
// 		byte[] temp = new byte[6];
// 		for (int j = 0; j < 6; j++) {
//			temp[j] = Buffs[j];
//		}
// 		System.out.println(DAPCUtil.toHex(temp));
		
//		String paramValue="1";
//		String outparam="001";
//		int[] cValue = new int[1];
//		cValue[0] = Integer.parseInt(paramValue);
//		int dataAddress=Integer.parseInt(outparam);
//		System.out.println(cValue[0]+"    "+dataAddress);
//		System.out.println(outparam.substring(0));
//		System.out.println(outparam.subSequence(0, 1));
//		Map<String, String> deviceValueMap = new HashMap<String, String>();
//		deviceValueMap.put("94_", "94_");
//		String outparam = "94_";
//		if (deviceValueMap.get("94_").equals("94_")) {
//			System.out.println(outparam.split("_").length);
//		}
		
//		String dt=outparam.substring(0, outparam.indexOf("_"));
//		System.out.println("dt��������"+dt);
//		String intData="";
//		String[] shuju=outparam.split("_");			
//		String datas=(String) shuju[1].subSequence(0, 1);
//		System.out.println("datas"+datas);
//		
//		if (datas.equalsIgnoreCase("0")) {
//			 intData=shuju[1].substring(1);
//		}else {
//			  intData=shuju[1].substring(0);
//		}
//		System.out.println("intData"+intData);
//		if (shuju[0].equalsIgnoreCase("94")) {
//			System.out.println("outparam"+outparam);
//		}
//		
		
//		int [] arr=new int[]{8,2,1,0,3};
//		int [] index=new int[]{2,0,3,2,4,0,1,3,2,3,3};
//		String telString="";
//		for (int i:index) {
//			telString+=arr[i];
//			
//		}
//		System.out.println(telString);
		//java截取字符串后n位 
//		String str = "823830303130343933303b313130393131303f31343031373283";
//		int n = 2;
//		System.out.println("java截取字符前2位 ："+str.substring(0,52));
// 		System.out.println("java截取字符串后2位  :"+str.substring(2));
//		
//		
//		Map<String, String> outParamMaps = new HashMap<String, String>();
//		outParamMaps.put("formula1", "33c1ab9196a54724856b357b0e24ca96");
//		outParamMaps.put("formula2", "d14582b8e3d549728d1521113c527630");
//		outParamMaps.put("formula3", "9f5763bfedb842f68bbd467403402b54");
//		outParamMaps.put("formula4", "35907aa307184dc095a9b54410833fd7");
//		outParamMaps.put("formula5", "3957ee0e3b6d48c29d8b880cd349b03b");
//		outParamMaps.put("formula6", "15a1b8be6ee0430da12875c57f40214e");
//		outParamMaps.put("formula7", "2f05bfbfec844f4bbae1c92c803b823d");
//		outParamMaps.put("formula8", "5116cfc5a9fb4742b4321f73f4e0e82a");
//		
//		for (String outParamKey : outParamMaps.keySet()) {
//			String outString=outParamMaps.get(outParamKey);
//			System.out.println(outString);
//			
//		}
//		int modbusAddr=4001;
//		int dataSize=2;
//		for (int i = 0; i < 3; i = i + 4) {
//			System.out.println((modbusAddr + i * 2 / dataSize+1));
//		}
//		byte[] buff = {(byte)0x82, (byte) 0x38, (byte) 0x30, (byte) 0x30, (byte) 0x31, (byte) 0x30, (byte) 0x34, (byte) 0x39, (byte) 0x33, (byte) 0x30, (byte) 0x3b, (byte) 0x31, (byte) 0x31, (byte) 0x30, (byte) 0x39, (byte) 0x31, (byte) 0x31, (byte) 0x30, (byte) 0x3f, (byte) 0x31, (byte) 0x34, (byte) 0x30, (byte) 0x31, (byte) 0x37, (byte) 0x32, (byte) 0x83
//};
//		System.out.println("接收到的数据1.....："+DAPCUtil.toHex(buff));
//		System.out.println("接收到的数据2.....："+ByteUtil.convertByteArrayToHexStr(buff));
//		
//		String formula = "14_5";
//		String[] data=formula.split("_");
//		System.out.println("data...."+data.length);
		String d1="1e";
		int q=Integer.parseInt(d1, 16);
		System.out.println("q:"+q);
		
	}
	public static int calculateCRC16(byte[] data) {
		// ����һint���͵�16���Ʊ���
		int crc = 0xFFFF;
		int crctemp = 0;
		for (int i = 0; i < data.length; i++) {
			crctemp = (0xFF00) | ((int) (data[i] ^ (crc & 0x00FF))); // �����8λ
			crc = crctemp & (crc | 0x00FF);
			for (int j = 0; j < 8; j++) {
				if ((crc & 0x0001) == 1) {
					crc = crc >> 1;
					crc = crc ^ 0xA001;
				} else if ((crc & 0x0001) == 0) {
					crc = crc >> 1;
				}
			}
		}
		return crc;
	}
	/**
	 * У���
	 */
	private static byte getValue(byte[] buff) {
		byte sum = (byte) (buff[4] + buff[5] + buff[6] + buff[7] + buff[8] + buff[9] + buff[10]+buff[11] + buff[12]);
		return (byte) (sum );

	}

	public static int getMJRecordCount(String beginTime, String endTime,List<String> list) {
		StringBuilder sb = new StringBuilder("select COUNT(*) from ");
		sb.append("( Select row_number() over (ORDER BY vr.WipeDate desc, vr.ID asc) AS RowNumber, ");
//		sb.append("vr.ID  , vr.janJDid, vr.WipeDate, ");
		if (list.size()>0&&list!=null){
			 for(int i=0;i<list.size();i++){
				 System.out.println(list.get(i));
				 sb.append("vr."+list.get(i)+",");
			 }
			 sb.setLength(sb.length()-1);
		}
		sb.append(" em.EmpName, ");
		sb.append("li.JDName ");
		sb.append("from JanETMonitor vr ");
		sb.append("join Employee em on vr.JanEmpCardNo = em.CardNo ");
		sb.append("join JanitorData li on vr.janJDid = li.JDID ");
		sb.append("where 1=1 ");
		if (null != beginTime) {
			sb.append("and vr.WipeDate >= '").append(beginTime).append("' ");
		}
		if (null != endTime) {
			sb.append("and vr.WipeDate <= '").append(endTime).append("' ");
		}
		sb.append(") A ");
		String sql = sb.toString();
		System.out.println(sql);
		//int count = subJdbcTemplate.queryForInt(sb.toString());
		int count=0;
		return count;
	}
}

package testzifuchuan.Stringlength;

import java.util.ArrayList;
import java.util.List;

public class testsql {

	public static void main(String[] args) {
//		String beginTime="2016-10-11 10:00:00";
//		String endTime="2017-11-12 11:00:00";
//		testsql tt=new testsql();
////		tt.getHYrecord(beginTime, endTime);
//		String param="CP.JSZJWY.139.1390001.2";
//		String [] gcid=param.split("\\.");
//		String cbdEnName=gcid[1];
//		System.out.println(cbdEnName);
		String gg="B115,B116,B117";
		if (gg.indexOf(",")!=-1) {
			String[] cc=gg.split(",");
			List<String> list=new ArrayList<String>();
				for (String data:cc) {
					list.add(data);
				}
			if (list.contains("B115")) {
				System.out.println(11111);
			}
		}
//		String[] cc=gg.split(",");
//		if(gg.indexOf("B11")!=-1){
//			   System.out.println("包含");
//			  }else{
//			   System.out.println("不包含");
//			  }
	}
	public String getHYrecord(String beginTime, String endTime){
		String result = "";
		StringBuilder sb = new StringBuilder(" select * from ");
		sb.append("( SELECT  count(opObjectName) as total ");
		sb.append(", gcID ");
		sb.append(", userID ");
		sb.append(", opObjectName ");
		sb.append("from sysLog ");
		sb.append("where 1=1 ");
		if (null != beginTime) {
			sb.append("and logTime >= '").append(beginTime).append("' ");
		}
		if (null != endTime) {
			sb.append("and logTime <= '").append(endTime).append("' ");
		}
		sb.append("group by gcID,userID,opObjectName) as data ");
		sb.append(" where  data.gcID in ");
		sb.append(" ( 'BJFKWD' ,'SCCDSLWD' ,'SCCDQYWD' ,'BJHFWD' ,'BJHFWD' ,'GDQYWD') ");
		sb.append(" order by data.total,data.gcID ");
		String sql = sb.toString();
		System.out.println(sql);

		return result;

}
}

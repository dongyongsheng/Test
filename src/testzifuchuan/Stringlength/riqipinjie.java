package testzifuchuan.Stringlength;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 计算两个日期之间的间隔日期
 * @author dys
 *
 */
public class riqipinjie {
	
	public static void main(String[] args) throws Exception {
	String beginTime="2017-09-28 10:09";
	 String endTime="2017-10-16 10:09";
	 String empID="";
	 String empName="";
	 Integer beginRow=1;
	 Integer endRow=20;
   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
   SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   Date start =sdfs.parse(beginTime);
   System.out.println("start......."+start);
   Date end = sdfs.parse(endTime);
   System.out.println("end......."+end);
   List<Date> lists = dateSplit(start, end);	
   StringBuilder sb = new StringBuilder();
   if (!lists.isEmpty()) {
       for (Date date : lists) {
       	String datas=sdf.format(date); 
       	System.out.println("间隔日期为...:"+datas);
       	sb.append("select EmpID,EmpName,CardNo,WipeDate from ");
   		sb.append("( Select row_number() over (ORDER BY etm.WipeDate desc, em.EmpID asc) AS RowNumber, ");
   		sb.append(" * ");
   		sb.append("from ");
   		sb.append("ACS.dbo.ACS_EventLog_"+datas);
   		sb.append(" etm ");
   		//sb.append("join Employee em on em.CardNo = etm.JanEmpCardNo ");
   		sb.append("where 1=1 ");
   		sb.append("and UserID is not null ");
   		if (null != beginTime) {
   			sb.append("and etm.LogDate >= '").append(beginTime).append("' ");
   		}
   		if (null != endTime) {
   			sb.append("and etm.LogDate <= '").append(endTime).append("' ");
   		}
   		if (null != empID) {
   			sb.append("and etm.UserID like '%").append(empID).append("%' ");
   		}
   		if (null != empName) {
   			sb.append("and etm.UserName like '%").append(empName).append("%' ");
   		}
   		sb.append(") A where 1=1 ");
   		if (null != beginRow && beginRow > -1) {
   			sb.append("and RowNumber >= ").append(beginRow).append(" ");
   		}
   		if (null != endRow && endRow > -1) {
   			sb.append("and RowNumber <= ").append(endRow);
   		}
   		
   		sb.append(" union ");     		
         
       }	
   }
       sb.setLength(sb.length()-7);
     //  System.out.println(sb.toString());
}

	private static List<Date> dateSplit(Date startDate, Date endDate)
	        throws Exception {
	    if (!startDate.before(endDate))
	        throw new Exception("开始时间应该在结束时间之后");
	    Long spi = endDate.getTime() - startDate.getTime();
	    Long step = spi / (24 * 60 * 60 * 1000);// 相隔天数

	    List<Date> dateList = new ArrayList<Date>();
	    dateList.add(endDate);
	    for (int i = 1; i <= step; i++) {
	        dateList.add(new Date(dateList.get(i - 1).getTime()
	                - (24 * 60 * 60 * 1000)));// 比上一天减一
	    }
	    return dateList;
	}

}


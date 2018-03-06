package testzifuchuan.Stringlength;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.math.BigDecimal;

/**
 * 查询两个日期之间的间隔天数
 * @author dys
 *
 */
public class testRQ {

		public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sf=new SimpleDateFormat("yyyyMM");
//		System.err.println("请输入查询月份");
//		Scanner sc=new Scanner(System.in);//键盘输入
//		String dateValue=sc.next();
//		Date date=sf.parse(dateValue);
//		System.err.println(sf.format(date));
//		if(sc!=null){
//		sc.close();
//		}
//		getDate(date);
		
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		 Date d1=sdf.parse("2017-08-08 10:10:10"); 
//		 Date d2=sdf.parse("2017-08-15 00:00:00"); 
//		 String d3=sdf.format(new Date());
//		 System.out.println("计算两个日期之间相差的天数:"+daysBetween(d1,d2));
//		 System.out.println("字符串的日期格式的计算相差天数:"+daysBetween("2017-08-08 10:10:10",d3));
		    String res;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date datess=new Date();
			Long time=new Long(System.currentTimeMillis());  
			String d = simpleDateFormat.format(time);
			 String beginTimess="2016-06-01 10:09:00";
			 Date starts = simpleDateFormat.parse(beginTimess);
//	        Date dates = simpleDateFormat.parse(datess);
//	        long ts = dates.getTime();
//	        res = String.valueOf(ts);
	        System.out.println("当前时间戳....："+d+"   时间....:"+starts);
	        //计算4的2次方
	        int i=(int) Math.pow(4, 2);
	        System.out.println(i);
	        //String转数组
	        String sysString="11223344556677";
	        char [] dd=sysString.toCharArray();
	        System.out.println(dd[2]);
	        
	        float a=10,b=23;
	        DecimalFormat df = new DecimalFormat("#.00");
	        System.out.println(df.format(Float.valueOf((a/b))*100)+"%");
			
			 try {
					 String beginTime="2016-06-01 10:09:00";
					 String endTime="2017-08-21 10:09:00";
					 String empID="";
					 String empName="";
					 Integer beginRow=1;
					 Integer endRow=20;
			        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			        Date start = sdf.parse(beginTime);
			        Date end = sdf.parse(endTime);
			        List<Date> lists = dateSplit(start, end);	
			        StringBuilder sb = new StringBuilder();
			        if (!lists.isEmpty()) {
			            for (Date date : lists) {
			            	String datas=sdf.format(date); 
			            	String beginTimes=sdf.format(beginTime); 
			            	String endTimes=sdf.format(endTime); 
			            	sb.append("select EmpID,EmpName,CardNo,WipeDate from ");
			        		sb.append("( Select row_number() over (ORDER BY etm.WipeDate desc, em.EmpID asc) AS RowNumber, ");
			        		sb.append(" * ");
			        		sb.append("from ");
			        		sb.append(" KQ_JanETMonitor");
			        		sb.append(" etm ");
			        		sb.append("join KQ_Employee em on em.CardNo = etm.JanEmpCardNo ");
			        		sb.append("where 1=1 ");
			        		if (null != beginTime) {
			        			sb.append("and etm.WipeDate >= '").append(beginTimes).append("' ");
			        		}
			        		if (null != endTime) {
			        			sb.append("and etm.WipeDate <= '").append(endTimes).append("' ");
			        		}
			        		if (null != empID) {
			        			sb.append("and em.EmpID like '%").append(empID).append("%' ");
			        		}
			        		if (null != empName) {
			        			sb.append("and em.EmpName like '%").append(empName).append("%' ");
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
			            System.out.println(sb.toString());
			    } catch (Exception e) {
			    }

			
				
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

		    /**  
		     * 计算两个日期之间相差的天数  
		     * @param smdate 较小的时间 
		     * @param bdate  较大的时间 
		     * @return 相差天数 
		     * @throws ParseException  
		     */
		public static int daysBetween(Date smdate,Date bdate) throws ParseException{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Integer.parseInt(String.valueOf(between_days));
}
	
		
		/** 
		*字符串的日期格式的计算 
		*/
		public static int daysBetween(String smdate,String bdate) throws ParseException{
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate)); 
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Integer.parseInt(String.valueOf(between_days));
		} 

		public static void getDate(Date nowDate){
		Calendar cad=Calendar.getInstance();
		cad.setTime(nowDate);
		int day_month=cad.getActualMaximum(Calendar.DAY_OF_MONTH); //获取当月天数
		int[][] array=new int[6][7];
		System.err.println("天数长度："+day_month);
		for(int i=0;i<=day_month-1;i++){//循环遍历每天
		cad.set(Calendar.DAY_OF_MONTH,i+1);
		int week_month=cad.get(Calendar.WEEK_OF_MONTH);//获取改天在本月的第几个星期，也就是第几行
		int now_day_month=cad.get(Calendar.DAY_OF_WEEK);//获取该天在本星期的第几天  ，也就是第几列
		array[week_month-1][now_day_month-1]=i+1;//将改天存放到二位数组中
		}
	
		for(int i=0;i<=array.length-1;i++){

			for(int j=0;j<=array[i].length-1;j++){
				if(array[i][j]!=0){//没有存放的数字默认为0，过滤
					
					System.err.print(array[i][j]);
				}
				System.err.print("\t");
				if((j+1)%7==0){
				
					System.err.print(""); 
					
				}
			}
		}
		}

}

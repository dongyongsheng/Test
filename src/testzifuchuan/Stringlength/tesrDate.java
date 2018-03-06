package testzifuchuan.Stringlength;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class tesrDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
		String endInDate = format.format(cal.getTime());
		cal.add(Calendar.MINUTE, -300);// «∞12∑÷÷”
		String beginInDate = format.format(cal.getTime());
		System.out.println("beginInDate....:"+beginInDate);
		System.out.println("endInDate....:"+endInDate);
	}

}

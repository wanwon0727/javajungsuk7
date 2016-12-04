package chapter10.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatPractice2 {

	public static void main(String[] args) {
		// Calendar와 Date간의 변환은 다음과 같이 한다.
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 9, 3); // 2005년 10월 3일  Month는 0 ~ 11의 범위를 갖는다.
		
		Date day = cal.getTime();
		
		//Date day = new Date();
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yy-MM-dd E요일");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(day));
		System.out.println(sdf2.format(day));
		System.out.println(sdf3.format(day));
		System.out.println(sdf4.format(day));
		
		DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2015년 11월 23일");
			System.out.println(df2.format(d));	
		} catch(Exception e) { }
	}
}

package chapter10.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormatPractice2 {

	public static void main(String[] args) {
		// Calendar�� Date���� ��ȯ�� ������ ���� �Ѵ�.
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 9, 3); // 2005�� 10�� 3��  Month�� 0 ~ 11�� ������ ���´�.
		
		Date day = cal.getTime();
		
		//Date day = new Date();
		SimpleDateFormat sdf1, sdf2, sdf3, sdf4;
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yy-MM-dd E����");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
		
		System.out.println(sdf1.format(day));
		System.out.println(sdf2.format(day));
		System.out.println(sdf3.format(day));
		System.out.println(sdf4.format(day));
		
		DateFormat df = new SimpleDateFormat("yyyy�� MM�� dd��");
		DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			Date d = df.parse("2015�� 11�� 23��");
			System.out.println(df2.format(d));	
		} catch(Exception e) { }
	}
}

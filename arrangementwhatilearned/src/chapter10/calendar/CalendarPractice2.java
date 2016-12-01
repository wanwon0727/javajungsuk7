package chapter10.calendar;

import java.util.Calendar;

public class CalendarPractice2 {

	public static void main(String[] args) {
		// 요일은 1부터 시작하기 때문에, DAY_OF_WEEK[0]은 비워두었다.
		final String[] DAY_OF_WEEK={"","일","월","화","수","목","금","토"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		//month의 경우 0부터 시작하기 때문에 8월인 경우, 7로 지정해야 한다.
		// date1.set(2016, Calendar.August, 15 ); 와 같이 할 수도 있다.
		date1.set(2016, 7,15 );// 2016년 8월 15일로 날짤르 설정한다.
		System.out.println("date1은 "+ toString(date1)
		+ DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일이고");
		System.out.println("date2는"+ toString(date2) 
		+ DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)]+"요일이다." );
		// 두 날짜간의 차이를 얻으려면, getTimeInMillis() 천분의 일초 단위로 변환해야 한다.
		long difference = (date2.getTimeInMillis()-date1.getTimeInMillis())/1000;
		System.out.println("그 날(date1)부터 지금(date2)까지 "+ difference +"초가 지났습니다.");
	    System.out.println("일(day)로 계산하면 "+ difference/(60*60*24)+ "일 입니다");
	    // 1일= 24*60*60
	}

	private static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년  "+(date.get(Calendar.MONTH)+1)+"월 "+ date.get(Calendar.DATE)+"일 ";
	}

}

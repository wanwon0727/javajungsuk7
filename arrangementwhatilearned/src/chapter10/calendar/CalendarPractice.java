package chapter10.calendar;

import java.util.*;

public class CalendarPractice {

	public static void main(String[] args) {
		// Calendar는 추상 클래스이기 때문에 직접 객체를 생성할 수 없고, 메서드를 통해서 완전히 구현된 클래스의 인스턴스를 얻어야 한다.
		
		
		// Calendar를 Date로 변환
		/*Calendar cal = Calendar.getInstance();
		Date d = new Date(ca.getTimeInMillis());
		System.out.println(d);*/
		
		// Date를 Calendar 로 변환
		/*Date d = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		System.out.println(cal);*/
		
		// 기본적으로 현재날짜와 시간으로 설정된다.
		Calendar today = Calendar.getInstance();
		System.out.println("이 해의 년도 : "+ today.get(Calendar.YEAR));
		System.out.println("월 (0~11, 0:1월) : "+ today.get(Calendar.MONTH));
		// Calendar의 월은 0부터 시작 하므로 결과값에서 1을 더한 월이 해당 월이 된다.
		System.out.println("이 해의 몇 째 주 : "+ today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주 : "+ today.get(Calendar.WEEK_OF_MONTH));
		
		// Date 와 Day_Of_Month 는 같다.
		System.out.println("이 달의 몇일 : "+ today.get(Calendar.DATE));
		System.out.println("이 달의 몇일 : "+ today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 몇일 : "+ today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일 (1~7, 1:일요일) : " + today.get(Calendar.DAY_OF_WEEK)); // 일요일부터 시작. 1~7까지
		System.out.println("요일 (1~7, 1:일요일) : "+ today.get(Calendar.DAY_OF_WEEK_IN_MONTH)); 
		//위의 요일이  만약 일요일이라면 이번달의 몇번째 일요일인지.  해당 요일이 그달에 몇번째 해당요일인지.
		System.out.println("오전_오후 ( 0:오전, 1:오후) : "+ today.get(Calendar.AM_PM));
		System.out.println("시간(0~11) : "+ today.get(Calendar.HOUR));
		System.out.println("시간(0~23) : "+ today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59) : "+ today.get(Calendar.MINUTE));
		System.out.println("초(0~59) : "+ today.get(Calendar.SECOND));
		System.out.println("1000분의 1 초 (0~999) : "+ today.get(Calendar.MILLISECOND));
		// 천분의 1초를 시간으로 표시하기 위해 3600000 으로 나누었다. (1시간 = 60*60초)
		System.out.println("TimeZone(-12 ~ +12 ) : "+ (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
		System.out.println("이 달의 마지막 날 : "+ today.getActualMaximum(Calendar.DATE));
 
	}

}

package chapter10.calendar;

import java.util.Calendar;

public class CalendarPractice4 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		
		date.set(2015, 7,31); // 2015년 8월 31일로 설정
		
		System.out.println(toString(date));
		System.out.println("= 1일 후 =");
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));
		
		System.out.println("= 6달전 =");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("=31일 후 (roll) =");
		date.roll(Calendar.DATE, 31);
		System.out.println(toString(date));
		System.out.println("=31일 후 (add) =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
		
		// roll 과 add는 지정한 필드의 값을 증가 또는 감소시킨다는 기능은 똑같지만
		// add 메서드로 날짜필드(Calendar.DATE) 값을 31일 증가시킬 경우 다음달로 넘어가므로 월 필드(Calendar.Month)의 값도 1 증가하지만
		// roll 메서드로 날짜필드 값을 31일 증가시킬 경우 월필드의 값은 변하지 않고 일 필드의 값만 바뀌게 된다.
		// 단, 한가지 예외가 있는데 일필드(Calendar.DATE)가 말일(end of month) 일 때, 
		// roll 메서드를 이용해서 월필드(Calendar.Month)를 변경하면 일필드(Calendar.DATE)에 영향을 미칠 수 있다.
		Calendar date2 = Calendar.getInstance();
		date2.set(2015, 0,31); // 2015년 1월 31일로 설정
		System.out.println(toString(date2));
		date2.roll(Calendar.MONTH, 1);
		System.out.println(toString(date2));
		// add 메서드도 같은경우에 마찬가지로 해당월 말일로 자동변경된다. 

	}

	private static String toString(Calendar date) {
		 
		return date.get(Calendar.YEAR)+"년 " + (date.get(Calendar.MONTH)+1)+"월 "+ date.get(Calendar.DATE)+"일";
	}

}

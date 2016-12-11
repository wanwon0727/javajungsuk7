package chapter10.format;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class JavaTimePackage4 {
	public static void main(String[] args){
		// Period 와 Duration
		// 날짜 - 날짜  = Period,   시간 - 시간 = Duration
		// between ()
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		Period pe = Period.between(date1, date2);
		
		LocalTime time1 = LocalTime.of(00, 00, 00);
		LocalTime time2 = LocalTime.of(12, 34, 56); // 12시 34분 56초
		
		Duration du = Duration.between(time1, time2);
		
		long year = pe.get(ChronoUnit.YEARS); // int getYears();
		long month = pe.get(ChronoUnit.MONTHS); // int getMonths();
		long day = pe.get(ChronoUnit.DAYS); // int getDays();
		
		long sec = du.get(ChronoUnit.SECONDS); // long getSeconds();
		int nano = (int) du.get(ChronoUnit.NANOS); // int getNano();
		// 실망스럽게도 Duration에는 Chrono.SECONDS와 Chrono.NANOS밖에 사용할 수 없다는 결과가 나왔다.
		// 좀 불편하지만 어쩔 수 없이 다음과 같이 직접 계산해 보았다.
		long hour2 = du.getSeconds()/3600;
		long min2 = (du.getSeconds()- hour2*3600)/60;
		long sec2 = (du.getSeconds()- hour2*3600 - min2*60) % 60;
		int nano2 = du.getNano();
		// 이 방법을 좀 더 안전하고 간단히 하기 위해서는 Duration을 LocalTime으로 변환한 다음에, LocalTime이 
		// 가지고 있는 get메서드를 사용하면 더 간단하다.
		
		LocalTime tmpTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		
		int hour3 = tmpTime.getHour();
		int min3 = tmpTime.getMinute();
		int sec3 = tmpTime.getSecond();
		int nano3 = du.getNano();
		
		// between() 과 until()
		// until() 과 between()은 거의 같은 일을 한다. between() 은 static메서드이고,
		// until()은 인스턴스 메서드라는 차이가 있다.
		/*Period pe2 = Period.between(today, myBirthDay);
		Period pe2 = today.until(myBirthDay);
		long dday = today.until(myBirthDay, ChronoUnit.DAYS);*/
		// Period 는 년월일을 분리해서 저장하기 때문에, D-day를 구하려는 경우에는 두 개의 매개변수를 
		// 받는 unit()을 사용하는 것이 낫다. 날짜가 아닌 시간에도 until()을 사용할 수 있지만, Duration을 반환하는until은 없다.
		// 사칙연산, 비교연산, 기타 메서드
		// plus(), minus() 외에 곱셈과 나눗셈을 위한 메서드도 있다.
		// pe = pe.minusYears(1).multipliedBy(2);  1년을 빼고, 2배를 곱한다.
		// du = du.plusHours(1).dividedBy(60); 1시간을 더하고 60으로 나눈다.
		// Period에 나눗셈을 위한 메서드가 없는데, Period는 날짜의 기간을 표현하기 위한 것이므로 나눗셈을 위한
		// 메서드가 별로 유용하지 않기 때문에 넣지 않은 것이다.
		// 그리고 음수인지 확인하는 isNegative()와 0인지 확인하는 isZero()가 있다. 두 날짜 또는 시간을 비교할 때,
		// 사용하면 어느쪽이 앞인지 또는 같은지 알아낼 수 있다.
		boolean sameDate = Period.between(date1, date2).isZero();
		boolean isBefore = Duration.between(time1, time2).isNegative();
	
		du = du.abs();// 부호 없애기
		if(du.isNegative()) du = du.negated();// 부호 반대로 바꾸기
	
		pe = Period.of(1, 13, 32).normalized(); // 1년 13개월 32일 -> 2년 1개월 32일;
		
		LocalDate date11 = LocalDate.of(2015, 11, 28);
		LocalDate date22 = LocalDate.of(2015, 11, 29);
		
		long period = date2.toEpochDay() - date1.toEpochDay(); // 1
	}
}

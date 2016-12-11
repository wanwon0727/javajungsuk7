package chapter10.format;

import java.time.*;
import java.time.temporal.*;
import java.time.temporal.Temporal;
import static java.time.temporal.TemporalAdjusters.*;
import static java.time.DayOfWeek.*;


public class JavaTimePackage3 {

	public static void main(String[] args){
		// 지난 주 토요일이 며칠인지, 이번달의 3번째 금요일은 며칠인지 등 자주 쓰일만한 날짜 계산들을
		// 대신 해주는 메서드를 정의 해놓은 것이 TemporalAdjusters 클래스이다.
		
		LocalDate today = LocalDate.now();
		LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		LocalDate date = today.with(new DayAfterTomorrow());
		
		p(today); // System.out.println(today);
		p(date);
		
		p(today.with(firstDayOfNextMonth())); // 다음달의 첫날
		p(today.with(firstDayOfMonth()));// 이달의 첫날
		p(today.with(lastDayOfMonth()));// 이 달의 마지막 날
		p(today.with(firstInMonth(TUESDAY)));// 이 달의 첫번째 화요일
		p(today.with(lastInMonth(TUESDAY)));// 이 달의 마지막 화요일
		p(today.with(previous(TUESDAY)));// 지난 주 화요일
		p(today.with(previousOrSame(TUESDAY)));// 지난 주 화요일(오늘포함)
		p(today.with(next(TUESDAY)));// 다음 주 화요일
		p(today.with(nextOrSame(TUESDAY)));// 다음주 화요일(오늘 포함)
		p(today.with(dayOfWeekInMonth(4,TUESDAY)));// 이달의 4번째 화요일
		
	}
	
	

	public static void p(Object obj){
		System.out.println(obj);
	}

	
}

class DayAfterTomorrow implements TemporalAdjuster{
	@Override
	public Temporal adjustInto(Temporal temporal){
		return temporal.plus(2, ChronoUnit.DAYS);
	}
	
}
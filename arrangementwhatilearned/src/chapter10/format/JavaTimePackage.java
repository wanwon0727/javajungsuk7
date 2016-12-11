package chapter10.format;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class JavaTimePackage {

	public static void main(String[] args) {
		/*
		 * 날짜와 시간을 하나로 표현하는 Calendar 클래스와 달리, java.time패키지에서는 날짜와 시간을 별도의 클래스로 분리해 놓았다.
		 * 시간을 표현할 때는 LocalTime 클래스를 사용하고, 날짜를 표현할때는 LocalDate클래스를 사용한다. 그리고
		 * 날짜와 시간이 모두 필요할떄는 LocalDateTime클래스를 사용하면 된다.
		 * Calendar는 ZonedDateTime처럼 , 날짜와 시간 그리고 시간대까지 모두 가지고 있다.
		 * Date와 유사한 클래스로는 Instant가 있는데, 이 클래스는 날짜와 시간을 초 단위(정확히는 나노초)로 표현한다.
		 * 날짜와 시간을 초단위로 표현한 값을 타임스탬프(time-stamp)라고 부르는데 이 값은 날짜와 시간을 하나의 정수로 
		 * 표현할 수 있으므로 날짜와 시간의 차이를 계산하거나 순서를 비교하는데 유리해서 데이터 베이스에 많이 사용된다.
		 * 날짜 - 날짜 = Period
		 * 시간 - 시간 = Duration
		 * */
		
		// now() = 현재의 날짜와 시간을 반환,  of() = 지정된 날짜와 시간으로 객체 생성.
		LocalDate date = LocalDate.now(); // 2016-12-11
		LocalTime time = LocalTime.now();//17:19:16.361
		LocalDateTime dateTime = LocalDateTime.now();//2016-12-11T17:19:16.361
		ZonedDateTime dateTimeInKr = ZonedDateTime.now(); //2016-12-11T17:19:16.362+09:00[Asia/Seoul]
		
		LocalDate date2 = LocalDate.of(2016, 12, 11);
		LocalTime time2 = LocalTime.of(17, 19, 16);
		
		LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
		ZonedDateTime zDateTime = ZonedDateTime.of(dateTime2, ZoneId.of("Asia/Seoul"));
		
		LocalDate birthDate = LocalDate.ofYearDay(1984, 365); // 1984년 12월 31일
		LocalTime birthTime = LocalTime.ofSecondOfDay(86399); //23시 59분 59초

		LocalDate birthDate2 = LocalDate.parse("1984-12-31");
		LocalTime birthTime2 = LocalTime.parse("23:59:59");
		
		// 기타 참고 : temporal 과 chrono 의 의미가 모두 시간(time)인데도 , time 대신 굳이 이런 어려운 용어를 쓴 이유는
		// 시간(시분초) 과 더 큰 개념의 시간(년월일시분초)을 구분하기 위해서이다.
		
		LocalTime now = LocalTime.now(); // 현재시간
		int minute = now.getMinute(); // 현재 시간에서 분(minute)만 뽑아낸다.
		int minute2 = now.get(ChronoField.MINUTE_OF_HOUR); // 위의 문장과 동일
		
		LocalDate today = LocalDate.now(); // 오늘
		LocalDate setday = today.withYear(2000); // 오늘의 년도를 2000년으로 바꿈
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS); // 오늘에 1일을 더한다.
		LocalDate tomorrow2 = today.plusDays(1);// 위의 문장과 동일
		
		
		System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); // 1 - 24
		System.out.println(ChronoField.HOUR_OF_DAY.range()); // 0 - 23
		
		// 필드의 값 변경하기 - with(), plus(), minus()
		// LocalTime의 truncatedTo() 는 지정된 필드보다 작은 단위의 필드값을 0으로 만든다.
		LocalTime time7 = LocalTime.of(12, 34, 56); // 12시 34분 56초
		time7.truncatedTo(ChronoUnit.HOURS); // 시(hour) 보다 작은 단위를 0으로 바꿈.
		System.out.println(time7) ; // 12:00
		
		
		// int result = date1.compareTo(date2)  // 같으면 0, date1dl 이전이면 -1, 이후면 1
		// boolean isAfter(ChronoLocalDate other)
		// boolean isBefor(ChronoLocalDate other)
		// boolean isEqual(ChronoLocalDate other) // LocalDate에만 있음.
		
		// equals() 가 있는데도, isEqual()을 제공하는 이유는 연표(chronology)가 다른 두 날짜를
		// 비교하기 위해서이다. 모든 필드가 일치해야 하는 equals()와 달리 isEqual()은 오직 날짜만 비교한다.
		// 그래서 대부분의 경우 equals()와 isEqual()의 결과는 같다.
		LocalDate kDate = LocalDate.of(1999, 12, 31);
		JapaneseDate jDate = JapaneseDate.of(1999, 12, 31);
		System.out.println(kDate.equals(jDate));// false 연대가 다름
		System.out.println(kDate.isEqual(jDate));// true
		
		
		// Instant 는 에포크 타임(EPOCH TIME, 1970-01-01 00:00:00 UTC) 부터 경과된 시간을
		// 나노초 단위로 표현한다. 사람이 보기에는 불편하지만, 단일 진법으로 다루기 때문에 계산에는 편리하다.
		// 사람이 사용하는 날짜와 시간에는 여러 진법이 섞여 있어서 계산하기 어렵다.
		Instant now1 = Instant.now();
		Instant now2 = Instant.ofEpochSecond(now1.getEpochSecond());
		Instant now3 = Instant.ofEpochSecond(now1.getEpochSecond(), now1.getNano());
		// Instant를 생성할 때는 위와 같이  now() 와 ofEpochSecond()를 사용한다. 그리고 필드에 저장된
		//값을 가져올 때는 다음과 같이 한다.
		long epochSec = now1.getEpochSecond();
		int nano = now1.getNano();
		// 위의 코드에서 짐작할 수 있듯이, Instant는 시간을 초 단위와 나노초 단위로 나누어 저장한다.
		// 오라클 데이터베이스의 타임스탬프(timestamp)처럼 밀리초 단위의 EPOCH TIME을 필요로 하는 
		// 경우를 위해 toEpochMilli() 가 정의 되어 있다.
		// long toEpochMilli()
		// Instant 는 항상 UTC(+00:00)를 기준으로 하기 때문에, LocalTime과 차이가 있을 수 
		// 있다. 예를 들어 한국은 시간대가 "+09:00' 이므로 Instant와 LocalTime간에는 9시간
		//의 차이가 있다. 시간대를 고려해야 하는 경우 OffsetDateTime을 사용하는 것이 더 나은 선택일 수 있다.
		// UTC는 'Coordinated Universal Time'의 약어로 '세계 협정시' 이라고 하며, 
		//1972년 1월1일부터 시행된 국제 표준시이다.
		// Instant는 기존의 java.util.Date를 대체하기 위한 것이며, JDK1.8 부터 Date에 Instant로
		// 변환할 수 있는 새로운 메서드가 추가되었다.
		// static Date   from(Instant instant) // Instant -> Date
		//		  Instant toInstant() // Date -> Instant  
		
		// LocalDate 와 LocalTime 으로 LocalDateTime 만들기
		LocalDate date10 = LocalDate.of(2015, 12, 31);
		LocalTime time10 = LocalTime.of(12, 34, 56);
		LocalDateTime dt = LocalDateTime.of(date10, time10);
		LocalDateTime dt2 = date10.atTime(time10);
		LocalDateTime dt3 = time10.atDate(date10);
		LocalDateTime dt4 = date10.atTime(12, 34, 56);
		LocalDateTime dt5 = time.atDate(LocalDate.of(2015, 12, 31));
		LocalDateTime dt6 = date.atStartOfDay(); // dt6 = date.atTime(0, 0, 0);
		
		LocalDateTime dt7 = LocalDateTime.of(2015, 12, 31, 12, 34, 56);
		LocalDate date11 = dt7.toLocalDate(); // LocalDateTime -> LocalDate
		LocalTime time11 = dt7.toLocalTime();
		
		ZoneId zid = ZoneId.of("Asia/Seoul");
		ZonedDateTime zdt = dateTime.atZone(zid);
		System.out.println(zdt); //2016-12-11T19:05:25.443+09:00[Asia/Seoul]
		
		ZonedDateTime zdt2 = LocalDate.now().atStartOfDay(zid);
		System.out.println(zdt2); //2016-12-11T00:00+09:00[Asia/Seoul]
		
		// 뉴욕시간대를 알고 싶다면.
		ZoneId nyId = ZoneId.of("America/New_York");
		ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
		
		//ZoneOffset
		// UTC로부터 얼마만큼 떨어져 있는지를 ZoneOffSet으로 표현한다. 위의 결과에서 알 수 있듯이
		// 서울은 '+9' 이다. 즉 , UTC 보다 9시간 (32400초 = 60*60*9)이 빠르다.
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		// zoneOffset krOffset = ZoneOffset.of("+9"); // +h, +hh, hhmm, +hh:mm
		int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS); // 32400 초
		
		// 같은 지역내의 컴퓨터 간에 데이터를 주고받을 때, 전송시간을 표현하기에 LocalDateTime 이면,
		// 충분하겠지만, 서로 다른 시간대에 존재하는 컴퓨터 간의 통신에는 OffsetDateTime 이 필요하다.
		ZonedDateTime zdt3 = ZonedDateTime.of(date, time, zid);
		OffsetDateTime odt = OffsetDateTime.of(date, time, krOffset);
		
		//ZonedDatetime -> OffsetDateTime
		OffsetDateTime odt2 = zdt3.toOffsetDateTime();
		
		//GregorianCalendar from(ZonedDateTime zdt) // ZonedDateTime-> GregorianCalendar
		//ZonedDateTime toZonedDateTime() // GregorianCalendar -> ZonedDateTime
		
	}

}

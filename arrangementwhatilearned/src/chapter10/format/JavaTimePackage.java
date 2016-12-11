package chapter10.format;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class JavaTimePackage {

	public static void main(String[] args) {
		/*
		 * ��¥�� �ð��� �ϳ��� ǥ���ϴ� Calendar Ŭ������ �޸�, java.time��Ű�������� ��¥�� �ð��� ������ Ŭ������ �и��� ���Ҵ�.
		 * �ð��� ǥ���� ���� LocalTime Ŭ������ ����ϰ�, ��¥�� ǥ���Ҷ��� LocalDateŬ������ ����Ѵ�. �׸���
		 * ��¥�� �ð��� ��� �ʿ��ҋ��� LocalDateTimeŬ������ ����ϸ� �ȴ�.
		 * Calendar�� ZonedDateTimeó�� , ��¥�� �ð� �׸��� �ð������ ��� ������ �ִ�.
		 * Date�� ������ Ŭ�����δ� Instant�� �ִµ�, �� Ŭ������ ��¥�� �ð��� �� ����(��Ȯ���� ������)�� ǥ���Ѵ�.
		 * ��¥�� �ð��� �ʴ����� ǥ���� ���� Ÿ�ӽ�����(time-stamp)��� �θ��µ� �� ���� ��¥�� �ð��� �ϳ��� ������ 
		 * ǥ���� �� �����Ƿ� ��¥�� �ð��� ���̸� ����ϰų� ������ ���ϴµ� �����ؼ� ������ ���̽��� ���� ���ȴ�.
		 * ��¥ - ��¥ = Period
		 * �ð� - �ð� = Duration
		 * */
		
		// now() = ������ ��¥�� �ð��� ��ȯ,  of() = ������ ��¥�� �ð����� ��ü ����.
		LocalDate date = LocalDate.now(); // 2016-12-11
		LocalTime time = LocalTime.now();//17:19:16.361
		LocalDateTime dateTime = LocalDateTime.now();//2016-12-11T17:19:16.361
		ZonedDateTime dateTimeInKr = ZonedDateTime.now(); //2016-12-11T17:19:16.362+09:00[Asia/Seoul]
		
		LocalDate date2 = LocalDate.of(2016, 12, 11);
		LocalTime time2 = LocalTime.of(17, 19, 16);
		
		LocalDateTime dateTime2 = LocalDateTime.of(date2, time2);
		ZonedDateTime zDateTime = ZonedDateTime.of(dateTime2, ZoneId.of("Asia/Seoul"));
		
		LocalDate birthDate = LocalDate.ofYearDay(1984, 365); // 1984�� 12�� 31��
		LocalTime birthTime = LocalTime.ofSecondOfDay(86399); //23�� 59�� 59��

		LocalDate birthDate2 = LocalDate.parse("1984-12-31");
		LocalTime birthTime2 = LocalTime.parse("23:59:59");
		
		// ��Ÿ ���� : temporal �� chrono �� �ǹ̰� ��� �ð�(time)�ε��� , time ��� ���� �̷� ����� �� �� ������
		// �ð�(�ú���) �� �� ū ������ �ð�(����Ͻú���)�� �����ϱ� ���ؼ��̴�.
		
		LocalTime now = LocalTime.now(); // ����ð�
		int minute = now.getMinute(); // ���� �ð����� ��(minute)�� �̾Ƴ���.
		int minute2 = now.get(ChronoField.MINUTE_OF_HOUR); // ���� ����� ����
		
		LocalDate today = LocalDate.now(); // ����
		LocalDate setday = today.withYear(2000); // ������ �⵵�� 2000������ �ٲ�
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS); // ���ÿ� 1���� ���Ѵ�.
		LocalDate tomorrow2 = today.plusDays(1);// ���� ����� ����
		
		
		System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range()); // 1 - 24
		System.out.println(ChronoField.HOUR_OF_DAY.range()); // 0 - 23
		
		// �ʵ��� �� �����ϱ� - with(), plus(), minus()
		// LocalTime�� truncatedTo() �� ������ �ʵ庸�� ���� ������ �ʵ尪�� 0���� �����.
		LocalTime time7 = LocalTime.of(12, 34, 56); // 12�� 34�� 56��
		time7.truncatedTo(ChronoUnit.HOURS); // ��(hour) ���� ���� ������ 0���� �ٲ�.
		System.out.println(time7) ; // 12:00
		
		
		// int result = date1.compareTo(date2)  // ������ 0, date1dl �����̸� -1, ���ĸ� 1
		// boolean isAfter(ChronoLocalDate other)
		// boolean isBefor(ChronoLocalDate other)
		// boolean isEqual(ChronoLocalDate other) // LocalDate���� ����.
		
		// equals() �� �ִµ���, isEqual()�� �����ϴ� ������ ��ǥ(chronology)�� �ٸ� �� ��¥��
		// ���ϱ� ���ؼ��̴�. ��� �ʵ尡 ��ġ�ؾ� �ϴ� equals()�� �޸� isEqual()�� ���� ��¥�� ���Ѵ�.
		// �׷��� ��κ��� ��� equals()�� isEqual()�� ����� ����.
		LocalDate kDate = LocalDate.of(1999, 12, 31);
		JapaneseDate jDate = JapaneseDate.of(1999, 12, 31);
		System.out.println(kDate.equals(jDate));// false ���밡 �ٸ�
		System.out.println(kDate.isEqual(jDate));// true
		
		
		// Instant �� ����ũ Ÿ��(EPOCH TIME, 1970-01-01 00:00:00 UTC) ���� ����� �ð���
		// ������ ������ ǥ���Ѵ�. ����� ���⿡�� ����������, ���� �������� �ٷ�� ������ ��꿡�� ���ϴ�.
		// ����� ����ϴ� ��¥�� �ð����� ���� ������ ���� �־ ����ϱ� ��ƴ�.
		Instant now1 = Instant.now();
		Instant now2 = Instant.ofEpochSecond(now1.getEpochSecond());
		Instant now3 = Instant.ofEpochSecond(now1.getEpochSecond(), now1.getNano());
		// Instant�� ������ ���� ���� ����  now() �� ofEpochSecond()�� ����Ѵ�. �׸��� �ʵ忡 �����
		//���� ������ ���� ������ ���� �Ѵ�.
		long epochSec = now1.getEpochSecond();
		int nano = now1.getNano();
		// ���� �ڵ忡�� ������ �� �ֵ���, Instant�� �ð��� �� ������ ������ ������ ������ �����Ѵ�.
		// ����Ŭ �����ͺ��̽��� Ÿ�ӽ�����(timestamp)ó�� �и��� ������ EPOCH TIME�� �ʿ�� �ϴ� 
		// ��츦 ���� toEpochMilli() �� ���� �Ǿ� �ִ�.
		// long toEpochMilli()
		// Instant �� �׻� UTC(+00:00)�� �������� �ϱ� ������, LocalTime�� ���̰� ���� �� 
		// �ִ�. ���� ��� �ѱ��� �ð��밡 "+09:00' �̹Ƿ� Instant�� LocalTime������ 9�ð�
		//�� ���̰� �ִ�. �ð��븦 ����ؾ� �ϴ� ��� OffsetDateTime�� ����ϴ� ���� �� ���� ������ �� �ִ�.
		// UTC�� 'Coordinated Universal Time'�� ���� '���� ������' �̶�� �ϸ�, 
		//1972�� 1��1�Ϻ��� ����� ���� ǥ�ؽ��̴�.
		// Instant�� ������ java.util.Date�� ��ü�ϱ� ���� ���̸�, JDK1.8 ���� Date�� Instant��
		// ��ȯ�� �� �ִ� ���ο� �޼��尡 �߰��Ǿ���.
		// static Date   from(Instant instant) // Instant -> Date
		//		  Instant toInstant() // Date -> Instant  
		
		// LocalDate �� LocalTime ���� LocalDateTime �����
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
		
		// ����ð��븦 �˰� �ʹٸ�.
		ZoneId nyId = ZoneId.of("America/New_York");
		ZonedDateTime nyTime = ZonedDateTime.now().withZoneSameInstant(nyId);
		
		//ZoneOffset
		// UTC�κ��� �󸶸�ŭ ������ �ִ����� ZoneOffSet���� ǥ���Ѵ�. ���� ������� �� �� �ֵ���
		// ������ '+9' �̴�. �� , UTC ���� 9�ð� (32400�� = 60*60*9)�� ������.
		ZoneOffset krOffset = ZonedDateTime.now().getOffset();
		// zoneOffset krOffset = ZoneOffset.of("+9"); // +h, +hh, hhmm, +hh:mm
		int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS); // 32400 ��
		
		// ���� �������� ��ǻ�� ���� �����͸� �ְ���� ��, ���۽ð��� ǥ���ϱ⿡ LocalDateTime �̸�,
		// ����ϰ�����, ���� �ٸ� �ð��뿡 �����ϴ� ��ǻ�� ���� ��ſ��� OffsetDateTime �� �ʿ��ϴ�.
		ZonedDateTime zdt3 = ZonedDateTime.of(date, time, zid);
		OffsetDateTime odt = OffsetDateTime.of(date, time, krOffset);
		
		//ZonedDatetime -> OffsetDateTime
		OffsetDateTime odt2 = zdt3.toOffsetDateTime();
		
		//GregorianCalendar from(ZonedDateTime zdt) // ZonedDateTime-> GregorianCalendar
		//ZonedDateTime toZonedDateTime() // GregorianCalendar -> ZonedDateTime
		
	}

}

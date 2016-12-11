package chapter10.format;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class parshingAndFormat {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016, 1, 2);
		String yyyymmdd = DateTimeFormatter.ISO_DATE.format(date); //"2016-01-02"
		String yyyymmdd2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//"2016-01-02"
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		String shortFormat = formatter.format(LocalDate.now());
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		ZonedDateTime zdateTime = ZonedDateTime.now();
		
		String[] patternArr = {
			"yyyy-MM-dd HH:mm:ss",
			"''yy년 MMM dd일 E요일",
			"yyyy-MM-dd HH:mm:ss.SSS Z VV",
			"yyyy-MM-dd hh:mm:ss a",
			"오늘은 올 해의 D번째 날입니다.",
			"오늘은 이 달의 d번째 날입니다.",
			"오늘은 올 해의 w번째 주입니다.",
			"오늘은 이 달의 W번째 주입니다.",
			"오늘은 이 달의 W번째 E요일입니다"
		};

		for(String p : patternArr){
			DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter3));
		}

	}

}

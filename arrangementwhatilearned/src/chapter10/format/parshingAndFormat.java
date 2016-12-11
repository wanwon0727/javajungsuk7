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
			"''yy�� MMM dd�� E����",
			"yyyy-MM-dd HH:mm:ss.SSS Z VV",
			"yyyy-MM-dd hh:mm:ss a",
			"������ �� ���� D��° ���Դϴ�.",
			"������ �� ���� d��° ���Դϴ�.",
			"������ �� ���� w��° ���Դϴ�.",
			"������ �� ���� W��° ���Դϴ�.",
			"������ �� ���� W��° E�����Դϴ�"
		};

		for(String p : patternArr){
			DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern(p);
			System.out.println(zdateTime.format(formatter3));
		}

	}

}

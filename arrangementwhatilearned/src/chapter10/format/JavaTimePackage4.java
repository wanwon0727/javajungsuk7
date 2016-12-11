package chapter10.format;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class JavaTimePackage4 {
	public static void main(String[] args){
		// Period �� Duration
		// ��¥ - ��¥  = Period,   �ð� - �ð� = Duration
		// between ()
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		Period pe = Period.between(date1, date2);
		
		LocalTime time1 = LocalTime.of(00, 00, 00);
		LocalTime time2 = LocalTime.of(12, 34, 56); // 12�� 34�� 56��
		
		Duration du = Duration.between(time1, time2);
		
		long year = pe.get(ChronoUnit.YEARS); // int getYears();
		long month = pe.get(ChronoUnit.MONTHS); // int getMonths();
		long day = pe.get(ChronoUnit.DAYS); // int getDays();
		
		long sec = du.get(ChronoUnit.SECONDS); // long getSeconds();
		int nano = (int) du.get(ChronoUnit.NANOS); // int getNano();
		// �Ǹ������Ե� Duration���� Chrono.SECONDS�� Chrono.NANOS�ۿ� ����� �� ���ٴ� ����� ���Դ�.
		// �� ���������� ��¿ �� ���� ������ ���� ���� ����� ���Ҵ�.
		long hour2 = du.getSeconds()/3600;
		long min2 = (du.getSeconds()- hour2*3600)/60;
		long sec2 = (du.getSeconds()- hour2*3600 - min2*60) % 60;
		int nano2 = du.getNano();
		// �� ����� �� �� �����ϰ� ������ �ϱ� ���ؼ��� Duration�� LocalTime���� ��ȯ�� ������, LocalTime�� 
		// ������ �ִ� get�޼��带 ����ϸ� �� �����ϴ�.
		
		LocalTime tmpTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		
		int hour3 = tmpTime.getHour();
		int min3 = tmpTime.getMinute();
		int sec3 = tmpTime.getSecond();
		int nano3 = du.getNano();
		
		// between() �� until()
		// until() �� between()�� ���� ���� ���� �Ѵ�. between() �� static�޼����̰�,
		// until()�� �ν��Ͻ� �޼����� ���̰� �ִ�.
		/*Period pe2 = Period.between(today, myBirthDay);
		Period pe2 = today.until(myBirthDay);
		long dday = today.until(myBirthDay, ChronoUnit.DAYS);*/
		// Period �� ������� �и��ؼ� �����ϱ� ������, D-day�� ���Ϸ��� ��쿡�� �� ���� �Ű������� 
		// �޴� unit()�� ����ϴ� ���� ����. ��¥�� �ƴ� �ð����� until()�� ����� �� ������, Duration�� ��ȯ�ϴ�until�� ����.
		// ��Ģ����, �񱳿���, ��Ÿ �޼���
		// plus(), minus() �ܿ� ������ �������� ���� �޼��嵵 �ִ�.
		// pe = pe.minusYears(1).multipliedBy(2);  1���� ����, 2�踦 ���Ѵ�.
		// du = du.plusHours(1).dividedBy(60); 1�ð��� ���ϰ� 60���� ������.
		// Period�� �������� ���� �޼��尡 ���µ�, Period�� ��¥�� �Ⱓ�� ǥ���ϱ� ���� ���̹Ƿ� �������� ����
		// �޼��尡 ���� �������� �ʱ� ������ ���� ���� ���̴�.
		// �׸��� �������� Ȯ���ϴ� isNegative()�� 0���� Ȯ���ϴ� isZero()�� �ִ�. �� ��¥ �Ǵ� �ð��� ���� ��,
		// ����ϸ� ������� ������ �Ǵ� ������ �˾Ƴ� �� �ִ�.
		boolean sameDate = Period.between(date1, date2).isZero();
		boolean isBefore = Duration.between(time1, time2).isNegative();
	
		du = du.abs();// ��ȣ ���ֱ�
		if(du.isNegative()) du = du.negated();// ��ȣ �ݴ�� �ٲٱ�
	
		pe = Period.of(1, 13, 32).normalized(); // 1�� 13���� 32�� -> 2�� 1���� 32��;
		
		LocalDate date11 = LocalDate.of(2015, 11, 28);
		LocalDate date22 = LocalDate.of(2015, 11, 29);
		
		long period = date2.toEpochDay() - date1.toEpochDay(); // 1
	}
}

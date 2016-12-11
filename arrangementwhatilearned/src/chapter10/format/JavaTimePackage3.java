package chapter10.format;

import java.time.*;
import java.time.temporal.*;
import java.time.temporal.Temporal;
import static java.time.temporal.TemporalAdjusters.*;
import static java.time.DayOfWeek.*;


public class JavaTimePackage3 {

	public static void main(String[] args){
		// ���� �� ������� ��ĥ����, �̹����� 3��° �ݿ����� ��ĥ���� �� ���� ���ϸ��� ��¥ ������
		// ��� ���ִ� �޼��带 ���� �س��� ���� TemporalAdjusters Ŭ�����̴�.
		
		LocalDate today = LocalDate.now();
		LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		LocalDate date = today.with(new DayAfterTomorrow());
		
		p(today); // System.out.println(today);
		p(date);
		
		p(today.with(firstDayOfNextMonth())); // �������� ù��
		p(today.with(firstDayOfMonth()));// �̴��� ù��
		p(today.with(lastDayOfMonth()));// �� ���� ������ ��
		p(today.with(firstInMonth(TUESDAY)));// �� ���� ù��° ȭ����
		p(today.with(lastInMonth(TUESDAY)));// �� ���� ������ ȭ����
		p(today.with(previous(TUESDAY)));// ���� �� ȭ����
		p(today.with(previousOrSame(TUESDAY)));// ���� �� ȭ����(��������)
		p(today.with(next(TUESDAY)));// ���� �� ȭ����
		p(today.with(nextOrSame(TUESDAY)));// ������ ȭ����(���� ����)
		p(today.with(dayOfWeekInMonth(4,TUESDAY)));// �̴��� 4��° ȭ����
		
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
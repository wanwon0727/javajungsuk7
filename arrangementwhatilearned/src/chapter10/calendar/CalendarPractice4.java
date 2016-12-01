package chapter10.calendar;

import java.util.Calendar;

public class CalendarPractice4 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		
		date.set(2015, 7,31); // 2015�� 8�� 31�Ϸ� ����
		
		System.out.println(toString(date));
		System.out.println("= 1�� �� =");
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));
		
		System.out.println("= 6���� =");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		System.out.println("=31�� �� (roll) =");
		date.roll(Calendar.DATE, 31);
		System.out.println(toString(date));
		System.out.println("=31�� �� (add) =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
		
		// roll �� add�� ������ �ʵ��� ���� ���� �Ǵ� ���ҽ�Ų�ٴ� ����� �Ȱ�����
		// add �޼���� ��¥�ʵ�(Calendar.DATE) ���� 31�� ������ų ��� �����޷� �Ѿ�Ƿ� �� �ʵ�(Calendar.Month)�� ���� 1 ����������
		// roll �޼���� ��¥�ʵ� ���� 31�� ������ų ��� ���ʵ��� ���� ������ �ʰ� �� �ʵ��� ���� �ٲ�� �ȴ�.
		// ��, �Ѱ��� ���ܰ� �ִµ� ���ʵ�(Calendar.DATE)�� ����(end of month) �� ��, 
		// roll �޼��带 �̿��ؼ� ���ʵ�(Calendar.Month)�� �����ϸ� ���ʵ�(Calendar.DATE)�� ������ ��ĥ �� �ִ�.
		Calendar date2 = Calendar.getInstance();
		date2.set(2015, 0,31); // 2015�� 1�� 31�Ϸ� ����
		System.out.println(toString(date2));
		date2.roll(Calendar.MONTH, 1);
		System.out.println(toString(date2));
		// add �޼��嵵 ������쿡 ���������� �ش�� ���Ϸ� �ڵ�����ȴ�. 

	}

	private static String toString(Calendar date) {
		 
		return date.get(Calendar.YEAR)+"�� " + (date.get(Calendar.MONTH)+1)+"�� "+ date.get(Calendar.DATE)+"��";
	}

}

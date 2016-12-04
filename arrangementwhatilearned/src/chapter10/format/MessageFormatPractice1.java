package chapter10.format;

import java.text.MessageFormat;

public class MessageFormatPractice1 {

	public static void main(String[] args) {
		
		// MessageFormat�� ����� ����� ���ڿ� msg�� �ۼ��� �� '{����}' �� ǥ�õ� �κ��� �����Ͱ� ��µ� �ڸ��̴�.
		// ���ڸ��� �������� �ʿ�� ���� ������ �ݺ��ؼ� ����� ���� �ִ�.
		String msg = "Name : {0} \nTel : {1} \nAge : {2} \nBirthday : {3} ";
		
		Object[] arguments = {
				"���ڹ�", "02-123-1234", "27", "07-09"
		};
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);

	}

}

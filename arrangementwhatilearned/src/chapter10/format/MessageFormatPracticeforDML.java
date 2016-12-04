package chapter10.format;

import java.text.MessageFormat;

public class MessageFormatPracticeforDML {

	public static void main(String[] args) {
		// �ټ��� �����͸� Database�� �����ϱ� ���� Insert������ ��ȯ�ϴ� ��� � ����ϸ� ����.
		// Ȭ����ǥ ' �� MessageFormat �� ��Ŀ� escape ���ڷ� ���Ǳ� ������ ���ڿ� msg������ Ȭ����ǥ�� ����Ϸ��� 
		// Ȭ����ǥ�� �������� �� �� ����ؾ� �Ѵ�.
		
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO "+ tableName + " VALUES (''{0}'', ''{1}'', {2}, ''{3}'');";
		
		Object[][] arguments = {
				{"���ڹ�","02-123-1234", "27", "07-09"},
				{"������", "032-333-1234", "33", "10-07"},
		};

		for(int i=0; i < arguments.length; i++){
			String result = MessageFormat.format(msg, arguments[i]);
			System.out.println(result);
		}
	}
}

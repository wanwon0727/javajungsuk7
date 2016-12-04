package chapter10.format;

import java.text.MessageFormat;

public class MessageFormatPracticeforDML {

	public static void main(String[] args) {
		// 다수의 데이터를 Database에 저장하기 위한 Insert문으로 변환하는 경우 등에 사용하면 좋음.
		// 홑따옴표 ' 는 MessageFormat 의 양식에 escape 문자로 사용되기 때문에 문자열 msg내에서 홑따옴표를 사용하려면 
		// 홑따옴표를 연속으로 두 번 사용해야 한다.
		
		String tableName = "CUST_INFO";
		String msg = "INSERT INTO "+ tableName + " VALUES (''{0}'', ''{1}'', {2}, ''{3}'');";
		
		Object[][] arguments = {
				{"이자바","02-123-1234", "27", "07-09"},
				{"김프로", "032-333-1234", "33", "10-07"},
		};

		for(int i=0; i < arguments.length; i++){
			String result = MessageFormat.format(msg, arguments[i]);
			System.out.println(result);
		}
	}
}

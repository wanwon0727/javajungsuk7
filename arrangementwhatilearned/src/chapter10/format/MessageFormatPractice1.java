package chapter10.format;

import java.text.MessageFormat;

public class MessageFormatPractice1 {

	public static void main(String[] args) {
		
		// MessageFormat에 사용할 양식인 문자열 msg를 작성할 때 '{숫자}' 로 표시된 부분이 데이터가 출력될 자리이다.
		// 이자리는 순차적일 필요는 없고 여러번 반복해서 사용할 수도 있다.
		String msg = "Name : {0} \nTel : {1} \nAge : {2} \nBirthday : {3} ";
		
		Object[] arguments = {
				"이자바", "02-123-1234", "27", "07-09"
		};
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);

	}

}

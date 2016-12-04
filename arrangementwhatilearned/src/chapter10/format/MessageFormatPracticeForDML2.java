package chapter10.format;

import java.text.MessageFormat;

public class MessageFormatPracticeForDML2 {

	public static void main(String[] args) {
		//이전 예제에서는 데이터를 양식에 넣어서 출력했지만 이번에는 parse(String source)를
		// 이용해서 출력된 데이터로부터 필요한 데이터만을 뽑아내는 방법을 보여준다.
		String[] data = {
			"INSERT INTO CUST_INFO VALUES ('이자바', '02-123-1234', 27, '07-09'); ",
			"INSERT INTO CUST_INFO VALUES ('김프로', '032-333-1234', 33, '10-07'); "
		};

		String pattern = "INSERT INTO CUST_INFO VALUES ({0}, {1}, {2}, {3});";
		MessageFormat mf = new MessageFormat(pattern);
		
		try{
			for(int i=0; i < data.length; i++){
				Object[] objs = mf.parse(data[i]);
				for(int j=0; j < objs.length; j++){
					System.out.print(objs[j]+",");
				}
				System.out.println();
			}
		}catch(Exception e) {}
	}

}

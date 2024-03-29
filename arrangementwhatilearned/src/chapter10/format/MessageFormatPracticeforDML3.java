package chapter10.format;

import java.io.File;
import java.text.MessageFormat;
import java.util.*;
public class MessageFormatPracticeforDML3 {

	public static void main(String[] args) throws Exception{
		String tableName = "CUST_INFO";
		String fileName = "data4.txt";
		String msg = "INSERT INTO "+ tableName + " VALUES ({0}, {1}, {2}, {3});";// 깃허브7777
		Scanner s = new Scanner(new File(fileName));
		
		String pattern = "{0}, {1}, {2}, {3}";
		MessageFormat mf = new MessageFormat(pattern);//
		
		while(s.hasNextLine()){//j
			String line = s.nextLine();
			Object[] objs = mf.parse(line);
			System.out.println(MessageFormat.format(msg, objs));
		}
		s.close(); // 작업이 끝났으니 Scanner 에서 사용한 파일을 닫아 준다
	}

}

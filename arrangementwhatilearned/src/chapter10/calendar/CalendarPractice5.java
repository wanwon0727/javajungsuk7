package chapter10.calendar;

import java.util.Calendar;

public class CalendarPractice5 {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage : java CalendarEx6 2015 9");
			return ;
		}
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int START_DAY_OF_WEEK = 0;
		int END_DAY = 0;
		
		Calendar sDay = Calendar.getInstance();
		Calendar eDay = Calendar.getInstance();
		
		// 월의 경우 0부터 11까지의 값을 가지므로 1을 빼주어야 한다.
		// 예를 들어, 2004년 11월 1일은 sDay.set(2004,10,1); 과 같이 해줘야 한다.
		sDay.set(year,month-1,1);
		eDay.set(year, month,1); 
		
		// 다음달의 첫날에서 하루를 빼면 현재달의 마지막 날이 된다.
		// 12월1일에서 하루를 빼면 11월 30일이 된다.
		eDay.add(Calendar.DATE, -1);
		
		// 첫번째 요일이 무슨 요일인지 알아낸다.
		START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		
		// eDay에 지정된 날짜를 얻어온다.
		END_DAY = eDay.get(Calendar.DATE);
		
		System.out.println( year+"년 " + month+"월");
		System.out.println("SU  MO  TU  WE  TH  FR  SA");
		// 해당월의 1일이 어느요일인지에 따라서 공백을 찍는다.
		for(int i=1; i<START_DAY_OF_WEEK; i++){
			System.out.print("    ");
		}
		
	/*	// 내가 만든 for문
		for(int j=1; j<=END_DAY; j++){
			if((j+START_DAY_OF_WEEK-1)%7!=0){
			  if(j<10) System.out.print(j+"   ");
			  else System.out.print(j+"  ");
			}
			else {
				 if(j<10) System.out.print(j+"   ");
				 else System.out.print(j+"  ");;
				System.out.println();
				 
			}
		}// 내가 만든 for문 종료
*/		
		// 자바의 정석 for문  - 삼항 연산자 사용
		for(int i=1, n=START_DAY_OF_WEEK ; i <= END_DAY; i++,n++){
			System.out.print( ( i<10 ) ? i+"   " : i+"  ");
			if (n%7==0) System.out.println();
		}  
		

	}

}

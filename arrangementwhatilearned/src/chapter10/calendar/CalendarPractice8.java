package chapter10.calendar;

public class CalendarPractice8 {

	public static void main(String[] args) {
		
		 // boolean isLeapYear(int year)
		 // : 매개변수 year 가 윤년이면 true를 그렇지 않으면 false 를 반환한다.
		  
		 // int dayDiff(int y1, int m1, int y2, int m2, int d2)
		 // : 두 날짜간의 차이를 일단위로 반환한다.
		
		 // int getDayOfWeek(int year, int month, int day)
		 // : 지정한 날짜의 요일을 반환한다. (1~7, 1이 일요일 )
		  
		 // String converDayToDate(int day)
		 // : 일 단위의 값을 년월일의 형태의 문자열로 변환하여 반환한다.
		
		 // int convertDateToDay(int year, int month, int day)
		 // : 년월일을 입력 받아서 일단위로 변환한다.
		
		// 일단위로 변환할 때 , Calendar의 경우 1970년 1월1일을 기준으로 계산한다.
		// 따라서 그 이전 날짜에 대해 getTimeInMillis() 를 호출하면 음수를 결과로 얻는다.
		
		System.out.println("2014. 5. 31 :"+ getDayOfWeek(2014, 5, 31));
		System.out.println("2012. 6. 1 :"+ getDayOfWeek(2012, 6, 1));
		System.out.println("2014. 5. 1 - 2014. 4. 28 :"+
							dayDiff(2014,5,1,2014,4,28));
		System.out.println("2015. 6. 29 :"+ convertDateToDay(2015, 6, 29));
		System.out.println("735778 : "+ convertDayToDate(735778));
		  
	}
	
	 public static int[] endOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	  public static int getDayOfWeek(int year, int month, int day){
			// 1~7 의 값을 반환한다. 결과가 1이면 일요일이다.
			return convertDateToDay(year, month, day)%7 +1;
			
	}
		
	  public static boolean isLeapYear(int year){
			return ( (year%4==0) && (year%100!=0) || (year%400==0) );
	}
	  
	  public static int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2){
		  return convertDateToDay(y1, m1, d1) - convertDateToDay(y2, m2, d2);
	  }
		  
	  public static int convertDateToDay(int year, int month, int day){
			int numOfLeapYear = 0;  // 윤년의 수

			// 전년도까지의 윤년의 수를 구한다.
			for(int i=1; i<year; i++){
				if(isLeapYear(i)) 
					numOfLeapYear++;
			}
			
			// 전년도까지의 일수를 구한다.
			int toLastYearDaySum = (year-1)* 365 + numOfLeapYear;
			
			// 올해의 전 월까지의 일수 계산
			int thisYearDaySum = 0;
			
			for(int i=0; i< month-1; i++){
				thisYearDaySum += endOfMonth[i];
			}
			// 윤년이고, 2월이 포함되어 있으면 1일을 증가시킨다.
			if(month>2 && isLeapYear(year))
			    thisYearDaySum ++;
			
			thisYearDaySum += day;
			
			return toLastYearDaySum + thisYearDaySum;
	}

	public static String convertDayToDate(int day){
		int year = 1;
		int month = 0;
		while(true){
			int aYear = isLeapYear(year) ? 366 : 365;
			if(day > aYear){
				day-= aYear;
				year++;
			}else {
				break;
			}
		}
		
		while(true){
			int endDay = endOfMonth[month];
			// 윤년이고 윤달이 포함되어 있으면, 1일을 더 뺀다.
			if(isLeapYear(year) && month == 1) endDay++;
			
			if(day > endDay){
				day -= endDay;
				month++;
				
			}else {
				break;
			}
		}
		return year + "-" + (month+1) + "-" + day;
	}

}

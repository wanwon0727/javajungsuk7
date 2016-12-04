package chapter10.format;

import java.text.DecimalFormat;

public class DecimalFormatPractice {

	 

	public static void main(String[] args) {
		/* double number = 1234567.89;
		DecimalFormat df = new DecimalFormat("#.#E0");
		String result = df.format(number);
		System.out.println(result);  // 결과 : 1.2E6 ; */
		
		double number = 1234567.89;
		
		String[] pattern = {
				"0",
				"#",
				"0.0",
				"#.#",
				"0000000000.0000",
				"##########.####",
				"#.#-",
				"-#.#",
				"#,###.##",
				"#,####.##",
				"#E0",
				"0E0",
				"##E0",
				"00E0",
				"####E0",
				"0000E0",
				"#.#E0",
				"0.0E0",
				"0.000000000E0",
				"00.00000000E0",
				"000.0000000E0",
				"#.#########E0",
				"##.########E0",
				"###.#######E0",
				"#,###.##+;#,###.##-",
				"#.#%",
				"#.#\u2030",
				"\u00A4 #,###",
				"'#'#,###",
				"''#,###"
		};
		
		for(int i=0; i <pattern.length ; i++){
			DecimalFormat df = new DecimalFormat(pattern[i]);
			System.out.printf("%19s : %s\n", pattern[i], df.format(number));
		}
		
		System.out.println();
		System.out.printf("숫자소수점1째자리되게 반올림 처리  %.1f\n", number); // 참고
				
		
	}

}
  
package chapter10.format;

import java.text.ChoiceFormat;

public class ChoiceFormatPractice1 {

	public static void main(String[] args) {
		double[] limits = {60, 70, 80, 90};// ���� ������ ū ���� ������ ����� �Ѵ�.
		// limits, grades ���� ������ ������ ���߾�� �Ѵ�.
		String[] grades = {"D", "C", "B", "A"};
		
		int[] scores = { 100, 95, 88, 70, 52, 60, 70 };
		
		ChoiceFormat form = new ChoiceFormat(limits, grades);
		
		for(int i=0; i<scores.length; i++){
			System.out.println(scores[i]+ " : " + form.format(scores[i]));
		}
		
		System.out.println();
		
		// ������ �����ڷ� # ��  < �ΰ����� �����ϴµ� 'limit#value'�� ���·� ����Ѵ�.
		// #�� ��谪�� ������ ���Խ�Ű���� < �� ���Խ�Ű�� �ʴ´�. �Ʒ��� ����� 90�� A����, 80�� B�� �ƴ�, C�ΰͿ� �ָ�����.
		String pattern = "60 # D | 70 # C | 80 < B | 90 # A";
		int[] scores2 = { 91, 90, 80, 88, 70, 52, 60 };
		
		ChoiceFormat form2 = new ChoiceFormat(pattern);
		
		for(int i=0; i< scores2.length; i++){
			System.out.println(scores2[i]+ " : "+ form2.format(scores2[i]));
		}

	}

}

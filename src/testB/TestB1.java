package testB;

import calc.Calc;

public class TestB1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		double [][]A=new double [5][5];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A.length;j++){
				A[i][j]=i+j+2;
			}
		}
		System.out.println(Calc.matNormInf(A));

	}

}

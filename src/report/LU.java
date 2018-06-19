package report;

import calc.Calc;
import chapter8.Inv;

public class LU {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int n=10;
		double []x=new double[n];
		long timesum=0;
		int s=1;
		for(int i=0;i<s;i++){
			long t1 = System.nanoTime();
			double[][] A=Inv.makeMat(n);
			double []b=Calc.reportB(A);
			x=Calc.LUSolve(A, b);
			long t2 = System.nanoTime();
			System.out.println((t2-t1));
			if(i!=0){
				timesum=timesum+t2-t1;
			}
		}

		System.out.println();
		System.out.println(Inv.GosaNolm(x));

	}

}

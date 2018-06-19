package report;

import calc.Calc;
import chapter8.Inv;

public class Pivot {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int n=5000;
		int s=1;
		double []x=new double[n];
		long timesum=0;
		for(int i=0;i<s;i++){
			long t1 = System.nanoTime();
			double[][] A=Inv.makeMat(n);
			double []b=Calc.reportB(A);
			x=Calc.Pivot(A, b);
			long t2 = System.nanoTime();
			if(i!=0){
				timesum=timesum+t2-t1;
			}
			System.out.println((t2-t1));
		}
		System.out.println();
		System.out.println(Inv.GosaNolm(x));

	}

}

package report;

import calc.Calc;
import chapter8.Inv;

public class Jacobi {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int n=1000;
		int s=1;
		double []x=new double[n];
		/*long timesum=0;
		for(int i=0;i<s;i++){
			long t1 = System.nanoTime();
			double[][] A=Inv.makeMat(n);
			double []b=Calc.reportB(A);
			double[]x0=Calc.reportX(n);
			x=Calc.Jacobi(A, x0, b);
			long t2 = System.nanoTime();
			System.out.println((t2-t1));
			if(i!=0){
				timesum=timesum+t2-t1;
			}
		}
		*/

		System.out.println();
		double[][] A=Calc.reportA(n);
		System.out.println("条件数は"+Inv.kappa(A, Calc.InvertMatirox(A)));
		System.out.println(Inv.GosaNolm(x));

	}

}

package report2;

import calc.Calc;

public class PivotEffect {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int Temp,m=500;
		double A[][]=new double[m][m];
		double T[][]=new double[m][m];
		double b[]=new double[m];
		double t[]=new double[m];
		double x[]=new double[m];
		double xp[]=new double[m];
		double d,dp,temp=0;
		for(int i=1;i<101;i++){
			for(int s=0;s<m;s++){
				b[s]=Math.random();
				for(int u=0;u<m;u++){
					A[s][u]=Math.random();
				}
			}
			x=Calc.Gaus(A, b);
			xp=Calc.Pivot(A, b);
			d=Calc.vecNorm2(Calc.subVec(b, Calc.matVec(A, x)));
			dp=Calc.vecNorm2(Calc.subVec(b, Calc.matVec(A, xp)));
			if(d-dp>temp){
				T=Calc.copyMat(A);
				t=Calc.copyVec(b);
				System.out.println(d+" "+dp);
			}
			System.out.println(d+"       "+dp);

		}
		System.out.println("参考値");
		Calc.printMat(T);
		Calc.printVec(t);
	}

}

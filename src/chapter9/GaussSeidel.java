package chapter9;

import calc.Calc;

public class GaussSeidel {

	public static double[] Jacobi(double[][]A,double []x,double[]b) {
		// TODO 自動生成されたメソッド・スタブ


		for(int i=0;i<x.length;i++){
			x[i]=10.0;
		}
		double []xtemp;

		double e=Math.pow(10, -10),temp;
		int M=100,m=0;
		while(true){

			xtemp=Calc.copyVec(x);
			for(int i=0;i<A.length;i++){
				temp=0;
				for(int j=0;j<A.length;j++){
					if(i!=j){
						temp=temp+A[i][j]*xtemp[j];//xtempをｘに変えるとGaussSeidel
					}
				}
				x[i]=(b[i]-temp)/(double)(A[i][i]);
			}
			System.out.print(m+"回目のx=");
			Calc.printVec(x);
			if(Calc.vecNorm2(Calc.subVec(xtemp, x))/Calc.vecNorm2(x)<=e){
				System.out.print("近似解は");
				Calc.printVec(x);
				System.out.println();
				System.out.println("反復回数は"+m);
				return x;
			}
			if(M==m){
				System.out.println("収束しない");
				return x;
			}
			m++;

		}


	}
}

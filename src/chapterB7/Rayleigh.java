package chapterB7;

import calc.Calc;

public class Rayleigh {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double e=1e-8,r,rtemp=0;
		int N=10000;

			double[]x={20,1,2,3,0};
			double xtemp[]=new double[x.length];
			double[][] A={{0, -(1/2), 0, 0, 0}, {-(1/2), 0, -(1/2), 0, 0}, {0, -(1/2),
				  0, -(1/2), 0}, {0, 0, -(1/2), 0, -(1/2)}, {0, 0, 0, -(1/2), 0}};
		int k=0;
		while(true){
			if(k==N){
				System.out.println("収束しない");
				break;
			}
			xtemp=Calc.copyVec(x);
			for(int i=0;i<x.length;i++){
				x[i]=x[i]/Calc.vecNorm2(xtemp);
			}
			xtemp=Calc.copyVec(x);
			x=Calc.matVec(A, x);
			r=rtemp;
			rtemp=Calc.innProd(x, xtemp)/Calc.innProd(xtemp, xtemp);
			if(Math.abs(rtemp-r)/Math.abs(rtemp)<e){
				System.out.println("反復回数は"+k+",絶対値最大の固有値が"+rtemp+",対応する固有ベクトルは");
				Calc.printVec(x);
				break;
			}
			k++;
		}



	}

}

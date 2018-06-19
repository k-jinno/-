package chapterB6;

import calc.Calc;

public class PowerMethod {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//mathemarhicaで固有値を求めるときはEigenvalues[]
		double e=1e-8,r,rtemp=0;
		int N=2000;
		for(double a=1;a<5;a++){
			double[]x={1000,100,-20,9,5};
			double xtemp[]=new double[x.length];
			rtemp=0;
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
			double max=0;
			int l=0;
			for(int i=0;i<x.length;i++){
				if(max<Math.abs(xtemp[i])){
					l=i;
				}
			}
			rtemp=x[l]/xtemp[l];
			if(Math.abs(rtemp-r)/Math.abs(rtemp)<e){
				System.out.println("反復回数は"+k+",絶対値最大の固有値が"+rtemp+",対応する固有ベクトルは");
				Calc.printVec(x);
				break;
			}
			k++;
		}
		}

	}

}

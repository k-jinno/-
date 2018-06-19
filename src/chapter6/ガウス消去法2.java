package chapter6;

import calc.Calc;

public class ガウス消去法2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double[][] A=new double[5][5];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				A[i][j]=1.0/(double)((i+1.0)+(j+1.0));
			}
		}
		double[]b={1,1,1,1,1};
		double[]b1=Calc.matVec(A,b);//b*=Ax*

		Calc.printVec(b1);
		double b1Inf=Calc.vecNormInf(b1);
		double[]b0={0.001*b1[0],0,0,0,0};//Δb
		double b0Inf=Calc.vecNormInf(b0);
		b1[0]=b1[0]+b0[0];

		double[]x=new double[A.length];//x_1*
		double a;//中間変数
		for(int k=0;k<A.length-1;k++){
			for(int i=k+1;i<A.length;i++){
				a=A[i][k]/A[k][k];//中間変数の更新
				for(int j=k+1;j<A.length;j++){
					A[i][j]=A[i][j]-a*A[k][j];//行列Ａの(i,j)成分A[i-1][j-1]を更新
				}
				b1[i]=b1[i]-a*b1[k];//行列bのi成分b[i-1]を更新
			}
		}

		System.out.println();

		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				if(i>j){
					A[i][j]=0;
				}
				System.out.printf("%.3e\t",A[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		//bの出力
		for(int i=0;i<b1.length;i++){
			System.out.printf("%.3e\t",b1[i]);
		}

		System.out.println();
		System.out.println();

		//後退代入
		double c;
		for(int k=A.length-1;k>=0;k--){
			c=0;
			for(int j=k+1;j<A.length;j++){
				c=c+A[k][j]*x[j];
			}
			x[k]=(b1[k]-c)/A[k][k];
		}

		for(int i=0;i<x.length;i++){
			System.out.printf("%.3e\t",x[i]);
		}
		System.out.println();
		System.out.println();

		System.out.println(b0Inf/b1Inf);
		System.out.println(Calc.vecNormInf(Calc.subVec(x,b))/Calc.vecNormInf(b));


	}

}

package chapter9;

import calc.Calc;
import chapter8.Inv;

public class Pivot {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double[][]A=Inv.makeMat(8);
		System.out.println("A=");
		Calc.printMat(A);
		System.out.println();
		double[][]A_inv=Inv.InvertMatirox(A);
		System.out.println("A_inv=");
		Calc.printMat(A_inv);
		System.out.println();

		double kappa=Calc.matNorm1(A_inv)*Calc.matNorm1(A);
		System.out.println("条件数kは"+kappa);
		System.out.println();
		double[]b=Inv.makeVec(A);
		System.out.println("b=");
		Calc.printVec(b);
		double[]b1=new double[b.length];
		b1[0]=0.001*b[0];
		double []b2=new double[b.length];
		b2=Calc.addVec(b1, b);
		System.out.println("b2=");
		Calc.printVec(b2);

		double[]x1=new double[A.length];//x_1*
		double a;//中間変数
		for(int k=0;k<A.length-1;k++){
			int pivot=k;
			double max=Math.abs(A[k][k]);
			for(int m=k+1;m<A.length;m++){
				if(max<Math.abs(A[m][k])){
					max=Math.abs(A[m][k]);
					pivot=m;
				}
			}
			if(pivot!=k){
				System.out.println("pivot="+pivot);
				double[] temp1=A[pivot];
				A[pivot]=A[k];
				A[k]=temp1;
				double temp2=b2[pivot];
				System.out.println("temp2="+temp2);
				b2[pivot]=b2[k];
				System.out.println("b2[pivot]="+b2[pivot]);
				b2[k]=temp2;
				System.out.println("b2[k]="+b2[k]);
			}
			for(int i=k+1;i<A.length;i++){
				a=A[i][k]/A[k][k];//中間変数の更新
				for(int j=k+1;j<A.length;j++){
					A[i][j]=A[i][j]-a*A[k][j];//行列Ａの(i,j)成分A[i-1][j-1]を更新
				}
				b2[i]=b2[i]-a*b2[k];//行列bのi成分b[i-1]を更新
			}
			System.out.println();
			System.out.println((k+1)+"回目のA=");
			Calc.printMat(A);
			System.out.println();
			System.out.println((k+1)+"回目のb=");
			Calc.printVec(b2);
			System.out.println();
		}

		System.out.println();

		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.printf("%.3e\t",A[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		//後退代入
		double c;
		for(int k=A.length-1;k>=0;k--){
			c=0;
			for(int j=k+1;j<A.length;j++){
				c=c+A[k][j]*x1[j];
			}
			x1[k]=(b2[k]-c)/A[k][k];
		}
		System.out.println("近似解x1は");
		for(int i=0;i<x1.length;i++){
			System.out.printf("%.3e\t",x1[i]);
		}
		System.out.println();

		double[]x={1,1,1,1,1,1,1,1};
		double []Dx=Calc.subVec(x, x1);
		System.out.println("Δx=");
		Calc.printVec(Dx);
		System.out.println();
		System.out.println("解の誤差は");
		System.out.println(Calc.vecNorm1(Dx)/Calc.vecNorm1(x));
		System.out.println("誤差の上限は");
		System.out.println((kappa*Calc.vecNorm1(b1))/Calc.vecNorm1(b));
	}

}

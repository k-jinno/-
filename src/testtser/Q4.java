package testtser;

import calc.Calc;

public class Q4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int N=7;
		int M=200;
		double w,e=1e-8,MM=50;
		double[][]A=new double[N][N];
		double[]d=new double[N];
		int a=3;
			double[]x={1,1,1,1,1,1,1};
			double[]b;
			b=Calc.copyVec(x);
			Calc.printVec(b);
			for(int s=1;s<50;s++){
				w=s*2.0/MM;
				for(int q=0;q<x.length;q++){
					x[q]=1.0;
				}
				b=Calc.copyVec(x);
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(i==j){
							A[i][j]=a;
						}else if(i==j-1||i==j+1||i==j+2){
							A[i][j]=-1.0;
						}else{
							A[i][j]=0;
						}
					}

				}
				System.out.print("s="+s+"\t");
			d=Calc.SOR(A, x, b,w,e,M);
			System.out.println();

	}
	}

}

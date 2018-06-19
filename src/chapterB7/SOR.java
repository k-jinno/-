package chapterB7;

import calc.Calc;

public class SOR {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int N=5,M=1000;
		double w,e=1e-10,MM=100;
		double[][]A=new double[N][N];
		double[]d=new double[N];
		int a=2;
		w=2.0/(1.0+Math.sqrt(1.0-Math.pow(Math.sqrt(3.0)/2.0, 2.0)));
		double[]x={1,1,1,1,1};
		double[]b;
		b=Calc.copyVec(x);
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(i==j){
					A[i][j]=a;
				}else if(i==j-1||i==j+1){
					A[i][j]=-1.0;
				}else{
					A[i][j]=0;
				}
			}

		}
		d=Calc.SOR(A, x, b,w,e,M);
		System.out.println();
		for(int s=1;s<100;s++){
			w=s*2.0/MM;
			for(int q=0;q<x.length;q++){
				x[q]=1.0;
			}
			b=Calc.copyVec(x);
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(i==j){
						A[i][j]=a;
					}else if(i==j-1||i==j+1){
						A[i][j]=-1.0;
					}else{
						A[i][j]=0;
					}
				}

			}
			System.out.println("s="+s);
			d=Calc.SOR(A, x, b,w,e,M);
			System.out.println();
		}

	}

}

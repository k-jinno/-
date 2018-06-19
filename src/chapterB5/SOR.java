package chapterB5;

import calc.Calc;

public class SOR {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int N=10,M=500;
		double w=1.3,e=1e-8;
		double[][]A=new double[N][N];
		double[]d=new double[N];
		for(int a=2;a<9;a++){
			double[]x={1,1,1,1,1,1,1,1,1,1};
			double[]b;
			b=Calc.copyVec(x);
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(i==j){
						A[i][j]=a;
					}else if(i==j-1||i==j-2||i==j+1||i==j+2){
						A[i][j]=-1;
					}else{
						A[i][j]=0;
					}
				}

			}
			Calc.printMat(A);
			d=Calc.SOR(A, x, b,w,e,M);
			System.out.printf("近似解の第1成分は%.5e",d[0]);
			System.out.println();



		}

	}

}

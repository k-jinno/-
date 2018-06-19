package testtser;

import calc.Calc;

public class Q3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int N=7;
		double[][]A=new double[N][N];
		int a=3;
			double[]x={1,1,1,1,1,1,1};
			double[]b;
			b=Calc.copyVec(x);
			Calc.printVec(b);
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					if(i==j){
						A[i][j]=a;
					}else if(i==j-1||i==j+1||i==j+2){
						A[i][j]=-1;
					}else{
						A[i][j]=0;
					}
				}
			}
			Calc.printMat(A);
			x=Calc.GaussSeidel(A, x, b);
			Calc.printVec(x);
			System.out.printf("近似解の第1成分は%.5e",x[0]);
			System.out.println();

	}

}

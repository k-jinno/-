package testtser;

import calc.Calc;

public class Q2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double[][]A={{4,-1,-1,0,0},{-1,4,-1,-1,0},{-1,-1,4,-1,-1},{0,-1,-1,4,-1},{0,0,-1,-1,4}};
		double s;
		double[][] L=new double[5][5];
		double[]x=new double[A.length];
		double[]b={1,1,1,1,1};
		//コレスキー分解
		for(int j=0;j<A.length;j++){
			for(int i=j;i<A.length;i++){
				s=0;
				for(int k=0;k<j;k++){
					s=s+L[i][k]*L[j][k];
				}
				if(i==j){
					L[i][i]=Math.sqrt(A[i][i]-s);
				}else{
					L[i][j]=(A[i][j]-s)/L[j][j];
				}
			}
		}
		Calc.printMat(L);//対角成分1じゃないから反復法そのまま使えないよ
		//代入

		double []y=Calc.Forward_sub(L, b);
		x=Calc.Cholesky_Backward_sub(L, y);
		System.out.println("xの値は");
		Calc.printVec(x);
		/*後退代入
		public static double []Backward_sub(double A[][],double y[]){
			double c;
			double []x=new double[y.length],y1=copyVec(y);
			double[][]A1=copyMat(A);
			for(int k=A.length-1;k>=0;k--){
				c=0;
				for(int j=k+1;j<A.length;j++){
					c=c+A1[k][j]*x[j];
				}
				x[k]=(y1[k]-c)/A1[k][k];
			}
			return x;
		}
		*/

	}

}

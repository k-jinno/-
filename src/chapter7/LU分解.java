package chapter7;

import calc.Calc;

public class LU分解 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//A,b.xの出力
		double[][] A=new double[10][10];
		double[]b=new double[A.length];
		double[]x=new double[A.length];
		double[]y=new double[A.length];
		for(int i=0;i<A.length;i++){
			b[i]=i+1;
			for(int j=0;j<A[0].length;j++){
				if(i==j){
					A[i][j]=2;
				}else if(j==i-1||j==i+1){
					A[i][j]=-1;
				}else{
					A[i][j]=0;
				}
			}
		}
		//前進消去
		double a;//中間変数
		for(int k=0;k<A.length-1;k++){
			for(int i=k+1;i<A.length;i++){
				a=A[i][k]/A[k][k];//中間変数の更新
				A[i][k]=a;
				for(int j=k+1;j<A.length;j++){
					A[i][j]=A[i][j]-a*A[k][j];//行列Ａの(i,j)成分A[i][j]を更新
				}
			}
		}
		//LとUに分解
		double[][] L=new double[10][10];
		double[][] U=new double[10][10];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A.length;j++){
				if(i<j){
					L[i][j]=0;
					U[i][j]=A[i][j];
				}else if(i==j){
					L[i][j]=1;
					U[i][j]=A[i][j];
				}else {
					L[i][j]=A[i][j];
					U[i][j]=0;
				}
			}
		}
		System.out.println("Lの出力");
		Calc.printMat(L);
		System.out.println("Uの出力");
		Calc.printMat(U);

		//Aの行列式(|A|=|LU|=|L||U|)
		double sum1=1;
		double sum2=1;
		double sum3=1;
		double sum4=1;
		for(int i=0;i<A.length;i++){
			sum1=sum1*L[i][i];
			sum2=sum2*U[i][i];
		}
		double sum=sum1*sum2;
		System.out.println("Aの行列式の出力");
		System.out.println(sum);
		//前進代入
		double temp;
		for(int k=0;k<y.length;k++){
			temp=0;
			for(int j=0;j<k;j++){
				temp=temp+A[k][j]*y[j];
			}
			y[k]=b[k]-temp;
		}
		System.out.println("yの出力");
		Calc.printVec(y);

		//後退代入
		double c;
		for(int k=A.length-1;k>=0;k--){
			c=0;
			for(int j=k+1;j<A.length;j++){
				c=c+A[k][j]*x[j];
			}
			x[k]=(y[k]-c)/A[k][k];
		}
		System.out.println("xの出力");
		Calc.printVec(x);
	}

}

package chapter6;

public class ガウス消去法 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//行列Aの生成
		double[][] A=new double[5][5];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				A[i][j]=1.0/(double)((i+1.0)+(j+1.0));
			}
		}

		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				System.out.printf("%.3e\t",A[i][j]);
			}
			System.out.println();
		}

		//前進消去
		double[]x=new double[A.length];
		double[]b={1,1,1,1,1};
		double a;//中間変数
		for(int k=0;k<A.length-1;k++){
			for(int i=k+1;i<A.length;i++){
				a=A[i][k]/A[k][k];//中間変数の更新
				for(int j=k+1;j<A.length;j++){
					A[i][j]=A[i][j]-a*A[k][j];//行列Ａの(i,j)成分A[i][j]を更新
				}
				b[i]=b[i]-a*b[k];//ベクトルbのi成分b[i]を更新
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
		for(int i=0;i<b.length;i++){
			System.out.printf("%.3e\t",b[i]);
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
			x[k]=(b[k]-c)/A[k][k];
		}

		for(int i=0;i<x.length;i++){
			System.out.printf("%.3e\t",x[i]);
		}



	}



}

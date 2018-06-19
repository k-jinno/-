package chapter10;

import calc.Calc;

public class Jacobi {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double[][]A={{6,1,1,1,0},{1,7,1,1,1},{0,1,8,1,1},{0,0,1,9,1},{0,0,0,1,10}};
		double []b={9,11,11,11,11};
		double []x=new double[A.length];
		for(int i=0;i<x.length;i++){
			x[i]=10.0;
		}
		double []xtemp;

		double e=Math.pow(10, -10),temp;
		int M=100,m=0;
		while(true){

			xtemp=Calc.copyVec(x);
			for(int i=0;i<A.length;i++){
				temp=0;
				for(int j=0;j<A.length;j++){
					if(i!=j){
						temp=temp+A[i][j]*xtemp[j];//xtempをｘに変えるとGaussSeidel
					}
				}
				x[i]=(b[i]-temp)/(double)(A[i][i]);
			}
			System.out.print(m+"回目のx=");
			Calc.printVec(x);
			if(Calc.vecNorm2(Calc.subVec(xtemp, x))/Calc.vecNorm2(x)<=e){
				System.out.print("近似解は");
				Calc.printVec(x);
				System.out.println();
				System.out.println("反復回数は"+m);
				break;
			}
			if(M==m){
				System.out.println("収束しない");
				break;
			}
			m++;

		}


	}

}

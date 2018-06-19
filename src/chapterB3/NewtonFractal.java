package chapterB3;

import calc.Calc;

public class NewtonFractal {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x[]={-1.0,1.0};
		double e=1e-10;
		double []temp;
		int i=0,M=50;
		while(true){
			if(i==M){
				System.out.println("収束しない");
				break;
			}
			temp=x;
			x=Calc.addVec(temp, Calc.Pivot(J(x[0],x[1]),Calc.scalarMultiple(-1,F(x[0],x[1]))));
			if(Calc.vecNormInf(Calc.subVec(x, temp))<e){
				System.out.println("反復回数は"+i+",近似解は");
				Calc.printVec(x);
				break;
			}
			Calc.printVec(x);
			i++;
		}

	}

	public static double[] F(double x1,double x2){
		double[] F={x1*x1+x2*x2-1,Math.sin(x1)+x2*x2};
		return F;
	}

	public static double[][] J(double x1,double x2){
		double[][]J={{2*x1,2*x2},{Math.cos(x1),2*x2}};
		return J;
	}

}

package chapterB3;

import calc.Calc;

public class NewtonFractal2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x[]={-1,-1,1};
		double e=1e-10;
		double []temp;
		int i=0,M=50;
		while(true){
			if(i==M){
				System.out.println("収束しない");
				break;
			}
			temp=x;
			x=Calc.addVec(temp, Calc.Pivot(J(x[0],x[1],x[2]),Calc.scalarMultiple(-1,F(x[0],x[1],x[2]))));
			if(Calc.vecNormInf(Calc.subVec(x, temp))<e){
				System.out.println("反復回数は"+i+",近似解は");
				Calc.printVec(x);
				break;
			}
			i++;
		}

	}

	public static double[] F(double x1,double x2,double x3){
		double[] F={x1*x1+x2*x2+x3*x3-1,Math.sin(x1)+x2*x2+x3*x3,x1*x1+Math.sin(x2)+x3*x3};
		return F;
	}

	public static double[][] J(double x1,double x2,double x3){
		double[][]J={{2*x1,2*x2,2*x3},{Math.cos(x1),2*x2,2*x3},{2*x1,Math.cos(x2),2*x3}};
		return J;
	}

}

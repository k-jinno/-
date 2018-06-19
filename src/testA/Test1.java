package testA;

import calc.Calc;
import chapter8.Inv;

public class Test1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//1.4

		System.out.printf("%.3e\t",Calc.matNorm1(Inv.makeMat(10)));

		//2.1
		float Sn=0;
		float temp;
		int i=1;
		while(true){
			temp=Sn;
			Sn=Sn+(float)(1.0/Math.pow(i, 4));
			if(temp==Sn){
				System.out.println("n="+(i-1)+",Sn="+Sn);
				break;
			}
			i++;
		}

		//3.2
		double x0=5.0;
		double k=50;
		double e=1E-10;
		int i1=0;

		while(true){
			if(Math.abs(f(x0))<e){
				double a=f(x0);
				System.out.println(i1);
				System.out.printf("%.16e\t",x0);
				break;
			}else if(i1==k){
				System.out.println("収束しない");
			}else{
				i1++;
			System.out.println(x0);
			x0=x0-f(x0)/Df(x0);
			}

		}

		//4
		double[][] A=new double[5][5];
		for(int i11=0;i11<A.length;i11++){
			for(int j=0;j<A.length;j++){
				A[i11][j]=(double)(0.1/(double)(i11+j+2.0))+10.0*Math.sin(i11-j);
			}
		}
		double[] x={1.0,1.0,1.0,1.0,1.0};
		double[]b=Calc.matVec(A, x);
		System.out.println("b=");
		Calc.printVec(b);
		double[]x1=Calc.Gaus(A, b);
		System.out.println("x1=");
		Calc.printVec(x1);
		System.out.println("2のノルム");
		System.out.printf("%.3e\t",Calc.vecNorm1(Calc.subVec(x,x1))/Calc.vecNorm1(x));
		double[]x2=Calc.Pivot(A, b);
		System.out.println("x2=");
		Calc.printVec(x2);
		System.out.println("3のノルム");
		System.out.printf("%.3e\t",Calc.vecNorm1(Calc.subVec(x,x2))/Calc.vecNorm1(x));
		System.out.println("条件数");
		double kappa=Inv.kappa(A, Calc.InvertMatirox(A));
		System.out.printf("%.3e\t",kappa);
		double []db=new double[x.length];
		db[0]=0.001*b[0];
		double []b2=Calc.addVec(b, db);
		double[]x3=Calc.Pivot(A, b2);
		System.out.println("x3=");
		Calc.printVec(x3);
		System.out.println("4のノルム");
		double x4=Calc.vecNorm1(Calc.subVec(x,x3))/Calc.vecNorm1(x);
		System.out.println(x4);
		System.out.printf("%.3e\t",x4);
		double b4=(Calc.vecNorm1(Calc.residual(A, x3, b)))/Calc.vecNorm1(b);
		System.out.printf("%.3e\t",b4);


	}


	public static double f(double x){
		return x*x*x-3.0*x*x+4.0;
	}

	public static double Df(double x){
		return 3.0*x*x-6.0*x;
	}

	}



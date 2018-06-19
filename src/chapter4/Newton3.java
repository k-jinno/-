package chapter4;

public class Newton3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=6;
		double k=1000000;
		double e=1E-6;

		for(int i=0;i<k;i++){
			System.out.println(i);
			if(Math.abs(f(x0))<e){
				System.out.println("初期値は6,"+"近似解は"+x0+",反復回数は"+i);
				double a=f(x0);
				System.out.println(a);
				break;
			}

			System.out.println(x0);
			x0=x0-f(x0)/Df(x0);
			System.out.println(i);
		}

	}

	public static double f(double x){
		return Math.cos(2*x)+2*Math.sin(x)+1/x;
	}

	public static double Df(double x){
		return -2*Math.sin(2*x)+2*Math.cos(x)-1/(x*x);
	}

	}



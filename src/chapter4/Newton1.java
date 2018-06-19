package chapter4;

public class Newton1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=2;
		double e=1E-12;
		double temp;
		int i=0;

		while(true){
			temp=x0;
			x0=x0-f(x0)/Df(x0);
			i++;
			if(Math.abs(x0-temp)<e){
				break;
			}

		}
		System.out.println("初期値は2,近似解は"+x0+",反復回数は"+i);
		System.out.println("初期値は2,近似解は"+temp+",反復回数は"+i);

		double a=f(x0);
		double b=f(temp);
		System.out.println(a);
		System.out.println(b);


	}

	public static double f(double x){
		return Math.pow(Math.E,x)-2*x-1;
	}

	public static double Df(double x){
		return Math.pow(Math.E,x)-2;
	}

}

package chapter4;

public class Newton2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=-6.0;
		double e=1E-10;
		double temp;
		int i=0;

		while(true){
			temp=x0;
			x0=temp-f(temp)/Df(temp);
			i++;
			System.out.println(i+"回目は"+x0);
			if(Math.abs((x0-temp))/Math.abs(x0)<e){
				break;
			}

		}
		System.out.println("初期値は-6,近似解は"+x0+",反復回数は"+i);
		double a=f(x0);
		double b=f(temp);
		System.out.println(a);
		System.out.println(b);

	}

	public static double f(double x){
		return Math.exp(-x/2)*Math.sin(x)-5*x;
	}

	public static double Df(double x){
		return Math.exp(-x/2)*((-1.0/2.0)*Math.sin(x)+Math.cos(x))-5;
	}

}



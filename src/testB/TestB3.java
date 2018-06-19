package testB;

public class TestB3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=5.0;
		double k=50;
		double e=1E-10;
		int i1=0;

		while(true){
			if(Math.abs(f(x0))<e){
				double a=f(x0);
				System.out.println(i1);
				System.out.printf("%.10e\t",x0);
				break;
			}else if(i1==k){
				System.out.println("収束しない");
			}else{
				i1++;
			System.out.println(x0);
			x0=x0-f(x0)/Df(x0);
			}

		}

	}
	public static double f(double x){
		return x*x*x-x*x-8.0*x+12.0;
	}

	public static double Df(double x){
		return 3.0*x*x-2.0*x-8.0;
	}


}

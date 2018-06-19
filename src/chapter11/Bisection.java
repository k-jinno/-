package chapter11;

public class Bisection {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println(12/Math.log10(2));

		double a=-0.9,b=1.1,e=1.0E-12,c=(a+b)/2.0,n=0;
		while(true){
			if(Math.abs(b-a)/2.0<e){
				break;
			}
			n++;
			c=(a+b)/2.0;
			if(fx(a)*fx(c)>0){
				a=c;
			}else if(fx(a)*fx(c)<0){
				b=c;
			}else{
				break;
			}

		}
		System.out.println("解は"+c+",反復回数は"+n);

	}

	public static double fx(double x){
		return Math.exp(x)-2.0*x-1.0;
	}

}

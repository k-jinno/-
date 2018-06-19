package testB;

public class TestB2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double b=1.0,a=Math.pow(10, -8),c=Math.pow(10, -5);
		double r=Math.sqrt(b*b-4*a*c);
		double x1=(-b+r)/(2*a),x2=(-b-r)/(2*a);
		System.out.printf("%.10e\t",x1);
		System.out.printf("%.10e\t",x2);
		double x=x1*x2;
		double d=c/a;
		System.out.printf("%.10e\t",x);
		System.out.printf("%.10e\t",d);


	}

}

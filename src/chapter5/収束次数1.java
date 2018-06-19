package chapter5;

public class 収束次数1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		/*一般に，{xk} が α に収束し，適当な p ≥ 1, C > 0 に対して
lim k→∞  |xk+1 − α|
           ___________=C
           |xk − α|^p
が成り立つとき，p を 収束次数 という．

		 *
		 */

		double x0=-5;
		double x1=5;
		double max_i=50;
		double e=1E-10;
		int i=0;
		int t=0;
		double ek;

		while(true){
			if(6-i<5){
				ek=Math.abs(x0+3);
				System.out.print("反復回数"+i+"回での絶対誤差は");
				System.out.printf("%.3e\t",ek);
				System.out.println();
			}
			if(Math.abs(f(x0))<=e){
				System.out.println("初期値30での近似解は"+x0+",反復回数は"+i);
				break;
			}

			if(i>=max_i){
				System.out.println("この初期値では収束しない");
				break;
			}

			x0=x0-f(x0)/Df(x0);
			i++;

		}

		while(true){
			if(Math.abs(f(x1))<=e){
				System.out.println("初期値-30での近似解は"+x1+",反復回数は"+t);
				break;
			}

			if(t>=max_i){
				System.out.println("この初期値では収束しない");
				break;
			}

			x1=x1-f(x1)/Df(x1);
			t++;
			if(20-t<5){
				ek=Math.abs(x1-2);
				System.out.print("反復回数"+t+"回での絶対誤差は");
				System.out.printf("%.3e\t",ek);
				System.out.println();
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

package chapterB2;

public class Newton3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=3;
		double e=1E-12;
		double temp=0;
		int M=200,i=1;
		double []X=new double[M];


		while(true){
			temp=x0;
			x0=x0-f(x0)/Df(x0);
			X[i-1]=x0;

			if(Math.abs(f(x0))<e){
				int m=i;
				System.out.println("以下誤差を出力");
				for(int j=0;j<m;j++){
					//System.out.println(j);
					System.out.println(Math.abs(X[j]-X[m-1]));
				}
				break;
			}
			i++;

		}
		System.out.println("初期値は2,近似解は"+x0+",反復回数は"+i);
		System.out.println("初期値は2,近似解は"+temp+",反復回数は"+i);

		double a=f(x0);
		double b=f(temp);
		System.out.println(a);
		System.out.println(b);



	}

	public static double f(double x){
		return x*x*x*x*x-100;
	}

	public static double Df(double x){
		return 5*x*x*x*x;
	}

}

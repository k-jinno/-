package chapterB2;

public class Secant {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=2.5,x1=3.0,e=1E-12,x;
		int M=200,i=1;
		double []X=new double[M];

		//Secantの反復式
		while(i<M){
			x=x1-f(x1)*(x1-x0)/(f(x1)-f(x0));
			x0=x1;
			x1=x;
			X[i-1]=x;
			if(Math.abs(f(x))<e){
				System.out.println("反復回数は"+i+"、近似解は"+x);
				for(int j=1;j<i;j++){

					System.out.println(Math.abs(X[j-1]-X[i-1]));

				}
				break;
			}
			i++;
		}

	}

	public static double f(double x){
		return Math.exp(x)-3*x;
	}

}

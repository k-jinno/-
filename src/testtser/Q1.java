package testtser;

public class Q1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=2.5,x1=3.0,e=1E-12,x=0;
		int M=200,i=1;
		double []X=new double[M];
		double []Y=new double[11];

		//Secantの反復式
		while(i<M){
			x=x1-f(x1)*(x1-x0)/(f(x1)-f(x0));
			x0=x1;
			x1=x;
			X[i-1]=x;
			if(Math.abs(f(x))<e){
				System.out.println("反復回数は"+i+"、近似解は"+x);
				for(int j=1;j<i;j++){
					System.out.println("反復回数"+j+"の近似解は"+X[j-1]);
					System.out.println(Math.abs(X[j-1]-X[i-1]));
					Y[j-1]=Math.abs(X[j-1]-X[i-1]);
					if(j>1){
						System.out.println("収束次数は");
						System.out.println(Math.log(Y[j-1])/Math.log(Y[j-2]));
					}


				}
				break;
			}
			i++;
		}
		System.out.println((1/x)+Math.log(x)+Math.exp(x));

	}

	public static double f(double x){
		return (1/x)-(1/(x*x))+Math.exp(x);
	}




}

package chapterB2;

public class Parallelchord {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x0=2.5,e=1E-12,x;
		int M=200,i=1;
		double []X=new double[M];

		//parallelchordの反復式
		double xp=x0;
		while(true){
			x=xp-(f(xp)/Df(x0));
			xp=x;
			X[i-1]=x;
			if(Math.abs(f(x))<e){
				System.out.println("反復回数は"+i+"、近似解は"+x);
				for(int j=1;j<i;j++){
					System.out.println(Math.abs(X[j-1]-X[i-1]));
				}
				break;
			}else if(i==M){
				System.out.println("収束しない");
				for(int j=1;j<i;j++){
					System.out.println("反復回数"+j+"での近似解は"+X[j]);
					System.out.println("そのときの誤差は"+Math.abs(X[j-1]-X[i-1]));
				}
				break;
			}
			i++;
		}

	}

	public static double f(double x){
		return Math.exp(x)-3*x;
	}

	public static double Df(double x){
		return Math.exp(x)-3;
	}

}

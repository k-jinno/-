package chapter3;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		//1
		double a=0.1;
		double b=0.3;
		double c=0.4;
		System.out.println((a+b)+c);
		System.out.println(a+(b+c));

		//2
		double x=1E-7;
		double fx1=(1-Math.cos(x))/(x*x);
		double fx2=Math.pow(Math.sin(x), 2)/(x*x*(1+Math.cos(x)));
		System.out.println(fx1);
		System.out.println(fx2);

		//3
		float n1=500f,n2=5000f,n3=50000f;
		float s=0f;
		for(float i=1;i<n1+1;i++){
			s=s+1f/(i*i);
		}
		System.out.println("n=500の時のS1の値は"+s);

		s=0f;
		for(float i=1;i<n2+1;i++){
			s=s+1f/(i*i);
		}
		System.out.println("n=5000の時のS1の値は"+s);

		s=0f;
		for(float i=1;i<n3+1;i++){
			s=s+1f/(i*i);
		}
		System.out.println("n=50000の時のS1の値は"+s);

		s=0f;
		float i=1f;
		float temp;
		while(true){
			temp=s;
			s=s+1f/(i*i);
			if(temp==s){
				break;
			}
			i++;
		}
		System.out.println("Nの値は"+(i-1));


	}

}

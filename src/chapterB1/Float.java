package chapterB1;

public class Float {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		float xf=0.2f;
		//1
		float yf=0;
		for(int i=0;i<5000;i++){
			yf=yf+xf;
		}
		System.out.println("0.2fを5000回足すと"+yf);
		System.out.printf("%f\n",yf);

		//2
		System.out.println("0.2f*5000="+(xf*5000f));

		//3
		double x=0.2;
		double y=0;
		for(int i=0;i<5000;i++){
			y=y+x;
		}
		System.out.println("0.2を5000回足すと"+y);

		//4
		System.out.println("0.2*5000="+(x*5000));

		float af=3.8f,x0f=0.6f,xnf=0f;
		double a=3.8,x0=0.6,xn=0;

		for(int i=1;i<50;i++){
			xnf=af*x0f*(1-x0f);
			x0f=xnf;
			//System.out.println("x"+i+"="+xnf);
			if(i==2||i==5||i==10||i==15||i==20||i==25||i==30){
				System.out.println("x"+i+"f="+xnf);
			}
		}

		for(int i=1;i<50;i++){
			xn=a*x0*(1-x0);
			x0=xn;
			if(i==5||i==10||i==15||i==20||i==25||i==30){
				System.out.println("x"+i+"="+xn);
			}
		}

		 af=3.5f;
		 x0f=0.6001f;
		 xnf=0f;
		 a=3.5;
		 x0=0.6001;
		 xn=0;

		for(int i=1;i<50;i++){
			xnf=af*x0f*(1-x0f);
			x0f=xnf;
			//System.out.println("x"+i+"="+xnf);
			if(i==2||i==5||i==10||i==15||i==20||i==25||i==30){
				System.out.println("x"+i+"f="+xnf);
			}
		}

		for(int i=1;i<50;i++){
			xn=a*x0*(1-x0);
			x0=xn;
			if(i==5||i==10||i==15||i==20||i==25||i==30){
				System.out.println("x"+i+"="+xn);
			}
		}

	}


}

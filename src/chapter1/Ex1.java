package chapter1;

public class Ex1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//問題1
	    double a=Math.sqrt(Math.PI);
	    double b=Math.abs(Math.cos(3.0/4.0)-Math.pow(Math.E, 4));
	    System.out.println(a);
	    System.out.println(b);

	    //問題2
	    long f0=0;
	    long f1=1;
	    long f;
	    for(int i=0;i<49;i++){
	    	f=f0+f1;
	    	f0=f1;
	    	f1=f;
	    	System.out.println("f"+(i+2)+"="+f);
	    }

	    //問題3
	    double an=1.0/3.0;
	    int n=1;
	    double temp=an;
	    double s=an;
	    while(an>1E-5){
	    	an=an*temp;
	    	s=s+an;
	    	n++;
	        System.out.println(an+","+n);
	       }
		    System.out.println("nの値は"+n+",そのときの和は"+s);

		//問題4
		double[][]A=new double[3][3];
		double[][]B=new double[3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				A[i][j]=(i+1)+(j+1);
				B[i][j]=Math.sqrt((i+1)*(j+1));
			}
		}
		System.out.println("Aの成分は");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			System.out.print(A[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("Bの成分は");
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			System.out.print(B[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("Cの成分は");
		double [][]C=new double [3][3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
			C[i][j]=A[i][j]+B[i][j];
			System.out.print(C[i][j]+"\t");
			}
			System.out.println();
		}


	}

}

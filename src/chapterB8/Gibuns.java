package chapterB8;

import calc.Calc;

public class Gibuns {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		int m=1,n=5,M=200;
		double e=1.0e-10;


	/*for(int i=0;i<A.length;i++){
			for(int j=0;j<A.length;j++){
				if(i==j){
					A[i][j]=n+i+1;
				}else if(Math.abs(i-j)>0&&Math.abs(i-j)<3){
					A[i][j]=-(i+j-n+2);
				}else{
					A[i][j]=0;
				}
			}
		}*/
	double [][]A={{2,-1,0,0},{-1,2,0,0},{0,0,4,1},{0,0,1,4}};
		Calc.printMat(A);
		while(true){
			double b,c,s;
			int temp[]=new int[2];
			double [][]Temp=new double[n][n];
			double[][]R=new double[n][n];
			double max=0;
			for(int i=0;i<A.length;i++){
				for(int j=0;j<A.length;j++){
					if(i!=j&&Math.abs(A[i][j])>max){
						temp[0]=i;
						temp[1]=j;
						max=Math.abs(A[i][j]);
					}
				}
			}
			if(max<e){
				System.out.println("収束して、その固有値は");
				for(int t=0;t<A.length;t++){
					System.out.print(A[t][t]+"\t");
				}
				break;
			}
			System.out.println("Aの絶対値最大の成分はA["+ temp[0] +"]["+ temp[1] +"]");
			b=(A[temp[0]][temp[0]] - A[temp[1]][temp[1]]) / 2.0;
			if(A[temp[0]][temp[0]] - A[temp[1]][temp[1]]>=0){
				c=Math.sqrt((1 + b /Math.sqrt((b * b + A[temp[0]][temp[1]] * A[temp[0]][temp[1]]))) / 2.0);
				s=A[temp[0]][temp[1]]/(2*c*Math.sqrt(b*b+A[temp[0]][temp[1]]*A[temp[0]][temp[1]]));

			}else{
				c=Math.sqrt((1-b/Math.sqrt((b*b+A[temp[0]][temp[1]]*A[temp[0]][temp[1]])))/2.0);
				s=-A[temp[0]][temp[1]]/(2*c*Math.sqrt(b*b+A[temp[0]][temp[1]]*A[temp[0]][temp[1]]));

			}
			for(int i=0;i<A.length;i++){
				for(int j=0;j<A.length;j++){
					if((i==temp[0]&&j==temp[0])||(i==temp[1]&&j==temp[1])){
						R[i][j]=c;
					}else if(i==temp[1]&&j==temp[0]){
						R[i][j]=s;
					}else if(i==temp[0]&&j==temp[1]){
						R[i][j]=-s;
					}else if(i==j){
						R[i][j]=1;
					}
				}
			}
			System.out.println("ギブンス回転行列は");
			Calc.printMat(R);
			Temp=Calc.copyMat(A);
			for(int i=0;i<A.length;i++){
				for(int j=0;j<A.length;j++){
					if((i==temp[0]&&j==temp[1])||(i==temp[1]&&j==temp[0])){
						A[i][j]=(c*c-s*s)*Temp[temp[0]][temp[1]]+c*s*(Temp[temp[1]][temp[1]]-Temp[temp[0]][temp[0]]);
					}else if(i==temp[0]&&j==temp[0]){
						A[i][j]=c*c*Temp[temp[0]][temp[0]]+2*c*s*Temp[temp[0]][temp[1]]+s*s*Temp[temp[1]][temp[1]];
					}else if(i==temp[1]&&j==temp[1]){
						A[i][j]=s*s*Temp[temp[0]][temp[0]]-2*c*s*Temp[temp[0]][temp[1]]+c*c*Temp[temp[1]][temp[1]];
					}else if(i==temp[0]){
						A[i][j]=c*Temp[temp[0]][j]+s*Temp[temp[1]][j];
					}else if(j==temp[0]){
						A[i][j]=c*Temp[temp[0]][i]+s*Temp[temp[1]][i];
					}else if(i==temp[1]){
						A[i][j]=s*Temp[temp[0]][j]-c*Temp[temp[1]][j];
					}else if(j==temp[1]){
						A[i][j]=s*Temp[temp[0]][i]-c*Temp[temp[1]][i];
					}else{
						A[i][j]=Temp[i][j];
					}
				}
			}
			System.out.println("更新したAは");
			Calc.printMat(A);
			m++;
			if(m==M){
				System.out.println("収束しない");
			}
		}
	}
}

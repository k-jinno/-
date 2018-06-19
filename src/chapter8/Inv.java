package chapter8;

import calc.Calc;

public class Inv {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		/*(2) の結果より，得られた近似解に対する相対残差 ∞-ノルムは 10−17 程度であり，精度の良
い近似解が得られたように思える．しかし，相対誤差 ∞-ノルムは 10−10 程度であり，近似解の
精度は必ずしも良いとは言えない．このような残差と誤差の差異は A の条件数に依るものであ
り，理論的に以下の関係式が成り立つ．
∥x* − x˜∥_∞			∥b − Ax˜∥∞
_____________≤ κ∞(A) ______________
∥x∗∥∞				∥b∥∞

(1) より，κ∞(A) ≈ 107 であるため，右辺の相対残差 ∞-ノルムが 10−17 程度であっても，左辺
の上限は 10−10 程度となり，相対誤差 ∞-ノルムはこの分だけ大きくなる可能性がある．この
ことから，(2) では残差が小さくなるにもかかわらず，誤差は大きくなってしまったと考えられ
る．
		 *
		 */
		//問い1
//		double[][]A4=makeMat(4);
//		double[][]A8=makeMat(8);
//		double[][]A12=makeMat(12);
		double[][]A5=makeMat(5);
		InvertMatirox(A5);
		Calc.printMat(A5);
		Calc.printMat(Calc.InvertMatirox(A5));
//		double [][]LU4=LU(A4);
		double [][]LU5=LU(A5);
		System.out.println();

//		InvertMatirox(A4);
//		InvertMatirox(A8);
//		InvertMatirox(A12);
//		System.out.println("A4の出力");
//		Calc.printMat(A4);
//		System.out.println();
//		Calc.printMat(A8);
//		System.out.println();
//		Calc.printMat(A12);
//		System.out.println();
//		Calc.printMat(InvertMatirox(A4));
//		System.out.println();
//		Calc.printMat(InvertMatirox(A8));
//		System.out.println();
//		Calc.printMat(InvertMatirox(A12));
//		System.out.println();
//		System.out.println(Calc.matNormInf(A4));
//		System.out.println(Calc.matNormInf(InvertMatirox(A4)));
//		System.out.println("k_Inf(A4)="+kappa(A4,InvertMatirox(A4)));
//		System.out.println();
//		System.out.println("k_Inf(A8)="+kappa(A8,InvertMatirox(A8)));
//		System.out.println();
//		System.out.println("k_Inf(A12)="+kappa(A12,InvertMatirox(A12)));
//		System.out.println();
//
//		//問い2
//		double []b4=makeVec(makeMat(4));
//		System.out.println("b4の出力");
//		Calc.printVec(b4);
//		double []b8=makeVec(A8);
//		double []b12=makeVec(A12);
		double []b5=makeVec(makeMat(5));
		Calc.printVec(b5);

//		double[]y4=Forward_sub(LU4,b4);
//		Calc.printVec(y4);
//		double[]x4=Backward_sub(LU4,y4);//誤差が発生しない？？
//		Calc.printVec(x4);
//		double[]Ax4=Calc.matVec(A4,x4);
//		Calc.printVec(Ax4);
//		double[]t4=Calc.subVec(b4, Ax4);
//		Calc.printVec(t4);
//		System.out.println("|b4-A4*x|="+Calc.vecNormInf(t4));
		double[]y5=Forward_sub(LU5,b5);
		Calc.printVec(y5);
		double[]x5=Backward_sub(LU5,y5);
		Calc.printVec(x5);
		double[]Ax5=Calc.matVec(A5,x5);
		Calc.printVec(Ax5);
		double[]t5=Calc.subVec(b5, Ax5);
		Calc.printVec(t5);
		System.out.println("|b5-A5*x|="+Calc.vecNormInf(t5));
		System.out.println("|x-x5|="+GosaNolm(Solve(A5, b5)));
//		System.out.println("|b4-A4*x|="+Calc.vecNormInf(Calc.subVec(b4,Calc.matVec(A4,Backward_sub(LU(A4),Forward_sub(LU(A4),b4))))));
//		System.out.println("|x-x4|="+GosaNolm(x4));
//		System.out.println();
//		System.out.println("|b8-A8*x|="+Calc.vecNormInf(Calc.residual(A8, Solve(A8, b8), b8)));
//		System.out.println("|x-x8|="+GosaNolm(Solve(A8, b8)));
//		System.out.println();
//		System.out.println("|b12-A12*x|="+Calc.vecNormInf(Calc.residual(A12, Solve(A12, b12), b12)));
//		System.out.println("|x-x12|="+GosaNolm(Solve(A12, b12)));

	}

	public static double[][]makeMat(int n){
		double[][] A=new double[n][n];
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A.length;j++){
				A[i][j]=1.0/(double)(i+j+1);
			}
		}
		return A;
	}
	public static double[]makeVec(double[][]A){
		double[]x=new double[A.length];
		for(int i=0;i<A.length;i++){
			x[i]=(double)1.0;
		}
		return Calc.matVec(A,x);
	}
	//LU分解
	public static double[][]LU(double a[][]){
	double[][]A=new double[a.length][a.length];
	for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length;j++){
			A[i][j]=a[i][j];
		}
	}
	double α;//中間変数
	for(int k=0;k<A.length-1;k++){
		for(int i=k+1;i<A.length;i++){
			α=A[i][k]/A[k][k];//中間変数の更新
			A[i][k]=α;
			for(int j=k+1;j<A.length;j++){
				A[i][j]=A[i][j]-α*A[k][j];//行列Ａの(i,j)成分A[i][j]を更新
			}
		}
	}
	return A;
}
	//前進代入
	public static double[]Forward_sub(double A[][],double b[]){
		double[]y=new double[b.length];
		double temp;
		for(int k=0;k<y.length;k++){
			temp=0;
			for(int j=0;j<k;j++){
				temp=temp+A[k][j]*y[j];
			}
			y[k]=b[k]-temp;
		}
		return y;
	}
	//後退代入
	public static double []Backward_sub(double A[][],double y[]){
		double c;
		double []x=new double[y.length];
		for(int k=A.length-1;k>=0;k--){
			c=0;
			for(int j=k+1;j<A.length;j++){
				c=c+A[k][j]*x[j];
			}
			x[k]=(y[k]-c)/A[k][k];
		}
		return x;
	}

	public static double[]Solve(double[][]A,double[]b){
		return Backward_sub(LU(A),Forward_sub(LU(A),b));
	}

	public static double[][] InvertMatirox(double a[][]){
		double[][]A_inv=new double[a.length][a.length];
		double[][]A=LU(a);
		double[]y=new double[a.length];
		double []x=new double[a.length];
		for(int i=0;i<a.length;i++){
			double []e_i=new double[a.length];
			e_i[i]=1;
			y=Forward_sub(A,e_i);
			x=Backward_sub(A,y);
			for(int j=0;j<a.length;j++){
				A_inv[j][i]=x[j];
			}
		}
		return A_inv;
	}
	public static double kappa(double[][]A,double[][]A_inv){
		return Calc.matNorm1(A_inv)*Calc.matNorm1(A);
	}


	public static double GosaNolm(double[] x){
		double[]x1=new double[x.length];
		for(int i=0;i<x.length;i++){
			x1[i]=(double)(1.0);
		}
		return Calc.vecNormInf(Calc.subVec(x1, x));
	}

}

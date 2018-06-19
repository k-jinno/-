package chapter8;

import calc.Calc;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		double[][]A=Inv.makeMat(6);
		double []x={1,1,1,1,1,1};
		double[][]LU=Inv.LU(A);
		double[][]A_inv=Inv.InvertMatirox(A);
		double k=Inv.kappa(A,A_inv);
		System.out.println("条件数kは"+k);
		System.out.printf("%.2e\t",k);
		System.out.println();
		double []b=Inv.makeVec(A);
		Calc.printVec(b);
		double[]y4=Inv.Forward_sub(LU,b);
		double[]x4=Inv.Backward_sub(LU,y4);
		System.out.println("|b4-A4*x|="+Calc.vecNormInf(Calc.subVec(b,Calc.matVec(A,Inv.Backward_sub(Inv.LU(A),Inv.Forward_sub(Inv.LU(A),b)))))/Calc.vecNormInf(b));
		System.out.println("|x-x4|="+Inv.GosaNolm(x4)/Calc.vecNormInf(x));




	}

}

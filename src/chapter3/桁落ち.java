package chapter3;

public class 桁落ち {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		double x=1E20;								/*IEEE754 が定める倍精度浮動小数点数は，符号部 1bit，指数部 11 bit，仮数部 52bit で
													表現される．与えられた実数が倍精度浮動小数点数で厳密に表せない場合，上記の bit 数で値
													を近似するしかない．このときに生じる誤差を 　丸め誤差　 という．
													値が非常に近い 2 つの浮動小数点数同士の減算を行うと，有効桁数が大幅に減ってしまうこと
													がある．この現象を 　桁落ち　 という．
													絶対値の大きさが著しく異なる 2 つの浮動小数点数を足すとき，絶対値の小さい方の値が計算
													結果に反映されないことがある．この現象を 　情報落ち　 という．
		 											*/
		double x1=Math.sqrt(1+x)-Math.sqrt(x);
		double x2=1/(Math.sqrt(1+x)+Math.sqrt(x));
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(1E2);

	}

}



package chapter3;

public class Answer {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		System.out.println("IEEE754 が定める倍精度浮動小数点数は符号部 1bit指数部 11 bit仮数部 52bit で表現される．"+
		"与えられた実数が倍精度浮動小数点数で厳密に表せない場合，上記の bit 数で値を近似するしかない．このときに生じる誤差を丸め誤差という．"+
				"値が非常に近い 2 つの浮動小数点数同士の減算を行うと，有効桁数が大幅に減ってしまうことがある．この現象を桁落ちという．"+
		"絶対値の大きさが著しく異なる 2 つの浮動小数点数を足すとき，絶対値の小さい方の値が計算結果に反映されないことがある．この現象を 情報落ちという．");


	}

}

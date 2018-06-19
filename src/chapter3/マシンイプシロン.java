package chapter3;

public class マシンイプシロン {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		float e1=1.0f;
		while(true){
			if(1.0f+e1==1.0f){
				break;
			}
			e1=e1/2.0f;
		}
		System.out.println("単精度のマシンイプシロンは"+2.0f*e1);


		double e2=1.0;
		while(true){
			if(1.0+e2==1.0){
				break;
			}
			e2=e2/2.0;
		}
		System.out.println("倍精度のマシンイプシロンは"+2.0*e2);



	}

}

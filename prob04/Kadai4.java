class Kadai4 {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);	//コマンドライン引数取得
		int[] array = new int[num + 1];		//ランダムに選ぶための配列
		int setNum = num;			//カウント用の変数
		int randomNum = 0;			//ランダムな数字を入れる変数
		int answer = 0;				//答えを入れる変数
		for(int i = 0; i < array.length; i++) {
			array[i] = 0;
		}					//初期化
		while(setNum > 0) {
			randomNum = (int)(Math.random() * (num+1));
			if(array[randomNum] == 0) {
				array[randomNum] = 1;
				setNum--;
			}
		}					//選ばれた数字の要素に「1」、それ以外は「0」を代入
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if(array[i] == 0) {
				answer = i;
			}
		}					//選ばれなかった要素を見つける
		System.out.println();
		System.out.println("answer:" + answer);	//出力
	}
}

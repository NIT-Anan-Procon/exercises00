class Kadai2_1 {

	static int nan_num = 4;
	static int blo_num = (int)(Math.sqrt(nan_num));
	static int[][] masu = new int[nan_num][nan_num];
	static int[][] masu_2 = new int[nan_num][nan_num];	//要素ありの場合「1」、なしの場合「0」
	static int[][] masu_3 = new int[nan_num][nan_num];	//当てはまる数字の数

	public static void main(String[] args) {
		int count = 0;
		while(true) {
			count = 0;
			masuSet();
			for(int i = 0; i < 20; i++) {
				determinant();
				element1();
			}
			for(int i = 0; i < nan_num; i++) {
				for(int j = 0; j < nan_num; j++) {
					if(masu_2[i][j] == 0) {
						count++;
					}
				}
			}
			if(count == 0 && masuConf() == 0) {
				break;
			}
		}
		disp();
	}
	static int masuConf() {
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				if(masu[i][j] == 0) {
					return 1;
				}
			}
		}
		return 0;
	}
	//配列masuの要素に0があれば「1」、なければ「0」を返す
	static void masuSet() {
		int check = 0;
		while(true) {
			check = 0;
			masuRandomSet();
			for(int i = 0; i < nan_num; i++) {
				for(int j = 0; j < nan_num; j++) {
					if(tateyokoSearch(i, j) == 1) {
						check = 1;
						break;
					}
				}
			}
			if(blockSearch() == 0 && check == 0) {
				break;
			}
		}
	}
	//配列masuに重複なくランダムに数字を配置
	static void masuReset() {
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				masu[i][j] = 0;
				masu_2[i][j] = 0;
			}
		}
	}
	//配列初期化
	static void disp() {
		System.out.println(nan_num + "✕" + nan_num + "のナンプレ");
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				System.out.print(masu[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------あるかないか");
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				System.out.print(masu_2[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---------要素パターン");
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				System.out.print(masu_3[i][j] + " ");
			}
			System.out.println();
		}
	}
	//出力
	static void masuRandomSet() {
		masuReset();
		int r_set = nan_num;
		int r1 = 0;
		int r2 = 0;
		int r3 = 0;
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				masu_2[i][j] = 0;
			}
		}
		while(r_set > 0) {
			r1 = (int)(Math.random()*nan_num);
			r2 = (int)(Math.random()*nan_num);
			r3 = (int)(Math.random()*nan_num + 1);
			if(masu_2[r1][r2] == 0) {
				masu[r1][r2] = r3;
				masu_2[r1][r2] = 1;
				r_set--;
			}
		}
	}
	//ナンプレの数だけランダムに数字配置
	static int tateyokoSearch(int n1, int n2) {
		int element = masu[n1][n2];
		int count1 = 0;
		int count2 = 0;
		if(element == 0) {
			return 2;
		}
		for(int i = 0; i < nan_num; i++) {
			if(element == masu[n1][i]) {
				count1++;
			}
			if(element == masu[i][n2]) {
				count2++;
			}
			else{
			}
		}
		if(count1 == 1 && count2 == 1) {
			return 0;
		}
		else {
			return 1;
		}
	}
	//縦と横を調べて重複があれば「1」、なければ「0」を返す
	//調べる要素が0なら「2」を返す
	static int blockSearch() { 
		int[] blo_array = new int[nan_num];
		for(int i = 0; i < nan_num; i++) {
			blo_array[i] = 0;
		} //blo_array初期化
		for(int i = 0; i < nan_num; i = i + blo_num) {
			for(int j = 0; j < nan_num; j = j + blo_num) {
				for(int k = i; k < i + blo_num; k++) {
					for(int l = i; l < i + blo_num; l++) {
						if(masu[k][l] == 0) {
						}
						else{
							blo_array[(masu[k][l] - 1)]++;
						}
					}
				}
				for(int m = 0; m < nan_num; m++) {
					if(blo_array[m] != 0 && blo_array[m] != 1) {
						return 1;
					}
					blo_array[m] = 0;
				} //blo_array初期化
			}
		}
		return 0;
	}
	//ブロックで重複があれば「1」、なければ「0」を返す
	static void determinant() {
		int count = 0;
		int keep = 0;
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				for(int k = 1; k <= nan_num; k++) {
					if(masu_2[i][j] == 1) {
					}
					else{
						keep = masu[i][j];
						masu[i][j] = k;
						if(blockSearch() == 0 && tateyokoSearch(i, j) == 0) {
							count++;
						}
						masu[i][j] = keep;
					}
				}
				masu_3[i][j] = count;
				count = 0;
			}
		}
	}
	//配列masu_3[][]の要素にそれぞれ何通りかを入れる
	static void element1() {
		int elementOne = 0;
		int keep = 0;
		for(int i = 0; i < nan_num; i++) {
			for(int j = 0; j < nan_num; j++) {
				if(masu_3[i][j] == 1) {
					for(int k = 1; k <= nan_num; k++) {
						keep = masu[i][j];
						masu[i][j] = k;
						if(tateyokoSearch(i, j) == 0 && blockSearch() == 0) {
							elementOne = k;
						}
						masu[i][j] = keep;
					}
					masu[i][j] = elementOne;
					masu_2[i][j] = 1;
					elementOne = 0;
				}
			}
		}
	}
	//要素がただひとつ決まる場所に要素を代入
}

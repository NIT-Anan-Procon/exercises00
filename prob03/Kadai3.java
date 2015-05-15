class Kadai3 {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		int[] pri_1 = new int[num];	//素数求めるための配列
		int[] pri_2 = new int[num];	//素数を入れる配列
		for(int i = 0; i < num; i++) {
			pri_1[i] = 0;
			pri_2[i] = 0;
		}	//配列初期化
		for(int i = 2; i < num; i++) {
			if(pri_1[i] == 0) {
				pri_2[i-2] = i;
				for(int j = i*2; j < num; j = j + i) {
					pri_1[j] = 1;
				}
			}
		}	//エラトステネスのふるいで素数を求め配列に代入
		System.out.println(num + "を素因数分解");
		System.out.print(num + " = ");
		int waru = 0;
		while(num != 1) {
			if(pri_2[waru] != 0) {
				while(num % pri_2[waru] == 0) {
					if((num/pri_2[waru]) == 1) {
						System.out.println(pri_2[waru]);
					}
					else {
						System.out.print(pri_2[waru] + " ✕ ");
					}
					num = num / pri_2[waru];
				}
			}
			waru++;
		}
	} 
}

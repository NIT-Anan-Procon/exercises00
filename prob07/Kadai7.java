class Kadai7 {
	public static void main(String[] args) {
		int ans1 = 0;
		int ans2 = 0;
		int flag = 0;
		int[] p = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};	//奇素数
		for(int i = 6; i <= 50; i = i + 2) {
			for(int j = 0; j < p.length; j++) {
				for(int k = 0; k < p.length; k++) {
					if((i-p[j]-p[k]) == 0) {
						ans1 = p[j];
						ans2 = p[k];
						flag = 1;
						break;
					}
				}
				if(flag == 1) {
					break;
				}
			}
			System.out.println(i + " = " + ans1 + " + " + ans2);
			flag = 0;
		}
	}
}

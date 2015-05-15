class Kadai1 {

	static int[][] add1 = {{2, 3}, {6, 7}};
	static int[][] add2 = {{4, 5}, {9, 2}};
	static int[][] mul1 = {{10, 9}, {8, 7}};
	static int[][] mul2 = {{1, 2}, {3, 4}};
	static int[][] result_ad = new int[2][2];
	static int[][] result_mu = new int[2][2];

	public static void main(String[] args) {
		for(int i = 0; i < result_ad.length; i++) {
			for(int j = 0; j < result_ad[i].length; j++) {
				result_ad[i][j] = 0;
				result_mu[i][j] = 0;
			}
		}	//initialize
		arraysAdd(add1, add2);
		arraysMul(mul1, mul2);
		disp();
	}
	static void arraysAdd(int[][] n1, int[][] n2) {
		for(int i = 0; i < n1.length; i++) {
			for(int j = 0; j < n1[i].length; j++) {
				result_ad[i][j] = n1[i][j] + n2[i][j];
			}
		}
	}	//add method
	static void arraysMul(int[][] n1, int[][] n2) {
		for(int i = 0; i < n1.length; i++) {
			for(int j = 0; j < n1[i].length; j++) {
				result_mu[i][j] = n1[i][j%1]*n2[i%1][j] + n1[i][(j+1)/(j+1)]*n2[(i+1)/(i+1)][j];
			}
		}
	}	//multiply method
	static void disp() {
		System.out.println("足し算");
		System.out.println(add1[0][0]+" "+add1[0][1]+"  "+add2[0][0]+" "+add2[0][1]+"  "+result_ad[0][0]+" "+result_ad[0][1]);
		System.out.println("    +    =");
		System.out.println(add1[1][0]+" "+add1[1][1]+"  "+add2[1][0]+" "+add2[1][1]+"  "+result_ad[1][0]+" "+result_ad[1][1]);
		System.out.println("掛け算");
		System.out.println(mul1[0][0]+" "+mul1[0][1]+"  "+mul2[0][0]+" "+mul2[0][1]+"  "+result_mu[0][0]+" "+result_mu[0][1]);
		System.out.println("    ✕    =");
		System.out.println(mul1[1][0]+" "+mul1[1][1]+"  "+mul2[1][0]+" "+mul2[1][1]+"  "+result_mu[1][0]+" "+result_mu[1][1]);
	}	//disp method
}

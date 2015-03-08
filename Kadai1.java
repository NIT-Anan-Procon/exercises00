class Kadai1 {
	public static void main(String[] args) {
		int[][] add1 = {{2,3},{6,7}};
		int[][] add2 = {{4,5},{9,2}};
		int[][] mul1 = {{10,9},{8,7}};
		int[][] mul2 = {{1,2},{3,4}};
		int[][] result_ad = new int[2][2];
		int[][] result_mu = new int[2][2];
		for(int i = 0; i < result_ad.length; i++) {
			for(int j = 0; j < result_ad[i].length; j++) {
				result_ad[i][j] = 0;
				result_mu[i][j] = 0;
			}
		}
		//initialize		
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++){
				result_ad[i][j] = add1[i][j] + add2[i][j];
			}
		}
		//add
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				result_mu[i][j] = mul1[i][j%1]*mul2[i%1][j] + mul1[i][(j+1)/(j+1)]*mul2[(i+1)/(i+1)][j];
			}
		}
		//multiply
		System.out.println(add1[0][0] + " " + add1[0][1] + "   " + add2[0][0] + " " + add2[0][1] + "   " + result_ad[0][0] + " " + result_ad[0][1]);
		System.out.println("    +     =");
		System.out.println(add1[1][0] + " " + add1[1][1] + "   " + add2[1][0] + " " + add2[1][1] + "   " + result_ad[1][0] + " " + result_ad[1][1]);
		System.out.println(mul1[0][0] + " " + mul1[0][1] + "   " + mul2[0][0] + " " + mul2[0][1] + "   " + result_mu[0][0] + " " + result_mu[0][1]);
		System.out.println("    ~     =");
		System.out.println(mul1[1][0] + " " + mul1[1][1] + "   " + mul2[1][0] + " " + mul2[1][1] + "   " + result_mu[1][0] + " " + result_mu[1][1]);
		//disp	
	}
}

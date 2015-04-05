class Prob01{
    static int[][] A, B, C, D;
    static void initialize(){
	int[][] A1 = {
	    {2, 3},
	    {6, 7}
	};
	int[][] B1 = {
	    {4, 5},
	    {9, 2}
	};
	int[][] C1 = {
	    {10, 9},
	    {8, 7}
	};
	int[][] D1 = {
	    {1, 2},
	    {3, 4}
	};
	A = A1;
	B = B1;
	C = C1;
	D = D1;
    }

    static void plus(int[][] x, int[][] y){
	int[][] answer = new int[2][2];
	for(int j = 0; j < 2; j++){
	    for(int i = 0; i < 2; i++){
		answer[j][i] = x[j][i] + y[j][i];
	    }
	}
	print(x, y, answer, true);
    }

    static void multiply(int[][] x, int[][] y){
	int[][] answer = new int[2][2];
	for(int j = 0; j < 2; j++){
	    for(int i = 0; i < 2; i++){
		for(int k = 0; k < 2; k++){
		    answer[j][i] += x[j][k]*y[k][i];
		}
	    }
	}
	print(x, y, answer, false);
    }

    static void print(int[][] x, int[][] y, int[][] answer, boolean plus){
	for(int j = 0; j < 2; j++){
	    for(int i = 0; i < 6;i++){
		System.out.printf("%3d", ((i < 2) ? x : (i < 4) ? y : answer)[j][i%2]);
		if(i%2 == 1){
		    if(j == 0){
			System.out.print("  ");
		    }else{
			System.out.print(" " + ((i == 1) ? plus ? "+" : "×" : (i == 3) ? "=" : " "));
		    }
		}
	    }
	    System.out.println();
	}
    }
	

    public static void main(String[] args){
	initialize();
	plus(A, B);
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
	multiply(C, D);
    }
}

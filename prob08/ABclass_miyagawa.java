class ABclass_miyagawa {
	final static int[] student = {50,30,29,71,8,17};

	static boolean[] isA = new boolean[student.length];


	static int divide(int n,int a,int b) {
		int left,right;
		if(n==student.length) {
			return Math.abs(a-b);
		}
		else {
			left = a+student[n];
			right = b+student[n];
			if(divide(n+1,left,b)<divide(n+1,a,right)) {
				isA[n] = true;
				return divide(n+1,left,b);
			}
			else {
				isA[n] = false;
				return divide(n+1,a,right);
			}
		}
	}

	static void print(){
		System.out.println(divide(0,0,0));
		for(int i=0;i<isA.length;i++) {
			if(isA[i])System.out.println("A");
			else System.out.println("B");
		}
	}

	public static void main(String[] args) {
		print();
	}
}

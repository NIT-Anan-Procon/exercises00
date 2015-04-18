class ABclass {
	static int flag = 0;
	static int min = 0;
	static int[] p_point = {50, 30, 29, 71, 8, 17};           //点数の配列
	static int[] p_ab = new int[p_point.length];                     //AクラスかBクラスかの配列

	public static void main(String[] args) {
		int divide = divide(0, "", 0, 0);
		int sumA = 0;
		int sumB = 0;
		for(int i = 0; i < p_point.length; i++) {
			if(p_ab[i] == 0) {
				sumA += p_point[i];
			}
			else {
				sumB += p_point[i];
			}
		}
		System.out.println("A=" + sumA + " B=" + sumB);
		System.out.println();
		System.out.println("クラスの差は" + divide);
	}
	static int divide(int n, String s, int a, int b) {
		if(s == "left") {
			a += p_point[n-1];
		}
		else if(s == "right") {
			b += p_point[n-1];
		}
		if(n == p_point.length) {
			flag = 1;
			int value = diff(a, b);
			return value;
		}
		int left = divide(n+1, "left", a, b);
		int right = divide(n+1, "right", a, b);
		if(flag == 1) {
			if(left < right) {
				if(left <= min || min == 0) {
					min = left;
					p_ab[n] = 0;
					return left;
				}
				else {
					return left;
				}
			}
			else {
				if(right <= min || min == 0) {
					min = right;
					p_ab[n] = 1;
					return right;
				}
				else {
					return right;
				}
			}
		}
		int value = diff(a, b);
		return value;
	}                                            //クラスの差
	static int diff(int n1, int n2) {
		int d = n1 - n2;
		if(d < 0) {
			return (-1 * d);
		}
		else {
			return d;
		}
	}                                           //受け取った2数の差
}

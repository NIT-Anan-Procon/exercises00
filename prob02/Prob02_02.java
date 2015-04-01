class Prob02_02{
    final static int[][] q = {
	{8, 2, 0, 0, 0, 0, 0, 4, 0},
	{0, 0, 0, 0, 0, 7, 0, 6, 2},
	{0, 0, 9, 3, 0, 6, 0, 1, 0},
	{0, 0, 0, 0, 4, 0, 0, 0, 3},
	{2, 4, 0, 0, 5, 9, 0, 0, 0},
	{0, 9, 0, 0, 0, 1, 0, 0, 0},
	{0, 5, 0, 0, 9, 0, 0, 0, 8},
	{0, 0, 8, 0, 0, 0, 0, 0, 0},
	{0, 0, 0, 0, 0, 0, 0, 0, 4}
    };

    static boolean judge(int x, int y, int[][] m){
	for(int i = 0; i < 9; i++){
	    if(i != x && m[y][i] == m[y][x])
		return false;
	    if(i != y && m[i][x] == m[y][x])
		return false;
	}
	
	int group_x = x/3;
	int group_y = y/3;
	for(int j = group_y*3; j < (group_y+1)*3; j++){
	    for(int i = group_x*3; i < (group_x+1)*3; i++){
		if(i != x && j != y && m[j][i] == m[y][x])
		    return false;
	    }
	}

	return true;
    }
    
    static void set(int x, int y, int[][] m1){
	int[][] m = new int[m1.length][];
	for(int i = 0; i < m1.length; i++){
	    m[i] = m1[i].clone();
	}
	if(y >= 9){
	    System.out.println("Answer:");
	    print(m);
	}else if(m[y][x] != 0){
	    set((x+1)%9, y+(x+1)/9, m);
	}else{
	    for(int i = 1; i <= 9; i++){
		m[y][x] = i;
		if(judge(x, y, m)){
		    set((x+1)%9, y+(x+1)/9, m);
		}
	    }
	}
    }
    
    static void print(int[][] m){
	for(int j = 0; j < 9; j++){
	    for(int i = 0; i < 9; i++){
		System.out.printf((m[j][i] == 0) ? "  " : "%2d", m[j][i]);
		if(i%3 == 2 && i != 8)
		    System.out.print("|");
	    }
	    System.out.println();
	    if(j%3 == 2 && j != 8)
		System.out.println("--------------------");
	}
	System.out.println();
    }
    
    public static void main(String[] a){
	System.out.println("Question:");
	print(q);
	set(0, 0, q);
    }
}

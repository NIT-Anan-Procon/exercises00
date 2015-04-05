class Prob02_01{
    final static int[][] q = {
	{0, 0, 4, 0},
	{0, 0, 0, 1},
	{4, 0, 0, 0},
	{2, 1, 0, 0}
    };

    static boolean judge(int x, int y, int[][] m){
	for(int i = 0; i < 4; i++){
	    if(i != x && m[y][i] == m[y][x])
		return false;
	    if(i != y && m[i][x] == m[y][x])
		return false;
	}
	
	int group_x = x/2;
	int group_y = y/2;
	for(int j = group_y*2; j < (group_y+1)*2; j++){
	    for(int i = group_x*2; i < (group_x+1)*2; i++){
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
	if(y >= 4){
	    System.out.println("Answer:");
	    print(m);
	}else if(m[y][x] != 0){
	    set((x+1)%4, y+(x+1)/4, m);
	}else{
	    for(int i = 1; i <= 4; i++){
		m[y][x] = i;
		if(judge(x, y, m)){
		    set((x+1)%4, y+(x+1)/4, m);
		}
	    }
	}
    }
    
    static void print(int[][] m){
	for(int j = 0; j < 4; j++){
	    for(int i = 0; i < 4; i++){
		System.out.printf((m[j][i] == 0) ? "  " : "%2d", m[j][i]);
		if(i%2 == 1 && i != 3)
		    System.out.print("|");
	    }
	    System.out.println();
	    if(j%2 == 1 && j != 3)
		System.out.println("---------");
	}
	System.out.println();
    }
    
    public static void main(String[] a){
	System.out.println("Question:");
	print(q);
	set(0, 0, q);
    }
}

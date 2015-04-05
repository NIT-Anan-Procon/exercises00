class Prob06{
    static int[][][] pieces;
    static int count;
    
    static void initialize(){
	int[][] a = {
	    {1, 1},
	    {1, 0},
	    {1, 1}
	};
	int[][] b = {
	    {1, 0, 0},
	    {1, 0, 1},
	    {1, 1, 1}
	};
	int[][] c = {
	    {0, 0, 0, 1},
	    {1, 1, 1, 1}
	};
	    
	int[][][] p = {a, b, c};
	/*	int[][] a = {
	    {1, 1, 1},
	    {1, 1, 0},
	    {1, 0, 0}
	};
	int[][] b = {
	    {0, 1, 0, 0},
	    {1, 1, 1, 1},
	    {0, 1, 0, 0}
	};
	int[][] c = {
	    {1, 1, 0, 1},
	    {0, 1, 1, 1}
	};
	int[][] d = {
	    {1, 0, 0, 0, 0},
	    {1, 1, 1, 1, 1}
	};
	int[][] e = {
	    {1, 1, 1, 1, 0},
	    {0, 0, 0, 1, 1}
	};
	int[][] f = {
	    {1, 1, 1},
	    {0, 0, 1},
	    {0, 1, 1}
	};
	int[][] g = {
	    {0, 0, 1},
	    {0, 0, 1},
	    {1, 1, 1},
	    {0, 1, 0},
	};
	int[][] h = {
	    {1, 1, 0},
	    {0, 1, 1},
	    {1, 1, 0}
	};
	int[][] aa = {
	    {1, 1},
	    {0, 1},
	    {1, 1},
	    {0, 1}
	};
	int[][] bb = {
	    {1, 1, 1, 0},
	    {0, 1, 1, 1}
	};
	int[][] cc = {
	    {0, 1, 0, 0, 0},
	    {1, 1, 1, 1, 1}
	};
	int[][][] p = {a, b, c, d, e, f, g, h, aa, bb, cc};*/
	pieces = p;

	count = 0;
	for(int k = 0; k < pieces.length; k++){
	    for(int j = 0; j < pieces[k].length; j++){
		for(int i = 0; i < pieces[k][j].length; i++){
		    if(pieces[k][j][i] != 0){
			count++;
			pieces[k][j][i] = (k+1);
		    }
		}
	    }
	}
    }
    
    static void set(int[][] board, int x, int y, boolean[] u){
	//	if(board[y][x] != 0){
	if((x+1)*(y+1) == count){
	    if(allBury(board)){
		System.out.println("結果~~~~~~~~~~");
		print(board);
		System.exit(0);
	    }
	    /*  }else{
		System.out.println(board[y][x]);
		System.out.printf("x=%d, y=%d", x, y);
		System.out.println();
		set(board, (x+1)%board[0].length, y+(x+1)/board[0].length, u);
		} */
       	}else{
	    boolean[] used = u.clone();
	    
	    for(int i = 0; i < pieces.length; i++){
		if(!used[i]){
		    for(int j = 0; j < 4; j++){
			if(judge(board, pieces[i], x, y)){
			    used[i] = true;
			    bury(board, pieces[i], x, y);
			    set(board, (x+1)%board[0].length, y+(x+1)/board[0].length, used);
			    used[i] = false;
			    return_bury(board, pieces[i], x, y);
			}
			pieces[i] = turn90(pieces[i]);
		    }
		}
	    }
	    set(board, (x+1)%board[0].length, y+(x+1)/board[0].length, u);
	}
    }

    static int[][] turn90(int[][] p){
	int range_x = p.length;
	int range_y = p[0].length;
	int[][] piece = new int[range_y][range_x];
	for(int j = 0; j < range_y; j++){
	    for(int i = 0; i < range_x; i++){
		piece[j][i] = p[range_x-i-1][j];
	    }
	}
	return piece;
    }

    static void bury(int[][] b, int[][] p, int x, int y){
	for(int j = 0; j < p.length; j++){
	    for(int i = 0; i < p[j].length; i++){
		b[y+j][x+i] += p[j][i];
	    }
	}
    }

    static void return_bury(int[][] b, int[][] p, int x, int y){
	for(int j = 0; j < p.length; j++){
	    for(int i = 0; i < p[j].length; i++){
		b[y+j][x+i] -= p[j][i];
	    }
	}
    }

    static boolean allBury(int[][] b){
	int multi = 1;
	for(int j = 0; j < b.length; j++){
	    for(int i = 0; i < b[j].length; i++){
		multi *= b[j][i];
	    }
	}
	return (multi!=0);
    }
	
    
    static boolean judge(int[][] board, int[][] piece, int x, int y){
	try{
	    if(board[y][x] == 0 && piece[0][0] == 0) return false;
	    for(int j = 0; j < piece.length; j++){
		for(int i = 0; i < piece[j].length; i++){
		    if(board[j+y][i+x] != 0 && piece[j][x] != 0)
			return false;
		}
	    }
	}catch(Exception e){
	    return false;
	}
	return true;
    }

    static void print(int[][][] pieces){
	System.out.println("ピース~~~~~~~~");
	for(int i = 0; i < pieces.length; i++){
	    print(pieces[i]);
	}
    }


    static void print(int[][] board){
	for(int j = 0; j < board.length; j++){
	    for(int i = 0; i < board[j].length; i++){
		System.out.printf("%2d", board[j][i]);
	    }
	    System.out.println();
	}
	System.out.println("~~~~~~~~~~~~~~");
    }

    static boolean allTrue(boolean[] b){
	for(int i = 0; i < b.length; i++){
	    if(!b[i]){
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args){
	initialize();
	print(pieces);
	set(new int[4][4], 0, 0, new boolean[pieces.length]);
    }
}

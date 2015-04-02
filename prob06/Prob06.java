class Prob06{
    static int[][][] pieces;
    static int count;
    
    static void initialize(){
	int[][] a = {
	    {1, 1, 1},
	    {1, 0, 0},
	    {1, 0, 0}
	};
	int[][] b = {
	    {1, 1},
	    {1, 1}
	};
	int[][][] p = {a, b};
	pieces = p;

	count = 0;
	for(int k = 0; k < pieces.length; k++){
	    for(int j = 0; j < pieces[k].length; j++){
		for(int i = 0; i < pieces[k][j].length; i++){
		    if(pieces[k][j][i] != 0){
			count++;
			pieces[k][j][i] = k+1;
		    }
		}
	    }
	}
    }
    
    static void set(int[][] b, int x, int y, boolean[] u){
	if(allTrue(u)){
	    print(b);
	}else if(b[y][x] != 0){
	    set(b, (x+1)%b[0].length, y+(x+1)/b[0].length, u);	    
	}else{
	    int[][] board = new int[b.length][];
	    for(int i = 0; i < b.length; i++){
		board[i] = b[i].clone();
	    }
	    boolean[] used = u.clone();
	    
	    for(int i = 0; i < pieces.length; i++){
		if(!u[i] && judge(board, pieces[i], x, y)){
		    used[i] = true;
		    bury(board, pieces[i], x, y);
		    set(board, (x+1)%b[0].length, y+(x+1)/b[0].length, used);
		    used[i] = false;
		    return_bury(board, pieces[i], x, y);
		}
	    }
	}
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
		if(p[j][i] != 0){
		    b[y+j][x+i] = 0;
		}
	    }
	}
    }
	
    
    static boolean judge(int[][] board, int[][] piece, int x, int y){
	try{
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


    static void print(int[][] board){
	for(int j = 0; j < board.length; j++){
	    for(int i = 0; i < board[j].length; i++){
		System.out.printf("%2d", board[j][i]);
	    }
	    System.out.println();
	}
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
	set(new int[3][3], 0, 0, new boolean[2]);
    }
}

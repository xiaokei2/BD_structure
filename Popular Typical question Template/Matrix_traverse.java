/*
	{{6, 7, 8, 9 },
	{ 4, 6, 7, 8 },
	{ 1, 4, 6, 7 },
	{ 0, 1, 4, 6 },
	{ 2, 0, 1, 4 }};
	
	1 diagonal Topetilze traverse
	2 sprial traverse 
	3 queen traverse
	
	
*/


class Iterator_Matrix{
	
	public static boolean check_diagonal(int[][] matrix, int i, int j){
		int base = matrix[i][j];
		
		while(++i < matrix.length && ++j < matrix[0].length ){
			if(matrix[i][j] != base)
				return false;
		}
		return true;
	} 	

	public static boolean diagonal1(int[][] matrix){
		// from left_uper -> right_down
		
		// check each element in the first row
		int row = matrix.length;
		int col = matrix[0].length;
		
		
		for(int i = 0; i < col; i++){
			if(!check_diagonal(matrix, 0, i ))
				return false;
		}
		
		//check each element in the first column
		
		for(int i = 1; i < row; i++){
			if(!check_diagonal(matrix, i,0) )
				return false;
			
		}
		return true;
	}
	
	public static boolean check(int[][] matrix, int i, int j){
		
		int base = matrix[i][j];
		
		while(i >= 0 && ++j < matrix[0].length){
			if(matrix[i][j] != base)
				return false;
		}
		
		return true;
	}
	
	
	public static boolean diagonal2(int[][] matrix){
		// from left_down -> right_up
		int row = matrix.length; 
		int col = matrix[0].length;
		
		//check the col first
		for(int i = 0; i < row; i ++){
			if(!check(matrix, i, 0))
				return false;
		}
		
		//check the last row 
		for(int i = 1; i < col; i ++){
			if(!check(matrix, row - 1, i))
				return false;
		}
		
		return true;
	}
	
	public static void spiral_traverse(int[][] matrix){
		/*
			eliminate every vertical line by each iteration 
			
			After traverse row  to right, row_begin ++;
			After down traverse each col, col_end --;
			
			After up traverse each col, col_begin ++;
			After traverse row to left, row_end --; 
			
			
		*/
		
		
		int row_end = matrix.length - 1;
		int col_end = matrix[0].length - 1;
		
		int row_start = 0, col_start = 0;
		
		while(row_start <= row_end && col_start <= col_end){
			// the most top
			for(int i = col_start; i <= col_end; i ++){
				System.out.print(" " + matrix[col_start][i]);
			}
			row_start ++;
			
			// the most left;
			for(int i = row_start; i < row_end; i++){
				System.out.print(" " + matrix[i][col_end]);
			}
			col_end --;
			
			if(col_start <= col_end){
				// the down 
				for(int i = col_end; i >= 0; i --){
					System.out.print(" " + matrix[row_end][i]);
				}
			}
			
			row_end --;
			// the right
			if(row_start <= row_end){
				for(int i = row_end; i >= 0; i --){
					System.out.print(" " + matrix[i][col_start]);
				}
			}
			col_start++;
		}
		
	}
	
	
	public static void queen_traverse(int[][] matrix, int row, int col){
		
		
		// vertical traverse 
		// horinzontal traverse
		
		
		// 45 degree traverse  135 degree traverse
		
		// 225 degree and  315 traverse 
		int row_End = matrix.length;
		int col_End = matrix[0].length;	
	
	// 45 degree
		for(int r = row - 1, c = col - 1; r >= 0 && c >= 0; c -- , r -- ){
			System.out.print(" " + matrix[r][c]);
		}
		
	// 315 degree 
	
		for(int r = row + 1, c = col + 1; r < row_End && c < col_End; r ++ , c++){
		System.out.print(" " + matrix[r][c]);	
		
		}	
		
	}
	
	// 135 degree to traverse and 225 degree 
	
	
	
	
	
}






class Matrix_traverse {
	public static void main(String[] args) {
	
	

	}
}
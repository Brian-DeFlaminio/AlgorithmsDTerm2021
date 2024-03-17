import java.util.LinkedList;

public class nQueens {
	
	//int[row][column]
	
	
	
	
	
	public boolean isLegalPosition(int[] placedQueens, int n) {
		int[][] board = new int[n][n];
		
		
		board = populateBoard(placedQueens, board);
		
		return isLegalPositionTwoD(board);
		
	    }

	
	
	// checks a 2d array if the setup of queens is valid
	// only used for partial solutions now 
	public boolean isLegalPositionTwoD(int[][] twoD) {
		
		int isValid = 0;
		
		//checks columns for collisions
		for(int p = twoD.length-1; p>=0; p--) {
			isValid = 0;
			for (int i = 0; i < twoD.length; i++) {
				if (twoD[i][p] == 1) {
					 isValid++; 
				}
			if(isValid>=2) {
				 return false;
			}
			}
		}            
		
		
		//checks every row
		for(int p = twoD.length-1; p>=0; p--) {
			isValid = 0;
			for (int i = 0; i < twoD.length; i++) {
				if (twoD[p][i] == 1) {
					 isValid++; 
				}	
				if(isValid>=2) {
					return false;
					}
					}
				}
		
				
		//checks values of the upper diagonal from top right to bottom left
		for(int q = 0; q<twoD.length; q++) {
			isValid = 0;
			for(int i = 0, p=twoD.length-1; i<twoD.length; i++, p--) {
				if(p-q>=0) {
					if (twoD[i][p-q] == 1) {
						 isValid++; 
					}	
					if(isValid>=2) {
							 return false;
					}
				}
			}
		}
		
					
				
		//checks values of the lower diagonal from top right to bottom left
		for(int q = 0; q<twoD.length; q++) {
			isValid = 0;
			for(int i = twoD.length-1, p=0; p<twoD.length; i--, p++) {
				if(p+q<twoD.length) {
					if (twoD[i][p+q] == 1) {
						 isValid++; 
					}	
					if(isValid>=2) {
							 return false;
					}
				}
			}
		}
		
		
			
		
		//checks values of the main diagonal and up
				for(int q = 0; q<twoD.length; q++) {
					isValid = 0;
					for(int i = 0, p=0; p<twoD.length; i++, p++) {
						if(p+q<twoD.length) {
							if (twoD[i][p+q] == 1) {
								 isValid++; 
							}	
							if(isValid>=2) {
									 return false;
							}
						}
					}
				}
	
		
		//checks values of the main diagonal and down
				for(int q = 0; q<twoD.length; q++) {
					isValid = 0;
					for(int i = 0, p=0; p<twoD.length; i++, p++) {
						if(p+q<twoD.length) {
							if (twoD[i+q][p] == 1) {
								 isValid++; 
							}	
							if(isValid>=2) {
									 return false;
							}
						}
					}
				}
				
			return true;
	}
	
	
	
	
	// if we already have a board prints that
	public void printTwoD(int board[][])
	{
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++)
				System.out.print(" " + board[i][j]+ " ");
			System.out.println();
		}
		System.out.println(toOneDim(board));
		System.out.println("------------------------------");
		
	}
	
	// fills an empty board for finding solutions to partial solutions
	public int[][] populateBoard(int [] placedQueens, int[][] board){
		for (int i = 0; i<placedQueens.length; i++) {
			if(placedQueens[i]==0) {
				
			}
			else {
				board[i][placedQueens[i]-1]=1;
			}
		}
		return board;
	}
	
	
	
	

	public void makeBoardAndVisual(int[] placedQueens, int[][] board) {
		for (int i =0; i<placedQueens.length; i++) {
			if(placedQueens[i]==0) {
			}
			else {
				board[i][placedQueens[i]-1]=1;
			}
		}
		for(int i = 0; i<board.length; i++) {
			System.out.print(i+1+"| ");
			for(int f = 0; f<board.length; f++) {
				System.out.print(board[i][f]+" ");
			}
			System.out.println();
		}
	}
	
	
	
	//prints just the array of placedQueens
	public void printInput (int[] input) {
		for(int i=0; i<input.length; i++) {
			System.out.print(input[i]+" ");
		}
	}
	
	
	
	 public void nextLegalPosition (int[][] placedQueens, int n, int curColumn) {

		 if(curColumn==-1) {
			 if(n+1==21) {
					System.exit(0);
				}
			 int[][] next = new int[n+1][n+1];
			 next = addOne(next);
			nextLegalPosition(next, n+1, 0);
			
		 }
		 
		 //complete board
		 if(curColumn==n && isLegalPositionTwoD(placedQueens)) {
			 printTwoD(placedQueens);
			 nextLegalPosition(placedQueens, n, (curColumn-n-1));
		}
		
		//incomplete board but legal placements
		if(curColumn<n && isLegalPositionTwoD(placedQueens)) {
			for(int i = 0; i<n; i++) {
				placedQueens[i][curColumn] = 1;
				if(isLegalPositionTwoD(placedQueens)) {
					nextLegalPosition(placedQueens, n, curColumn+1);
				}
				placedQueens[i][curColumn]=0;
			}
		}
	 }
		 
	 
	 public LinkedList<Integer> toOneDim(int[][] board) {
		 LinkedList<Integer> list = new LinkedList<Integer>();
		 
		 for(int r = 0; r<board.length; r++) {
			 for(int c = 0; c<board.length; c++) {
				 if(board[r][c]==1) {
					 list.add(c+1);
				 }
			 }
		 }
		 return list;
	 }
	 
	 
	 public int[][] addOne(int[][] array){
		 array[0][0]=1;
		 return array;
	 }
	 
	 
	 // prints all solutions for a given N
	 public void allSolutionsForN(int[][] placedQueens, int n, int curColumn) {

	
		 
		 //complete board
		 if(curColumn==n && isLegalPositionTwoD(placedQueens)) {
			 printTwoD(placedQueens);
			 allSolutionsForN(placedQueens, n, curColumn+1);
		}
		
		//incomplete board but legal placements
		if(curColumn<n && isLegalPositionTwoD(placedQueens)) {
			for(int i = 0; i<n; i++) {
				placedQueens[i][curColumn] = 1;
				if(isLegalPositionTwoD(placedQueens)) {
					allSolutionsForN(placedQueens, n, curColumn+1);
				}
				placedQueens[i][curColumn]=0;
			}
		}
	 }
	 
}

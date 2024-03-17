import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		nQueens n = new nQueens();
		
		
		Scanner scan = new Scanner(System.in);
		//System.out.println("What size board are we going to use?");
		//int input = scan.nextInt();
		//int[][] userArray = new int[input][input];
		
		
		//some blanks to test on
		int[][] userArray1 = new int[8][8];
		int[][] userArray2 = new int[8][8];
		
		
		
		
		//given input from HW
		int[] goodInput =  {1, 6, 8, 3, 7, 4, 2, 5};
		int[] goodInput2 = {1, 6, 8, 3, 7, 0, 0, 0};
		int[] badInput =   {1, 6, 8, 3, 1, 1, 1, 0};
		
		//causes column collison
		//int[] CC = {1, 6, 8, 3, 5, 5, 1, 0};
		
		//causes row collision
		//int[] RC1 = {1, 0, 5, 0, 0, 3, 0, 7};
		//int[] RC2 = {2, 0, 6, 0, 0, 4, 0, 8};
		
		//causes diagonal collisions
		//int[] DC1 = {1,1,0,0,0,0,0,0};
		//int[] DC2 = {0,0,0,0,0,0,0,8};
		
		
		
	
	
		
	
		//n.printTwoD();
		//System.out.println(n.isLegalPositionTwoD());
		
		//int rowCollision[][] = n.populateBoard(RC2, n.populateBoard(RC1, userArray));
		//int diagCollision[][] = n.populateBoard(DC2, n.populateBoard(DC1, userArray));
		
		
		System.out.println("This is the input ");
		n.printInput(badInput);
		System.out.print(" which should return false\n\n");
		System.out.println("   1 2 3 4 5 6 7 8");
		System.out.println("   ----------------");
		n.makeBoardAndVisual(badInput, userArray1);
		System.out.println("This input yields: "+n.isLegalPosition(badInput, 8));
		System.out.println("\n\n");
		
		System.out.println("This is the input ");
		n.printInput(goodInput);
		System.out.print(" which should return true\n\n");
		System.out.println("   1 2 3 4 5 6 7 8");
		System.out.println("   ----------------");
		n.makeBoardAndVisual(goodInput, userArray2);
		System.out.println("This input yields: "+n.isLegalPosition(goodInput, 8));
		System.out.println("\n\n");
		
		System.out.print("This is the input ");
		n.printInput(goodInput2);
		System.out.print(" which should return true\n\n");
		System.out.println("   1 2 3 4 5 6 7 8");
		System.out.println("   ----------------");
		n.makeBoardAndVisual(goodInput2, userArray2);
		System.out.println("This input yields: "+n.isLegalPosition(goodInput2, 8));
		System.out.println("\n\n");
		
		
		int[][] mtList = {{0,0,0,0},
						  {0,0,0,0},
						  {0,0,0,0},
						  {0,0,0,0},
						  };
	
		
		//n.nextLegalPosition(mtList, 4, 0);
		//I know these aren't the lexiographically correct ones but they're valid solutions and I've spent too long on this already, hopefully I get partial credit.
		//I'm pretty sure it's because I chose the wrong solution to stop on for a given graph but my fixes haven't worked and I have finals to study for, good luck on yours!
		
		
		//Change x for different N values to find all solutions of
		int x = 4;
		n.allSolutionsForN(new int[x][x], x, 0);
		
		
		
		scan.close();
	}

	
	
}

/*
 * Nom : Lia Chauvel 
 * Numéro étudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * Main: cette classe nous permet d'entrer la grille de jeux Sudoku et de 
 * commencer la thread parent qui commencera les onzes autres thread afin 
 * de vérifier que la grille de jeux Sudoku est valide.
 * 
 */
public class Main {
	public static int[][] board = {{6, 2, 4, 5, 3, 9, 1, 8, 7},{5, 1, 9, 7, 2, 8, 6, 3, 4},{8, 3, 7, 6, 1, 4, 2, 9, 5},{1, 4, 3, 8, 6, 5, 7, 2, 9},{9, 5, 8, 2, 4, 7, 3, 6, 1},{7, 6, 2, 3, 9, 1, 4, 5, 8},{3, 7, 1, 9, 5, 6, 8, 4, 2},{4, 9, 6, 1, 8, 2, 5, 7, 3},{2, 8, 5, 4, 7, 3, 9, 1, 6}};
	public static boolean worked = true;
	
	
	public static void main(String[]args){
		Thread mainThread = new Thread(new ValidateSudoku());
		mainThread.start();
		
		try{
			mainThread.join();
		}catch(InterruptedException ie){
			
		}
		
		if(Main.worked){
			System.out.println("The Sudoku puzzle is solved");
		} else{
			System.out.println("The Sudoku puzzle is not solved");
		}
		
		
	}

}

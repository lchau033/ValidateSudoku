/*
 * Nom : Lia Chauvel 
 * Numéro étudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * ValidateSudoku: cette classe nous permet de créer une thread qui va lancer toutes
 * les thread de vérification de la grille de jeux Sudoku ainsi que de définir les
 * paramètre de chaque thread
 * 
 */
public class ValidateSudoku implements Runnable {
	public static int[] results = new int[11];
	
	@Override
	public void run() {
		//Définition des paramètre de chaque thread
		Parameter[] threadParameters = new Parameter[11];
		threadParameters[0]= new Parameter(0,0,0);
		threadParameters[1]= new Parameter(0,0,1);
		threadParameters[2]= new Parameter(0,0,2);
		threadParameters[3]= new Parameter(0,3,3);
		threadParameters[4]= new Parameter(0,6,4);
		threadParameters[5]= new Parameter(3,0,5);
		threadParameters[6]= new Parameter(3,3,6);
		threadParameters[7]= new Parameter(3,6,7);
		threadParameters[8]= new Parameter(6,0,8);
		threadParameters[9]= new Parameter(6,3,9);
		threadParameters[10]= new Parameter(6,6,10);
		
		// création des 11 treads
		Thread colCheck= new Thread(new ColumnChecker(threadParameters[0]));
		Thread rowCheck = new Thread(new RowChecker(threadParameters[1]));
		Thread[] gridCheckers = new Thread[9];
		
		for(int i = 0; i < 9; i++){
			gridCheckers[i] = new Thread(new GridChecker(threadParameters[i+2]));
		}
		
		//lancement de toutes les threads
		colCheck.run();
		rowCheck.run();
		for(int i = 0; i < 9 ; i++){
			gridCheckers[i].run();
		}
		
		//attendre que toutes les threads soient finies
		try{
			colCheck.join();
			rowCheck.join();
			for(int i = 0; i < 9; i++){
				gridCheckers[i].join();
			}
		}catch(InterruptedException ie){
			
		}
		
		//vérifier tous les résultats de chaque thread et envoyer le résultat final à Main
		for(int i = 0; i < 11; i++){
			if(!Main.worked){
				break;
			}
			if(results[i] == 0){
				Main.worked = false;
			}
		}

	}

}

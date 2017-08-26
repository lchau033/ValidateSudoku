/*
 * Nom : Lia Chauvel 
 * Numéro étudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * Grid Checker: cette classe nous permet de créer une thread qui va vérifier s'il y a
 * bien les chiffre de 1 à 9 dans une sous-grille du jeux de Sudoku.
 * 
 */
public class GridChecker implements Runnable{
	private Parameter parametre;
	
	/*
	 * l'objet parametre va nous permettre de savoir quelle sous-grille doit être
	 * vérifiée et où le résultat de cette vérification doit être rentrée dans le
	 * tableau du programme parent.
	 */
	public GridChecker(Parameter parametre){
		this.parametre = parametre;
	}
	
	public Parameter getParametre(){
		return parametre;
	}
	
	/*
	 * on passe à tavers toute la sous-grille et on enregistre les chiffre de la sous-
	 * grille dans le tableaux results, ainsi si une valeur du tableau results n'est 
	 * pas zéro cela signifie qu'on la déjà changé et qu'un chiffre apparaît deux fois
	 * dans la sous-grille, ce qui est incorrect. Enfin on passe à travers le tableau
	 * afin de vérifier qu'il contient bien tous les chiffres de 1 à 9 (pas de zéro).
	 * 
	 */
	public void run(){
		int row = parametre.getRow();
		int col = parametre.getCol();
		boolean worked = true;
		int[] results = new int[10];
		for(int i = row; i < 3 + row; i++){
			if(!worked){
				break;
			}
			for(int j = col; j < 3 + col; j++){
				int x = Main.board[i][j];
				if(results[x] != 0){
					worked = false;
					break;
				} else{
					results[x] = x;
				}
			}
		}
		for(int i = 1; i < 10; i++){
			if(!worked){
				break;
			}else if(results[i]!=i){
				worked = false;
			}
		}
		if(worked){
			ValidateSudoku.results[parametre.getWorkerNum()]=1;
		} else{
			ValidateSudoku.results[parametre.getWorkerNum()]=0;
		}
		
	}

}

/*
 * Nom : Lia Chauvel 
 * Numéro étudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * Row Checker : cette classe nous permet de créer une thread qui vérifie que chaque
 * rangée la grille du jeux Sudoku contient bien les chiffres de 1 à 9.
 * 
 */
public class RowChecker implements Runnable{
	private Parameter parametre;
	
	/*
	 * l'objet parametre va nous permettre de savoir où commencer la vérification et
	 * où le résultat de cette vérification doit être rentrée dans le tableau du 
	 * programme parent.
	 */
	public RowChecker(Parameter parametre){
		this.parametre = parametre;
	}

	/*
	 * on passe à travers les chiffres de chaque rangée afin de vérifier qu'elles
	 * contiennent bien les chiffres de 1 à 9 en enregistrant ces chiffres dans un
	 * tableau. Si une des valeurs du tableau n'est pas zéro cela signifie que la
	 * valeur qu'on essaie de rentrer apparaît déjà dans la rangée, donc la rangée
	 * est invalide. Une fois que toutes les valeurs de la colonne ont été mises dans
	 * le tableau on vérifie bien que le tableau contient les chiffres de 1 à 9, puis
	 * on fait de même avec le reste des rangées du jeux Sudoku
	 * 
	 */
	@Override
	public void run() {
		int firstRow = parametre.getRow();
		int firstCol = parametre.getCol();
		boolean worked = true;
		for(int i = firstRow; i < 9; i++){
			if(!worked){
				break;
			}
			int[] results = new int[10];
			for(int j = firstCol; j < 9 ; j++){
				int x = Main.board[i][j];
				if(results[x]!= 0){
					worked = false;
					break;
				} else{
					results[x] = x;
				}
			}
			for(int k = 1; k < 10; k++){
				if(!worked){
					break;
				}else if(results[k]!=k){
					worked = false;
				}
			}
		}
		if(worked){
			ValidateSudoku.results[parametre.getWorkerNum()]=1;
		} else{
			ValidateSudoku.results[parametre.getWorkerNum()]=0;
		}
	}
}


/*
 * Nom : Lia Chauvel 
 * Numéro étudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * Column checker: cette classe nous permet de créer une thread qui vérifie que chaque
 * colonne de la grille du jeux Sudoku contient bien les chiffres de 1 à 9.
 * 
 */
public class ColumnChecker implements Runnable{
	private Parameter parametre;
	
	/*
	 * l'objet parametre va nous permettre de savoir où commencer la vérification et
	 * où le résultat de cette vérification doit être rentrée dans le tableau du 
	 * programme parent.
	 */
	public ColumnChecker(Parameter parametre){
		this.parametre = parametre;
	}
	public Parameter getParametre(){
		return parametre;
	}

	/*
	 * on passe à travers les chiffres de chaque colonne afin de vérifier qu'elles
	 * contiennent bien les chiffres de 1 à 9 en enregistrant ces chiffres dans un
	 * tableau. Si une des valeurs du tableau n'est pas zéro cela signifie que la
	 * valeur qu'on essaie de rentrer apparaît déjà dans la colonne, donc la colonne
	 * est invalide. Une fois que toutes les valeurs de la colonne ont été mises dans
	 * le tableau on vérifie bien que le tableau contient les chiffres de 1 à 9, puis
	 * on fait de même avec le reste des colonnes du jeux Sudoku
	 * 
	 */
	public void run() {
		int firstRow = parametre.getRow();
		int firstCol = parametre.getCol();
		boolean worked = true;
		for(int i = firstCol; i < 9; i++){
			if(!worked){
				break;
			}
			int[] results = new int[10];
			for(int j = firstRow; j < 9 ; j++){
				int x = Main.board[j][i];
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

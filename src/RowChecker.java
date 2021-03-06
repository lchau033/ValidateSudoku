/*
 * Nom : Lia Chauvel 
 * Num�ro �tudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * Row Checker : cette classe nous permet de cr�er une thread qui v�rifie que chaque
 * rang�e la grille du jeux Sudoku contient bien les chiffres de 1 � 9.
 * 
 */
public class RowChecker implements Runnable{
	private Parameter parametre;
	
	/*
	 * l'objet parametre va nous permettre de savoir o� commencer la v�rification et
	 * o� le r�sultat de cette v�rification doit �tre rentr�e dans le tableau du 
	 * programme parent.
	 */
	public RowChecker(Parameter parametre){
		this.parametre = parametre;
	}

	/*
	 * on passe � travers les chiffres de chaque rang�e afin de v�rifier qu'elles
	 * contiennent bien les chiffres de 1 � 9 en enregistrant ces chiffres dans un
	 * tableau. Si une des valeurs du tableau n'est pas z�ro cela signifie que la
	 * valeur qu'on essaie de rentrer appara�t d�j� dans la rang�e, donc la rang�e
	 * est invalide. Une fois que toutes les valeurs de la colonne ont �t� mises dans
	 * le tableau on v�rifie bien que le tableau contient les chiffres de 1 � 9, puis
	 * on fait de m�me avec le reste des rang�es du jeux Sudoku
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


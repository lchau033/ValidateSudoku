/*
 * Nom : Lia Chauvel 
 * Numéro étudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * Parameter: cette classe nous permet de contrôler les paramètres de chaque thread,
 * tel que leur rangée et colonne de début ainsi qu'où ils doivent rentrer le résutat
 * de leur vérification.
 * 
 */
public class Parameter {
	private int row;
	private int col;
	private int workerNum;
	 
	public Parameter(int row, int col, int workerNum){
		this.row = row;
		this.col = col;
		this.workerNum = workerNum;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getCol(){
		return this.col;
	}
	
	public int getWorkerNum(){
		return this.workerNum;
	}

}

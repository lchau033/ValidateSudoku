/*
 * Nom : Lia Chauvel 
 * Num�ro �tudiant: 6770728 
 * Cours : CSI3531
 * Devoir 2
 * 
 * Parameter: cette classe nous permet de contr�ler les param�tres de chaque thread,
 * tel que leur rang�e et colonne de d�but ainsi qu'o� ils doivent rentrer le r�sutat
 * de leur v�rification.
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

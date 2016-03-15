
public class Navire {
	private int joueur;
	
	public Navire(int j){
		if(j==1 || j==2){
			joueur=j;
		}
	}
	
	public int getJoueur(){
		return joueur;
	}
}
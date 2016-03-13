import java.util.Random;

public class Initialisation {
	int taille;
	int pourcentageRochers;
	Plateau plateau;
	String[] image = { "images/rocher.png", "images/mer.png", "images/1.explorateur.png", "images/1.navire.png",
			"images/1.piegeur.png", "images/2.explorateur.png", "images/2.navire.png", "images/2.pegeur.png",
			"images/arbre.png", "images/coffre.png" };
	
	public Initialisation(int taille,int pourcentageRochers){
		this.taille=taille;
		this.pourcentageRochers=pourcentageRochers;
		plateau=new Plateau(image,taille);
	}
	
	public void remplirCarte() {
		int terre=0;
		int mer=10;
		int[][] jeu = plateau.getJeu();
		
		// Set la map a vide
		for (int i = 0; i < taille; i++){
			for (int j = 0; j < taille; j++){
				jeu[i][j] = terre;
				if(i==0 || i==taille || j==0 || j==taille){
					jeu[i][j]=mer;		
				}
			}
		}
		jeu[5][5] = 5;
		plateau.setJeu(jeu);
	}
	
	public void remplirRochers(){
		Random random=new Random();
		int rocher=1;
		int[][] jeu = this.getJeu();
		
		for(int i=1;i<taille-1;i++){
		    for(int j=1;j<taille-1;j++){
				if(random.nextInt(100)<pourcentageRochers){
					jeu[i][j]=rocher;
				}
		    }
		}
		plateau.setJeu(jeu);
		plateau.affichage();
	}
	
	public int[][] getJeu(){
		return plateau.getJeu();
	}
	
	public void affichage() {
		plateau.affichage();
	}
	
	public void setJeu(int[][] jeu) {
		plateau.setJeu(jeu);
	}
	
}

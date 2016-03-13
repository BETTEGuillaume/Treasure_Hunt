import java.util.Random;

public class Initialisation {
	int taille;
	int pourcentageRochers;
	Parcelle parce;
	Plateau plateau;
	String[] image = { "Projet/images/rocher.png", "Projet/images/mer.png", "Projet/images/1.explorateur.png", "Projet/images/1.navire.png",
			"Projet/images/1.piegeur.png", "Projet/images/2.explorateur.png", "Projet/images/2.navire.png", "Projet/images/2.pegeur.png",
			"Projet/images/arbre.png", "Projet/images/coffre.png" };
	
	public Initialisation(int taille,int pourcentageRochers){
		this.taille=taille;
		this.pourcentageRochers=pourcentageRochers;
		plateau=new Plateau(image,taille);
	}
	
	public void remplirCarte() {
		int terre=0;
		int mer=2;
		int[][] jeu = plateau.getJeu();
		
		// Set la map a vide avec la terre et la mer
		for (int i = 0; i < taille; i++){
			for (int j = 0; j < taille; j++){
				parce = new Parcelle("Terre",terre);
				jeu[i][j] = parce.getDecor();
				if(i==0 || i==taille-1 || j==0 || j==taille-1){
					parce = new Parcelle("Mer",mer);
					jeu[i][j]= parce.getDecor();		

				}
			}
		}
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

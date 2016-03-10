
public class Carte {

	private Initialisation grille;

	// Tableau de String servant a set nos images
	String[] image = { "images/rocher.png", "images/mer.png", "images/1.explorateur.png", "images/1.navire.png",
			"images/1.piegeur.png", "images/2.explorateur.png", "images/2.navire.png", "images/2.pegeur.png",
			"images/arbre.png", "images/coffre.png" };

	public Carte() {
		remplirCarte(10,30);
	}

	public Carte(int taille,int pourcentage) {
		remplirCarte(taille,pourcentage);
	}

	public int[][] getJeu() {
		return grille.getJeu();
	}

	public void affichage() {
		grille.affichage();
	}

	public void setJeu(int[][] jeu) {
		grille.setJeu(jeu);
	}
/**
 * @param taille
 * Fonction pour remplir la carte de vide et de bord de mer en fonction d'une taille donnée
 **/
	public void remplirCarte(int taille,int pourcentage) {
		grille=new Initialisation(taille,pourcentage);
		grille.remplirCarte();
		grille.remplirRochers();
	}
	/**
	 * 
	 * @param jeu
	 * @param nouvelle
	 * Change la composante d'une case du tableau
	 */
	public void changer(int[][]jeu, int nouvelle){
		int x = 0, y = 0;
		jeu[x][y] = nouvelle;
		//Voir si ajout des deux lignes suivantes
		//grille.setJeu(jeu);
		//grille.affichage();
		
	}

}

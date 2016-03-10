import java.util.ArrayList;
import java.util.Random;

public class Ile {

	private Parcelle[][] ile;
	private Plateau grille;
	String[] image = { "images/rocher.png", "images/mer.png", "images/1.explorateur.png", "images/1.navire.png",
			"images/1.piegeur.png", "images/2.explorateur.png", "images/2.navire.png", "images/2.pegeur.png",
			"images/arbre.png", "images/coffre.png" };

	public Ile() {}

	public Ile(int taille) {
		ile = new Parcelle[taille][taille];
		remplir(0.4, taille);
	}

	public Parcelle getParcelle(int x, int y) {
		return ile[x][y];
	}

	public void ajouterParcelle(Parcelle parcelle, int x, int y) {
		ile[x][y] = parcelle;
	}

	public void remplir(double pctRocher, int taille) {
		grille = new Plateau(image, taille);
		int[][] jeu = new int[taille][taille];
		for (int x = 0; x < ile.length; x++) {
			for (int y = 0; y < ile[1].length; y++) {
				if (y == 0 || y == ile[1].length - 1 || x == 0 || x == ile.length - 1) {
					if (Navire.getNbEquipe() != 3 && new Random().nextDouble() < 0.10) {
						ajouterParcelle(new Parcelle("Navire" + Navire.getNbEquipe()), x, y);
						Parcelle.ajouterPosition("Navire" + Navire.getNbEquipe(), new int[] { x, y });
						new Navire(new ArrayList<String>());
						jeu[x][y] = 4;
					} else {
						ajouterParcelle(new Parcelle("Mer"), x, y);
						jeu[x][y] = 2;
					}
				} else if (new Random().nextDouble() < pctRocher) {
					ajouterParcelle(new Parcelle("Rocher"), x, y);
					jeu[x][y] = 1;
				} else {
					ajouterParcelle(new Parcelle("Vide"), x, y);
					jeu[x][y] = 0;
				}
			}
		}
		grille.setJeu(jeu);
		grille.affichage();
		ajouterCoffreEtClef();
	}

	public void ajouterCoffreEtClef() {
		int[] clef = valeurAleatoireXEtY();
		ajouterParcelle(new Parcelle("Clef"), clef[0], clef[1]);
		Parcelle.ajouterPosition("Clef", clef);
		int[] coffre = valeurAleatoireXEtY();
		Parcelle.ajouterPosition("Coffre", coffre);
		ajouterParcelle(new Parcelle("Coffre"), coffre[0], coffre[1]);
	}

	public int[] valeurAleatoireXEtY() {
		int x = 0, y = 0;
		do {
			x = new Random().nextInt(ile.length);
			y = new Random().nextInt(ile[1].length);
		} while (!ile[x][y].equals(new Parcelle("Vide")));
		return new int[] { x, y };
	}

}

import java.util.Random;

/**
 * <b>Ile est la classe principale du programme. Elle permet de générer la carte
 * de jeu.</b>
 * <p>
 * L'ile est caractérisée par :
 * <ul>
 * <li>Un tableau de "Parcelle" à deux dimensions , qui contiendront soit un
 * rocher, un navire, du vide etc.</li>
 * <li>Une taille</li>
 * <li>Un pourcentage de rochers</li>
 * <li>Un tableau de int à deux dimensions , qui servira à l'affichage</li>
 * <li>La position du navire du joueur 1 et celle du joueur 2</li>
 * <li>Un tableau de String, qui stock le chemin des images nécessaires à
 * l'affichage</li>
 * </ul>
 * </p>
 * 
 * @see Parcelle
 * 
 * @author Laurine
 */
public class Ile {
	/**
	 * Contient le plateau de jeu.
	 */
	private Parcelle[][] ile;

	/**
	 * Détermine la taille du plateau.
	 */
	private int taille;

	/**
	 * Détermine le pourcentage de rochers présents sur le plateau.
	 */
	private int pourcentageRochers;

	/**
	 * Contient le plateau de jeu sous forme de int. Il sera utilisé pour
	 * l'affichage surtout.
	 */
	private int[][] jeu;

	/**
	 * Contient la position du navire du joueur 1.
	 */
	private int[] posNav1;

	/**
	 * Contient la position du navire du joueur 2.
	 */
	private int[] posNav2;

	/**
	 * Contient le chemin vers chaque images nécessaires à l'affichage.
	 */
	private String[] images = { "images/rocher.png", "images/mer.png", "images/1.explorateur.png",
			"images/1.navire.png", "images/1.piegeur.png", "images/2.explorateur.png", "images/2.navire.png",
			"images/2.pegeur.png", "images/arbre.png", "images/coffre.png", "images/sand.png", "images/cle.png" };

	/**
	 * Constructeur vide de Ile.
	 * <p>
	 * La taille est fixée à 10 et le pourcentage de rochers à 30.
	 * Initialisation des tableaux concernant le plateau. 
	 * Instanciation du tableau de "Parcelle".
	 * </p>
	 * 
	 * @see Ile#taille
	 * @see Ile#pourcentageRochers
	 * @see Ile#ile
	 * @see Ile#jeu
	 * @see Parcelle
	 */
	public Ile() {
		taille = 10;
		pourcentageRochers = 30;
		ile = new Parcelle[taille][taille];
		jeu = new int[taille][taille];
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				ile[i][j] = new Parcelle();
			}
		}
	}
	
	/**
	 * Constructeur de Ile.
	 * <p>
	 * Initialisation de la taille et du pourcentage de rochers.
	 * Initialisation des tableaux concernant le plateau. 
	 * Instanciation du tableau de "Parcelle".
	 * </p>
	 * 
	 * @param taille
     *            Taille du plateau.
     * @param pourcentage
     *            Pourcentage de rochers.
	 * 
	 * 
	 * @see Ile#taille
	 * @see Ile#pourcentageRochers
	 * @see Ile#ile
	 * @see Ile#jeu
	 * @see Parcelle
	 */
	public Ile(int taille, int pourcentage) {
		this.taille = taille;
		pourcentageRochers = pourcentage;
		ile = new Parcelle[taille][taille];
		jeu = new int[taille][taille];
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				ile[i][j] = new Parcelle();
			}
		}
	}

	/**
	 * Retourne la valeur de "taille".
	 * 
	 * @return Retourne un int.
	 * 
     * @see Ile#taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Retourne la valeur de la parcelle en question.
	 * 
	 * @param x
     *         Ligne.
	 * @param y
     *         Colonne.
     *            
	 * @return Retourne un objet.
	 * 
     * @see Ile#ile
     * @see Parcelle#getParcelle()
	 */
	public Object getParcelle(int x, int y) {
		return ile[x][y].getParcelle();
	}

	/**
	 * Retourne et met à jour le tableau de int à deux dimensions associé au plateau de "Parcelle".
     *            
	 * @return Retourne un tableau de int à deux dimensions.
	 * 
     * @see Ile#ile
     * @see Ile#jeu
     * @see Parcelle#getParcelle()
     * @see Coffre#getTresor()
     * @see Cle#getCle()
	 */
	public int[][] getJeu() {

		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				if (i == 0 || i == taille - 1 || j == 0 || j == taille - 1) {
					jeu[i][j] = 2;
				}
			}
		}

		for (int i = 1; i < taille - 1; i++) {
			for (int j = 1; j < taille - 1; j++) {
				if (ile[i][j].getParcelle() instanceof Rocher) {
					jeu[i][j] = 1;
					if (((Rocher) ile[i][j].getParcelle()).getCoffre()) {
						jeu[i][j] = 10;
					} else if (((Rocher) ile[i][j].getParcelle()).getCle()) {
						jeu[i][j] = 12;
					}
				} else if (ile[i][j].getParcelle() instanceof Vide) {
					jeu[i][j] = 11;
				} else if (ile[i][j].getParcelle() instanceof Navire) {
					jeu[i][j] = 4;
				}
			}
		}

		return jeu;
	}
	
	/**
	 * Affiche le jeu à l'aide de la classe Plateau.
	 * 
     * @see Plateau
     * @see Plateau#Plateau(String[],int)
     * @see Plateau#setJeu(int[][])
     * @see Plateau#affichage()
	 */
	public void affichage() {
		Plateau plateauAffichage = new Plateau(images, taille);
		plateauAffichage.setJeu(jeu);
		plateauAffichage.affichage();
	}

	/**
	 * Pose les rochers sur le plateau en fonction du pourcentage de rochers choisi auparavant.
	 * 
     * @see Parcelle#setParcelle(Object)
	 */
	public void remplirRochers() {
		Random random = new Random();

		for (int i = 1; i < taille - 1; i++) {
			for (int j = 1; j < taille - 1; j++) {
				if (random.nextInt(100) < pourcentageRochers) {
					ile[i][j].setParcelle(new Rocher(false, false));
				}
			}
		}
	}

	/**
	 * Place la clé et le coffre dans un rocher chacun.
	 * La position des rochers est déterminée grâce à la fonction "getPositionsRochers"
	 * Deux rochers sont tirés au hasard.
	 * 
     * @see Parcelle#setParcelle(Object)
     * @see Ile#getPositionsRochers(Parcelle[][])
	 */
	public void remplirCleCoffre() {
		Random random = new Random();

		int[][] positionsRochers = getPositionsRochers(ile);
		
		int posCle = random.nextInt(positionsRochers.length - 1);
		int posCoffre;

		do {
			posCoffre = random.nextInt(positionsRochers.length - 1);
		} while (posCle == posCoffre);

		int ligneCle = positionsRochers[posCle][1];
		int colonneCle = positionsRochers[posCle][0];
		int ligneCoffre = positionsRochers[posCoffre][1];
		int colonneCoffre = positionsRochers[posCoffre][0];

		ile[ligneCle][colonneCle].setParcelle(new Rocher(true, false));
		ile[ligneCoffre][colonneCoffre].setParcelle(new Rocher(false, true));
	}

	/**
	 * Place un navire de façon aléatoire sur l'un des bords de l'ile.
	 * 
	 * @param joueur
	 * 				Numéro du joueur
	 * 
     * @see Parcelle#setParcelle(Object)
     * @see Navire#debarquementPossible(Parcelle[][], int, int, int)
	 */
	public void remplirNavire(int joueur) {

		Random random = new Random();
		int x = 0;
		int y = 0;
		int bordIle;

		do {
			bordIle = random.nextInt(4);

			if (bordIle == 0) {
				x = 1;
				y = random.nextInt(taille - 4) + 2;
			} else if (bordIle == 1) {
				x = random.nextInt(taille - 4) + 2;
				y = taille - 2;
			} else if (bordIle == 2) {
				x = taille - 2;
				y = random.nextInt(taille - 4) + 2;
			} else if (bordIle == 3) {
				x = random.nextInt(taille - 4) + 2;
				y = 1;
			}
		} while (!(ile[x][y]).debarquementPossible(ile, x, y, taille));

		ile[x][y].setParcelle(new Navire(joueur));
		
		if (joueur == 1) {
			posNav1 = new int[] { x, y };
		} else {
			posNav2 = new int[] { x, y };
		}

	}

	/**
	 * Retourne la position du navire du joueur 1.
	 * 
	 * @return Retourne un int.
	 * 
     * @see Ile#posNav1
	 */
	public int[] getPosNav1() {
		return posNav1;
	}

	/**
	 * Retourne la position du navire du joueur 2.
	 * 
	 * @return Retourne un int.
	 * 
     * @see Ile#posNav2
	 */
	public int[] getPosNav2() {
		return posNav2;
	}

	/**
	 * Retourne la position des rochers dans un tableau à deux dimensions.
	 * 
	 * @param plateau
	 *            Ile en question (ile).
	 * 
	 * @return Retourne un tableau de int à deux dimensions.
	 * 
	 * @see Ile#ile
	 * @see Parcelle#getParcelle()
	 */
	public int[][] getPositionsRochers(Parcelle[][] plateau) {
		int nbRochers = 0;

		for (int i = 1; i < taille - 1; i++) {
			for (int j = 1; j < taille - 1; j++) {
				if (plateau[j][i].getParcelle() instanceof Rocher) {
					nbRochers = nbRochers + 1;
				}
			}
		}
		
		int[][] positions = new int[nbRochers][2];
		int nb = 0;

		for (int i = 1; i < taille - 1; i++) {
			for (int j = 1; j < taille - 1; j++) {
				if (plateau[j][i].getParcelle() instanceof Rocher) {
					positions[nb][0] = j;
					positions[nb][1] = i;
					nb = nb + 1;
				}
			}
		}

		return positions;
	}

	/**
	 * Vérifie si tous les rochers sont accessibles en comptant le nombre de voisins. Si il y a plus de un voisin autour alors le rocher est enlevé.
	 * 
	 * @see Ile#getPositionsRochers(Parcelle[][])
	 * @see Parcelle#getParcelle()
	 * @see Parcelle#removeParcelle()
	 */
	public void accessible() {
		int[][] positionsRochers = getPositionsRochers(ile);

		int nbVoisins = 0;

		for (int[] posRocher : positionsRochers) {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (ile[(posRocher[0] + i)][(posRocher[1] + j)].getParcelle() instanceof Rocher) {
						nbVoisins = nbVoisins + 1;
					}
				}
			}
			
			if (nbVoisins > 1) {
				ile[posRocher[0]][posRocher[1]].removeParcelle();
			}
			nbVoisins = 0;
		}

	}

}

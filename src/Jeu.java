/**
 * <b>Jeu est la classe qui permet de lancer deux modes différents, un avec des valeurs par défaut et un avec des valeurs personnalisables</b>
 * <p>
 * Elle est caractérisée par :
 * <ul>
 * <li>Une ile</li>
 * </ul>
 * </p>
 * <p>
 * Elle créer l'ile, la remplit et l'affiche.
 * </p>
 * 
 * @see Ile
 * 
 * @author Laurine
 */
public class Jeu {
	
	/**
	 * Ile du jeu en cours.
	 */
	private Ile ile;
	
	/**
	 * Constructeur vide de Jeu.
	 * 
	 * @see Ile#Ile()
	 * @see Ile#remplirRochers()
	 * @see Ile#remplirNavire(int)
	 * @see Ile#accessible()
	 * @see Ile#remplirCleCoffre()
	 * @see Ile#getJeu()
	 * @see Ile#affichage()
	 */
	public Jeu(){
		ile=new Ile();
		ile.remplirRochers();
		ile.remplirNavire(1);
		ile.remplirNavire(2);
		ile.accessible();
		ile.remplirCleCoffre();
		ile.getJeu();
		ile.affichage();
	}
	
	/**
	 * Constructeur de Jeu.
	 * 
	 * @param taille
	 * 				Taille de l'ile voulue
	 * 
	 * @param pourcentageRochers
	 * 				Pourcentage de rochers voulu
	 * 
	 * @see Ile#Ile(int, int)
	 * @see Ile#remplirRochers()
	 * @see Ile#remplirNavire(int)
	 * @see Ile#accessible()
	 * @see Ile#remplirCleCoffre()
	 * @see Ile#getJeu()
	 * @see Ile#affichage()
	 */
	public Jeu(int taille,int pourcentageRochers){
		ile=new Ile(taille,pourcentageRochers);
		ile.remplirRochers();
		ile.remplirNavire(1);
		ile.remplirNavire(2);
		ile.accessible();
		ile.remplirCleCoffre();
		ile.getJeu();
		ile.affichage();
	}
	

	
}

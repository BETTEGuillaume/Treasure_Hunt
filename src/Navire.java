/**
 * <b>Navire est la classe représentant le navire d'un joueur. C'est un type de Parcelle</b>
 * <p>
 * Elle est caractérisée par :
 * <ul>
 * <li>Un int concernant le numéro du joueur</li>
 * </ul>
 * </p>
 * <p>
 * Il est possible de regarder la valeur de son attribut (joueur).
 * </p>
 * 
 * @see Parcelle
 * 
 * @author Laurine
 */
public class Navire extends Parcelle{
	/**
	 * Cet attribut correspond au numéro du joueur.
	 * 
     * @see Cle#Navire(int)
     * @see Cle#getJoueur()
	 */
	private int joueur;
	
	/**
	 * Constructeur de Navire. Associe un numéro de joueur à l'attribut de l'instance.
	 *         
     * @see Ile#remplirNavire(int)
	 */
	public Navire(int j){
		if(j==1 || j==2){
			joueur=j;
		}
	}
	
	/**
	 * Retourne la valeur de l'attribut "joueur" 
	 * 
	 * @return Retourne un int.
	 * 
     * @see Navire#joueur
	 */
	public int getJoueur(){
		return joueur;
	}

}
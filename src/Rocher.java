
/**
 * <b>Rocher est un type de Parcelle</b>
 * <p>
 * Le rocher est caract�ris� par :
 * <ul>
 * <li>Un objet Cle</li>
 * <li>Un objet Coffre</li>
 * </ul>
 * </p>
 * 
 * @see Parcelle
 * 
 * @author Laurine
 */
public class Rocher extends Parcelle {
	/**
	 * Repr�sente la cl�. Vaut null si il n'y a pas de cl� sous le rocher.
	 * 
	 * @see Cle
	 */
	private Cle cle;

	/**
	 * Repr�sente le coffre. Vaut null si il n'y a pas de coffre sous le rocher.
	 * 
	 * @see Coffre
	 */
	private Coffre coffre;

	/**
	 * Constructeur de Rocher. En fonction des boolean pass�s en param�tre il y
	 * aura instanciation ou non d'une cl� ou d'un coffre.
	 * 
	 * @param presenceCle
	 *            Si true alors il y a une cl�
	 * 
	 * @param presenceCoffre
	 *            Si true alors il y a un coffre
	 * 
	 * @see Cle
	 * @see Coffre
	 */
	public Rocher(boolean presenceCle, boolean presenceCoffre) {
		if (presenceCle) {
			cle = new Cle();
		} else if (presenceCoffre) {
			coffre = new Coffre();
		}
	}

	/**
	 * Methode permettant de regarder ce qu'il y a sous le rocher. Si il y a une
	 * cl� alors il est possible de la prendre. S'il y a un coffre avec un
	 * tr�sor alors il est possible de prendre le tr�sor.
	 * 
	 * @see Cle
	 * @see Coffre
	 */
	public void souleverRocher() {
		if (cle != null) {
			cle.prendreCle();
		} else if (coffre != null) {
			coffre.prendreTresor(false);// Il manque encore des m�thodes et des
										// classes pour faire la suite
		}
	}

	/**
	 * Retourne un boolean correspondant � la pr�sence de la cl� sous le rocher.
	 * 
	 * @return Un boolean
	 * 
	 * @see Rocher#cle
	 */
	public boolean getCle() {
		if (cle != null) {
			return true;
		}
		return false;
	}

	/**
	 * Retourne un boolean correspondant � la pr�sence du coffre sous le rocher.
	 * 
	 * @return Un boolean
	 * 
	 * @see Rocher#coffre
	 */
	public boolean getCoffre() {
		if (coffre != null) {
			return true;
		}
		return false;
	}
	
}


/**
 * <b>Rocher est un type de Parcelle</b>
 * <p>
 * Le rocher est caractérisé par :
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
	 * Représente la clé. Vaut null si il n'y a pas de clé sous le rocher.
	 * 
	 * @see Cle
	 */
	private Cle cle;

	/**
	 * Représente le coffre. Vaut null si il n'y a pas de coffre sous le rocher.
	 * 
	 * @see Coffre
	 */
	private Coffre coffre;

	/**
	 * Constructeur de Rocher. En fonction des boolean passés en paramètre il y
	 * aura instanciation ou non d'une clé ou d'un coffre.
	 * 
	 * @param presenceCle
	 *            Si true alors il y a une clé
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
	 * clé alors il est possible de la prendre. S'il y a un coffre avec un
	 * trésor alors il est possible de prendre le trésor.
	 * 
	 * @see Cle
	 * @see Coffre
	 */
	public void souleverRocher() {
		if (cle != null) {
			cle.prendreCle();
		} else if (coffre != null) {
			coffre.prendreTresor(false);// Il manque encore des méthodes et des
										// classes pour faire la suite
		}
	}

	/**
	 * Retourne un boolean correspondant à la présence de la clé sous le rocher.
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
	 * Retourne un boolean correspondant à la présence du coffre sous le rocher.
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

/**
 * <b>Cle est la classe représentant la clé permettant d'ouvrir le coffre. La clé se situe sous un Rocher.</b>
 * <p>
 * La clé est caractérisée par :
 * <ul>
 * <li>Un boolean permettant de savoir si la clé a déjà été ramassée</li>
 * </ul>
 * </p>
 * <p>
 * Il est possible de ramasser cette clé et de regarder la valeur de son attribut (cle).
 * </p>
 * 
 * @see Rocher
 * 
 * @author Laurine
 */
public class Cle {
	/**
	 * Cet attribut détermine si la clé est toujours présente sous le rocher.
	 * 
     * @see Cle#prendreCle(cle)
     * @see Cle#getCle()
	 */
	private boolean cle = true;

	/**
	 * Rammasse la clé si elle est toujours présente.
	 * 
	 * @return Retourne un boolean, qui servira à déterminer si le ramassage de
	 *         la clé était possible ou non.
	 *         
     * @see Cle#cle
	 */
	public boolean prendreCle() {
		if (cle) {
			cle = false;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retourne la valeur de l'attribut "cle" (si elle est toujours présente ou
	 * non).
	 * 
	 * @return Retourne un boolean.
	 * 
     * @see Cle#cle
	 */
	public boolean getCle() {
		return cle;
	}
}

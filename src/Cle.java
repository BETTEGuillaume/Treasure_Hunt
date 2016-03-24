/**
 * <b>Cle est la classe repr�sentant la cl� permettant d'ouvrir le coffre. La cl� se situe sous un Rocher.</b>
 * <p>
 * La cl� est caract�ris�e par :
 * <ul>
 * <li>Un boolean permettant de savoir si la cl� a d�j� �t� ramass�e</li>
 * </ul>
 * </p>
 * <p>
 * Il est possible de ramasser cette cl� et de regarder la valeur de son attribut (cle).
 * </p>
 * 
 * @see Rocher
 * 
 * @author Laurine
 */
public class Cle {
	/**
	 * Cet attribut d�termine si la cl� est toujours pr�sente sous le rocher.
	 * 
     * @see Cle#prendreCle(cle)
     * @see Cle#getCle()
	 */
	private boolean cle = true;

	/**
	 * Rammasse la cl� si elle est toujours pr�sente.
	 * 
	 * @return Retourne un boolean, qui servira � d�terminer si le ramassage de
	 *         la cl� �tait possible ou non.
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
	 * Retourne la valeur de l'attribut "cle" (si elle est toujours pr�sente ou
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

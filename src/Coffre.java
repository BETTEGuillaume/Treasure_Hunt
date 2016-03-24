/**
 * <b>Coffre est la classe repr�sentant le coffre contenant le tr�sor. Le coffre se situe sous un Rocher.</b>
 * <p>
 * Le coffre est caract�ris� par :
 * <ul>
 * <li>Un boolean permettant de savoir si le tr�sor a d�j� �t� ramass�</li>
 * </ul>
 * </p>
 * <p>
 * Il est possible de ramasser le tr�sor situ� dans le coffre et de regarder la valeur de son attribut (tr�sor).
 * </p>
 * 
 * @see Rocher
 * 
 * @author Laurine
 */
public class Coffre {
	/**
	 * Cet attribut d�termine si le tr�sor est toujours pr�sent dans le coffre.
	 * 
     * @see Coffre#prendreTr�sor(cle)
     * @see Coffre#getTr�sor()
	 */
	private boolean tresor=true;
	
	/**
	 * Rammasse le tr�sor si le joueur poss�de la cl� et si le tr�sor est toujours pr�sent.
	 * 
	 * @param cle
	 * 			Si le joueur poss�de la cl� ou non
	 * 
	 * @return Retourne un boolean, qui servira � d�terminer si le ramassage du
	 *         tr�sor �tait possible ou non.
	 *         
     * @see Coffre#tresor
	 */
	public boolean prendreTresor(boolean cle){
		if(cle){
			tresor=false;
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Retourne la valeur de l'attribut "tresor" (si il est toujours pr�sent ou
	 * non).
	 * 
	 * @return Retourne un boolean.
	 * 
     * @see Coffre#tresor
	 */
	public boolean getTresor(){
		return tresor;
	}
}

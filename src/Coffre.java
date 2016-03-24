/**
 * <b>Coffre est la classe représentant le coffre contenant le trésor. Le coffre se situe sous un Rocher.</b>
 * <p>
 * Le coffre est caractérisé par :
 * <ul>
 * <li>Un boolean permettant de savoir si le trésor a déjà été ramassé</li>
 * </ul>
 * </p>
 * <p>
 * Il est possible de ramasser le trésor situé dans le coffre et de regarder la valeur de son attribut (trésor).
 * </p>
 * 
 * @see Rocher
 * 
 * @author Laurine
 */
public class Coffre {
	/**
	 * Cet attribut détermine si le trésor est toujours présent dans le coffre.
	 * 
     * @see Coffre#prendreTrésor(cle)
     * @see Coffre#getTrésor()
	 */
	private boolean tresor=true;
	
	/**
	 * Rammasse le trésor si le joueur possède la clé et si le trésor est toujours présent.
	 * 
	 * @param cle
	 * 			Si le joueur possède la clé ou non
	 * 
	 * @return Retourne un boolean, qui servira à déterminer si le ramassage du
	 *         trésor était possible ou non.
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
	 * Retourne la valeur de l'attribut "tresor" (si il est toujours présent ou
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

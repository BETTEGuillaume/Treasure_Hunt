
public class Rocher extends Parcelle{
	private Cle cle;
	private Coffre coffre;
	
	public Rocher(boolean PresenceCle,boolean PresenceCoffre){
		if(PresenceCle){
			cle=new Cle();
		}else if(PresenceCoffre){
			coffre=new Coffre();
		}
	}
	
	public void souleverRocher(){
		if(cle!=null){
			cle.prendreCle();
		}else if(coffre!=null){
			coffre.prendreTresor(cle.getCle());
		}
	}
	
	public boolean getCle(){
		if(cle!=null){
			return true;
		}
		return false;
	}
	
	public boolean getCoffre(){
		if(coffre!=null){
			return true;
		}
		return false;
	}
	
}

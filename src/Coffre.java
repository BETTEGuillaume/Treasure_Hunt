
public class Coffre {
	private boolean tresor=true;
	
	public void prendreTresor(boolean cle){
		if(cle){
			tresor=false;
		}
	}
	
	public boolean getTresor(){
		return tresor;
	}
}

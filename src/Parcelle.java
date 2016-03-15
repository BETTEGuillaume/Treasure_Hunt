
public class Parcelle {
	
	private Object obj;
	
	public Parcelle(){
		obj=new Vide();
	}
	
	public Object getParcelle(){
		return obj;	
	}
	
	public void setParcelle(Object objet){
		obj=objet;
	}
	
	public void removeParcelle(){
		obj=new Vide();
	}
	
	public boolean debarquementPossible(Parcelle[][] ile,int x,int y,int taille){

		if(x==1 && (y!=0 && y!=taille-1)){
			if((ile[x+1][y].getParcelle() instanceof Rocher || ile[x+1][y].getParcelle() instanceof Navire) &&
				(ile[x][y-1].getParcelle() instanceof Rocher || ile[x][y-1].getParcelle() instanceof Navire || y==2) &&
				(ile[x][y+1].getParcelle() instanceof Rocher || ile[x][y+1].getParcelle() instanceof Navire || y==taille-2)){
				return false;
			}
		}else if(x==taille-2 && (y!=0 && y!=taille-1)){
			if((ile[x-1][y].getParcelle() instanceof Rocher || ile[x-1][y].getParcelle() instanceof Navire) &&
				(ile[x][y-1].getParcelle() instanceof Rocher || ile[x][y-1].getParcelle() instanceof Navire || y==2) &&
				(ile[x][y+1].getParcelle() instanceof Rocher || ile[x][y+1].getParcelle() instanceof Navire || y==taille-2)){
				return false;	
			}
		}else if(y==1 && (x!=0 && x!=taille-1)){
			if((ile[x][y+1].getParcelle() instanceof Rocher || ile[x][y+1].getParcelle() instanceof Navire) &&
				(ile[x-1][y].getParcelle() instanceof Rocher || ile[x-1][y].getParcelle() instanceof Navire || x==2) &&
				(ile[x+1][y].getParcelle() instanceof Rocher || ile[x+1][y].getParcelle() instanceof Navire || x==taille-2)){
				return false;	
			}
		}else if(y==taille-2 && (x!=0 && x!=taille-1)){
			if((ile[x][y-1].getParcelle() instanceof Rocher || ile[x][y-1].getParcelle() instanceof Navire) &&
				(ile[x-1][y].getParcelle() instanceof Rocher || ile[x-1][y].getParcelle() instanceof Navire || x==2) &&
				(ile[x+1][y].getParcelle() instanceof Rocher || ile[x+1][y].getParcelle() instanceof Navire || x==taille-2)){
				return false;	
			}
		}
		if(ile[x][y].getParcelle() instanceof Rocher || ile[x][y].getParcelle() instanceof Navire){
			return false;
		}
		
		return true;

	}
	
	public boolean getCle(){
		return ((Rocher)obj).getCle();
	}
	
	public boolean getCoffre(){
		return ((Rocher)obj).getCoffre();
	}
}

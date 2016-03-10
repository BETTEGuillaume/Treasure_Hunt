
import java.util.HashMap;


public class Parcelle {
	
	private String nom;
	
	private static HashMap<String, int[]> pos = new HashMap<String, int[]>();
	
	public Parcelle(){
		
	}
	public Parcelle(String nom){
		this.nom = nom;
	}	
	
	public Parcelle(String nom, int x, int y){
		this(nom);
		pos.put(nom, new int[]{x,y});
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public boolean equals(Parcelle p){
		return this.nom.equals(p.nom);
	}
	
	public static void ajouterPosition(String nom, int[] posi){
		pos.put(nom, posi);
	}
	
}

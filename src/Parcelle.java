public class Parcelle {
	
	private String nom;
	private int decor;

	public Parcelle(){
	}
	public Parcelle(String nom){
		this.nom = nom;
	}
	public Parcelle(String nom, int decor){
		this.nom = nom;
		this.decor = decor;
	}
	public int getDecor() {
		return decor;
	}
	public void setDecor(int decor) {
		this.decor = decor;
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
	
	
}

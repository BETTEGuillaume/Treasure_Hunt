
public class Jeu {
	private Ile ile;
	
	public Jeu(){
		ile=new Ile();
		ile.remplirRochers();
		ile.remplirNavire(1);
		ile.remplirNavire(2);
		ile.accessible();
		ile.remplirCleCoffre();
		ile.getJeu();
		ile.affichage();
		/*
		boolean[][] acces = ile.toutEstAccessible(new boolean[taille][taille],ile.getPosNav1()[0],ile.getPosNav1()[1]);

		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				System.out.print(acces[i][j] + " ");
			}
			System.out.println();
		}*/
	}
	
	
	public Jeu(int taille,int pourcentageRochers){
		ile=new Ile(taille,pourcentageRochers);
		ile.remplirRochers();
		ile.remplirNavire(1);
		ile.remplirNavire(2);
		ile.accessible();
		ile.remplirCleCoffre();
		ile.getJeu();
		ile.affichage();
		//ile.toutEstAccessible(new boolean[taille][taille],ile.getPosNav1()[0],ile.getPosNav1()[1]);
	}
	

	
}

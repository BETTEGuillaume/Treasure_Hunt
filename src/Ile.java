import java.util.Random;

public class Ile {
	private Parcelle[][] ile;
	private int taille;
	private int pourcentageRochers;
	private int[][] jeu;
	private int[] posNav1;
	private int[] posNav2;
	
	private String[] images = { "images/rocher.png", "images/mer.png", "images/1.explorateur.png", "images/1.navire.png",
			"images/1.piegeur.png", "images/2.explorateur.png", "images/2.navire.png", "images/2.pegeur.png",
			"images/arbre.png", "images/coffre.png","images/sand.png","images/cle.png" };
	
	public Ile(){
		taille=10;
		pourcentageRochers=30;
		ile=new Parcelle[taille][taille];
		jeu=new int[taille][taille];
		for(int i=0;i<taille;i++){
		    for(int j=0;j<taille;j++){
		    	ile[i][j]=new Parcelle();
		    }
		}
	}
	
	public Ile(int taille,int pourcentage){
		this.taille=taille;
		pourcentageRochers=pourcentage;
		ile=new Parcelle[taille][taille];
		jeu=new int[taille][taille];
		for(int i=0;i<taille;i++){
		    for(int j=0;j<taille;j++){
		    	ile[i][j]=new Parcelle();
		    }
		}
	}
	
	
	public int getTaille(){
		return taille;
	}
	
	public Object getParcelle(int x,int y){
		return ile[x][y].getParcelle();
	}
	
	public int[][] getJeu(){
		
		for(int i=0;i<taille;i++){
		    for(int j=0;j<taille;j++){
				if(i==0 || i==taille-1 || j==0 || j==taille-1){
					jeu[i][j]=2;
				}				
		    }
		}
		
		for(int i=1;i<taille-1;i++){
		    for(int j=1;j<taille-1;j++){
				if(ile[i][j].getParcelle() instanceof Rocher){
					jeu[i][j]=1;
					if(((Rocher)ile[i][j].getParcelle()).getCoffre()){
						jeu[i][j]=10;
					}else if(((Rocher)ile[i][j].getParcelle()).getCle()){
						jeu[i][j]=12;
					}
				}else if(ile[i][j].getParcelle() instanceof Vide){
					jeu[i][j]=11;
				}else if(ile[i][j].getParcelle() instanceof Navire){
					jeu[i][j]=4;
				}
		    }
		}
		
		return jeu;
	}
	
	public void affichage(){
		Plateau plateauAffichage=new Plateau(images,taille);
		plateauAffichage.setJeu(jeu);
		plateauAffichage.affichage();
	}
	
	public void remplirRochers(){
		Random random=new Random();
		
		for(int i=1;i<taille-1;i++){
		    for(int j=1;j<taille-1;j++){
				if(random.nextInt(100)<pourcentageRochers){
					ile[i][j].setParcelle(new Rocher(false,false));
				}
		    }
		}		
	}
	
	public void remplirCleCoffre(){	
		Random random=new Random();
		
		int[][] positionsRochers=getPositionsRochers(ile);
		
		int nbPositions=0;
		int i=0;
		while(positionsRochers[i][0]!=0){
			nbPositions=nbPositions+1;
			i=i+1;
		}
		
		int posCle=random.nextInt(nbPositions-1);
		int posCoffre;
		
		do{
			posCoffre=random.nextInt(nbPositions-1);
		}while(posCle==posCoffre);
		
		int ligneCle=positionsRochers[posCle][1];
		int	colonneCle=positionsRochers[posCle][0];
		int ligneCoffre=positionsRochers[posCoffre][1];
		int colonneCoffre=positionsRochers[posCoffre][0];
		
		ile[ligneCle][colonneCle].setParcelle(new Rocher(true,false));
		ile[ligneCoffre][colonneCoffre].setParcelle(new Rocher(false,true));	
	}
	
	public void remplirNavire(int joueur){

		Random random=new Random();
		int x=0;
		int y=0;
		int bordIle;

		do {
			bordIle = random.nextInt(4);

			if (bordIle == 0) {
				x = 1;
				y = random.nextInt(taille - 4) + 2;
			} else if (bordIle == 1) {
				x = random.nextInt(taille - 4) + 2;
				y = taille - 2;
			} else if (bordIle == 2) {
				x = taille - 2;
				y = random.nextInt(taille - 4) + 2;
			} else if (bordIle == 3) {
				x = random.nextInt(taille - 4) + 2;
				y = 1;
			}
		} while(!ile[x][y].debarquementPossible(ile, x, y, taille));

		ile[x][y].setParcelle(new Navire(joueur));
		if(joueur==1){
			posNav1=new int[]{x,y};
		}else{
			posNav2=new int[]{x,y};
		}

	}
	
	public int[] getPosNav1(){
		return posNav1;
	}
	
	public int[] getPosNav2(){
		return posNav2;
	}
	
	public int[][] getPositionsRochers(Parcelle[][] plateau){
		int[][] positions=new int[(taille-1)*(taille-1)][2];
		int nb=0;
		
		for(int i=1;i<taille-1;i++){
			for(int j=1;j<taille-1;j++){
				if(plateau[j][i].getParcelle() instanceof Rocher){
					positions[nb][0]=j;
					positions[nb][1]=i;
					nb=nb+1;
				}
			}
		}

		return positions;
	}

	public void accessible() {
		int[][] positions = getPositionsRochers(ile); //trop de lignes "vides"
		
		int ligne=0;
		
		while(positions[ligne][0]!=0){
			ligne=ligne+1;
		}
		
		int[][] positionsRochers=new int[ligne][2];
		ligne=0;
		
		while(positions[ligne][0]!=0){
			positionsRochers[ligne][0]=positions[ligne][0];
			positionsRochers[ligne][1]=positions[ligne][1];	
			ligne=ligne+1;
		}

		int nbVoisins = 0;

		for (int[] posRocher : positionsRochers) {
			System.out.println(posRocher[0] + " " + posRocher[1]);
			System.out.println();

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {

					System.out.println((posRocher[0] + i) + " " + (posRocher[1] + j));

					if (ile[(posRocher[0] + i)][(posRocher[1] + j)].getParcelle() instanceof Rocher) {
						nbVoisins = nbVoisins + 1;
					}
				}
			}
			System.out.println(nbVoisins);
			System.out.println("\n\n");
			if (nbVoisins > 1) {
				ile[posRocher[0]][posRocher[1]].removeParcelle();
			}
			nbVoisins = 0;
		}

	}

	/*
	 * public boolean[][] toutEstAccessible(boolean[][] accesCases, int y, int
	 * x) { accesCases[x][y] = true; System.out.println(x + " " + y); for (int i
	 * = 0, j = -1; i < 2 && j < 2; i++, j++) { if ((ile[x + i][y +
	 * j].getParcelle() instanceof Vide || ile[x + i][y + j].getParcelle()
	 * instanceof Navire) && ((x+i)>1 && (x+i)<taille-2 && (y+i)>1 &&
	 * (y+i)<taille-2)) { toutEstAccessible(accesCases, x + i, y + j); } }
	 * return accesCases; }
	 */

}

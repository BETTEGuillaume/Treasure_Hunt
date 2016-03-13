import java.util.ArrayList;

public class Navire {

	private static int nbEquipe = 1;

	private int equipe = 0;

	ArrayList<String> equipage = new ArrayList<String>();

	public Navire() {

	}

	public Navire(ArrayList<String> team) {
		setEquipe(nbEquipe++);
		equipage = team;
	}

	public int getEquipe() {
		return equipe;
	}

	public void setEquipe(int equipe) {
		this.equipe = equipe;
	}

	public static int getNbEquipe() {
		return nbEquipe;
	}

	public static void setNbEquipe(int nbEquipe) {
		Navire.nbEquipe = nbEquipe;
	}

}

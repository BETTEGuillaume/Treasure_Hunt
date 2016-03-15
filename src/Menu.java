import javax.swing.JOptionPane;

public class Menu {

	String choix = JOptionPane.showInputDialog(null,
			"Que souhaitez vous faire? \n1)Jouer avec une taille que vous choississez \n2)Jouer avec une taille de 10*10\n3)Regles \n4)Quitter");
	// Si l'ulitisateur choisi d'avoir les regles
	boolean boo = false;
	boolean boo1 = false;
	boolean boo2 = false;
	int minimum = 10;
	int maximum = 50;

	{
		// Rajouter la verification si les arguments sont bien des int et non
		// des char;
		while (!boo) {
			// Si l'utilisateur choisit d'appuyer sur la croix rouge en haut
			if (choix == null) {
				JOptionPane.showMessageDialog(null, "Au revoir ! émoticône smile");
				boo = true;
			}

			// Si l'utilisateur choisit de configurer sa taille
			else if (choix.equals("1")) {
				String taille = JOptionPane.showInputDialog(null,"Quelle est la taille de votre carte?(Minimum " + minimum + ")");
				if (taille == null) {
					JOptionPane.showMessageDialog(null,
							"Vous avez décidez de vous enfuir ! Levez l'ancre moussaillon !!");
					boo = true;
					break;
				}
				// Voir pour le if lorsque l'on ne rentre aucune taille(direct
				// entrée)
				while (!boo1) {
					if (!taille.matches("[0-9]*")) {
						JOptionPane.showMessageDialog(null, "Veuillez rentrer un argument valide s'il vous plait.");
						taille = JOptionPane.showInputDialog(null,
								"Quelle est la taille de votre carte?(Minimum " + minimum + ")");
					} else if (Integer.parseInt(taille) < minimum) {
						JOptionPane.showMessageDialog(null,
								"Veuillez rentrer une taille supérieure à " + minimum + ".");
						taille = JOptionPane.showInputDialog(null, "Quelle est la taille de votre carte?");
					} else if (Integer.parseInt(taille) > maximum) {
						JOptionPane.showMessageDialog(null,
								"Veuillez rentrer une taille inférieure à " + maximum + ".");
						taille = JOptionPane.showInputDialog(null, "Quelle est la taille de votre carte?");
					} else
						boo1 = true;
				}

				String pourcentage = JOptionPane.showInputDialog(null,"Choisissez une proportion de rochers?(20 pour l'instant)");
				
				while (!boo2) {
					if (!pourcentage.matches("[0-9]*")|| Integer.parseInt(pourcentage)!=20) {
						JOptionPane.showMessageDialog(null, "Veuillez rentrer un argument valide s'il vous plait.");
						pourcentage = JOptionPane.showInputDialog(null,"Choisissez une proportion de rochers?(20 pour l'instant)");
					}else{
						boo2 = true;
					}
				}
				
				Jeu l = new Jeu(Integer.parseInt(taille),Integer.parseInt(pourcentage));
				boo = true;
			}

			// Si l'utilisateur utilise la carte par défaut
			else if (choix.equals("2")) {
				Jeu z = new Jeu();
				boo = true;
			} else if (choix.equals("3")) {
				JOptionPane.showMessageDialog(null, "Voici les regles du jeu !\n ");
				choix = JOptionPane.showInputDialog(null,
						"Que souhaitez vous faire? \n1)Jouer avec une taille que vous choississez \n2)Jouer avec une taille de 10*10\n3)Regles \n4)Quitter");
			} else if (choix.equals("4")) {
				JOptionPane.showMessageDialog(null, "Au revoir ! émoticône smile");
				boo = true;
			}

			// Changer le max du matches en fonction des choix possible dans
			// le
			// menu
			else if (!choix.matches("[0-4]")) {
				JOptionPane.showMessageDialog(null, "Veuillez rentrer un argument valide s'il vous plait.");
				choix = JOptionPane.showInputDialog(null,
						"Que souhaitez vous faire? \n1)Jouer avec une taille que vous choississez \n2)Jouer avec une taille de 10*10\n3)Regles \n4)Quitter");

			}

		}
	}

}
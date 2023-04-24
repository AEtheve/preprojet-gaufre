package Modele;
import Global.Configuration;
import Structures.Coords;

public class IA {
    
    public Jeu jeu;

    public static IA nouvelle(Jeu j){

        IA resultat = null;
		// Méthode de fabrication pour l'IA, qui crée le bon objet selon la config
		String type = Configuration.IA;
		switch (type) {
			case "Faible":
				resultat = new IAFaible(j);
				break;
			// case "Moyen":
			// 	resultat = new IAMoyen();
			// 	break;
			// case "Eleve":
			// 	resultat = new IAEleve();
			// 	break;
			default:
				Configuration.erreur("IA de type " + type + " non supportée");
		}
		if (resultat != null) {
			resultat.jeu = j;
		}
		return resultat;

    }

    public void aJoue(Coords c) {
        return;
    }

    public Coords Jouer() {
        return null;
    }
}
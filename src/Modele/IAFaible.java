package Modele;


import Structures.*;

public class IAFaible extends IA {
    ArbreEtOu arbre;
    // Jeu j;
    
    public IAFaible(Jeu jeu) {
        int[] config = jeu.getPlateau().getConfig();
        if (jeu.getPlayer()==1) {
            // Si c'est a l'IA de jouer a l'instanciation
            arbre = new ArbreEtOu(false);
            arbre.CalculJoueurA(config);
        } else {
            // Sinon
            arbre = new ArbreEtOu(true);
            arbre.CalculJoueurB(config);
        }
    }
    
    // Appelé quand le joueur humain joue
    @Override
    public void aJoue(Coords c) {
        arbre = arbre.GetSuivant(c);
    }
    
    // Retourne un coup à jouer pour l'IA
    @Override
    public Coords Jouer(){
        if (arbre.gagnant==false) {
            Coords out = arbre.suivants.get(0).GetFirst();
            arbre = arbre.suivants.get(0).GetSecond();
            return out;
        } else {
            for (Couple<Coords, ArbreEtOu> couple: arbre.suivants) {
                if (couple.GetSecond().gagnant) {
                    arbre = couple.GetSecond();
                    return couple.GetFirst();
                }
            }

            // Jamais atteint
            return null;
        }
    }
}

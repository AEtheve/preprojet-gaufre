package Modele;

import Patterns.Observable;

public class Jeu extends Observable {
    Plateau plateau;

    public Jeu(int width, int height) {
        plateau = new Plateau(width, height);
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void efface(int x, int y) {
        if(termine(x,y)){
            System.out.println("Le jeu est terminé");
            return;
        }
        plateau.efface(x, y);
        metAJour();
    }

    boolean termine(int x, int y) {
        return plateau.estPoison(x, y);
    }
    
}

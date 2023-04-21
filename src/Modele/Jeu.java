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
        if (plateau.efface(x, y)) {
            metAJour();
        }
    }
    
}

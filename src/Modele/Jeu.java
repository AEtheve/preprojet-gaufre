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
            System.out.println("Le joueur " + (plateau.getPlayer() == 0 ? 2 : 1) + " a gagné");
            plateau.efface(0,1);
            plateau.efface(1,0);
            metAJour();
            return;
        }
        plateau.efface(x, y);
        plateau.setPlayer(plateau.getPlayer() == 0 ? 1 : 0);
        metAJour();
    }

    boolean termine(int x, int y) {
        return plateau.estPoison(x, y);
    }
    
}

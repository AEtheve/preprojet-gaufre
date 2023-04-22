package Modele;

import Patterns.Observable;

public class Jeu extends Observable {
    Plateau plateau;

    public Jeu(int width, int height) {
        plateau = new Plateau(width, height,"pixel");
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void resetPlateau(){
        plateau = new Plateau(plateau.getWidth(), plateau.getHeight(),plateau.getStyle());
    }

    public void efface(int x, int y) {
        if(termine(x,y)){
            // A modifier pour utiliser InfoBox de InterfaceGraphique pour afficher le vainqueur directement dans la fenêtre (et plus dans la console)
            System.out.println("Le jeu est terminé");
            System.out.println("Le joueur " + (plateau.getPlayer() == 0 ? 2 : 1) + " a gagné ! (" + (plateau.getCounter()+1) + " coups joués lors de cette partie)");  // +1 coup car le coup perdant n'est pas ajouté avant
            // Reset du plateau pour relancer une nouvelle partie          
            resetPlateau();
            metAJour();
            return;
        }
        if (plateau.estMange(x, y)) {
            return;
        }
        plateau.efface(x, y);
        plateau.setPlayer(plateau.getPlayer() == 0 ? 1 : 0);
        plateau.setCounter(plateau.getCounter() + 1);
        metAJour();
    }

    boolean termine(int x, int y) {
        return plateau.estPoison(x, y);
    }
    
}

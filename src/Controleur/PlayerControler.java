package Controleur;

import Vue.CollecteurEvenements;
import Vue.InterfaceUtilisateur;
import Modele.Jeu;
import Structures.Coords;

public class PlayerControler implements CollecteurEvenements {
    Jeu j;
    InterfaceUtilisateur vue;

    public PlayerControler(Jeu j) {
        this.j = j;
    }

    @Override
    public void onClick(int x, int y) {
        if (x < 0 || x >= j.getPlateau().getWidth() || y < 0 || 
                y >= j.getPlateau().getHeight() || j.getPlateau().estMange(x, y)) {
            return;
        }

        j.upCounter();
        j.changePlayer();

        if(!testFin(x, y))
            j.efface(x, y);

        if (j.getNiveauIA()!=Jeu.IA_AUCUNE) {
            // System.out.println("IA JOUE");
            j.ia.aJoue(new Coords(x, y));

            Coords play_ia = j.ia.Jouer();

            j.efface(play_ia.x, play_ia.y);
            j.changePlayer();
            j.upCounter();
        }
    }

    @Override
    public void onKeyPress(int keyCode) {
        if (keyCode == 37) {
            j.annule();
            j.metAJour();
        } 
        else if (keyCode == 39) {
            j.refait();
            j.metAJour();
        }
    }

    boolean testFin(int x, int y) {
        if (j.getPlateau().estPoison(x, y)) {
                System.out.println("Le jeu est terminé");
                System.out.println("Le joueur " + (j.getPlayer()+1) + " a gagné ! (" + j.getCounter() + " coups joués lors de cette partie)");  // +1 coup car le coup perdant n'est pas ajouté avant
            // Reset du plateau pour relancer une nouvelle partie          
            j.setFin();
            return true;
        }
        return false;
    }

    public void ajouteInterfaceUtilisateur(InterfaceUtilisateur v) {
		vue = v;
	}


    
}
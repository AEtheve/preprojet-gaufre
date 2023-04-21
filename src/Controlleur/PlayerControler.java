package Controlleur;

import Modele.Plateau;
import Vue.InterfaceGraphique;
import Vue.EcouteurDeSouris;

public class PlayerControler implements Controler{
    InterfaceGraphique interfaceGraphique;
    Plateau plateau;

    @Override
    public void onClick(int x, int y) {
        int i = (x - (interfaceGraphique.fenetre.getWidth() - plateau.getWidth() * interfaceGraphique.largeurCase) / 2) / interfaceGraphique.largeurCase;
        int j = (y - (interfaceGraphique.fenetre.getHeight() - plateau.getHeight() * interfaceGraphique.hauteurCase) / 2) / interfaceGraphique.hauteurCase;

        if (i < 0 || i >= plateau.getWidth() || j < 0 || j >= plateau.getHeight()) {
            return;
        }
        
        if (plateau.efface(i, j)) {
            interfaceGraphique.miseAJour();
        }
    }

    public PlayerControler(InterfaceGraphique i, Plateau p) {
        interfaceGraphique = i;
        plateau = p;

        EcouteurDeSouris ecouteur = new EcouteurDeSouris(this);
        interfaceGraphique.fenetre.addMouseListener(ecouteur);
    }
}

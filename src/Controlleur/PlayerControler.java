package Controlleur;

import Modele.Plateau;
import Vue.InterfaceGraphique;
import Vue.EcouteurDeSouris;

public class PlayerControler implements Controler{
    InterfaceGraphique interfaceGraphique;
    Plateau plateau;

    @Override
    public void onClick(int x, int y) {
        int i = (x - (interfaceGraphique.fenetre.getWidth() - plateau.getLargeur() * interfaceGraphique.largeurCase) / 2) / interfaceGraphique.largeurCase;
        int j = (y - (interfaceGraphique.fenetre.getHeight() - plateau.getHauteur() * interfaceGraphique.hauteurCase) / 2) / interfaceGraphique.hauteurCase;

        if (i < 0 || i >= plateau.getLargeur() || j < 0 || j >= plateau.getHauteur()) {
            return;
        }

        boolean  res = plateau.efface(i, j);
        interfaceGraphique.miseAjour();
        if (res) {
            interfaceGraphique.clear(i,j);
        }
    }

    public PlayerControler(InterfaceGraphique i, Plateau p) {
        interfaceGraphique = i;
        plateau = p;

        EcouteurDeSouris ecouteur = new EcouteurDeSouris(this);
        interfaceGraphique.fenetre.addMouseListener(ecouteur);
    }
}

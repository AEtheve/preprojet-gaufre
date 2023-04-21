package Controleur;

import Vue.CollecteurEvenements;
import Vue.InterfaceUtilisateur;
import Modele.Jeu;

public class PlayerControler implements CollecteurEvenements {
    Jeu j;
    InterfaceUtilisateur vue;

    public PlayerControler(Jeu j) {
        this.j = j;
    }

    @Override
    public void onClick(int x, int y) {
        if (x < 0 || x >= j.getPlateau().getWidth() || y < 0 || y >= j.getPlateau().getHeight()) {
            return;
        }
        
        j.efface(x, y);
    }

    public void ajouteInterfaceUtilisateur(InterfaceUtilisateur v) {
		vue = v;
	}


    
}
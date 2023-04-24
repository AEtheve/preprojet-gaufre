
import Global.Configuration;

import Modele.Jeu;
import Vue.CollecteurEvenements;
import Vue.InterfaceGraphique;
import Controleur.PlayerControler;

public class Gaufre {

    public static void main(String[] args) {
        Configuration.info("Initialisation de la fenetre");
        Jeu j = new Jeu(4, 4);


        CollecteurEvenements pc = new PlayerControler(j);

        InterfaceGraphique.demarrer(j, pc);
    }


}
package Vue;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import Modele.Jeu;

public class BarreDesMenus extends JMenuBar{

    JMenu menu, menu2, smenu;
    JMenuItem e1, e2, e3, e4, e5, e6,s1,s2;
    Jeu j;

    AbstractAction Quitter = new AbstractAction("Quitter") {
        // Action réalisée lors du clic sur l'item Quitter du menu déroulant
        public void actionPerformed(ActionEvent e) {
            System.out.println("Merci d'avoir joué au jeu de la gaufre empoisonnée");
            System.exit(0);
        }
    };

    AbstractAction NouvellePartie = new AbstractAction("Nouvelle Partie") {
        // Action réalisée lors du clic sur l'item Nouvelle Partie du menu déroulant
        public void actionPerformed(ActionEvent e) {
            System.out.println("Nouvelle Partie");
            // Reset du plateau
            j.resetPlateau();
            j.metAJour();

        }
    };

    AbstractAction Classique = new AbstractAction("Classique") {
        // Action réalisée lors du clic sur l'item Classique du menu déroulant
        public void actionPerformed(ActionEvent e) {
            // Reset du plateau
            j.getPlateau().setStyle("Classique");
            j.metAJour();

        }
    };

    AbstractAction Pixel = new AbstractAction("Pixel") {
        // Action réalisée lors du clic sur l'item Classique du menu déroulant
        public void actionPerformed(ActionEvent e) {
            // Reset du plateau
            j.getPlateau().setStyle("Pixel");
            j.metAJour();

        }
    };


    
    public BarreDesMenus(Jeu j){
        this.j=j;
        menu = new JMenu("Options de jeu");
        smenu = new JMenu("Niveau de l'IA");
        // Créer les éléments du menu déroulant principal
        e1 = new JMenuItem();
        e1.setAction(NouvellePartie);
        e2 = new JMenuItem();
        e2.setAction(Quitter);
        // Créer les éléments du sous menu déroulant (les 3 niveaux de l'IA)
        e3 = new JMenuItem("Faible");
        e4 = new JMenuItem("Moyen");
        e5 = new JMenuItem("Elevé");
        // Ajouter les éléments au menu
        menu.add(e1); 
        menu.add(e2); 
        // Ajouter les éléments dans le sous menu déroulant
        smenu.add(e3); 
        smenu.add(e4);
        smenu.add(e5);
        // Ajouter le sous menu dans le menu déroulant principal
        menu.add(smenu);
        this.add(menu);
        // Menu du style de plateau
        menu2 = new JMenu("Style de plateau");
        s1 = new JMenuItem();
        s1.setAction(Classique);
        s2 = new JMenuItem();
        s2.setAction(Pixel);
        menu2.add(s1);
        menu2.add(s2);
        this.add(menu2);
    }


}

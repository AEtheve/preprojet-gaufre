package Vue;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import Modele.Jeu;

public class BarreDesMenus extends JMenuBar{

    JMenu menu, menu2, smenu, coups;
    JMenuItem e1, e2, e3, e4, e5, e6,s1,s2, annule, refait;
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

    AbstractAction Annule = new AbstractAction("Annuler le dernier coup") {
        // Action réalisée lors du clic sur l'item Classique du menu déroulant
        public void actionPerformed(ActionEvent e) {
            // Reset du plateau
            j.annule();
            j.metAJour();
        }
    };

    AbstractAction Refait = new AbstractAction("Refaire le dernier coup") {
        // Action réalisée lors du clic sur l'item Classique du menu déroulant
        public void actionPerformed(ActionEvent e) {
            // Reset du plateau
            j.refait();
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

        // Ajouter les actions aux éléments du sous menu déroulant:
        e3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j.setNiveauIA(Jeu.IA_FAIBLE);
                System.out.println("Niveau de l'IA: Faible");
            }
        });

        e4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j.setNiveauIA(Jeu.IA_MOYEN);
                System.out.println("Niveau de l'IA: Moyen");
            }
        });

        e5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j.setNiveauIA(Jeu.IA_ELEVE);
                System.out.println("Niveau de l'IA: Elevé");
            }
        });
        
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
        coups = new JMenu("Coups");
        annule = new JMenuItem();
        annule.setAction(Annule);
        refait = new JMenuItem();
        refait.setAction(Refait);
        coups.add(annule);
        coups.add(refait);
        this.add(coups);
        
    }


}

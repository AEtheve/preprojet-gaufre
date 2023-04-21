package Vue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class BarreDesMenus extends JMenuBar{

    //JMenuBar menubar;
    JMenu menu, smenu;
    JMenuItem e1, e2, e3, e4, e5, e6;
    
    public BarreDesMenus(){
        menu = new JMenu("Options de jeu");
        smenu = new JMenu("Niveau de l'IA");
        // Créer les éléments du menu et sous menu
        e1 = new JMenuItem("Nouvelle partie");
        e2 = new JMenuItem("Quitter");
        e3 = new JMenuItem("Faible");
        e4 = new JMenuItem("Moyen");
        e5 = new JMenuItem("Elevé");
        // Ajouter les éléments au menu
        menu.add(e1); 
        menu.add(e2); 
        // Ajouter les éléments au sous menu
        smenu.add(e3); 
        smenu.add(e4);
        smenu.add(e5);
        // Ajouter le sous menu au menu principale
        menu.add(smenu);
        // Ajouter le menu au barre de menu
        this.add(menu);
    }


}

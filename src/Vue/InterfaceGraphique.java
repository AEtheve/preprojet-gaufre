package Vue;

import Modele.Jeu;

import javax.swing.*;
import java.awt.*;


public class InterfaceGraphique implements Runnable, InterfaceUtilisateur {
    Jeu j;
	CollecteurEvenements control;
    JFrame frame;
	boolean maximized;

    public InterfaceGraphique(Jeu j, CollecteurEvenements c) {
        this.j = j;
		control = c;
    }

    public static void demarrer(Jeu j, CollecteurEvenements c) {
		InterfaceGraphique vue = new InterfaceGraphique(j, c);
		c.ajouteInterfaceUtilisateur(vue);
		SwingUtilities.invokeLater(vue);

	}

    public void toggleFullscreen() {
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = env.getDefaultScreenDevice();
		if (maximized) {
			device.setFullScreenWindow(null);
			maximized = false;
		} else {
			device.setFullScreenWindow(frame);
			maximized = true;
		}
	}

    public void run() {
		frame = new JFrame("Gaufre Empoisonnée");
		PlateauGraphique plateauGraphique = new PlateauGraphique(j);
		plateauGraphique.addMouseListener(new AdaptateurSouris(plateauGraphique, control));
		frame.add(plateauGraphique);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}



}

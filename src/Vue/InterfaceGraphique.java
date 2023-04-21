package Vue;

import Modele.Jeu;

import javax.swing.*;
import java.awt.*;


public class InterfaceGraphique implements Runnable, InterfaceUtilisateur {
    Jeu j;
	CollecteurEvenements control;
    JFrame frame;
	boolean maximized;
	JLabel joueur;

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

	private JLabel creerLabel(String text) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}

	private JToggleButton creerToggleButton(String text) {
		JToggleButton bouton = new JToggleButton(text);
		bouton.setAlignmentX(Component.CENTER_ALIGNMENT);
		bouton.setFocusable(false);
		return bouton;
	}

	private JButton creerButton(String text) {
		JButton bouton = new JButton(text);
		bouton.setAlignmentX(Component.CENTER_ALIGNMENT);
		bouton.setFocusable(false);
		return bouton;
	}

	private Box creerBoiteHorizontale() {
		Box boite = Box.createHorizontalBox();
		boite.setAlignmentX(Component.CENTER_ALIGNMENT);
		return boite;
	}

	public void ajouteBarreDesMenus(JFrame frame) {
		BarreDesMenus barreDesMenus = new BarreDesMenus(j);
		frame.setJMenuBar(barreDesMenus);
	}



    public void run() {
		frame = new JFrame("Gaufre Empoisonnée");
		PlateauGraphique plateauGraphique = new PlateauGraphique(j);
		plateauGraphique.addMouseListener(new AdaptateurSouris(plateauGraphique, control));
		ajouteBarreDesMenus(frame);
		frame.add(plateauGraphique);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}



}

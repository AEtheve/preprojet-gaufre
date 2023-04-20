package Vue;

import javax.swing.*;

import Modele.Plateau;

import java.awt.*;
import java.io.InputStream;

import javax.imageio.ImageIO;

import Vue.EcouteurDeSouris;

public class InterfaceGraphique extends JComponent{

    Plateau plateau;
    JFrame fenetre = new JFrame("Gaufre");

    int largeurCase = 64;
    int hauteurCase = 64;

    public InterfaceGraphique(Plateau p){
        plateau = p;
    }
    
    public void demarrer(){


        // TODO: s'adapter à la résolution de l'écran qui execute

        fenetre.setSize(largeurCase * plateau.getLength(), hauteurCase * plateau.getWidth()+30);
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paintComponent(fenetre.getGraphics());

        
        EcouteurDeSouris ecouteur = new EcouteurDeSouris(this);
        fenetre.addMouseListener(ecouteur);
    }

    public void clic(int x, int y){
        
        int i = (x - (fenetre.getWidth() - plateau.getLength() * largeurCase) / 2) / largeurCase;
        int j = (y - (fenetre.getHeight() - plateau.getWidth() * hauteurCase) / 2) / hauteurCase;

        if (i < 0 || i >= plateau.getLength() || j < 0 || j >= plateau.getWidth()) {
            return;
        }

        plateau.efface(i, j);
        miseAjour();
        clear(i,j);

    }

    public void miseAjour(){
        paintComponent(fenetre.getGraphics());
    }

    public void clear(int i, int j){
        Graphics2D drawable = (Graphics2D) fenetre.getGraphics();

        int largeur = fenetre.getWidth();
        int hauteur = fenetre.getHeight();

        Point center = new Point(largeur / 2, hauteur / 2);

        for (int k = i; k < plateau.getLength(); k++) {
            for (int l = j; l < plateau.getWidth(); l++) {
                drawable.clearRect(center.x - (plateau.getLength() * largeurCase) / 2 + k * largeurCase, center.y + 14 - (plateau.getWidth() * hauteurCase) / 2 + l * hauteurCase, largeurCase, hauteurCase);
            }
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;

        int largeur = fenetre.getWidth();
        int hauteur = fenetre.getHeight();
        
        Image imgGaufre = importImage("res/Images/gaufre.png");
        Image imgPoison = importImage("res/Images/poison.png");

        Point center = new Point(largeur / 2, hauteur / 2);

        for (int i = 0; i < plateau.getLength(); i++) {
            for (int j = 0; j < plateau.getWidth(); j++) {
                if (plateau.estGauffre(i, j)) {
                    drawable.drawImage(imgGaufre, center.x - (plateau.getLength() * largeurCase) / 2 + i * largeurCase, center.y + 14 - (plateau.getWidth() * hauteurCase) / 2 + j * hauteurCase, largeurCase, hauteurCase, null);
                }

                if (plateau.estPoison(i, j)) {
                    drawable.drawImage(imgGaufre, center.x - (plateau.getLength() * largeurCase) / 2 + i * largeurCase, center.y + 14 - (plateau.getWidth() * hauteurCase) / 2 + j * hauteurCase, largeurCase, hauteurCase, null);
                    drawable.drawImage(imgPoison, center.x - (plateau.getLength() * largeurCase) / 2 + i * largeurCase, center.y + 14 - (plateau.getWidth() * hauteurCase) / 2 + j * hauteurCase, largeurCase, hauteurCase, null);
                }
            }
        }
    }
    
    Image importImage(String path){
        Image img;

        try {
            InputStream in = new java.io.FileInputStream(path);
            img = ImageIO.read(in);
        } catch (Exception e) {
            img = null;
            System.out.println("Image non trouvée");
        }

        return img;
    }

}

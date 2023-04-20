package Vue;

import javax.swing.*;

import Modele.Plateau;

import java.awt.*;
import java.io.InputStream;

import javax.imageio.ImageIO;

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

        paintComponent(fenetre.getGraphics());

    }

    public void miseAjour(){
        clear();
        paintComponent(fenetre.getGraphics());
    }

    public void clear(){
        fenetre.getGraphics().clearRect(0, 0, fenetre.getWidth(), fenetre.getHeight());
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

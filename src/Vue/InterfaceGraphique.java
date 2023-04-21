package Vue;

import javax.swing.*;

import Modele.Plateau;

import java.awt.*;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class InterfaceGraphique extends JComponent{

    Plateau plateau;
    public JFrame fenetre = new JFrame("Gaufre");

    public int largeurCase = 64;
    public int hauteurCase = 64;

    public InterfaceGraphique(Plateau p){
        plateau = p;
    }
    
    public void demarrer(){


        // TODO: s'adapter à la résolution de l'écran qui execute
        fenetre.setSize(largeurCase * plateau.getWidth(), hauteurCase * plateau.getHeight()+32);
        fenetre.add(new InterfaceGraphique(plateau));
        
        fenetre.setVisible(true);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    }

    public void miseAJour(){
        fenetre.repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        
        Image imgGaufre = importImage("res/Images/gaufre.png");
        Image imgPoison = importImage("res/Images/poison.png");


        imgGaufre = imgGaufre.getScaledInstance(largeurCase, hauteurCase, Image.SCALE_DEFAULT);
        imgPoison = imgPoison.getScaledInstance(largeurCase, hauteurCase, Image.SCALE_DEFAULT);

        for (int i = 0; i < plateau.getWidth(); i++) {
            for (int j = 0; j < plateau.getHeight(); j++) {
                if (plateau.estGaufre(i, j)) {
                    drawable.drawImage(imgGaufre, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                }

                if (plateau.estPoison(i, j)) {
                    drawable.drawImage(imgGaufre, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
                    drawable.drawImage(imgPoison, i * largeurCase, j * hauteurCase, largeurCase, hauteurCase, null);
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

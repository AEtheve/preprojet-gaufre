package Vue;

import Global.Configuration;
import Patterns.Observateur;
import Modele.*;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class PlateauGraphique extends JComponent implements Observateur {
    Image gaufre, poison, gaufre_droit, gaufre_bas, gaufre_coin, poison_bas, poison_droit;
    Jeu j;
    int largeurCase;
    int hauteurCase;
    int xFen;
    int yFen;
    int barreHauteur;
    int barreLargeur;

    public PlateauGraphique(Jeu j) {
        this.j = j;
        j.ajouteObservateur(this);
        gaufre = lisImage("gaufre");
        poison = lisImage("gaufre_empoisonnee");
        gaufre_droit = lisImage("gaufre_droit");
        gaufre_bas = lisImage("gaufre_bas");
        gaufre_coin = lisImage("gaufre_coin");
        poison_bas = lisImage("gaufre_empoisonnee_bas");
        poison_droit = lisImage("gaufre_empoisonnee_droit");
    }

    private Image lisImage(String nom) {
        InputStream in = Configuration.ouvre("Images/" + nom + ".png");
        Configuration.info("Chargement de l'image " + nom);
        try {
            return ImageIO.read(in);
        } catch (Exception e) {
            Configuration.erreur("Impossible de charger l'image " + nom);
        }
        return null;
    }

    private void tracer(Graphics2D g, Image i, int x, int y, int l, int h) {
        g.drawImage(i, x, y, l, h, null);
    }

    public void miseAJour() {
        repaint();
    }

    public void paintComponent(Graphics g) {
        Graphics2D drawable = (Graphics2D) g;
        Plateau p = j.getPlateau();

        barreHauteur = 30;
        barreLargeur = getSize().width;

        int largeur = getSize().width;
        int hauteur = getSize().height - barreHauteur;
        largeurCase = largeur / p.getWidth();
        hauteurCase = hauteur / p.getHeight();
        largeurCase = Math.min(largeurCase, hauteurCase);
        hauteurCase = largeurCase;

        xFen = (largeur - largeurCase * p.getWidth()) / 2;
        yFen = (hauteur - hauteurCase * p.getHeight()) / 2 + barreHauteur;

        dessinerBarre(drawable, p);
        dessinerCases(drawable, p);

    }

    private void dessinerBarre(Graphics2D drawable, Plateau p) {
        int barreY = 0;
        int barreX = 0;

        drawable.setColor(Color.GRAY);
        drawable.fillRect(barreX, barreY, barreLargeur, barreHauteur);

        String title = "Tour du joueur " + (j.getPlateau().getPlayer() + 1);
        Font font = new Font("Arial", Font.BOLD, 16);
        drawable.setFont(font);
        drawable.setColor(Color.WHITE);
        FontMetrics metrics = drawable.getFontMetrics(font);
        int titleWidth = metrics.stringWidth(title);
        int titleX = (barreLargeur - titleWidth) / 2;
        int titleY = barreHauteur / 2 + metrics.getAscent() / 2;
        drawable.drawString(title, titleX, titleY);
    }

    private void dessinerCases(Graphics2D drawable, Plateau p) {
        for (int i = 0; i < p.getWidth(); i++) {
            for (int j = 0; j < p.getHeight(); j++) {
                int x = xFen + i * largeurCase;
                int y = yFen + j * hauteurCase;

                if (p.estGaufre(i, j)) {
                    if (i + 1 < p.getWidth() && p.estMange(i + 1, j) && j + 1 < p.getHeight() && p.estMange(i, j + 1)) {
                        tracer(drawable, gaufre_coin, x, y, largeurCase, hauteurCase);
                    } else if (i + 1 < p.getWidth() && p.estMange(i + 1, j)) {
                        tracer(drawable, gaufre_droit, x, y, largeurCase, hauteurCase);
                    } else if (j + 1 < p.getHeight() && p.estMange(i, j + 1)) {
                        tracer(drawable, gaufre_bas, x, y, largeurCase, hauteurCase);
                    } else {
                        tracer(drawable, gaufre, x, y, largeurCase, hauteurCase);
                    }
                }
                if (p.estPoison(i, j)) {
                    tracer(drawable, poison, x, y, largeurCase, hauteurCase);
                    tracer(drawable, poison_bas, x, y + hauteurCase, largeurCase, hauteurCase);
                    tracer(drawable, poison_droit, x + largeurCase, y, largeurCase, hauteurCase);
                }
            }
        }
    }

    public int getLargeurCase() {
        return largeurCase;
    }

    public int getHauteurCase() {
        return hauteurCase;
    }

    public int getxFen() {
        return xFen;
    }

    public int getyFen() {
        return yFen;
    }

}

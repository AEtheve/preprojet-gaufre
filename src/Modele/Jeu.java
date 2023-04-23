package Modele;

import Patterns.Observable;

public class Jeu extends Observable {
    Plateau plateau;
    int niveauIA;

    public static final int IA_FAIBLE = 1;
    public static final int IA_MOYEN = 2;
    public static final int IA_ELEVE = 3;

    public Jeu(int width, int height) {
        plateau = new Plateau(width, height,"pixel");
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void resetPlateau(){
        plateau = new Plateau(plateau.getWidth(), plateau.getHeight(),plateau.getStyle());
    }

    public void efface(int x, int y) {
        plateau.addHisto();
        plateau.efface(x, y);
        metAJour();
    }

    public int getPlayer(){
        return plateau.getPlayer();
    }

    public int getCounter(){
        return plateau.getCounter();
    }

    public void changePlayer(){
        plateau.setPlayer(getPlayer() == 0 ? 1 : 0);
    }

    public void upCounter(){
        plateau.setCounter(getCounter() + 1);
    }

    public void setFin(){
        resetPlateau();
        metAJour();
    }

    public void setNiveauIA(int niveauIA) {
        this.niveauIA = niveauIA;
    }

    public int getNiveauIA() {
        return niveauIA;
    }

    public void annule(){
        if (plateau.peutAnnuler()){
            plateau.annule();
        }
    }

    public void refait(){
        if (plateau.peutRefaire()){
            plateau.refait();
        }
    }
    
}

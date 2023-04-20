package Vue;

import javax.swing.*;
import java.awt.*;

public class Plateau {

    static final int MANGE = 0;
    static final int GAUFFRE = 1;
    static final int POISON = 2;

    int [][] matrice;

    public Plateau(int n, int m) {
        matrice = new int[n][m];
    }

    public int getLength(){
        return matrice.length;
    }

    public int getWidth(){
        return matrice[0].length;
    }

    public int getCase(int i, int j){
        return matrice[i][j];
    }

    boolean estMange(int i, int j){
        return matrice[i][j] == MANGE;
    }

    boolean estGauffre(int i, int j){
        return matrice[i][j] == GAUFFRE;
    }

    boolean estPoison(int i, int j){
        return matrice[i][j] == POISON;
    }


    public void setMange(int i, int j){
        matrice[i][j] = MANGE;
    }

    public void setGauffre(int i, int j){
        matrice[i][j] = GAUFFRE;
    }

    public void setPoison(int i, int j){
        matrice[i][j] = POISON;
    }


}

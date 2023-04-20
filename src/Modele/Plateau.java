package Modele;

public class Plateau {

    static final int MANGE = 0;
    static final int GAUFFRE = 1;
    static final int POISON = 2;

    int [][] matrice;

    public Plateau(int n, int m) {
        matrice = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                setGauffre(i, j);
            }
        }
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

    public boolean estMange(int i, int j){
        return matrice[i][j] == MANGE;
    }

    public boolean estGauffre(int i, int j){
        return matrice[i][j] == GAUFFRE;
    }

    public boolean estPoison(int i, int j){
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
    
    public void efface(int x, int y){
        for (int i = x; i < matrice.length; i++) {
            for (int j = y; j < matrice[0].length; j++) {
                setMange(i, j);
            }
        }
    }


}

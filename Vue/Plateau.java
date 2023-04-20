package Vue;

public class Plateau {

    static final int MANGE = 0;
    static final int GAUFFRE = 1;
    static final int EMPOISONNE = 2;

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

    boolean estEmpoisonne(int i, int j){
        return matrice[i][j] == EMPOISONNE;
    }
    

}

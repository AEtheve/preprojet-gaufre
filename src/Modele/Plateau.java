package Modele;

public class Plateau {

    static final int MANGE = 0;
    static final int Gaufre = 1;
    static final int POISON = 2;

    int [][] matrice;

    public Plateau(int n, int m) {
        matrice = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                setGaufre(i, j);
            }
        }
    }

    public int getWidth(){
        return matrice.length;
    }

    public int getHeight(){
        return matrice[0].length;
    }

    public int getCase(int i, int j){
        return matrice[i][j];
    }

    public boolean estMange(int i, int j){
        return matrice[i][j] == MANGE;
    }

    public boolean estGaufre(int i, int j){
        return matrice[i][j] == Gaufre;
    }

    public boolean estPoison(int i, int j){
        return matrice[i][j] == POISON;
    }


    public void setMange(int i, int j){
        matrice[i][j] = MANGE;
    }

    public void setGaufre(int i, int j){
        matrice[i][j] = Gaufre;
    }

    public void setPoison(int i, int j){
        matrice[i][j] = POISON;
    }
    
    public boolean efface(int x, int y){
        if (x==0 && y==0){
            System.out.println("Perdu");
            return false;
        }
        for (int i = x; i < matrice.length; i++) {
            for (int j = y; j < matrice[0].length; j++) {
                setMange(i, j);
            }
        }
        return true;
    }


}

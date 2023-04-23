package Modele;

import java.util.ArrayList;

public class Plateau {

    static final int MANGE = 0;
    static final int Gaufre = 1;
    static final int POISON = 2;

    int [][] matrice;

    int player = 0;
    int counter;
    String style;
    boolean styleChanged;

    ArrayList<int [][]> histo; // Historique des coups
    int pos; // Position dans l'historique des coups

    public Plateau(int n, int m,String style) {
        matrice = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                setGaufre(i, j);
            }
        }
        setPoison(0, 0);
        this.style=style;
        histo = new ArrayList<int [][]>();
        // histo.add(mcopy(matrice)); // Ajout de la config complète de base du plateau - plateau vierge
        counter = 0;
    }

    private int[][] mcopy(int [][] mat_src){
        // Renvoie une copie de matrice - Utilisable pour ajouter une config de plateau à l'historique de jeu
        int [][] mat_dest = new int [mat_src.length] [mat_src.length];
        for (int i=0; i<mat_src.length;i++){
            for (int j=0;j<mat_src.length;j++){
                mat_dest[i][j]=mat_src[i][j];
            }
        }
        return mat_dest;
    }

    public int getWidth(){
        return matrice.length;
    }

    public void setStyle(String style){
        this.style=style;
        this.styleChanged=true;
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
    
    public void efface(int x, int y){
        for (int i = x; i < matrice.length; i++) {
            for (int j = y; j < matrice[0].length; j++) {
                setMange(i, j);
            }
        }
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean styleChanged(){
        return styleChanged;
    }

    public void resetStyleChanged(){
        styleChanged=false;
    }

    public String getStyle(){
        return style;
    }

    public void addHisto(){
        try{
            // Remplace la case si déjà créée dans l'histo
            histo.add(pos,mcopy(matrice));
            pos++;
            return;
        } catch (Exception e){}
        histo.add(mcopy(matrice));
        pos++;
    }

    private void afficheMat(int [][] mat){
        System.out.println("Affiche MAT");
        for (int i=0;i<mat.length;i++){
            for (int j=0; j<mat[0].length;j++){
                System.out.print(mat[i][j]);
            }
            System.out.print("\n");
        }
    }

    public boolean peutAnnuler(){
        System.out.println("POS : "+pos);
        for (int i=0; i<histo.size();i++){
            afficheMat(histo.get(i));
        }
        return pos > 0 ? true : false;
    }

    public void annule(){
        matrice = mcopy(histo.get(pos-1));
        pos--;
        counter--;
        setPlayer(getPlayer()==0 ? 1 : 0);
    }
}
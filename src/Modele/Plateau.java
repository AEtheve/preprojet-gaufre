package Modele;

public class Plateau {

    static final int MANGE = 0;
    static final int Gaufre = 1;
    static final int POISON = 2;

    int [][] matrice;

    int player = 0;
    int counter;
    String style;
    boolean styleChanged;

    public Plateau(int n, int m,String style) {
        matrice = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                setGaufre(i, j);
            }
        }
        setPoison(0, 0);
        this.style=style;
        counter = 0;
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
}
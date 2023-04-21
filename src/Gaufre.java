import Vue.InterfaceGraphique;
import Modele.Plateau;

public class Gaufre{
    public static void main(String[] args) {
        Plateau p = new Plateau(8, 8);
        InterfaceGraphique i = new InterfaceGraphique(p);

        int rx = (int) (Math.random() * p.getWidth());
        int ry = (int) (Math.random() * p.getHeight());
        p.setPoison(rx,ry);

        i.demarrer();
    
    }
}
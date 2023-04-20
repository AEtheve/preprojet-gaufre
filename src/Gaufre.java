import Vue.InterfaceGraphique;
import Modele.Plateau;
import Vue.InterfaceGraphique;

public class Gaufre{
    public static void main(String[] args) {
        Plateau p = new Plateau(8, 8);
        InterfaceGraphique i = new InterfaceGraphique(p);

        p.setPoison(0, 0);

        i.demarrer();

        p.setMange(1,2);

        i.miseAjour();
    
    }
}
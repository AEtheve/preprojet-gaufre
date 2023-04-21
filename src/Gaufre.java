import Vue.InterfaceGraphique;
import Modele.Plateau;
import Controlleur.PlayerControler;

public class Gaufre{
    public static void main(String[] args) {
        Plateau p = new Plateau(8, 8);
        InterfaceGraphique i = new InterfaceGraphique(p);
        i.demarrer();
        PlayerControler pc = new PlayerControler(i, p);

        p.setPoison(0, 0);

        
    
    }
}
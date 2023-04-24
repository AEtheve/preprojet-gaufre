package Structures;

import java.util.ArrayList;

public class ArbreEtOu {
    public boolean gagnant;
    public ArrayList<Couple<Coords, ArbreEtOu>> suivants;

    public ArbreEtOu(boolean b) {
        suivants = new ArrayList<Couple<Coords, ArbreEtOu>>();
        this.gagnant = b;
    }

    public void AjouterSuivant(Coords c, ArbreEtOu a) {
        suivants.add(new Couple<Coords, ArbreEtOu>(c, a));
    }

    public void CalculJoueurA(int[] config) {
        if(config[0]==1 && config[1]==0) {
            gagnant=false;
            return;
        }
        // Remplissage des suivants
        for (int i=0; i<config.length; i++) {
            for (int j=0; j<config[i]; j++) {
                // Creation fils
                ArbreEtOu fils = new ArbreEtOu(true);
                //Calcul nouvelle config
                int[] new_config = config.clone();
                for(int k=i; k<config.length; k++) {
                    new_config[k] = Math.min(j, new_config[k]);
                }
                // Calcul fils
                fils.CalculJoueurB(new_config);
                // Ajout fils
                AjouterSuivant(new Coords(i, j), fils);
            }
        }


        // Calcul de gagnant
        for (Couple<Coords, ArbreEtOu> c : suivants) {
            gagnant = gagnant || c.second.gagnant;
        }
    }

    public void CalculJoueurB(int[] config) {
        if(config[0]==1 && config[1]==0) {
            gagnant=true;
            return;
        }
        // Remplissage des suivants
        for (int i=0; i<config.length; i++) {
            for (int j=0; j<config[i]; j++) {
                // Creation fils
                ArbreEtOu fils = new ArbreEtOu(false);
                //Calcul nouvelle config
                int[] new_config = config.clone();
                for(int k=i; k<config.length; k++) {
                    new_config[k] = Math.min(j, new_config[k]);
                }
                // Calcul fils
                fils.CalculJoueurA(new_config);
                // Ajout fils
                AjouterSuivant(new Coords(i, j), fils);
            }
        }


        // Calcul de gagnant
        for (Couple<Coords, ArbreEtOu> c : suivants) {
            gagnant = gagnant && c.second.gagnant;
        }
    }

    public ArbreEtOu GetSuivant(Coords coords) {
        for (Couple<Coords, ArbreEtOu> c : suivants) {
            if (c.first.equals(coords)) {
                return c.second;
            }
        }
        return null;
    } 
}
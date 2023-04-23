package Vue;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdaptateurClavier extends KeyAdapter {
	CollecteurEvenements cont;
	PlateauGraphique plateauGraphique;

	public AdaptateurClavier(PlateauGraphique p, CollecteurEvenements c) {
		cont = c;
		plateauGraphique = p;
	}

	@Override
	public void keyPressed(KeyEvent e) { 
		cont.onKeyPress(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) { }
	@Override
	public void keyTyped(KeyEvent e) { }
}

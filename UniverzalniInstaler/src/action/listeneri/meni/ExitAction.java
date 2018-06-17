package action.listeneri.meni;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

public class ExitAction extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7284940431165820989L;

	public ExitAction() {
		
		putValue(NAME, "Izlaz");
		putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		putValue(SHORT_DESCRIPTION, "Izlazak iz aplikacija");
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			System.exit(0);
	}

}

package action.listeneri;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import admin.gui.glavniProzor.PocetniProzor;
import admin.gui.paneliZaIzmenu.PanelZaUnosProizvoda;

public class PanZaUnosProizvodaAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2932873145259476907L;

	public PanZaUnosProizvodaAction() {
		
		putValue(NAME,PocetniProzor.getInstance().getResourceBundle().getString("dodatno.kreiranje"));
		putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		putValue(SHORT_DESCRIPTION,PocetniProzor.getInstance().getResourceBundle().getString("dodatno.kwizard"));

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PanelZaUnosProizvoda p=new PanelZaUnosProizvoda(false);
		p.setVisible(true);
		
		
	}
}


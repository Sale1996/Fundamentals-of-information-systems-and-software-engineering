package action.listeneri.meni;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import admin.gui.glavniProzor.AboutClass;

public class AboutAction extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5208566707553791695L;

	public AboutAction() {
		
		putValue(NAME, "About..");
		//VIDI BANE OVDE PROSLEDJUJES SAMO JEDNO SLOVO U ZAVISNOSTI KOJI JE JEZIK 
		//AKO JE ENGLESKI PROSLEDI MU A , AKO JE SPRSKI PROSLEDI MU N , AKO JE JAPANSKI ZNAS VEC...
	// putValue(MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(PocetniProzor.getInstance().getResourceBundle().getString("M"));
		putValue(SHORT_DESCRIPTION, "Informacije o Universtalatoru");
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AboutClass ac=new AboutClass();
		ac.setVisible(true);
	}
}

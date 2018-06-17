package action.listeneri;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import admin.gui.glavniProzor.PocetniProzor;
import admin.gui.parametar.UnosParametra;

public class UnosParametraAction extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2954984809084770640L;

	public UnosParametraAction() {
		
		putValue(NAME,PocetniProzor.getInstance().getResourceBundle().getString("dodatno.parametar"));
		putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		putValue(SHORT_DESCRIPTION, PocetniProzor.getInstance().getResourceBundle().getString("dodatno.nparametar"));

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		UnosParametra up=new UnosParametra(false);
		up.setVisible(true);
	}
}

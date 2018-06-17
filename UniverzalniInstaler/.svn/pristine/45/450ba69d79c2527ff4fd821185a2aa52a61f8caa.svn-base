package action.listeneri.meni;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.zip.InflaterInputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import admin.gui.glavniProzor.PocetniProzor;
import model.Workspace;

public class OpenAction extends AbstractAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1481396884944096476L;

	public OpenAction() {
		putValue(NAME, "Open...");
		putValue(MNEMONIC_KEY, KeyEvent.VK_O);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl O"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
		choose.showSaveDialog(null);
		File open = choose.getSelectedFile().getAbsoluteFile();
		Workspace lista_pro = PocetniProzor.getInstance().getWorkspace1();
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new InflaterInputStream(new FileInputStream(open))));
			try {
				lista_pro = (Workspace) in.readObject();
				
				PocetniProzor.getInstance().setWorkspace1(lista_pro);
				PocetniProzor.getInstance().popuni_stablo();
			} finally {
				in.close();
			}
			PocetniProzor.getInstance().setWorkspace1(lista_pro);
			JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("dodatno.uspesno"), "Universtalator",JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("openaction.klasa"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
		}catch (FileNotFoundException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("openaction.fajl"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
		} catch (IOException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("openaction.greska"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
			
		}
		
	}

	
	
}

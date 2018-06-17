package action.listeneri.meni;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import admin.gui.glavniProzor.PocetniProzor;
import model.Parametar;
import model.Proizvod;
import model.Wizard;
import model.Workspace;


public class SaveAction extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8092571414794010790L;
	private static int inc = 0;
	private int brojIzvrsnogParametra=0;
	public SaveAction() {
		
		putValue(NAME, "Save...");
		putValue(MNEMONIC_KEY, KeyEvent.VK_K);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl S"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(PocetniProzor.getInstance().getWorkspace1().getLokacija()==null) {
			JFileChooser choose = new JFileChooser();
			choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
			choose.showSaveDialog(null);
			File save = new File(choose.getSelectedFile().getAbsolutePath());
			PocetniProzor.getInstance().getWorkspace1().setLokacija(save);
		}
		
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
				.getInstance().getTree().getLastSelectedPathComponent();
		
		
		Object o = null;
		if (sel != null) {
			o = sel.getUserObject();
		}
					
		if (sel != null){
			if (o instanceof Proizvod) {
		        Proizvod proizvod1=(Proizvod) o;
		        brojIzvrsnogParametra=0;
		        
		        List<Wizard> listaWizarda=proizvod1.getListaWizarda();
		        for(int i=0; i<listaWizarda.size();i++){
		        	List<Parametar> parametri =listaWizarda.get(i).getParametri();
		        	for(int j=0; j<parametri.size();j++){
						Parametar parametar1=parametri.get(j);
						if((parametar1.getData_type()=="Izvorni")){
							brojIzvrsnogParametra++;
						}
		        	}
		        }
		        
		        if(brojIzvrsnogParametra!= 1){
					JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("dodatno.savenijesave"), "Universtalator",JOptionPane.ERROR_MESSAGE);

		        }else{
		        	brojIzvrsnogParametra=0;
			        File lokacija = new File(PocetniProzor.getInstance().getWorkspace1().getLokacija(),proizvod1.getIme()+".proizvod");
					try {
						ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new DeflaterOutputStream(new FileOutputStream(lokacija))));
						try {
							out.writeObject(proizvod1);
						} finally {
							out.close();
						}
						JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("saveaction.snimljen"), "Universtalator",JOptionPane.INFORMATION_MESSAGE);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("saveaction.putanja") , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
					} catch (IOException e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("saveaction.greska"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
						
					} 
				}
			}else if(sel.getPath().length == 1){
				Workspace lista_pro = PocetniProzor.getInstance().getWorkspace1();
				File lokacija = new File(PocetniProzor.getInstance().getWorkspace1().getLokacija(),"ws.wksp");
				try {
					ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new DeflaterOutputStream(new FileOutputStream(lokacija))));
					try {
						out.writeObject(lista_pro);
					} finally {
						out.close();
					}
					JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("saveaction.uspesno"), "Universtalator",JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("openaction.fajl"),PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("saveaction.greska_workspace"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
					
				}
			}else {
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("saveaction.select"), PocetniProzor.IME_APLIKACIJE,
				JOptionPane.WARNING_MESSAGE);
			}
	   }else {
		     JOptionPane.showMessageDialog(PocetniProzor.getInstance(), PocetniProzor.getInstance().getResourceBundle().getString("saveaction.select"), PocetniProzor.IME_APLIKACIJE,
			 JOptionPane.WARNING_MESSAGE);
	   }

	
	}

}

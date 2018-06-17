package action.listeneri.tree;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import admin.gui.glavniProzor.PocetniProzor;
import model.Parametar;
import model.Proizvod;
import model.Wizard;
import model.Workspace;

public class ObrisiCvorAction extends AbstractAction {

	

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 7463982165945853762L;


	public ObrisiCvorAction() {
	}

	public ObrisiCvorAction(String name) {
		super(name);
	}


	public ObrisiCvorAction(String name, Icon icon) {
		super(name, icon);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
				.getInstance().getTree().getLastSelectedPathComponent();
		
		Object o = null;
		if (sel != null) {
			o = sel.getUserObject();
		}
		
		if (sel != null && !sel.isRoot()) {
			/*
			 * Ako selektovani cvor nije koren i nije null mi uzimamo roditelja od tog cvora i gledamo 
			 * ako je wizard uzimamo proizvod (njegov parent cvor) i iz njegove liste wizarda brisemo nas te nakon toga 
			 * radimo metodu removeNodeFromParent koja ce ukloniti taj cvor iz stabla
			 * */

			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
			Object parent = parentNode.getUserObject();
			
			
			JLabel a=new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("wizard.nothinghappen"));
			
			if(o instanceof Proizvod){
				Proizvod proizvod1=(Proizvod) o;
		        Workspace workspace1 =(Workspace) PocetniProzor.getInstance().getWorkspace1();
		        workspace1.removeProizvod(proizvod1);
		        a = new JLabel("Product:  '"+proizvod1.getIme()+"'  removed");
			}else if(o instanceof Wizard){
				Wizard wizard1=(Wizard) o;
				Proizvod roditelj = (Proizvod) parent;
				roditelj.removeWizard(wizard1);
				a = new JLabel("Wizard:  '"+wizard1.getIme()+"'  removed");
			}else if(o instanceof Parametar){
				Parametar parametar1=(Parametar) o;
				Wizard roditelj =(Wizard) parent;
				roditelj.removeParametar(parametar1);
				a = new JLabel("Parameter:  '"+parametar1.getParameter_name()+"'  removed");
			}
			a.setForeground(Color.WHITE);
	        PocetniProzor.getInstance().getPanStatusLinija().removeAll();
	        PocetniProzor.getInstance().getPanStatusLinija().add(a);
			PocetniProzor.getInstance().getTreeModel().removeNodeFromParent(sel);
		}else {
			//ali ako nije instance kategorija ti mu izbaci ovaj warning
			JOptionPane.showMessageDialog(PocetniProzor.getInstance(), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.select"), PocetniProzor.IME_APLIKACIJE,
					JOptionPane.WARNING_MESSAGE);
		}

	}

}
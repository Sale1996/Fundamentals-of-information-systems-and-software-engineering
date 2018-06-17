package action.listeneri.tree;

import java.awt.Color;
import java.awt.event.ActionEvent;




import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import admin.gui.glavniProzor.PocetniProzor;
import model.Proizvod;
import model.Wizard;

public class AddCvorWizardAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7455410325285552471L;
	/**
	 * 
	 */
	private static int incrementer;
	
	public AddCvorWizardAction() {}

	public AddCvorWizardAction(String name) {
		super(name);
	}
	public AddCvorWizardAction(String name, Icon icon) {
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
		//proverava da li je selektovani cvor : koren,wizard ili parametar
		//kako bi zabranio unos unos wizarda kao deteta tog cvora
		
		if (sel != null){
			
		
			if (o instanceof Proizvod) {
				
		        Wizard wizard1 = new Wizard(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.carobni") + incrementer++);
		        
		        Proizvod proizvod1=(Proizvod) o;
		        proizvod1.addWizard(wizard1);
		        
		        /////OVDE MENJAM STATUS LINIJU
		        JLabel a = new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.created"));
		        a.setForeground(Color.WHITE);
		        PocetniProzor.getInstance().getPanStatusLinija().removeAll();
		        PocetniProzor.getInstance().getPanStatusLinija().add(a);
		        
		        
				DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(wizard1);
				
				
				PocetniProzor.getInstance().getTreeModel()
						.insertNodeInto(nNode, sel, sel.getChildCount());

		//naredbe koje nam odma selektuju nas novonastali cvor
		
				PocetniProzor.getInstance().getTree()
						.setSelectionPath(new TreePath(nNode.getPath()));
				PocetniProzor.getInstance().getTree()
						.scrollPathToVisible(new TreePath(nNode.getPath()));
				
			}else {
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("wizard.cvor"), PocetniProzor.IME_APLIKACIJE,
				JOptionPane.WARNING_MESSAGE);
			}
	   }else {
		     JOptionPane.showMessageDialog(PocetniProzor.getInstance(), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.select"), PocetniProzor.IME_APLIKACIJE,
			 JOptionPane.WARNING_MESSAGE);
	   }

	}
	
	
}
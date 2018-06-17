package admin.gui.glavniProzor;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.Parametar;
import model.Proizvod;
import model.Wizard;

public class TreeProizvodiRender extends DefaultTreeCellRenderer {
	
	//inicijalizacija izgleda ikonica cvorova u stablu 

	/**
	 * 
	 */
	private static final long serialVersionUID = 4054181840633852864L;
	private ImageIcon wizardIcon = new ImageIcon("slike/icons8-wizard-16 (1).png");
	private ImageIcon imgIcon = new ImageIcon("slike/icons8-picture-16.png");
	private ImageIcon oneLineTextIcon = new ImageIcon("slike/icons8-typography-filled-16.png");
	private ImageIcon multiLineTextIcon = new ImageIcon("slike/icons8-add-text-filled-16.png");
	private ImageIcon booleanIcon =  new ImageIcon("slike/icons8-puzzled-filled-16.png");
	private ImageIcon fileChooserIcon = new ImageIcon("slike/icons8-elections-filled-16.png");
	private ImageIcon proizvodIcon = new ImageIcon("slike/icons8-software-installer-16.png");
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		// Èvor koga treba iscrtati.
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		Object o = node.getUserObject();

		// Podešavanje tekst èvora koji se iscrtava na osnovu naziva èlanka ili
		// kategorije iz modela.
		if (o instanceof Wizard) {
			Wizard carobnjak = (Wizard) o;
			setText(carobnjak.getIme());
			setIcon(wizardIcon);
		} else if (o instanceof Parametar) {
			Parametar parametar1 = (Parametar) o;
			setText(parametar1.getParameter_name());
			if(parametar1.getData_type()=="Image")
				setIcon(imgIcon);
			else if(parametar1.getData_type()=="One Line Text")
				setIcon(oneLineTextIcon);
			else if(parametar1.getData_type()=="Multiple Line Text")
				setIcon(multiLineTextIcon);
			else if(parametar1.getData_type()=="Boolean")
				setIcon(booleanIcon);
			else
				setIcon(fileChooserIcon);
		} else if(o instanceof Proizvod){
			Proizvod proizvod1 =(Proizvod) o;
			setText(proizvod1.getIme());
			setIcon(proizvodIcon);
		}

		return this;
	}
}

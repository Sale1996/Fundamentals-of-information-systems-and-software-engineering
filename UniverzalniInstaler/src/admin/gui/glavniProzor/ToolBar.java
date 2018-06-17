package admin.gui.glavniProzor;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import action.listeneri.PanZaIzmenuProizvodaAction;
import action.listeneri.PanZaUnosProizvodaAction;
import action.listeneri.UnosParametraAction;
import action.listeneri.meni.OpenAction;
import action.listeneri.meni.SaveAction;
import action.listeneri.tree.AddCvorWizardAction;
import action.listeneri.tree.ObrisiCvorAction;

public class ToolBar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNewWizard;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnNewParameter;
	private JButton btnNewProizvod;
	private JButton btnEdit;
	private JButton open;
	
	public ToolBar(){

		
		super(SwingConstants.HORIZONTAL);
		
		
		
		btnNewProizvod = new JButton();
		btnNewProizvod.setToolTipText(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.newprod"));
		btnNewProizvod.setIcon(new ImageIcon("slike/icons8-software-installer-16.png"));
		btnNewProizvod.setBackground(Color.gray);
		btnNewProizvod.addActionListener(new PanZaUnosProizvodaAction());
		add(btnNewProizvod);
		
		addSeparator();

		btnNewWizard = new JButton(new AddCvorWizardAction());
		btnNewWizard.setToolTipText( PocetniProzor.getInstance().getResourceBundle().getString("dodatno.newwiz"));
		btnNewWizard.setIcon(new ImageIcon("slike/icons8-wizard-22.png"));
		btnNewWizard.setBackground(Color.gray);
		add(btnNewWizard);


		addSeparator();
		
		btnNewParameter = new JButton();
		btnNewParameter.setToolTipText( PocetniProzor.getInstance().getResourceBundle().getString("dodatno.newparam"));
		btnNewParameter.setIcon(new ImageIcon("slike/icons8-new-file-22.png"));
		btnNewParameter.setBackground(Color.gray);
		btnNewParameter.addActionListener(new UnosParametraAction());

		add(btnNewParameter);
		
		addSeparator();
		
		
		
		open = new JButton();
		open.setIcon(new ImageIcon("slike/icons8-opennnn.png"));
		open.setBackground(Color.gray);
		open.addActionListener(new OpenAction());

		add(open);
		
		addSeparator();
		
		


		btnEdit =  new JButton();
		btnEdit.setToolTipText(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.edit"));
		btnEdit.setIcon(new ImageIcon("slike/icons8-edit-22.png"));
		btnEdit.setBackground(Color.gray);
		btnEdit.addActionListener(new PanZaIzmenuProizvodaAction());

		add(btnEdit);
		
		addSeparator();


		btnDelete =  new JButton(
				new ObrisiCvorAction());
		btnDelete.setToolTipText(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.delete"));
		btnDelete.setIcon(new ImageIcon("slike/icons8-trash-22.png"));
		btnDelete.setBackground(Color.gray);
		add(btnDelete);

	
		addSeparator();
		
		btnSave = new JButton();
		btnSave.setToolTipText(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.save"));
		btnSave.setIcon(new ImageIcon("slike/icons8-save-22 (2).png"));
		btnSave.setBackground(Color.GRAY);
		btnSave.addActionListener(new SaveAction());
		add(btnSave);
		
		


		setFloatable(true);
		setBackground(new Color(255,255,204));
	
   }


}
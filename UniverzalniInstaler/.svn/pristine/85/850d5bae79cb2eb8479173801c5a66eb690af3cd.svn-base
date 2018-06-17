package admin.gui.glavniProzor;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import action.listeneri.PanZaUnosProizvodaAction;
import action.listeneri.UnosParametraAction;
import action.listeneri.meni.AboutAction;
import action.listeneri.meni.ExitAction;
import action.listeneri.meni.OpenAction;
import action.listeneri.meni.SaveAction;
import action.listeneri.tree.AddCvorWizardAction;

public class GlavniMeni extends JMenuBar implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -612111468754156763L;
	private JMenu file;
	private JMenu miNew;
	private JMenuItem mWizard;
	private JMenuItem mParametar;
	private JMenuItem miOpen;
	private JMenuItem miSave;
	private JMenuItem miDelete;
	private JMenuItem miEdit;
	private JMenuItem miExit;
	
	private JMenu help;
	private JMenuItem hAbout;
	
	private JMenu language;
	private JMenuItem srpski;
	private JMenuItem engleski;
	private JMenuItem japanski;
	private JMenuItem francuski;
	
	private UnosParametraAction up = new UnosParametraAction();
	private ExitAction ea = new ExitAction();
	private AboutAction aa = new AboutAction();
	private SaveAction sa = new SaveAction();
	private OpenAction oa = new OpenAction();

	public GlavniMeni (){						
		
	    file=new JMenu("File");
	    //file.setMnemonic(KeyEvent.VK_F);
	    file.setForeground(Color.WHITE);
	    miNew =new JMenu("New");
	    	  
		mWizard=new JMenuItem("Wizard");
		mWizard.addActionListener(new AddCvorWizardAction());
		mWizard.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
		
	
		
//-----------------------------------------------------------------------------

		mParametar= new JMenuItem("Parameter");
		
		mParametar.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_P, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK));
		
		mParametar.addActionListener(up);

//-------------------------------------------------------------------------------		
		
		miNew.add(mParametar);
		miNew.add(mWizard);
		miNew.addSeparator();
		
		miOpen =new JMenuItem("Open");
		miOpen.addActionListener(oa);
		miOpen.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_O, ActionEvent.CTRL_MASK));

	    miSave =new JMenuItem("Save");
	    miSave.addActionListener(sa);
	    miSave.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_S, ActionEvent.CTRL_MASK));	   
	    
	    miEdit = new JMenuItem("Edit");
        miDelete =new JMenuItem("Delete");

		
		//---------------------------------------------------------
		miExit = new JMenuItem("Exit");
		miExit.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_F4, ActionEvent.ALT_MASK));

		miExit.addActionListener(ea);
		
		//---------------------------------------------------
		
		file.add(miNew);
		file.addSeparator();
		file.add(miOpen);
		file.addSeparator();
		file.add(miSave);
		file.add(miEdit);
		file.addSeparator();

		file.add(miDelete);		
		file.addSeparator();
		file.add(miExit);
		
				// dodavanje elemenata za lokalizaciju
		
		language = new JMenu ("Language");
		srpski = new JMenuItem ("Srpski");
		engleski = new JMenuItem ("Engleski");
		japanski = new JMenuItem ("Japanski");
		francuski = new JMenuItem ("Francuski");
		
		

		engleski.setSelected(true);
		engleski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en", "US"));
				PocetniProzor.getInstance().changeLanguage();
				
			}
		});
		
				
		srpski.setSelected(true);
		srpski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr","RS"));
				PocetniProzor.getInstance().changeLanguage();
				
			}
		});
		
		japanski.setSelected(true);
		japanski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("ja","JP"));
				PocetniProzor.getInstance().changeLanguage();
				
			}
		});
		
		francuski.setSelected(true);
		francuski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("fr","FR"));
				PocetniProzor.getInstance().changeLanguage();
				
			}
		});
		
		
		
		
		language.add(srpski);
		language.add(engleski);
		language.add(japanski);
		language.add(francuski);
						// 
		
	

		help=new JMenu("Help");
		help.setForeground(Color.WHITE);
		//-------------------------------------------------------
	

		hAbout=new JMenuItem("About..");
		hAbout.addActionListener(aa);
				
		help.add(hAbout);
		//----------------------------------------------------
		add(file);
		add(help);
		add(language);
	}	
	
	public void initComponents() {

		file.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file"));
				
		miNew.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.new"));
				
		mWizard.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.new.wizard"));
				
		mParametar.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.new.parametar"));
				
		miOpen.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.open"));
				
		miSave.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.save"));
				
		miDelete.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.delete"));
		
		miEdit.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.edit"));
								
		miExit.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.file.exit"));
				
		help.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.help"));
				
		hAbout.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.help.about"));
								
		language.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.language"));
		
		srpski.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.language.srpski"));
				
		engleski.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.language.engleski"));
		
		japanski.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.language.japanski"));
		
		francuski.setText(PocetniProzor.getInstance().getResourceBundle().getString("menu.language.francuski"));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

	
}


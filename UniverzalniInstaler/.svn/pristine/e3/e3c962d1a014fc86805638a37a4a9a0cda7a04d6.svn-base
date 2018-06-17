package admin.gui.paneliZaIzmenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import admin.gui.glavniProzor.PocetniProzor;
import model.Proizvod;
import model.Workspace;

public class PanelZaUnosProizvoda extends JFrame { 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 625509905323333218L;
	JTextField txtime;
	public JTextField getTxtime() {
		return txtime;
	}

	public void setTxtime(JTextField txtime) {
		this.txtime = txtime;
	}

	private String imeProizvoda;
	private String izvornaDestinacija;
	private Boolean izmena;
	private Proizvod proizvod2;
	private Proizvod proizvod1;
	private JTextField txtValue;
	private JFileChooser browse;
	
	
	public PanelZaUnosProizvoda(Boolean izmena1) {
					// JFrame
		setTitle ( PocetniProzor.getInstance().getResourceBundle().getString("proizvod.naslov"));
		setIconImage(new ImageIcon("slike/ikonica.png").getImage());

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		izmena=izmena1;

					//  panel - box   panIme - ( Username ) 
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout( panel , BoxLayout.Y_AXIS);
		panel.setLayout(box);
		panel.setBackground(new Color(51, 51, 51));

		JPanel panIme = new JPanel( new FlowLayout( FlowLayout.LEFT));
		JLabel lblime = new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("proizvod.ime"));
		lblime.setPreferredSize(new Dimension ( 120, 35 ));
		txtime = new JTextField();
		txtime.setPreferredSize(new Dimension (400, 35));
		panIme.add(lblime);
		panIme.add(txtime);
		panIme.setBackground(new Color(51, 51, 51));
		lblime.setForeground(Color.WHITE);
		txtime.setBackground(new Color(255, 217, 179));
		
		panel.add(panIme);
		panel.add( Box.createVerticalStrut(15));
		add(panel , BorderLayout.CENTER);
		
		
		
		
		
		txtValue = new JTextField();
		txtValue.setPreferredSize(new Dimension (400, 35));
		txtValue.setBackground(new Color(255, 217, 179));
		
		JPanel panValue = new JPanel();
		JButton btnBrowse = new JButton(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.browse"));
		btnBrowse.setPreferredSize(new Dimension(75,25));
		btnBrowse.setBackground(new Color(255, 140, 26));
		btnBrowse.addActionListener(new BrowseActionListener());
		panValue.setBackground(new Color(51, 51, 51));
		FlowLayout fl1=new FlowLayout(FlowLayout.RIGHT);
		panValue.setLayout(fl1);
		JLabel lblValue = new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.izaberidirektivu"));
		lblValue.setForeground(Color.WHITE);
		lblValue.setPreferredSize(new Dimension ( 120, 35 ));
		
		panValue.add(lblValue);
		panValue.add(txtValue);
		panValue.add(btnBrowse);
		
		panel.add(panValue);
		panel.add(Box.createVerticalStrut(15));
		
		
		
		
		
		
		
		
		
		

		JPanel panBottom = new JPanel();
		BoxLayout box1 = new BoxLayout( panBottom , BoxLayout.X_AXIS);
		panBottom.setLayout(box1);
		panBottom.setBackground(new Color(51, 51, 51));
	
		JButton btnOk=new JButton(PocetniProzor.getInstance().getResourceBundle().getString("okOption"));
		btnOk.setPreferredSize(new Dimension(75,25));
		btnOk.setBackground(new Color(255, 140, 26));
		btnOk.addActionListener(new OkActionListener());
		JButton btnCancel=new JButton(PocetniProzor.getInstance().getResourceBundle().getString("cancelOption"));
		btnCancel.setPreferredSize(new Dimension(75,25));
		btnCancel.setBackground(new Color(255, 140, 26));
		btnCancel.addActionListener(new CancelActionListener());
		panBottom.add(Box.createGlue());
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
			
		add(panBottom,BorderLayout.SOUTH);
		

		pack();
		validate();	
	}
	


	public class OkActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File f = new File(txtValue.getText());
			if(!(txtime.getText()!=null && !txtime.getText().isEmpty()))
				JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error.poruka")
						 , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			else if(!(txtValue.getText()!=null && !txtValue.getText().isEmpty())){
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("dodatno.unesitedesti"),PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"),JOptionPane.ERROR_MESSAGE);
			}else if(!(f.exists())) {
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("dodatno.unesitezeljenu"),PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			}else{
				
				DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
						.getInstance().getTree().getLastSelectedPathComponent();
				
				
				//proverava da li je selektovani cvor tipa proizvod,wizard ili parametar kako bi mu zabranio 
				//unos deteta kao proizvoda
				
				if (sel != null) {
					imeProizvoda=txtime.getText();
					izvornaDestinacija=txtValue.getText();
					/*
					 * Ako je izmena u pitanju uzmi selektovani proizvod
					 * i izvuci ga iz cvora kako bi mogao proveriti ime
					 * */
					Object o = null;
					if(izmena) {
						
							if (sel != null) {
								o = sel.getUserObject();
								proizvod2=(Proizvod) o;
							}
					}
					if (sel.getPath().length==1 || (sel.getPath().length==2 && izmena)){
						
						
						int vecPostojiProizvod=0;
						Workspace workspace1 =(Workspace) PocetniProzor.getInstance().getWorkspace1();
						List<Proizvod> listaProizvoda=workspace1.getListaProizvoda();
						for(int i=0; i<listaProizvoda.size();i++){
							Proizvod proizvod1=listaProizvoda.get(i);
							if(txtime.getText().equals(proizvod1.getIme())){
								JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("proizvod.postojeci"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
								vecPostojiProizvod=1;
								break;
								
							}else if(txtime.getText().equals(proizvod1.getIme()) && (!proizvod1.getIme().equals(proizvod2.getIme()) && izmena)){
								JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("proizvod.postojeci"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
								vecPostojiProizvod=1;
								break;
							}
						}	
						
						if(vecPostojiProizvod==0){
								
								
							    if(izmena)
								    proizvod1=(Proizvod) o;
							    else
							    	proizvod1 = new Proizvod(imeProizvoda);
						       
						        
						        //OVDE MENJAM STATUSNU LINIJU
						        JLabel a;
						        if(izmena)
									a = new JLabel("Product:  '"+proizvod1.getIme()+"'  changed name to:  '"+imeProizvoda + "'");
						        else
						        	a = new JLabel("Product:  '"+imeProizvoda+"'  created");
						        a.setForeground(Color.WHITE);
						        PocetniProzor.getInstance().getPanStatusLinija().removeAll();
						        PocetniProzor.getInstance().getPanStatusLinija().add(a);
						        PocetniProzor.getInstance().getPanStatusLinija().revalidate();

						        proizvod1.setIzvornaAdresa(izvornaDestinacija);
						        
						        if(izmena) {
						        	proizvod1.setIme(imeProizvoda);
									PocetniProzor.getInstance().getTreeModel().nodeChanged(sel);

						        }else {
						        
								workspace1.addProizvod(proizvod1);
						        
								DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(proizvod1);
		
								
								PocetniProzor.getInstance().getTreeModel()
										.insertNodeInto(nNode, sel, sel.getChildCount());
								
								//naredbe koje nam odma selektuju nas novonastali cvor
								PocetniProzor.getInstance().getTree()
										.setSelectionPath(new TreePath(nNode.getPath()));
								PocetniProzor.getInstance().getTree()
										.scrollPathToVisible(new TreePath(nNode.getPath()));
						        }
								setVisible(false);
						}
					
				    }else {JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("proizvod.ne_postojeci"), PocetniProzor.IME_APLIKACIJE,
						JOptionPane.WARNING_MESSAGE);
				    setVisible(false);
				    }
			       }else{
					
					JOptionPane.showMessageDialog(PocetniProzor.getInstance(), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.select"), PocetniProzor.IME_APLIKACIJE,
							JOptionPane.WARNING_MESSAGE);
					setVisible(false);
				}
			}
						
		}
	}
	
	public class CancelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);	
		}
	}
	
	public class BrowseActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			browse = new JFileChooser();

		    browse.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int dijalog = browse.showOpenDialog(null);
			
			if(dijalog == JFileChooser.APPROVE_OPTION) {
				txtValue.setText(browse.getSelectedFile().getAbsolutePath());
		    }						
		}
	}
}






package admin.gui.parametar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import admin.gui.glavniProzor.PocetniProzor;
import model.Parametar;
import model.Wizard;


public class UnosParametra extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6165097138591697742L;
	private JTextField txtNP;
	private JComboBox boxTP;
	private List<String> listaNP;
	private JRadioButton promenljiv;
	private JRadioButton read_only;
	private JCheckBox vidljiv;
	private JCheckBox obavezan;
	private Boolean izmena;
	
	
	private String stariTipParametra;
	private String idParametar;
	private String parameterName;
	private String locationParametar;
	private String DataTypeParametar;


	private String valueParametar;
	
	
	public UnosParametra(Boolean izmena1) {
		// TODO Auto-generated method stub
		
		setTitle(PocetniProzor.getInstance().getResourceBundle().getString("parametar.naslov"));
		setSize(500, 500);
		setIconImage(new ImageIcon("slike/ikonica.png").getImage());

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//Promenjiva koja ce se koristiti za prepoznavanje
		//da li je izmena izvrsena nad parametrom
		izmena=izmena1;
		
		JPanel panCenter=new JPanel();
		panCenter.setBackground(new Color(51, 51, 51));
		BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		
		Dimension dim=new Dimension(200, 35);
		
		//NazivParametra
		
		JPanel panNP=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panNP.setBackground(new Color(51, 51, 51));
		JLabel lblNP=new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("parametar.ime"));
		lblNP.setPreferredSize(dim);
		lblNP.setForeground(Color.WHITE);
		txtNP=new JTextField();
		txtNP.setBackground(new Color(255, 217, 179));
		txtNP.setPreferredSize(dim);
		txtNP.addActionListener(new TextActionListener());
		panNP.add(lblNP);
		panNP.add(txtNP);
		
		//TipPodatka
		
		JPanel panTP=new JPanel(new FlowLayout(FlowLayout.LEFT));
		panTP.setBackground(new Color(51, 51, 51));
		JLabel lblTP=new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("parametar.tip"));
		lblTP.setPreferredSize(dim);
		lblTP.setForeground(Color.WHITE);
		String[] tipovi= {"", "One Line Text", "Multiple Line Text", "Boolean", "File Chooser", "Image","Izvorni"};
		boxTP=new JComboBox(tipovi);
		boxTP.setPreferredSize(dim);
		boxTP.setBackground(new Color(255, 217, 179));
		boxTP.addActionListener(new TextActionListener());
		panTP.add(lblTP);
		panTP.add(boxTP);

		
		panCenter.add(panNP);
		panCenter.add(panTP);

		panCenter.add(Box.createVerticalStrut(25));  
        add(panCenter,BorderLayout.CENTER);
		
		//Buttons
        
        JPanel panelRBtn = new JPanel();
        FlowLayout fl= new FlowLayout(FlowLayout.LEFT);
        panelRBtn.setLayout(fl);
        panelRBtn.setBackground(new Color(51, 51, 51));
        promenljiv=new JRadioButton(PocetniProzor.getInstance().getResourceBundle().getString("parametar.btn.promenjiv"));
        promenljiv.setBackground(new Color(51, 51, 51));
        promenljiv.setForeground(Color.WHITE);
        read_only=new JRadioButton(PocetniProzor.getInstance().getResourceBundle().getString("parametar.btn.read_only"));
        read_only.setBackground(new Color(51, 51, 51));
        read_only.setForeground(Color.WHITE);
        ButtonGroup btnGroup1=new ButtonGroup();
        btnGroup1.add(promenljiv);
        btnGroup1.add(read_only);
        panelRBtn.add(promenljiv);
        panelRBtn.add(read_only);
        panCenter.add(panelRBtn);
        
        JPanel panelCBtn1 = new JPanel();
        panelCBtn1.setBackground(new Color(51, 51, 51));
        panelCBtn1.setLayout(fl);
        JPanel panelCBtn2 = new JPanel();
        panelCBtn2.setBackground(new Color(51, 51, 51));
        panelCBtn2.setLayout(fl);
        vidljiv=new JCheckBox(PocetniProzor.getInstance().getResourceBundle().getString("parametar.box.vidljiv"));
        vidljiv.setBackground(new Color(51, 51, 51));
        vidljiv.setForeground(Color.WHITE);
        obavezan=new JCheckBox(PocetniProzor.getInstance().getResourceBundle().getString("parametar.box.obavezan"));
        obavezan.setBackground(new Color(51, 51, 51));
        obavezan.setForeground(Color.WHITE);
        panelCBtn1.add(vidljiv);
        panelCBtn2.add(obavezan);
        panCenter.add(panelCBtn1);
        panCenter.add(panelCBtn2);
       
           
        JPanel panBottom=new JPanel();
        panBottom.setBackground(new Color(51, 51, 51));
		BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);
		
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

	}
	//ActionListener-i

	public class TextActionListener implements ActionListener {                  //////////////////
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() instanceof JComboBox){
				JComboBox a=(JComboBox) e.getSource();
				String selectedBox=(String)a.getSelectedItem();
				System.out.println(selectedBox);
				DataTypeParametar=selectedBox;
			}
			else
			System.out.println(e.getActionCommand());

		}
	} 

	public class OkActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if(!(txtNP.getText()!=null && !txtNP.getText().isEmpty()))
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("parametar.naziv")
 , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			
			else if(boxTP.getSelectedItem()=="")
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("parametar.tip") , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			
			else if(boxTP.getSelectedItem()=="Izvorni" && (read_only.isSelected()|| !(vidljiv.isSelected()) || !(obavezan.isSelected()))) {
					JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("dodatno.staradisbre") , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			}
			else if((promenljiv.isSelected() && obavezan.isSelected()) && (!(vidljiv.isSelected())))
					JOptionPane.showMessageDialog(null, "Ukoliko je parametar promenljiv ili obavezan mora biti vidljiv", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			else if(!((promenljiv.isSelected()) || (read_only.isSelected()))) {
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("parametar.odabir"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			}	
			else if(read_only.isSelected() && obavezan.isSelected()){
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("parametar.obavezni") , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			}
			else {
				stariTipParametra=(String) boxTP.getSelectedItem();
				
				DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
						.getInstance().getTree().getLastSelectedPathComponent();
				
				
				
				Object o = null;
				if (sel != null) {
					o = sel.getUserObject();
				}
				
				//gleda da li je selektovani cvor koren ili proizvod ili parametar kako bi zabranio
				//unos novog cvora tipa parametar kao deteta
				
				if (sel != null){
				
					if (o instanceof Wizard) {
						
						int vecPostojiParametar=0; //Ova promenljiva se koristi da proverimo da li vec postoji parametar sa istim nazivom.
						Wizard cvorWizard = (Wizard) o;
						List<Parametar> parametri =cvorWizard.getParametri();
						for(int i=0; i<parametri.size();i++){
							Parametar parametar1=parametri.get(i);
							if(txtNP.getText().equals(parametar1.getParameter_name())){
								JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("parametar.postojeci") , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
								vecPostojiParametar=1;
								break;
							}
						}	
						if(vecPostojiParametar==0){
				        
						        Parametar parametar1= new Parametar(txtNP.getText(),DataTypeParametar);
						        
						        
						        //////OVDE MENJAM STATUSNU LINIJU
						        JLabel a = new JLabel("Parametar:  '"+txtNP.getText()+"'  created");
						        a.setForeground(Color.WHITE);
						        PocetniProzor.getInstance().getPanStatusLinija().removeAll();
						        PocetniProzor.getInstance().getPanStatusLinija().add(a);
						        
						        cvorWizard.addParametar(parametar1);
						        
								DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(parametar1);
		
								
								PocetniProzor.getInstance().getTreeModel()
										.insertNodeInto(nNode, sel, sel.getChildCount());
		
								nNode.setAllowsChildren(false);
		
								//naredbe koje nam odma selektuju nas novonastali cvor
						
								PocetniProzor.getInstance().getTree()
										.setSelectionPath(new TreePath(nNode.getPath()));
								PocetniProzor.getInstance().getTree()
										.scrollPathToVisible(new TreePath(nNode.getPath()));
								
								if((promenljiv.isSelected()))
									parametar1.setChangeable(true);
								else
									parametar1.setReadOnly(true);
								
								if((obavezan.isSelected()))
									parametar1.setObavezan(true);
								if((vidljiv.isSelected()))
									parametar1.setVidljiv(true);
								
								if(DataTypeParametar=="Image") {                                        //////////////
									ImageFrame imageFrame = new ImageFrame(izmena);
								}
								else if(DataTypeParametar=="One Line Text") {
									OneLineTextFrame oneLineTextFrame = new OneLineTextFrame(izmena);
								}
								else if(DataTypeParametar=="Multiple Line Text") {
									MultipleLineTextFrame  multipleLineTextFrame = new MultipleLineTextFrame(izmena);
								}
								else if(DataTypeParametar=="Boolean") {
									//BooleanFrame booleanFrame = new BooleanFrame ();
								}
								else if(DataTypeParametar=="Izvorni") {
									//IzborIzvornogFoldera izvor = new IzborIzvornogFoldera();
								}
								
								
								setVisible(false);
						}
					}else if(o instanceof Parametar && izmena){
						Parametar parametar1=(Parametar) o;
						// Sledi provera da li ime parametra vec postiji
						// Uzima cvor roditelja i ide kroz njegovu listu 
						// parametara
						int vecPostojiParametar=0;
						DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
						Object parent = parentNode.getUserObject();
						Wizard cvorWizard = (Wizard) parent;
						List<Parametar> parametri =cvorWizard.getParametri();
						for(int i=0; i<parametri.size();i++){
							Parametar parametar2=parametri.get(i);
							if(txtNP.getText().equals(parametar2.getParameter_name()) && !(parametar1.getParameter_name().equals(parametar2.getParameter_name()))){
								JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("parametar.postojeci") , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
								vecPostojiParametar=1;
								break;
							}
						}	
						if(vecPostojiParametar==0){
							//Ako ime parametra ne postoji, mozemo ga izmeniti 				
							JLabel a = new JLabel("Product:  '"+parametar1.getParameter_name()+"'  changed name to:  '"+ txtNP+ "'");
							a.setForeground(Color.WHITE);
					        PocetniProzor.getInstance().getPanStatusLinija().removeAll();
					        PocetniProzor.getInstance().getPanStatusLinija().add(a);
							parametar1.setParameter_name(txtNP.getText());
							parametar1.setChangeable(promenljiv.isSelected());
							parametar1.setReadOnly(read_only.isSelected());
							parametar1.setVidljiv(vidljiv.isSelected());
							parametar1.setObavezan(obavezan.isSelected());
							parametar1.setData_type((String)boxTP.getSelectedItem());
							
					        /* U zavisnosti od tipa parametra otvaramo nove prozore za izmenu podataka
					         * 
					         * */
							
							if(boxTP.getSelectedItem().equals("Image")){
								//sada da pozovemo prozor i da mu ubacimo novu sliku 
								ImageFrame p= new ImageFrame(izmena);
								if(boxTP.getSelectedItem().equals(stariTipParametra))
									p.getImgLabel().setIcon((ImageIcon)parametar1.getValue());
								
								p.setVisible(true);
							}
							else if(boxTP.getSelectedItem().equals("One Line Text")) {
								// ubacen stari tekst u txtfield naseg prozora OneLineText edit
								OneLineTextFrame p= new OneLineTextFrame(izmena);
								if(boxTP.getSelectedItem().equals(stariTipParametra)){
									System.out.println(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.unbeliavable"));
									JTextArea tekst=(JTextArea)parametar1.getValue();
									p.getTxtValue().setText(tekst.getText());
								}
								p.setVisible(true);
							}
							else if(boxTP.getSelectedItem().equals("Multiple Line Text")) {
								// ubacen stari tekst u txtfield naseg prozora MultiLineText edit
								MultipleLineTextFrame p= new MultipleLineTextFrame(izmena);
								if(boxTP.getSelectedItem().equals(stariTipParametra)){
									JTextArea tekst=(JTextArea)parametar1.getValue();
									p.getTxtValue().setText(tekst.getText());
								}
								p.setVisible(true);
							}
							else if(boxTP.getSelectedItem().equals("Boolean")) {
							}
							else {}
							
							
							PocetniProzor.getInstance().getTreeModel().nodeChanged(sel);
			
							setVisible(false);
						}

											
					}
					else{		JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("parametar.nemozes"), PocetniProzor.IME_APLIKACIJE,
								JOptionPane.WARNING_MESSAGE);
								setVisible(false);
					}
				}else{	
				JOptionPane.showMessageDialog(PocetniProzor.getInstance(), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.select") , PocetniProzor.IME_APLIKACIJE,
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

	public JTextField getTxtNP() {
		return txtNP;
	}

	public void setTxtNP(JTextField txtNP) {
		this.txtNP = txtNP;
	}

	public JComboBox getBoxTP() {
		return boxTP;
	}

	public void setBoxTP(JComboBox boxTP) {
		this.boxTP = boxTP;
	}

	public JRadioButton getPromenljiv() {
		return promenljiv;
	}

	public void setPromenljiv(JRadioButton promenljiv) {
		this.promenljiv = promenljiv;
	}

	public JRadioButton getRead_only() {
		return read_only;
	}

	public void setRead_only(JRadioButton read_only) {
		this.read_only = read_only;
	}

	public JCheckBox getVidljiv() {
		return vidljiv;
	}

	public void setVidljiv(JCheckBox vidljiv) {
		this.vidljiv = vidljiv;
	}

	public JCheckBox getObavezan() {
		return obavezan;
	}

	public void setObavezan(JCheckBox obavezan) {
		this.obavezan = obavezan;
	}

	public String getStariTipParametra() {
		return stariTipParametra;
	}

	public void setStariTipParametra(String stariTipParametra) {
		this.stariTipParametra = stariTipParametra;
	}

	public String getDataTypeParametar() {
		return DataTypeParametar;
	}

	public void setDataTypeParametar(String dataTypeParametar) {
		DataTypeParametar = dataTypeParametar;
	}

}


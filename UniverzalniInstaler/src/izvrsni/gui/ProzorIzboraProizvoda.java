package izvrsni.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.zip.InflaterInputStream;

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
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import admin.gui.glavniProzor.PocetniProzor;
import admin.gui.previewWizard.GenerickiWizard;
import model.Parametar;
import model.Proizvod;
import model.Wizard;

public class ProzorIzboraProizvoda extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3362682183786215365L;
	private JTextField txtValue;
	private JFileChooser browse;
	private static ResourceBundle resourceBundle;

	
	public ProzorIzboraProizvoda(){
		setTitle (PocetniProzor.getInstance().getResourceBundle().getString("izvrsni.naslov"));
		setSize( 400 , 400 );
		setIconImage(new ImageIcon("slike/ikonica.png").getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		

		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		panel.setBackground(new Color(51, 51, 51));
		txtValue = new JTextField();
		txtValue.setPreferredSize(new Dimension (400, 35));
		txtValue.setBackground(new Color(215,183,188));
		
		JPanel panValue = new JPanel();
		JButton btnBrowse = new JButton(PocetniProzor.getInstance().getResourceBundle().getString("izvrsni.browse"));
		btnBrowse.setPreferredSize(new Dimension(75,25));
		btnBrowse.setBackground(new Color(79, 84, 125));
		btnBrowse.addActionListener(new BrowseActionListener());
		panValue.setBackground(new Color(51, 51, 51));
		FlowLayout fl1=new FlowLayout(FlowLayout.RIGHT);
		panValue.setLayout(fl1);
		JLabel lblValue = new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("izvrsni.putanja"));
		lblValue.setForeground(Color.WHITE);
		lblValue.setPreferredSize(new Dimension ( 100, 35 ));
		
		panValue.add(lblValue);
		panValue.add(txtValue);
		panValue.add(btnBrowse);
		
		panel.add(panValue);
		panel.add(Box.createVerticalStrut(15));
		add(panel, BorderLayout.CENTER);
		

		JPanel panBottom = new JPanel();
		BoxLayout box2 = new BoxLayout( panBottom , BoxLayout.X_AXIS);
		panBottom.setLayout(box2);
		panBottom.setBackground(new Color(51, 51, 51));
	
		JButton btnOk=new JButton(PocetniProzor.getInstance().getResourceBundle().getString("okOption"));
		btnOk.setPreferredSize(new Dimension(75,25));
		btnOk.setBackground(new Color(79, 84, 125));
		btnOk.addActionListener(new OkActionListener());
		JButton btnCancel=new JButton(PocetniProzor.getInstance().getResourceBundle().getString("cancelOption"));
		btnCancel.setPreferredSize(new Dimension(75,25));
		btnCancel.setBackground(new Color(79, 84, 125));
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
	
	public class BrowseActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			browse = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Proizvod","proizvod");
			browse.setFileFilter(filter);
			int dijalog = browse.showOpenDialog(null);
			
			if(dijalog == JFileChooser.APPROVE_OPTION) {
				txtValue.setText(browse.getSelectedFile().getAbsolutePath());
		    }						
		}
	}
	
	public class OkActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			File f = new File(txtValue.getText());
			ObjectInputStream in = null;
			Proizvod proizvod1 = null;
			if(!(txtValue.getText()!=null && !txtValue.getText().isEmpty()))
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("izvrsni.unesite_putanju"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			else if(!(f.exists())) {
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("izvrsni.postojecu"),PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			}
			else{
				try {
					in = new ObjectInputStream(new BufferedInputStream(new InflaterInputStream(new FileInputStream(f))));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try {
					proizvod1=(Proizvod) in.readObject();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				GenerickiWizard gw= new GenerickiWizard(true,f);
				gw.setVisible(true);
				
				int duzinaListeWizarda=proizvod1.getListaWizarda().size();
				
				if(duzinaListeWizarda==1)
					gw.addDugmadZaJedanJediniWizard(proizvod1);
				else
					gw.addPocetnaDugmad(proizvod1);
				
				Wizard prviWizard = proizvod1.getListaWizarda().get(0);
				
				List<Parametar> parametri =prviWizard.getParametri();
				for(int i=0; i<parametri.size();i++){
					Parametar parametar1=parametri.get(i);
					if(parametar1.getData_type().equals("Image")){
						gw.addImage(parametar1.getValue(),parametar1.getVidljiv(),parametar1.getChangeable(), parametar1.getObavezan());
					}
					else if(parametar1.getData_type().equals("One Line Text")){
						gw.addOneLineText(parametar1.getValue(),parametar1.getReadOnly(),parametar1.getVidljiv(), parametar1.getObavezan());
					}
					else if(parametar1.getData_type().equals("Multiple Line Text")){
						gw.addMultiLineText(parametar1.getValue(),parametar1.getReadOnly(),parametar1.getVidljiv(), parametar1.getObavezan());
					}
					else if(parametar1.getData_type().equals("Boolean")){
						gw.addBoolean(parametar1.getVidljiv(), parametar1.getReadOnly(), parametar1.getObavezan());
					}
					else if(parametar1.getData_type().equals("File Chooser")){
						gw.addFileChooser(parametar1.getVidljiv(), parametar1.getObavezan(),false);
					}else{
						gw.addFileChooser(parametar1.getVidljiv(), parametar1.getObavezan(),true);
					}
				}
				
				
				setVisible(false);
			}
		}
	}
	
	public class CancelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			setVisible(false);	
		}
	}

	
	public void changeLanguage() {

		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
		
		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
		
	}
}

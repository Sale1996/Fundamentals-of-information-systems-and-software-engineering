package admin.gui.parametar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;

import admin.gui.glavniProzor.PocetniProzor;
import model.Parametar;
import model.Wizard;

public class ImageFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5866951504908448854L;
	private JTextField txtValue;
	private JFileChooser browse;
	private JPanel panel;
	private FileNameExtensionFilter filter;
	private JLabel imgLabel;
	private String put;
	private Image slika_smanjena;
	private Boolean izmena;
	
	public ImageFrame(Boolean izmena1){

		setTitle ( PocetniProzor.getInstance().getResourceBundle().getString("image.naslov"));
		setSize( 400 , 400 );
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("slike/ikonica.png").getImage());

		setResizable(false);
		setVisible(true);

		izmena=izmena1;
		panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		panel.setBackground(new Color(51, 51, 51));
		txtValue = new JTextField();
		txtValue.setPreferredSize(new Dimension (400, 35));
		txtValue.setBackground(new Color(255, 217, 179));
		
		JPanel panValue = new JPanel();
		JButton btnBrowse = new JButton(PocetniProzor.getInstance().getResourceBundle().getString("wizard.browse"));
		btnBrowse.setPreferredSize(new Dimension(75,25));
		btnBrowse.setBackground(new Color(255, 140, 26));
		btnBrowse.addActionListener(new BrowseActionListener());
		panValue.setBackground(new Color(51, 51, 51));
		FlowLayout fl1=new FlowLayout(FlowLayout.RIGHT);
		panValue.setLayout(fl1);
		JLabel lblValue = new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("image.value"));
		lblValue.setForeground(Color.WHITE);
		lblValue.setPreferredSize(new Dimension ( 100, 35 ));
		
		panValue.add(lblValue);
		panValue.add(txtValue);
		panValue.add(btnBrowse);
		
		panel.add(panValue);
		panel.add(Box.createVerticalStrut(15));
		add(panel, BorderLayout.CENTER);
		
		imgLabel = new JLabel();
		imgLabel.setPreferredSize(new Dimension ( 200, 200 ));
		imgLabel.setForeground(Color.WHITE);
		panel.add(imgLabel, BorderLayout.CENTER);
		
		JPanel panBottom = new JPanel();
		BoxLayout box2 = new BoxLayout( panBottom , BoxLayout.X_AXIS);
		panBottom.setLayout(box2);
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

	public class OkActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			File f = new File(txtValue.getText());
			if(!(txtValue.getText()!=null && !txtValue.getText().isEmpty()))
				JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("image.parametar"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			else if(!(f.exists())) {
				JOptionPane.showMessageDialog(null,PocetniProzor.getInstance().getResourceBundle().getString("image.putanja") , PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
			}
			else {
				
				/* uzima selektovani cvor parametra i u njega ubacuje sliku koju smo izabrali, pa zatvara prozor */
				DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
				.getInstance().getTree().getLastSelectedPathComponent();
		
				Object o = null;
				if (sel != null) {
					o = sel.getUserObject();
				}
				
				
				
				Parametar selektovaniParametar=(Parametar) o;
				
				ImageIcon imageIcon = new ImageIcon(slika_smanjena);

				selektovaniParametar.setValue(imageIcon);
				
				PocetniProzor.getInstance().getTreeModel().nodeChanged(sel);
		
				setVisible(false);
			}	
		}
	}
	
	public class CancelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(!izmena){
				DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
						.getInstance().getTree().getLastSelectedPathComponent();
				
				Object o = null;
				if (sel != null) {
					o = sel.getUserObject();
				}
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
				Object parent = parentNode.getUserObject();
				
				Parametar parametar1=(Parametar) o;
				Wizard roditelj =(Wizard) parent;
				roditelj.removeParametar(parametar1);
				
				PocetniProzor.getInstance().getTreeModel().removeNodeFromParent(sel);
			}
			setVisible(false);	
		}
	}

	public class BrowseActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			browse = new JFileChooser();
			filter = new FileNameExtensionFilter("Images","jpg", "jpeg", "png");
			browse.setFileFilter(filter);
			int dijalog = browse.showOpenDialog(null);
			
			if(dijalog == JFileChooser.APPROVE_OPTION) {
				put = browse.getSelectedFile().getAbsolutePath();
				txtValue.setText(put);
				
				BufferedImage slika = null;
				try {
				    slika = ImageIO.read(new File(put));
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, PocetniProzor.getInstance().getResourceBundle().getString("image.putanja"), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.error"), JOptionPane.ERROR_MESSAGE);
				}
				
				slika_smanjena = slika.getScaledInstance(200, 200,Image.SCALE_SMOOTH);
				ImageIcon imageIcon = new ImageIcon(slika_smanjena);
				imgLabel.setIcon(imageIcon);
			}			
		}
	}

	public JLabel getImgLabel() {
		return imgLabel;
	}

	public void setImgLabel(JLabel imgLabel) {
		this.imgLabel = imgLabel;
	}
}


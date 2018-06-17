package admin.gui.parametar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.tree.DefaultMutableTreeNode;

import admin.gui.glavniProzor.PocetniProzor;
import model.Parametar;
import model.Wizard;

public class MultipleLineTextFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2080549955247948065L;
	private JTextArea txtValue;
	private Boolean izmena;
	
	public MultipleLineTextFrame(Boolean izmena1) {

		setTitle ( PocetniProzor.getInstance().getResourceBundle().getString("wizard.multi"));
		setSize( 400 , 400 );
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("slike/ikonica.png").getImage());

		setResizable(false);
		setVisible(true);

		izmena=izmena1;
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout( panel , BoxLayout.Y_AXIS);
		panel.setLayout(box);
		panel.setBackground(new Color(51, 51, 51));
       
		JPanel panValue = new JPanel( new FlowLayout( FlowLayout.LEFT));
		JLabel lblValue = new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.valuee"));
		lblValue.setPreferredSize(new Dimension ( 100, 35 ));
		txtValue = new JTextArea(10,50);
		txtValue.setLineWrap(true);
		JScrollPane txtScroll = new JScrollPane(txtValue);

		panValue.add(lblValue);
		panValue.add(txtScroll);
		panValue.setBackground(new Color(51, 51, 51));
		lblValue.setForeground(Color.WHITE);
		txtValue.setBackground(new Color(255, 217, 179));
		
		panel.add(panValue);
		panel.add( Box.createVerticalStrut(15));
		add(panel , BorderLayout.CENTER);
		

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
	
	/* Akcija koja se aktivira klikom na Ok i koja ubacuje vrednost sadrzaja multilineText-a
	 * u predhodno dodati cvor parametra
	 * */
	public class OkActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
					.getInstance().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			
			JTextArea multiLineText=new JTextArea(txtValue.getText());
			
			Parametar selektovaniParametar=(Parametar) o;
			selektovaniParametar.setValue(multiLineText);
			
			PocetniProzor.getInstance().getTreeModel().nodeChanged(sel);

			setVisible(false);	
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

	public JTextArea getTxtValue() {
		return txtValue;
	}

	public void setTxtValue(JTextArea txtValue) {
		this.txtValue = txtValue;
	}
}



package admin.gui.parametar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import admin.gui.glavniProzor.PocetniProzor;
import model.Parametar;
import model.Wizard;

public class OneLineTextFrame extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 701954129535921125L;
	private String imeProizvoda;
	private Boolean izmena;
	
	public OneLineTextFrame(Boolean izmena1) {

		setTitle (PocetniProzor.getInstance().getResourceBundle().getString("dodatno.onelinetext"));
		setSize( 400 , 400 );
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("slike/ikonica.png").getImage());

		setResizable(false);
		setVisible(true);

		
		izmena=izmena1;
		JPanel panel = new JPanel();
		BoxLayout box = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(box);
		panel.setBackground(new Color(51, 51, 51));
		txtValue = new JTextField();
		txtValue.setPreferredSize(new Dimension (400, 35));
		txtValue.setBackground(new Color(255, 217, 179));
		
		JPanel panValue = new JPanel();
		panValue.setLayout(new BorderLayout());
		panValue.setBackground(new Color(51, 51, 51));
		JLabel lblValue = new JLabel(PocetniProzor.getInstance().getResourceBundle().getString("dodatno.valuee"));
		lblValue.setForeground(Color.WHITE);
		lblValue.setPreferredSize(new Dimension ( 100, 35 ));
		
		panValue.add(lblValue,BorderLayout.WEST);
		panValue.add(txtValue,BorderLayout.CENTER);
		
	
		
		
		panel.add(panValue);
		panel.add(Box.createVerticalStrut(15));
		add(panel, BorderLayout.CENTER);
		

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
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
					.getInstance().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			
			JTextField oneLineText=new JTextField(txtValue.getText());
			
			Parametar selektovaniParametar=(Parametar) o;
			selektovaniParametar.setValue(oneLineText);
			
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
	
	JTextField txtValue;
	public JTextField getTxtValue() {
		return txtValue;
	}

	public void setTxtValue(JTextField txtValue) {
		this.txtValue = txtValue;
	}
}

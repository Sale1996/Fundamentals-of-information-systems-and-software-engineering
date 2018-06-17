package admin.gui.glavniProzor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import izvrsni.gui.ProzorIzboraProizvoda;




public class OdabirJezika extends JFrame implements ActionListener{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8299402307938314248L;
	JComboBox box;
	static Boolean value=true;
	private Boolean izvrsni;
	private ProzorIzboraProizvoda mf;


	public static Boolean isValue() {
		return value;
	}


	public OdabirJezika(Boolean izvrsni1) {
		
		setSize(350, 350);
		setResizable(true);
		setIconImage(new ImageIcon("slike/ikonica.png").getImage());

		setLocationRelativeTo(null);
		setVisible(true);
		
		
		izvrsni=izvrsni1;
		JPanel pan =new JPanel(new FlowLayout(FlowLayout.LEFT));		
		pan.setBackground(new Color(51, 51, 51));
		JLabel lbl=new JLabel("Choose your language for installation:");
		lbl.setPreferredSize(new Dimension(500,35));
		lbl.setForeground(Color.WHITE);
		String[] jezici= {"English", "Serbian", "Japanese", "French"};
		box=new JComboBox(jezici);
		box.setPreferredSize(new Dimension(320,41));
		box.setBackground(new Color(255, 217, 179));
		
				 
		JPanel pan_oc = new JPanel();         // panel za raspored dugmada ( ok i cancel)
		pan_oc.setPreferredSize(new Dimension(200,50));
		pan_oc.setBackground(new Color(51, 51, 51));		
		
		
		JButton btn_ok = new JButton("Ok");
		btn_ok.setPreferredSize(new Dimension(75,25));
		btn_ok.setBackground(new Color(255, 140, 26));
		btn_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String selected_box = (String) box.getSelectedItem();		
				
				if ( selected_box=="English") {
					setVisible(false);
					value = false;
					Locale.setDefault(new Locale("en", "US"));
					if(izvrsni){
						mf =new ProzorIzboraProizvoda();
						mf.changeLanguage();
					    mf.setVisible(true); 
					    
					}else{
					PocetniProzor.getInstance().changeLanguage();
					PocetniProzor.getInstance().setVisible(true);
					}
				}
				else if (selected_box=="Serbian") {
					setVisible(false);
					value=false;
					Locale.setDefault(new Locale("sr","RS"));
					if(izvrsni){
						mf =new ProzorIzboraProizvoda();
						mf.changeLanguage();
					    mf.setVisible(true); 
					    
					}else{
					PocetniProzor.getInstance().changeLanguage();
					PocetniProzor.getInstance().setVisible(true);
					}
				}
				else if ( selected_box=="Japanese") {
					setVisible(false);
					value=false;
					Locale.setDefault(new Locale("ja","JP"));
					if(izvrsni){
						mf =new ProzorIzboraProizvoda();
						mf.changeLanguage();
					    mf.setVisible(true); 
					    
					}else{
					PocetniProzor.getInstance().changeLanguage();
					PocetniProzor.getInstance().setVisible(true);
					}
				}
				else if ( selected_box=="French") {
					setVisible(false);
					value=false;
					Locale.setDefault(new Locale("fr","FR"));
					if(izvrsni){
						mf =new ProzorIzboraProizvoda();
						mf.changeLanguage();
					    mf.setVisible(true); 
					    
					}else{
					PocetniProzor.getInstance().changeLanguage();
					PocetniProzor.getInstance().setVisible(true);
					}

				}
			}
									
		});
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}					
		});	
				
		btn_cancel.setPreferredSize(new Dimension(75,25));
		btn_cancel.setBackground(new Color(255, 140, 26));
		pan_oc.add(Box.createGlue());
		pan_oc.add(btn_ok);
		pan_oc.add(Box.createHorizontalStrut(10));
		pan_oc.add(btn_cancel);
		pan_oc.add(Box.createHorizontalStrut(10));
				
		pan.add(lbl);
		pan.add(box);
		add(pan_oc , BorderLayout.SOUTH);
		add(pan);
				
		validate();
	}

		
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
			
	
}

package admin.gui.glavniProzor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutClass extends JFrame{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1782404663048271233L;
		private BufferedImage img;
	
		public AboutClass(){
			super();
			 setTitle(PocetniProzor.getInstance().getResourceBundle().getString("wizard.about"));
			 setSize(800,400);
			 setIconImage(new ImageIcon("slike/ikonica.png").getImage());
			 setLocationRelativeTo(null);
			 setVisible(true);
			 
			 
			 //-------panel koji ce sluziti za logo universtalatora-----
			 JLabel logo = new JLabel();
			 logo.setBackground(new Color(51,51,51));
			 logo.setOpaque(true); //da ne bude labela providna pa da mozemo podesiti nasu boju
			 logo.setPreferredSize(new Dimension(220,40));
			 logo.setIcon( new ImageIcon("slike/logo.png"));
		     add(logo,BorderLayout.WEST);
		     
		   
			 
			 //---------donji panel--------------------------
	 
			 JPanel donjiPanel = new JPanel();
			 donjiPanel.setBackground(new Color(51,51,51));
			 donjiPanel.setPreferredSize(new Dimension(50,50));
			 BoxLayout box=new BoxLayout(donjiPanel, BoxLayout.X_AXIS);
			 donjiPanel.setLayout(box);
			 add(donjiPanel,BorderLayout.SOUTH);
			 
			 
			 JButton btnOk=new JButton(PocetniProzor.getInstance().getResourceBundle().getString("okOption"));
			 btnOk.setPreferredSize(new Dimension(75,25));
			 btnOk.setBackground(new Color(255, 140, 26));
			 donjiPanel.add(Box.createGlue());
			 donjiPanel.add(btnOk);
			 donjiPanel.add(Box.createHorizontalStrut(10));
             btnOk.addMouseListener(new MouseListener() {
     			
     			@Override
     			public void mouseReleased(MouseEvent arg0) {
     				setVisible(false);
     			}
     			
     			@Override
     			public void mousePressed(MouseEvent arg0) {
     				
     			}
     			
     			@Override
     			public void mouseExited(MouseEvent arg0) {
     				
     			}
     			
     			@Override
     			public void mouseEntered(MouseEvent arg0) {
     				
     			}				
     			@Override
     			public void mouseClicked(MouseEvent arg0) {
     				
     				
     			}
     		});
			 
			 
			 
			 
			 //-----------TEXT PANEL-----------------------------
			 
			 JPanel textPanel = new JPanel();
			 textPanel.setBackground(new Color(82,82,82));
			 add(textPanel,BorderLayout.CENTER);
			 String daVidimo=new String("Ime \t Prezime \t grupa \nAleksandar \t Stanic \t 10.1");
			// JTextArea textArea=new JTextArea(PocetniProzor.getInstance().getResourceBundle().getString("wizard.textarea"),45,50);
			 JTextArea textArea=new JTextArea(daVidimo);
			 textArea.setLineWrap(true); 
			 textArea.setEditable(false);
			 textArea.setBackground(new Color(82,82,82));
			 textArea.setForeground(Color.WHITE);
			 textPanel.add(textArea,BorderLayout.CENTER);
			 
			 
	
		}

		public BufferedImage getImg() {
			return img;
		}

		public void setImg(BufferedImage img) {
			this.img = img;
		}
		
		
		
}

package admin.gui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import admin.gui.glavniProzor.OdabirJezika;


public class PozivPocProzora {
	
	 static JFrame mainFrame;
	 
	 
	 

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	    OdabirJezika  oj = new OdabirJezika(false);		
		oj.setVisible(true);	
		
	}

}

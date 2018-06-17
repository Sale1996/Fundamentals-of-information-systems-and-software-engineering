package izvrsni.gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import admin.gui.glavniProzor.OdabirJezika;


public class PozivProzoraIzbora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		 OdabirJezika  oj = new OdabirJezika(true);		
		 oj.setVisible(true);
		
	}

}

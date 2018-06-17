package action.listeneri;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import admin.gui.glavniProzor.PocetniProzor;
import admin.gui.paneliZaIzmenu.PanelZaUnosProizvoda;
import admin.gui.parametar.UnosParametra;
import model.Parametar;
import model.Proizvod;
import model.Wizard;

public class PanZaIzmenuProizvodaAction extends AbstractAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4511912435772543076L;

	public PanZaIzmenuProizvodaAction(){
	putValue(NAME, PocetniProzor.getInstance().getResourceBundle().getString("dodatno.izmena"));
	putValue(SHORT_DESCRIPTION, PocetniProzor.getInstance().getResourceBundle().getString("dodatno.izmena"));

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		

		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) PocetniProzor
				.getInstance().getTree().getLastSelectedPathComponent();
		
		Object o = null;
		if (sel != null) {
			o = sel.getUserObject();
		}
		
		if (sel != null && !sel.isRoot()) {

			
			if(o instanceof Proizvod){
				PanelZaUnosProizvoda p=new PanelZaUnosProizvoda(true);
				String staroIme=((Proizvod) o).getIme();
				p.getTxtime().setText(staroIme);
				p.setVisible(true);
			}else if(o instanceof Wizard){
				JOptionPane.showMessageDialog(PocetniProzor.getInstance(), PocetniProzor.getInstance().getResourceBundle().getString("wizard"), PocetniProzor.IME_APLIKACIJE,
						JOptionPane.WARNING_MESSAGE);
			}else if(o instanceof Parametar){
				UnosParametra p = new UnosParametra(true);
				
				/*
				 *  kupi stare vrednosti iz cvora Parametar i smesta ih u Edit Parametar prozor
				 *  kako bi korisnik imao na uvid sta je pre upisao
				 * */
				String staroIme=((Parametar) o).getParameter_name();
				p.getTxtNP().setText(staroIme);
				
				String stariTipParametra=((Parametar) o).getData_type();
				p.setStariTipParametra(stariTipParametra);
				
				String tipParametra=((Parametar) o).getData_type();
				p.getBoxTP().setSelectedItem(tipParametra);
				
				Boolean isPromenljiv = ((Parametar) o).getChangeable();
				if(isPromenljiv){
					p.getPromenljiv().setSelected(true);
				}else
					p.getRead_only().setSelected(true);
				
				Boolean vidljiv = ((Parametar) o).getVidljiv();
				if(vidljiv)
					p.getVidljiv().setSelected(true);
				
				Boolean obavezan = ((Parametar) o).getObavezan();
				if(obavezan)
					p.getObavezan().setSelected(true);
				
				p.setVisible(true);

			}
			
		}else {
			//ali ako nije instance kategorija ti mu izbaci ovaj warning
			JOptionPane.showMessageDialog(PocetniProzor.getInstance(), PocetniProzor.getInstance().getResourceBundle().getString("proizvod.select"), PocetniProzor.IME_APLIKACIJE,
					JOptionPane.WARNING_MESSAGE);
		}

	
	}

}

package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import modelo.MwriteMsj;
import vista.VOpciones;
import vista.Vlogin;
import vista.VwriteMsj;
/**
 * 
 * @author palestina719
 *
 */
public class Copciones implements ActionListener,WindowListener {
	VOpciones vista=new VOpciones();
/**
 * 
 * @param vista Recibe la vista de las opciones
 */
	public Copciones(VOpciones vista) {
		super();
		this.vista = vista;
		vista.onClickVerMensajes(this);
		vista.onClickWriteMensaje(this);
		vista.eventoVentana(this);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		try {
			if(a.getSource()==vista.getBtnverMensaje()){
				JOptionPane.showMessageDialog(vista, "ver mensaje");
			}
			else if(a.getSource()==vista.getBtnWriteMsj()){
				VwriteMsj vista=new VwriteMsj();
				vista.setVisible(true);
				MwriteMsj modelo=new MwriteMsj();
				CwriteMsj control=new CwriteMsj(vista,modelo);
			}
		} catch (Exception e) {
			vista.MostrarError("Error");
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		Vlogin vista=new Vlogin();
		vista.setVisible(true);
		Clogin c=new Clogin(vista);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

package vista;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * 
 * @author palestina719
 *
 */
public class VOpciones extends JFrame {
	JButton btnverMensaje=new JButton("Ver Mensajes");
	JButton btnWriteMsj=new JButton("Escribir Mensaje");

/**
 * 
 * @return Retorna el nombre del boton
 */
	public JButton getBtnverMensaje() {
		return btnverMensaje;
	}
/**
 * 
 * @return Retorna el nombre del boton
 */
	public JButton getBtnWriteMsj() {
		return btnWriteMsj;
	}

	private Container c=getContentPane();
	
	public VOpciones(){
		super.setTitle("Opciones");
		super.setSize(320, 480);
		super.setResizable(false);
		cargarControles();
	}
	
	
	private void cargarControles() {
		c.setLayout(null);
		btnverMensaje.setBounds(20, 90, 280, 50);
		btnWriteMsj.setBounds(20, 160, 280, 50);
		
		c.add(btnverMensaje);
		c.add(btnWriteMsj);
		
		
	}
	public void onClickVerMensajes(ActionListener al){
		btnverMensaje.addActionListener(al);
		
	}
	public void onClickWriteMensaje(ActionListener al){
		btnWriteMsj.addActionListener(al);
		
	}
	public void MostrarError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
	public void eventoVentana(WindowListener wl) {
		this.addWindowListener(wl);
	}
	
}

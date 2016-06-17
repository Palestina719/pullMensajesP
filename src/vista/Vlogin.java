package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * 
 * @author palestina719
 *
 */
public class Vlogin extends JFrame {
	private JButton btnacceder=new JButton("Acceder");
	private JButton btnregistro=new JButton("Registrarse");
	private JLabel txtC=new JLabel("Correo:");
	private JLabel txtP=new JLabel("Contraseña:");
	
	private JTextField txtcorreo=new JTextField();
	private JTextField txtpass=new JTextField();
	
	private Container c=getContentPane();

	public Vlogin(){
		super.setTitle("Login");
		super.setSize(320, 480);
		super.setResizable(false);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
	private void cargarControles() {
		c.setLayout(null);
		txtC.setBounds(20, 20, 100, 20);
		txtcorreo.setBounds(20, 60, 280, 30);
		txtP.setBounds(20, 110, 100, 20);
		txtpass.setBounds(20, 140, 280, 30);
		btnacceder.setBounds(20, 200, 280, 50);
		btnregistro.setBounds(90, 270, 130, 20);
		c.add(txtC);
		c.add(txtcorreo);
		c.add(txtP);
		c.add(txtpass);
		c.add(btnacceder);
		c.add(btnregistro);
	}
/**
 * 
 * @return Retorna el nombre del boton
 */

	public JButton getBtnacceder() {
		return btnacceder;
	}
/**
 * 
 * @return Retorna el nombre del boton
 */

	public JButton getBtnregistro() {
		return btnregistro;
	}
/**
 * 
 * @return Retorna el contenido de la caja de texto
 */

	public JTextField getTxtcorreo() {
		return txtcorreo;
	}
/**
 * 
 * @return Retorna el contenido de la caja de texto
 */

	public JTextField getTxtpass() {
		return txtpass;
	}
/**
 * 	
 * @param al Evento que nos permite realizar una accion con el boton
 */
	public void onClickAcceder(ActionListener al){
		btnacceder.addActionListener(al);
		
	}
/**
 * 	
 * @param al Evento que nos permite realizar una accion con el boton
 */
	public void onClickRegistrar(ActionListener al){
		btnregistro.addActionListener(al);
		
	}
/**
 * 	
 * @param error Recibe una cadena String con un mensaje de error
 */
	public void MostrarError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
}

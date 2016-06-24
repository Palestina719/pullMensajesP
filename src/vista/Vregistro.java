package vista;

import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

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
public class Vregistro extends JFrame {
	private JButton btnguardar=new JButton("Guardar");
	private JTextField txtNombre=new JTextField();
	private JTextField txtPaterno=new JTextField();
	private JTextField txtMaterno=new JTextField();
	private JTextField txtUsuario=new JTextField();
	private JTextField txtpassword=new JTextField();
	private JLabel lblnombre=new JLabel("Nombre:");
	private JLabel lblpaterno=new JLabel("Paterno:");
	private JLabel lblmaterno=new JLabel("Materno:");
	private JLabel lblusuario=new JLabel("Usuario:");
	private JLabel lblpassword=new JLabel("Contraseña:");
	private Container c=getContentPane();
	
	public Vregistro(){
		super.setTitle("Registro de usuarios");
		super.setSize(320, 480);
		super.setResizable(false);
		super.setLocation(500, 120);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		cargarCOntroles();
	}

	private void cargarCOntroles() {
		c.setLayout(null);
		lblnombre.setBounds(20, 20, 80, 20);
		txtNombre.setBounds(20, 50, 280, 25);
		lblpaterno.setBounds(20, 90, 80, 20);
		txtPaterno.setBounds(20, 120, 280, 25);
		lblmaterno.setBounds(20, 160, 80, 20);
		txtMaterno.setBounds(20, 190, 280, 25);
		lblusuario.setBounds(20, 230, 80, 20);
		txtUsuario.setBounds(20, 260, 280, 25);
		lblpassword.setBounds(20, 290, 280, 20);
		txtpassword.setBounds(20, 320, 280, 25);
		btnguardar.setBounds(20, 360, 280, 50);
		
		c.add(lblnombre);
		c.add(txtNombre);
		c.add(lblpaterno);
		c.add(txtPaterno);
		c.add(lblmaterno);
		c.add(txtMaterno);
		c.add(lblusuario);
		c.add(txtUsuario);
		c.add(lblpassword);
		c.add(txtpassword);
		c.add(btnguardar);
	}
	public void eventoVentana(WindowListener wl) {
		this.addWindowListener(wl);
	}
	public void onClickGuardar(ActionListener al){
		btnguardar.addActionListener(al);
	}

	public JButton getBtnguardar() {
		return btnguardar;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtPaterno() {
		return txtPaterno;
	}

	public JTextField getTxtMaterno() {
		return txtMaterno;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JTextField getTxtpassword() {
		return txtpassword;
	}
	public void MostrarError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
}

package vista;

import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VwriteMsj extends JFrame {
	private JButton btnEnviar=new JButton("Enviar");
	private JScrollPane pane=new JScrollPane();
	private JTextArea area=new JTextArea();
	private Container c=getContentPane();
	
	public VwriteMsj(){
		super.setTitle("Escribir Mensajes");
		super.setSize(320, 480);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setResizable(false);
		cargarControles();
	}

	private void cargarControles() {
		c.setLayout(null);
		pane.setBounds(20, 20, 280, 100);
		area.setBounds(20, 140, 280, 50);
		btnEnviar.setBounds(20, 210, 280, 40);
		
		c.add(pane);
		c.add(area);
		c.add(btnEnviar);
		
	}

	public JScrollPane getPane() {
		return pane;
	}

	public void setMensaje(String s) {
		
	}

	public JTextArea getArea() {
		return area;
	}

	public void setArea(JTextArea area) {
		this.area = area;
	}

	public JButton getBtnEnviar() {
		return btnEnviar;
	}
	public void onCLickEnviar(ActionListener al){
		btnEnviar.addActionListener(al);
	}
	public void MostrarError(String error){
		JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
	}
}

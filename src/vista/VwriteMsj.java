package vista;

import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
/**
 * 
 * @author palestina719
 *
 */
public class VwriteMsj extends JFrame {
	private JButton btnEnviar=new JButton("Enviar");
	private JScrollPane pane=new JScrollPane();
	private JTextArea mensajes=new JTextArea();
	public JTable tabla=new JTable(); 
	
	public JTable getTabla() {
		return tabla;
	}

	public void setTabla(JTable tabla) {
		this.tabla = tabla;
		tabla.addColumn(null);
	}

	public JTextArea getMensajes() {
		return mensajes;
	}

	public void setMensajes(String m) {
		mensajes.setText(m);
	}
	private JTextArea area=new JTextArea();
	private Container c=getContentPane();
	
	public VwriteMsj(){
		super.setTitle("Escribir Mensajes");
		super.setSize(480, 320);
		super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		super.setResizable(false);
		super.setLocation(480, 120);
		cargarControles();
	}

	private void cargarControles() {
		c.setLayout(null);
		pane.setBounds(20, 20, 430, 100);
		area.setBounds(20, 140, 430, 50);
		btnEnviar.setBounds(20, 210, 430, 40);
		tabla.setBounds(20, 20, 430, 100);
		pane.setViewportView(tabla);
		tabla.setModel(new DefaultTableModel(new Object[][] {},new String[] {
				"Mensaje", "Usuario", "Fecha y Hora"}
		));
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

	public void setArea(String a) {
		area.setText(null);
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
	
	public void eventoVentana(WindowListener wl) {
		this.addWindowListener(wl);
	}
}

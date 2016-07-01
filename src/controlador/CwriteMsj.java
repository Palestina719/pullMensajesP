package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.MaddUser;
import modelo.MwriteMsj;
import modelo.UserSingleton;
import vista.Vlogin;
import vista.VwriteMsj;
/**
 * 
 * @author palestina719
 *
 */
public class CwriteMsj implements ActionListener,WindowListener{
	VwriteMsj vista=new VwriteMsj();
	MwriteMsj modelo=new MwriteMsj();
/**
 * 	
 * @param vista Recibe la vista de escriir mensaje
 * @param modelo Recibe el modelo de escribir mensaje
 */
	public CwriteMsj(VwriteMsj vista, MwriteMsj modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		vista.onCLickEnviar(this);
		vista.eventoVentana(this);
	}
	@Override
	
public void actionPerformed(ActionEvent w) {
		try {
			if(w.getSource()==vista.getBtnEnviar()){
				String s=vista.getArea().getText();
				if(modelo.guardarMsj(s)==true){
					//JOptionPane.showMessageDialog(vista, "Mensaje enviado");
					vista.setArea(null);
					vista.setMensajes(s);
					
					
					//tabla
					Date date=new Date();
					DateFormat datetime=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
					String FH=datetime.format(date);
					
					UserSingleton user=UserSingleton.instancia();
					MaddUser getuser=new MaddUser();
					
					String usuario="";
					for (int i = 0; i < user.getUsuario().size(); i++) {
						getuser=user.getUsuario().get(i);
						usuario=getuser.getUsuario();
					}
					DefaultTableModel miTabla=(DefaultTableModel) vista.tabla.getModel();
					int fila=miTabla.getRowCount();
					miTabla.addRow(new Object[1]);
					miTabla.setValueAt(s,fila,0);
					miTabla.setValueAt(usuario,fila,1);
					miTabla.setValueAt(FH,fila,2);
					//vista.getPane().setViewportView(vista.tabla);
					//vista.setTabla(null);
				}else{
					vista.MostrarError("Error");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
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
		//VOpciones vista2=new VOpciones();
		//vista2.setVisible(true);
		//Copciones c=new Copciones(vista2);
		
		Vlogin vista=new Vlogin();
		vista.setVisible(true);
		Clogin c=new Clogin(vista);
		
		UserSingleton user=UserSingleton.instancia();
		
		user.borrar(null);
		
		
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

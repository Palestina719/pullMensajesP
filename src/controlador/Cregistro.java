package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

import modelo.Mregistrar;
import vista.Vlogin;
import vista.Vregistro;
/**
 * 
 * @author palestina719
 *
 */
public class Cregistro implements ActionListener, WindowListener {
	private Vregistro vista=new Vregistro();
	private Mregistrar modelo=new Mregistrar();
/**
 * 	
 * @param vista Recibe la vista del formulario de registro
 * @param modelo Recibe el modelo donde se hara la insercion
 */
	public Cregistro(Vregistro vista, Mregistrar modelo) {
		this.vista = vista;
		vista.eventoVentana(this);
		vista.onClickGuardar(this);
	}

	@Override
	public void actionPerformed(ActionEvent q) {
		try {
			if(q.getSource()==vista.getBtnguardar()){
				String nombre=String.valueOf(vista.getTxtNombre().getText());
				String paterno=String.valueOf(vista.getTxtPaterno().getText());
				String materno=String.valueOf(vista.getTxtMaterno().getText());;
				String usuario=String.valueOf(vista.getTxtUsuario().getText());;
				String pass=String.valueOf(vista.getTxtpassword().getText());;
				if(nombre.length()==0 || paterno.length()==0 || materno.length()==0 || usuario.length()==0 || pass.length()==0){
					vista.MostrarError("Completar todos los campos");
				}else{
					if(modelo.registro(nombre,paterno,materno,usuario,pass)==true){
						JOptionPane.showMessageDialog(vista, "Registro exitoso!");
						vista.setVisible(false);
						Vlogin b=new Vlogin();
						b.setVisible(true);
						Clogin cl=new Clogin(b);
					}else{
						JOptionPane.showMessageDialog(vista, "Nombre de usuario no disponible");
					}
				}
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
		Clogin controlador=new Clogin(vista);
		
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

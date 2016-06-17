package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Mregistrar;
import conexion.Gestion;
import vista.VOpciones;
import vista.Vlogin;
import vista.Vregistro;
/**
 * 
 * @author palestina719
 *
 */
public class Clogin implements ActionListener {
	Vlogin vista=new Vlogin();
/**
 * 
 * @param vista Recibe la vista del login
 */
	public Clogin(Vlogin vista) {
		this.vista = vista;
		vista.onClickAcceder(this);
		vista.onClickRegistrar(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent q) {
		Gestion objGestion=new Gestion();
		try {
			if(q.getSource()==vista.getBtnacceder()){
				String correo=String.valueOf(vista.getTxtcorreo().getText());
				String pass=String.valueOf(vista.getTxtpass().getText());
				if(correo.length()==0 || pass.length()==0){
					vista.MostrarError("Ingrese usuario y contraseña");
				}else{
					String user=null;
					String cont=null;
					String Consulta="Select usuario,password from usuarios where usuario='"+correo+"';";	
					ResultSet cdr=objGestion.ejecutarConsulta(Consulta);
					try {
						while(cdr.next()){
							user=cdr.getString(1);
							cont=cdr.getString(2);
						}
						if(pass.equals(cont) && correo.equals(user)){
							vista.setVisible(false);
							VOpciones Vo=new VOpciones();
							Vo.setVisible(true);
							Copciones contr=new Copciones(Vo);
						}else{
							JOptionPane.showMessageDialog(vista, "Usuario o contraseña invalido");
						}
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "ocurrio un error\n"+e,"Error", JOptionPane.ERROR_MESSAGE);
					}     
				}
			}else if(q.getSource()==vista.getBtnregistro()){
				vista.setVisible(false);
				
				Mregistrar mod=new Mregistrar();
				Vregistro vista1=new Vregistro();
				vista1.setVisible(true);
				Cregistro x=new Cregistro(vista1,mod);
			}
		} catch (Exception e) {
			vista.MostrarError("error");
		}
	}
}

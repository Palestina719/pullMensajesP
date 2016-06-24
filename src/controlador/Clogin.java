package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import modelo.MaddUser;
import modelo.Mregistrar;
import modelo.MwriteMsj;
import modelo.UserSingleton;
import conexion.Gestion;
import vista.Vlogin;
import vista.Vregistro;
import vista.VwriteMsj;
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
/**
 * Evento que nos permite generar una accion	
 */
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
							
							
							VwriteMsj vista1=new VwriteMsj();
							vista1.setVisible(true);
							MwriteMsj modelo=new MwriteMsj();
							CwriteMsj control=new CwriteMsj(vista1,modelo);
							vista.setVisible(false);
							
							String sentencia="Select mensaje,usuario,fecha from mensajes;";
							Gestion obj=new Gestion();
							//obj.ejecutarConsulta(sentencia);
							ResultSet cdr1=obj.ejecutarConsulta(sentencia);
							
							DefaultTableModel miTabla=(DefaultTableModel) vista1.tabla.getModel();
							
							while(cdr1.next()){
								int fila=miTabla.getRowCount();
								miTabla.addRow(new Object[1]);
								miTabla.setValueAt(cdr1.getString("mensaje"),fila,0);
								miTabla.setValueAt(cdr1.getString("usuario"),fila,1);
								miTabla.setValueAt(cdr1.getString("fecha"),fila,2);
							}
							
							
							
							//VOpciones Vo=new VOpciones();
							//Vo.setVisible(true);
							//Copciones contr=new Copciones(Vo);
							
							//envio de usuario a singleton
							MaddUser x=new MaddUser();
							x.setUsuario(correo);
							UserSingleton adp=UserSingleton.instancia();
							adp.agregar(x);
							
							
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

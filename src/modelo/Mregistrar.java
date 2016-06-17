package modelo;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import vista.Vregistro;
import conexion.Gestion;
/**
 * 
 * @author palestina719
 *
 */
public class Mregistrar {
/**
 * 	
 * @param nombre Recibe un dato de tipo String
 * @param paterno Recibe un dato de tipo String
 * @param materno Recibe un dato de tipo String
 * @param usuario Recibe un dato de tipo String
 * @param pass Recibe un dato de tipo String
 * @return Retorna un boolean para saber si se inserto o no
 */
	public boolean registro(String nombre, String paterno, String materno, String usuario, String pass){
		
		Gestion objGestion=new Gestion();
		
		String sentenciaSQL="INSERT INTO usuarios(nombre,paterno,materno,usuario,password) VALUES"+ 
				"('"+ nombre +"','"+ paterno +"','"+ materno +"','"+usuario+"','"+pass+"')";
			Vregistro c=new Vregistro();
			if(objGestion.ejecutarSentencia(sentenciaSQL)!=false){
				//JOptionPane.showMessageDialog(c, "Registro exitoso!");
			return true;
			}else{
				//JOptionPane.showMessageDialog(c, "Nombre de Usuario no disponible");
			return false;	
			}
	}
}

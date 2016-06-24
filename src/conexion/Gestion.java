package conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import vista.Vregistro;
/**
 * 
 * @author palestina719
 *
 */
public class Gestion {
	Statement sentencia;
	Connection cadenaConexion;
	ResultSet cdr;
	
	Conexion objConexion=new Conexion();
	
	public Gestion(){
		cadenaConexion=objConexion.conectandoBD();
	}
/**
 * 	
 * @param sentenciaSQL Recibe la sentencia que se quiere ejecutar en la base de datos
 * @return Retorna el resultado de la sentencia
 */
	public boolean ejecutarSentencia(String sentenciaSQL){
		
		try {
			sentencia=cadenaConexion.createStatement();
			sentencia.execute(sentenciaSQL);
			return true;
		} catch (SQLException e) {
			//JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible");
			//JOptionPane.showMessageDialog(null, "Ocurrio el error \n"+e, "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	}
/**
 * 
 * @param sentenciaSQL Recibe la consulta que se quiere realizar en la base de datos
 * @return Retorna el valor de la consulta
 */
	public ResultSet ejecutarConsulta(String sentenciaSQL) {
		ResultSet cdr=null;
		try {
			sentencia=cadenaConexion.createStatement();
		cdr=sentencia.executeQuery(sentenciaSQL);
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Ocurrio el error \n"+e, "Error", JOptionPane.ERROR_MESSAGE);
			
		}
	
		return cdr;
	}
}
	




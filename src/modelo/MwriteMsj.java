package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import conexion.Gestion;
/**
 * 
 * @author palestina719
 *
 */
public class MwriteMsj {
/**
 * 	
 * @param s Recibe el mensaje a guardar
 * @return Retorna true o false si se inserto correctamente o no
 */
	public boolean guardarMsj(String s){
		String fecha="hola";
		Gestion obj=new Gestion();
		
		Date date=new Date();
		DateFormat datetime=new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		
		String FH=datetime.format(date);
		
		//llamar singleton de usuario
		
		
		UserSingleton user=UserSingleton.instancia();
		MaddUser getuser=new MaddUser();
		
		String usuario="";
		for (int i = 0; i < user.getUsuario().size(); i++) {
			getuser=user.getUsuario().get(i);
			usuario=getuser.getUsuario();
		}
		
		//JOptionPane.showMessageDialog(null, usuario);
		
		String sentenciaSQL="INSERT INTO mensajes(mensaje,usuario,fecha) VALUES"+ 
			"('"+ s +"','"+ usuario +"','"+ FH+"')";
		
		if(obj.ejecutarSentencia(sentenciaSQL)!=false){
			
			return true;
		}
		else{
			return false;
		}
				
	}
}

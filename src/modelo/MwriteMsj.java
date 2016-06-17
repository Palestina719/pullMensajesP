package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import conexion.Gestion;

public class MwriteMsj {
	public boolean guardarMsj(String s){
		String fecha="hola";
		Gestion obj=new Gestion();
		
		Date date=new Date();
		DateFormat hora=new SimpleDateFormat("HH:mm:ss");
		//System.out.println("hora:"+hora.format(date));
		
		
		DateFormat datetime=new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		//System.out.println("HOra y fecha:"+datetime.format(date));
		String FH=datetime.format(date);
		
		String sentenciaSQL="INSERT INTO mensajes(mensaje,fecha) VALUES"+ 
			"('"+ s +"','"+ FH+"')";
		
		if(obj.ejecutarSentencia(sentenciaSQL)!=false){
			
			return true;
		}
		else{
			return false;
		}
				
	}
}

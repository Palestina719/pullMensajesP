package app;



import conexion.Conexion;
import controlador.Clogin;
import vista.Vlogin;

/**
 * 
 * @author palestina719
 *
 */
public class app {
/**
 * 
 * @param args
 */
	public static void main(String[] args) {
		Vlogin vista=new Vlogin();
		vista.setVisible(true);
		Clogin controlador=new Clogin(vista);
		
		

	}

}

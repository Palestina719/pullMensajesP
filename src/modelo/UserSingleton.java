package modelo;

import java.util.ArrayList;
/**
 * 
 * @author palestina719
 *
 */
public final class UserSingleton {
	private ArrayList<MaddUser> Usuario =new ArrayList<MaddUser>();
	
/**
 * 	
 * @return Retorna el usuario
 */
	public ArrayList<MaddUser> getUsuario() {
		return Usuario;
	}
/**
 * 	
 * @param usuario Recibe el nombre del usuario
 */
	public void setUsuario(ArrayList<MaddUser> usuario) {
		Usuario = usuario;
	}
	private static final UserSingleton adp=new UserSingleton();

	private UserSingleton(){
		
	}
/**
 * 
 * @return Retorna la instancia
 */
	public static UserSingleton instancia(){
		
		return adp;
	}
/**
 * 	
 * @param e Agregamos el usuario
 */
	public void agregar(MaddUser e) {
		Usuario.add(e);
	}
/**
 * 	
 * @param a Limpiamos el arreglo
 */
	public void borrar(MaddUser a){
		Usuario.clear();
	}
}

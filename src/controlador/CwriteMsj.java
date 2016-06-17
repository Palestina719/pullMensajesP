package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.MwriteMsj;
import vista.VwriteMsj;

public class CwriteMsj implements ActionListener {
	VwriteMsj vista=new VwriteMsj();
	MwriteMsj modelo=new MwriteMsj();
	public CwriteMsj(VwriteMsj vista, MwriteMsj modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		vista.onCLickEnviar(this);
	}
	@Override
	public void actionPerformed(ActionEvent w) {
		try {
			if(w.getSource()==vista.getBtnEnviar()){
				String s=vista.getArea().getText();
				if(modelo.guardarMsj(s)==true){
					JOptionPane.showMessageDialog(vista, "Mensaje enviado");
				}else{
					vista.MostrarError("Error");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

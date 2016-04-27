package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

public class ControladorloginAreaDeBodega implements Initializable{
	public Main main;
	@FXML private RadioButton rbtSupervisor;
	@FXML private RadioButton rbtBodeguero;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	@FXML public void seccionInventario() {
		if (rbtSupervisor.isSelected()) {
			irformularioPrincipal();
		}
		if (rbtBodeguero.isSelected()) {

			irformularioPrincipal();
		}
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}

	public void irformularioPrincipal() {
		main.irInventario2();

	}
	
	@FXML
	public void volverMenuPrincipal3() {
		main.volverMenu3();
	}
	
	

}

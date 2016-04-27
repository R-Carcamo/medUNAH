package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class ControladorPrincipal implements Initializable{
	private Main main;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	@FXML public void agregarNuevoMedicamento(){
		main.agregarMedicamento();
	}
	
	@FXML public void atras(){
		main.volverMenu6();
	}
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}

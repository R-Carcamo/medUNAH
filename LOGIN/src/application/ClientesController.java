package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ClientesController implements Initializable {
	private Main main;
	@FXML Button btnseleccionar;
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	@FXML public void cambiarFormularioFactura(){

	}
}

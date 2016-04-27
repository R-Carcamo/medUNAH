package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControladorEfectivo implements Initializable {
	private Main main;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	@FXML
	public void aceptar(){
		main.cerrarPagoEfec();
	}


	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;

	}


}

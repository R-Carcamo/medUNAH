package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControladorloginVendedores implements Initializable {

	public Main main;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	@FXML
	public void volverMenuPrincipal2() {
		main.volverMenu2();
	}
	@FXML
	public void mostrarFactura(){
		main.mostrarFactura();
	}
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}



}

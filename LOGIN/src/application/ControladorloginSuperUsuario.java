package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

public class ControladorloginSuperUsuario implements Initializable {
	private Main main;
	@FXML private RadioButton rbtAreaVentas;
	@FXML private RadioButton rbtAreaInventario;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	/*
	 * public int ingresarAreaVentas(int a){ int a1=0; if
	 * (rbtAreaVentas.isSelected()) { a1=1; } return a1;
	 * 
	 * }
	 */
	@FXML public void seleccionArea() {
		if (rbtAreaInventario.isSelected()) {
			irLoginSuperUsuarioAreaInventario();
		}
		if (rbtAreaVentas.isSelected()) {

			irLoginSuperUsuarioAreaVentas();
		}
	}

	public void irLoginSuperUsuarioAreaInventario() {

		main.mostrarSuperUsuarioAreaInventario();

	}

	public void irLoginSuperUsuarioAreaVentas() {

		main.mostrarSuperUsuarioAreaVentas();

	}

	@FXML
	public void volverMenuPrincipal1() {
		main.volverMenu1();

	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;

	}

}

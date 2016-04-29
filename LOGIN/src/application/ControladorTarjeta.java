package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;

public class ControladorTarjeta implements Initializable{
	public Main main;
	private ObservableList<String> emisor;
	@FXML private ComboBox<String> cboEmisor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		llenarComboBox();
	}
	@FXML
	public void aceptar(){
		try {
			Alert alert = new Alert(AlertType.INFORMATION);
	        alert.setTitle("Notificacion");
	        alert.setContentText("El Pago se ha realizado con exito");
	        alert.showAndWait();
	        main.cerrarPagoTar();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Notificacion");
	        alert.setContentText("El Pago no se ha realizado con exito");
	        alert.showAndWait();
		}
	}

	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;

	}
	public void llenarComboBox(){
		emisor = FXCollections.observableArrayList();
		cboEmisor.setItems(emisor);
		emisor.add("Visa");
		emisor.add("MasterCard");
}
}

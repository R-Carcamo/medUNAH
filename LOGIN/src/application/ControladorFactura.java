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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import modelo.Detalle;

public class ControladorFactura implements Initializable {
	private Main main;
	private ObservableList<String> formaPago;
	@FXML private ComboBox<String> cboFormaPago;

	@FXML private TextField txtNumIdentidad;
	@FXML private TextField txtNombre;
	@FXML private TableView<Detalle> tlvDetalle;
	@FXML private TextField txtTot;
	@FXML private TextField txtIsv;
	@FXML private TextField txtTotPagar;
	@FXML private DatePicker dtpFecha;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		llenarComboBox();


	}
	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;

	}
	@FXML
	public void cobrar(){
		if(cboFormaPago.getSelectionModel().getSelectedItem() != null){
			if(cboFormaPago.getSelectionModel().getSelectedItem().equals("Efectivo")){
				main.mostrarEfectivo();
				}
			if(cboFormaPago.getSelectionModel().getSelectedItem().equals("Tarjeta")){
				main.mostrarTarjeta();
			}
		}
		else{
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Error");
	        alert.setContentText("Seleccione una forma de Pago");
	        alert.showAndWait();
		}


	}
	public void llenarComboBox(){
			formaPago = FXCollections.observableArrayList();
			cboFormaPago.setItems(formaPago);
			formaPago.add("Efectivo");
			formaPago.add("Tarjeta");
	}

	public void nueva(){
		cboFormaPago.setValue(null);
		txtNumIdentidad.setText(null);
		txtNombre.setText(null);
		//tlvDetalle;
		txtTot.setText(null);
		txtIsv.setText(null);
		txtTotPagar.setText(null);
		dtpFecha.setValue(null);
	}
	@FXML
	public void mostrarClientes(){
		main.agregarCliente();
	}
}

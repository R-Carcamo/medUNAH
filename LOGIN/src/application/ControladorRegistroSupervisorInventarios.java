package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ComboBox;

import javafx.scene.control.DatePicker;

import javafx.scene.control.TableView;

public class ControladorRegistroSupervisorInventarios implements Initializable {
	private Main main;

	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtApellido;
	@FXML
	private TextField txtDireccion;
	@FXML
	private TextField txtCorreo;
	@FXML
	private TextField txtNumTel;
	@FXML
	private TextField txtIdentidad;
	@FXML
	private TextField txtUser;
	@FXML
	private TextField txtPass;
	@FXML
	private DatePicker dtpFechaNac;
	@FXML
	private ComboBox cboEstadoCivil;
	@FXML
	private Button btnGuardar;
	@FXML
	private Button btnActualizar;
	@FXML
	private Button btnEliminar;
	@FXML
	private Button btnNuevo;
	@FXML
	private TableView tlvInfo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}

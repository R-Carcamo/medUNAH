package application;

import java.net.URL;
import java.sql.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Vendedor;
import utilidades.GestorConexiones;

public class ControladorVendedor implements Initializable {
	private Main main;
	@FXML Button btnatras;
	@FXML private Button btnGuardar;
	@FXML private Button btnActualizar;
	@FXML private Button btnNuevo;
	@FXML private Button btnEliminar;
	@FXML private Button btnBuscar;
	@FXML private TextField txtBuscar;
	@FXML private TextField txtNombre;
	@FXML private TextField txtApellido;
	@FXML private TextField txtIdentidad;
	@FXML private TextField txtTelefono;
	@FXML private TextField txtdireccion;
	@FXML private TextField txtEstado;
	@FXML private TextField txtCorreoElectronico;
	@FXML private RadioButton rbtnMasculino;
	@FXML private RadioButton rbtnFemenino;
	@FXML private TableView<Vendedor> tblVendedores;
	@FXML private DatePicker dtpkrFechaNacimiento;
	@FXML private DatePicker dtpkrFechaIngreso;
	@FXML private ComboBox<String> cboEstadoCivil;
	private ObservableList<String> estadosCiviles;
	private GestorConexiones conexion;
	private ObservableList<Vendedor> vendedores;

	@FXML private TableColumn<Vendedor,String> clmnNombre;
	@FXML private TableColumn<Vendedor,String> clmnApellido;
	@FXML private TableColumn<Vendedor,String> clmnIdentidad;
	@FXML private TableColumn<Vendedor,String> clmnTelefono;
	@FXML private TableColumn<Vendedor,String> clmndireccion;
	@FXML private TableColumn<Vendedor,String> clmnCorreoElectronico;
	@FXML private TableColumn<Vendedor,String> clmnGenero;
	@FXML private TableColumn<Vendedor,Date> clmnFechaNacimiento;
	@FXML private TableColumn<Vendedor,Date> clmnFechaIngreso;
	@FXML private TableColumn<Vendedor,String> clmnEstadoCivil;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion=new GestorConexiones();
		conexion.establecerConexion();
		vendedores=FXCollections.observableArrayList();
		tblVendedores.setItems(vendedores);
		estadosCiviles=FXCollections.observableArrayList();
		cboEstadoCivil.setItems(estadosCiviles);
		Vendedor.llenarTablero(conexion.getConexion(), vendedores);
		llenarTablero();
		conexion.establecerConexion();
	}
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	@FXML public void salirVendedores(){
		main.salirRegistroVentas();
	}
	public void llenarTablero(){
		clmnNombre.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("nombre"));
		clmnApellido.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("apellido"));
		clmnIdentidad.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("numeroIdentidadVendedor"));
		clmnTelefono.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("telefono"));
		clmndireccion.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("direccion"));
		clmnCorreoElectronico.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("correo"));
		clmnGenero.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("genero"));
		clmnFechaNacimiento.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,Date>("fechaNacimiento"));
		clmnFechaIngreso.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,Date>("fechaIngreso"));
		clmnEstadoCivil.setCellValueFactory(
				 new PropertyValueFactory<Vendedor,String>("estadoCivil"));
		tblVendedores.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Vendedor>() {
					@Override
					public void changed(
							ObservableValue<? extends Vendedor> arg0,
							Vendedor valorAnterior,
							Vendedor valorNuevo) {
						if(valorNuevo!=null){
							llenarComponentes(valorNuevo);
						}
					}
				}
		);
		estadosCiviles.add("Soltero");
		estadosCiviles.add("Casado");
		estadosCiviles.add("Viudo");
		estadosCiviles.add("Union Libre");

	}
	public void llenarComponentes(Vendedor c){
		txtNombre.setText(c.getNombre());
		txtApellido.setText(c.getApellido());
		txtTelefono.setText(c.getTelefono());
		txtdireccion.setText(c.getDireccion());
		txtCorreoElectronico.setText(c.getCorreo());
		txtIdentidad.setText(c.getNumeroIdentidadVendedor());
		dtpkrFechaNacimiento.setValue(c.getFechaNacimiento().toLocalDate());
		dtpkrFechaIngreso.setValue(c.getFechaIngreso().toLocalDate());
		cboEstadoCivil.getSelectionModel().select(c.getEstadoCivil());
		btnGuardar.setDisable(true);
		btnEliminar.setDisable(false);
		btnActualizar.setDisable(false);

		if (c.getGenero().equals("F")){
			rbtnFemenino.setSelected(true);
		}else{
			rbtnMasculino.setSelected(true);
		}
	}
	public String validarCampos(){
		String errores = "";
		if (txtNombre.getText().equals(""))
			errores += "Debe ingresar el nombre del Vendedor\n";
		if (cboEstadoCivil.getSelectionModel().getSelectedItem()==null)
			errores += "Debe seleccionar un Estado Civil\n";
		if (txtApellido.getText().equals(""))
			errores += "Debe ingresar el apellido del Vendedor\n";
		if (txtTelefono.getText().equals(""))
			errores += "Debe ingresar un numero telefonico\n";
		if (txtdireccion.getText().equals(""))
			errores += "Debe ingresar la direccion\n";
		if (txtIdentidad.getText().equals(""))
			errores += "Debe ingresar la identidad\n";
		if (dtpkrFechaNacimiento.getValue()==null)
			errores += "Debe seleccionar una fecha de nacimiento\n";
		if (dtpkrFechaIngreso.getValue()==null)
			errores += "Debe seleccionar una fecha de Ingreso\n";
		if (txtCorreoElectronico.getText().equals(""))
			errores += "Debe ingresar un correo electronico\n";
		if ((rbtnMasculino.isSelected()==false) && (rbtnFemenino.isSelected()==false)){
			errores +="Debe Seleccionar un genero";
		}
		Pattern pattern = Pattern.compile("[0-9]{4}-[0-9]{4}-[0-9]{5}");
		Matcher matcher = pattern.matcher(txtIdentidad.getText());
		if (!matcher.matches())
			errores += "Su identidad no coincide con el patron de la identidad\n";
		return errores;
	}
	@FXML public void guardarVendedor(){
		String errores = validarCampos();
		if (!errores.equals("")){
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error al guardar");
			mensaje.setHeaderText("Se encontraron los siguientes errrores");
			mensaje.setContentText(errores);
			mensaje.show();
			return;
		}
		Vendedor vendedor=new Vendedor(0, txtNombre.getText(), txtApellido.getText(),
				rbtnMasculino.isSelected()?"M":"F", Date.valueOf(dtpkrFechaNacimiento.getValue()),
				Date.valueOf(dtpkrFechaIngreso.getValue()), txtIdentidad.getText(),
				cboEstadoCivil.getSelectionModel().getSelectedItem(),
				txtdireccion.getText(),txtTelefono.getText(),txtCorreoElectronico.getText());
		conexion.establecerConexion();
		int resultado=vendedor.guardarVendedor(conexion.getConexion());
		conexion.cerrarConexion();
		if (resultado==1){
			vendedores.add(vendedor);
		}
	}

	@FXML public void actualizarVendedor(){
		String errores = validarCampos();
		if (!errores.equals("")){
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error al actualizar el Registro");
			mensaje.setHeaderText("Se encontraron los siguientes errrores");
			mensaje.setContentText(errores);
			mensaje.show();
			return;
		}
		Vendedor c=tblVendedores.getSelectionModel().getSelectedItem();
		c.setNombre(txtNombre.getText());
		c.setNumeroIdentidadVendedor(txtIdentidad.getText());
		c.setTelefono(txtTelefono.getText());
		c.setCorreo(txtCorreoElectronico.getText());
		c.setGenero(rbtnMasculino.isSelected()?"M":"F");
		c.setFechaNacimiento(Date.valueOf(dtpkrFechaNacimiento.getValue()));
		c.setDireccion(txtdireccion.getText());
		c.setFechaIngreso(Date.valueOf(dtpkrFechaIngreso.getValue()));
		c.setEstadoCivil(cboEstadoCivil.getSelectionModel().getSelectedItem());
		c.setApellido(txtApellido.getText());
		conexion.establecerConexion();
		int resultado=c.actualizarVendedor(conexion.getConexion());
		conexion.cerrarConexion();
		if (resultado==1){
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setContentText("Registro con codigo " + c.getCodigoVendedor()+ " ha sido actualizado con exito.");
			mensaje.show();
			vendedores.set(tblVendedores.getSelectionModel().getSelectedIndex(), c);
		}
	}

	@FXML public void EliminarVendedor(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar registro");
		alert.setHeaderText("Eliminar registro");
		alert.setContentText("�Esta seguro de que desea eliminar este registro?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Vendedor a = tblVendedores.getSelectionModel().getSelectedItem();
			conexion.establecerConexion();
			int resultado = a.eliminarVendedor(conexion.getConexion());
			conexion.cerrarConexion();
			if (resultado == 1){
				vendedores.remove(a);
			}
			btnGuardar.setDisable(false);
			btnEliminar.setDisable(true);
			btnActualizar.setDisable(true);
		}
	}
	@FXML public void nuevoVendedor(){
		txtNombre.setText(null);
		txtApellido.setText(null);
		txtIdentidad.setText(null);
		txtdireccion.setText(null);
		txtTelefono.setText(null);
		txtCorreoElectronico.setText(null);
		cboEstadoCivil.getSelectionModel().clearSelection();
		dtpkrFechaNacimiento.setValue(null);
		dtpkrFechaIngreso.setValue(null);
		rbtnMasculino.setSelected(false);
		rbtnFemenino.setSelected(false);
		btnGuardar.setDisable(false);
		btnEliminar.setDisable(true);
		btnActualizar.setDisable(true);
	}
	@FXML public void BusquedaVendedor(){
		vendedores.clear();
		conexion.establecerConexion();
		Vendedor.BusquedaVendedor(conexion.getConexion(), vendedores, txtBuscar.getText());
		conexion.cerrarConexion();
	}
}

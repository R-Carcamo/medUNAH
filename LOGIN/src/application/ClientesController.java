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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import utilidades.GestorConexiones;

public class ClientesController implements Initializable {
	private Main main;
	@FXML private Button btnseleccionar;
	@FXML private Button btnBuscar;
	@FXML private TextField txtBuscar;
	@FXML private Button btnGuardar;
	@FXML private Button btnActualizar;
	@FXML private Button btnNuevo;
	@FXML private Button btnEliminar;
	@FXML private TextField txtNombre;
	@FXML private TextField txtIdentidad;
	@FXML private TextField txtTelefono;
	@FXML private TextField txtdireccion;
	@FXML private TextField txtCorreoElectronico;
	@FXML private RadioButton rbtnMasculino;
	@FXML private RadioButton rbtnFemenino;
	@FXML private TableView<Cliente> tblClientes;
	@FXML private DatePicker dtpkrFechaNacimiento;
	private GestorConexiones conexion;
	private ObservableList<Cliente> clientes;

	@FXML private TableColumn<Cliente,String> clmnNombre;
	@FXML private TableColumn<Cliente,String> clmnIdentidad;
	@FXML private TableColumn<Cliente,String> clmnTelefono;
	@FXML private TableColumn<Cliente,String> clmndireccion;
	@FXML private TableColumn<Cliente,String> clmnCorreoElectronico;
	@FXML private TableColumn<Cliente,String> clmnGenero;
	@FXML private TableColumn<Cliente,Date> clmnFechaNacimiento;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion=new GestorConexiones();
		conexion.establecerConexion();
		clientes=FXCollections.observableArrayList();
		tblClientes.setItems(clientes);
		Cliente.llenarTablero(conexion.getConexion(), clientes);
		llenarTablero();
		conexion.cerrarConexion();
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	@FXML public void cambiarFormularioFactura(){

	}
	public void llenarTablero(){
		clmnNombre.setCellValueFactory(
				 new PropertyValueFactory<Cliente,String>("NombreCliente"));
		clmnIdentidad.setCellValueFactory(
				 new PropertyValueFactory<Cliente,String>("identidadCliente"));
		clmnTelefono.setCellValueFactory(
				 new PropertyValueFactory<Cliente,String>("telefono"));
		clmndireccion.setCellValueFactory(
				 new PropertyValueFactory<Cliente,String>("direccion"));
		clmnCorreoElectronico.setCellValueFactory(
				 new PropertyValueFactory<Cliente,String>("correoElectronico"));
		clmnGenero.setCellValueFactory(
				 new PropertyValueFactory<Cliente,String>("sexo"));
		clmnFechaNacimiento.setCellValueFactory(
				 new PropertyValueFactory<Cliente,Date>("fechaNacimiento"));
		tblClientes.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Cliente>() {
					@Override
					public void changed(
							ObservableValue<? extends Cliente> arg0,
							Cliente valorAnterior,
							Cliente valorNuevo) {
						if(valorNuevo!=null){
							llenarComponentes(valorNuevo);
						}
					}
				}
		);
	}

	@FXML public void guardarCliente(){
		String errores = validarCampos();
		if (!errores.equals("")){
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error al guardar");
			mensaje.setHeaderText("Se encontraron los siguientes errrores");
			mensaje.setContentText(errores);
			mensaje.show();
			return;
		}
		Cliente cliente=new Cliente(0, txtNombre.getText(),txtTelefono.getText(),
				txtdireccion.getText(),
				txtIdentidad.getText(),Date.valueOf(dtpkrFechaNacimiento.getValue()),
				rbtnMasculino.isSelected()?"M":"F",
				txtCorreoElectronico.getText());
		conexion.establecerConexion();
		int resultado=cliente.guardarCliente(conexion.getConexion());
		conexion.cerrarConexion();
		if (resultado==1){
			clientes.add(cliente);
		}
	}
	public void llenarComponentes(Cliente c){
		txtNombre.setText(c.getNombreCliente());
		txtTelefono.setText(c.getTelefono());
		txtdireccion.setText(c.getDireccion());
		txtCorreoElectronico.setText(c.getCorreoElectronico());
		txtIdentidad.setText(c.getIdentidadCliente());
		dtpkrFechaNacimiento.setValue(c.getFechaNacimiento().toLocalDate());
		if (c.getSexo().equals("F")){
			rbtnFemenino.setSelected(true);
		}else{
			rbtnMasculino.setSelected(true);
		}
		btnGuardar.setDisable(true);
		btnEliminar.setDisable(false);
		btnActualizar.setDisable(false);
	}

	@FXML public void EliminarCliente(){
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Eliminar registro");
		alert.setHeaderText("Eliminar registro");
		alert.setContentText("�Esta seguro de que desea eliminar este registro?");
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			Cliente a = tblClientes.getSelectionModel().getSelectedItem();
			conexion.establecerConexion();
			int resultado = a.eliminarCliente(conexion.getConexion());
			conexion.cerrarConexion();
			if (resultado == 1){
				clientes.remove(a);
			}
			nuevoCliente();
		}
	}

	@FXML public void nuevoCliente(){
		txtNombre.setText(null);
		txtIdentidad.setText(null);
		txtdireccion.setText(null);
		txtTelefono.setText(null);
		txtCorreoElectronico.setText(null);
		dtpkrFechaNacimiento.setValue(null);
		rbtnMasculino.setSelected(false);
		rbtnFemenino.setSelected(false);
		btnGuardar.setDisable(false);
		btnEliminar.setDisable(true);
		btnActualizar.setDisable(true);
	}

	@FXML public void ActualizarCliente(){
		String errores = validarCampos();
		if (!errores.equals("")){
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error al actualizar el Registro");
			mensaje.setHeaderText("Se encontraron los siguientes errrores");
			mensaje.setContentText(errores);
			mensaje.show();
			return;
		}
		Cliente c=tblClientes.getSelectionModel().getSelectedItem();
		c.setNombreCliente(txtNombre.getText());
		c.setIdentidadCliente(txtIdentidad.getText());
		c.setTelefono(txtTelefono.getText());
		c.setCorreoElectronico(txtCorreoElectronico.getText());
		c.setSexo(rbtnMasculino.isSelected()?"M":"F");
		c.setFechaNacimiento(Date.valueOf(dtpkrFechaNacimiento.getValue()));
		c.setDireccion(txtdireccion.getText());
		conexion.establecerConexion();
		int resultado=c.actualizarCliente(conexion.getConexion());
		conexion.cerrarConexion();
		if (resultado==1){
			Alert mensaje = new Alert(AlertType.INFORMATION);
			mensaje.setContentText("Registro con codigo " + c.getCodigoCliente()+ " ha sido actualizado con exito.");
			mensaje.show();
			clientes.set(tblClientes.getSelectionModel().getSelectedIndex(), c);
		}
	}

	public String validarCampos(){
		String errores = "";
		if (txtNombre.getText().equals(""))
			errores += "Debe ingresar el nombre del Cliente\n";
		if (txtTelefono.getText().equals(""))
			errores += "Debe ingresar un numero telefonico\n";
		if (txtdireccion.getText().equals(""))
			errores += "Debe ingresar la direccion\n";
		if (txtIdentidad.getText().equals(""))
			errores += "Debe ingresar la identidad\n";
		if (dtpkrFechaNacimiento.getValue()==null)
			errores += "Debe seleccionar una fecha\n";
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
	@FXML public void BusquedaCliente(){
		clientes.clear();
		conexion.establecerConexion();
		Cliente.BusquedaCliente(conexion.getConexion(), clientes, txtBuscar.getText());
		conexion.cerrarConexion();
	}
}

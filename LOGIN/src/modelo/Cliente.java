package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Cliente{
	private IntegerProperty codigoCliente;
	private StringProperty nombreCliente;
	private StringProperty identidadCliente;
	private Date fechaNacimiento;
	private StringProperty sexo;
	private StringProperty telefono;
	private StringProperty direccion;
	private StringProperty correoElectronico;

	public Cliente(int codigoCliente, String nombreCliente,String telefono,String direccion,
			String identidadCliente,Date fechaNacimiento, String sexo, String correoElectronico) {
		this.codigoCliente = new SimpleIntegerProperty(codigoCliente);
		this.nombreCliente = new SimpleStringProperty(nombreCliente);
		this.identidadCliente = new SimpleStringProperty(identidadCliente);
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = new SimpleStringProperty(sexo);
		this.telefono = new SimpleStringProperty(telefono);
		this.direccion = new SimpleStringProperty(direccion);
		this.correoElectronico = new SimpleStringProperty(correoElectronico);
	}

	//Metodos atributo: codigoCliente
	public int getCodigoCliente() {
		return codigoCliente.get();
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = new SimpleIntegerProperty(codigoCliente);
	}
	public IntegerProperty CodigoClienteProperty() {
		return codigoCliente;
	}
	//Metodos atributo: nombreCliente
	public String getNombreCliente() {
		return nombreCliente.get();
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = new SimpleStringProperty(nombreCliente);
	}
	public StringProperty NombreClienteProperty() {
		return nombreCliente;
	}
	//Metodos atributo: identidadCliente
	public String getIdentidadCliente() {
		return identidadCliente.get();
	}
	public void setIdentidadCliente(String identidadCliente) {
		this.identidadCliente = new SimpleStringProperty(identidadCliente);
	}
	public StringProperty IdentidadClienteProperty() {
		return identidadCliente;
	}
	//Metodos atributo: fechaNacimiento
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//Metodos atributo: sexo
	public String getSexo() {
		return sexo.get();
	}
	public void setSexo(String sexo) {
		this.sexo = new SimpleStringProperty(sexo);
	}
	public StringProperty SexoProperty() {
		return sexo;
	}
	//Metodos atributo: telefono
	public String getTelefono() {
		return telefono.get();
	}
	public void setTelefono(String telefono) {
		this.telefono = new SimpleStringProperty(telefono);
	}
	public StringProperty TelefonoProperty() {
		return telefono;
	}
	//Metodos atributo: direccion
	public String getDireccion() {
		return direccion.get();
	}
	public void setDireccion(String direccion) {
		this.direccion = new SimpleStringProperty(direccion);
	}
	public StringProperty DireccionProperty() {
		return direccion;
	}
	public String getCorreoElectronico() {
		return correoElectronico.get();
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = new SimpleStringProperty(correoElectronico);
	}
	public StringProperty correoElectronicoeProperty() {
		return correoElectronico;
	}
	public int guardarCliente(Connection conexion){
		try {
			PreparedStatement instruccion=conexion.prepareCall("INSERT INTO tbl_cliente( "+
					"codigo_cliente, "+
					"nombre_cliente, "+
					"telefono_cliente, "+
					"direccion, "+
					"identidad, "+
					"fecha_nacimiento, "+
					"sexo, "+
					"correo_electronico "+
					") "+
					"VALUES (?,?,?,?,?,?,?,?)");
			instruccion.setInt(1,codigoCliente.get());
			instruccion.setString(2,nombreCliente.get());
			instruccion.setString(3, telefono.get());
			instruccion.setString(4, direccion.get());
			instruccion.setString(5, identidadCliente.get());
			instruccion.setDate(6, fechaNacimiento);
			instruccion.setString(7, sexo.get());
			instruccion.setString(8, correoElectronico.get());
			int resultado = instruccion.executeUpdate();
			if (resultado==1){
				Statement instruccionId = conexion.createStatement();
				ResultSet resultadoId = instruccionId.executeQuery("SELECT last_insert_id() id");
				resultadoId.first();
				codigoCliente=new SimpleIntegerProperty(resultadoId.getInt("id"));
			}
			return resultado;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int actualizarCliente(Connection conexion){
		try {
			PreparedStatement instruccion=conexion.prepareStatement("UPDATE tbl_cliente "+
					"SET nombre_cliente = ?, "+
					"telefono_cliente = ?, "+
					"direccion = ?, "+
					"identidad = ?, "+
					"fecha_nacimiento = ?, "+
					"sexo = ?, "+
					"correo_electronico = ? "+
					"WHERE codigo_cliente = ?");
			instruccion.setString(1,nombreCliente.get());
			instruccion.setString(2, telefono.get());
			instruccion.setString(3, direccion.get());
			instruccion.setString(4, identidadCliente.get());
			instruccion.setDate(5, fechaNacimiento);
			instruccion.setString(6, sexo.get());
			instruccion.setString(7, correoElectronico.get());
			instruccion.setInt(8, codigoCliente.get());
			return instruccion.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public int eliminarCliente(Connection conexion){
		try {
			PreparedStatement instruccion=conexion.prepareStatement("DELETE FROM tbl_cliente "+
																	"WHERE codigo_cliente = ?");
			instruccion.setInt(1,codigoCliente.get());
			return instruccion.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public static void llenarTablero(Connection conexion,ObservableList<Cliente> c){
		try {
		Statement instruccion=conexion.createStatement();
			ResultSet resultado;
				resultado = instruccion.executeQuery("SELECT codigo_cliente, "+
				"nombre_cliente, "+
				"telefono_cliente, "+
				"direccion, "+
				"identidad, "+
				"fecha_nacimiento, "+
				"sexo, "+
				"correo_electronico "+
				"FROM tbl_cliente");
				while(resultado.next()){
					c.add(new Cliente(resultado.getInt("codigo_cliente"),
							resultado.getString("nombre_cliente"),
							resultado.getString("telefono_cliente"),
							resultado.getString("direccion"),
							resultado.getString("identidad"),
							resultado.getDate("fecha_nacimiento"),
							resultado.getString("sexo"),
							resultado.getString("correo_electronico")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void BusquedaCliente(Connection conexion,ObservableList<Cliente> c, String id){
		try {
			PreparedStatement instruccion=conexion.prepareStatement("SELECT codigo_cliente, "+
					"nombre_cliente, "+
					"telefono_cliente, "+
					"direccion, "+
					"identidad, "+
					"fecha_nacimiento, "+
					"sexo, "+
					"correo_electronico "+
					"FROM tbl_cliente "+
					"WHERE identidad = ?");
			instruccion.setString(1, id);
			ResultSet resultado = instruccion.executeQuery();
			while(resultado.next()){
				c.add(new Cliente(resultado.getInt("codigo_cliente"),
						resultado.getString("nombre_cliente"),
						resultado.getString("telefono_cliente"),
						resultado.getString("direccion"),
						resultado.getString("identidad"),
						resultado.getDate("fecha_nacimiento"),
						resultado.getString("sexo"),
						resultado.getString("correo_electronico")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

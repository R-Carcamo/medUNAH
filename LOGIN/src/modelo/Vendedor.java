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

public class Vendedor {
	private IntegerProperty codigoVendedor;
	private StringProperty nombre;
	private StringProperty apellido;
	private StringProperty genero;
	private Date fechaNacimiento;
	private Date fechaIngreso;
	private StringProperty numeroIdentidadVendedor;
	private StringProperty estadoCivil;
	private StringProperty direccion;
	private StringProperty telefono;
	private StringProperty correo;

	public Vendedor(int codigoVendedor, String nombre, String apellido,
String genero, Date fechaNacimiento, Date fechaIngreso,
String numeroIdentidadVendedor, String estadoCivil, String direccion,
String telefono, String correo) {
		this.codigoVendedor = new SimpleIntegerProperty(codigoVendedor);
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido = new SimpleStringProperty(apellido);
		this.genero = new SimpleStringProperty(genero);
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.numeroIdentidadVendedor = new SimpleStringProperty(numeroIdentidadVendedor);
		this.estadoCivil = new SimpleStringProperty(estadoCivil);
		this.direccion = new SimpleStringProperty(direccion);
		this.telefono = new SimpleStringProperty(telefono);
		this.correo = new SimpleStringProperty(correo);
	}

	//Metodos atributo: codigoVendedor
	public int getCodigoVendedor() {
		return codigoVendedor.get();
	}
	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = new SimpleIntegerProperty(codigoVendedor);
	}
	public IntegerProperty CodigoVendedorProperty() {
		return codigoVendedor;
	}
	//Metodos atributo: nombre
	public String getNombre() {
		return nombre.get();
	}
	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}
	public StringProperty NombreProperty() {
		return nombre;
	}
	//Metodos atributo: apellido
	public String getApellido() {
		return apellido.get();
	}
	public void setApellido(String apellido) {
		this.apellido = new SimpleStringProperty(apellido);
	}
	public StringProperty ApellidoProperty() {
		return apellido;
	}
	//Metodos atributo: genero
	public String getGenero() {
		return genero.get();
	}
	public void setGenero(String genero) {
		this.genero = new SimpleStringProperty(genero);
	}
	public StringProperty GeneroProperty() {
		return genero;
	}
	//Metodos atributo: fechaNacimiento
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	//Metodos atributo: fechaIngreso
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	//Metodos atributo: numeroIdentidadVendedor
	public String getNumeroIdentidadVendedor() {
		return numeroIdentidadVendedor.get();
	}
	public void setNumeroIdentidadVendedor(String numeroIdentidadVendedor) {
		this.numeroIdentidadVendedor = new SimpleStringProperty(numeroIdentidadVendedor);
	}
	public StringProperty NumeroIdentidadVendedorProperty() {
		return numeroIdentidadVendedor;
	}
	//Metodos atributo: estadoCivil
	public String getEstadoCivil() {
		return estadoCivil.get();
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = new SimpleStringProperty(estadoCivil);
	}
	public StringProperty EstadoCivilProperty() {
		return estadoCivil;
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
	//Metodos atributo: correo
	public String getCorreo() {
		return correo.get();
	}
	public void setCorreo(String correo) {
		this.correo = new SimpleStringProperty(correo);
	}
	public StringProperty CorreoProperty() {
		return correo;
	}

	public int guardarVendedor(Connection conexion){
		try {
			PreparedStatement instruccion=conexion.prepareStatement("INSERT INTO tbl_vendedor( "+
					"id_vendedor, "+
					"nombres, "+
					"apellidos, "+
					"genero, "+
					"fecha_nacimiento, "+
					"fecha_ingreso, "+
					"numero_identidad, "+
					"estado_civil, "+
					"direccion, "+
					"telefono, "
					+"correo "+
					") "+
					"VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			instruccion.setInt(1,codigoVendedor.get());
			instruccion.setString(2, nombre.get());
			instruccion.setString(3,apellido.get());
			instruccion.setString(4, genero.get());
			instruccion.setDate(5, fechaNacimiento);
			instruccion.setDate(6, fechaIngreso);
			instruccion.setString(7, numeroIdentidadVendedor.get());
			instruccion.setString(8, estadoCivil.get());
			instruccion.setString(9, direccion.get());
			instruccion.setString(10, telefono.get());
			instruccion.setString(11, correo.get());
			int resultado = instruccion.executeUpdate();
			if (resultado==1){
				Statement instruccionId = conexion.createStatement();
				ResultSet resultadoId = instruccionId.executeQuery("SELECT last_insert_id() id");
				resultadoId.first();
				codigoVendedor=new SimpleIntegerProperty(resultadoId.getInt("id"));
			}
			return resultado;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int actualizarVendedor(Connection conexion){
		try {
			PreparedStatement instruccion=conexion.prepareStatement("UPDATE tbl_vendedor "+
					"SET nombres = ?, "+
					"apellidos = ?, "+
					"genero = ?, "+
					"fecha_nacimiento = ?, "+
					"fecha_ingreso = ?, "+
					"numero_identidad = ?, "+
					"estado_civil = ?, "+
					"direccion = ?, "+
					"telefono = ?, "+
					"correo = ? "+
					"WHERE id_vendedor = ?");
			instruccion.setString(1, nombre.get());
			instruccion.setString(2,apellido.get());
			instruccion.setString(3, genero.get());
			instruccion.setDate(4, fechaNacimiento);
			instruccion.setDate(5, fechaIngreso);
			instruccion.setString(6, numeroIdentidadVendedor.get());
			instruccion.setString(7, estadoCivil.get());
			instruccion.setString(8, direccion.get());
			instruccion.setString(9, telefono.get());
			instruccion.setString(10, correo.get());
			instruccion.setInt(11,codigoVendedor.get());
			return instruccion.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int eliminarVendedor(Connection conexion){
		try {
			PreparedStatement instruccion;
			instruccion = conexion.prepareStatement("DELETE FROM tbl_vendedor "+
					"WHERE id_vendedor = ?");
			instruccion.setInt(1, codigoVendedor.get());
			return instruccion.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static void llenarTablero(Connection conexion, ObservableList<Vendedor> v){
		try {
			Statement instruccion=conexion.createStatement();
			ResultSet resultado=instruccion.executeQuery("SELECT id_vendedor, "+
					"nombres, "+
					"apellidos, "+
					"genero, "+
					"fecha_nacimiento, "+
					"fecha_ingreso, "+
					"numero_identidad, "+
					"estado_civil, "+
					"direccion, "+
					"telefono, "+
					"correo "+
					"FROM tbl_vendedor");
			while(resultado.next()){
				v.add(new Vendedor(resultado.getInt("id_vendedor"),
						resultado.getString("nombres"),
						resultado.getString("apellidos"),
						resultado.getString("genero"),
						resultado.getDate("fecha_nacimiento"),
						resultado.getDate("fecha_ingreso"),
						resultado.getString("numero_identidad"),
						resultado.getString("estado_civil"),
						resultado.getString("direccion"),
						resultado.getString("telefono"),
						resultado.getString("correo")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void BusquedaVendedor(Connection conexion,ObservableList<Vendedor> c, String id){
		try {
			PreparedStatement instruccion;
			instruccion = conexion.prepareStatement("SELECT id_vendedor, "+
					"nombres, "+
					"apellidos, "+
					"genero, "+
					"fecha_nacimiento, "+
					"fecha_ingreso, "+
					"numero_identidad, "+
					"estado_civil, "+
					"direccion, "+
					"telefono, "+
					"correo "+
					"FROM tbl_vendedor "+
					"WHERE numero_identidad = ?");
			instruccion.setString(1, id);
			ResultSet resultado = instruccion.executeQuery();
			while(resultado.next()){
				c.add(new Vendedor(resultado.getInt("id_vendedor"),
						resultado.getString("nombres"),
						resultado.getString("apellidos"),
						resultado.getString("genero"),
						resultado.getDate("fecha_nacimiento"),
						resultado.getDate("fecha_ingreso"),
						resultado.getString("numero_identidad"),
						resultado.getString("estado_civil"),
						resultado.getString("direccion"),
						resultado.getString("telefono"),
						resultado.getString("correo")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
}

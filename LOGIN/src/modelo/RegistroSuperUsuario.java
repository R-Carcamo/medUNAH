package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegistroSuperUsuario {
	private IntegerProperty codigoSuperUsuario;
	private StringProperty nombres;
	private StringProperty apellidos;
	private StringProperty genero;
	private IntegerProperty edad;
	private Date fechaNacimiento;
	private Date fechaIngreso;
	private StringProperty numeroIdentidad;
	private StringProperty estadoCivil;
	private StringProperty direccion;
	private StringProperty telefono;
	private StringProperty correo;

	public RegistroSuperUsuario(int codigoSuperUsuario, String nombres,
			String apellidos, String genero, int edad, Date fechaNacimiento,
			Date fechaIngreso, String numeroIdentidad, String estadoCivil,
			String direccion, String telefono, String correo) {
		this.codigoSuperUsuario = new SimpleIntegerProperty(codigoSuperUsuario);
		this.nombres = new SimpleStringProperty(nombres);
		this.apellidos = new SimpleStringProperty(apellidos);
		this.genero = new SimpleStringProperty(genero);
		this.edad = new SimpleIntegerProperty(edad);
		this.fechaNacimiento = fechaNacimiento;
		this.fechaIngreso = fechaIngreso;
		this.numeroIdentidad = new SimpleStringProperty(numeroIdentidad);
		this.estadoCivil = new SimpleStringProperty(estadoCivil);
		this.direccion = new SimpleStringProperty(direccion);
		this.telefono = new SimpleStringProperty(telefono);
		this.correo = new SimpleStringProperty(correo);
	}
	
	public RegistroSuperUsuario(int usuario, String contrasena) { 
		this.codigoSuperUsuario = new SimpleIntegerProperty(usuario);
		//this.nombres = new SimpleStringProperty(nombre);
		this.numeroIdentidad = new SimpleStringProperty(contrasena);
	}

	// Metodos atributo: codigoSuperUsuario
	public int getCodigoSuperUsuario() {
		return codigoSuperUsuario.get();
	}

	public void setCodigoSuperUsuario(int codigoSuperUsuario) {
		this.codigoSuperUsuario = new SimpleIntegerProperty(codigoSuperUsuario);
	}

	public IntegerProperty CodigoSuperUsuarioProperty() {
		return codigoSuperUsuario;
	}

	// Metodos atributo: nombres
	public String getNombres() {
		return nombres.get();
	}

	public void setNombres(String nombres) {
		this.nombres = new SimpleStringProperty(nombres);
	}

	public StringProperty NombresProperty() {
		return nombres;
	}

	// Metodos atributo: apellidos
	public String getApellidos() {
		return apellidos.get();
	}

	public void setApellidos(String apellidos) {
		this.apellidos = new SimpleStringProperty(apellidos);
	}

	public StringProperty ApellidosProperty() {
		return apellidos;
	}

	// Metodos atributo: genero
	public String getGenero() {
		return genero.get();
	}

	public void setGenero(String genero) {
		this.genero = new SimpleStringProperty(genero);
	}

	public StringProperty GeneroProperty() {
		return genero;
	}

	// Metodos atributo: edad
	public int getEdad() {
		return edad.get();
	}

	public void setEdad(int edad) {
		this.edad = new SimpleIntegerProperty(edad);
	}

	public IntegerProperty EdadProperty() {
		return edad;
	}

	// Metodos atributo: fechaNacimiento
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	// Metodos atributo: fechaIngreso
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	// Metodos atributo: numeroIdentidad
	public String getNumeroIdentidad() {
		return numeroIdentidad.get();
	}

	public void setNumeroIdentidad(String numeroIdentidad) {
		this.numeroIdentidad = new SimpleStringProperty(numeroIdentidad);
	}

	public StringProperty NumeroIdentidadProperty() {
		return numeroIdentidad;
	}

	// Metodos atributo: estadoCivil
	public String getEstadoCivil() {
		return estadoCivil.get();
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = new SimpleStringProperty(estadoCivil);
	}

	public StringProperty EstadoCivilProperty() {
		return estadoCivil;
	}

	// Metodos atributo: direccion
	public String getDireccion() {
		return direccion.get();
	}

	public void setDireccion(String direccion) {
		this.direccion = new SimpleStringProperty(direccion);
	}

	public StringProperty DireccionProperty() {
		return direccion;
	}

	// Metodos atributo: telefono
	public String getTelefono() {
		return telefono.get();
	}

	public void setTelefono(String telefono) {
		this.telefono = new SimpleStringProperty(telefono);
	}

	public StringProperty TelefonoProperty() {
		return telefono;
	}

	// Metodos atributo: correo
	public String getCorreo() {
		return correo.get();
	}

	public void setCorreo(String correo) {
		this.correo = new SimpleStringProperty(correo);
	}

	public StringProperty CorreoProperty() {
		return correo;
	}
	
	public int verificarUsuario(Connection conexion){
		try {
			PreparedStatement instruccion = 
					conexion.prepareStatement(
					"SELECT id_super_usuario "+
					"FROM tbl_super_usuario "+
					"WHERE id_super_usuario = ? "+
					"AND numero_identidad = sha1(?) "
					);
			instruccion.setString(1, String.valueOf(codigoSuperUsuario.get()));
			instruccion.setString(2, numeroIdentidad.get());
			ResultSet resultado = instruccion.executeQuery();
			if(resultado.next())
				return resultado.getInt("id_super_usuario");
			else 
				return -1;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -1;
		}
		
	}
}
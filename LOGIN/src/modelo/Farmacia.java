package modelo;
/* Java Bean
* Clase: Farmacia  */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Farmacia{
	private IntegerProperty codigoFarmacia;
	private Bodega bodega;
	private StringProperty nombreFarmacia;
	private StringProperty direccionFarmacia;
	private StringProperty correoFarmacia;
	private StringProperty telefonoFarmacia;

	public Farmacia(Integer codigoFarmacia, Bodega bodega, String nombreFarmacia, String direccionFarmacia, String correoFarmacia, String telefonoFarmacia){
		this.codigoFarmacia = new SimpleIntegerProperty(codigoFarmacia);
		this.bodega = bodega;
		this.nombreFarmacia = new SimpleStringProperty(nombreFarmacia);
		this.direccionFarmacia = new SimpleStringProperty(direccionFarmacia);
		this.correoFarmacia = new SimpleStringProperty(correoFarmacia);
		this.telefonoFarmacia = new SimpleStringProperty(telefonoFarmacia);
	}

	public Integer getCodigoFarmacia(){
		return codigoFarmacia.get();
	}

	public void setCodigoFarmacia(Integer codigoFarmacia){
		this.codigoFarmacia = new SimpleIntegerProperty(codigoFarmacia);
	}

	public Bodega getBodega(){
		return bodega;
	}

	public void setBodega(Bodega bodega){
		this.bodega = bodega;
	}

	public String getNombreFarmacia(){
		return nombreFarmacia.get();
	}

	public void setNombreFarmacia(String nombreFarmacia){
		this.nombreFarmacia = new SimpleStringProperty(nombreFarmacia);
	}

	public String getDireccionFarmacia(){
		return direccionFarmacia.get();
	}

	public void setDireccionFarmacia(String direccionFarmacia){
		this.direccionFarmacia = new SimpleStringProperty(direccionFarmacia);
	}

	public String getCorreoFarmacia(){
		return correoFarmacia.get();
	}

	public void setCorreoFarmacia(String correoFarmacia){
		this.correoFarmacia = new SimpleStringProperty(correoFarmacia);
	}

	public String getTelefonoFarmacia(){
		return telefonoFarmacia.get();
	}

	public void setTelefonoFarmacia(String telefonoFarmacia){
		this.telefonoFarmacia = new SimpleStringProperty(telefonoFarmacia);
	}

	public IntegerProperty codigoFarmaciaProperty(){
		return codigoFarmacia;
	}

	public StringProperty nombreFarmaciaProperty(){
		return nombreFarmacia;
	}

	public StringProperty direccionFarmaciaProperty(){
		return direccionFarmacia;
	}

	public StringProperty correoFarmaciaProperty(){
		return correoFarmacia;
	}

	public StringProperty telefonoFarmaciaProperty(){
		return telefonoFarmacia;
	}


}
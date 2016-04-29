package modelo;
/* Java Bean
* Clase: Bodega  */
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bodega{
	private IntegerProperty codigoBodega;
	private StringProperty nombreBodega;
	private StringProperty ubicacionBodega;

	public Bodega(Integer codigoBodega, String nombreBodega, String ubicacionBodega){
		this.codigoBodega = new SimpleIntegerProperty(codigoBodega);
		this.nombreBodega = new SimpleStringProperty(nombreBodega);
		this.ubicacionBodega = new SimpleStringProperty(ubicacionBodega);
	}

	public Integer getCodigoBodega(){
		return codigoBodega.get();
	}

	public void setCodigoBodega(Integer codigoBodega){
		this.codigoBodega = new SimpleIntegerProperty(codigoBodega);
	}

	public String getNombreBodega(){
		return nombreBodega.get();
	}

	public void setNombreBodega(String nombreBodega){
		this.nombreBodega = new SimpleStringProperty(nombreBodega);
	}

	public String getUbicacionBodega(){
		return ubicacionBodega.get();
	}

	public void setUbicacionBodega(String ubicacionBodega){
		this.ubicacionBodega = new SimpleStringProperty(ubicacionBodega);
	}

	public IntegerProperty codigoBodegaProperty(){
		return codigoBodega;
	}

	public StringProperty nombreBodegaProperty(){
		return nombreBodega;
	}

	public StringProperty ubicacionBodegaProperty(){
		return ubicacionBodega;
	}


}
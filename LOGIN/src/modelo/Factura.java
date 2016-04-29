/* Java Bean

* Clase: Factura  */
package modelo;
import java.sql.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Factura{
	private IntegerProperty codigoFactura;
	private Farmacia Farmacia;
	private Bodega Bodega;
	private Cliente Cliente;
	private Date fecha;
	private DoubleProperty total;
	private DoubleProperty isv;
	private DoubleProperty totalPagar;
	private StringProperty tipoPago;
	private Vendedor vendedor;

	public Factura(Integer codigoFactura, Farmacia Farmacia, Bodega Bodega, Cliente Cliente, Date fecha, Double total, Double isv, Double totalPagar, String tipoPago, Vendedor vendedor){
		this.codigoFactura = new SimpleIntegerProperty(codigoFactura);
		this.Farmacia = Farmacia;
		this.Bodega = Bodega;
		this.Cliente = Cliente;
		this.fecha = fecha;
		this.total = new SimpleDoubleProperty(total);
		this.isv = new SimpleDoubleProperty(isv);
		this.totalPagar = new SimpleDoubleProperty(totalPagar);
		this.tipoPago = new SimpleStringProperty(tipoPago);
		this.vendedor = vendedor;
	}

	public Integer getCodigoFactura(){
		return codigoFactura.get();
	}

	public void setCodigoFactura(Integer codigoFactura){
		this.codigoFactura = new SimpleIntegerProperty(codigoFactura);
	}

	public Farmacia getFarmacia(){
		return Farmacia;
	}

	public void setFarmacia(Farmacia Farmacia){
		this.Farmacia = Farmacia;
	}

	public Bodega getBodega(){
		return Bodega;
	}

	public void setBodega(Bodega Bodega){
		this.Bodega = Bodega;
	}

	public Cliente getCliente(){
		return Cliente;
	}

	public void setCliente(Cliente Cliente){
		this.Cliente = Cliente;
	}

	public Date getFecha(){
		return fecha;
	}

	public void setFecha(Date fecha){
		this.fecha = fecha;
	}

	public Double getTotal(){
		return total.get();
	}

	public void setTotal(Double total){
		this.total = new SimpleDoubleProperty(total);
	}

	public Double getIsv(){
		return isv.get();
	}

	public void setIsv(Double isv){
		this.isv = new SimpleDoubleProperty(isv);
	}

	public Double getTotalPagar(){
		return totalPagar.get();
	}

	public void setTotalPagar(Double totalPagar){
		this.totalPagar = new SimpleDoubleProperty(totalPagar);
	}

	public String getTipoPago(){
		return tipoPago.get();
	}

	public void setTipoPago(String tipoPago){
		this.tipoPago = new SimpleStringProperty(tipoPago);
	}

	public Vendedor getVendedor(){
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor){
		this.vendedor = vendedor;
	}

	public IntegerProperty codigoFacturaProperty(){
		return codigoFactura;
	}

	public DoubleProperty totalProperty(){
		return total;
	}

	public DoubleProperty isvProperty(){
		return isv;
	}

	public DoubleProperty totalPagarProperty(){
		return totalPagar;
	}

	public StringProperty tipoPagoProperty(){
		return tipoPago;
	}


}
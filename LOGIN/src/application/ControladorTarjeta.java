package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.pagoTarjeta;
public class ControladorTarjeta implements Initializable{
	private Double totPagar;
	  @FXML private TextField txtNumTarjeta;
	  @FXML private TextField txtTotPagar;
	public Main main;
	private ObservableList<String> emisor;
	@FXML private ComboBox<String> cboEmisor;
	private boolean finalizo = false;
	private Socket cliente;

	private ObjectOutputStream salida;
	private DataInputStream entrada;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Task<String> tarea = new Task<String>(){

			@Override
			protected String call() throws Exception {
				try{
					System.out.println("Intentando conectar");
					cliente = new Socket("localhost",60666);
					System.out.println("Se conecto satisfactoriamente");
					salida = new  ObjectOutputStream(cliente.getOutputStream());
					entrada = new DataInputStream(cliente.getInputStream());
					while(!finalizo){
						try {
							String mensaje = entrada.readUTF();



						Platform.runLater(new Runnable(){
							@Override
							public void run() {
									//txtResultado.appendText(mensaje+"\n");
								Alert alert = new Alert(AlertType.INFORMATION);
						        alert.setTitle("Notificacion");
						        alert.setContentText(mensaje);
						        alert.showAndWait();
						        if(mensaje.equals("Se ha realizado el pago correctamente"))
						        {
						        	main.cerrarPagoTar();
						        }
						        /*if(todo esta corecto){
						         * cliente.close();
						         * main.cerrarPagoTar();
						         * }
						         */
							}
						});
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e);
						}
					}
					//cliente.close();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "Finalizo el hilo";
			}

		};
		Thread hilo = new Thread(tarea);
		hilo.setDaemon(true);
		hilo.start();
		llenarComboBox();
	}
	@FXML
	public void aceptar(){
		try {
			/**/
	       // main.cerrarPagoTar();
			salida.writeObject(new pagoTarjeta(
									cboEmisor.getSelectionModel().getSelectedItem(),
									txtNumTarjeta.getText(),
									Double.parseDouble(txtTotPagar.getText())
									));
			System.out.println("[CLIENTE]: " + txtNumTarjeta.getText()+"\n");
			//txtResultado.appendText("[CLIENTE]: " + txtMensaje.getText()+"\n");
			//txtMensaje.setText(null);
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
	        alert.setTitle("Notificacion");
	        alert.setContentText("El Pago no se ha realizado con exito");
	        alert.showAndWait();
		}

		//main.cerrarPagoTar();
	}

	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;

	}
	public void llenarComboBox(){
		emisor = FXCollections.observableArrayList();
		cboEmisor.setItems(emisor);
		emisor.add("Visa");
		emisor.add("MasterCard");
}
	public Double getTotPagar() {
		return totPagar;
	}
	public void setTotPagar(Double totPagar) {
		this.totPagar = totPagar;
		txtTotPagar.setText(totPagar.toString());
	}
}

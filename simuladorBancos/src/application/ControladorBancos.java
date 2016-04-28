package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;


public class ControladorBancos implements Initializable{
	private boolean finalizo = false;
	private ServerSocket servidor;

	@FXML private TextArea txtMensaje;
	@FXML private TextArea txtResultado;
	@FXML private ListView<Socket> lstClientes;
	private ObservableList<Socket> socketsClientes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		socketsClientes = FXCollections.observableArrayList();
		lstClientes.setItems(socketsClientes);
		Task<String> tareaEscucharPeticiones = new Task<String>(){
			public String call(){
				try {
					servidor = new ServerSocket(60666);
					while(!finalizo){
						System.out.println("Esperando cliente");
						Socket cliente= servidor.accept();
						System.out.println("Cliente conectado: " + cliente);
						Platform.runLater(new Runnable(){
							public void run(){
								socketsClientes.add(cliente);
							}
						});
						procesarMensajesCliente(cliente);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "Tarea finalizada";
			}
		};
		Thread hilo = new Thread(tareaEscucharPeticiones);
		hilo.setDaemon(true);
		hilo.start();
	}

	public void procesarMensajesCliente(Socket cliente){
		Task<String> tareaLecturaMensajes = new Task<String>(){

			@Override
			protected String call() throws Exception {
				DataInputStream entrada = new DataInputStream(cliente.getInputStream());
				while(!finalizo){
					System.out.println("Esperando a que el cliente escriba algo");
					String mensaje = entrada.readUTF();
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
								txtResultado.appendText(mensaje+"\n");
						}
					});
				}
				servidor.close();
				cliente.close();
				return "Finalizo la tarea";
			}

		};
		Thread hilo = new Thread(tareaLecturaMensajes);
		hilo.setDaemon(true); //Para que el hilo de la aplicacion
		//finalicen cuando se cierra la aplicacion
		hilo.start();//Inicia el hilo, es decir llama al metodo call()
	}

	@FXML
	public void enviarMensaje(){
		 try {
			Socket clienteSeleccionado =
					lstClientes.getSelectionModel().getSelectedItem();
			DataOutputStream salida = new DataOutputStream(clienteSeleccionado.getOutputStream());
			salida.writeUTF("[SERVIDOR]: " + txtMensaje.getText());
			txtResultado.appendText("[SERVIDOR]: " + txtMensaje.getText()+"\n");
			txtMensaje.setText(null);
			//salida.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
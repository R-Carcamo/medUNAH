package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	//INVENTARIO
	private Stage formulario1;
	private Stage formularioPrincipal;
	private ControladorPrincipal controladorPrincipal;
	private ControladorFormulario1 controladorFormulario1;
	// STAGES
	private Stage loginPrincipal;
	//AREA SUPER USUARIO
	private Stage loginSuperUsuario;
	private Stage formularioVendedor;
	private Stage formularioBodeguero;
	//AREA INVENTARIO
	private Stage loginSuperUsuarioAreaInventario;//
	private Stage loginAreaDeBodega;
	private Stage listaBodega;
	private Stage registroSupervisorInventarios;

	//AREA VENTAS
	private Stage loginVendedores;
	private Stage loginSuperUsuarioAreaVentas;
	private Stage listaVendedores;
	private Stage factura;
	private Stage tarjeta;
	private Stage efectivo;

	//CONTROLADORES VISTAS
	private ControladorloginPrincipal controladorLoginPrincipal;
	//CONTROLADOR VISTA SUPERUSUARIO
	private ControladorloginSuperUsuario controladorLoginSuperUsuario;
	//CONTROLADOR VISTAS AREA INVENTARIO
	private ControladorloginAreaDeBodega controladorLoginAreaDeBodega;
	private ControladorloginSuperUsuarioAreaInventario controladorLoginSuperUsuarioAreaInventario;
	private ControladorlistaEncargadodeBodega controladorListaBodega;
	private ControladorBodeguero controladorBodeguero;
	//CONTROLADOR VISTAS AREA VENTAS
	private ControladorloginVendedores controladorLoginVendedores;
	private ControladorloginSuperUsuarioAreaVentas controladorLoginSuperUsuarioAreaVentas;
	private ControladorlistaVendedores controladorListaVendedores;
	private ControladorVendedor controladorVendedor;
	private ControladorFactura controladorFactura;
	private ControladorTarjeta controladorTarjeta;
	private ControladorEfectivo controladorEfectivo;
	private ControladorRegistroSupervisorInventarios controladorRegistroSupervisorInventarios;

// CLIENTES
	private Stage formularioCliente;
	private Stage formularioFactura;
	private ClientesController clientesController;
	//private int a;

	@Override
	public void start(Stage primaryStage) {
		loginPrincipal = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("loginPrincipal.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			primaryStage.setTitle("LOGIN PRINCIPAL");
			controladorLoginPrincipal = loader.getController();
			controladorLoginPrincipal.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//INGRESAR AL LOGIN DEL SUPERUSUARIO
	public void mostrarLoginSuperUsuario(){
		if(loginSuperUsuario==null){
			loginSuperUsuario = new Stage();
			loginSuperUsuario.initOwner(loginPrincipal);
			loginSuperUsuario.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("loginSuperUsuario.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				loginSuperUsuario.setScene(scene);
				loginSuperUsuario.setTitle("LOGIN SUPERUSUARIO");
				controladorLoginSuperUsuario = loader.getController();
				controladorLoginSuperUsuario.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginPrincipal.hide();
		loginSuperUsuario.show();
		}

	//INGRESAR AL LOGIN VENDEDOR
	public void mostrarLoginVendedores(){
		if(loginVendedores==null){
			loginVendedores = new Stage();
			loginVendedores.initOwner(loginPrincipal);
			loginVendedores.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("loginVendedores.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				loginVendedores.setScene(scene);
				loginVendedores.setTitle("LOGIN VENDEDORES");
				controladorLoginVendedores = loader.getController();
				controladorLoginVendedores.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginPrincipal.hide();
		loginVendedores.show();
		}

	//INGRESAR AL LOGIN DEL ENCARGADO DE BODEGA
	public void mostrarLoginEncargadoDeBodega(){
		if(loginAreaDeBodega==null){
			loginAreaDeBodega = new Stage();
			loginAreaDeBodega.initOwner(loginPrincipal);
			loginAreaDeBodega.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("loginAreaDeBodega.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				loginAreaDeBodega.setScene(scene);
				loginAreaDeBodega.setTitle("ENCARGADOS DE BODEGA");
				controladorLoginAreaDeBodega = loader.getController();
				controladorLoginAreaDeBodega.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginPrincipal.hide();
		loginAreaDeBodega.show();
		}



	//INGRESO A LAS OPCIONES DEL SUPERUSUARIO EN EL AREA DE INVENTARIO
	public void mostrarSuperUsuarioAreaInventario(){
		if(loginSuperUsuarioAreaInventario==null){
			loginSuperUsuarioAreaInventario = new Stage();
			loginSuperUsuarioAreaInventario.initOwner(loginSuperUsuario);//
			loginSuperUsuarioAreaInventario.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("loginSuperUsuarioAreaInventario.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				loginSuperUsuarioAreaInventario.setScene(scene);
				loginSuperUsuarioAreaInventario.setTitle("LOGIN AREA INVENTARIO");
				controladorLoginSuperUsuarioAreaInventario = loader.getController();
				controladorLoginSuperUsuarioAreaInventario.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginSuperUsuario.hide();
		loginSuperUsuarioAreaInventario.show();
		}


	//INGRESO A LAS OPCIONES DEL SUPERUSUARIO EN EL AREA DE VENTAS
	public void mostrarSuperUsuarioAreaVentas(){
		if(loginSuperUsuarioAreaVentas==null){
			loginSuperUsuarioAreaVentas = new Stage();
			loginSuperUsuarioAreaVentas.initOwner(loginSuperUsuario);//
			loginSuperUsuarioAreaVentas.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("loginSuperUsuarioAreaVentas.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				loginSuperUsuarioAreaVentas.setScene(scene);
				loginSuperUsuarioAreaVentas.setTitle("LOGIN AREA VENTAS");
				controladorLoginSuperUsuarioAreaVentas = loader.getController();
				controladorLoginSuperUsuarioAreaVentas.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginSuperUsuario.hide();
		loginSuperUsuarioAreaVentas.show();
		}


	public void mostrarlistaVendedores(){
		if(listaVendedores==null){
			listaVendedores = new Stage();
			listaVendedores.initOwner(loginSuperUsuario);//
			listaVendedores.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("listaVendedores.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				listaVendedores.setScene(scene);
				listaVendedores.setTitle("LISTA VENDEDORES");
				controladorListaVendedores = loader.getController();
				controladorListaVendedores.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginSuperUsuario.hide();
		listaVendedores.show();
		}

	public void mostrarlistaEcncargadosdeBodega(){
		if(listaBodega==null){
			listaBodega = new Stage();
			listaBodega.initOwner(loginSuperUsuario);//
			listaBodega.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("listaVendedores.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				listaBodega.setScene(scene);
				listaBodega.setTitle("LISTA ");
				controladorListaBodega = loader.getController();
				controladorListaBodega.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginSuperUsuario.hide();
		listaBodega.show();
		}


	//INGRESO AL AREA DE INVENTARIO
	public void irInventario(){
		if(loginSuperUsuarioAreaInventario==null){
			loginSuperUsuarioAreaInventario = new Stage();
			loginSuperUsuarioAreaInventario.initOwner(loginSuperUsuario);//
			loginSuperUsuarioAreaInventario.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("loginSuperUsuarioAreaInventario.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				loginSuperUsuarioAreaInventario.setScene(scene);
				loginSuperUsuarioAreaInventario.setTitle("LOGIN AREA INVENTARIO");
				controladorLoginSuperUsuarioAreaInventario = loader.getController();
				controladorLoginSuperUsuarioAreaInventario.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		loginSuperUsuario.hide();
		loginSuperUsuarioAreaInventario.show();
		}


	//INVENTARIO

		public void irInventario2(){
			if(formularioPrincipal==null){
				formularioPrincipal = new Stage();
				formularioPrincipal.initOwner(loginAreaDeBodega);
				formularioPrincipal.initModality(Modality.WINDOW_MODAL);
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaPrincipal.fxml"));
					BorderPane root = (BorderPane)loader.load();
					Scene scene = new Scene(root);
					formularioPrincipal.setScene(scene);
					formularioPrincipal.setTitle("INVENTARIO");
					controladorPrincipal = loader.getController();
					controladorPrincipal.setMain(this);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			loginAreaDeBodega.close();
			formularioPrincipal.show();
		}

		public void agregarMedicamento(){
			if(formulario1==null){
				formulario1 = new Stage();
				formulario1.initOwner(formularioPrincipal);
				formulario1.initModality(Modality.WINDOW_MODAL);
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaFormulario1.fxml"));
					AnchorPane root = (AnchorPane)loader.load();
					Scene scene = new Scene(root);
					formulario1.setScene(scene);
					formulario1.setTitle("INVENTARIO");
					controladorFormulario1 = loader.getController();
					controladorFormulario1.setMain(this);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			//formularioPrincipal.close();
			formulario1.show();
		}
		public void mostrarBodeguero(){
			if(formularioBodeguero==null){
				formularioBodeguero = new Stage();
				formularioBodeguero.initOwner(loginSuperUsuarioAreaInventario);
				formularioBodeguero.initModality(Modality.WINDOW_MODAL);
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaBodeguero.fxml"));
					AnchorPane root = (AnchorPane)loader.load();
					Scene scene = new Scene(root);
					formularioBodeguero.setScene(scene);
					formularioBodeguero.setTitle("Encargados de Bodega");
					controladorBodeguero = loader.getController();
					controladorBodeguero.setMain(this);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			loginSuperUsuarioAreaInventario.hide();
			formularioBodeguero.show();
		}
		public void mostrarVendedores(){
			if(formularioVendedor==null){
				formularioVendedor = new Stage();
				formularioVendedor.initOwner(loginSuperUsuarioAreaVentas);
				formularioVendedor.initModality(Modality.WINDOW_MODAL);
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaVendedor.fxml"));
					AnchorPane root = (AnchorPane)loader.load();
					Scene scene = new Scene(root);
					formularioVendedor.setScene(scene);
					formularioVendedor.setTitle("Vendedores");
					controladorVendedor = loader.getController();
					controladorVendedor.setMain(this);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			loginSuperUsuarioAreaVentas.hide();
			formularioVendedor.show();
		}

 //MOSTRARCLIENTES
		public void agregarCliente(){
			if(formularioCliente==null){
				formularioCliente = new Stage();
				formularioCliente.initOwner(loginSuperUsuarioAreaVentas);
				formularioCliente.initModality(Modality.WINDOW_MODAL);
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaClientes.fxml"));
					AnchorPane root = (AnchorPane)loader.load();
					Scene scene = new Scene(root);
					formularioCliente.setScene(scene);
					formularioCliente.setTitle("Clientes");
					clientesController = loader.getController();
					clientesController.setMain(this);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			formularioCliente.show();
		}

	//CONTROLES BOTON SALIR LOGIN PRINCIPAL
	public void volverMenu1(){
	    loginSuperUsuario.close();
		loginPrincipal.show();
	}

	public void volverMenu2(){
		loginVendedores.close();
		loginPrincipal.show();
	}

	public void volverMenu3(){
	    loginAreaDeBodega.close();
		loginPrincipal.show();
	}

	public void volverMenu4(){
	    loginSuperUsuarioAreaVentas.close();
		loginSuperUsuario.show();
	}

	public void volverMenu5(){
	    listaVendedores.close();
		loginSuperUsuarioAreaVentas.show();
	}

	public void volverMenu6(){
	formularioPrincipal.close();
	loginAreaDeBodega.show();
	}

	public void volverMenu7(){
		loginSuperUsuarioAreaInventario.close();
		loginSuperUsuario.show();
		}

	public void volverMenu8(){
		listaBodega.close();
		loginSuperUsuarioAreaInventario.show();
		}
	public void salirRegistroVentas(){
		formularioVendedor.close();
		loginSuperUsuarioAreaVentas.show();
	}
	public void VolverMenuSuperUsuario2(){
		loginSuperUsuarioAreaInventario.close();
		loginSuperUsuario.show();
	}
	public void salirRegistroBodeguero(){
		formularioBodeguero.close();
		loginSuperUsuarioAreaInventario.show();
	}
	//Ventas
		//Abre la factura
	// Registro Supervisor inventarios
	public void mostrarRegistroSupervisorInventarios(){
		if(registroSupervisorInventarios==null){
			registroSupervisorInventarios = new Stage();
			registroSupervisorInventarios.initOwner(loginPrincipal);
			registroSupervisorInventarios.initModality(Modality.WINDOW_MODAL);

			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("VistaRegistroSupervisorInventarios.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				registroSupervisorInventarios.setScene(scene);
				registroSupervisorInventarios.setTitle("Registro (Nuevo Supervisor de Inventarios)");
				controladorRegistroSupervisorInventarios = loader.getController();
				controladorRegistroSupervisorInventarios.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		registroSupervisorInventarios.show();
		}

			public void mostrarFactura(){
				if(factura==null){
					factura = new Stage();
					factura.initOwner(loginSuperUsuario);
					factura.initModality(Modality.WINDOW_MODAL);
					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Factura.fxml"));
						AnchorPane root = (AnchorPane)loader.load();
						Scene scene = new Scene(root);
						factura.setScene(scene);
						factura.setTitle("MedUNAH Factura");
						controladorFactura = loader.getController();
						controladorFactura.setMain(this);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				loginVendedores.close();
				factura.show();
			}

			//Abre Pago con tarjeta

			public void mostrarTarjeta(){
				if(tarjeta==null){
					tarjeta = new Stage();
					tarjeta.initOwner(loginSuperUsuario);
					tarjeta.initModality(Modality.WINDOW_MODAL);

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Tarjeta.fxml"));
						AnchorPane root = (AnchorPane)loader.load();
						Scene scene = new Scene(root);
						tarjeta.setScene(scene);
						tarjeta.setTitle("Pago con Tarjeta");
						controladorTarjeta = loader.getController();
						controladorTarjeta.setMain(this);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				tarjeta.show();
				}

			//abrir pago en efectivo

			public void mostrarEfectivo(){
				if(efectivo==null){
					efectivo = new Stage();
					efectivo.initOwner(loginSuperUsuario);
					efectivo.initModality(Modality.WINDOW_MODAL);

					try {
						FXMLLoader loader = new FXMLLoader(getClass().getResource("Efectivo.fxml"));
						AnchorPane root = (AnchorPane)loader.load();
						Scene scene = new Scene(root);
						efectivo.setScene(scene);
						efectivo.setTitle("Pago en Efectivo");
						controladorEfectivo = loader.getController();
						controladorEfectivo.setMain(this);
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
				efectivo.show();
				}

			public void cerrarPagoEfec() {
				// TODO Auto-generated method stub
				efectivo.close();
				controladorFactura.nueva();
			}

			public void cerrarPagoTar() {
				// TODO Auto-generated method stub
				tarjeta.close();
				controladorFactura.nueva();
			}
	public static void main(String[] args) {
		launch(args);
	}
}

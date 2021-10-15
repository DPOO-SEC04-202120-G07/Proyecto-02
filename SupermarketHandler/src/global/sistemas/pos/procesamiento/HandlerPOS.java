package global.sistemas.pos.procesamiento;

public class HandlerPOS {

	
	private LoaderDatabase databaseLoader = new LoaderDatabase();
	private  SupermarketModeler supermarketModeler = new SupermarketModeler();
	private SaverDatabase databaseSaver = new SaverDatabase();
	
	public void commandLoadCSVDatabase() {
		
		databaseLoader.loadDatabaseCSV(supermarketModeler);

	}
	
	
	
	public boolean cajeroRegistrado (String id) {
		return supermarketModeler.getSupermercado().getCajeros().containsKey(id);
	}
	
	public void registrarCajero( String nombre,String id) {
		supermarketModeler.modelarCajero(nombre, id);
	}
	
	public void registrarCliente(String nombre, int edad, char sexo, String cedula, String estadoCivil, String situacionLaboral) throws HandledException {
		
		if (supermarketModeler.getSupermercado() == null) {
			throw new HandledException("null-supermercado");
		}
		
		supermarketModeler.modelarCliente(nombre, edad, sexo, cedula, estadoCivil, situacionLaboral);
	}
	
	public void registrarCompra(String cajero, String cc) throws HandledException {

		if (supermarketModeler.getSupermercado().getClientes().get(cc) == null && cc != "None") {
			throw new HandledException("null-cliente");
		}
		supermarketModeler.modelarCompra(cajero, cc);
		
	}
	
<<<<<<< HEAD
	public void agregarProducto(String producto) throws HandledException {
		
		if (supermarketModeler.getSupermercado().getProducto(producto) == null) {
			throw new HandledException("null-producto");
		}
		
		supermarketModeler.getSupermercado().getCompraActual().agregarProductoCompra(supermarketModeler.getSupermercado().getProducto(producto));
=======
	public String agregarProducto(String producto) {
		return supermarketModeler.getSupermercado().getCompraActual().agregarProductoCompra(supermarketModeler.getSupermercado().getProducto(producto));
>>>>>>> branch 'master' of https://github.com/DPOO-SEC04-202120-G07/Proyecto-01.git
		
	}
	
	public String facturarCompra() throws HandledException {
		
		if (supermarketModeler.getSupermercado() == null) {
			throw new HandledException("null-supermercado");
		}
		else if (supermarketModeler.getSupermercado().getCompraActual() == null) {
			throw new HandledException("null-compra");
		}
		
		return supermarketModeler.getSupermercado().cerrarCompraActual();

	}
	
	public void commandSaveCSVDatabase() {
		databaseSaver.saveDatabaseCSV(supermarketModeler);
	}

}

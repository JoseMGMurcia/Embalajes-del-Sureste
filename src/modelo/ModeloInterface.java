package modelo;

import java.util.List;
import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;
import dominio.Usuario;

public interface ModeloInterface {
	
	public boolean alta(Proveedor p);
	public boolean alta(Producto p);
	public boolean alta(Compra c);
	public boolean alta(Usuario u);
	
	public boolean baja(Proveedor p);
	public boolean baja(Producto p);
	public boolean baja(Compra c);
	public boolean baja(Usuario c);
	
	public boolean modificacion(Proveedor p);
	public boolean modificacion(Producto p);
	public boolean modificacion(Compra c);
	public boolean modificacion(Usuario c);
	
	public Proveedor consultaProveedor(int id);
	public Producto consultaProducto(int id);
	public Compra consultaCompra(int id);
	public Usuario consultaUsuario(int id);
	
	public List<Proveedor> consultaProveedores();
	public List<Producto> consultaProductos();
	public List<Compra> consultaCompras();
	public List<Usuario> consultaUsuarios();
}

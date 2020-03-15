package control;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.model.SelectItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dominio.*;
import modelo.Modelo;

public abstract class Control {

	private Proveedor proveedor;
	private ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
	private SelectItem[] listaNombresProveedores = new SelectItem[proveedores.size()];

	private Producto producto;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	private SelectItem[] listaNombresProductos = new SelectItem[productos.size()];

	private Usuario usuario;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private SelectItem[] listaNombresUsuarios;

	private Compra compra;
	private ArrayList<Compra> compras = new ArrayList<Compra>();
	private SelectItem[] listaIdCompras = new SelectItem[compras.size()];
	private int[] fromatoCompras;
	private String[] vistaCompras;

	// METODOS
	public SelectItem[] nombreItemsProv() {
		if (proveedores == null) {
			try {
				return null;
			} catch (Exception e) {
				System.out.println("No hay proveedores...");
			}
		}
		listaNombresProveedores = new SelectItem[proveedores.size()];
		for (int i = 0; i < proveedores.size(); i++) {
			listaNombresProveedores[i] = new SelectItem(proveedores.get(i).getNombre());
		}
		return listaNombresProveedores;
	}

	public SelectItem[] nombreItemsUser() {
		if (usuarios == null) {
			try {
				return null;
			} catch (Exception e) {
				System.out.println("No hay usuarios...");
			}
		}
		int cont = 0;
		for (int i = 0; i < usuarios.size(); i++) {
			if (!usuarios.get(i).getRol().equals("ROLE_ADMIN")) {
				cont++;
			}
		}
		listaNombresUsuarios = new SelectItem[cont];
		cont = 0;
		for (int i = 0; i < usuarios.size(); i++) {
			if (!usuarios.get(i).getRol().equals("ROLE_ADMIN")) {
				listaNombresUsuarios[cont] = new SelectItem(
						String.format("%s, %s", usuarios.get(i).getLogin(), usuarios.get(i).getApellidos()));
				cont++;
			}
		}
		return listaNombresUsuarios;
	}

	public SelectItem[] nombreItemsProduct() {
		if (productos == null) {
			try {
				return null;
			} catch (Exception e) {
				System.out.println("No hay productos...");
			}
		}
		listaNombresProductos = new SelectItem[productos.size()];
		for (int i = 0; i < productos.size(); i++) {
			listaNombresProductos[i] = new SelectItem(productos.get(i).getNombre());
		}
		return listaNombresProductos;
	}

	public SelectItem[] idItemsCompr() {
		if (compras == null) {
			try {
				return null;
			} catch (Exception e) {
				System.out.println("No hay compras...");
			}
		}
		listaIdCompras = new SelectItem[compras.size()];
		this.fromatoCompras = new int[compras.size()];
		this.vistaCompras = new String[compras.size()];
		for (int i = 0; i < compras.size(); i++) {
			String vistaCompra = formatoFecha(compras.get(i).getFecha()) + "_"
					+ compras.get(i).getProducto().getNombre();
			listaIdCompras[i] = new SelectItem(vistaCompra);
			this.fromatoCompras[i] = compras.get(i).getId();
			this.vistaCompras[i] = vistaCompra;
		}

		return listaIdCompras;
	}

	public String formatoFecha(GregorianCalendar fecha) {
		String compra = fecha.toInstant().toString();
		compra = compra.substring(0, compra.indexOf("T"));
		return compra;
	}

	public String toMD5(String md5) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}

	public abstract String preparaPagina();

	// GETTER y SETTERS
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public SelectItem[] getListaNombresProveedores() {
		return listaNombresProveedores;
	}

	public void setListaNombresProveedores(SelectItem[] listaNombresProveedores) {
		this.listaNombresProveedores = listaNombresProveedores;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public SelectItem[] getListaNombresProductos() {
		return listaNombresProductos;
	}

	public void setListaNombresProductos(SelectItem[] listaNombresProductos) {
		this.listaNombresProductos = listaNombresProductos;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	public SelectItem[] getListaIdCompras() {
		return listaIdCompras;
	}

	public void setListaIdCompras(SelectItem[] listaIdCompras) {
		this.listaIdCompras = listaIdCompras;
	}

	public int[] getFromatoCompras() {
		return fromatoCompras;
	}

	public void setFromatoCompras(int[] fromatoCompras) {
		this.fromatoCompras = fromatoCompras;
	}

	public String[] getVistaCompras() {
		return vistaCompras;
	}

	public void setVistaCompras(String[] vistaCompras) {
		this.vistaCompras = vistaCompras;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public SelectItem[] getListaNombresUsuarios() {
		return listaNombresUsuarios;
	}

	public void setListaNombresUsuarios(SelectItem[] listaNombresUsuarios) {
		this.listaNombresUsuarios = listaNombresUsuarios;
	}

}

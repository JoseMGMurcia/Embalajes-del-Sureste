package control;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import dominio.*;
import modelo.Modelo;

public class CGerente extends Control {

	private String[] selectProv;
	private String[] selectProducto;
	private String[] selectCompra;
	private String tarea;
	private Proveedor proveedorAux;
	private Producto productorAux;
	private Modelo modelo;

	@Override
	public String preparaPagina() {
		setProveedores((ArrayList<Proveedor>) modelo.consultaProveedores());
		setProductos((ArrayList<Producto>) modelo.consultaProductos());
		setCompras((ArrayList<Compra>) modelo.consultaCompras());
		for (Proveedor p : getProveedores()) {
			p.setCompras(new ArrayList<Compra>());
		}
		for (Producto p : getProductos()) {
			p.setCompras(new ArrayList<Compra>());
		}
		super.nombreItemsProv();
		super.nombreItemsProduct();
		super.idItemsCompr();
		return "loginGerente";
	}

	public void seleccionProveedor() {
		try {
			for (Proveedor p : getProveedores()) {
				if (p.getNombre().equals(this.selectProv[0])) {
					setProveedor(new Proveedor(p.getId(), p.getNombre(), p.getTelefono(), p.getContacto()));
					getProveedor().setCompras(new ArrayList<Compra>());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void seleccionProducto() {
		try {
			for (Producto p : getProductos()) {
				if (p.getNombre().equals(this.selectProducto[0])) {
					setProducto(new Producto(p.getId(), p.getNombre(), p.getDescripcion()));
					getProducto().setCompras(new ArrayList<Compra>());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void seleccionCompra() {
		try {

			for (int i = 0; i < getVistaCompras().length; i++) {
				if (this.selectCompra[0].equals(getVistaCompras()[i])) {
					for (Compra c : getCompras()) {
						if (getFromatoCompras()[i] == c.getId()) {
							setCompra(new Compra(c.getId(), c.getCantidad(), c.getPrecio(), c.getFecha(),
									c.getProducto(), c.getProveedor()));
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String editarProv() {
		try {
			if (getProveedor().getNombre() != null) {
				this.tarea = "Modificar";
				return "AnydirEditarProv";
			}
		} catch (Exception e) {
		}
		return "loginGerente";
	}

	public void eliminarProv() {
		if (getProveedor() != null) {
			modelo.baja(getProveedor());
		}
	}

	public String anyadirProv() {
		this.tarea = "Añadir";
		if (getProveedor() != null) {
			this.proveedorAux = new Proveedor(getProveedor().getId(), getProveedor().getNombre(),
					getProveedor().getTelefono(), getProveedor().getContacto());
		}
		setProveedor(new Proveedor());
		return "AnydirEditarProv";
	}

	public String accionProv() {
		if (this.tarea.equals("Añadir")) {
			modelo.alta(getProveedor());
		} else {
			modelo.modificacion(getProveedor());
		}
		return "loginGerente";
	}

	public String editarProd() {
		try {
			if (getProducto().getNombre() != null) {
				this.tarea = "Modificar";
				return "AnydirEditarProd";
			}
		} catch (Exception e) {
		}
		return "loginGerente";
	}

	public void eliminarProd() {

		if (getProducto() != null) {

			modelo.baja(getProducto());
		}

	}

	public String anyadirProd() {
		this.tarea = "Añadir";
		if (getProducto() != null) {
			this.productorAux = new Producto(getProducto().getId(), getProducto().getNombre(),
					getProducto().getDescripcion());
		}
		setProducto(new Producto());
		return "AnydirEditarProd";
	}

	public String accionProd() {
		if (this.tarea.equals("Añadir")) {
			modelo.alta(getProducto());
		} else {
			modelo.modificacion(getProducto());
		}
		return "loginGerente";
	}

	public String revision() {
		if (getProducto() == null)
			setProducto(productorAux);
		if (getProveedor() == null)
			setProveedor(proveedorAux);
		return "loginGerente";
	}

	public String obtenerFecha() {
		if (getCompra() != null)
			return formatoFecha(getCompra().getFecha());
		return "";
	}

	public String formatoPrecio() {
		if (getCompra() != null)
			return getCompra().getPrecio() + "€";
		return "";
	}

	public String[] getSelectProv() {
		return selectProv;
	}

	public void setSelectProv(String[] selectProv) {
		this.selectProv = selectProv;
	}

	public String[] getSelectProducto() {
		return selectProducto;
	}

	public void setSelectProducto(String[] selectProducto) {
		this.selectProducto = selectProducto;
	}

	public String[] getSelectCompra() {
		return selectCompra;
	}

	public void setSelectCompra(String[] selectCompra) {
		this.selectCompra = selectCompra;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	

}

package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.faces.model.SelectItem;

import dominio.Compra;
import dominio.Producto;
import dominio.Proveedor;
import modelo.Modelo;

public class CEmpleado extends Control {

	private String selectProducto;
	private String selectProv;
	private float[] precios;
	private int cantidad = 1;
	private float precio;
	private Modelo modelo;

	@Override
	public String preparaPagina() {
		setProveedores((ArrayList<Proveedor>) modelo.consultaProveedores());
		setProductos((ArrayList<Producto>) modelo.consultaProductos());
		for (Proveedor p : getProveedores()) {
			p.setCompras(new ArrayList<Compra>());
		}
		for (Producto p : getProductos()) {
			p.setCompras(new ArrayList<Compra>());
		}
		super.nombreItemsProv();
		super.nombreItemsProduct();
		precios = new float[getProductos().size()];
		for (int i = 0; i < precios.length; i++) {
			precios[i] = (float) (Math.random() * 500) + 50;
		}
		return "loginEmpleado";
	}

	public void seleccionProveedor() {
		try {
			for (Proveedor p : getProveedores()) {
				if (p.getNombre().equals(this.selectProv)) {
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
			int i = 0;
			for (Producto p : getProductos()) {
				if (p.getNombre().equals(this.selectProducto)) {
					setProducto(new Producto(p.getId(), p.getNombre(), p.getDescripcion()));
					getProducto().setCompras(new ArrayList<Compra>());
					this.precio = this.precios[i];
				}
				i++;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void addCompra() {
		if (getProducto().getId() != 0 && getProveedor().getId() != 0) {
			System.out.println("" + getProducto().getId() + "," + getProveedor().getId() + "," + this.cantidad + ","
					+ getPrecioTotal());
			Compra compra = new Compra(this.cantidad, getPrecioTotal(), new GregorianCalendar(), getProducto(),
					getProveedor());
			modelo.alta(compra);
		}
	}

	private static Collection<SelectItem> cantidadItems;
	static {
		cantidadItems = new ArrayList<SelectItem>();
		cantidadItems.add(new SelectItem(null, "Selecciona una Cantidad", "", false, false, true));
		for (int i = 1; i <= 100; ++i)
			cantidadItems.add(new SelectItem(i));
	}

	public float getPrecioTotal() {
		return this.cantidad * this.precio;
	}

	public String precioToString() {
		return String.format("%.2f€", this.precio);
	}

	public String precioTotalToString() {
		return String.format("%.2f€", getPrecioTotal());
	}

	public String getSelectProducto() {
		return selectProducto;
	}

	public void setSelectProducto(String selectProducto) {
		this.selectProducto = selectProducto;
	}

	public String getSelectProv() {
		return selectProv;
	}

	public void setSelectProv(String selectProv) {
		this.selectProv = selectProv;
	}

	public float[] getPrecios() {
		return precios;
	}

	public void setPrecios(float[] precios) {
		this.precios = precios;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Collection<SelectItem> getCantidadItems() {
		return cantidadItems;
	}

	public void setCantidadItems(Collection<SelectItem> cantidadItems) {
		CEmpleado.cantidadItems = cantidadItems;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

}
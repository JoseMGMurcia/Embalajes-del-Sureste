/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tcompras")
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private int id;
	@Basic(optional = false)
	@Column(name = "Cantidad")
	private int cantidad;
	@Basic(optional = false)
	@Column(name = "Precio")
	private double precio;
	@Basic(optional = false)
	@Column(name = "Fecha")
	private GregorianCalendar fecha;
	@JoinColumn(name = "IdProducto", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Producto producto;
	@JoinColumn(name = "IdProveedor", referencedColumnName = "Id")
	@ManyToOne(optional = false)
	private Proveedor proveedor;

	public Compra() {
	}

	public Compra(int cantidad, double precio, GregorianCalendar fecha, Producto producto, Proveedor proveedor) {
		super();
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
		this.producto = producto;
		this.proveedor = proveedor;
	}

	public Compra(int id, int cantidad, double precio, GregorianCalendar fecha, Producto producto,
			Proveedor proveedor) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
		this.producto = producto;
		this.proveedor = proveedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + this.id;
		hash = 67 * hash + this.cantidad;
		hash = 67 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
		hash = 67 * hash + Objects.hashCode(this.producto);
		hash = 67 * hash + Objects.hashCode(this.proveedor);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Compra other = (Compra) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "dominio.Compra[ id=" + id + " ]";
	}

}

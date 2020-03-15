/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tproveedores")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private int id;
	@Basic(optional = false)
	@Column(name = "Nombre")
	private String nombre;
	@Basic(optional = false)
	@Column(name = "Telefono")
	private String telefono;
	@Basic(optional = false)
	@Column(name = "Contacto")
	private String contacto;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
	private List<Compra> compras;

	public Proveedor() {
	}

	public Proveedor(String nombre, String telefono, String contacto) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.contacto = contacto;
	}

	public Proveedor(int id, String nombre, String telefono, String contacto) {
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.contacto = contacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + this.id;
		hash = 67 * hash + Objects.hashCode(this.telefono);
		hash = 67 * hash + Objects.hashCode(this.contacto);
		hash = 67 * hash + Objects.hashCode(this.compras);
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
		final Proveedor other = (Proveedor) obj;
		if (this.id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", contacto=" + contacto
				+ ", compras=" + compras + '}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

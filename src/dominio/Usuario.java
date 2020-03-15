package dominio;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tusuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "Id")
	private int id;

	@Basic(optional = false)
	@Column(name = "Login")
	private String login;

	@Basic(optional = false)
	@Column(name = "Apellidos")
	private String apellidos;

	@Basic(optional = false)
	@Column(name = "Pass")
	private String pass;

	@Basic(optional = false)
	@Column(name = "Rol")
	private String rol;

	@Basic(optional = false)
	@Column(name = "Habilitado")
	private int habilitado;

	public Usuario() {

	}

	public Usuario(String login, String apellidos, String pass, String rol, int habitlitado) {
		super();
		this.login = login;
		this.apellidos = apellidos;
		this.pass = pass;
		this.rol = rol;
		this.habilitado = habitlitado;
	}

	public Usuario(int id, String login, String apellidos, String pass, String rol, int habitlitado) {
		super();
		this.id = id;
		this.login = login;
		this.apellidos = apellidos;
		this.pass = pass;
		this.rol = rol;
		this.habilitado = habitlitado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public int getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}

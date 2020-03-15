package control;

import java.util.ArrayList;

import javax.faces.model.SelectItem;

import dominio.Producto;
import dominio.Usuario;
import modelo.Modelo;

public class CUsuarios extends Control {

	private Modelo modelo;

	private String[] selectUser;
	private boolean add;
	private Usuario userAux;
	private String repeatedPass;
	private boolean empleado, habilitado;
	private String tarea;

	@Override
	public String preparaPagina() {
		setUsuarios((ArrayList<Usuario>) modelo.consultaUsuarios());
		super.nombreItemsUser();
		return "userEditor";
	}

	public void seleccionUsuario() {
		try {
			for (Usuario u : getUsuarios()) {
				if (u.getLogin().equals(this.selectUser[0].substring(0,this.selectUser[0].indexOf(",")))) {
					setUsuario(new Usuario(u.getId(), u.getLogin(), u.getApellidos(), u.getPass(), u.getRol(), u.getHabilitado()));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String anyadirUser() {
		this.tarea = "Añadir";
		this.add = true;
		if (getUsuario() != null) {
			this.userAux = new Usuario(getUsuario().getLogin(),getUsuario().getApellidos(), getUsuario().getPass(), getUsuario().getRol(),
					getUsuario().getHabilitado());
		}
		setUsuario(new Usuario());
		return "AnydirEditarUser";
	}

	public void eliminarUser() {

		if (getUsuario() != null) {
			modelo.baja(getUsuario());
		}
	}

	public String editarUser() {
		try {
			if (getUsuario().getLogin() != null) {
				this.tarea = "Modificar";
				this.add = false;
				if (getUsuario().getRol().equals("ROLE_USER"))
					this.empleado = true;
				else
					this.empleado = false;
				if (getUsuario().getHabilitado() == 1)
					this.habilitado = true;
				else
					this.habilitado = false;
				return "AnydirEditarUser";
			}
		} catch (Exception e) {
		}
		return "userEditor";
	}

	public String accionUser() {
		if(this.empleado)getUsuario().setRol("ROLE_USER");
		else getUsuario().setRol("ROLE_ANONYMOUS");
		if(this.habilitado)getUsuario().setHabilitado(1);
		else getUsuario().setHabilitado(0);
		if (this.add && getUsuario().getPass().equals(this.repeatedPass)) {
			this.getUsuario().setPass(super.toMD5(this.getUsuario().getPass()));
			modelo.alta(getUsuario());
		} else {
			modelo.modificacion(getUsuario());
		}
		return "userEditor";
	}

	public String revision() {
		if (getUsuario() == null)
			setUsuario(userAux);
		return "userEditor";
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String[] getSelectUser() {
		return selectUser;
	}

	public void setSelectUser(String[] selectUser) {
		this.selectUser = selectUser;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

	public Usuario getUserAux() {
		return userAux;
	}

	public void setUserAux(Usuario userAux) {
		this.userAux = userAux;
	}

	public String getRepeatedPass() {
		return repeatedPass;
	}

	public void setRepeatedPass(String repeatedPass) {
		this.repeatedPass = repeatedPass;
	}

	public boolean isEmpleado() {
		return empleado;
	}

	public void setEmpleado(boolean empleado) {
		this.empleado = empleado;
	}


	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	

}

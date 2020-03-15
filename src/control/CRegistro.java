package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.logging.Level;

import javax.faces.model.SelectItem;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dominio.Usuario;
import modelo.Modelo;

public class CRegistro extends Control {

	private String login;
	private String apellidos;
	private String pass1;
	private String pass2;
	private String mensaje;
	private String email;
	private Modelo modelo;

	public String[] sexItems = { "Masculino", "Femenino", "No especificado" };

	private static Collection<SelectItem> birthYears;
	static {
		int año = new GregorianCalendar().get(GregorianCalendar.YEAR);
		birthYears = new ArrayList<SelectItem>();
		birthYears.add(new SelectItem(null, "Selecciona un año:", "", false, false, true));
		for (int i = año - 65; i < año - 18; ++i)
			birthYears.add(new SelectItem(i));
	}

	public String comprobarRegristro() {
		if (login != null && pass1.equals(pass2) && alta()) {
			enviarMail(false);
			return "index";
		}
		return "registro";
	}

	public boolean alta() {
		Usuario u = new Usuario(this.login,this.apellidos, this.toMD5(this.pass1), "ROLE_ANONYMOUS", 1);
		if (!modelo.alta(u)) {
			return false;
		}
		return true;
	}

	@Override
	public String preparaPagina() {
		// TODO Auto-generated method stub
		return null;
	}

	public void enviarMail(boolean contacto) {
		Properties propiedad = new Properties();
		propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
		propiedad.setProperty("mail.smtp.starttls.enable", "true");
		propiedad.setProperty("mail.smtp.port", "587");
		propiedad.setProperty("mail.smtp.auth", "true");

		Session sesion = Session.getDefaultInstance(propiedad);
		
		String mensaje;
		String asunto;
		
		if (contacto) {
			mensaje = String.format("De: %s\nMensaje: %s",this.email,this.mensaje);
			asunto = "Mensaje de Usuario";
		} else {
			mensaje = String.format("Tiene una nueva solicitud de registro del Usuario: %s", this.login);
			asunto = "Solucitud de registro";
		}
		
		String correoEnvia = "embalajesdelsureste2@gmail.com";
		String contrasena = "Es/12345";
		String receptor = "embalajesdelsureste2@gmail.com";
		

		MimeMessage mail = new MimeMessage(sesion);
		try {
			mail.setFrom(new InternetAddress(correoEnvia));
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
			mail.setSubject(asunto);
			mail.setText(mensaje);

			Transport transportar = sesion.getTransport("smtp");
			transportar.connect(correoEnvia, contrasena);
			transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			transportar.close();

		} catch (AddressException ex) {

		} catch (MessagingException ex) {

		}

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String[] getSexItems() {
		return sexItems;
	}

	public void setSexItems(String[] sexItems) {
		this.sexItems = sexItems;
	}

	public Collection<SelectItem> getYearItems() {
		return birthYears;
	}

	public void setYearItems(Collection<SelectItem> yearItems) {
		CRegistro.birthYears = yearItems;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	

}

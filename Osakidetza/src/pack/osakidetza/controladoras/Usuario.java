package pack.osakidetza.controladoras;

public class Usuario {

	private String nombre;
	private String email;

	public Usuario(String pNombre,String pEmail) {
		this.nombre=pNombre;
		this.email=pEmail;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}	

	
}

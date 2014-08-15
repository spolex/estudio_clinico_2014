package pack.osakidetza.controladoras;

public class Usuario {

	private String nombre;
	private String email;
	private String pass;
	private String especialidad;

	public Usuario(String pNombre,String pEmail, String pEsp) {
		this.nombre=pNombre;
		this.email=pEmail;
		this.pass="";
		this.especialidad=pEsp;
	}

	public String getNombre() {
		return nombre;
	}

	public String getEmail() {
		return email;
	}	
	
	public String getPass(){
		return this.pass;
	}
	
	public void resetPass(){
		this.setPass("");
	}
	
	public void setPass(String pPass){
		this.pass=pPass;
	}
	
	public String getEsp(){
		return this.especialidad;
	}
	
}

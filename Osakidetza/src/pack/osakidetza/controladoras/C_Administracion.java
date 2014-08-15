package pack.osakidetza.controladoras;

import java.util.ArrayList;

public class C_Administracion {
	
	private static C_Administracion miAdmin=new C_Administracion();
	
	private C_Administracion() {
	}

	public static C_Administracion getMiAdmin() {
		return miAdmin;
	}

	public String identificarse(String pNombre, String pPass) {		
		return CatalogoUsuarios.getMisUsuarios().identificarse(pNombre, pPass);
	}

	public boolean cambiarPass(String pUsuario, String pPass, String pPassNueva, String pPregunta, String pResp) {
		return CatalogoUsuarios.getMisUsuarios().cambiarPass(pUsuario, pPass, pPassNueva, pPregunta, pResp);
	
	}

	public boolean restablecerPass(String pEmail, String pRespSeg,
			String pNuevoPass) {
				return CatalogoUsuarios.getMisUsuarios().restablecerPass(pEmail, pRespSeg, pNuevoPass);
	}

	public boolean addUsuario(String pNom,String pEmail,String pEsp, String pPass, String pEsmedico, String pNomAdmin){
		return CatalogoUsuarios.getMisUsuarios().addUsuario(pNom, pEmail, pEsp, pPass, pEsmedico, pNomAdmin);
	}
	
	public ArrayList<Usuario> listarMedicos()
	{
		return CatalogoUsuarios.getMisUsuarios().listarMedicos();
	}

	public boolean actualizarUsuario(String pNom, String pEmailViejo,String pEmailNuevo, String pEspec) {
				return CatalogoUsuarios.getMisUsuarios().actualizarUsuario(pNom,pEmailViejo,pEmailNuevo,pEspec);
	}

	public boolean darDeBajaUsuario(String pNom, String pEmail){
		return CatalogoUsuarios.getMisUsuarios().darDeBajaUsuario(pEmail, pNom);
	}
	
	public String obtenerPregunta(String pEmail){
		return CatalogoUsuarios.getMisUsuarios().obtenerPregunta(pEmail);
	}

	public Usuario obtenerUsuario(String pEmail) {
		return CatalogoUsuarios.getMisUsuarios().obtenerUsuario(pEmail);
	}
	
	

}

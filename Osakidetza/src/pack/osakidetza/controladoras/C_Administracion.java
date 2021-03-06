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

	public boolean addUsuario(Usuario pUser,String pNomAdmin){
		return CatalogoUsuarios.getMisUsuarios().addUsuario(pUser, pNomAdmin);
	}
	
	public ArrayList<Usuario> listarMedicos()
	{
		return CatalogoUsuarios.getMisUsuarios().listarMedicos();
	}

	public boolean actualizarUsuario(String pEmailViejo,String pEmailNuevo,String pNombreNuevo, String pEspec) {
				return CatalogoUsuarios.getMisUsuarios().actualizarUsuario(pEmailViejo,pEmailNuevo,pNombreNuevo,pEspec);
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

	public String identificarseEmail(String pEmail, String pPass) {
		return CatalogoUsuarios.getMisUsuarios().identificarseEmail(pEmail, pPass);
	}

	public boolean darDeAltaUsuario(Usuario user, String pAdmin) {
		return CatalogoUsuarios.darDeAltaUsuario(user, pAdmin);
	}
	
	

}

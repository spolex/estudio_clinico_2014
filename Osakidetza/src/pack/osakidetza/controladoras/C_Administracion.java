package pack.osakidetza.controladoras;

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

	/*public Usuario existeUsuario(String pNom) {
		throw new UnsupportedOperationException();
	}*/

	public boolean addUsuario(String pNom, String pPass, String pEsmedico,
			String pEsAdmin) {
				return false;
	}

	public boolean borrarUsuario(String pNom, String pPass){
		throw new UnsupportedOperationException();
	}
	
	public String obtenerPregunta(String pEmail){
		return CatalogoUsuarios.getMisUsuarios().obtenerPregunta(pEmail);
	}

}

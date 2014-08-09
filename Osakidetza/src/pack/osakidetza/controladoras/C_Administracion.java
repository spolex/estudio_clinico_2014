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

	public boolean cambiarPass(String pUsuario, String pPass, String pPassNueva) {
		return false;
	
	}

	public boolean recuperarPass(String pNomUsuario, String pRespSeg,
			String pNuevoPass) {
				return false;
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

}

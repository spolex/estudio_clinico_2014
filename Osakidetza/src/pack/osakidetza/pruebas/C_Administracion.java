package pack.osakidetza.pruebas;

import javax.swing.Spring;

public class C_Administracion {

	private C_Administracion miAdmin;

	private C_Administracion() {
	}

	public C_Administracion getMiAdmin() {
		return miAdmin;
	}

	public String identificarse(String pNombre, String pPass) {
		return pPass;
		
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

	public boolean borrarUsuario(String pNom, String pPass) {
		throw new UnsupportedOperationException();
	}
}

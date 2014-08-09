package pack.osakidetza.controladoras;

import java.util.ArrayList;

import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

public class CatalogoUsuarios {

	private ArrayList<Usuario> listaUsuarios;
	private static CatalogoUsuarios misUsuarios = new CatalogoUsuarios();

	private CatalogoUsuarios() {		
	}

	public static CatalogoUsuarios getMisUsuarios() {
		return misUsuarios;
	}
/**
 * @pre Recibe como parametro el nombre del usuario y la clave
 * @post Si existe el usuario con la clave devuelve true, en caso contrario false. 
 * @param pNombre
 * @param pPass
 * @return boolean
 */
	public String identificarse(String pNombre, String pPass) {
		String rdo = null;	
		ResultadoSQL rdoSQL = SGBD.getSGBD().consultaSQL("SELECT esAdmin FROM Usuario  WHERE Usuario.nombre='" +pNombre+"' AND Usuario.pass=sha1('" +pPass+ "')");
		if(rdoSQL.next()){
		rdo = rdoSQL.get("esAdmin");
		rdoSQL.close();
		}
		return rdo;		
	}

	/*public boolean cambiarPass(string pPass, string pUsuario,
			string pPassNueva, string pAsk, string pResp) {
		throw new UnsupportedOperationException();
	}*/

	/*public boolean recuperarPass(string pNomUsuario, string pRespSeg,
			string pNuevoPass) {
		throw new UnsupportedOperationException();
	}*/

	/*public boolean addUsuario(string pNom, string pPass, string pEsmedico,
			string pEsAdmin) {
		throw new UnsupportedOperationException();
	}
*/
	/*public boolean borrarUsuario(string pNom, string pPass) {
		throw new UnsupportedOperationException();
	}*/

	/*public string obtenerPregunta(string pNom) {
		throw new UnsupportedOperationException();
	}*/
}

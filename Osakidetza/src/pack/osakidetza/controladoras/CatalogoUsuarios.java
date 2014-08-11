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
	
	/**
	 * @pre Recibe como parametro el nombre del usuario y la clave
	 * @post Si existe el usuario con la clave devuelve true, en caso contrario false. 
	 * @param pNombre
	 * @param pPass
	 * @return boolean
	 */
		public String identificarseEmail(String pEmail, String pPass) {
			String rdo = null;	
			ResultadoSQL rdoSQL = SGBD.getSGBD().consultaSQL("SELECT esAdmin FROM Usuario  WHERE Usuario.pEmail='" +pEmail+"' AND Usuario.pass=sha1('" +pPass+ "')");
			if(rdoSQL.next()){
			rdo = rdoSQL.get("esAdmin");
			rdoSQL.close();
			}
			return rdo;		
		}
	/**
	 * pre:Recibe por parámetros el nombre y la contraseña para poder identificarse, además de la pregunta de seguridad nueva y su correspondiente respuesta.
	 * post:Cambia la contraseña del usuario y además actualiza la pregunta y respuesta de seguridad.
	 * @param pPass
	 * @param pUsuario
	 * @param pPassNueva
	 * @param pAsk
	 * @param pResp
	 * @return
	 */
	public boolean cambiarPass(String pUsuario,String pPass,
			String pPassNueva, String pAsk, String pResp) {
		if(CatalogoUsuarios.getMisUsuarios().identificarse(pUsuario,pPass) != null){
				SGBD.getSGBD().execSQL("UPDATE Usuario SET pass = sha1('"+ pPassNueva+ "'), "
						+ "pregunta='" +pAsk+ "', respuesta='" +pResp+ "' "
						+ "WHERE nombre='"+pUsuario+"' AND pass = sha1('" +pPass+ "')");			
		}
		/*
		 * Como  execSQL no  permite comprobar si se ha efectuado el cambio, comprobamos que 
		 * la contraseña se ha actualizado correctamente mediante el método identificarse(nombre,pass).
		 */		
		
		return CatalogoUsuarios.getMisUsuarios().identificarse(pUsuario, pPassNueva) != null ;
	}
	
	/**
	 *pre:recibe el nombre de usuario como parámetro.
	 *post: devuelve la pregunta de segurida del usuario. Si el ID es incorrecto devuelve null. 
	 * @param pNombre
	 * @return
	 */
	public String obtenerPregunta(String pEmail)
	{		
		
		String rdo=null;
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT pregunta FROM Usuario WHERE email='" + pEmail +"'");
		if(RdoSQL.next())
		rdo=RdoSQL.get("pregunta");
		RdoSQL.close();
		return rdo;
	}
    /**
     * pre:el usuario existe y está registrado con el email que se recibe como parámetro,además se recibe la respuesta a la pregunta de seguridad.
     * post: si la respuesta es correcta se actualiza la contraseña con la que se recibe por parámetro.
     * @param pEmail
     * @param pRespSeg
     * @param pNuevoPass
     * @return true en caso de actualizarse la contraseña, en otro caso false.
     */
	public boolean restablecerPass(String pEmail, String pRespSeg,
			String pNuevoPass) 
	{
		ResultadoSQL rdoSQL=SGBD.getSGBD().consultaSQL("SELECT respuesta FROM Usuario WHERE email='"+pEmail+"'");
		if(rdoSQL.next())
		{
			if(rdoSQL.get("respuesta").equals(pRespSeg)){
				SGBD.getSGBD().execSQL("UPDATE Usuario SET pass = sha1('"+ pNuevoPass+ "') WHERE email = '" +pEmail+ "'");	
			}
		}		
		return CatalogoUsuarios.getMisUsuarios().identificarseEmail(pEmail, pNuevoPass)!=null;
	}

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

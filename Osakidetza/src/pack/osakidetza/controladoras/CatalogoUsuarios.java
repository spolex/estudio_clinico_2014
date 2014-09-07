package pack.osakidetza.controladoras;

import java.util.ArrayList;
import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

public class CatalogoUsuarios {

	@SuppressWarnings("unused")
	private ArrayList<Usuario> listaUsuarios;
	private static CatalogoUsuarios misUsuarios = new CatalogoUsuarios();
	public static int max = 100;//El máximo de usuarios que soporta el sistema.
	 

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
		ResultadoSQL rdoSQL = SGBD.getSGBD().consultaSQL("SELECT esAdmin,activo FROM Usuario  WHERE Usuario.nombre='" +pNombre+"' AND Usuario.pass=sha1('" +pPass+ "')");
		if(rdoSQL.next()){
			if(rdoSQL.getBoolean("activo")){
				rdo = rdoSQL.get("esAdmin");
			}
		}
		rdoSQL.close();
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
			ResultadoSQL rdoSQL = SGBD.getSGBD().consultaSQL("SELECT esAdmin,activo FROM Usuario  WHERE email='" +pEmail+ "' AND pass = sha1('" +pPass+ "')");
			if(rdoSQL.next()){
				if(rdoSQL.getBoolean("activo")){
					rdo = rdoSQL.get("esAdmin");
				}
			}
			rdoSQL.close();
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
		{
			rdo=RdoSQL.get("pregunta");
		}
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
	
		ResultadoSQL rdoSQL=SGBD.getSGBD().consultaSQL("SELECT respuesta FROM Usuario WHERE email='" +pEmail+ "'");
		
		if(rdoSQL.next())
		{
			if(rdoSQL.get("respuesta").equalsIgnoreCase(pRespSeg))
			{
				SGBD.getSGBD().execSQL("UPDATE Usuario SET pass = sha1('"+pNuevoPass+ "') WHERE email = '" +pEmail+ "'");
				rdoSQL.close();
				return true;
			}
		}
		rdoSQL.close();
		return false;
	}

	/**
	 * pre:recibe por parámetros los datos del usuario que quiere añadir.
	 * post:si no existe se añade un nuevo usuario en el sistema.
	 * @param pNom
	 * @param pEmail
	 * @param pEsp
	 * @param pPass
	 * @param pEsmedico
	 * @param pNomAdmin
	 * @return true si se añade, en otro caso false.
	 */
	public boolean addUsuario(Usuario pUser, String pNomAdmin) {
		String nombre = existeUsuario(pUser.getEmail());
		if(nombre == null)
		{
			SGBD.getSGBD().execSQL("INSERT INTO Usuario(nombre, pass, email, esMedico, especialidad, nombreAdmin) "
					+ "VALUES('" + pUser.getNombre() + "', sha1('" + pUser.getPass() + "'), '" + pUser.getEmail() + "', 1, '" + pUser.getEsp() + "','"+ pNomAdmin +"')");
			return existeUsuario(pUser.getEmail()) !=null;
		}	
		return false;		
	}
	
	/**
	 * pre:recibe por parámetros el email que se quiere verificar si está registrado en el sistema.
	 * post:
	 * @param pEmail
	 * @return si existe devuelve el nombre del usuario, en otro caso NULL.
	 */
	private String existeUsuario(String pEmail){
		ResultadoSQL rdoSQL = SGBD.getSGBD().consultaSQL("SELECT nombre FROM Usuario WHERE email='" +pEmail+ "'");
		if(rdoSQL.next()){
			return rdoSQL.get("nombre");
		}
		return null;
		}
	
	/**
	 * pre:recibe por parámetro el email y el nombre del usuario que se quiere dar de baja en el sistema.
	 * post: si está activo se da de baja (esAdmin=0 y esMedico=0).
	 * @param pEmail
	 * @param pNom
	 * @return true si no está activo o si se consigue dar de baja, false en otro caso.
	 */
	
	public boolean darDeBajaUsuario(String pEmail, String pNom) 
	{
		if(existeUsuario(pEmail) != null && estaActivo(pEmail)){
			SGBD.getSGBD().execSQL("UPDATE Usuario SET esAdmin=0, esMedico=0 WHERE email='" +pEmail+ "'");
		}
		return !estaActivo(pEmail);
	}
	
	/**
	 * pre:recibe por parémetro el email del usuario que se quiere verificar si está dado de alta en el sistema.
	 * post:si existe y es administrador o médico está activo, en otro caso no.
	 * @param pEmail
	 * @return true si es admin o médico, false en otro caso. 
	 */
	private boolean estaActivo(String pEmail){
		ResultadoSQL rdoSQL = SGBD.getSGBD().consultaSQL("Select esMedico,esAdmin FROM Usuario WHERE email='"+pEmail+"'");
		if(rdoSQL.next()){
			return (rdoSQL.get("esAdmin").equals("1") || rdoSQL.get("esMedico").equals("1"));
		}
		return false;
	}
	/**
	 * 
	 * @return la lista de los usuarios registrados como médicos.
	 */
	public ArrayList<Usuario> listarMedicos() {
		ArrayList<Usuario> pListaUsuarios =new ArrayList<Usuario>();
		
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT * FROM Usuario WHERE esMedico=1");			
			while(RdoSQL.next())			
			{	
				Usuario nUsuario = new Usuario(RdoSQL.get("nombre"),RdoSQL.get("email"),"");
				pListaUsuarios.add(nUsuario);	
				
			}
			RdoSQL.close();
		
		return pListaUsuarios;
	}
	
	/**
	 * pre:recibe el email del usuario que desea obtener
	 * pos:obtiene el usuario con el email recibido por parámetros.
	 * @param pEmail
	 * @return 
	 */
	public Usuario obtenerUsuario(String pEmail) 
	{
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("Select * FROM Usuario WHERE email = '" +pEmail+ "'");
		if(RdoSQL.next()){
			return new Usuario(RdoSQL.get("nombre"),pEmail, RdoSQL.get("especialidad"));
		}
		return null;
	}
	/**
	 * pre: el usuario a actualizar es el correspondiente con el email.
	 * @param pEmailViejo
	 * @param pEmailNuevo
	 * @param pNomNuevo
	 * @param pEspec
	 * @return true si se consiguen actualizar los datos, false en otro caso.
	 */
	public boolean actualizarUsuario(String pEmailViejo,String pEmailNuevo, String pNomNuevo,String pEspec) {
		
		SGBD.getSGBD().execSQL("UPDATE Usuario SET nombre='"+pNomNuevo+"', email='"+pEmailNuevo+"', especialidad='"+pEspec+"' WHERE email='" +pEmailViejo+ "'");
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL("SELECT nombre FROM Usuario WHERE email='" +pEmailNuevo+ "'");
		if(RdoSQL.next()){
			boolean rdo= pNomNuevo.equals(RdoSQL.get("nombre"));
			RdoSQL.close();
			return rdo;
		}
		return false;		
	}
	/**
	 * pre: el usuario existe en el sistema y se corresponde con el email.
	 * @param user
	 * @param pAdmin
	 * @return
	 */
	public static boolean darDeAltaUsuario(Usuario user, String pAdmin) {
		return SGBD.getSGBD().execSQL("UPDATE Usuario SET esMedico = '1', nombreAdmin = '"+pAdmin+"' WHERE email = '"+user.getEmail()+"'");
		
	}
}

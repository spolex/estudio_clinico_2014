package pack.osakidetza.controladoras;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

public class CatalogoPacientes {

	private static CatalogoPacientes misPacientes = new CatalogoPacientes();
	
	private CatalogoPacientes() {
		
	}
	
	public static CatalogoPacientes getPacientes(){
		return misPacientes;
	}

	/**
	 * pre:recibe todos los datos necesarios para dar de alta en el sistema un paciente.El número de historial no está registrado en el sistema.
	 * post:registra un nuevo paciemte con todos sus datos.
	 * @param pNom
	 * @param pHist
	 * @param cI
	 * @param sexo
	 * @param criteriosCI
	 * @param numFamilia
	 * @param familiarCi
	 * @param relacionCi
	 * @param fechaNacimiento
	 * @param lugarNace
	 * @param origenMaterno
	 * @param origenPaterno
	 * @param fechaSeguimiento
	 * @param anovulatorios
	 * @param numGest
	 * @param fechaPrimerEmbarazo
	 * @param fechaMenopausia
	 * @param fechaMenarquia
	 * @return true en caso de poder dar de alta al paciente en el sistema, false en otro caso.
	 */
	public boolean addPaciente(String pNom, String pHist, String cI, String sexo, String histCI,
			String criteriosCI, String numFamilia, String familiarCi,
			String relacionCi, String fechaNacimiento, String lugarNace,
			String origenMaterno, String origenPaterno,
			String fechaSeguimiento, String anovulatorios, String numGest,
			String fechaPrimerEmbarazo, String fechaMenopausia, String fechaMenarquia) {
		
		int numGes= Integer.parseInt(numGest);
		
		SGBD.getSGBD().execSQL("INSERT INTO Paciente(historial, nombre, fechaAlta, casoIndice, sexo, criteriosCI,numeroFamilia, familiarCI, relacionCI"
				+ ", lugarNacimiento, origenMaterno, origenPaterno, consumoAnovulatorios, numeroGestaciones)"
				+ "VALUES('"+pHist+"','"+pNom+"','"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"'"
				+ ", '"+cI+"', '"+sexo+"', '"+criteriosCI+"', '"+numFamilia+"','"+familiarCi+"', '"+relacionCi+"','"+lugarNace+"','"+origenMaterno+"', '"+origenPaterno+"', '"+anovulatorios+"','"+numGes+"')");
		
		
		if(!fechaNacimiento.equals("")){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET fechaNacimiento = '"+fechaNacimiento+"' WHERE historial = '"+pHist+"'");
		}
		
		if(!fechaSeguimiento.equals("")){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET fechaSeguimiento = '"+fechaSeguimiento+"' WHERE historial = '"+pHist+"'");
		}
		
		if(!fechaPrimerEmbarazo.equals("")){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET primerEmbarazo = '"+fechaPrimerEmbarazo+"' WHERE historial = '"+pHist+"'");
			
			if(!fechaMenarquia.equals("")){
				SGBD.getSGBD().execSQL("UPDATE Paciente SET menarquia = '"+fechaMenarquia+"' WHERE historial = '"+pHist+"'");
			}
		}
		
		if(!fechaMenopausia.equals("")){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET menopausia = '"+fechaMenopausia+"' WHERE historial = '"+pHist+"'");
		}
		
		if(!numFamilia.equals("")){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET numeroFamilia = '"+numFamilia+"' WHERE historial = '"+pHist+"'");
		}
		
		if(!histCI.equals("")){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET historialCI = '"+histCI+"' WHERE historial = '"+pHist+"'");
		}
		
		return buscarPaciente(pHist)!=null;
	}

	/**
	 * pre:
	 * post:comprueba si el paciente con el número de historial recibido como parámetro existe en el sistema.
	 * @param pHist
	 * @return retorna el nº historial si existe en el sistema, null en otro caso.
	 */
	public String buscarPaciente(String pHist) {
		
		String encontrado = null;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT historial FROM Paciente WHERE historial = '"+pHist+"'");
		if(RdoSQL.next()){
			encontrado = RdoSQL.get("historial");
			RdoSQL.close();
		}
		return encontrado;
	}
	
	/**
	 * pre: el paciente existe en el sistema.
	 * @param historial
	 * @return
	 */
	public boolean borrarPaciente(String historial) {
		
		SGBD.getSGBD().execSQL("UPDATE Paciente SET activo = 0 WHERE historial = '" +historial+"'");
		
		return buscarPaciente(historial)!=null;
	}
	
	/**
	 * pre:
	 * post:obtiene la lista de todos los pacientes que son caso índice.
	 * @return lista pacientes que son caso índice.
	 */
	public ArrayList<String> listarCasosIndice(){
		
		ArrayList<String> listaCI = new ArrayList<String>();
		
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT historial from Paciente WHERE casoIndice = 'si'");
		while(RdoSQL.next()){
			listaCI.add(RdoSQL.get("historial"));
		}
		
		return listaCI;
	}
	
	/**
	 * 
	 * @return todos los pacientes ACTIVOS en el sistema.
	 */
	public ArrayList<String> listarPacientes() {
		
		ArrayList<String> listaPacientes = new ArrayList<String>();
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("Select historial FROM Paciente WHERE activo = '1' ORDER BY Paciente.historial ASC");
		while(RdoSQL.next()){
			listaPacientes.add(RdoSQL.get("historial"));
		}
		return listaPacientes;
	}

	/**
	 * 
	 * @param cI
	 * @return la lista de pacientes a partir de un caso índice
	 */
	public ArrayList<String> listarPacientesDado(String cI) {
		ArrayList<String> lista= new ArrayList<String>();
		
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT historial FROM Paciente WHERE historialCI = '"+cI+"'");
		while(RdoSQL.next()){
			lista.add(RdoSQL.get("historial"));
		}
		return lista;
	}

	/**
	 * pre:el paciente existe en el sistema.
	 * post:devuelve el paciente con el número de historial recibido como parámetro.
	 * @param historial
	 * @return paciente si el paciente existe, en otro caso null.
	 */
	public Paciente obtenerPaciente(String historial) {
		if(this.buscarPaciente(historial)!=null)
		{
			ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT * FROM Paciente WHERE historial = '"+historial+"'");
			if(RdoSQL.next())
			{
			String pNom = RdoSQL.get("nombre");
			String pCI = RdoSQL.get("casoIndice");
			String pSex = RdoSQL.get("sexo");
			String pCriterios = RdoSQL.get("criteriosCI");
			String pNumFam = RdoSQL.get("numeroFamilia");
			String pFamCI = RdoSQL.get("familiarCI");
			String pRelacionCI = RdoSQL.get("relacionCI");
			Date pFechaNace = RdoSQL.getDate("fechaNacimiento");
			String pHistCI = null;
 			if(RdoSQL.get("historialCI")!=null) {
				pHistCI = RdoSQL.get("historialCI");
			}
			String pLugNace = RdoSQL.get("lugarNacimiento");
			String pMater = RdoSQL.get("origenMaterno");
			String pPater = RdoSQL.get("origenPaterno");
			Date pSeguimiento= RdoSQL.getDate("fechaSeguimiento");
			String pAnovu = RdoSQL.get("consumoAnovulatorios");
			int pNumGest = RdoSQL.getInt("numeroGestaciones");
			Date pPrimer = RdoSQL.getDate("primerEmbarazo");
			Date pMeno = RdoSQL.getDate("menopausia");
			Date pMenar = RdoSQL.getDate("menarquia");
			RdoSQL.close();
			return new Paciente(pNom, historial, pCI, pSex, pCriterios, pNumFam, pFamCI, pRelacionCI, 
					pFechaNace, pHistCI, pLugNace, pMater, pPater, pSeguimiento, pAnovu, pNumGest, pPrimer, pMeno, pMenar);
			}
		}
		return null;
	}
	
		
	public void actualizarPaciente(Paciente pacienteCurrent) {
		
		String fechaNacimiento = "0000-00-00";
		if(pacienteCurrent.getFechaNace()!=null){ 
			fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").format(pacienteCurrent.getFechaNace());
					}
		String fechaSeguimiento = "0000-00-00";
		if(pacienteCurrent.getFechaSeguimiento()!=null) fechaSeguimiento = new SimpleDateFormat("yyyy-MM-dd").format(pacienteCurrent.getFechaSeguimiento());
		String primer = "0000-00-00"; 
		if(pacienteCurrent.getPrimerEmbarazo()!=null)primer= new SimpleDateFormat("yyyy-MM-dd").format(pacienteCurrent.getPrimerEmbarazo());
		String menopausia="0000-00-00";
		if(pacienteCurrent.getMenopausia()!=null) menopausia = new SimpleDateFormat("yyyy-MM-dd").format(pacienteCurrent.getMenopausia());
		String menarquia = "0000-00-00";
		if(pacienteCurrent.getMenarquia()!=null) menarquia = new SimpleDateFormat("yyyy-MM-dd").format(pacienteCurrent.getMenarquia());
		String orden = "UPDATE Paciente SET nombre ='"+pacienteCurrent.getNombre()+"', casoIndice = '"+pacienteCurrent.getCi().toString()+"', "+ 
						"sexo = '"+pacienteCurrent.getSexo().toString()+"', historialCI = '"+pacienteCurrent.getHistorialCI()+"', numeroFamilia = '"+pacienteCurrent.getNumFamilia()+"',"
						+ "familiarCI = '"+pacienteCurrent.getFamiliarCI().toString()+"', relacionCI = '"+pacienteCurrent.getRelacionCI()+"', "
						+ "fechaNacimiento = '"+fechaNacimiento+"', lugarNacimiento = '"+pacienteCurrent.getLugarNace()+"', origenMaterno = '"+pacienteCurrent.getOrigenMaterno()+"',"
						+ "origenPaterno = '"+pacienteCurrent.getOrigenPaterno()+"', fechaSeguimiento= '"+fechaSeguimiento+"', consumoAnovulatorios = '"+pacienteCurrent.getAnovulatorios()+"',"
						+ " numeroGestaciones = '"+pacienteCurrent.getNumGestaciones()+"', primerEmbarazo = '"+primer+"',"
						+ " menarquia = '"+menarquia+"', menopausia = '"+menopausia+"'"
						+ "WHERE historial= '"+pacienteCurrent.getHistorial()+"'";
		SGBD.getSGBD().execSQL(orden);
	}
}

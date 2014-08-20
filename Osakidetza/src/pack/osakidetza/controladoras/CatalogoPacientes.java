package pack.osakidetza.controladoras;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import pack.osakidetza.enumerados.Mama;
import pack.osakidetza.enumerados.TipoCancer;
import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

@SuppressWarnings("serial")
public class CatalogoPacientes extends ArrayList<Paciente>{

	private static CatalogoPacientes misPacientes = new CatalogoPacientes();
	
	private CatalogoPacientes() {
		
	}
	
	public static CatalogoPacientes getPacientes(){
		return misPacientes;
	}

	/**
	 * pre:recibe todos los datos necesarios para dar de alta en el sistema un paciente.El número de historial no está registrado en el sistema.
	 * post:registra un nuevo paciemte con todos sus datos y lo añade al catalogo en ejecución.
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
			String relacionCi, Date fechaNacimiento, String lugarNace,
			String origenMaterno, String origenPaterno,
			Date fechaSeguimiento, String anovulatorios, String numGest,
			Date fechaPrimerEmbarazo, Date fechaMenopausia, Date fechaMenarquia) {		
		
		int numGes= Integer.parseInt(numGest);
		
		SGBD.getSGBD().execSQL("INSERT INTO Paciente(historial, nombre, fechaAlta, criteriosCI, numeroFamilia"
				+ ", consumoAnovulatorios, numeroGestaciones)"
				+ "VALUES('"+pHist+"','"+pNom+"','"+new java.sql.Date(new Date().getTime())+"'"
				+ ", '"+criteriosCI+"', '"+numFamilia+"', '"+anovulatorios+"','"+numGes+"')");
		
		if(origenPaterno!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET origenPaterno = '"+origenPaterno+"' WHERE historial = '"+pHist+"'");
		}
		
		if(origenMaterno!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET origenMaterno = '"+origenMaterno+"' WHERE historial = '"+pHist+"'");
		}
		
		if(lugarNace!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET lugarNacimiento = '"+lugarNace+"' WHERE historial = '"+pHist+"'");
		}
		
		if(relacionCi!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET relacionCI = '"+relacionCi+"' WHERE historial = '"+pHist+"'");
		}
		
		if(familiarCi!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET familiarCI = '"+familiarCi+"' WHERE historial = '"+pHist+"'");
		}
		
		if(numFamilia!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET numeroFamilia = '"+numFamilia+"' WHERE historial = '"+pHist+"'");
		}
		
		if(sexo!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET sexo = '"+sexo+"' WHERE historial = '"+pHist+"'");
		}
		
		if(cI!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET casoIndice = '"+cI+"' WHERE historial = '"+pHist+"'");
		}
		
		if(numFamilia!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET numeroFamilia = '"+numFamilia+"' WHERE historial = '"+pHist+"'");
		}
		
		if(histCI!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET historialCI = '"+histCI+"' WHERE historial = '"+pHist+"'");
		}
		if(fechaNacimiento!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET fechaNacimiento = '"+new java.sql.Date(fechaNacimiento.getTime())+"' WHERE historial = '"+pHist+"'");
		}
		if(fechaSeguimiento!=null) {
			SGBD.getSGBD().execSQL("UPDATE Paciente SET fechaSeguimiento = '"+new java.sql.Date(fechaSeguimiento.getTime())+"' WHERE historial = '"+pHist+"'");
		}
		if(fechaPrimerEmbarazo!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET primerEmbarazo = '"+new java.sql.Date(fechaPrimerEmbarazo.getTime())+"' WHERE historial = '"+pHist+"'");
		}
		if(fechaMenopausia!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET menopausia = '"+new java.sql.Date(fechaMenopausia.getTime())+"' WHERE historial = '"+pHist+"'");
		}
		if(fechaMenarquia!=null) {
			SGBD.getSGBD().execSQL("UPDATE Paciente SET menarquia = '"+new java.sql.Date(fechaMenarquia.getTime())+"' WHERE historial = '"+pHist+"'");
		}
		
		if(buscarPaciente(pHist)!=null)
		{
			CatalogoPacientes.getPacientes().add(new Paciente(pNom, pHist, cI, sexo, criteriosCI, numFamilia, familiarCi, relacionCi, 
												fechaNacimiento, histCI, lugarNace, origenMaterno, 
												origenPaterno, fechaSeguimiento, anovulatorios, numGes, fechaPrimerEmbarazo, fechaMenopausia, fechaMenarquia));
			return true;
		}
		else{
			return false;
		}
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
		}
		RdoSQL.close();
		return encontrado;
	}
	
	/**
	 * pre: el paciente existe en el sistema.
	 * post:
	 * @param historial
	 * @return true si se borra del sistema, en otro caso false.
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
		RdoSQL.close();
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
		RdoSQL.close();
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
		RdoSQL.close();
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
	
	/**
	 * pre:actualiza los datos del paciente que recibe como parámetro.
	 * post:todos los datos del paciente se actualizan en el modelo.	
	 * @param pacienteCurrent
	 */
	public void actualizarPaciente(Paciente pacienteCurrent) {
		
		if(pacienteCurrent.getFechaNace()!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET fechaNacimiento = '"+new java.sql.Date(pacienteCurrent.getFechaNace().getTime())+"' WHERE historial = '"+pacienteCurrent.getHistorial()+"'");
		}
					
		
		if(pacienteCurrent.getFechaSeguimiento()!=null) {
			SGBD.getSGBD().execSQL("UPDATE Paciente SET fechaSeguimiento = '"+new java.sql.Date(pacienteCurrent.getFechaSeguimiento().getTime())+"' WHERE historial = '"+pacienteCurrent.getHistorial()+"'");
		}
		
		if(pacienteCurrent.getPrimerEmbarazo()!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET primerEmbarazo = '"+new java.sql.Date(pacienteCurrent.getPrimerEmbarazo().getTime())+"' WHERE historial = '"+pacienteCurrent.getHistorial()+"'");
		}
		
		if(pacienteCurrent.getMenopausia()!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET menopausia = '"+new java.sql.Date(pacienteCurrent.getMenopausia().getTime())+"' WHERE historial = '"+pacienteCurrent.getHistorial()+"'");

		}
		
		if(pacienteCurrent.getMenarquia()!=null){
			SGBD.getSGBD().execSQL("UPDATE Paciente SET menarquia = '"+new java.sql.Date(pacienteCurrent.getMenarquia().getTime())+"' WHERE historial = '"+pacienteCurrent.getHistorial()+"'");
		}
		
		String orden = "UPDATE Paciente SET nombre ='"+pacienteCurrent.getNombre()+"', casoIndice = '"+pacienteCurrent.getCi().toString()+"', "+ 
						"sexo = '"+pacienteCurrent.getSexo().toString()+"', historialCI = '"+pacienteCurrent.getHistorialCI()+"', numeroFamilia = '"+pacienteCurrent.getNumFamilia()+"',"
						+ "familiarCI = '"+pacienteCurrent.getFamiliarCI().toString()+"', relacionCI = '"+pacienteCurrent.getRelacionCI()+"', "
						+ "lugarNacimiento = '"+pacienteCurrent.getLugarNace()+"', origenMaterno = '"+pacienteCurrent.getOrigenMaterno()+"',"
						+ "origenPaterno = '"+pacienteCurrent.getOrigenPaterno()+"', consumoAnovulatorios = '"+pacienteCurrent.getAnovulatorios()+"',"
						+ " numeroGestaciones = '"+pacienteCurrent.getNumGestaciones()+"'"
						+ "WHERE historial= '"+pacienteCurrent.getHistorial()+"'";
		SGBD.getSGBD().execSQL(orden);
	}

	public Iterator<Cancer> listarCancer(String pHistorial) {
				Paciente paciente = CatalogoPacientes.getPacientes().obtenerPaciente(pHistorial);
				return paciente.listarCancerPaciente();				
	}

	public boolean addCancer(String pHistorial, java.util.Date dateFecha,
			String pTipo, String pMama, String pTratamiento) {
		Mama mama=null;
		TipoCancer tipo=null;
		if(pMama!=null)mama=Mama.valueOf(pMama);
		if(pTipo!=null)tipo=TipoCancer.valueOf(pTipo);
		return CatalogoPacientes.getPacientes().obtenerPaciente(pHistorial).addCancer(new Cancer(pHistorial, new java.sql.Date(dateFecha.getTime()), tipo, pTratamiento,mama));
	}
}

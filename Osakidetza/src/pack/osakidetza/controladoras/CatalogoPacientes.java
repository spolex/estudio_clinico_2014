package pack.osakidetza.controladoras;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ListModel;

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
		
		boolean encontrado = buscarPaciente(pHist);
		
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
		
		return encontrado;
	}

	/**
	 * pre:
	 * post:comprueba si el paciente con el número de historial recibido como parámetro existe en el sistema.
	 * @param pHist
	 * @return true si existe en el sistema, false en otro caso.
	 */
	public boolean buscarPaciente(String pHist) {
		
		boolean encontrado = false;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("SELECT historial FROM Paciente WHERE historial = '"+pHist+"'");
		if(RdoSQL.next()){
			encontrado = true;
			RdoSQL.close();
		}
		return encontrado;
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
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL("Select historial FROM Paciente WHERE activo = '1'");
		while(RdoSQL.next()){
			listaPacientes.add(RdoSQL.get("historial"));
		}
		return listaPacientes;
	}

}

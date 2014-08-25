package pack.osakidetza.controladoras;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class C_Doctor {
	
	private static C_Doctor miDoctor=new C_Doctor();
	
	private C_Doctor() {
	}

	public static C_Doctor getMiDoctor() {
		return miDoctor;
	}

	public boolean addPaciente(String pNom, String pHist, String cI, String sexo, String histCI,
			String criteriosCI, String numFamilia, String familiarCi,
			String relacionCi, Date fechaNacimiento, String lugarNace,
			String origenMaterno, String origenPaterno,
			Date fechaSeguimiento, String anovulatorios, String numGest,
			Date fechaPrimerEmbarazo, Date fechaMenopausia, Date fechaMenarquia) {
		return CatalogoPacientes.getPacientes().addPaciente( pNom, pHist,  cI,  sexo, histCI,
				 criteriosCI,  numFamilia,  familiarCi,
				 relacionCi,  fechaNacimiento,  lugarNace,
				 origenMaterno,  origenPaterno,
				 fechaSeguimiento,  anovulatorios,  numGest,
				 fechaPrimerEmbarazo,  fechaMenopausia, fechaMenarquia);
	}

	public String buscarPaciente(String pHist) {
		return CatalogoPacientes.getPacientes().buscarPaciente(pHist);
	}
	
	public ArrayList<String> listarCasosIndice(){
		return CatalogoPacientes.getPacientes().listarCasosIndice();
	}

	public ArrayList<String> listarPacientes() {
		return CatalogoPacientes.getPacientes().listarPacientes();
	}

	public ArrayList<String> listarPacientesDado(String cI) {
		return CatalogoPacientes.getPacientes().listarPacientesDado(cI);
	}

	public boolean borrarPaciente(String Historial) {
		return CatalogoPacientes.getPacientes().borrarPaciente(Historial);
	}

	public Paciente obtenerPaciente(String historial) {
		return CatalogoPacientes.getPacientes().obtenerPaciente(historial);
	}

	public boolean actualizarPaciente(Paciente pacienteCurrent, String historialOld) {
		return CatalogoPacientes.getPacientes().actualizarPaciente(pacienteCurrent,historialOld);
	}

	public Iterator<Cancer> listarCancer(String pHistorial) {
		 return CatalogoPacientes.getPacientes().listarCancer(pHistorial);		
	}

	public boolean addCancer(String pHistorial, java.util.Date date,
			String pTipo, String pMama, String pTratamiento) {
		return CatalogoPacientes.getPacientes().addCancer(pHistorial,date,pTipo,pMama,pTratamiento);
	}

	public boolean eliminarCancer(Cancer pCancer) {
		return CatalogoPacientes.getPacientes().eliminarCancer(pCancer);
	}

	public int actualizarCancer(Cancer cancerCurrent, Cancer cancerNew) {
		return CatalogoPacientes.getPacientes().actualizarCancer(cancerCurrent,cancerNew);
	}

	public boolean addVisita(Visita visita) {
		return CatalogoVisitas.getMisvisitas().addVisita(visita);
	}

	public boolean existeVisita(Visita visita) {
		return CatalogoVisitas.getMisvisitas().existe(visita);
	}
	
	public Iterator<Visita> listarVisitas(String pEmail){
		return CatalogoVisitas.getMisvisitas().listarVisitas(pEmail);
	}
	
	public Iterator<Visita> listarVisitasEntre(String pEmail,
			java.util.Date fechaDesde, java.util.Date fechaHasta) {
		return CatalogoVisitas.getMisvisitas().listarVisitas(pEmail, fechaDesde, fechaHasta);
	}
	
	public boolean eliminarVisita(Visita pVisita){
		return CatalogoVisitas.getMisvisitas().eliminarVisita(pVisita);
	}
	
	public boolean resetVisitas(){
		return CatalogoVisitas.getMisvisitas().removeAll(CatalogoVisitas.getMisvisitas());
	}

	public Iterator<Diagnostico> listarDiagnosticos(String historial) {
		return CatalogoPacientes.getPacientes().listarDiagnosticos(historial);		
	}

	public boolean eliminarDiagnostico(Diagnostico diag) {
		return CatalogoPacientes.getPacientes().eliminarDiagnostico(diag);
	}

	public boolean actualizarDiagnostico(Diagnostico diagOld, Diagnostico actualizado) {
		return CatalogoPacientes.getPacientes().actualizarDiagnostico(diagOld,actualizado);
	}

	public boolean addDiagnostico(Diagnostico nuevo) {
		return CatalogoPacientes.getPacientes().addDiagnostico(nuevo);
	}

	public Iterator<Estudio> listarEstudios(String pHistorial, String tipo, java.sql.Date fecha) {
		return CatalogoPacientes.getPacientes().listarEstudios(pHistorial,tipo, fecha);
	}

	public static boolean addEstudio(Estudio estudio, java.sql.Date pFechaCancer) {
		return CatalogoPacientes.getPacientes().addEstudio(estudio,pFechaCancer);
	}

	public boolean eliminarEstudio(Estudio estudio, java.sql.Date fechaCancer) {
		return CatalogoPacientes.getPacientes().eliminarEstudio(estudio, fechaCancer);
	}

	
}

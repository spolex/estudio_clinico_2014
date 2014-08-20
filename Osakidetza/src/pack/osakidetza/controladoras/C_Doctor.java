package pack.osakidetza.controladoras;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import com.toedter.calendar.JDateChooser;

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

	public void actualizarPaciente(Paciente pacienteCurrent) {
		CatalogoPacientes.getPacientes().actualizarPaciente(pacienteCurrent);
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

}

package pack.osakidetza.controladoras;

import java.util.ArrayList;

public class C_Doctor {
	
	private static C_Doctor miDoctor=new C_Doctor();
	
	private C_Doctor() {
	}

	public static C_Doctor getMiDoctor() {
		return miDoctor;
	}

	public boolean addPaciente(String pNom, String pHist, String cI, String sexo, String histCI,
			String criteriosCI, String numFamilia, String familiarCi,
			String relacionCi, String fechaNacimiento, String lugarNace,
			String origenMaterno, String origenPaterno,
			String fechaSeguimiento, String anovulatorios, String numGest,
			String fechaPrimerEmbarazo, String fechaMenopausia, String fechaMenarquia) {
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

}

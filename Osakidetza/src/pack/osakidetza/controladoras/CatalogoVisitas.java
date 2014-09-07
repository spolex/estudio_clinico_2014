package pack.osakidetza.controladoras;

import java.util.ArrayList;
import java.util.Iterator;

import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

@SuppressWarnings("serial")
public class CatalogoVisitas extends ArrayList<Visita>{

	private static CatalogoVisitas misVisitas = new CatalogoVisitas();
	
	private CatalogoVisitas(){
		
	}
	
	public static CatalogoVisitas getMisvisitas(){
		return misVisitas;
	}

	/**
	 * 
	 * @param pVisita
	 * @return
	 */
	public boolean existe(Visita pVisita){
		String consulta="SELECT * FROM Visita WHERE pacienteHistorial = '"+pVisita.getPaciente()+"' AND fecha = '"+pVisita.getFecha()+"' AND nombreUsuario = '"+pVisita.getMedico()+"' AND emailMedico = '"+pVisita.getEmailMedico()+"'";
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta);
		if(RdoSQL.next()){
			RdoSQL.close();
			return true;
		}
		RdoSQL.close();
		return false;
	}
	/**
	 * 
	 * @param visita
	 * @return
	 */
	public boolean addVisita(Visita visita) {
		
		String paciente = visita.getPaciente();
		java.sql.Date fecha = visita.getFecha();
		String nombre = visita.getMedico();
		String email = visita.getEmailMedico();
		String observ = visita.getObservaciones();
		String orden ="INSERT INTO Visita(pacienteHistorial, fecha, nombreUsuario, emailMedico, observaciones)"
				+ "VALUES('"+paciente+"','"+fecha +"','"+nombre+"', '"+email+"', '"+observ+"')";		
		return SGBD.getSGBD().execSQL(orden);
	}
	
	/**
	 * 
	 * @param pEmail 
	 * @return Iterator de todas las visitas del sistema.
	 */
	
	public Iterator<Visita> listarVisitas(String pEmail){
		String consulta = "SELECT * FROM Visita WHERE emailMedico = '"+pEmail+"'";
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta);
		while(RdoSQL.next()){
			CatalogoVisitas.getMisvisitas().add(new Visita(RdoSQL.get("pacienteHistorial"), RdoSQL.getDate("fecha"), RdoSQL.get("nombreUsuario"), RdoSQL.get("emailMedico"), RdoSQL.get("observaciones")));			
		}
		RdoSQL.close();
		return this.iterator();
	}
	
	public boolean eliminarVisita(Visita pVisita){
		System.out.println(pVisita.getFecha());
		String delete="DELETE FROM Visita WHERE pacienteHistorial = '"+pVisita.getPaciente()+"' AND fecha = '"+pVisita.getFecha()+"' AND nombreUsuario = '"+pVisita.getMedico()+"' AND emailMedico = '"+pVisita.getEmailMedico()+"'";
		SGBD.getSGBD().execSQL(delete);
		
		String consulta="SELECT * FROM Visita WHERE pacienteHistorial = '"+pVisita.getPaciente()+"' AND fecha = '"+pVisita.getFecha()+"' AND nombreUsuario = '"+pVisita.getMedico()+"' AND emailMedico = '"+pVisita.getEmailMedico()+"'";;
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta);
		boolean rdo = RdoSQL.next();
		RdoSQL.close();
		return !rdo;
	}
	
	public boolean resetVisitas()
	{
		return CatalogoVisitas.getMisvisitas().removeAll(getMisvisitas());
	}

	public Iterator<Visita> listarVisitas(String pEmail,
		java.util.Date fechaDesde, java.util.Date fechaHasta) {
		String consulta = "SELECT * FROM Visita WHERE emailMedico = '"+pEmail+"' AND fecha >= '"+fechaDesde+"' AND fecha <= '"+fechaHasta+"'";
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta);
		while(RdoSQL.next()){
			CatalogoVisitas.getMisvisitas().add(new Visita(RdoSQL.get("pacienteHistorial"), 
					RdoSQL.getDate("fecha"), RdoSQL.get("nombreUsuario"), RdoSQL.get("emailMedico"), RdoSQL.get("observaciones")));			
		}
		RdoSQL.close();
		return this.iterator();
	}
}

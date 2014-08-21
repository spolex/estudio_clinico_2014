package pack.osakidetza.controladoras;

import java.util.ArrayList;

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
	 */
	public boolean addVisita(Visita visita) {
		
		String paciente = visita.getPaciente();
		java.sql.Date fecha = visita.getFecha();
		String nombre = visita.getMedico();
		String email = visita.getEmailMedico();
		String orden ="INSERT INTO Visita(pacienteHistorial, fecha, nombreUsuario, emailMedico)"
				+ "VALUES('"+paciente+"','"+fecha +"','"+nombre+"', '"+email+"')";
		SGBD.getSGBD().execSQL(orden);
		return existe(visita);
	}
}

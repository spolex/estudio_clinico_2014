package pack.osakidetza.controladoras;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import pack.osakidetza.enumerados.Mama;
import pack.osakidetza.enumerados.TipoCancer;
import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

@SuppressWarnings("serial")
public class ListaCancer extends ArrayList<Cancer> {

	public ListaCancer() {
	}

	public ListaCancer(int initialCapacity) {
		super(initialCapacity);
	}

	public ListaCancer(Collection<? extends Cancer> c) {
		super(c);
	}

	/**
	 * pre:Los atributos en la relación Cancer de la BD no pueden ser NULL.El paciente con el historial pHist existe en la BD.
	 * post:se cargan en la ListaCancerPaciente los cánceres de un paciente dado su historial,registrados en la BD.
	 * @param pHist
	 * @return 
	 */
	public java.util.Iterator<Cancer> listarCancerPaciente(String pHist){
		
		String consulta = "SELECT * FROM Cancer WHERE historial = '"+pHist+"'";
		ResultadoSQL RdoSQL= SGBD.getSGBD().consultaSQL(consulta);
		while (RdoSQL.next()){
			Cancer cancer = new Cancer(RdoSQL.get("historial"), RdoSQL.getDate("fechaCancer"),
					TipoCancer.valueOf(RdoSQL.get("tipo")), RdoSQL.get("tratamiento"), Mama.valueOf(RdoSQL.get("mama")));
			this.add(cancer);
		}
		RdoSQL.close();
		return this.iterator();
	}
	/**
	 * 
	 * pre:El paciente existe en la BD.
	 * post:Se añade el cáncer tanto a la BD como a la ListaCancerPacienete.
	 * @param pHistorial
	 * @param pFecha
	 * @param pTipo
	 * @param pTratamiento
	 * @param pMama
	 * @return si se añade con éxito true, false en otro caso.
	 */
	public boolean añadirCancer(Cancer pCancer) {
		
		String insert="INSERT INTO Cancer(historial,fechaCancer, tipo) VALUES('"+pCancer.getPaciente()+"', '"+pCancer.getFecha()+"','"+pCancer.getTipo().toString()+"')";
		SGBD.getSGBD().execSQL(insert);
		if(pCancer.getMama()!=null){
			String update = "UPDATE Cancer SET mama = '"+pCancer.getMama()+"' WHERE historial = '"+pCancer.getPaciente()+"'"
					+ "AND tipo ='"+pCancer.getTipo().toString()+"' AND fechaCancer = '"+pCancer.getFecha()+"'";
			SGBD.getSGBD().execSQL(update);
		}
		if(pCancer.getTratamiento()!=null){
			String update1="UPDATE Cancer set tratamiento = '"+pCancer.getTratamiento()+"' WHERE historial = '"+pCancer.getPaciente()+"'"
					+ "AND tipo ='"+pCancer.getTipo().toString()+"' AND fechaCancer = '"+pCancer.getFecha()+"'";
			SGBD.getSGBD().execSQL(update1);
		}
		String consulta="Select * FROM Cancer WHERE historial = '"+pCancer.getPaciente()+"'"
					+ "AND tipo ='"+pCancer.getTipo().toString()+"' AND fechaCancer = '"+pCancer.getFecha()+"'";
		ResultadoSQL RdoSQL=SGBD.getSGBD().consultaSQL(consulta);
		if(RdoSQL.next()){
			return this.add(pCancer);
		}
		RdoSQL.close();
		return false;
	}
	
	
	
	
}

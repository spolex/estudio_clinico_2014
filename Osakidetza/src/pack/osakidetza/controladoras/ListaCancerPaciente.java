package pack.osakidetza.controladoras;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import pack.osakidetza.enumerados.Mama;
import pack.osakidetza.enumerados.TipoCancer;
import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

@SuppressWarnings("serial")
public class ListaCancerPaciente extends ArrayList<Cancer> {

	public ListaCancerPaciente() {
	}

	public ListaCancerPaciente(int initialCapacity) {
		super(initialCapacity);
	}

	public ListaCancerPaciente(Collection<? extends Cancer> c) {
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
	 * pre:El paciente con el historial pHist existe en la BD.
	 * post:Se añade el cáncer tanto a la BD como a la ListaCancerPacienete.
	 * @param pHistorial
	 * @param pFecha
	 * @param pTipo
	 * @param pTratamiento
	 * @param pMama
	 * @return si se añade con éxito true, false en otro caso.
	 */
	public boolean addCancer(String pHistorial,Date pFecha, TipoCancer pTipo, String pTratamiento, Mama pMama){
		
		Cancer pCancer = new Cancer(pHistorial,pFecha,pTipo,pTratamiento, pMama);
		
		String orden = "INSERT INTO Cancer(historial,fechaCancer,tipo,mama,tratamiento) VALUES('"+pHistorial+"','"+pFecha+"',"
				+ "'"+pTipo+"', '"+pMama+"','"+pTratamiento+"')";
		SGBD.getSGBD().execSQL(orden );
		
		String consulta = "SELECT tipo FROM Cancer WHERE tipo = '"+pTipo+"' AND historial = '"+pHistorial+"' AND fechaCancer = '"+pFecha+"'";
		ResultadoSQL RdoSql = SGBD.getSGBD().consultaSQL(consulta);
		
		if(RdoSql.next())this.add(pCancer);
		
		return this.contains(pCancer);
	}
}

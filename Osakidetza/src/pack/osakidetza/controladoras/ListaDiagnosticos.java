package pack.osakidetza.controladoras;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import pack.osakidetza.enumerados.Gen;
import pack.osakidetza.enumerados.TipoCancer;
import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

@SuppressWarnings("serial")
public class ListaDiagnosticos extends ArrayList<Diagnostico>
{
	public ListaDiagnosticos(){
		
	}
	
	public ListaDiagnosticos(int initialCapacity) {
		super(initialCapacity);
	}

	public ListaDiagnosticos(Collection<? extends Diagnostico> c) {
		super(c);
	}

	/**
	 * pre:recibe el historial del paciente del que hay que listar los diagnósticos
	 * post: añade a la lista de diagnostticos del paciente los diagnósticos que existen en el sistema y devuelve un iterador.
	 * @param pHistorial
	 * @return Iterator
	 */
	public Iterator<Diagnostico> listarDiagnosticos(String pHistorial){
		
		String consulta = "SELECT * FROM Diagnostico_genetico WHERE pacienteHistorial = '"+pHistorial+"'";
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta );
		
		while(RdoSQL.next())
		{
			TipoCancer tipo =null;
			if(RdoSQL.get("tipoCancer")!=null)tipo = TipoCancer.valueOf(RdoSQL.get("tipoCancer"));
			
			Gen gen = null;
			if(RdoSQL.get("genSecuenciado")!=null)gen = Gen.valueOf(RdoSQL.get("genSecuenciado"));
			
			java.sql.Date fecha = new Date(0);
			if(RdoSQL.getDate("fecha")!=null)fecha=RdoSQL.getDate("fecha");
			
			String rdo = null;
			if(RdoSQL.get("resultado")!=null)rdo=RdoSQL.get("resultado");
			
			String mutacion = null;
			if(RdoSQL.get("mutacion")!=null)mutacion=RdoSQL.get("mutacion");
			
			Diagnostico diag = new Diagnostico(pHistorial,tipo,gen,mutacion,rdo,fecha);
			
			this.add(diag);

		}
		RdoSQL.close();
		return this.iterator();
	}

	/**
	 * pre:
	 * post:elimina el diagnóstico de la lista de diagnósticos del paciente, del sistema y del modelo.
	 * @param diag
	 * @return
	 */
	public boolean eliminarDiagnostico(Diagnostico diag) 
	{
		String orden = "DELETE FROM Diagnostico_genetico WHERE tipoCancer = '"+diag.getCancer().toString()+"' "
				+ "AND pacienteHistorial = '"+diag.getPaciente()+"' "
						+ "AND fecha = '"+diag.getFecha()+"' AND genSecuenciado ='"+diag.getGenSecuenciado().toString()+"'";
		return SGBD.getSGBD().execSQL(orden);
	}
	/**
	 * pre:el paciente con historial pHist existe.
	 *post: carga en la lista todos los diagnósticos del paciente con historial pHist
	 * @param pHist
	 */
	@SuppressWarnings("unused")
	private void getDiagnosticos(String pHist)
	{
		String consulta = "SELECT * FROM Diagnostico_genetico WHERE pacienteHistorial = '"+pHist+"'";
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta );
		
		while(RdoSQL.next())
		{
			TipoCancer tipo =null;
			if(RdoSQL.get("tipoCancer")!=null)tipo = TipoCancer.valueOf(RdoSQL.get("tipoCancer"));
			
			Gen gen = null;
			if(RdoSQL.get("genSecuenciado")!=null)gen = Gen.valueOf(RdoSQL.get("genSecuenciado"));
			
			java.sql.Date fecha = new Date(0);
			if(RdoSQL.getDate("fecha")!=null)fecha=RdoSQL.getDate("fecha");
			
			String rdo = null;
			if(RdoSQL.get("resultado")!=null)rdo=RdoSQL.get("resultado");
			
			String mutacion = null;
			if(RdoSQL.get("mutacion")!=null)mutacion=RdoSQL.get("mutacion");
			
			Diagnostico diag = new Diagnostico(pHist,tipo,gen,mutacion,rdo,fecha);
			
			this.add(diag);

		}
		RdoSQL.close();
	}

	public boolean actualizarDiagnostico(Diagnostico diagOld, Diagnostico actualizado) {
		String orden = "UPDATE Diagnostico_genetico SET genSecuenciado = '"+actualizado.getGenSecuenciado().toString()+"', fecha = '"+actualizado.getFecha()+"', "
				+ "tipoCancer = '"+actualizado.getCancer().toString()+"', mutacion= '"+actualizado.getMutacion()+"', resultado = '"+actualizado.getResultado()+"'"
				+ "WHERE pacienteHistorial = '"+diagOld.getPaciente()+"'"
				+ " AND genSecuenciado = '"+diagOld.getGenSecuenciado().toString()+"' AND fecha = '"+diagOld.getFecha()+"' AND "
				+ "tipoCancer = '"+diagOld.getCancer().toString()+"'";
		return SGBD.getSGBD().execSQL(orden);
	}

	public boolean addDiagnostico(Diagnostico nuevo) {
		String orden = "INSERT INTO Diagnostico_genetico (genSecuenciado, pacienteHistorial, fecha, tipoCancer, mutacion, resultado)"
				+ "VALUES('"+nuevo.getGenSecuenciado().toString()+"', '"+nuevo.getPaciente()+"', '"+nuevo.getFecha()+"', '"+nuevo.getCancer().toString()+"', "
						+ "'"+nuevo.getMutacion()+"', '"+nuevo.getResultado()+"')";
		return SGBD.getSGBD().execSQL(orden );
	}
}



package pack.osakidetza.controladoras;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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

	/**
	 * 
	 * @param pCancer
	 * @return
	 */
	public boolean eliminarCancer(Cancer pCancer) {	
	
			String delete="DELETE FROM Cancer WHERE historial='"+pCancer.getPaciente()+"' AND fechaCancer = '"+pCancer.getFecha()+"' AND tipo = '"+pCancer.getTipo().toString()+"'";
			SGBD.getSGBD().execSQL(delete);
			this.remove(pCancer);
			
			String consulta="Select * FROM Cancer WHERE historial='"+pCancer.getPaciente()+"' AND fechaCancer = '"+pCancer.getFecha()+"' AND tipo = '"+pCancer.getTipo().toString()+"'";
			ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta);
			boolean eliminado=RdoSQL.next();
			RdoSQL.close();
		
		return eliminado;
	}

	/**
	 * pre:el cancer a actualizar (oCancerOld) existe en el sistema
	 * pos:actualiza todos los campos que varían de pCancerOld a pCancerNew.
	 * @param pCancerOld
	 * @param pCancerNew
	 * @return
	 */
	public int actualizarCancer(Cancer pCancerOld, Cancer pCancerNew) {		
		
		int actualizado = 0;
		java.util.Date fecha= new Date(new java.util.Date().getTime()); 
		
		String update="UPDATE Cancer SET fechaCancer = '"+pCancerNew.getFecha()+"' WHERE historial='"+pCancerOld.getPaciente()+"' AND fechaCancer = '"+pCancerOld.getFecha()+"' AND tipo = '"+pCancerOld.getTipo().toString()+"'";
		if(pCancerNew.getFecha()!=null && !pCancerOld.getFecha().equals(pCancerNew.getFecha())){
			if (SGBD.getSGBD().execSQL(update))actualizado++;
			fecha=pCancerNew.getFecha();
		}
		else
		{
			fecha=pCancerOld.getFecha();
		}

		boolean mismoTipo=false;
		String tipo= null; 
		String update1="UPDATE Cancer SET tipo = '"+pCancerNew.getTipo().toString()+"' WHERE historial='"+pCancerOld.getPaciente()+"' AND fechaCancer = '"+fecha+"' AND tipo = '"+pCancerOld.getTipo().toString()+"'";
		if(pCancerNew.getTipo()!=null && !pCancerNew.getTipo().equals(pCancerOld.getTipo())){
			if(SGBD.getSGBD().execSQL(update1))actualizado++;
			tipo=pCancerNew.getTipo().toString();
		}
		else
		{
			tipo=pCancerOld.getTipo().toString();
		    mismoTipo = true;
		}
		
		if(tipo!=null && !mismoTipo)
		{
			String mama="ninguna";
			if(tipo.equals("mama"))mama=pCancerNew.getMama().toString();
			String update2="UPDATE Cancer SET mama = '"+mama+"' WHERE historial='"+pCancerOld.getPaciente()+"' AND fechaCancer = '"+fecha+"' AND tipo = '"+tipo+"'";
			if(SGBD.getSGBD().execSQL(update2))actualizado++;
		}
		
		String update3="UPDATE Cancer SET tratamiento = '"+pCancerNew.getTratamiento()+"' WHERE historial='"+pCancerOld.getPaciente()+"' AND fechaCancer = '"+fecha+"' AND tipo = '"+tipo+"'";
		if(pCancerNew.getTratamiento()!=null && !pCancerNew.getTratamiento().equalsIgnoreCase(pCancerOld.getTratamiento()))
		{
			if(SGBD.getSGBD().execSQL(update3))actualizado++;
		}
		
		return actualizado;
	}
	
	public Iterator<Estudio> listarEstudios(String pHistorial, String tipo,
			java.sql.Date fecha) 
	{
		return this.obtenerCancer(pHistorial, tipo, fecha).listarEstudios();
	}
	
	/**
	 * obtiene el cancer con los datos que se reciben como parámetros.
	 * @param pHIst
	 * @param tipo
	 * @param fecha
	 * @return Si éxiste el cáncer con dichos parámetros, en otro caso null.
	 */
	private Cancer obtenerCancer(String pHIst, String tipo, java.sql.Date fecha)
	{
		String consulta = "Select * From Cancer WHERE tipo = '"+tipo+"' AND historial = '"+pHIst+"' AND fechaCancer = '"+fecha+"'";
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta );
		
		if(RdoSQL.next())
		{
			Mama pMama=null;
			if(RdoSQL.get("mama")!=null)pMama=Mama.valueOf(RdoSQL.get("mama"));
			Cancer cancer = new Cancer(pHIst, fecha, TipoCancer.valueOf(tipo), RdoSQL.get("tratamiento"), pMama);
			RdoSQL.close();
			return  cancer;
		}
		RdoSQL.close();
		return null;
	}

	public boolean addEstudios(Estudio estudio, Date pFechaCancer) {
		return this.obtenerCancer(estudio.getPaciente(), estudio.getTipo().toString(),pFechaCancer).addEstudio(estudio);
	}

	
	 
	
	
	
	
}

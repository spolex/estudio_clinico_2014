package pack.osakidetza.controladoras;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import pack.osakidetza.enumerados.EstidiajeM;
import pack.osakidetza.enumerados.EstidiajeN;
import pack.osakidetza.enumerados.EstidiajeT;
import pack.osakidetza.enumerados.Grado;
import pack.osakidetza.enumerados.Subtipo;
import pack.osakidetza.enumerados.TipoCancer;
import pack.osakidetza.gestorBD.ResultadoSQL;
import pack.osakidetza.gestorBD.SGBD;

@SuppressWarnings("serial")
public class ListaEstudios extends ArrayList<Estudio> 
{

	/**
	 * pre:existe el cancer registrado con los datos que se reciben como parámetro.
	 * post:Devuelve un iterador con los estudios patológicos asociados a dicho cancer.
	 * 
	 * @param pHistorial
	 * @param tipo
	 * @param fecha
	 * @return
	 */
	public Iterator<Estudio> listarEstudios(String paciente, TipoCancer tipo) 
	{
		String consulta = "SELECT * FROM Patologico WHERE cancerTipo = '"+tipo+"' AND cancerHistorial = '"+paciente+"'";
		ResultadoSQL RdoSQL = SGBD.getSGBD().consultaSQL(consulta);
		while(RdoSQL.next()){
			String code = RdoSQL.get("codigo");
			
			Subtipo subHistologico = null;
			if(RdoSQL.get("subtipoHistologico")!=null)subHistologico = Subtipo.valueOf(RdoSQL.get("subtipoHistologico"));
			
			String receptoresEstrogenicos=null;
			if(RdoSQL.get("receptoresEstrogenicos")!=null)receptoresEstrogenicos = RdoSQL.get("receptoresEstrogenicos");
						
			String receptoresProstagenicos=null;
			if(RdoSQL.get("receptoresProstagenicos")!=null)receptoresProstagenicos = RdoSQL.get("receptoresProstagenicos");
			
			String cerbE2 = null;
			if(RdoSQL.get("cerbE2")!=null)cerbE2 = RdoSQL.get("cerbE2");
			
			int ki676 =  0;
			if(RdoSQL.get("Ki67")!=null)ki676 = Integer.parseInt(RdoSQL.get("Ki67"));
						
			Grado gHistologico = null;
			if(RdoSQL.get("gradoHistologico")!=null)gHistologico = Grado.valueOf(RdoSQL.get("gradoHistologico"));
			
			EstidiajeT t = null;
			if(RdoSQL.get("estidiajeT")!=null)t = EstidiajeT.valueOf(RdoSQL.get("estidiajeT"));
			
			EstidiajeN n = null;
			if(RdoSQL.get("estidiajeN")!=null)n = EstidiajeN.valueOf(RdoSQL.get("estidiajeN"));
			
			EstidiajeM m = null;
			if(RdoSQL.get("estidiajeM")!=null)m = EstidiajeM.valueOf(RdoSQL.get("estidiajeM"));
			
			Date fecha=new Date(0);
			if(RdoSQL.getDate("fecha")!=null)fecha=RdoSQL.getDate("fecha");

			Estudio patologico = new Estudio(code , tipo, paciente, fecha, subHistologico , receptoresEstrogenicos, receptoresProstagenicos,
					cerbE2, ki676, gHistologico, t , n , m );
			this.add(patologico);
		}
		RdoSQL.close();
		return this.iterator();
	}

	/**
	 * pre: El estudio a añadir no existe en el sistema.
	 * post: se  añade al sistema el estudio nuevo, tanto al modelo como a la lista de estudios patológicos del cancer correspondiente. 
	 * @param estudio
	 * @return
	 */
	public boolean addEstudio(Estudio estudio) {
		String orden="INSERT INTO Patologico(codigo, cancerTipo, cancerHistorial) VALUES('"+estudio.getCode()+"','"+estudio.getTipo().toString()+"', "
				+ "'"+estudio.getPaciente()+"')";
		boolean rdo=false;
		if(SGBD.getSGBD().execSQL(orden))rdo=true;
		//Fecha
		if(estudio.getFecha()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET fecha = '"+estudio.getFecha()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getKi676()>0)SGBD.getSGBD().execSQL("UPDATE Patologico SET Ki67 = '"+estudio.getKi676()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getSubHistologico()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET subtipoHistologico = '"+estudio.getSubHistologico()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getReceptoresEstrogenicos()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET receptoresEstrogenicos = '"+estudio.getReceptoresEstrogenicos()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getReceptoresProstagenicos()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET receptoresProgestagenicos = '"+estudio.getReceptoresProstagenicos()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getCerbE2()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET cerbE2 = '"+estudio.getCerbE2()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getgHistologico()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET gradoHistologico = '"+estudio.getgHistologico()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getN()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET estidiajeN = '"+estudio.getN()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getT()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET estidiajeT = '"+estudio.getT()+"' WHERE codigo = '"+estudio.getCode()+"'");
		if(estudio.getM()!=null)SGBD.getSGBD().execSQL("UPDATE Patologico SET estidiajeM = '"+estudio.getM()+"' WHERE codigo = '"+estudio.getCode()+"'");
		this.add(estudio);
		return rdo;
	}

	/**
	 * pre: El estudio a eliminar existe en el sistema.
	 * post: se elimina completamente del sistyema el estudio seleccionado.
	 * @param estudio
	 * @return
	 */
	public boolean eliminarEstudio(Estudio estudio)
	{
		String orden ="DELETE FROM Patologico WHERE codigo = '"+estudio.getCode()+"' AND cancerTipo = '"+estudio.getTipo().toString()+"'"
				+ " AND cancerHistorial = '"+estudio.getPaciente()+"' AND fecha = '"+estudio.getFecha()+"'";
		this.remove(estudio);
		return SGBD.getSGBD().execSQL(orden);
	}

}

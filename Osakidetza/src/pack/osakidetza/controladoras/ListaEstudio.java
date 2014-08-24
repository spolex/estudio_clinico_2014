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
public class ListaEstudio extends ArrayList<Estudio> 
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
	 * 
	 * @param estudio
	 * @return
	 */
	public boolean addEstudio(Estudio estudio) {
		String orden="INSERT INTO Patologico(codigo, cancerTipo, cancerHistorial) VALUES('"+estudio.getCode()+"','"+estudio.getTipo().toString()+"', "
				+ "'"+estudio.getPaciente()+"')";
		boolean rdo=false;
		if(SGBD.getSGBD().execSQL(orden))rdo=true;
		//Fecha
		if(estudio.getFecha()!=null){
			SGBD.getSGBD().execSQL("UPDATE Patologico SET fecha = '"+estudio.getFecha()+"' WHERE codigo = '"+estudio.getCode()+"'");
		}
		if(estudio.getSubHistologico()!=null)
		{
			SGBD.getSGBD().execSQL("UPDATE Patologico SET subtipoHistologico = '"+estudio.getSubHistologico()+"' WHERE codigo = '"+estudio.getCode()+"'");

		}		
		return rdo;
	}

}

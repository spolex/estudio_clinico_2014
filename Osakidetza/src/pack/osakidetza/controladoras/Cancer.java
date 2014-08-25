package pack.osakidetza.controladoras;

import java.sql.Date;
import java.util.Iterator;

import pack.osakidetza.enumerados.*;

public class Cancer 
{
	private TipoCancer tipo;
	private String historial;
	private Date fecha;
	private Mama mama;
	private String tratamiento;
	private ListaEstudios estudios;
	
	
	public Cancer(String pHistorial, Date pFecha, TipoCancer pTipo,
			String pTratamiento, Mama pMama) {
		this.historial= pHistorial;
		this.tipo=pTipo;
		this.fecha=pFecha;
		this.tratamiento= pTratamiento;
		this.mama= pMama;
		this.estudios=new ListaEstudios();
	}
	public void setTipo(TipoCancer tipo) {
		this.tipo = tipo;
	}
	public void setPaciente(String paciente) {
		this.historial = paciente;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setMama(Mama mama) {
		this.mama = mama;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public TipoCancer getTipo() {
		return tipo;
	}
	public String getPaciente() {
		return historial;
	}
	public Date getFecha() {
		return fecha;
	}
	public Mama getMama() {
		return mama;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	private ListaEstudios getEstudios() {
		return estudios;
	}
	public Iterator<Estudio> listarEstudios(){			
		return this.getEstudios().listarEstudios(this.getPaciente(), this.getTipo());
	}
	public boolean addEstudio(Estudio estudio) {
		return this.getEstudios().addEstudio(estudio);
	}
	public boolean eliminarEstudio(Estudio estudio) {
		return this.getEstudios().eliminarEstudio(estudio);
	}
}

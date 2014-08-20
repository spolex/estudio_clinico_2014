package pack.osakidetza.controladoras;

import java.sql.Date;

import pack.osakidetza.enumerados.*;

public class Cancer 
{
	private TipoCancer tipo;
	private String paciente;
	private Date fecha;
	private Mama mama;
	private String tratamiento;
	public Cancer(String pHistorial, Date pFecha, TipoCancer pTipo,
			String pTratamiento, Mama pMama) {
		this.paciente= pHistorial;
		this.tipo=pTipo;
		this.fecha=pFecha;
		this.tratamiento= pTratamiento;
		this.mama= pMama;
	}
	public void setTipo(TipoCancer tipo) {
		this.tipo = tipo;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
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
		return paciente;
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
}

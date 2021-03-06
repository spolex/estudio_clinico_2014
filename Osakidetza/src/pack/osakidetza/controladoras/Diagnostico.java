package pack.osakidetza.controladoras;

import java.sql.Date;

import pack.osakidetza.enumerados.Gen;

public class Diagnostico {
	
	private String paciente;
	private Gen genSecuenciado;
	private String mutacion;
	private String resultado;
	private java.sql.Date fecha;

	public Diagnostico(String paciente, Gen genSecuenciado,
			String mutacion, String resultado, Date fecha) {
		super();
		this.paciente = paciente;
		this.genSecuenciado = genSecuenciado;
		this.mutacion = mutacion;
		this.resultado = resultado;
		this.fecha = fecha;
	}

	public String getPaciente() {
		return paciente;
	}


	public Gen getGenSecuenciado() {
		return genSecuenciado;
	}

	public String getMutacion() {
		return mutacion;
	}

	public String getResultado() {
		return resultado;
	}

	public java.sql.Date getFecha() {
		return fecha;
	}

	@SuppressWarnings("unused")
	private void setPaciente(String paciente) {
		this.paciente = paciente;
	}


	public void setGenSecuenciado(Gen genSecuenciado) {
		this.genSecuenciado = genSecuenciado;
	}

	public void setMutacion(String mutacion) {
		this.mutacion = mutacion;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}
	
	

}

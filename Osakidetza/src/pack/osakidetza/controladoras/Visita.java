package pack.osakidetza.controladoras;

public class Visita
{
	private String paciente;
	private java.sql.Date fecha;
	private String medico;
	private String emailMedico;
	private String observaciones;
	
	/**
	 * 
	 * @param pHistorial
	 * @param pFecha
	 * @param pMedico
	 * @param pEmailMedico
	 */
	public Visita(String pHistorial, java.sql.Date pFecha,String pMedico, String pEmailMedico, String pObservaciones){
		this.paciente=pHistorial;
		this.fecha=pFecha;
		this.medico=pMedico;
		this.emailMedico=pEmailMedico;
		this.observaciones= pObservaciones;
	}

	public String getPaciente() {
		return paciente;
	}

	public java.sql.Date getFecha() {
		return fecha;
	}

	public String getMedico() {
		return medico;
	}

	public String getEmailMedico() {
		return emailMedico;
	}
	
	public void setEmail(String pEmail){
		this.emailMedico=pEmail;
	}

	public String getObservaciones() {
		return this.observaciones;
	}
}

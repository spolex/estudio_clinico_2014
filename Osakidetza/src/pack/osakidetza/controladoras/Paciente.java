package pack.osakidetza.controladoras;

import java.util.Date;
import java.util.Iterator;

import pack.osakidetza.enumerados.Sexo;
import pack.osakidetza.enumerados.SiNo;
import pack.osakidetza.gestorBD.SGBD;

public class Paciente {

	private String nombre;
	private String historial;
	private SiNo ci;
	private Sexo sexo;
	private String criteriosCI;
	private String numFamilia;
	private SiNo familiarCI;
	private String relacionCI;
	private Date fechaNace;
	private String historialCI;
	private String lugarNace;
	private String origenMaterno;
	private String origenPaterno;
	private Date fechaSeguimiento;
	private String anovulatorios;
	private int numGestaciones;
	private Date primerEmbarazo;
	private Date menopausia;
	private Date menarquia;
	private ListaCancer listaCancer;

	/**
	 * La constructora se encarga de convertir a enumerados
	 * @param pNom
	 * @param historial
	 * @param pCI
	 * @param pSex
	 * @param pCriterios
	 * @param pNumFam
	 * @param pFamCI
	 * @param pRelacionCI
	 * @param pFechaNace
	 * @param pHistCI
	 * @param pLugNace
	 * @param pMater
	 * @param pPater
	 * @param pSeguimiento
	 * @param pAnovu
	 * @param pNumGest
	 * @param pPrimer
	 * @param pMeno
	 * @param pMenar
	 */
	public Paciente(String pNom, String historial, String pCI, String pSex,
			String pCriterios, String pNumFam, String pFamCI,
			String pRelacionCI, Date pFechaNace, String pHistCI,
			String pLugNace, String pMater, String pPater, Date pSeguimiento,
			String pAnovu, int pNumGest, Date pPrimer, Date pMeno, Date pMenar) {
		this.nombre = pNom;
		this.historial = historial;
		if(pCI!=null)this.ci = SiNo.valueOf(pCI);
		if(pSex!=null)this.sexo = Sexo.valueOf(pSex);
		this.criteriosCI = pCriterios;
		this.numFamilia = pNumFam;
		if(pFamCI!=null)this.familiarCI = SiNo.valueOf(pFamCI);
		this.relacionCI = pRelacionCI;
		this.fechaNace = pFechaNace;
		this.historialCI = pHistCI;
		this.lugarNace = pLugNace;
		this.origenMaterno = pMater;
		this.origenPaterno = pPater;
		this.fechaSeguimiento = pSeguimiento;
		this.anovulatorios = pAnovu;
		this.numGestaciones = pNumGest;
		this.primerEmbarazo = pPrimer;
		this.menopausia = pMeno;
		this.menarquia = pMenar;
		this.listaCancer = new ListaCancer();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@SuppressWarnings("unused")
	private void setHistorial(String historial) {
		this.historial = historial;
	}

	public String getNombre() {
		return nombre;
	}

	public String getHistorial() {
		return historial;
	}

	public SiNo getCi() {
		return ci;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public String getCriteriosCI() {
		return criteriosCI;
	}

	public String getNumFamilia() {
		return numFamilia;
	}

	public SiNo getFamiliarCI() {
		return familiarCI;
	}

	public String getRelacionCI() {
		return relacionCI;
	}

	public Date getFechaNace() {
		return fechaNace;
	}

	public String getHistorialCI() {
		return historialCI;
	}

	public String getLugarNace() {
		return lugarNace;
	}

	public String getOrigenMaterno() {
		return origenMaterno;
	}

	public String getOrigenPaterno() {
		return origenPaterno;
	}

	public Date getFechaSeguimiento() {
		return fechaSeguimiento;
	}

	public String getAnovulatorios() {
		return anovulatorios;
	}

	public int getNumGestaciones() {
		return numGestaciones;
	}

	public Date getPrimerEmbarazo() {
		return primerEmbarazo;
	}

	public Date getMenopausia() {
		return menopausia;
	}

	public Date getMenarquia() {
		return menarquia;
	}

	public void setCi(SiNo ci) {
		this.ci = ci;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public void setCriteriosCI(String criteriosCI) {
		this.criteriosCI = criteriosCI;
	}

	public void setNumFamilia(String numFamilia) {
		this.numFamilia = numFamilia;
	}

	public void setFamiliarCI(SiNo familiarCI) {
		this.familiarCI = familiarCI;
	}

	public void setRelacionCI(String relacionCI) {
		this.relacionCI = relacionCI;
	}

	public void setFechaNace(Date fechaNace) {
		this.fechaNace = fechaNace;
	}

	public void setHistorialCI(String historialCI) {
		this.historialCI = historialCI;
	}

	public void setLugarNace(String lugarNace) {
		this.lugarNace = lugarNace;
	}

	public void setOrigenMaterno(String origenMaterno) {
		this.origenMaterno = origenMaterno;
	}

	public void setOrigenPaterno(String origenPaterno) {
		this.origenPaterno = origenPaterno;
	}

	public void setFechaSeguimiento(Date fechaSeguimiento) {
		this.fechaSeguimiento = fechaSeguimiento;
	}

	public void setAnovulatorios(String anovulatorios) {
		this.anovulatorios = anovulatorios;
	}

	public void setNumGestaciones(int numGestaciones) {
		this.numGestaciones = numGestaciones;
	}

	public void setPrimerEmbarazo(Date primerEmbarazo) {
		this.primerEmbarazo = primerEmbarazo;
	}

	public void setMenopausia(Date menopausia) {
		this.menopausia = menopausia;
	}

	public void setMenarquia(Date menarquia) {
		this.menarquia = menarquia;
	}
	
	public  Iterator<Cancer> listarCancerPaciente()
	{
		return this.getCanceres().listarCancerPaciente(this.historial);
	}
	
	private ListaCancer getCanceres(){
		return this.listaCancer;
	}

	public boolean addCancer(Cancer cancer) {
		return this.getCanceres().añadirCancer(cancer);
	}

	public boolean eliminarCancer(Cancer pCancer) {
		return this.getCanceres().eliminarCancer(pCancer);
	}

	public int actualizarCancer(Cancer cancerOld, Cancer cancerNew) {
		return this.getCanceres().actualizarCancer(cancerOld,cancerNew);
	}

}

package pack.osakidetza.controladoras;

import java.sql.Date;

import pack.osakidetza.enumerados.EstidiajeM;
import pack.osakidetza.enumerados.EstidiajeN;
import pack.osakidetza.enumerados.EstidiajeT;
import pack.osakidetza.enumerados.Grado;
import pack.osakidetza.enumerados.Subtipo;
import pack.osakidetza.enumerados.TipoCancer;

public class Estudio 
{
	private String code; 
	private TipoCancer tipo;
	private String paciente;
	private java.sql.Date fecha;
	private Subtipo subHistologico;
	private String receptoresEstrogenicos;//problemas con +,- para implementar enum
	private String receptoresProstagenicos;
	private String cerbE2;
	private int ki676;//Es un %.
	private Grado gHistologico;
	private EstidiajeT t;
	private EstidiajeN n;
	private EstidiajeM m;
	
	public Estudio(String code, TipoCancer tipo, String paciente, Date fecha,
			Subtipo subHistologico, String receptoresEstrogenicos,
			String receptoresProstagenicos, String cerbE2, int ki676,
			Grado gHistologico, EstidiajeT t, EstidiajeN n, EstidiajeM m) {
		
		this.code = code;
		this.tipo = tipo;
		this.paciente = paciente;
		this.fecha = fecha;
		this.subHistologico = subHistologico;
		this.receptoresEstrogenicos = receptoresEstrogenicos;
		this.receptoresProstagenicos = receptoresProstagenicos;
		this.cerbE2 = cerbE2;
		this.ki676 = ki676;
		this.gHistologico = gHistologico;
		this.t = t;
		this.n = n;
		this.m = m;
	}

	public Estudio() 
	{
		this.code = null;
		this.tipo = null;
		this.paciente = null;
		this.fecha = null;
		this.subHistologico = null;
		this.receptoresEstrogenicos = null;
		this.receptoresProstagenicos = null;
		this.cerbE2 = null;
		this.ki676 = 0;
		this.gHistologico = null;
		this.t = null;
		this.n = null;
		this.m = null;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTipo(TipoCancer tipo) {
		this.tipo = tipo;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public void setFecha(java.sql.Date fecha) {
		this.fecha = fecha;
	}

	public void setSubHistologico(Subtipo subHistologico) {
		this.subHistologico = subHistologico;
	}

	public void setReceptoresEstrogenicos(String receptoresEstrogenicos) {
		this.receptoresEstrogenicos = receptoresEstrogenicos;
	}

	public void setReceptoresProstagenicos(String receptoresProstagenicos) {
		this.receptoresProstagenicos = receptoresProstagenicos;
	}

	public void setCerbE2(String cerbE2) {
		this.cerbE2 = cerbE2;
	}

	public void setKi676(int ki676) {
		this.ki676 = ki676;
	}

	public void setgHistologico(Grado gHistologico) {
		this.gHistologico = gHistologico;
	}

	public void setT(EstidiajeT t) {
		this.t = t;
	}

	public void setN(EstidiajeN n) {
		this.n = n;
	}

	public void setM(EstidiajeM m) {
		this.m = m;
	}

	public String getCode() {
		return code;
	}

	public TipoCancer getTipo() {
		return tipo;
	}

	public String getPaciente() {
		return paciente;
	}

	public java.sql.Date getFecha() {
		return fecha;
	}

	public Subtipo getSubHistologico() {
		return subHistologico;
	}

	public String getReceptoresEstrogenicos() {
		return receptoresEstrogenicos;
	}

	public String getReceptoresProstagenicos() {
		return receptoresProstagenicos;
	}

	public String getCerbE2() {
		return cerbE2;
	}

	public int getKi676() {
		return ki676;
	}

	public Grado getgHistologico() {
		return gHistologico;
	}

	public EstidiajeT getT() {
		return t;
	}

	public EstidiajeN getN() {
		return n;
	}

	public EstidiajeM getM() {
		return m;
	}
	
	
	
}

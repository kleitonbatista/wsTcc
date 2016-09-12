package br.com.minhafarmacia.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "DOSAGEM")
@SequenceGenerator(name = "DOSAGEM_SEQUENCE", sequenceName = "DOSAGEM_SEQUENCE",allocationSize = 1, initialValue = 0)
public class Dosagem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DOSAGEM_SEQUENCE")
	private Integer id;
	private Integer quantidade;
	private String tipo;
	@Transient
	private String dataInicioString;
	@Temporal(TemporalType.DATE)
	private Date dataInicio;
	private Integer periodo;
	private Integer intervalo;
	
	
	public Dosagem(){
		
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dosagem other = (Dosagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDataInicio() {
		return dataInicioString;
	}


	public void setDataInicio(String dataInicio) {
		this.dataInicioString = dataInicio;
	}


	public Integer getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}


	public Integer getIntervalo() {
		return intervalo;
	}


	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	
	
}

package com.ada.restfulapicursos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DatosSocioEconom {

	@Column(nullable = false)
	private boolean estudia;
	
	@Column(nullable = false)
	private boolean trabaja;
	
	@Column(nullable = false, precision=8, scale=2)
	private BigDecimal ingresoMensual;
	
	@Column(name = "personas_a_cargo", nullable = false)
	private int personasACargo;

	public boolean isEstudia() {
		return estudia;
	}

	public void setEstudia(boolean estudia) {
		this.estudia = estudia;
	}

	public boolean isTrabaja() {
		return trabaja;
	}

	public void setTrabaja(boolean trabaja) {
		this.trabaja = trabaja;
	}

	public BigDecimal getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(BigDecimal ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public int getPersonasACargo() {
		return personasACargo;
	}

	public void setPersonasACargo(int personasACargo) {
		this.personasACargo = personasACargo;
	}
	
	
}

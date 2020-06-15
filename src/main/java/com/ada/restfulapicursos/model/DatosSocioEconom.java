package com.ada.restfulapicursos.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DatosSocioEconom {

	@Column(nullable = false)
	private boolean estudia;
	
	@Column(nullable = false)
	private boolean trabaja;
	
	@Column(nullable = false)
	private Float ingresoMensual;
	
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

	public Float getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(Float ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public int getPersonasACargo() {
		return personasACargo;
	}

	public void setPersonasACargo(int personasACargo) {
		this.personasACargo = personasACargo;
	}
	
	
}

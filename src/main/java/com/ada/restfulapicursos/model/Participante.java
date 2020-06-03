package com.ada.restfulapicursos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participantes")
public class Participante {
	
	@Id
	@Column(nullable = false, unique = true)
	private int partId;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;
	
	@Column(nullable = false)
	private LocalDate fechaNacimiento;
	
	@Column(nullable = false)
	private char genero;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String provincia;
	
	@Column(nullable = false)
	private boolean estudia;
	
	@Column(nullable = false)
	private boolean trabaja;
	
	
	public int getPartId() {
		return partId;
	}

	public void setPartId(int partId) {
		this.partId = partId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setIngresos(Float ingresos) {
		this.ingresos = ingresos;
	}
	
	private Float ingresos;
	
	@Column(name = "personas_a_cargo")
	private int personasACargo;

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

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

	public float getIngresos() {
		return ingresos;
	}

	public void setIngresos(float ingresos) {
		this.ingresos = ingresos;
	}

	public int getPersonasACargo() {
		return personasACargo;
	}

	public void setPersonasACargo(int personasACargo) {
		this.personasACargo = personasACargo;
	}

}

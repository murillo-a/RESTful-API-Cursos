package com.ada.restfulapicursos.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "participantes")
public class Participante {
	
	@Id
	@Column(nullable = false, unique = true)
	private Long partId;

	@OneToOne(fetch = FetchType.EAGER)
	@MapsId
	@JoinColumn(name = "part_id")
	private User user;
	
	@Column(nullable = false)
	private LocalDate fechaNacimiento;
	
	@Column(nullable = false)
	private char genero;
	
	@Column(nullable = false)
	private String ciudad;
	
	@Column(nullable = false)
	private String provincia;

	@Embedded
	private DatosSocioEconom datosSocioEconom;
	
	public DatosSocioEconom getDatosSocioEconom() {
		return datosSocioEconom;
	}

	public void setDatosSocioEconom(DatosSocioEconom datosSocioEconom) {
		this.datosSocioEconom = datosSocioEconom;
	}

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

}

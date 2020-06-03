package com.ada.restfulapicursos.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "representantes")
public class Representante {

	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(nullable = false, unique = true)
	private int repId;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "rep_id")
	private User user;

	@Column(nullable = false)
	private String tipoDeDoc;

	@Column(nullable = false)
	private String nroDeDoc;

	@Column(nullable = false)
	private String cargoEnEmpresa;

	
	
	public int getRepId() {
		return repId;
	}

	public void setRepId(int repId) {
		this.repId = repId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTipoDeDoc() {
		return tipoDeDoc;
	}

	public void setTipoDeDoc(String tipoDeDoc) {
		this.tipoDeDoc = tipoDeDoc;
	}

	public String getNroDeDoc() {
		return nroDeDoc;
	}

	public void setNroDeDoc(String nroDeDoc) {
		this.nroDeDoc = nroDeDoc;
	}

	public String getCargoEnEmpresa() {
		return cargoEnEmpresa;
	}

	public void setCargoEnEmpresa(String cargoEnEmpresa) {
		this.cargoEnEmpresa = cargoEnEmpresa;
	}

}

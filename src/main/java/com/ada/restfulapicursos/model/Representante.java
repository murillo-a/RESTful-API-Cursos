package com.ada.restfulapicursos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "representantes")
public class Representante {

	@Id
	@Column(nullable = false, unique = true)
	private Long repId;

	@OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "rep_id")
	private User user;

	@Column(nullable = false)
	private String tipoDeDoc;

	@Column(nullable = false)
	private String nroDeDoc;

	@Column(nullable = false)
	private String cargoEnEmpresa;

	public Long getRepId() {
		return repId;
	}

	public void setRepId(Long repId) {
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

package com.ada.restfulapicursos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "rep_id")
public class Representante extends User {

	private String tipoDeDoc;
	private String nroDeDoc;
	private String cargoEnEmpresa;	
	
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

package com.ada.restfulapicursos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Integer empresaId;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false, unique = true)
	private String cuil;
	
	private String tipoDeEmpresa;
	private String direccion;
	private String categoria;
	private String anioFundacion;
	
	@Column(nullable = false)
	private String telef;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rep_id", nullable = false)
	private Representante representante;
	
	public Empresa(String nombre, String cuil, String tipoDeEmpresa, String direccion, String categoria,
			String anioFundacion, String telef, Representante representante) {
		this.nombre = nombre;
		this.cuil = cuil;
		this.tipoDeEmpresa = tipoDeEmpresa;
		this.direccion = direccion;
		this.categoria = categoria;
		this.anioFundacion = anioFundacion;
		this.telef = telef;
		this.representante = representante;
	}
	
	public Empresa() {
	}
	
	public Integer getEmpresaId() {
		return empresaId;
	}
	public void setEmpresaId(Integer id) {
		this.empresaId = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuil() {
		return cuil;
	}
	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	public String getTipoDeEmpresa() {
		return tipoDeEmpresa;
	}
	public void setTipoDeEmpresa(String tipoDeEmpresa) {
		this.tipoDeEmpresa = tipoDeEmpresa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getAnioFundacion() {
		return anioFundacion;
	}
	public void setAnioFundacion(String anioFundacion) {
		this.anioFundacion = anioFundacion;
	}
	public String getTelef() {
		return telef;
	}
	public void setTelef(String telef) {
		this.telef = telef;
	}
	public Representante getRepresentante() {
		return representante;
	}
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	
	

}

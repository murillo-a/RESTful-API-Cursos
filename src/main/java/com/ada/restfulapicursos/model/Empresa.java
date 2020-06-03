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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "empresas", uniqueConstraints={@UniqueConstraint(columnNames = {"id", "cuil"} ) })
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private Integer id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String cuil;
	
	private String tipoDeEmpresa;
	private String direccion;
	private String categoria;
	private String anioFundacion;
	
	@Column(nullable = false)
	private String telef;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rep_id", insertable=false, updatable=false, nullable = false)
	private Representante representante;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

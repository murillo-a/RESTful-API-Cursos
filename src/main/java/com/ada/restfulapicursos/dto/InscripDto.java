package com.ada.restfulapicursos.dto;

import javax.validation.constraints.NotBlank;

public class InscripDto {

	@NotBlank
	private int cursoId;
	
	@NotBlank
	private Long partId;
	
	@NotBlank
	private int porcentPedido;
	
	private String estado;
	
	public int getCursoId() {
		return cursoId;
	}
	public void setCursoId(int cursoId) {
		this.cursoId = cursoId;
	}
	public Long getPartId() {
		return partId;
	}
	public void setPartId(Long partId) {
		this.partId = partId;
	}
	public int getPorcentPedido() {
		return porcentPedido;
	}
	public void setPorcentPedido(int porcentPedido) {
		this.porcentPedido = porcentPedido;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}

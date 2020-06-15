package com.ada.restfulapicursos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "part_id")
	private Participante participante;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	private int porcentPedido;

	@Column(columnDefinition = "varchar(9) check (estado IN ('pendiente', 'aprobada', 'rechazada'))")
	private String estado;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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

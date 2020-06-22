package com.ada.restfulapicursos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

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

	@Column(columnDefinition = "TINYINT(3) CHECK (porcent_pedido IN (0, 25, 75, 100))")
	private int porcentPedido;

	@Size(min = 8, max = 9)
	@Column(columnDefinition = "VARCHAR(9) DEFAULT 'pendiente' CHECK (estado IN ('pendiente', 'aprobado', 'rechazado', 'cursando', 'terminado'))")
	private String estado;
	
	public Inscripcion() {
		
	}
	
	public Inscripcion(Participante participante, Curso curso, int porcentPedido, String aprobacion) {
		this.participante = participante;
		this.curso = curso;
		this.porcentPedido = porcentPedido;
		this.estado = aprobacion;
	}

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

	public String getAprobacion() {
		return estado;
	}

	public void setAprobacion(String aprobacion) {
		this.estado = aprobacion;
	}

}

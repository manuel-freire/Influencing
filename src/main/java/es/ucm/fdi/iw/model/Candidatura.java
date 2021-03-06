package es.ucm.fdi.iw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Candidatura.byCandidato", 
	query="SELECT c.propuesta FROM Candidatura c WHERE c.candidato.id = :idCandidato"),
	
	@NamedQuery(name="Candidatura.activeByCandidato", 
	query="SELECT c FROM Candidatura c WHERE c.candidato.id = :idCandidato AND (c.estado = 'EN_CURSO' OR c.estado = 'NEGOCIANDO')"),

	@NamedQuery(name="Candidatura.activeByIdUsuario", 
			query="SELECT c FROM Candidatura c WHERE (c.candidato.id = :idUsuario OR c.propuesta.empresa.id = :idUsuario) AND (c.estado = 'EN_CURSO' OR c.estado = 'NEGOCIANDO')"),

	
	@NamedQuery(name="Candidatura.searchByName",
	query="SELECT c FROM Candidatura c WHERE c.propuesta.nombre LIKE :patron AND (c.candidato.id = :idUsuario OR c.propuesta.empresa.id = :idUsuario)"),
	
	@NamedQuery(name="Candidatura.getAllActive",
	query="SELECT c FROM Candidatura c WHERE c.aceptada = true AND (c.estado = 'EN_CURSO' OR c.estado = 'NEGOCIANDO')"),

	@NamedQuery(name="Candidatura.getPendingCandidatures",
	query="SELECT c FROM Candidatura c WHERE c.aceptada = false AND (c.estado = 'EN_CURSO' OR c.estado = 'NEGOCIANDO')"),
	
	@NamedQuery(name="Candidatura.getAllActiveById",
	query="SELECT c FROM Candidatura c WHERE c.aceptada = true AND (c.estado = 'EN_CURSO' OR c.estado = 'NEGOCIANDO') AND (c.candidato.id = :idUsuario OR c.propuesta.empresa.id = :idUsuario)"),

	@NamedQuery(name="Candidatura.getPendingCandidaturesById",
	query="SELECT c FROM Candidatura c WHERE c.aceptada = false AND (c.estado = 'EN_CURSO' OR c.estado = 'NEGOCIANDO') AND (c.candidato.id = :idUsuario OR c.propuesta.empresa.id = :idUsuario)"),
	
	@NamedQuery(name="Candidatura.getByUser",
		query="SELECT c FROM Candidatura c WHERE c.candidato.id = :idUsuario OR c.propuesta.empresa.id = :idUsuario")
})

public class Candidatura {

	private long id;
	private Propuesta propuesta;
	private Usuario candidato;
	private Boolean aceptada;
	public enum Estado {NEGOCIANDO, EN_CURSO, FINALIZADA};
	private String estado;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(targetEntity = Propuesta.class)
	public Propuesta getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(Propuesta propuesta) {
		this.propuesta = propuesta;
	}

	@ManyToOne(targetEntity = Usuario.class)
	public Usuario getCandidato() {
		return candidato;
	}

	public void setCandidato(Usuario candidato) {
		this.candidato = candidato;
	}

	public Boolean getAceptada() {
		return aceptada;
	}

	public void setAceptada(Boolean aceptada) {
		this.aceptada = aceptada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Candidatura #" + id;
	}

}

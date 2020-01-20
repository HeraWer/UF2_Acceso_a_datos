package biblioteca;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Llibres {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_llibre")
	private int id_llibre;

	@Column(name = "nomLlibre")
	private String nomLlibre;

	@Column(name = "editoria")
	private String editoria;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUTOR_ID")
	private Autor autor;

	@ManyToMany(mappedBy = "llibres")
	private Set<Persona> persones;

	@Override
	public String toString() {
		return "Llibres [id_llibre=" + id_llibre + ", nomLlibre=" + nomLlibre + ", editoria=" + editoria + ", autor="
				+ autor + ", persones=" + persones + ", biblioteques=" + biblioteques + "]";
	}

	@ManyToMany(mappedBy = "llibres")
	private Set<Biblioteca> biblioteques;

	public int getId_llibre() {
		return id_llibre;
	}

	public void setId_llibre(int id_llibre) {
		this.id_llibre = id_llibre;
	}

	public String getNomLlibre() {
		return nomLlibre;
	}

	public void setNomLlibre(String nomLlibre) {
		this.nomLlibre = nomLlibre;
	}

	public String getEditoria() {
		return editoria;
	}

	public void setEditoria(String editoria) {
		this.editoria = editoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}

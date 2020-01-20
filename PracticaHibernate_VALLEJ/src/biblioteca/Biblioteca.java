package biblioteca;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_biblioteca")
	private int id_biblioteca;

	@Column(name = "nom")
	private String nom;

	@Override
	public String toString() {
		return "Biblioteca [id_biblioteca=" + id_biblioteca + ", nom=" + nom + ", llibres=" + llibres + "]";
	}

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "bibliotecallibre", joinColumns = { @JoinColumn(name = "id_biblio") }, inverseJoinColumns = {
			@JoinColumn(name = "id_llibre") })
	private Set<Llibres> llibres;

	public Set<Llibres> getLlibres() {
		return llibres;
	}

	public void setLlibres(Set<Llibres> llibres) {
		this.llibres = llibres;
	}

	public int getId_biblioteca() {
		return id_biblioteca;
	}

	public void setId_biblioteca(int id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

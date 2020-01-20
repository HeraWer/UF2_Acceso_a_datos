package biblioteca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor")
	private int id_autor;

	@Column(name = "nomAutor")
	private String nomAutor;

	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	private List<Llibres> libros = new ArrayList<>();

	public List<Llibres> getLibros() {
		return libros;
	}

	public void setLibros(List<Llibres> libros) {
		this.libros = libros;
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		this.id_autor = id_autor;
	}

	public String getNomAutor() {
		return nomAutor;
	}

	public void setNomAutor(String nomAutor) {
		this.nomAutor = nomAutor;
	}

	@Override
	public String toString() {
		return "Autor [id_autor=" + id_autor + ", nomAutor=" + nomAutor + ", libros=" + libros + "]";
	}
	
	

}

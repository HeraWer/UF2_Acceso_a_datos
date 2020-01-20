package biblioteca;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

public class Persona {

	@Id
	@Column(name = "dni")
	private int dni;

	@Column(name = "nom")
	private String nomPersona;

	@Column(name = "telefon")
	private int telefon;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "personallibre", joinColumns = { @JoinColumn(name = "dni_persona") }, inverseJoinColumns = {
			@JoinColumn(name = "id_llibre") })
	private Set<Llibres> llibres;

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nomPersona=" + nomPersona + ", telefon=" + telefon + ", llibres=" + llibres
				+ "]";
	}

	public Set<Llibres> getLlibres() {
		return llibres;
	}

	public void setLlibres(Set<Llibres> llibres) {
		this.llibres = llibres;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNomPersona() {
		return nomPersona;
	}

	public void setNomPersona(String nomPersona) {
		this.nomPersona = nomPersona;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}

}

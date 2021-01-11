 package it.prova.gestioneRegistaJPA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "titolo")
	private String titolo;
	@Column(name = "genere")
	private String genere;
	@Column(name = "durata")
	private int durata;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "regista_id")
	private Regista regista;

	public Film() {
	}

	public Film(String titolo, String genere, int durata) {
		super();
		this.titolo = titolo;
		this.genere = genere;
		this.durata = durata;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}

	@Override
	public String toString() {
		return "Film [id= " + id + "titolo= " + titolo + ", genere= " + genere + ", durata= " + durata + "]";
	}

}

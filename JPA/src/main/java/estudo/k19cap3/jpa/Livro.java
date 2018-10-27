package estudo.k19cap3.jpa;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Livro {

	@Id
	@GeneratedValue
	private Long id;

	private String titulo;

	@ManyToMany
	private Collection<Autor> autor = new ArrayList<Autor>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Collection<Autor> getAutor() {
		return autor;
	}

	public void setAutor(Collection<Autor> autor) {
		this.autor = autor;
	}


}

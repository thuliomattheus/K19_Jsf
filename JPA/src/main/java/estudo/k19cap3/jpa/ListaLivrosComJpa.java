package estudo.k19cap3.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaLivrosComJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("SELECT l FROM Livro l");

		@SuppressWarnings("unchecked")
		List<Livro> livros = query.getResultList();

		System.out.println("Livros:");

		for(Livro l : livros) {
			System.out.println("\t" + l.getTitulo() + " - " + l.getPreco());
		}

		manager.close();
		factory.close();
	}

}

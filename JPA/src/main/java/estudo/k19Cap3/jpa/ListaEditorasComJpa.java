package estudo.k19Cap3.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaEditorasComJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("SELECT e FROM Editora e");

		@SuppressWarnings("unchecked")
		List<Editora> editoras = query.getResultList();

		System.out.println("Editoras:");

		for(Editora e : editoras) {
			System.out.println("\t" + e.getNome() + " - " + e.getEmail());
		}

		manager.close();
		factory.close();
	}
}

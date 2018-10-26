package estudo.k19cap3.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaClientesComJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("SELECT c FROM Cliente c");

		@SuppressWarnings("unchecked")
		List<Cliente> clientes = query.getResultList();

		System.out.println("Clientes:");

		for(Cliente c : clientes) {
			System.out.println("\t" + c.getNome() + " - " + c.getEndereco().getCidade());
		}

		manager.close();
		factory.close();
	}
}

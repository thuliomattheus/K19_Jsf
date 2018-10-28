package estudo.k19Cap3.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaRevista {

	public static void main(String[] args) {

		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		for(int i=0; i<15; i++) {
			Revista r = new Revista();
			r.setNome("Revista " + i);
			r.setPreco(10.0 * i+1);
			manager.persist(r);
		}

		manager.getTransaction().commit();

		manager.close();
		factory.close();
		System.out.println("15 revistas foram adicionadas");
	}
}

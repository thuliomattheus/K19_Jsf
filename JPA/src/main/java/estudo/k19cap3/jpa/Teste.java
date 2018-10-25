package estudo.k19cap3.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("livraria-pu");

		factory.close();
	}

}

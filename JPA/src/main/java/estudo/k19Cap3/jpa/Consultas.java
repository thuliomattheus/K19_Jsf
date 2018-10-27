package estudo.k19Cap3.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Consultas {

	public static void main(String[] args) {

		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		// Contando quantas revistas existem no banco
		String jpql = "SELECT COUNT(r) FROM Revista r";

		// Cria uma consulta passando a query e o tipo de retorno
		TypedQuery<Long> consulta1 = manager.createQuery(jpql, Long.class);

		Long contador = consulta1.getSingleResult();

		System.out.println("Há " + contador + " revistas.\n");

		jpql = "SELECT COUNT(r) FROM Revista r WHERE r.preco > 100";

		// Cria uma consulta passando a query e o tipo de retorno
		TypedQuery<Long> consulta2 = manager.createQuery(jpql, Long.class);

		contador = consulta2.getSingleResult();

		System.out.println("Há " + contador + " revistas que custam mais de 100.\n");

		jpql = "SELECT SUM(r.preco) FROM Revista r";

		// Cria uma consulta passando a query e o tipo de retorno
		TypedQuery<Double> consulta3 = manager.createQuery(jpql, Double.class);

		double somatorio = consulta3.getSingleResult();

		System.out.println("O preço total das revistas é " + somatorio + "\n");

		jpql = "SELECT AVG(r.preco) FROM Revista r";

		// Cria uma consulta passando a query e o tipo de retorno
		TypedQuery<Double> consulta4 = manager.createQuery(jpql, Double.class);

		double media = consulta4.getSingleResult();

		System.out.println("O preço médio das revistas é " + media + "\n");

		jpql = "SELECT r FROM Revista r";

		// Cria uma consulta passando a query e o tipo de retorno
		TypedQuery<Revista> consulta5 = manager.createQuery(jpql, Revista.class);

		List<Revista> revistas = consulta5.getResultList();

		System.out.println("-------------------------------");
		for(Revista r : revistas) {
			System.out.println("Id   :" + r.getId() + "\n");
			System.out.println("Nome :" + r.getNome() + "\n");
			System.out.println("Preço:" + r.getPreco());
			System.out.println("-------------------------------");
		}

		manager.close();
		factory.close();

	}
}

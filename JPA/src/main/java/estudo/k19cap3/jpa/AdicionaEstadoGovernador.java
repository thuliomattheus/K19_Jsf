package estudo.k19cap3.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaEstadoGovernador {

	public static void main(String[] args) {
		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		Scanner entrada = new Scanner(System.in);

		Governador g = new Governador();
		System.out.println("Digite o nome do governador: ");
		g.setNome(entrada.nextLine());

		Estado e = new Estado();
		System.out.println("Digite o nome do estado: ");
		e.setNome(entrada.nextLine());

		entrada.close();

		e.setGovernador(g);

		manager.persist(g);
		manager.persist(e);

		manager.getTransaction().commit();

		System.out.println(
			"O governador " + g.getNome() + " foi eleito em " + e.getNome()
			);

		manager.close();
		factory.close();
	}
}

package estudo.k19cap3.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoveLivroComJpa {

	public static void main(String[] args) {
		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o id do livro que deseja remover: ");
		Long id = entrada.nextLong();

		entrada.close();

		Livro l = manager.find(Livro.class, id);

		manager.remove(l);

		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Livro removido!");
		manager.close();
		factory.close();
	}

}

package estudo.k19cap3.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraLivroComJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o id do livro que deseja alterar: ");
		Long id = Long.parseLong(entrada.nextLine());

		Livro l = manager.find(Livro.class, id);

		System.out.println("Digite o novo nome do livro");
		l.setTitulo(entrada.nextLine());

		System.out.println("Digite o novo preço do livro");
		l.setPreco(entrada.nextDouble());

		entrada.close();

		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Livro de id = " + l.getId()+ " foi atualizado!");
		manager.close();
		factory.close();
	}
}

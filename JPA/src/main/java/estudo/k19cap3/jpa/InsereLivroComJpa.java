package estudo.k19cap3.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsereLivroComJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();
		Livro novoLivro = new Livro();
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o título do livro: ");
		novoLivro.setTitulo(entrada.nextLine());

		System.out.println("Digite o preço do livro: ");
		novoLivro.setPreco(entrada.nextDouble());

		System.out.println("Digite o id da editora: ");
		novoLivro.setEditoraId(entrada.nextLong());

		entrada.close();

		manager.persist(novoLivro);
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		System.out.println("Livro cadastrado com id: " + novoLivro.getId());

		manager.close();
		factory.close();
	}

}

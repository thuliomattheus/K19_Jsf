package estudo.k19Cap3.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaLivroAutor {

	public static void main(String[] args) {

		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Livro l = new Livro();
		Autor a = new Autor();
		Scanner entrada = new Scanner(System.in);

		System.out.println("Digite o nome do livro");
		l.setTitulo(entrada.nextLine());

		System.out.println("Digite o nome do autor");
		a.setNome(entrada.nextLine());
		l.getAutor().add(a);

		entrada.close();

		manager.getTransaction().begin();
		manager.persist(l);
		manager.persist(a);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
		System.out.println("Livro " + l.getTitulo() + " de " + a.getNome() + " adicionado!");
	}
}

package estudo.k19cap3.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaDepartamentoFuncionario {

	public static void main(String[] args) {

		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager =	factory.createEntityManager();

		manager.getTransaction().begin();

		Scanner entrada = new Scanner(System.in);

		Departamento d = new Departamento();
		System.out.println("Digite o nome do Departamento");
		d.setNome(entrada.nextLine());

		boolean temNovo = true;

		while(temNovo) {
			Funcionario f = new Funcionario();
			System.out.println("\nDigite o nome do funcionário");
			f.setNome(entrada.nextLine());
			d.getFuncionarios().add(f);

			System.out.println("Caso desejar adicionar outro funcionário digite y");
			if(!entrada.nextLine().equalsIgnoreCase("y")) {
				temNovo = false;
			}

			// Adiciona o funcionário
			manager.persist(f);

		}

		entrada.close();

		// Adiciona o departamento
		manager.persist(d);
		manager.getTransaction().commit();

		System.out.println("Departamento " + d.getNome() + " e seus funcionários foram adicionados!");
		manager.close();
		factory.close();
	}
}

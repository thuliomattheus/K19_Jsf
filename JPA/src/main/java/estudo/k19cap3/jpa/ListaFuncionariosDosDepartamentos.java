package estudo.k19cap3.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaFuncionariosDosDepartamentos {

	public static void main(String[] args) {

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("SELECT f FROM Departamento d JOIN d.funcionarios f");

		@SuppressWarnings("unchecked")
		List<Funcionario> funcs = query.getResultList();

		System.out.println("Funcionários:");

		for(Funcionario f : funcs) {
			System.out.println("\t" + f.getNome());
		}

		manager.close();
		factory.close();
	}

}

package estudo.k19cap3.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ListaPedidosDosClientes {

	public static void main(String[] args) {

		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		Query query = manager.createQuery("SELECT p FROM Pedido p JOIN p.cliente c");

		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = query.getResultList();

		System.out.println("Clientes:");

		for(Pedido p : pedidos) {
			System.out.println("\t" + p.getCliente().getNome() + " - " + p.getData().getTime());
		}

		manager.close();
		factory.close();
	}


}

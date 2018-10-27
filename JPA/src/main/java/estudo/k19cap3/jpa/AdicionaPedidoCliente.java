package estudo.k19cap3.jpa;

import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AdicionaPedidoCliente {

	public static void main(String[] args) {

		EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("livraria-pu");

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		Scanner entrada = new Scanner(System.in);

		Cliente c = new Cliente();
		System.out.println("Digite o nome do cliente");
		c.setNome(entrada.nextLine());

		System.out.println("Digite o cpf do cliente");
		c.setCpf(entrada.nextLine());

		Pedido p = new Pedido();
		p.setData(Calendar.getInstance());

		p.setCliente(c);

		entrada.close();

		manager.persist(c);
		manager.persist(p);

		manager.getTransaction().commit();

		System.out.println("Pedido do cliente " + c.getNome() + " realizado em " + p.getData().getTime());
		manager.close();
		factory.close();
	}
}

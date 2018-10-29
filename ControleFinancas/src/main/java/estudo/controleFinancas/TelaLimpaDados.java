package estudo.controleFinancas;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TelaLimpaDados implements Tela{

	private Tela anterior;

	public TelaLimpaDados(Tela anterior) {
		this.anterior = anterior;
	}

	public Tela mostra() {
		System.out.println(">>> " + this.getNome() + " <<<\n");

		System.out.println("Limpando dados...");

		EntityManager manager = App.getEntityManager();
		manager.getTransaction().begin();

		Query query = manager.createQuery("DELETE FROM Receita");
		query.executeUpdate();

		query = manager.createQuery("DELETE FROM Despesa");
		query.executeUpdate();

		manager.getTransaction().commit();
		manager.close();

		System.out.println("Dados limpos");

		return this.anterior;
	}

	public String getNome() {
		return "Limpa Dados";
	}
}

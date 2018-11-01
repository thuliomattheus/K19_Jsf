package estudo.controleFinancas;

import javax.persistence.EntityManager;

public class TelaAdicionarDespesa extends TelaAdicionarFinanca implements Tela {

	public TelaAdicionarDespesa(Tela anterior) {
		super(anterior);
	}

	public Tela mostra() {
		Despesa d = new Despesa();
		super.mostra(d);

		EntityManager manager = App.getEntityManager();
		manager.getTransaction().begin();

		RepositorioDespesas rd = new RepositorioDespesas(manager);
		rd.adiciona(d);

		manager.getTransaction().commit();
		manager.close();

		System.out.println("\nDespesa adicionada!\n");

		return this.anterior;
	}

	public String getNome() {
		return super.getNome("Despesa");
	}
}

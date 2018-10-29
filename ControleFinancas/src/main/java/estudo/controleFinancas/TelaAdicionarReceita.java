package estudo.controleFinancas;

import javax.persistence.EntityManager;

public class TelaAdicionarReceita extends TelaAdicionarFinanca implements Tela {

	public TelaAdicionarReceita(Tela anterior) {
		super(anterior);
	}

	public Tela mostra() {
		Receita r = new Receita();
		super.mostra(r);

		EntityManager manager = App.getEntityManager();
		manager.getTransaction().begin();

		RepositorioReceitas rr = new RepositorioReceitas(manager);
		rr.adiciona(r);

		manager.getTransaction().commit();
		manager.close();

		System.out.println("Receita adicionada!");

		return this.anterior;
	}

	public String getNome() {
		return super.getNome("Receita");
	}
}

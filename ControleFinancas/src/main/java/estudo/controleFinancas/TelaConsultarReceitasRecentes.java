package estudo.controleFinancas;

public class TelaConsultarReceitasRecentes extends TelaConsultarFinancasRecentes implements Tela {

	public TelaConsultarReceitasRecentes(Tela anterior) {
		super(anterior);
	}

	public Tela mostra() {
		Receita r = new Receita();
		RepositorioReceitas rr = new RepositorioReceitas(App.getEntityManager());
		return super.mostra(rr, r);
	}

	public String getNome() {
		return super.getNome("Receita");
	}
}

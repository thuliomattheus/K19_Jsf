package estudo.controleFinancas;

public class TelaConsultarReceitasPorPeriodo extends TelaConsultarFinancasPorPeriodo implements Tela {

	public TelaConsultarReceitasPorPeriodo(Tela anterior) {
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

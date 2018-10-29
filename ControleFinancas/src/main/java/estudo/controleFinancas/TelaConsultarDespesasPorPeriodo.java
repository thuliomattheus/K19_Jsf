package estudo.controleFinancas;

public class TelaConsultarDespesasPorPeriodo extends TelaConsultarFinancasPorPeriodo implements Tela {

	public TelaConsultarDespesasPorPeriodo(Tela anterior) {
		super(anterior);
	}

	public Tela mostra() {
		Despesa d = new Despesa();
		RepositorioDespesas rd = new RepositorioDespesas(App.getEntityManager());
		return super.mostra(rd, d);
	}

	public String getNome() {
		return super.getNome("Despesa");
	}
}

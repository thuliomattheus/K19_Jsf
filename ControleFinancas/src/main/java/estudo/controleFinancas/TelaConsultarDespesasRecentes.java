package estudo.controleFinancas;

public class TelaConsultarDespesasRecentes extends TelaConsultarFinancasRecentes implements Tela {

	public TelaConsultarDespesasRecentes(Tela anterior) {
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

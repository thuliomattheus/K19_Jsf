package estudo.controleFinancas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

public class TelaRelatorioPersonalizado implements Tela {

	private Tela anterior;

	public TelaRelatorioPersonalizado(Tela anterior) {
		this.anterior = anterior;
	}

	public Tela mostra() {

		System.out.println(">>> " + this.getNome() + " <<<\n");

		Calendar dataInicial=null, dataFinal=null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		while(dataInicial==null) {
			System.out.println("Digite a data inicial (ex: 05/08/2016): ");

			try {
				Date d = sdf.parse(App.getEntrada().next());
				dataInicial = Calendar.getInstance();
				dataInicial.setTime(d);
			}
			catch(ParseException e) {
				System.out.println("Data incorreta");
			}
		}

		while(dataFinal==null) {
			System.out.println("Digite a data final (ex: 05/08/2016): ");

			try {
				Date d = sdf.parse(App.getEntrada().next());
				dataFinal = Calendar.getInstance();
				dataFinal.setTime(d);
			}
			catch(ParseException e) {
				System.out.println("Data incorreta");
			}
		}

		EntityManager manager = App.getEntityManager();

		RepositorioReceitas rr = new RepositorioReceitas(manager);
		RepositorioDespesas rd = new RepositorioDespesas(manager);

		double receitas, despesas;

		// Verificando se existiu alguma receita no período informado
		try {
			receitas = rr.somaReceitas(dataInicial, dataFinal);
		}
		catch(NullPointerException e) {
			receitas = 0;
		}

		// Verificando se existiu alguma despesa no período informado
		try {
			despesas = rd.somaDespesas(dataInicial, dataFinal);
		}
		catch(NullPointerException e) {
			despesas = 0;
		}
		manager.close();

		System.out.println("\nPeríodo : " + sdf.format(dataInicial.getTime()) + " - " + sdf.format(dataFinal.getTime()));
		System.out.println("Receitas : " + receitas);
		System.out.println("Despesas : " + despesas);
		System.out.println("Saldo do Período : " + (receitas-despesas) + "\n");

		return this.anterior;
	}

	public String getNome() {
		return "Relatório Personalizado";
	}
}

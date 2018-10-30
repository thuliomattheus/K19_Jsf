package estudo.controleFinancas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import javax.persistence.EntityManager;

public class TelaRelatorioMensal implements Tela {

	private Tela anterior;

	public TelaRelatorioMensal(Tela anterior) {
		this.anterior = anterior;
	}

	public Tela mostra() {

		System.out.println(">>> " + this.getNome() + " <<<\n");

		int mes = -1;

		while(mes < 1 || mes > 12) {
			System.out.println("Digite o mês [1 - 12]: ");

			try {
				mes = App.getEntrada().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Valor inválido");
				continue;
			}

			if(mes < 1 || mes > 12) {
				System.out.println("Valor inválido");
			}
		}

		int ano = -1;

		while(ano < 1900 || ano > 3000) {
			System.out.println("Digite o ano [1900 - 3000]: ");

			try {
				ano = App.getEntrada().nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Valor inválido");
				continue;
			}

			if(ano < 1900 || ano > 3000) {
				System.out.println("Valor inválido");
			}
		}

		// Primeiro dia do mês
		Calendar dataInicial = new GregorianCalendar(ano, mes-1, 1);

		// Último dia do mês
		Calendar dataFinal = new GregorianCalendar(ano, mes, 0);

		// Formatação da data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

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

		System.out.println("\nPeríodo  : " + sdf.format(dataInicial.getTime()) + " - " + sdf.format(dataFinal.getTime()));
		System.out.println("Receitas : " + receitas);
		System.out.println("Despesas : " + despesas);
		System.out.println("Saldo    : " + (receitas - despesas) + "\n");

		return this.anterior;
	}

	public String getNome() {
		return "Relatório Mensal";
	}
}

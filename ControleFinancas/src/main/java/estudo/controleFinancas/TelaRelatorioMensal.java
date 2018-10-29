package estudo.controleFinancas;

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

		Calendar dataInicial = new GregorianCalendar(ano, mes-1, 1);
		Calendar dataFinal = new GregorianCalendar(ano, mes-1, 1);

		EntityManager manager = App.getEntityManager();

		RepositorioReceitas rr = new RepositorioReceitas(manager);
		RepositorioDespesas rd = new RepositorioDespesas(manager);

		double receitas = rr.somaReceitas(dataInicial, dataFinal);
		double despesas = rd.somaDespesas(dataInicial, dataFinal);

		manager.close();

		System.out.println("Receitas: " + receitas);
		System.out.println("Despesas: " + despesas);
		System.out.println("Saldo do período: " + (receitas - despesas) + "\n");

		return this.anterior;
	}

	public String getNome() {
		return "Relatório Mensal";
	}
}

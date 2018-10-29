package estudo.controleFinancas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;

public class TelaRelatorioConsolidado implements Tela {

	private Tela anterior;

	public TelaRelatorioConsolidado(Tela anterior) {
		this.anterior = anterior;
	}

	public Tela mostra() {
		System.out.println(">>> " + this.getNome() + " <<<\n");

		Calendar data = null;

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		while(data == null) {
			System.out.println("Digite uma data (ex: 01/01/2018): ");

			try {
				Date d = sdf.parse(App.getEntrada().next());
				data = Calendar.getInstance();
				data.setTime(d);
			}
			catch(ParseException e) {
				System.out.println("Data incorreta");
			}
		}

		EntityManager manager = App.getEntityManager();

		RepositorioReceitas rr =
			new RepositorioReceitas(manager);

		RepositorioDespesas rd =
			new RepositorioDespesas(manager);

		double receitas = rr.somaReceitasAte(data);
		double despesas = rd.somaDespesasAte(data);

		manager.close();

		System.out.println("Saldo: " + (receitas - despesas) + "\n");

		return this.anterior;
	}

	public String getNome() {
		return "Relatório Consolidado";
	}
}

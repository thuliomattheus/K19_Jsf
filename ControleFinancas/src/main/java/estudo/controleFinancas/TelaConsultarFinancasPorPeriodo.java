package estudo.controleFinancas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

import javax.persistence.EntityManager;


public class TelaConsultarFinancasPorPeriodo {

	protected Tela anterior;

	public TelaConsultarFinancasPorPeriodo(Tela anterior) {
		this.anterior = anterior;
	}

	protected <R extends RepositorioFinancas, T extends Financa> Tela mostra(R repositoryType, T type) {

		System.out.println(">>> " + this.getNome(type.getClass().getSimpleName()) + " <<<");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Calendar dataInicial = null, dataFinal = null;

		while(dataInicial == null) {
			System.out.println("Digite a data inicial (ex: 01/10/2017): ");

			try {
				Date d = sdf.parse(App.getEntrada().next());
				dataInicial = Calendar.getInstance();
				dataInicial.setTime(d);
			}
			catch(ParseException e) {
				System.out.println("Data incorreta");
			}
		}

		while(dataFinal == null) {
			System.out.println("Digite a data final (ex: 01/10/2017): ");

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

		List<T> financas = (List<T>) repositoryType.buscaPorPeriodo(dataInicial, dataFinal, type.getClass());

		int opcao = -1;

		while(opcao < 0 || opcao > financas.size()) {

			for(int i=0; i<financas.size(); i++) {
				System.out.println((i+1) + ". " + financas.get(i));
			}

			System.out.println("\nDigite o número da " +
				type.getClass().getSimpleName().toLowerCase() +
				" que deseja remover.");

			System.out.println("Digite 0 para retornar.");

			try {
				opcao = App.getEntrada().nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Opção incorreta!");
				continue;
			}

			if(opcao < 0 || opcao > financas.size()) {
				System.out.println("Opção incorreta!");
				continue;
			}

			if(opcao != 0) {
				manager.getTransaction().begin();
				repositoryType.remove(financas.get(opcao-1));
				manager.getTransaction().commit();
				financas.remove(opcao-1);

				opcao = -1;

				System.out.println("\n" +
					type.getClass().getSimpleName() +
					" Removida.\n"
				);
			}

		}

		System.out.println();

		return this.anterior;
	}

	protected String getNome(String type) {
		return (type + "s por Período");
	}
}

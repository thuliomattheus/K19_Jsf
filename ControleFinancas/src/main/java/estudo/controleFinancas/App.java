package estudo.controleFinancas;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

	private static Scanner entrada = new Scanner(System.in);

	private static EntityManagerFactory factory =
		Persistence.createEntityManagerFactory("financas-pu");

	public static Scanner getEntrada() {
		return entrada;
	}

	public static EntityManager getEntityManager() {
		return App.factory.createEntityManager();
	}

	public static void main(String[] args) {

		/* Menus */
		TelaMenu principal =
			new TelaMenu("Menu Principal");
		TelaMenu relatorios =
			new TelaMenu("Relatórios");
		TelaMenu receitas =
			new TelaMenu("Receitas");
		TelaMenu despesas =
			new TelaMenu("Despesas");
		TelaGeraDados geraDados =
			new TelaGeraDados(principal);
		TelaLimpaDados limpaDados =
			new TelaLimpaDados(principal);
		TelaSair sair =
			new TelaSair();

		principal.adicionarFilha(relatorios);
		principal.adicionarFilha(receitas);
		principal.adicionarFilha(despesas);
		principal.adicionarFilha(geraDados);
		principal.adicionarFilha(limpaDados);
		principal.adicionarFilha(sair);


		/* Relatórios */
		TelaRelatorioConsolidado consolidado =
			new TelaRelatorioConsolidado(relatorios);
		TelaRelatorioMensal mensal =
			new TelaRelatorioMensal(relatorios);
		TelaRelatorioPersonalizado personalizado =
			new TelaRelatorioPersonalizado(relatorios);

		relatorios.adicionarFilha(consolidado);
		relatorios.adicionarFilha(mensal);
		relatorios.adicionarFilha(personalizado);
		relatorios.adicionarFilha(principal);


		/* Receitas */
		TelaAdicionarReceita adicionarReceita =
			new TelaAdicionarReceita(receitas);
		TelaMenu consultarReceita =
			new TelaMenu("Consultar Receitas");

		receitas.adicionarFilha(adicionarReceita);
		receitas.adicionarFilha(consultarReceita);
		receitas.adicionarFilha(principal);


		/* Tipos de Consultas de Receitas */
		TelaConsultarReceitasPorPeriodo consultarReceitasPorPeriodo =
				new TelaConsultarReceitasPorPeriodo(consultarReceita);
		TelaConsultarReceitasRecentes consultarReceitasRecentes =
				new TelaConsultarReceitasRecentes(consultarReceita);

		consultarReceita.adicionarFilha(consultarReceitasPorPeriodo);
		consultarReceita.adicionarFilha(consultarReceitasRecentes);
		consultarReceita.adicionarFilha(receitas);


		/* Despesas */
		TelaAdicionarDespesa adicionarDespesa =
			new TelaAdicionarDespesa(despesas);
		TelaMenu consultarDespesa =
			new TelaMenu("Consultar Despesas");

		despesas.adicionarFilha(adicionarDespesa);
		despesas.adicionarFilha(consultarDespesa);
		despesas.adicionarFilha(principal);


		/* Tipos de Consultas de Despesas */
		TelaConsultarDespesasPorPeriodo consultarDespesasPorPeriodo =
				new TelaConsultarDespesasPorPeriodo(consultarDespesa);
		TelaConsultarDespesasRecentes consultarDespesasRecentes =
				new TelaConsultarDespesasRecentes(consultarDespesa);

		consultarDespesa.adicionarFilha(consultarDespesasPorPeriodo);
		consultarDespesa.adicionarFilha(consultarDespesasRecentes);
		consultarDespesa.adicionarFilha(despesas);


		App.factory = Persistence.createEntityManagerFactory("financas-pu");

		Tela atual = principal;
		while(atual != null) {
			atual = atual.mostra();
		}

		System.out.println("Até Logo!\n");

		App.entrada.close();
		App.factory.close();
	}
}

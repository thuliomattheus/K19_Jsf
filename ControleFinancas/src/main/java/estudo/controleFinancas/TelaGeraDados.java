package estudo.controleFinancas;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

public class TelaGeraDados implements Tela {

	private Tela anterior;

	public TelaGeraDados(Tela anterior) {
		this.anterior = anterior;
	}

	public Tela mostra() {
		System.out.println(">>> " + this.getNome() + " <<<\n");

		System.out.println("Gerando dados...");

		EntityManager manager = App.getEntityManager();

		RepositorioReceitas repositorioReceitas = new RepositorioReceitas(manager);
		RepositorioDespesas repositorioDespesas = new RepositorioDespesas(manager);

		manager.getTransaction().begin();

		Calendar data0 = new GregorianCalendar(2014, 0, 10);
		Calendar data1 = new GregorianCalendar(2014, 0, 15);
		Calendar data2 = new GregorianCalendar(2014, 0, 20);
		Calendar data3 = new GregorianCalendar(2014, 0, 1);

		Receita[] r = new Receita[4];
		Despesa[] d = new Despesa[4];

		for (int i = 0; i < r.length; i++) {
			r[i] = new Receita();
			d[i] = new Despesa();
		}

		/* Receitas e Despesas*/
		for(int i=0; i<36; i++) {

			r[0].setNome("Salário K19");
			r[0].setTipo("Salário");
			r[0].setValor(8000.0);

			r[1].setNome("VA");
			r[1].setTipo("Vale Alimentação");
			r[1].setValor(400.0);

			r[2].setNome("VR");
			r[2].setTipo("Vale Refeição");
			r[2].setValor(500.0);

			r[3].setNome("Aluguel Casa BH");
			r[3].setTipo("Aluguel");
			r[3].setValor(1000.0);

			d[0].setNome("Aluguel Apto SP");
			d[0].setTipo("Aluguel");
			d[0].setValor(1800.0);

			d[1].setNome("Compras Supermercado");
			d[1].setTipo("Alimentação");
			d[1].setValor(1000.0);

			d[2].setNome("Combustível");
			d[2].setTipo("Transporte");
			d[2].setValor(400.0);

			d[3].setNome("Cinema");
			d[3].setTipo("Lazer");
			d[3].setValor(200.0);

			r[0].setData(data0);
			r[1].setData(data1);
			r[2].setData(data2);
			r[3].setData(data3);

			d[0].setData(data3);
			d[1].setData(data1);
			d[2].setData(data2);
			d[3].setData(data0);

			repositorioReceitas.adiciona(r[0]);
			repositorioReceitas.adiciona(r[1]);
			repositorioReceitas.adiciona(r[2]);
			repositorioReceitas.adiciona(r[3]);

			repositorioDespesas.adiciona(d[0]);
			repositorioDespesas.adiciona(d[1]);
			repositorioDespesas.adiciona(d[2]);
			repositorioDespesas.adiciona(d[3]);
		}

		manager.getTransaction().commit();
		manager.close();

		System.out.println("Dados gerados\n");

		return this.anterior;
	}

	public String getNome() {
		return "Gera Dados";
	}
}

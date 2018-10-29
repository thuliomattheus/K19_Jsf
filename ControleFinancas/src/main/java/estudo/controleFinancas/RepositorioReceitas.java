package estudo.controleFinancas;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

public class RepositorioReceitas extends RepositorioFinancas{

	public RepositorioReceitas(EntityManager manager) {
		super(manager);
	}

	public double somaReceitasAte(Calendar data) {

		return super.somaFinancasAte(data, "Receita");
	}

	public double somaReceitas(Calendar inicio, Calendar fim) {

		return super.somaFinancas(inicio, fim, "Receita");
	}

	public List<Receita> buscaPorPeriodo(Calendar inicio, Calendar fim){

		return super.buscaPorPeriodo(inicio, fim, Receita.class);
	}

	public List<Receita> buscaRecentes(){

		return super.buscaRecentes(Receita.class);
	}

}

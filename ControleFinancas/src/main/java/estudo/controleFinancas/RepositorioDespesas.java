package estudo.controleFinancas;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

public class RepositorioDespesas extends RepositorioFinancas{

	public RepositorioDespesas(EntityManager manager) {
		super(manager);
	}

	public double somaFinancasAte(Calendar data) {

		return super.somaFinancasAte(data, "Despesa");
	}

	public double somaFinancas(Calendar inicio, Calendar fim) {

		return super.somaFinancas(inicio, fim, "Despesa");
	}

	public List<Despesa> buscaPorPeriodo(Calendar inicio, Calendar fim){

		return super.buscaPorPeriodo(inicio, fim, Despesa.class);
	}

	public List<Despesa> buscaRecentes(){

		return super.buscaRecentes(Despesa.class);
	}

}

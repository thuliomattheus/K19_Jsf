package estudo.controleFinancas;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class RepositorioFinancas {

	protected EntityManager manager;

	protected RepositorioFinancas(EntityManager manager) {
		this.manager = manager;
	}

	protected void adiciona(Financa financa) {
		this.manager.persist(financa);
	}

	protected void remove(Financa financa) {
		this.manager.remove(financa);
	}

	protected double somaFinancasAte(Calendar data, String type) {

		String jpql = "SELECT SUM(f.valor) FROM " + type + " f WHERE f.data <= :data";

		TypedQuery<Double> query = this.manager.createQuery(jpql, Double.class);

		query.setParameter("data", data);

		return query.getSingleResult();
	}

	protected double somaFinancas(Calendar inicio, Calendar fim, String type) {

		String jpql = "SELECT SUM(f.valor) FROM " + type + " f WHERE " +
			" f.data >= :dataInicial AND f.data <= :dataFinal";

		TypedQuery<Double> query = this.manager.createQuery(jpql, Double.class);

		query.setParameter("dataInicial", inicio);
		query.setParameter("dataFinal", fim);

		return query.getSingleResult();
	}

	protected <T extends Financa> List<T> buscaPorPeriodo(Calendar inicio, Calendar fim, Class<T> type){

		String jpql = "SELECT f FROM " + type.getSimpleName() + " f WHERE " +
				" f.data >= :dataInicial AND f.data <= :dataFinal ORDER BY f.data";

		TypedQuery<T> query = this.manager.createQuery(jpql, type);

		query.setParameter("dataInicial", inicio);
		query.setParameter("dataFinal", fim);

		return (List<T>) query.getResultList();
	}

	protected <T extends Financa> List<T> buscaRecentes(Class<T> type){

		String jpql = "SELECT f FROM " + type.getSimpleName() + " f ORDER BY f.id DESC";

		TypedQuery<T> query = this.manager.createQuery(jpql, type);

		query.setMaxResults(10);

		return (List<T>) query.getResultList();
	}
}

package estudo.controleFinancas;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

public class RepositorioReceitas extends RepositorioFinancas{

	public RepositorioReceitas(EntityManager manager) {
		super(manager);
	}

	public double somaFinancasAte(Calendar data) {

		return super.somaFinancasAte(data, "Receita");
	}

	public double somaFinancas(Calendar inicio, Calendar fim) {

		return super.somaFinancas(inicio, fim, "Receita");
	}

	public List<Receita> buscaPorPeriodo(Calendar inicio, Calendar fim){

		return super.buscaPorPeriodo(inicio, fim, Receita.class);
	}

	public List<Receita> buscaRecentes(){

		return super.buscaRecentes(Receita.class);
	}

//	public static void main(String[] args) {
//
//		EntityManagerFactory factory =
//			Persistence.createEntityManagerFactory("financas-pu");
//
//		EntityManager m = factory.createEntityManager();
//
//		RepositorioReceitas rr = new RepositorioReceitas(m);
//
//		m.getTransaction().begin();
//		Receita r;
//
//		for(int i=0; i<12; i++) {
//			r = new Receita();
//			r.setNome("nome " + (i+1));
//			r.setData(new GregorianCalendar(2001 + i, i, i+1));
//			r.setValor(i+1);
//			r.setTipo("tipo " + (i+1));
//			rr.adiciona(r);
//
//			m.persist(r);
//		}
//
//		m.getTransaction().commit();
//
//		System.out.println(rr.somaFinancas(new GregorianCalendar(2004, 1, 1), new GregorianCalendar()));
//		System.out.println(rr.somaFinancasAte(new GregorianCalendar()));
//		System.out.println(rr.buscaPorPeriodo(new GregorianCalendar(2010, 1, 1), new GregorianCalendar(2014, 1, 3)));
//		System.out.println(rr.buscaRecentes());
//
//		m.close();
//		factory.close();
//	}
}

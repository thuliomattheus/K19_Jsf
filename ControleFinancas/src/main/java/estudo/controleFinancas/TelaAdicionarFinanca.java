package estudo.controleFinancas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManager;


public class TelaAdicionarFinanca {

	protected Tela anterior;

	public TelaAdicionarFinanca(Tela anterior) {
		this.anterior = anterior;
	}

	protected <T extends Financa> T mostra(T type) {
		System.out.println(">>> " + type.getClass().getSimpleName() + " <<<\n");

		System.out.println("Digite o nome: ");
		String nome = App.getEntrada().next();

		double valor = -1;

		while(valor < 0) {
			System.out.println("Digite o valor: ");

			try {
				valor = App.getEntrada().nextDouble();
			}
			catch(InputMismatchException e) {
				System.out.println("Valor incorreto");
				continue;
			}

			if(valor < 0) {
				System.out.println("Valor incorreto");
			}
		}

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Calendar data = null;

		while(data == null) {
			System.out.println("Digite a data (ex: 02/05/2018): ");

			try {
				Date d = sdf.parse(App.getEntrada().next());
				data = Calendar.getInstance();
				data.setTime(d);
			}
			catch(ParseException e) {
				System.out.println("Data incorreta");
			}
		}

		System.out.println();
		Map<Integer, String> tipos = new LinkedHashMap<Integer, String>();

		tipos.put(1, "Aluguel");
		tipos.put(2, "Alimentação");
		tipos.put(3, "Transporte");
		tipos.put(4, "Lazer");
		tipos.put(5, "Outros");

		for(Integer key : tipos.keySet()) {
			System.out.println(key + ". " + tipos.get(key));
		}

		int tipo = -1;

		while(tipo < 1 || tipo > 5) {
			System.out.println("Escolha o tipo (número de 1 a 5): ");

			try {
				tipo = App.getEntrada().nextInt();
			}
			catch(InputMismatchException e){
				System.out.println("Tipo incorreto");
				continue;
			}

			if(tipo < 1 || tipo > 5) {
				System.out.println("Tipo incorreto");				
			}
		}

		type.setNome(nome);
		type.setValor(valor);;
		type.setTipo(tipos.get(tipo));
		type.setData(data);;

		return type;
	}

	protected String getNome(String type) {
		return ("Adicionar " + type);
	}
}

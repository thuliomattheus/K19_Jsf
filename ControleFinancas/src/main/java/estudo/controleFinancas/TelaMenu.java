package estudo.controleFinancas;

import java.util.ArrayList;
import java.util.List;

public class TelaMenu implements Tela{

	private String nome;

	private List<Tela> filhas = new ArrayList<Tela>();

	public TelaMenu(String nome) {
		this.nome = nome;
	}

	public Tela mostra() {
		System.out.println(">>> " + this.nome + " <<<\n");

		for(int i=0; i<this.filhas.size(); i++) {
			System.out.println((i+1) + ". " + this.filhas.get(i).getNome());
		}

		System.out.println("\nEscolha a opção:");
		int opcao = App.getEntrada().nextInt() - 1;
		System.out.println();

		return this.filhas.get(opcao);
	}

	public void adicionarFilha(Tela tela) {
		this.filhas.add(tela);
	}

	public String getNome() {
		return this.nome;
	}
}

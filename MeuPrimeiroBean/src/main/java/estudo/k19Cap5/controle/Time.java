package estudo.k19Cap5.controle;

import java.util.ArrayList;
import java.util.List;

public class Time {

	private String nome;

	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}

package estudo.k19Cap6.modelo;

import java.util.ArrayList;
import java.util.List;

public class Time {

	private int id;

	private String nome;

	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public Time(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

package estudo.k19Cap6.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import estudo.k19Cap6.modelo.Jogador;
import estudo.k19Cap6.modelo.Time;

@Named
@ViewScoped
public class ComponentesVisuaisBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idJogador;

	private int idTime;

	private Time timeEscolhido;

	private Jogador jogadorEscolhido;

	private int numeroEscolhido;

	private List<Time> listaTimes = new ArrayList<Time>();

	private List<Jogador> listaJogadores = new ArrayList<Jogador>();

	private List<Integer> listaNumeros = new ArrayList<Integer>();

	public ComponentesVisuaisBean() {

		// Populando a lista de números
		for(int i=0; i<10; i++) {
			listaNumeros.add(i+1);
		}

		// Populando a lista de jogadores
		listaJogadores.add(new Jogador(0, "Eden Hazard", "Bélgica"));
		listaJogadores.add(new Jogador(1, "N'Golo Kanté", "França"));
		listaJogadores.add(new Jogador(2, "Ross Barkley", "Inglaterra"));
		listaJogadores.add(new Jogador(3, "Marcos Alonso", "Espanha"));
		listaJogadores.add(new Jogador(4, "Ethan Ampadu", "País de Gales"));
		listaJogadores.add(new Jogador(5, "Willian", "Brasil"));
		listaJogadores.add(new Jogador(6, "Mohamed Salah", "Egito"));
		listaJogadores.add(new Jogador(7, "Sadio Manè", "Senegal"));
		listaJogadores.add(new Jogador(8, "Bailly", "Costa do Marfim"));
		listaJogadores.add(new Jogador(9, "Granit Xhaka", "Suíça"));

		listaTimes.add(new Time(0, "Chelsea FC"));
		listaTimes.add(new Time(1, "Manchester United FC"));
		listaTimes.add(new Time(2, "Arsenal FC"));
		listaTimes.add(new Time(3, "Liverpool FC"));

	}

	public String mostraJogador() {
		return listaJogadores.get(idJogador).getNome() + " - " + listaTimes.get(idTime).getNome();
	}

	public Jogador getJogadorEscolhido() {
		return jogadorEscolhido;
	}
	public void setJogadorEscolhido(Jogador jogadorEscolhido) {
		this.jogadorEscolhido = jogadorEscolhido;
	}
	public int getNumeroEscolhido() {
		return numeroEscolhido;
	}
	public void setNumeroEscolhido(int numeroEscolhido) {
		this.numeroEscolhido = numeroEscolhido;
	}

	public List<Jogador> getListaJogadores() {
		return listaJogadores;
	}
	public void setListaJogadores(List<Jogador> listaJogadores) {
		this.listaJogadores = listaJogadores;
	}
	public List<Integer> getListaNumeros() {
		return listaNumeros;
	}
	public void setListaNumeros(List<Integer> listaNumeros) {
		this.listaNumeros = listaNumeros;
	}

	public int getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(int idJogador) {
		this.idJogador = idJogador;
	}

	public List<Time> getListaTimes() {
		return listaTimes;
	}

	public void setListaTimes(List<Time> listaTimes) {
		this.listaTimes = listaTimes;
	}

	public Time getTimeEscolhido() {
		return timeEscolhido;
	}

	public void setTimeEscolhido(Time timeEscolhido) {
		this.timeEscolhido = timeEscolhido;
	}

	public int getIdTime() {
		return idTime;
	}

	public void setIdTime(int idTime) {
		this.idTime = idTime;
	}

}
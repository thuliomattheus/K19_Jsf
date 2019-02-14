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
public class PremierLeagueBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Time> times = new ArrayList<Time>(20);

	private int timeIndice;

	private String nomeNovoTime, nomeNovoJogador;

	public String adicionarTime() {
		Time t = new Time();
		t.setNome(nomeNovoTime);
		this.times.add(t);

		return "index";
	}

	public String adicionarJogador() {
		Jogador j = new Jogador();
		j.setNome(nomeNovoJogador);
		this.times.get(timeIndice).getJogadores().add(j);

		return "index";
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public String getNomeNovoTime() {
		return nomeNovoTime;
	}

	public void setNomeNovoTime(String nomeNovoTime) {
		this.nomeNovoTime = nomeNovoTime;
	}

	public String getNomeNovoJogador() {
		return nomeNovoJogador;
	}

	public void setNomeNovoJogador(String nomeNovoJogador) {
		this.nomeNovoJogador = nomeNovoJogador;
	}

	public int getTimeIndice() {
		return timeIndice;
	}

	public void setTimeIndice(int timeIndice) {
		this.timeIndice = timeIndice;
	}

}

package estudo.k19Cap5.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class PremierLeagueBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Time> times = new ArrayList<Time>(20);

	private String nomeNovoTime;

	public String adicionarTime() {
		Time t = new Time();
		t.setNome(nomeNovoTime);
		this.times.add(t);

		return "verTimes";
	}

	public String telaPrincipal() {
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

}

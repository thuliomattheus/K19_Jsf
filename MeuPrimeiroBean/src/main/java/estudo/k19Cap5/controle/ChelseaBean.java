package estudo.k19Cap5.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ChelseaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> jogadores = new ArrayList<String>();

	private String nome, escolhido;

	public void contratar() {
		jogadores.add(nome);
	}

	public List<String> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<String> jogadores) {
		this.jogadores = jogadores;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEscolhido() {
		return escolhido;
	}

	public void setEscolhido(String escolhido) {
		this.escolhido = escolhido;
	}

}

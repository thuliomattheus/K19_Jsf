package estudo.controleFinancas;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TipoFinanca {

	private String nome;

	private double valor;

	private Calendar data;

	private String tipo;


	@Override
	public String toString() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String s = this.nome + " - " +
			this.valor + " -  " +
			sdf.format(this.data.getTime()) + " - " +
			this.tipo;

		return s;
	}

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected Calendar getData() {
		return data;
	}

	protected void setData(Calendar data) {
		this.data = data;
	}

	protected String getTipo() {
		return tipo;
	}

	protected void setTipo(String tipo) {
		this.tipo = tipo;
	}

	protected double getValor() {
		return valor;
	}

	protected void setValor(double valor) {
		this.valor = valor;
	}

}

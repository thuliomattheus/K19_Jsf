package estudo.k19Cap6.controle;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConversorMonetarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String de;
	private String para;
	private double valor;

	private double resultado;

	private Map<String, Double> taxas = new LinkedHashMap<String, Double>();

	public ConversorMonetarioBean() {
		taxas.put("Real Brasileiro", 1D);
		taxas.put("Dólar Americano", 3.73);
		taxas.put("Euro", 4.23);
		taxas.put("Libra Esterlina", 4.85);
		taxas.put("Peso Argentino", 0.11);
		taxas.put("Bitcoin", 23752.01);
	}

	public void converte() {
		this.setResultado(this.valor * this.taxas.get(this.de) / this.taxas.get(this.para));
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public Map<String, Double> getTaxas() {
		return taxas;
	}

	public void setTaxas(Map<String, Double> taxas) {
		this.taxas = taxas;
	}

}

package estudo.k19Cap2.jdbc;

public class Livro {
	private Long id;
	private Long editoraId;
	private String titulo;
	private double preco;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEditoraId() {
		return editoraId;
	}
	public void setEditoraId(Long editoraId) {
		this.editoraId = editoraId;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}


}

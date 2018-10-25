package estudo.k19cap2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ListaLivros {
	public static void main(String[] args) throws Exception {

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		// Consulta dos atributos de todas as editoras cadastradas
		String sql = "SELECT * from Livro";

		PreparedStatement comando = conexao.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery();

		// Cópia de todas as editoras em um arraylist
		List<Livro> livros = new ArrayList<Livro>();
		while(resultado.next()) {
			Livro l = new Livro();
			l.setId(resultado.getLong("id"));
			l.setTitulo(resultado.getString("titulo"));
			l.setPreco(resultado.getDouble("preco"));
			l.setEditoraId(resultado.getLong("editoraId"));
			livros.add(l);
		}

		System.out.println("Resultados encontrados: \n");
		for(Livro l : livros) {
			System.out.println("Id: " + l.getId());
			System.out.println("Título: " + l.getTitulo());
			System.out.println("Preço: " + l.getPreco());
			System.out.println("Id da Editora: " + l.getEditoraId());
			System.out.println("--------------------------------------------");
		}

		comando.close();
		conexao.close();
	}

}

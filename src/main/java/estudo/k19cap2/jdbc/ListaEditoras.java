package estudo.k19cap2.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ListaEditoras {

	public static void main(String[] args) throws Exception {

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		// Consulta dos atributos de todas as editoras cadastradas
		String sql = "SELECT * from Editora";

		PreparedStatement comando = conexao.prepareStatement(sql);
		ResultSet resultado = comando.executeQuery();

		// Cópia de todas as editoras em um arraylist
		List<Editora> editoras = new ArrayList<Editora>();
		while(resultado.next()) {
			Editora e = new Editora();
			e.setId(resultado.getLong("id"));
			e.setNome(resultado.getString("nome"));
			e.setEmail(resultado.getString("email"));
			editoras.add(e);
		}

		System.out.println("Resultados encontrados: \n");
		for(Editora e : editoras) {
			System.out.println("Id: " + e.getId());
			System.out.println("Nome: " + e.getNome());
			System.out.println("Email: " + e.getEmail());
			System.out.println("--------------------------------------------");
		}

		comando.close();
		conexao.close();
	}
}

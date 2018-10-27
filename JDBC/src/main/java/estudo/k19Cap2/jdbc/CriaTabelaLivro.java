package estudo.k19Cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaTabelaLivro {

	public static void main(String[] args) throws Exception{

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		String sql =
			"CREATE TABLE IF NOT EXISTS Livro (" +
				"id BIGINT NOT NULL AUTO_INCREMENT," +
				"titulo VARCHAR (255) NOT NULL," +
				"preco DOUBLE NOT NULL," +
				"editoraId BIGINT NOT NULL," +
				"PRIMARY KEY (id)," +
				"FOREIGN KEY (editoraId) REFERENCES Editora(id)" +
				"ON DELETE CASCADE ON UPDATE CASCADE" +
			")" +
			"ENGINE = InnoDB";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Tabela Livro criada!");

		conexao.close();

	}
}

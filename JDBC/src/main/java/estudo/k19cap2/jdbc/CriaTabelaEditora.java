package estudo.k19cap2.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CriaTabelaEditora {

	public static void main(String[] args) throws Exception{

		// Conexão com o banco
		Connection conexao = ConnectionFactory.createConnection();

		String sql =
			"CREATE TABLE IF NOT EXISTS Editora (" +
				"id BIGINT NOT NULL AUTO_INCREMENT," +
				"nome VARCHAR (255) NOT NULL," +
				"email VARCHAR (255) NOT NULL," +
				"PRIMARY KEY (id)" +
			")" +
			"ENGINE = InnoDB";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.execute();
		comando.close();

		System.out.println("Tabela Editora criada!");

		conexao.close();
	}
}
